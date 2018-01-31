package daoimpl;

import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.paymentterm.PaymentTerm;
import dao.IPaymentTerm;
import model.paymentterm.PaymentTermPenalty;
import model.period.Period;
import model.schoolyear.SchoolYear;
import utility.date.DateUtil;

/**
 *
 * @author Acer
 */
public class PaymentTermDaoImpl implements IPaymentTerm{
    
    private PeriodDaoImpl periodDaoImlp;
    private DateUtil dateUtil;

    public PaymentTermDaoImpl(){
        periodDaoImlp = new PeriodDaoImpl();
        dateUtil = new DateUtil();
    }
    
    /**
     * Gets ALL of PaymentTerms including ALL Period information
     * such as Period's payment deadline and name etc.
     * @return 
     */
    @Override
    public List<PaymentTerm> getAll() {
        List<PaymentTerm> paymentTermList = new ArrayList<>();
        String SQLa = "{CALL getAllPaymentTermsInfo()}";
        String SQLb = "{CALL getPaymentTermPeriodsByPaymentTermId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csa = con.prepareCall(SQLa);
                CallableStatement csb = con.prepareCall(SQLb);) {
            try (ResultSet rsa = csa.executeQuery();) {
                while (rsa.next()) {
                    PaymentTerm paymentTerm = new PaymentTerm();
                    paymentTerm.setPaymentTermId(rsa.getInt("paymentterm_id"));
                    paymentTerm.setPaymentTermName(rsa.getString("paymentterm_name"));
                    paymentTerm.setIsPaymentTermActive(rsa.getBoolean("isPaymentTermActive"));
                    paymentTerm.setDivisor(rsa.getInt("divisor"));
                    paymentTerm.setSchoolYearId(rsa.getInt("schoolyear_id"));
                    paymentTerm.setPenaltyAmount(rsa.getBigDecimal("penalty_amount"));
                    paymentTerm.setIsPenaltyActive(rsa.getBoolean("isPenaltyActive"));
                    paymentTerm.setDateAdded(rsa.getDate("date_added"));

                    List<Period> periods = new ArrayList<>();
                    csb.setInt(1, rsa.getInt("paymentterm_id"));
                    try (ResultSet rsb = csb.executeQuery();) {
                        while (rsb.next()) {
                            Period period = new Period();
                            period.setPeriodId(rsb.getInt("period_id"));
                            period.setPeriodCode(rsb.getString("period_code"));
                            period.setPeriodName(rsb.getString("period_name"));
                            period.setPaymentDeadline(rsb.getDate("paymentdeadline"));

                            periods.add(period);
                        }
                    }
                    paymentTerm.setPeriods(periods);
                    paymentTermList.add(paymentTerm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentTermList;
    }

    @Override
    public PaymentTerm getPaymentTermByPaymentTermId(int paymentTermId) {
        PaymentTerm paymentTerm = new PaymentTerm();
        String SQLa = "{CALL getPaymentTermByPaymentTermId(?)}";
        String SQLb = "{CALL getPaymentTermPeriodsByPaymentTermId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csa = con.prepareCall(SQLa);
                CallableStatement csb = con.prepareCall(SQLb);) {
            csa.setInt(1, paymentTermId);
            try (ResultSet rsa = csa.executeQuery();) {
                while (rsa.next()) {
                    paymentTerm.setPaymentTermId(rsa.getInt("paymentterm_id"));
                    paymentTerm.setPaymentTermName(rsa.getString("paymentterm_name"));
                    paymentTerm.setIsPaymentTermActive(rsa.getBoolean("isPaymentTermActive"));
                    paymentTerm.setDivisor(rsa.getInt("divisor"));
                    paymentTerm.setSchoolYearId(rsa.getInt("schoolyear_id"));
                    paymentTerm.setPenaltyAmount(rsa.getBigDecimal("penalty_amount"));
                    paymentTerm.setIsPenaltyActive(rsa.getBoolean("isPenaltyActive"));
                    paymentTerm.setDateAdded(rsa.getDate("date_added"));

                    List<Period> periods = new ArrayList<>();
                    csb.setInt(1, paymentTermId);
                    try (ResultSet rsb = csb.executeQuery();) {
                        while (rsb.next()) {
                            Period period = new Period();
                            period.setPeriodId(rsb.getInt("period_id"));
                            period.setPeriodCode(rsb.getString("period_code"));
                            period.setPeriodName(rsb.getString("period_name"));
                            period.setPaymentDeadline(rsb.getDate("paymentdeadline"));

                            periods.add(period);
                        }
                    }
                    paymentTerm.setPeriods(periods);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentTerm;
    }

    @Override
    public List<Period> getPeriodsByPaymentTermId(int paymentTermId,int schoolYearId) {
        List<Period> list = new ArrayList<>();
        String SQL = "{CALL getPeriodsByPaymentTermId(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, paymentTermId);
            cs.setInt(2, schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Period p = new Period();
                    p.setPeriodCode(rs.getString("period_code"));
                    p.setPaymentDeadline(rs.getDate("deadline"));
                    p.setPeriodName(rs.getString("description"));
                    p.setPeriodId(rs.getInt("period_id"));
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    @Override
    public int getPaymentTermIDByName(String paymenttermName) {
        int paymentTermId = 0;
        String SQL = "{CALL getPaymentTermIdByName(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1, paymenttermName.toLowerCase().trim());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    paymentTermId = rs.getInt("paymentterm_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentTermId;
    }

    @Override
    public boolean add(PaymentTerm aPaymentTerm) {
        boolean isAdded = false;
        String SQL = "{addNewPaymentTerm(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1,aPaymentTerm.getPaymentTermName());
            isAdded = cs.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    /**
     * 
     * @param paymentTerms
     * is a List of PaymentTerm objects.<br>
     * This method inserts payment deadline record for every payment term period to <br> 
     * "<b>paymentterm_deadline</b>" table. <br>
     * This method also inserts late fee (penalty amount) record for the payment terms to <br> 
     * "<b>paymentterm_penalty</b>" table. <br>
     * @return 
     */
    @Override
    public boolean addPaymentSchedule(List<PaymentTerm> paymentTerms) {
        boolean isAdded = false;
        String SQLa = "{CALL addPaymentTermPeriodPaymentDeadline(?,?,?,?)}";
        String SQLb = "{CALL addPaymentTermPenalty(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csA = con.prepareCall(SQLa);
                    CallableStatement csB = con.prepareCall(SQLb);) {
                for (PaymentTerm paymentTerm : paymentTerms) {
                    List<Period> periods = paymentTerm.getPeriods();
                    for (Period period : periods) {
                        int periodId = periodDaoImlp.getId(period.getPeriodName().trim());
                        System.out.println("PeriodName: "+period.getPeriodName().trim()+", ID: "+periodId);
                        csA.setInt(1, paymentTerm.getSchoolYearId());
                        csA.setInt(2, paymentTerm.getPaymentTermId());
                        csA.setInt(3, periodId);
                        csA.setDate(4, dateUtil.toSqlDate(period.getPaymentDeadline()));
                        csA.executeUpdate();
                    }
                }
                for (PaymentTerm paymentTerm : paymentTerms) {
                    csB.setInt(1, paymentTerm.getSchoolYearId());
                    csB.setInt(2, paymentTerm.getPaymentTermId());
                    csB.setBigDecimal(3, paymentTerm.getPenaltyAmount());
                    csB.executeUpdate();
                }
                isAdded = true;
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                System.err.print(e.getErrorCode() + "\n" + e.getMessage());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public List<SchoolYear> getSchoolYearsWithPenalty() {
        List<SchoolYear> list = new ArrayList<>();
        String SQL = "{CALL getSchoolYearsWithPenalty()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    SchoolYear sy = new SchoolYear();
                    sy.setSchoolYearId(rs.getInt("schoolyear_id"));
                    sy.setYearFrom(rs.getInt("yearFrom"));
                    sy.setYearTo(rs.getInt("yearTo"));
                    sy.setIsActive(rs.getBoolean("isActive"));
                    sy.setSchoolYearStartDate(rs.getDate("start_date"));
                    sy.setSchoolYearEndDate(rs.getDate("end_date"));
                    sy.setIsCurrentSchoolYear(rs.getBoolean("isCurrentSchoolYear"));
                    
                    list.add(sy);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PaymentTermPenalty> getPenaltyInformationBySchoolYearId(int schoolYearId) {
        List<PaymentTermPenalty> list = new ArrayList<>();
        
        String SQL = "{CALL getPenaltyInformationBySchoolYearId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    PaymentTerm paymentTerm = new PaymentTerm();
                    paymentTerm.setPaymentTermId(rs.getInt("paymentterm_id"));
                    paymentTerm.setPaymentTermName(rs.getString("paymentterm"));
                    paymentTerm.setDivisor(rs.getInt("divisor"));
                    paymentTerm.setIsPaymentTermActive(rs.getBoolean("isActive"));
                    
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setSchoolYearId(rs.getInt("schoolyear_id"));
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    schoolYear.setYearTo(rs.getInt("yearTo"));
                    
                    PaymentTermPenalty penalty = new PaymentTermPenalty();
                    penalty.setDateAdded(rs.getDate("date_added"));
                    penalty.setPenaltyId(rs.getInt("penalty_id"));
                    penalty.setPenaltyAmount(rs.getDouble("penalty_amount"));
                    penalty.setSchoolYear(schoolYear);
                    penalty.setPaymentTerm(paymentTerm);
                    
                    list.add(penalty);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
