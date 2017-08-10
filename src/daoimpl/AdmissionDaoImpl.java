package daoimpl;

import constants.AdmissionTable;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.admission.Admission;
import dao.IAdmission;
import java.util.List;
import model.basicfee.BasicFee;
import model.downpayment.DownPaymentFee;
import model.fee.Fee;
import model.miscellaneousfees.MiscellaneousFees;
import model.otherfees.OtherFees;
import model.registration.Registration;
import model.schoolfees.SchoolFees;
import org.apache.derby.client.am.Types;

public class AdmissionDaoImpl implements IAdmission {

    /**
     * 
     * @param admission
     * <p>admission parameter contains registrationId and schoolYearId <br>
     * Both parameters will be used as arguments to stored procedures,<br>
     * <code>completeAdmission(?,?)</code> and 
     * <b><code>assignFeesToStudent(?,?,?)</code></b>.<br>
     * <code>completeAdmission</code> method will mark registered applicant's admission to 1 <br>
     * and then insert a new student record on <code>student_mt</code> table in the database. <br>
     * If successful, it will then continue and call <b><code>assignFeesToStudent(?,?,?)</code></b> <br>
     * to assign fees to student which inserts all fees to database table <code>student_fees</code> <br>
     * </p>
     * @return 
     */
    @Override
    public boolean completeAdmission(Admission admission) {
        boolean isSuccessful = false;
        int registrationId = admission.getRegistration().getRegistrationId();
        int schoolYearId = admission.getSchoolYearId();
        int gradeLevelId = admission.getGradeLevelId();
        String studentType = admission.getRegistration().getStudentType();

        
        String setAdmissionGradeLevel = "{CALL setAdmissionGradeLevel(?,?)}";
        String addAsStudent = "{CALL addAsStudent(?,?)}";
        String completeAdmission = "{CALL completeAdmission(?)}";
        String assignFeesToStudent = "{CALL assignFeesToStudent(?,?,?)}";
        String addTransferee = "{CALL addTransferee(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(setAdmissionGradeLevel);
                    CallableStatement csb = con.prepareCall(addAsStudent);
                    CallableStatement csc = con.prepareCall(completeAdmission);
                    CallableStatement csd = con.prepareCall(assignFeesToStudent);
                    CallableStatement cse = con.prepareCall(addTransferee);) {
                csa.setInt(1, gradeLevelId);
                csa.setInt(2, registrationId);
                csa.executeUpdate();
                
                csb.setInt(1, registrationId);
                csb.registerOutParameter(2, Types.INTEGER);
                csb.executeUpdate();
                int studentId = csb.getInt(2);
                
                csc.setInt(1,registrationId);
                csc.executeUpdate();

                isSuccessful = true;
                
                SchoolFees schoolFees = admission.getSchoolFees();
                BasicFee basic = schoolFees.getBasicFee();
                DownPaymentFee downPayment = schoolFees.getDownPaymentFee();
                MiscellaneousFees misc = schoolFees.getMiscellaneousFees();
                OtherFees other = schoolFees.getOtherFees();

                List<Fee> miscFeeList = misc.getFees();
                List<Fee> otherFeeList = other.getFees();

                csd.setInt(1, studentId);
                csd.setInt(2, downPayment.getId());
                csd.setInt(3, schoolYearId);
                csd.executeUpdate();

                csd.setInt(1, studentId);
                csd.setInt(2, basic.getId());
                csd.setInt(3, schoolYearId);
                csd.executeUpdate();

                for (Fee f : miscFeeList) {
                    csd.setInt(1, studentId);
                    csd.setInt(2, f.getId());
                    csd.setInt(3, schoolYearId);
                    csd.executeUpdate();
                }

                for (Fee f : otherFeeList) {
                    csd.setInt(1, studentId);
                    csd.setInt(2, f.getId());
                    csd.setInt(3, schoolYearId);
                    csd.executeUpdate();
                }
                
                if(studentType.equalsIgnoreCase("transferee")){
                    cse.setInt(1, studentId);
                    cse.executeUpdate();
                }

                con.commit();
                isSuccessful = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return isSuccessful;
    }

    @Override
    public Admission getAdmissionInfoByRegistrationId(int aRegistrationId) {
        String SQL = "{CALL getAdmissionInfoByRegistrationId(?)}";
        Admission admission = new Admission();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aRegistrationId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    admission.setAdmissionId(rs.getInt(AdmissionTable.ADMISSIONID));
                    admission.setCompletionDate(rs.getDate(AdmissionTable.COMPLETIONDATE));
                    admission.setIsCompleted(rs.getBoolean(AdmissionTable.ISCOMPLETE));
                    
                    Registration registration = new Registration();
                    registration.setRegistrationId(rs.getInt(AdmissionTable.REGISTRATIONID));
                    
                    admission.setRegistration(registration);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return admission;
    }

    @Override
    public Admission getAdmissionInfoByStudentId(int aStudentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
