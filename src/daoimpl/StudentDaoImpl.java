package daoimpl;

import constants.AdmissionTable;
import constants.RegistrationTable;
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
import model.registration.Registration;
import model.schoolyear.SchoolYear;
import model.student.Student;
import dao.IStudent;
import model.paymentterm.PaymentTerm;

public class StudentDaoImpl implements IStudent {

    private final AdmissionDaoImpl admissionDaoImpl;
    private final RegistrationDaoImpl registrationDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;

    public StudentDaoImpl() {
        admissionDaoImpl = new AdmissionDaoImpl();
        registrationDaoImpl = new RegistrationDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
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
        String SQL = "{CALL getStudentCurrentGradeLevelId(?)}";
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
        String SQLc = "{CALL getGradeLevelById(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);
                CallableStatement csC = con.prepareCall(SQLc);) {
            csA.setString(1, aKeyword);
            csA.setFetchSize(100);
            csB.setFetchSize(100);
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
                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rsA.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }

                    admission.setGradeLevel(admissionLevel);

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
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQLc = "{CALL getRegistrationPaymentTermByStudentId(?)}";

        Student student = new Student();
        Admission admission = new Admission();
        Registration registration = new Registration();
        CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            try (CallableStatement csA = con.prepareCall(SQLa);
                    CallableStatement csB = con.prepareCall(SQLb);
                    CallableStatement csC = con.prepareCall(SQLc);) {
                csA.setInt(1, aStudentId);
                csB.setInt(1, aStudentId);
                csC.setInt(1, aStudentId);
                try (ResultSet rsA = csA.executeQuery();) {
                    while (rsA.next()) {
                        registration.setRegistrationId(rsA.getInt("registration_id"));
                        registration.setStudentType(rsA.getInt("student_type") == 1 ? "New" : "Old");
                        registration.setLastName(rsA.getString("lastname"));
                        registration.setFirstName(rsA.getString("firstname"));
                        registration.setMiddleName(rsA.getString("middlename"));
                        registration.setDateOfBirth(rsA.getString("dob"));
                        registration.setPlaceOfBirth(rsA.getString("pob"));
                        registration.setNationality(rsA.getString("nationality"));
                        registration.setGender(rsA.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
                        registration.setFatherFirstName(rsA.getString("father_firstname"));
                        registration.setFatherMiddleName(rsA.getString("father_middlename"));
                        registration.setFatherLastName(rsA.getString("father_lastname"));
                        registration.setFatherOccupation(rsA.getString("father_occupation"));
                        registration.setFatherOfficePhoneNo(rsA.getString("father_officephone_no"));
                        registration.setFatherMobileNo(rsA.getString("father_mobile_no"));
                        registration.setIsFatherContactInCaseEmergency(rsA.getBoolean("isFatherContactInCaseEmergency"));
                        registration.setMotherFirstName(rsA.getString("mother_firstname"));
                        registration.setMotherMiddleName(rsA.getString("mother_middlename"));
                        registration.setMotherLastName(rsA.getString("mother_lastname"));
                        registration.setMotherOccupation(rsA.getString("mother_occupation"));
                        registration.setMotherOfficePhoneNo(rsA.getString("mother_officephone_no"));
                        registration.setMotherMobileNo(rsA.getString("mother_mobile_no"));
                        registration.setIsMotherContactInCaseEmergency(rsA.getBoolean("isMotherContactInCaseEmergency"));
                        registration.setGuardianLastName(rsA.getString("guardian_lastname"));
                        registration.setGuardianFirstName(rsA.getString("guardian_firstname"));
                        registration.setGuardianMiddleName(rsA.getString("guardian_middlename"));
                        registration.setGuardianOccupation(rsA.getString("guardian_occupation"));
                        registration.setGuardianOfficePhoneNo(rsA.getString("guardian_officephone_no"));
                        registration.setGuardianMobileNo(rsA.getString("guardian_mobile_no"));
                        registration.setGuardianRelationToStudent(rsA.getString("guardian_relation_to_student"));
                        registration.setIsGuardianContactInCaseEmergency(rsA.getBoolean("isGuardianContactInCaseEmergency"));
                        registration.setSchoolLastAttended(rsA.getString("school_last_attended"));
                        registration.setSchoolLastAttendedAddress(rsA.getString("school_last_attended_address"));
                        registration.setAddressRoomOrHouseNo(rsA.getString("room_or_house_no"));
                        registration.setAddressStreet(rsA.getString("street"));
                        registration.setAddressBrgyOrSubd(rsA.getString("brgy_or_subd"));
                        registration.setAddressCity(rsA.getString("city"));
                        registration.setProvince(rsA.getString("province"));

                        GradeLevel gradeLevel = gradeLevelDaoImpl.getById(rsA.getInt("gradelevel_id"));
                        registration.setGradeLevel(gradeLevel.getLevel());

                        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
                        SchoolYear schoolYear = schoolYearDaoImpl.getById(rsA.getInt("schoolyear_id"));
                        registration.setSchoolYear(schoolYear);

                        PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
                        PaymentTerm paymentTerm = paymentTermDaoImpl.getById(rsA.getInt("paymentterm_id"));
                        registration.setPaymentTerm(paymentTerm.getName());

                        admission.setAdmissionId(rsA.getInt("admission_id"));
                        admission.setIsCompleted(rsA.getBoolean("isComplete"));
                        admission.setCompletionDate(rsA.getDate("completion_date"));
                        admission.setGradeLevel(gradeLevel.getLevel());

                        student.setStudentId(rsA.getInt("student_id"));
                        student.setEntryDate(rsA.getDate("entry_date"));
                        student.setIsGraduated(rsA.getBoolean("isGraduated"));
                        student.setDateGraduated(rsA.getDate("date_graduated"));
                        student.setIsActive(rsA.getBoolean("isActive"));

                        student.setStudentType(rsA.getInt("student_type"));

                        ResultSet rsB = csB.executeQuery();
                        if (rsB.next()) {
                            int level = rsB.getInt("grade_level");
                            currentGradeLevel.setLevel(level);
                        }

                        student.setAdmission(admission);
                        student.setRegistration(registration);
                        student.setCurrentGradeLevel(currentGradeLevel);
                    }
                }

                try (ResultSet rsc = csC.executeQuery();) {
                    while (rsc.next()) {
                        registration.setPaymentTerm(rsc.getString("paymentterm"));
                    }
                }
                student.setAdmission(admission);
                student.setRegistration(registration);
                student.setCurrentGradeLevel(currentGradeLevel);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student getStudentRecordById(Student aStudent) {
        int aStudentId = aStudent.getStudentId();
        String SQLa = "{CALL getStudentRecordById(?)}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        Student student = new Student();
        Admission admission = new Admission();
        Registration registration = new Registration();
        CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);) {
            csA.setInt(1, aStudentId);
            csB.setInt(1, aStudentId);
            try (ResultSet rs = csA.executeQuery();) {
                while (rs.next()) {
                    registration.setRegistrationId(rs.getInt("registration_id"));
                    registration.setStudentType(rs.getInt("student_type") == 1 ? "New" : "Old");
                    registration.setLastName(rs.getString("lastname"));
                    registration.setFirstName(rs.getString("firstname"));
                    registration.setMiddleName(rs.getString("middlename"));
                    registration.setDateOfBirth(rs.getString("dob"));
                    registration.setPlaceOfBirth(rs.getString("pob"));
                    registration.setNationality(rs.getString("nationality"));
                    registration.setGender(rs.getInt(RegistrationTable.GENDER) == 1 ? "Male" : "Female");
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
                    registration.setGradeLevelId(rs.getInt("gradelevel_id"));
                    
                    GradeLevel gradeLevel = gradeLevelDaoImpl.getById(rs.getInt("gradelevel_id"));
                    registration.setGradeLevel(gradeLevel.getLevel());

                    SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
                    SchoolYear schoolYear = schoolYearDaoImpl.getById(rs.getInt("schoolyear_id"));
                    registration.setSchoolYear(schoolYear);

                    PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();
                    PaymentTerm paymentTerm = paymentTermDaoImpl.getById(rs.getInt("paymentterm_id"));
                    registration.setPaymentTerm(paymentTerm.getName());

                    admission.setAdmissionId(rs.getInt("admission_id"));
                    admission.setIsCompleted(rs.getBoolean("isComplete"));
                    admission.setCompletionDate(rs.getDate("completion_date"));
                    admission.setGradeLevel(gradeLevel.getLevel());

                    student.setStudentId(rs.getInt("student_id"));
                    student.setEntryDate(rs.getDate("entry_date"));
                    student.setIsGraduated(rs.getBoolean("isGraduated"));
                    student.setDateGraduated(rs.getDate("date_graduated"));
                    student.setIsActive(rs.getBoolean("isActive"));

                    student.setStudentType(rs.getInt("student_type"));

                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getActiveOfCurrentSchoolYear() {
        List<Student> list = new ArrayList<>();
        String SQLa = "{CALL getAllActiveStudentsOfCurrentSchoolYear()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQLc = "{CALL getGradeLevelById(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);
                CallableStatement csC = con.prepareCall(SQLc);) {
            cs.setFetchSize(100);
            csB.setFetchSize(100);
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

                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rs.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }

                    admission.setGradeLevel(admissionLevel);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);
                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> getInactive() {
        List<Student> list = new ArrayList<>();
        String SQLa = "{CALL getAllInactiveStudents()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQLc = "{CALL getGradeLevelById(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);
                CallableStatement csC = con.prepareCall(SQLc);) {
            csA.setFetchSize(100);
            csB.setFetchSize(100);
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

                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rsA.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }

                    admission.setGradeLevel(admissionLevel);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> getInactive(SchoolYear aSchoolYear) {
        List<Student> list = new ArrayList<>();
        String getAllInactiveStudentsBySchoolYear = "{CALL getAllInactiveStudentsBySchoolYear(?)}";
        String getStudentCurrentGradeLevel = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQL_getGradeLevelById = "{CALL getGradeLevelById(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(getAllInactiveStudentsBySchoolYear);
                CallableStatement csB = con.prepareCall(getStudentCurrentGradeLevel);
                CallableStatement csC = con.prepareCall(SQL_getGradeLevelById);) {
            csA.setInt(1, aSchoolYear.getSchoolYearId());
            csA.setFetchSize(100);
            csB.setFetchSize(100);
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

                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rsA.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }

                    admission.setGradeLevel(admissionLevel);

                    student.setAdmission(admission);
                    student.setRegistration(registration);
                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setLastGradeLevelEnrolledSchoolYear(schoolYear);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> get(SchoolYear aSchoolYear) {
        String SQLa = "{CALL getStudentsBySchoolYear(?)}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQLc = "{CALL getGradeLevelById(?)}";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);
                CallableStatement csC = con.prepareCall(SQLc);) {
            csA.setInt(1, aSchoolYear.getSchoolYearId());
            csA.setFetchSize(100);
            csB.setFetchSize(100);
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

                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        int level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rs.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }
                    admission.setGradeLevel(admissionLevel);

                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setAdmission(admission);
                    student.setRegistration(registration);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> get() {
        String SQLa = "{CALL getAllStudents()}";
        String SQLb = "{CALL getStudentCurrentGradeLevel(?)}";
        String SQLc = "{CALL getGradeLevelById(?)}";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csA = con.prepareCall(SQLa);
                CallableStatement csB = con.prepareCall(SQLb);
                CallableStatement csC = con.prepareCall(SQLc);) {
            csA.setFetchSize(100);
            csB.setFetchSize(100);
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

                    CurrentGradeLevel currentGradeLevel = new CurrentGradeLevel();
                    csB.setInt(1, student.getStudentId());
                    ResultSet rsB = csB.executeQuery();
                    if (rsB.next()) {
                        Integer level = rsB.getInt("grade_level");
                        currentGradeLevel.setLevel(level);
                    }

                    Integer admissionLevel = null;
                    int gradelevel_id = rsA.getInt("gradelevel_id");
                    csC.setInt(1, gradelevel_id);
                    ResultSet rsC = csC.executeQuery();
                    if (rsC.next()) {
                        admissionLevel = rsC.getInt("grade_level");
                    }

                    admission.setGradeLevel(admissionLevel);

                    student.setCurrentGradeLevel(currentGradeLevel);
                    student.setAdmission(admission);
                    student.setRegistration(registration);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            ex.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return list;
    }

}//end of class
