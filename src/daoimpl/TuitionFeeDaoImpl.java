
package daoimpl;

import dao.ITuitionFee;
import java.math.BigDecimal;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    public Tuition get(int studentId, int schoolyearId) {
        Tuition tuitionFee = new Tuition();
        
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
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);) {
                csa.setInt(1, tuitionFee.getStudent().getStudentId());
                csa.setBigDecimal(2, payment.getAmountReceived());
                csa.setBigDecimal(3, payment.getAmountCharged());
                csa.setInt(4, payment.getOrNo());
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
