package daoimpl;

import dao.IRecordGenerator;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import model.registration.Registration;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RecordGeneratorDaoImpl implements IRecordGenerator {

    @Override
    public boolean generateStudent(Registration registration) {
        boolean isAdded = false;
        String addRegistration = "{CALL addRegistration(?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?) }";
        String addAdmission = "{CALL addAdmission(?)}";
        String setAdmissionGradeLevel = "{CALL setAdmissionGradeLevel(?,?)}";
        String addAsStudent = "{CALL addAsStudent(?,?)}";
        String completeAdmission = "{CALL completeAdmission(?)}";
        String enrollStudent = "{CALL enrollStudent(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csA = con.prepareCall(addRegistration);
                    CallableStatement csB = con.prepareCall(addAdmission);
                    CallableStatement csC = con.prepareCall(setAdmissionGradeLevel);
                    CallableStatement csD = con.prepareCall(addAsStudent);
                    CallableStatement csE = con.prepareCall(completeAdmission);
                    CallableStatement csF = con.prepareCall(enrollStudent);) {
                csA.setString(1, registration.getStudentType());
                csA.setString(2, registration.getLastName());
                csA.setString(3, registration.getFirstName());
                csA.setString(4, registration.getMiddleName());
                csA.setObject(5, registration.getDateOfBirth());
                csA.setString(6, registration.getPlaceOfBirth());
                csA.setString(7, registration.getNationality());
                csA.setString(8, registration.getReligion());
                csA.setInt(9, "Male".equals(registration.getGender()) ? 1 : 0);
                csA.setString(10, registration.getFatherFirstName());
                csA.setString(11, registration.getFatherMiddleName());
                csA.setString(12, registration.getFatherLastName());
                csA.setString(13, registration.getFatherOccupation());
                csA.setString(14, registration.getFatherOfficePhoneNo());
                csA.setString(15, registration.getFatherMobileNo());
                csA.setInt(16, registration.getIsFatherContactInCaseEmergency() == true ? 1 : 0);
                csA.setString(17, registration.getMotherFirstName());
                csA.setString(18, registration.getMotherMiddleName());
                csA.setString(19, registration.getMotherLastName());
                csA.setString(20, registration.getMotherOccupation());
                csA.setString(21, registration.getMotherOfficePhoneNo());
                csA.setString(22, registration.getMotherMobileNo());
                csA.setInt(23, registration.getIsMotherContactInCaseEmergency() == true ? 1 : 0);
                csA.setString(24, registration.getGuardianLastName());
                csA.setString(25, registration.getGuardianFirstName());
                csA.setString(26, registration.getGuardianMiddleName());
                csA.setString(27, registration.getGuardianOccupation());
                csA.setString(28, registration.getGuardianOfficePhoneNo());
                csA.setString(29, registration.getGuardianMobileNo());
                csA.setString(30, registration.getGuardianRelationToStudent());
                csA.setInt(31, registration.getIsGuardianContactInCaseEmergency() == true ? 1 : 0);
                csA.setString(32, registration.getSchoolLastAttended());
                csA.setString(33, registration.getSchoolLastAttendedAddress());
                csA.setString(34, registration.getAddressRoomOrHouseNo());
                csA.setString(35, registration.getAddressStreet());
                csA.setString(36, registration.getAddressBrgyOrSubd());
                csA.setString(37, registration.getAddressCity());
                csA.setString(38, registration.getProvince());
                csA.setInt(39, registration.getGradeLevelId());
                csA.setInt(40, registration.getSchoolYearId());
                csA.setInt(41, registration.getPaymentTermId());
                csA.registerOutParameter(42, Types.INTEGER);
                csA.executeUpdate();
                int registrationId = csA.getInt(42);

                csB.setInt(1, registrationId);
                csB.executeUpdate();

                csC.setInt(1,registration.getGradeLevelId());
                csC.setInt(2,registrationId);
                csC.executeUpdate();
                
                csD.setInt(1, registrationId);
                csD.registerOutParameter(2, Types.INTEGER);
                csD.executeUpdate();
                int studentId = csD.getInt(2);
                
                csE.setInt(1, registrationId);
                csE.executeUpdate();

                SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();

                csF.setInt(1, sydi.getCurrentSchoolYearId());
                csF.setInt(2, studentId);
                csF.setInt(3, registration.getGradeLevelId());
                csF.executeUpdate();

                con.commit();
                isAdded = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            isAdded = false;
            e.printStackTrace();
        }
        return isAdded;
    }

}