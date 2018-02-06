
package daoimpl;

import dao.ITuitionFee;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.particulars.Particular;
import model.payment.Payment;
import model.paymentterm.PaymentTerm;
import model.student.Student;
import model.tuitionfee.Tuition;
import utility.date.DateUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TuitionFeeDaoImpl implements ITuitionFee {

    public TuitionFeeDaoImpl (){
    }

    @Override
    public boolean add(Tuition tuitionFee) {
        boolean isAdded = false;
        DateUtil dateUtil = new DateUtil();
        String SQLa = "{CALL addBalanceBreakDownFee(?,?,?,?,?,?,?,?)}";
        PaymentTerm paymentTerm = tuitionFee.getPaymentTerm();
        Student student = tuitionFee.getStudent();
        int schoolYearId = tuitionFee.getSchoolyearId();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);) {
                for (BalanceBreakDownFee b : tuitionFee.getBalanceBreakDownFees()) {
                    csa.setString(1, b.getName().trim());
                    csa.setBigDecimal(2, b.getAmount());
                    csa.setDate(3, dateUtil.toSqlDate(b.getDeadline()));
                    csa.setString(4, b.getCategory().trim());
                    csa.setInt(5, student.getStudentId());
                    csa.setInt(6, paymentTerm.getPaymentTermId());
                    csa.setInt(7, schoolYearId);
                    csa.registerOutParameter(8, Types.INTEGER);
                    csa.executeUpdate();
                    int balancebreakdownId = csa.getInt(8);
                    System.out.println(b.getName()+" added.");
                }
                con.commit();
                isAdded = true;
            } catch (Exception e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public Tuition getBy(int studentId, int schoolyearId) {
        Tuition tuitionFee = new Tuition();
        PaymentTerm paymentTerm = new PaymentTerm();
        String SQLa = "{CALL getTuitionByStudentIdAndSchoolYearId(?,?)}";
        String SQLb = "{CALL getTuitionTotalPaidAndRemainingBalance(?,?)}";
        String SQLc = "{CALL getTuitionPaymentTermByStudentIdAndSchoolYearId(?,?)}";
        List<BalanceBreakDownFee> bbFeeList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csa = con.prepareCall(SQLa);
                CallableStatement csb = con.prepareCall(SQLb);
                CallableStatement csc = con.prepareCall(SQLc);){
            csa.setInt(1,studentId);
            csa.setInt(2,schoolyearId);
            csb.setInt(1, studentId);
            csb.setInt(2, schoolyearId);
            csc.setInt(1, studentId);
            csc.setInt(2,schoolyearId);
            try(ResultSet rs = csa.executeQuery();){
                while(rs.next()){
                    BalanceBreakDownFee bb = new BalanceBreakDownFee();
                    bb.setId(rs.getInt("balancebreakdown_id"));
                    bb.setName(rs.getString("balancebreakdown_name").trim());
                    bb.setAmount(rs.getBigDecimal("balancebreakdown_amount"));
                    bb.setBalance(rs.getBigDecimal("balance"));
                    bb.setIsPaid(rs.getBoolean("isPaid"));
                    bb.setHasPenalty(rs.getBoolean("hasPenalty"));
                    bb.setIsPastDueDate(rs.getBoolean("isPastDueDate"));
                    bb.setDeadline(rs.getDate("due_date"));
                    String category = rs.getString("category").equalsIgnoreCase("B")? "Balance" :
                            rs.getString("category").equalsIgnoreCase("D")? "Downpayment" :
                            rs.getString("category").equalsIgnoreCase("O")? "Other" : "";
                    bb.setCategory(category);
                    bbFeeList.add(bb);
                }
            }
            
            try(ResultSet rs = csb.executeQuery();){
                while(rs.next()){
                    tuitionFee.setTotalPaid(rs.getBigDecimal("totalPaid"));
                    tuitionFee.setRemainingBalance(rs.getBigDecimal("remainingbalance"));
                }
            }
            
            try(ResultSet rs = csc.executeQuery();){
                while(rs.next()){
                    paymentTerm.setPaymentTermId(rs.getInt("paymentterm_id"));
                    paymentTerm.setPaymentTermName(rs.getString("paymentterm_name"));
                    paymentTerm.setIsPaymentTermActive(rs.getBoolean("isPaymentTermActive"));
                    paymentTerm.setDivisor(rs.getInt("divisor"));
                }
            }
            tuitionFee.setBalanceBreakDownFees(bbFeeList);
            tuitionFee.setPaymentTerm(paymentTerm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tuitionFee;
    }

    @Override
    public int getBalanceBreakDownId(String balancebreakdownName, int studentId, int schoolyearId) {
        int balancebreakdownId = 0;
        String SQL = "{CALL getBalanceBreakDownId(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1, balancebreakdownName.trim());
            cs.setInt(2, studentId);
            cs.setInt(3, schoolyearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    balancebreakdownId = rs.getInt("balancebreakdown_id");
                    System.out.println("BalanceBreakDown Id: "+balancebreakdownId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balancebreakdownId;
    }

    @Override
    public boolean pay(Tuition tuitionFee) {
        boolean isSuccessful = false;
        Payment payment = tuitionFee.getPayment();
        String SQLa = "{CALL addTransaction(?,?,?,?,?)}";
        String SQLb = "{CALL addTransactionBalanceBreakDown(?,?,?)}";
        String SQLc = "{CALL markOrNoAsUsed(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);
                    CallableStatement csc = con.prepareCall(SQLc);) {
                csa.setInt(1, tuitionFee.getStudent().getStudentId());
                csa.setBigDecimal(2, payment.getAmountReceived());
                csa.setBigDecimal(3, payment.getAmountCharged());
                csa.setInt(4, payment.getOrNoAttached());
                csa.registerOutParameter(5, Types.INTEGER);
                csa.executeUpdate();
                int transactionId = csa.getInt(5);
    
                int studentId = tuitionFee.getStudent().getStudentId();
                int schoolYearId = tuitionFee.getSchoolyearId();
                
                for (Particular p : payment.getParticulars()) {
                    int particularId = getBalanceBreakDownId(p.getName().trim(), studentId, schoolYearId);
                    csb.setInt(1,transactionId);
                    csb.setInt(2,particularId);
                    csb.setBigDecimal(3, p.getAmountPaid());
                    csb.executeUpdate();
                }
                
                csc.setInt(1, payment.getOrNoAttached());
                csc.executeUpdate();
                
                con.commit();
                isSuccessful = true;
            } catch (Exception e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    
    
}
