package daoimpl;

import constants.AdmissionTable;
import constants.RegistrationTable;
import constants.SchoolYearTable;
import constants.StudentTable;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.admission.Admission;
import model.gradelevel.GradeLevel;
import model.gradelevel.CurrentGradeLevel;
import model.gradelevel.PromotedGradeLevel;
import model.registration.Registration;
import model.schoolyear.SchoolYear;
import model.student.Student;
import dao.IStudent;

public class StudentDaoImpl implements IStudent {

    @Override
    public boolean exists(int aStudentId, int aSchoolYearId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getId(int registrationId) {
        Integer studentId = null;
        String SQL = "{CALL getStudentIdByRegistrationId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, registrationId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    studentId = rs.getInt("student_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentId;
    }

    @Override
    public Integer getCurrentGradeLevelId(int studentId) {
        Integer gradeLevelId = null;
        String SQL = "{CALL getStudentCurrentGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, studentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    gradeLevelId = rs.getInt("gradelevel_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeLevelId;
    }

    @Override
    public List<Student> get(String aKeyword) {
        List<Student> studentList = new ArrayList<>();
        String SQLa = "{CALL getAllStudentsByWildCard(?)}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            csA.setString(1, aKeyword);
            try (ResultSet rsA = csA.executeQuery();) {
                while (rsA.next()) {
                    Admission admission = new Admission();
                    Registration registration = new Registration();
                    Student student = new Student();

                    admission.setAdmissionId(rsA.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rsA.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rsA.getDate(AdmissionTable.COMPLETIONDATE));
                    admission.setGradeLevel(rsA.getInt("grade_level"));
                    registration.setRegistrationId(rsA.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rsA.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rsA.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rsA.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rsA.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rsA.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rsA.getString(RegistrationTable.POB));
                    registration.setNationality(rsA.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rsA.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rsA.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rsA.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rsA.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rsA.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rsA.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rsA.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rsA.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rsA.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rsA.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rsA.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rsA.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rsA.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rsA.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rsA.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rsA.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rsA.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rsA.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rsA.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rsA.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rsA.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rsA.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rsA.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rsA.getString(RegistrationTable.CITY));
                    registration.setProvince(rsA.getString(RegistrationTable.PROVINCE));
                    student.setStudentId(rsA.getInt(StudentTable.STUDENTID));
                    student.setStudentType(rsA.getInt("aStudentType"));
                    student.setEntryDate(rsA.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rsA.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rsA.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rsA.getBoolean(StudentTable.ISACTIVE));

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);

                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public boolean isAlreadyEnrolledInCurrentSchoolYear(Student aStudent) {
        int currentSchoolYearId = new SchoolYearDaoImpl().getCurrentSchoolYearId();
        boolean isAlreadyEnrolledInSchoolYear = false;
        String SQL = "{CALL isAlreadyEnrolledInCurrentSchoolYear(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudent.getStudentId());
            cs.setInt(2, currentSchoolYearId);
            int rowCount = 0;

            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    rowCount++;
                }
                isAlreadyEnrolledInSchoolYear = rowCount > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return isAlreadyEnrolledInSchoolYear;
    }

    @Override
    public Student getStudentById(int aStudentId) {
        String SQLa = "{CALL getStudentRecordById(?)}";
        String SQLb = "{CALL registrationExists(?)}";
        String SQLc = "{CALL getRegistrationPaymentTermByStudentId(?)}";

        Student student = new Student();
        Admission admission = new Admission();
        Registration registration = new Registration();
        GradeLevel admissionGradeLevel = new GradeLevel();
        GradeLevel lastGradeLevelEnrolled = new GradeLevel();
        CurrentGradeLevel presentGradeLevel = new CurrentGradeLevel();
        PromotedGradeLevel promotedGradeLevel = new PromotedGradeLevel();
        SchoolYear schoolYear = new SchoolYear();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);
                    CallableStatement csc = con.prepareCall(SQLc);) {
                csa.setInt(1, aStudentId);
                csb.setInt(1, aStudentId);
                csc.setInt(1, aStudentId);
                try (ResultSet rsa = csa.executeQuery();) {
                    while (rsa.next()) {
                        admission.setAdmissionId(rsa.getInt(AdmissionTable.ADMISSIONID));
                        admission.setIsCompleted(rsa.getBoolean(AdmissionTable.ISCOMPLETE));
                        admission.setCompletionDate(rsa.getDate(AdmissionTable.COMPLETIONDATE));
                        registration.setRegistrationId(rsa.getInt(RegistrationTable.REGISTRATION_ID));
                        registration.setStudentType(rsa.getString(RegistrationTable.STUDENT_TYPE));
                        registration.setLastName(rsa.getString(RegistrationTable.LASTNAME));
                        registration.setFirstName(rsa.getString(RegistrationTable.FIRSTNAME));
                        registration.setMiddleName(rsa.getString(RegistrationTable.MIDDLENAME));
                        registration.setDateOfBirth(rsa.getString(RegistrationTable.DOB));
                        registration.setPlaceOfBirth(rsa.getString(RegistrationTable.POB));
                        registration.setNationality(rsa.getString(RegistrationTable.NATIONALITY));
                        registration.setGender(rsa.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                        registration.setFatherFirstName(rsa.getString(RegistrationTable.FATHER_FIRSTNAME));
                        registration.setFatherMiddleName(rsa.getString(RegistrationTable.FATHER_MIDDLENAME));
                        registration.setFatherLastName(rsa.getString(RegistrationTable.FATHER_LASTNAME));
                        registration.setFatherOccupation(rsa.getString(RegistrationTable.FATHER_OCCUPATION));
                        registration.setFatherOfficePhoneNo(rsa.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                        registration.setFatherMobileNo(rsa.getString(RegistrationTable.FATHER_MOBILE_NO));
                        registration.setIsFatherContactInCaseEmergency(rsa.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                        registration.setMotherFirstName(rsa.getString(RegistrationTable.MOTHER_FIRSTNAME));
                        registration.setMotherMiddleName(rsa.getString(RegistrationTable.MOTHER_MIDDLENAME));
                        registration.setMotherLastName(rsa.getString(RegistrationTable.MOTHER_LASTNAME));
                        registration.setMotherOccupation(rsa.getString(RegistrationTable.MOTHER_OCCUPATION));
                        registration.setMotherOfficePhoneNo(rsa.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                        registration.setMotherMobileNo(rsa.getString(RegistrationTable.MOTHER_MOBILE_NO));
                        registration.setIsMotherContactInCaseEmergency(rsa.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                        registration.setGuardianLastName(rsa.getString(RegistrationTable.GUARDIAN_LASTNAME));
                        registration.setGuardianFirstName(rsa.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                        registration.setGuardianMiddleName(rsa.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                        registration.setGuardianOccupation(rsa.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                        registration.setGuardianOfficePhoneNo(rsa.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                        registration.setGuardianMobileNo(rsa.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                        registration.setGuardianRelationToStudent(rsa.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                        registration.setIsGuardianContactInCaseEmergency(rsa.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                        registration.setSchoolLastAttended(rsa.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                        registration.setSchoolLastAttendedAddress(rsa.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                        registration.setAddressRoomOrHouseNo(rsa.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                        registration.setAddressStreet(rsa.getString(RegistrationTable.STREET));
                        registration.setAddressBrgyOrSubd(rsa.getString(RegistrationTable.BRGY_OR_SUBD));
                        registration.setAddressCity(rsa.getString(RegistrationTable.CITY));
                        registration.setProvince(rsa.getString(RegistrationTable.PROVINCE));
                        registration.setRegistrationDate(rsa.getDate("date_registered"));

                        registration.setGradeLevel(rsa.getInt("registeredGradeLevel"));

                        student.setStudentId(rsa.getInt(StudentTable.STUDENTID));
                        student.setEntryDate(rsa.getDate(StudentTable.ENTRYDATE));
                        student.setIsGraduated(rsa.getBoolean(StudentTable.ISGRADUATED));
                        student.setDateGraduated(rsa.getDate(StudentTable.DATEGRADUATED));
                        student.setIsActive(rsa.getBoolean(StudentTable.ISACTIVE));

                        student.setStudentType(rsa.getInt("studentType"));
                        student.setIsNew((rsa.getInt("studentType") == 1));

                        admissionGradeLevel.setLevel(rsa.getInt("admissionGradeLevel"));
                        if (rsa.getObject("aPassed") == null) {
                            presentGradeLevel.setIsPassed(null);
                        } else {
                            presentGradeLevel.setIsPassed(rsa.getBoolean("aPassed"));
                        }

                        presentGradeLevel.setLevel(rsa.getInt("presentGradeLevel")); //ALIAS field
                        int pg = rsa.getInt("promotedGradeLevel");
                        if (rsa.wasNull()) {
                        } else {
                            promotedGradeLevel.setLevel(pg);
                        }

                        int lastGLevel = rsa.getInt("last_gradelevel_enrolled");
                        if (rsa.wasNull()) {

                        } else {
                            lastGradeLevelEnrolled.setLevel(lastGLevel);
                        }

                        schoolYear.setSchoolYearId(rsa.getInt("last_gradelevel_enrolled_schoolyear_id")); //ALIAS field

                        int yFrom = rsa.getInt("last_gradelevel_enrolled_schoolyear_yearFrom");
                        if (rsa.wasNull()) {

                        } else {
                            schoolYear.setYearFrom(yFrom);
                        }

                        int yTo = rsa.getInt("last_gradelevel_enrolled_schoolyear_yearTo");
                        if (rsa.wasNull()) {

                        } else {
                            schoolYear.setYearTo(yTo);
                        }

                        SchoolYear registeredSchoolYear = new SchoolYear();
                        registeredSchoolYear.setSchoolYearId(rsa.getInt("schoolyear_id"));
                        registeredSchoolYear.setYearFrom(rsa.getInt("yearFrom"));
                        registeredSchoolYear.setYearTo(rsa.getInt("yearTo"));
                        registration.setSchoolYear(registeredSchoolYear);
                    }
                }

                try (ResultSet rsb = csb.executeQuery();) {
                    while (rsb.next()) {
                        registration.setExists(rsb.getBoolean("registrationExists"));
                    }
                }

                try (ResultSet rsc = csc.executeQuery();) {
                    while (rsc.next()) {
                        registration.setPaymentTerm(rsc.getString("paymentterm"));
                    }
                }

                student.setAdmission(admission);
                student.setRegistration(registration);
                student.setAdmissionGradeLevel(admissionGradeLevel);
                student.setCurrentGradeLevel(presentGradeLevel);
                student.setLastGradeLevelEnrolledSchoolYear(schoolYear);

                student.setPromotedGradeLevel(promotedGradeLevel); // int level only

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return student;
    }

    @Override
    public Student getStudentRecordById(Student aStudent) {
        int aStudentId = aStudent.getStudentId();
        String SQL = "{CALL getStudentRecordById(?)}";
        Student student = new Student();
        Admission admission = new Admission();
        Registration registration = new Registration();
        GradeLevel admissionGradeLevel = new GradeLevel();
        GradeLevel lastGradeLevelEnrolled = new GradeLevel();
        CurrentGradeLevel presentGradeLevel = new CurrentGradeLevel();
        PromotedGradeLevel promotedGradeLevel = new PromotedGradeLevel();
        SchoolYear schoolYear = new SchoolYear();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    admission.setAdmissionId(rs.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rs.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rs.getDate(AdmissionTable.COMPLETIONDATE));
                    registration.setRegistrationId(rs.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rs.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rs.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rs.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rs.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rs.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rs.getString(RegistrationTable.POB));
                    registration.setNationality(rs.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rs.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rs.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rs.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rs.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rs.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rs.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rs.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rs.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rs.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rs.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rs.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rs.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rs.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rs.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rs.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rs.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rs.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rs.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rs.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rs.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rs.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rs.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rs.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rs.getString(RegistrationTable.CITY));
                    registration.setProvince(rs.getString(RegistrationTable.PROVINCE));

                    registration.setGradeLevel(rs.getInt("registeredGradeLevel"));

                    student.setStudentId(rs.getInt(StudentTable.STUDENTID));
                    student.setEntryDate(rs.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rs.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rs.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rs.getBoolean(StudentTable.ISACTIVE));

                    student.setStudentType(rs.getInt("studentType"));

                    admissionGradeLevel.setLevel(rs.getInt("admissionGradeLevel"));
                    presentGradeLevel.setIsPassed(rs.getBoolean("has_passed_last_gradelevel"));
                    presentGradeLevel.setLevel(rs.getInt("presentGradeLevel")); //ALIAS field
                    promotedGradeLevel.setLevel(rs.getInt("promotedGradeLevel"));
                    lastGradeLevelEnrolled.setLevel(rs.getInt("last_gradelevel_enrolled"));

                    schoolYear.setSchoolYearId(rs.getInt("last_gradelevel_enrolled_schoolyear_id")); //ALIAS field
                    schoolYear.setYearFrom(rs.getInt("last_gradelevel_enrolled_schoolyear_yearFrom")); //ALIAS field
                    schoolYear.setYearTo(rs.getInt("last_gradelevel_enrolled_schoolyear_yearTo")); //ALIAS field

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setAdmissionGradeLevel(admissionGradeLevel);
                    student.setCurrentGradeLevel(presentGradeLevel);
                    student.setLastGradeLevelEnrolledSchoolYear(schoolYear);
                    student.setPromotedGradeLevel(promotedGradeLevel); // int level only
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> getActiveOfCurrentSchoolYear() {
        List<Student> list = new ArrayList<>();
        String SQLa = "{CALL getAllActiveStudentsOfCurrentSchoolYear()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Student student = new Student();
                    Registration registration = new Registration();
                    Admission admission = new Admission();

                    admission.setAdmissionId(rs.getInt("admission_id"));
                    admission.setIsCompleted(rs.getBoolean("isComplete"));
                    admission.setCompletionDate(rs.getDate("completion_date"));

                    registration.setRegistrationId(rs.getInt("registration_id"));
                    registration.setStudentType(rs.getString("student_type"));
                    registration.setLastName(rs.getString("lastname"));
                    registration.setFirstName(rs.getString("firstname"));
                    registration.setMiddleName(rs.getString("middlename"));
                    registration.setDateOfBirth(rs.getString("dob"));
                    registration.setPlaceOfBirth(rs.getString("pob"));
                    registration.setNationality(rs.getString("nationality"));
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
                    registration.setGuardianOfficePhoneNo(rs.getString("guardian_officephone_no"));
                    registration.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    registration.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    registration.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    registration.setSchoolLastAttended(rs.getString("school_last_attended"));
                    registration.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    registration.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    registration.setAddressStreet(rs.getString("street"));
                    registration.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    registration.setAddressCity(rs.getString("city"));
                    registration.setProvince(rs.getString("province"));

                    student.setStudentType(rs.getInt("aStudentType"));
                    student.setStudentId(rs.getInt("student_id"));
                    student.setEntryDate(rs.getDate("entry_date"));
                    student.setIsGraduated(rs.getBoolean("isGraduated"));
                    student.setDateGraduated(rs.getDate("date_graduated"));
                    student.setIsActive(rs.getBoolean("aStudentStatus"));

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);
                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Student> getInactive() {
        List<Student> list = new ArrayList<>();
        String SQLa = "{CALL getAllInactiveStudents()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            try (ResultSet rsA = csA.executeQuery();) {
                while (rsA.next()) {
                    Admission admission = new Admission();
                    Registration registration = new Registration();
                    Student student = new Student();

                    admission.setAdmissionId(rsA.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rsA.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rsA.getDate(AdmissionTable.COMPLETIONDATE));
                    registration.setRegistrationId(rsA.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rsA.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rsA.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rsA.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rsA.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rsA.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rsA.getString(RegistrationTable.POB));
                    registration.setNationality(rsA.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rsA.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rsA.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rsA.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rsA.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rsA.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rsA.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rsA.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rsA.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rsA.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rsA.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rsA.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rsA.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rsA.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rsA.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rsA.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rsA.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rsA.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rsA.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rsA.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rsA.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rsA.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rsA.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rsA.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rsA.getString(RegistrationTable.CITY));
                    registration.setProvince(rsA.getString(RegistrationTable.PROVINCE));
                    student.setStudentType(rsA.getInt("aStudentType"));
                    student.setStudentId(rsA.getInt(StudentTable.STUDENTID));
                    student.setEntryDate(rsA.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rsA.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rsA.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rsA.getBoolean("aStudentStatus"));

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Student> getInactive(SchoolYear aSchoolYear) {
        List<Student> list = new ArrayList<>();
        String SQLa = "{CALL getAllInactiveStudentsBySchoolYear(?)}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            csA.setInt(1, aSchoolYear.getSchoolYearId());
            try (ResultSet rsA = csA.executeQuery();) {
                while (rsA.next()) {
                    Admission admission = new Admission();
                    Registration registration = new Registration();
                    CurrentGradeLevel previousGradeLevel = new CurrentGradeLevel();
                    Student student = new Student();
                    SchoolYear schoolYear = new SchoolYear();

                    admission.setAdmissionId(rsA.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rsA.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rsA.getDate(AdmissionTable.COMPLETIONDATE));
                    registration.setRegistrationId(rsA.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rsA.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rsA.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rsA.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rsA.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rsA.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rsA.getString(RegistrationTable.POB));
                    registration.setNationality(rsA.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rsA.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rsA.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rsA.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rsA.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rsA.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rsA.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rsA.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rsA.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rsA.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rsA.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rsA.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rsA.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rsA.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rsA.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rsA.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rsA.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rsA.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rsA.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rsA.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rsA.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rsA.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rsA.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rsA.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rsA.getString(RegistrationTable.CITY));
                    registration.setProvince(rsA.getString(RegistrationTable.PROVINCE));
                    student.setStudentId(rsA.getInt(StudentTable.STUDENTID));
                    student.setEntryDate(rsA.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rsA.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rsA.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rsA.getBoolean(StudentTable.ISACTIVE));

                    previousGradeLevel.setIsPassed(rsA.getBoolean("has_passed_last_gradelevel"));
                    previousGradeLevel.setLevel(rsA.getInt("last_gradelevel_enrolled")); //ALIAS field
                    schoolYear.setSchoolYearId(rsA.getInt("last_gradelevel_enrolled_schoolyear_id")); //ALIAS field
                    schoolYear.setYearFrom(rsA.getInt("last_gradelevel_enrolled_schoolyear_yearFrom")); //ALIAS field
                    schoolYear.setYearTo(rsA.getInt("last_gradelevel_enrolled_schoolyear_yearTo")); //ALIAS field

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setLastGradeLevelEnrolledSchoolYear(schoolYear);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Student> get(SchoolYear aSchoolYear) {
        String SQLa = "{CALL getStudentsBySchoolYear(?)}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            csA.setInt(1, aSchoolYear.getSchoolYearId());
            try (ResultSet rs = csA.executeQuery();) {
                while (rs.next()) {
                    Admission admission = new Admission();
                    Registration registration = new Registration();
                    Student student = new Student();

                    admission.setAdmissionId(rs.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rs.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rs.getDate(AdmissionTable.COMPLETIONDATE));
                    registration.setRegistrationId(rs.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rs.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rs.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rs.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rs.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rs.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rs.getString(RegistrationTable.POB));
                    registration.setNationality(rs.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rs.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rs.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rs.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rs.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rs.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rs.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rs.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rs.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rs.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rs.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rs.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rs.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rs.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rs.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rs.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rs.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rs.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rs.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rs.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rs.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rs.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rs.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rs.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rs.getString(RegistrationTable.CITY));
                    registration.setProvince(rs.getString(RegistrationTable.PROVINCE));
                    student.setStudentId(rs.getInt(StudentTable.STUDENTID));
                    student.setEntryDate(rs.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rs.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rs.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rs.getBoolean(StudentTable.ISACTIVE));

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setAdmission(admission);
                    student.setRegistration(registration);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Student> get() {
        String SQLa = "{CALL getAllStudents()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            try (ResultSet rsA = csA.executeQuery();) {
                while (rsA.next()) {
                    Admission admission = new Admission();
                    Registration registration = new Registration();
                    Student student = new Student();

                    admission.setAdmissionId(rsA.getInt(AdmissionTable.ADMISSIONID));
                    admission.setIsCompleted(rsA.getBoolean(AdmissionTable.ISCOMPLETE));
                    admission.setCompletionDate(rsA.getDate(AdmissionTable.COMPLETIONDATE));
                    registration.setRegistrationId(rsA.getInt(RegistrationTable.REGISTRATION_ID));
                    registration.setStudentType(rsA.getString(RegistrationTable.STUDENT_TYPE));
                    registration.setLastName(rsA.getString(RegistrationTable.LASTNAME));
                    registration.setFirstName(rsA.getString(RegistrationTable.FIRSTNAME));
                    registration.setMiddleName(rsA.getString(RegistrationTable.MIDDLENAME));
                    registration.setDateOfBirth(rsA.getString(RegistrationTable.DOB));
                    registration.setPlaceOfBirth(rsA.getString(RegistrationTable.POB));
                    registration.setNationality(rsA.getString(RegistrationTable.NATIONALITY));
                    registration.setGender(rsA.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                    registration.setFatherFirstName(rsA.getString(RegistrationTable.FATHER_FIRSTNAME));
                    registration.setFatherMiddleName(rsA.getString(RegistrationTable.FATHER_MIDDLENAME));
                    registration.setFatherLastName(rsA.getString(RegistrationTable.FATHER_LASTNAME));
                    registration.setFatherOccupation(rsA.getString(RegistrationTable.FATHER_OCCUPATION));
                    registration.setFatherOfficePhoneNo(rsA.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    registration.setFatherMobileNo(rsA.getString(RegistrationTable.FATHER_MOBILE_NO));
                    registration.setIsFatherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    registration.setMotherFirstName(rsA.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    registration.setMotherMiddleName(rsA.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    registration.setMotherLastName(rsA.getString(RegistrationTable.MOTHER_LASTNAME));
                    registration.setMotherOccupation(rsA.getString(RegistrationTable.MOTHER_OCCUPATION));
                    registration.setMotherOfficePhoneNo(rsA.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    registration.setMotherMobileNo(rsA.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    registration.setIsMotherContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    registration.setGuardianLastName(rsA.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    registration.setGuardianFirstName(rsA.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    registration.setGuardianMiddleName(rsA.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    registration.setGuardianOccupation(rsA.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    registration.setGuardianOfficePhoneNo(rsA.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    registration.setGuardianMobileNo(rsA.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    registration.setGuardianRelationToStudent(rsA.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    registration.setIsGuardianContactInCaseEmergency(rsA.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    registration.setSchoolLastAttended(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    registration.setSchoolLastAttendedAddress(rsA.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    registration.setAddressRoomOrHouseNo(rsA.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    registration.setAddressStreet(rsA.getString(RegistrationTable.STREET));
                    registration.setAddressBrgyOrSubd(rsA.getString(RegistrationTable.BRGY_OR_SUBD));
                    registration.setAddressCity(rsA.getString(RegistrationTable.CITY));
                    registration.setProvince(rsA.getString(RegistrationTable.PROVINCE));
                    student.setStudentId(rsA.getInt(StudentTable.STUDENTID));
                    student.setStudentType(rsA.getInt("aStudentType"));
                    student.setEntryDate(rsA.getDate(StudentTable.ENTRYDATE));
                    student.setIsGraduated(rsA.getBoolean(StudentTable.ISGRADUATED));
                    student.setDateGraduated(rsA.getDate(StudentTable.DATEGRADUATED));
                    student.setIsActive(rsA.getBoolean(StudentTable.ISACTIVE));

                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    rsB.next();
                    int level = rsB.getInt("grade_level");
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    currentGradeLevel.setLevel(level);

                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setAdmission(admission);
                    student.setRegistration(registration);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean isEnrolledInSchoolYear(Integer aStudentId, Integer aSchoolYearId) {
        boolean isEnrolled = false;
        String SQL = "{CALL isEnrolledInSchoolYear(?,?)}";
        int rowCount = 0;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            cs.setInt(2, aSchoolYearId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    rowCount++;
                }
                isEnrolled = rowCount > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return isEnrolled;
    }

    @Override
    public Integer getPresentGradeLevelByStudentId(Integer aStudentId) {
        Integer aPresentGradeLevel = null;
        String SQL = "{CALL getPresentGradeLevelByStudentId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    aPresentGradeLevel = rs.getInt("aPresentGradeLevel");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return aPresentGradeLevel;
    }

    @Override
    public Integer getRecommendedGradeLevel(Integer aStudentId) {
        Integer aRecommendedGradeLevel = null;
        String SQL = "{CALL getRecommendedGradeLevel(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    aRecommendedGradeLevel = rs.getInt("aRecommendedGradeLevel");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return aRecommendedGradeLevel;
    }

    @Override
    public Integer getRegistrationId(Integer aStudentId) {
        Integer aRegistrationId = null;
        String SQL = "{CALL getRegistrationIdByStudentId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    aRegistrationId = rs.getInt("aRegistrationId");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return aRegistrationId;
    }

    @Override
    public Integer getAdmissionGradeLevelByRegistrationId(Integer aRegistrationId) {
        Integer admissionGradeLevel = null;
        String SQL = "{CALL getAdmissionGradeLevelByRegistrationId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aRegistrationId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    admissionGradeLevel = rs.getInt("admissionGradeLevel");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return admissionGradeLevel;
    }

    @Override
    public List<Student> getAllRegisteredStudentsByGradeId(GradeLevel aGradeLevel) {
        String sql = "call getAllRegisteredStudentsByGradeId(?)";
        List<Student> list = new ArrayList();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, aGradeLevel.getId());
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();

                    student.setStudentId(rs.getInt(1));
                    student.setFirstName(rs.getString(2));
                    student.setMiddleName(rs.getString(3));
                    student.setLastName(rs.getString(4));
                    student.gradeLevel.setLevel(rs.getInt(5));
                    list.add(student);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error at getAllRegisteredStudentsByGradeId" + ex);
        }

        return list;
    }

    @Override
    public Integer getRegistrationIdByStudentId(Integer aStudentId) {
        Integer aRegistrationId = null;
        String SQL = "{CALL getRegistrationIdByStudentId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aStudentId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    aRegistrationId = rs.getInt("aRegistrationId");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return aRegistrationId;
    }

    @Override
    public List<Student> getAllStudent() {
        String sql = "call getAllStudent()";
        List<Student> list = new ArrayList();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql)) {
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setStudentId(rs.getInt("student_id"));
                    student.setFirstName(rs.getString("firstname"));
                    student.setMiddleName(rs.getString("middlename"));
                    student.setLastName(rs.getString("lastname"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error at getAllStudent " + e);
        }

        return list;
    }

}//end of class
