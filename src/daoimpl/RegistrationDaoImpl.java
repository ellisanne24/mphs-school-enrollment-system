package daoimpl;

import constants.AdmissionTable;
import constants.RegistrationTable;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.registration.Registration;
import model.schoolyear.SchoolYear;
import dao.IRegistration;

public class RegistrationDaoImpl implements IRegistration{

    PaymentTermDaoImpl paymentTermDaoImpl = new PaymentTermDaoImpl();

    @Override
    public boolean isDuplicateRegistration(Registration registration) {
        boolean isDuplicate = false;
        String SQL = "{CALL isDuplicateRegistration(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setString(1, registration.getFirstName().toLowerCase().trim());
            cs.setString(2, registration.getMiddleName().toLowerCase().trim());
            cs.setString(3, registration.getLastName().toLowerCase().trim());
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    isDuplicate = rs.getBoolean("isDuplicate");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDuplicate;
    }
    
    @Override
    public List<Registration> getAllRegistrationInfoBySyYearFrom(int syYearFrom) {
        List<Registration> registrationList = new ArrayList<>();
        String SQL = "{CALL getAllRegistrationInfoBySyYearFrom(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,syYearFrom);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Registration reg = new Registration();
                    reg.setRegistrationId(rs.getInt("registration_id"));
                    reg.setStudentType(rs.getString("student_type"));
                    reg.setLastName(rs.getString("lastname") );
                    reg.setFirstName(rs.getString("firstname")); 
                    reg.setMiddleName(rs.getString("middlename"));
                    reg.setBirthday(rs.getDate("dob"));
                    reg.setPlaceOfBirth(rs.getString("pob"));
                    reg.setNationality(rs.getString("nationality"));
                    reg.setReligion(rs.getString("religion"));
                    reg.setGender(rs.getInt("gender")==1?"Male":"Female");
                    reg.setFatherFirstName(rs.getString("father_firstname"));
                    reg.setFatherMiddleName(rs.getString("father_middlename"));
                    reg.setFatherLastName(rs.getString("father_lastname"));
                    reg.setFatherOccupation(rs.getString("father_occupation"));
                    reg.setFatherOfficePhoneNo(rs.getString("father_officephone_no"));
                    reg.setFatherMobileNo(rs.getString("father_mobile_no"));
                    reg.setIsFatherContactInCaseEmergency(rs.getBoolean("isFatherContactInCaseEmergency"));
                    reg.setMotherFirstName(rs.getString("mother_firstname"));
                    reg.setMotherMiddleName(rs.getString("mother_middlename"));
                    reg.setMotherLastName(rs.getString("mother_lastname"));
                    reg.setMotherOccupation(rs.getString("mother_occupation"));
                    reg.setMotherOfficePhoneNo(rs.getString("mother_officephone_no"));
                    reg.setMotherMobileNo(rs.getString("mother_mobile_no"));
                    reg.setIsMotherContactInCaseEmergency(rs.getBoolean("isMotherContactInCaseEmergency"));
                    reg.setGuardianLastName(rs.getString("guardian_lastname"));
                    reg.setGuardianFirstName(rs.getString("guardian_firstname"));
                    reg.setGuardianMiddleName(rs.getString("guardian_middlename"));
                    reg.setGuardianOccupation(rs.getString("guardian_occupation"));
                    reg.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    reg.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    reg.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    reg.setSchoolLastAttended(rs.getString("school_last_attended"));
                    reg.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    reg.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    reg.setAddressStreet(rs.getString("street"));
                    reg.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    reg.setAddressCity(rs.getString("city"));
                    reg.setRegion(rs.getString("region"));
                    reg.setGradeLevelNo(rs.getInt("gradelevel_no"));
                    reg.setSchoolYearYearFrom(rs.getInt("schoolyear_yearfrom"));
                    reg.setRegistrationDate(rs.getDate("date_registered"));
                    reg.setStudentNo(rs.getInt("student_no"));
                    
                    String isAdmissionComplete = rs.getString("isAdmissionComplete").trim();
                    reg.setIsAdmissionComplete(isAdmissionComplete.equalsIgnoreCase("Yes")? true : false);
                    
                    registrationList.add(reg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationList;
    }

    @Override
    public List<Registration> getAllRegistrationInfoByWildCard(String wildCardChar) {
        List<Registration> registrationList = new ArrayList<>();
        String SQL = "{CALL getAllRegistrationInfoByWildCard(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1,wildCardChar);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Registration reg = new Registration();
                    reg.setRegistrationId(rs.getInt("registration_id"));
                    reg.setStudentType(rs.getString("student_type"));
                    reg.setLastName(rs.getString("lastname") );
                    reg.setFirstName(rs.getString("firstname")); 
                    reg.setMiddleName(rs.getString("middlename"));
                    reg.setBirthday(rs.getDate("dob"));
                    reg.setPlaceOfBirth(rs.getString("pob"));
                    reg.setNationality(rs.getString("nationality"));
                    reg.setReligion(rs.getString("religion"));
                    reg.setGender(rs.getInt("gender")==1?"Male":"Female");
                    reg.setFatherFirstName(rs.getString("father_firstname"));
                    reg.setFatherMiddleName(rs.getString("father_middlename"));
                    reg.setFatherLastName(rs.getString("father_lastname"));
                    reg.setFatherOccupation(rs.getString("father_occupation"));
                    reg.setFatherOfficePhoneNo(rs.getString("father_officephone_no"));
                    reg.setFatherMobileNo(rs.getString("father_mobile_no"));
                    reg.setIsFatherContactInCaseEmergency(rs.getBoolean("isFatherContactInCaseEmergency"));
                    reg.setMotherFirstName(rs.getString("mother_firstname"));
                    reg.setMotherMiddleName(rs.getString("mother_middlename"));
                    reg.setMotherLastName(rs.getString("mother_lastname"));
                    reg.setMotherOccupation(rs.getString("mother_occupation"));
                    reg.setMotherOfficePhoneNo(rs.getString("mother_officephone_no"));
                    reg.setMotherMobileNo(rs.getString("mother_mobile_no"));
                    reg.setIsMotherContactInCaseEmergency(rs.getBoolean("isMotherContactInCaseEmergency"));
                    reg.setGuardianLastName(rs.getString("guardian_lastname"));
                    reg.setGuardianFirstName(rs.getString("guardian_firstname"));
                    reg.setGuardianMiddleName(rs.getString("guardian_middlename"));
                    reg.setGuardianOccupation(rs.getString("guardian_occupation"));
                    reg.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    reg.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    reg.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    reg.setSchoolLastAttended(rs.getString("school_last_attended"));
                    reg.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    reg.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    reg.setAddressStreet(rs.getString("street"));
                    reg.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    reg.setAddressCity(rs.getString("city"));
                    reg.setRegion(rs.getString("region"));
                    reg.setGradeLevelNo(rs.getInt("gradelevel_no"));
                    reg.setSchoolYearYearFrom(rs.getInt("schoolyear_yearfrom"));
                    reg.setRegistrationDate(rs.getDate("date_registered"));
                   
                    String isAdmissionComplete = rs.getString("isAdmissionComplete").trim();
                    reg.setIsAdmissionComplete(isAdmissionComplete.equalsIgnoreCase("Yes")? true : false);
                    
                    registrationList.add(reg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationList;
    }

    @Override
    public List<Registration> getAllRegistrationInfoByAdmissionStatus(int admissionStatus) {
        List<Registration> registrationList = new ArrayList<>();
        String SQL = "{CALL getAllRegistrationInfoByAdmissionStatus(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,admissionStatus);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Registration reg = new Registration();
                    reg.setRegistrationId(rs.getInt("registration_id"));
                    reg.setStudentType(rs.getString("student_type"));
                    reg.setLastName(rs.getString("lastname") );
                    reg.setFirstName(rs.getString("firstname")); 
                    reg.setMiddleName(rs.getString("middlename"));
                    reg.setBirthday(rs.getDate("dob"));
                    reg.setPlaceOfBirth(rs.getString("pob"));
                    reg.setNationality(rs.getString("nationality"));
                    reg.setReligion(rs.getString("religion"));
                    reg.setGender(rs.getInt("gender")==1?"Male":"Female");
                    reg.setFatherFirstName(rs.getString("father_firstname"));
                    reg.setFatherMiddleName(rs.getString("father_middlename"));
                    reg.setFatherLastName(rs.getString("father_lastname"));
                    reg.setFatherOccupation(rs.getString("father_occupation"));
                    reg.setFatherOfficePhoneNo(rs.getString("father_officephone_no"));
                    reg.setFatherMobileNo(rs.getString("father_mobile_no"));
                    reg.setIsFatherContactInCaseEmergency(rs.getBoolean("isFatherContactInCaseEmergency"));
                    reg.setMotherFirstName(rs.getString("mother_firstname"));
                    reg.setMotherMiddleName(rs.getString("mother_middlename"));
                    reg.setMotherLastName(rs.getString("mother_lastname"));
                    reg.setMotherOccupation(rs.getString("mother_occupation"));
                    reg.setMotherOfficePhoneNo(rs.getString("mother_officephone_no"));
                    reg.setMotherMobileNo(rs.getString("mother_mobile_no"));
                    reg.setIsMotherContactInCaseEmergency(rs.getBoolean("isMotherContactInCaseEmergency"));
                    reg.setGuardianLastName(rs.getString("guardian_lastname"));
                    reg.setGuardianFirstName(rs.getString("guardian_firstname"));
                    reg.setGuardianMiddleName(rs.getString("guardian_middlename"));
                    reg.setGuardianOccupation(rs.getString("guardian_occupation"));
                    reg.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    reg.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    reg.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    reg.setSchoolLastAttended(rs.getString("school_last_attended"));
                    reg.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    reg.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    reg.setAddressStreet(rs.getString("street"));
                    reg.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    reg.setAddressCity(rs.getString("city"));
                    reg.setRegion(rs.getString("region"));
                    reg.setGradeLevelNo(rs.getInt("gradelevel_no"));
                    reg.setSchoolYearYearFrom(rs.getInt("schoolyear_yearfrom"));
                    reg.setRegistrationDate(rs.getDate("date_registered"));
                   
                    String isAdmissionComplete = rs.getString("isAdmissionComplete").trim();
                    reg.setIsAdmissionComplete(isAdmissionComplete.equalsIgnoreCase("Yes")? true : false);
                    
                    registrationList.add(reg);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrationList;
    }

    @Override
    public List<Registration> getAllRegistrationInfo() {
        List<Registration> list = new ArrayList<>();
        String SQL = "{CALL getAllRegistrationInfo()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Registration reg = new Registration();
                    reg.setRegistrationId(rs.getInt(RegistrationTable.REGISTRATION_ID));
                    reg.setStudentType(rs.getString(RegistrationTable.STUDENT_TYPE));
                    reg.setLastName(rs.getString(RegistrationTable.LASTNAME) );
                    reg.setFirstName(rs.getString(RegistrationTable.FIRSTNAME)); 
                    reg.setMiddleName(rs.getString(RegistrationTable.MIDDLENAME));
//                    reg.setBirthday(rs.getString(RegistrationTable.DOB));
                    reg.setPlaceOfBirth(rs.getString(RegistrationTable.POB));
                    reg.setNationality(rs.getString(RegistrationTable.NATIONALITY));
                    reg.setReligion(rs.getString(RegistrationTable.RELIGION));
                    reg.setGender(rs.getInt(RegistrationTable.GENDER)==1?"Male":"Female");
                    reg.setFatherFirstName(rs.getString(RegistrationTable.FATHER_FIRSTNAME));
                    reg.setFatherMiddleName(rs.getString(RegistrationTable.FATHER_MIDDLENAME));
                    reg.setFatherLastName(rs.getString(RegistrationTable.FATHER_LASTNAME));
                    reg.setFatherOccupation(rs.getString(RegistrationTable.FATHER_OCCUPATION));
                    reg.setFatherOfficePhoneNo(rs.getString(RegistrationTable.FATHER_OFFICEPHONE_NO));
                    reg.setFatherMobileNo(rs.getString(RegistrationTable.FATHER_MOBILE_NO));
                    reg.setIsFatherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISFATHERCONTACTINCASEEMERGENCY));
                    reg.setMotherFirstName(rs.getString(RegistrationTable.MOTHER_FIRSTNAME));
                    reg.setMotherMiddleName(rs.getString(RegistrationTable.MOTHER_MIDDLENAME));
                    reg.setMotherLastName(rs.getString(RegistrationTable.MOTHER_LASTNAME));
                    reg.setMotherOccupation(rs.getString(RegistrationTable.MOTHER_OCCUPATION));
                    reg.setMotherOfficePhoneNo(rs.getString(RegistrationTable.MOTHER_OFFICEPHONE_NO));
                    reg.setMotherMobileNo(rs.getString(RegistrationTable.MOTHER_MOBILE_NO));
                    reg.setIsMotherContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISMOTHERCONTACTINCASEEMERGENCY));
                    reg.setGuardianLastName(rs.getString(RegistrationTable.GUARDIAN_LASTNAME));
                    reg.setGuardianFirstName(rs.getString(RegistrationTable.GUARDIAN_FIRSTNAME));
                    reg.setGuardianMiddleName(rs.getString(RegistrationTable.GUARDIAN_MIDDLENAME));
                    reg.setGuardianOccupation(rs.getString(RegistrationTable.GUARDIAN_OCCUPATION));
                    reg.setGuardianOfficePhoneNo(rs.getString(RegistrationTable.GUARDIAN_OFFICEPHONE_NO));
                    reg.setGuardianMobileNo(rs.getString(RegistrationTable.GUARDIAN_MOBILE_NO));
                    reg.setGuardianRelationToStudent(rs.getString(RegistrationTable.GUARDIAN_RELATION_TO_STUDENT));
                    reg.setIsGuardianContactInCaseEmergency(rs.getBoolean(RegistrationTable.ISGUARDIANCONTACTINCASEEMERGENCY));
                    reg.setSchoolLastAttended(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED));
                    reg.setSchoolLastAttendedAddress(rs.getString(RegistrationTable.SCHOOL_LAST_ATTENDED_ADDRESS));
                    reg.setIsAdmissionComplete(rs.getBoolean(AdmissionTable.ISCOMPLETE));
                    reg.setAddressRoomOrHouseNo(rs.getString(RegistrationTable.ROOM_OR_HOUSE_NO));
                    reg.setAddressStreet(rs.getString(RegistrationTable.STREET));
                    reg.setAddressBrgyOrSubd(rs.getString(RegistrationTable.BRGY_OR_SUBD));
                    reg.setAddressCity(rs.getString(RegistrationTable.CITY));
                    
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    schoolYear.setYearTo(rs.getInt("yearTo"));
                    
                    reg.setSchoolYear(schoolYear);
                    
                    int gradeLevel = Integer.parseInt( rs.getString(RegistrationTable.GRADELEVEL) );
                    reg.setGradeLevelNo(gradeLevel);
                    
                    reg.setRegistrationDate(rs.getDate("date_registered"));
                    
                    list.add(reg);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"getAllRegistrationInfo(): \n"+ e.getMessage());
        }
        return list;
    }

    @Override
    public Registration getRegistrationInfoById(int registrationId) {
        String SQL = "{CALL getRegistrationInfoById(?)}";
        Registration reg = new Registration();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, registrationId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    reg.setRegistrationId(rs.getInt("registration_id"));
                    reg.setStudentType(rs.getString("student_type"));
                    reg.setLastName(rs.getString("lastname") );
                    reg.setFirstName(rs.getString("firstname")); 
                    reg.setMiddleName(rs.getString("middlename"));
                    reg.setBirthday(rs.getDate("dob"));
                    reg.setPlaceOfBirth(rs.getString("pob"));
                    reg.setNationality(rs.getString("nationality"));
                    reg.setReligion(rs.getString("religion"));
                    reg.setGender(rs.getInt("gender")==1?"Male":"Female");
                    reg.setFatherFirstName(rs.getString("father_firstname"));
                    reg.setFatherMiddleName(rs.getString("father_middlename"));
                    reg.setFatherLastName(rs.getString("father_lastname"));
                    reg.setFatherOccupation(rs.getString("father_occupation"));
                    reg.setFatherOfficePhoneNo(rs.getString("father_officephone_no"));
                    reg.setFatherMobileNo(rs.getString("father_mobile_no"));
                    reg.setIsFatherContactInCaseEmergency(rs.getBoolean("isFatherContactInCaseEmergency"));
                    reg.setMotherFirstName(rs.getString("mother_firstname"));
                    reg.setMotherMiddleName(rs.getString("mother_middlename"));
                    reg.setMotherLastName(rs.getString("mother_lastname"));
                    reg.setMotherOccupation(rs.getString("mother_occupation"));
                    reg.setMotherOfficePhoneNo(rs.getString("mother_officephone_no"));
                    reg.setMotherMobileNo(rs.getString("mother_mobile_no"));
                    reg.setIsMotherContactInCaseEmergency(rs.getBoolean("isMotherContactInCaseEmergency"));
                    reg.setGuardianLastName(rs.getString("guardian_lastname"));
                    reg.setGuardianFirstName(rs.getString("guardian_firstname"));
                    reg.setGuardianMiddleName(rs.getString("guardian_middlename"));
                    reg.setGuardianOccupation(rs.getString("guardian_occupation"));
                    reg.setGuardianMobileNo(rs.getString("guardian_mobile_no"));
                    reg.setGuardianRelationToStudent(rs.getString("guardian_relation_to_student"));
                    reg.setIsGuardianContactInCaseEmergency(rs.getBoolean("isGuardianContactInCaseEmergency"));
                    reg.setSchoolLastAttended(rs.getString("school_last_attended"));
                    reg.setSchoolLastAttendedAddress(rs.getString("school_last_attended_address"));
                    reg.setAddressRoomOrHouseNo(rs.getString("room_or_house_no"));
                    reg.setAddressStreet(rs.getString("street"));
                    reg.setAddressBrgyOrSubd(rs.getString("brgy_or_subd"));
                    reg.setAddressCity(rs.getString("city"));
                    reg.setRegion(rs.getString("region"));
                    reg.setGradeLevelNo(rs.getInt("gradelevel_no"));
                    reg.setSchoolYearYearFrom(rs.getInt("schoolyear_yearfrom"));
                    reg.setRegistrationDate(rs.getDate("date_registered"));
                   
                    String isAdmissionComplete = rs.getString("isAdmissionComplete").trim();
                    reg.setIsAdmissionComplete(isAdmissionComplete.equalsIgnoreCase("Yes")? true : false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reg;

    }//end of method

    @Override
    public String getRegistrationPaymentTermByStudentId(Integer studentId) {
        String SQL = "{CALL getRegistrationPaymentTermByStudentId(?)}";
        String paymentTerm = null;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, studentId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    paymentTerm = rs.getString("paymentterm");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getErrorCode()+"\n"+e.getMessage());
        }
        return paymentTerm;
    }
    
    @Override
    public boolean addRegistration(Registration r) {
        boolean isAdded = false;
        String SQLa = "{"
                + "CALL addRegistration"
                + "("
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?"
                + ") "
                + "}" ;
        
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);) {
                csa.setString(1, r.getStudentType());
                csa.setString(2, r.getLastName());
                csa.setString(3, r.getFirstName());
                csa.setString(4, r.getMiddleName());
                csa.setObject(5, r.getBirthday());
                csa.setString(6, r.getPlaceOfBirth());
                csa.setString(7, r.getNationality());
                csa.setString(8, r.getReligion());
                csa.setInt(9, "Male".equals(r.getGender()) ? 1 : 0);
                csa.setString(10, r.getFatherFirstName());
                csa.setString(11, r.getFatherMiddleName());
                csa.setString(12, r.getFatherLastName());
                csa.setString(13, r.getFatherOccupation());
                csa.setString(14, r.getFatherOfficePhoneNo());
                csa.setString(15, r.getFatherMobileNo());
                csa.setInt(16, r.getIsFatherContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(17, r.getMotherFirstName());
                csa.setString(18, r.getMotherMiddleName());
                csa.setString(19, r.getMotherLastName());
                csa.setString(20, r.getMotherOccupation());
                csa.setString(21, r.getMotherOfficePhoneNo());
                csa.setString(22, r.getMotherMobileNo());
                csa.setInt(23, r.getIsMotherContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(24, r.getGuardianLastName());
                csa.setString(25, r.getGuardianFirstName());
                csa.setString(26, r.getGuardianMiddleName());
                csa.setString(27, r.getGuardianOccupation());
                csa.setString(28, r.getGuardianMobileNo());
                csa.setString(29, r.getGuardianRelationToStudent());
                csa.setInt(30, r.getIsGuardianContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(31, r.getSchoolLastAttended());
                csa.setString(32, r.getSchoolLastAttendedAddress());
                csa.setString(33, r.getAddressRoomOrHouseNo());
                csa.setString(34, r.getAddressStreet());
                csa.setString(35, r.getAddressBrgyOrSubd());
                csa.setString(36, r.getAddressCity());
                csa.setString(37, r.getRegion());
                csa.setInt(38,r.getGradeLevelNo());
                csa.setInt(39, r.getSchoolYearYearFrom());
                csa.executeUpdate();
                
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

    @Override
    public boolean updateRegistration(Registration r) {
        boolean isUpdated = false;
        String SQLa = "{"
                + "CALL updateRegistration"
                + "("
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?"
                + ") "
                + "}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);) {
                csa.setString(1, r.getStudentType());
                csa.setString(2, r.getLastName());
                csa.setString(3, r.getFirstName());
                csa.setString(4, r.getMiddleName());
                csa.setObject(5, r.getBirthday());
                csa.setString(6, r.getPlaceOfBirth());
                csa.setString(7, r.getNationality());
                csa.setString(8, r.getReligion());
                csa.setInt(9, "Male".equals(r.getGender()) ? 1 : 0);
                csa.setString(10, r.getFatherFirstName());
                csa.setString(11, r.getFatherMiddleName());
                csa.setString(12, r.getFatherLastName());
                csa.setString(13, r.getFatherOccupation());
                csa.setString(14, r.getFatherOfficePhoneNo());
                csa.setString(15, r.getFatherMobileNo());
                csa.setInt(16, r.getIsFatherContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(17, r.getMotherFirstName());
                csa.setString(18, r.getMotherMiddleName());
                csa.setString(19, r.getMotherLastName());
                csa.setString(20, r.getMotherOccupation());
                csa.setString(21, r.getMotherOfficePhoneNo());
                csa.setString(22, r.getMotherMobileNo());
                csa.setInt(23, r.getIsMotherContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(24, r.getGuardianLastName());
                csa.setString(25, r.getGuardianFirstName());
                csa.setString(26, r.getGuardianMiddleName());
                csa.setString(27, r.getGuardianOccupation());
                csa.setString(28, r.getGuardianMobileNo());
                csa.setString(29, r.getGuardianRelationToStudent());
                csa.setInt(30, r.getIsGuardianContactInCaseEmergency() == true ? 1 : 0);
                csa.setString(31, r.getSchoolLastAttended());
                csa.setString(32, r.getSchoolLastAttendedAddress());
                csa.setString(33, r.getAddressRoomOrHouseNo());
                csa.setString(34, r.getAddressStreet());
                csa.setString(35, r.getAddressBrgyOrSubd());
                csa.setString(36, r.getAddressCity());
                csa.setString(37, r.getRegion());
                csa.setInt(38,r.getGradeLevelNo());
                csa.setInt(39, r.getSchoolYearYearFrom());
                csa.setInt(40, r.getRegistrationId());
                csa.executeUpdate();
                
                isUpdated = true;
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean deleteRegistration(Registration registration) {
        boolean isDeleted = false;
        return isDeleted;
    }
 
     
}//end of class
