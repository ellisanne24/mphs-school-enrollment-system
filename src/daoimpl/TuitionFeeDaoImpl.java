
package daoimpl;

import dao.ITuitionFee;
import java.math.BigDecimal;
import java.math.RoundingMode;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.paymentterm.PaymentTerm;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.tuitionfee.TuitionFee;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TuitionFeeDaoImpl implements ITuitionFee {

    private final StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    private final SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private static BigDecimal truncateDecimal(double x, int numberofDecimals) {
        System.out.println("value@truncateDecimal() :"+x);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }
    
    @Override
    public boolean add(TuitionFee tuitionFee) {
        boolean isAdded = true;
        PaymentTerm paymentTerm = tuitionFee.getPaymentTerm();
        if(tuitionFee.getPayment() == null){
            System.out.println("Null PaymentTerm");
        }
        int paymentTermId = paymentTerm.getPaymentTermId();

        Discount discount = tuitionFee.getDiscount();
        int studentId = tuitionFee.getStudent().getStudentId();
        int schoolYearId = tuitionFee.getSchoolYear().getSchoolYearId();

        String SQL_addBalanceBreakDownFee = "{CALL addBalanceBreakDownFee(?,?,?,?)}"; //add to balance_breakdown_fee master
        String SQL_addTuitionFee = "{CALL addTuitionFee(?,?,?)}"; 
        String SQL_addStudentDiscount = "{CALL addStudentDiscount(?,?,?,?)}";
        String SQL_addStudentPaymentTerm = "{CALL addStudentPaymentTerm(?,?,?)}";
        String SQL_addTransaction = "{CALL addTransaction(?,?)}";
        String SQL_payTuitionFee = "{CALL payTuitionFee(?,?,?)}";
        String SQL_addTransactionPayment = "{CALL addTransactionPayment(?,?)}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement CS_addBalBreakDownFee = con.prepareCall(SQL_addBalanceBreakDownFee);
                    CallableStatement CS_addTuitionFee = con.prepareCall(SQL_addTuitionFee);
                    CallableStatement CS_addStudentDiscount = con.prepareCall(SQL_addStudentDiscount);
                    CallableStatement CS_addStudentPaymentTerm = con.prepareCall(SQL_addStudentPaymentTerm);
                    CallableStatement CS_addTransaction = con.prepareCall(SQL_addTransaction);
                    CallableStatement CS_payTuitionFee = con.prepareCall(SQL_payTuitionFee);) {
                
                if (!tuitionFee.exists()) {
                    for (BalanceBreakDownFee b : tuitionFee.getBalanceBreakDownFees()) {
                        
                        CS_addBalBreakDownFee.setString(1, b.getName());
                        CS_addBalBreakDownFee.setBigDecimal(2, b.getAmount());
                        CS_addBalBreakDownFee.setDate(3, (Date) b.getDeadline());
                        CS_addBalBreakDownFee.registerOutParameter(4, Types.INTEGER);
                        CS_addBalBreakDownFee.executeUpdate();
                        int balanceBreakDownFeeId = CS_addBalBreakDownFee.getInt(4);

                        CS_addTuitionFee.setInt(1, balanceBreakDownFeeId);
                        CS_addTuitionFee.setInt(2, studentId);
                        CS_addTuitionFee.setInt(3, schoolYearId);
                        CS_addTuitionFee.executeUpdate();
                    }
                    if (discount != null) {
                        CS_addStudentDiscount.setInt(1, studentId);
                        CS_addStudentDiscount.setInt(2, discount.getId());
                        CS_addStudentDiscount.setInt(3, schoolYearId);
                        CS_addStudentDiscount.setDouble(4,discount.getAmount());
                        CS_addStudentDiscount.executeUpdate();
                    }

                    CS_addStudentPaymentTerm.setInt(1, studentId);
                    CS_addStudentPaymentTerm.setInt(2, paymentTermId);
                    CS_addStudentPaymentTerm.setInt(3, schoolYearId);
                    CS_addStudentPaymentTerm.executeUpdate();
                    
//                    CS_addTransaction.setInt(1, studentId);
//                    CS_addTransaction.registerOutParameter(2, Types.INTEGER);
//                    int transactionId = CS_addTransaction.getInt(2);
                    
                    
                    
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                isAdded = false;
                e.printStackTrace();
            }
        } catch (SQLException e) {
            isAdded = false;
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public TuitionFee get(int studentId, int schoolyearId) {
        TuitionFee tuitionFee = new TuitionFee();
        
        List<BalanceBreakDownFee> balanceBreakDownFeeList = new ArrayList<>();
        boolean exists = false;
        SchoolYear schoolYear = schoolYearDaoImpl.getSchoolYearById(schoolyearId);
        Student student = studentDaoImpl.getStudentByStudentNo(studentId);
        PaymentTerm paymentTerm = new PaymentTerm();
        Discount discount = new Discount();

        String SQLa = "{CALL tuitionFeeExists(?,?)}";
        String SQLb = "{CALL getTuitionFee(?,?)}";
        String SQLc = "{CALL getTuitionFeeSum(?,?)}";
        String SQLd = "{CALL getStudentPaymentTerm(?,?)}";
        String SQLe = "{CALL getStudentDiscount(?,?)}";
        String SQLf = "{CALL getTuitionFeeTotalPaid(?,?)}";
        String SQLg = "{CALL hasTuitionFeeDiscount(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            try (CallableStatement csA = con.prepareCall(SQLa);
                    CallableStatement csB = con.prepareCall(SQLb);
                    CallableStatement csC = con.prepareCall(SQLc);
                    CallableStatement csD = con.prepareCall(SQLd);
                    CallableStatement csE = con.prepareCall(SQLe);
                    CallableStatement csF = con.prepareCall(SQLf);
                    CallableStatement csG = con.prepareCall(SQLg)) {
                csA.setInt(1, studentId);
                csA.setInt(2, schoolyearId);
                try (ResultSet rsa = csA.executeQuery();) {
                    while (rsa.next()) {
                        exists = rsa.getBoolean("tuitionFeeExists");
                    }
                    tuitionFee.setExists(exists);
                }

                csB.setInt(1, studentId);
                csB.setInt(2, schoolyearId);
                try (ResultSet rsb = csB.executeQuery();) {
                    while (rsb.next()) {
                        BalanceBreakDownFee balanceBreakDownFee = new BalanceBreakDownFee();
                        balanceBreakDownFee.setAmount(rsb.getBigDecimal("amount"));
                        balanceBreakDownFee.setBalance(rsb.getBigDecimal("balance"));
                        balanceBreakDownFee.setId(rsb.getInt("balance_breakdown_fee_id"));
                        balanceBreakDownFee.setDateAssigned(rsb.getTimestamp("date_assigned"));
                        balanceBreakDownFee.setIsPaid(rsb.getBoolean("isPaid"));
                        balanceBreakDownFee.setSchoolYearId(rsb.getInt("schoolyear_id"));
                        balanceBreakDownFee.setName(rsb.getString("description"));
                        balanceBreakDownFee.setStudentId(rsb.getInt("student_id"));

                        balanceBreakDownFeeList.add(balanceBreakDownFee);
                    }
                    tuitionFee.setBalanceBreakDownFees(balanceBreakDownFeeList);
                }

                csC.setInt(1, studentId);
                csC.setInt(2, schoolyearId);
                try (ResultSet rsc = csC.executeQuery();) {
                    while (rsc.next()) {
                        tuitionFee.setTotalFees(rsc.getDouble("tuitionFeeSum"));
                    }
                }

                csD.setInt(1, studentId);
                csD.setInt(2, schoolyearId);
                try(ResultSet rsD = csD.executeQuery();){
                    while(rsD.next()){
//                        paymentTerm.setPaymentTermId(rsD.getInt("paymentterm_id"));
                        paymentTerm.setPaymentTermName(rsD.getString("paymentterm"));
//                        paymentTerm.setIsActive(rsD.getBoolean("isActive"));
                        paymentTerm.setDivisor(rsD.getInt("divisor"));
                    }
                }
                
                csE.setInt(1,studentId);
                csE.setInt(2,schoolyearId);
                try(ResultSet rsE = csE.executeQuery();){
                    while(rsE.next()){
                        discount.setAmount(rsE.getInt("amount"));
                        discount.setId(rsE.getInt("discount_id"));
                        discount.setDiscountName(rsE.getString("discount_name"));
                        discount.setPercentOfDiscount(rsE.getInt("percentage"));
                        discount.setDescription(rsE.getString("description"));
                        discount.setDateCreated(rsE.getDate("date_created"));
                        discount.setIsActive(rsE.getBoolean("isActive"));
                    }
                }
                
                csF.setInt(1,studentId);
                csF.setInt(2,schoolyearId);
                try(ResultSet rsF = csF.executeQuery();){
                    while(rsF.next()){
                        tuitionFee.setTotalPaid(rsF.getDouble("totalTuitionPaid"));
                    }
                }
                
                csG.setInt(1, studentId);
                csG.setInt(2, studentId);
                try(ResultSet rsG = csG.executeQuery();){
                    while(rsG.next()){
                        tuitionFee.setHasDiscount(rsG.getBoolean("hasDiscount"));
                    }
                }
                
                tuitionFee.setDiscount(discount);
                tuitionFee.setPaymentTerm(paymentTerm);
                tuitionFee.setStudent(student);
                tuitionFee.setSchoolYear(schoolYear);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tuitionFee;
    }

    @Override
    public boolean pay(TuitionFee tuitionFee) {
        boolean isSuccessfullyPaid = false;
        String SQL_addTransaction = "{CALL addTransaction(?,?)}";
        String SQL_payTuitionFee = "{CALL payTuitionFee(?,?,?)}";
        String SQL_addTransactionPayment = "{CALL addTransactionPayment(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement CS_AddTransaction = con.prepareCall(SQL_addTransaction);
                    CallableStatement CS_PayTuitionFee = con.prepareCall(SQL_payTuitionFee);
                    CallableStatement CS_AddTransactionPayment = con.prepareCall(SQL_addTransactionPayment);) {
                CS_AddTransaction.setInt(1, tuitionFee.getStudent().getStudentId());
                CS_AddTransaction.registerOutParameter(2, Types.INTEGER);
                CS_AddTransaction.executeUpdate();
                int transactionId = CS_AddTransaction.getInt(2);
                
                List<BalanceBreakDownFee> breakDownFeeList = tuitionFee.getPayment().getParticulars().getBalanceBreakDownFees();
                double amountTendered = tuitionFee.getPayment().getAmountTendered();
                for(BalanceBreakDownFee breakDownFee: breakDownFeeList){
                    System.out.println("BreakdownFeeId :"+breakDownFee.getId());
                    CS_PayTuitionFee.setInt(1, breakDownFee.getId());
                    CS_PayTuitionFee.setDouble(2,amountTendered);
                    CS_PayTuitionFee.registerOutParameter(3, Types.INTEGER);
                    CS_PayTuitionFee.executeUpdate();
                    int paymentId = CS_PayTuitionFee.getInt(3);
                    
                    CS_AddTransactionPayment.setInt(1, transactionId);
                    CS_AddTransactionPayment.setInt(2, paymentId);
                    CS_AddTransactionPayment.executeUpdate();
                }
                
                con.commit();
                isSuccessfullyPaid = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessfullyPaid;
    }


    
}
