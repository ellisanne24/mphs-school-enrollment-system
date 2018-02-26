
package daoimpl;

import dao.IReports;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.enrollment.Enrollment;
import model.faculty.Faculty;
import model.registration.Registration;
import model.schedule.Schedule;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ReportsDaoImpl implements IReports{

    @Override
    public Student getCOROf(int studentNo, SchoolYear schoolYear) {
        String SQL = "{CALL getCOROf(?,?)}";
        Student student = new Student();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, studentNo);
            cs.setInt(2, schoolYear.getSchoolYearId());
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Registration registration = new Registration();
                    registration.setRegistrationId(rs.getInt("registration_id"));
                    registration.setStudentType(rs.getString("student_type"));
                    registration.setLastName(rs.getString("lastname"));
                    registration.setFirstName(rs.getString("firstname"));
                    registration.setMiddleName(rs.getString("middlename"));
                    registration.setBirthday(rs.getDate("dob"));
                    registration.setPlaceOfBirth(rs.getString("pob"));
                    registration.setNationality(rs.getString("nationality"));
                    registration.setReligion(rs.getString("religion"));
                    registration.setGender(rs.getInt("gender") == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rs.getString("father_firstname"));
                    registration.setFatherMiddleName(rs.getString("father_middlename"));
                    registration.setFatherLastName(rs.getString("father_lastname"));
                    registration.setFatherOccupation(rs.getString("father_occupation"));
                    registration.setFatherOfficePhoneNo(rs.getString("father_officephone_no"));
                    registration.setFatherMobileNo(rs.getString("father_mobile_no"));
                    registration.setIsFatherContactInCaseEmergency(rs.getBoolean("isFatherContactInCaseEmergency"));
                    registration.setMotherFirstName(rs.getString("mother_firstname"));
                    registration.setMotherMiddleName(rs.getString("mother_middlename"));
                    registration.setMotherLastName(rs.getString("mother_lastname"));
                    registration.setMotherOccupation(rs.getString("mother_occupation"));
                    registration.setMotherOfficePhoneNo(rs.getString("mother_officephone_no"));
                    registration.setMotherMobileNo(rs.getString("mother_mobile_no"));
                    registration.setIsMotherContactInCaseEmergency(rs.getBoolean("isMotherContactInCaseEmergency"));
                    registration.setGuardianLastName(rs.getString("guardian_lastname"));
                    registration.setGuardianFirstName(rs.getString("guardian_firstname"));
                    registration.setGuardianMiddleName(rs.getString("guardian_middlename"));
                    registration.setGuardianOccupation(rs.getString("guardian_occupation"));
                    registration.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    registration.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    registration.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    registration.setSchoolLastAttended(rs.getString("school_last_attended"));
                    registration.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    registration.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    registration.setAddressStreet(rs.getString("street"));
                    registration.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    registration.setAddressCity(rs.getString("city"));
                    registration.setRegion(rs.getString("region"));
                    registration.setGradeLevelNo(rs.getInt("gradelevel_no"));
                    registration.setSchoolYearYearFrom(rs.getInt("schoolyear_yearfrom"));
                    registration.setRegistrationDate(rs.getDate("date_registered"));

                    String isAdmissionComplete = rs.getString("isAdmissionComplete").trim();
                    registration.setIsAdmissionComplete(isAdmissionComplete.equalsIgnoreCase("Yes") ? true : false);
                    
                    Enrollment enrollment = new Enrollment();
                    enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
                    enrollment.setSchoolYearId(rs.getInt("enrolledSchoolYearId"));
                    enrollment.setEnrollmentDate(rs.getDate("dateEnrolled"));
                    enrollment.setIsWithdrawn(rs.getBoolean("isEnrollmentWithdrawn"));
                    enrollment.setEnrollmentType(rs.getString("enrollment_type"));
                    
                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("adviser_id"));
                    adviser.setLastName(rs.getString("facultyLastName"));
                    adviser.setFirstName(rs.getString("facultyFirstName"));
                    adviser.setMiddleName(rs.getString("facultyMiddleName"));
                    
                    Section section = new Section();
                    section.setSectionName(rs.getString("sectionname"));
                    section.setAdviser(adviser);
                    
                    student.setStudentId(rs.getInt("student_id"));
                    student.setStudentNo(rs.getInt("student_no"));
                    student.setIsActive(rs.getBoolean("isStudentActive"));
                    student.setStudentType(rs.getString("finalStudentType").equalsIgnoreCase("O") == true ? 0 : 1);
                    student.setGradeLevelNo(rs.getInt("currentGradeLevel"));
                    student.setRegistration(registration);
                    student.setEnrollment(enrollment);
                    student.setSection(section);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    
    
}
