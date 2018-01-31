package controller.registration;

import daoimpl.AdmissionDaoImpl;
import daoimpl.FeeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.RegistrationDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.admission.Admission;
import model.fee.Fee;
import model.registration.Registration;
import org.jdatepicker.impl.JDatePickerImpl;
import utility.date.DateUtil;

/**
 *
 * @author Jordan
 */
public class UpdateRegistration implements ActionListener {

    private final DateUtil dateUtil;
    private final RegistrationDaoImpl registrationDaoImpl;
    private final FeeDaoImpl feeDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;
    private final AdmissionDaoImpl admissionDaoImpl;

    private final JDatePickerImpl dpBirthday;

    private final JButton jbtnRegister;
    private final JCheckBox jcbFatherContactEmergency;
    private final JComboBox jcmbGender;
    private final JCheckBox jcbGuardianContactEmergency;
    private final JCheckBox jcbMotherContactEmergency;
    private final JCheckBox jcbTransferee;
    private final JComboBox jcmbGradeLevel;
    private final JPanel jp_reglabel;
    private final JPanel jp_statuscont;
    private final JPanel jpnlCredentials;
    private final JPanel jpnlGuardianInfo;
    private final JPanel jpnlHomeAddress;
    private final JPanel jpnlParentInfo;
    private final JPanel jpnlPhoto;
    private final JPanel jpnlPictureContainer;
    private final JPanel jpnlStudentInfo;
    private final JTextField jtfBrgySubd;
    private final JTextField jtfCity;
    private final JTextField jtfFatherFirstname;
    private final JTextField jtfFatherLname;
    private final JTextField jtfFatherMiddleName;
    private final JTextField jtfFatherOccupation;
    private final JTextField jtfFatherOfficePhoneNo;
    private final JTextField jtfFatherMobile;
    private final JTextField jtfFirstName;
    private final JTextField jtfGuardianFirstName;
    private final JTextField jtfGuardianLastName;
    private final JTextField jtfGuardianMiddleName;
    private final JTextField jtfGuardianMobile;
    private final JTextField jtfGuardianOccupation;
    private final JTextField jtfGuardianRelationship;
    private final JTextField jtfLastName;
    private final JTextField jtfMiddleName;
    private final JTextField jtfMotherFirstName;
    private final JTextField jtfMotherLastName;
    private final JTextField jtfMotherMiddleName;
    private final JTextField jtfMotherOccupation;
    private final JTextField jtfMotherMobile;
    private final JTextField jtfNationality;
    private final JTextField jtfMotherOfficePhoneNo;
    private final JTextField jtfPlaceOfBirth;
    private final JTextField jtfRegion;
    private final JTextField jtfReligion;
    private final JTextField jtfRoomNo;
    private final JTextField jtfSchoolLastAttended;
    private final JTextField jtfSchoolLastAttendedAddress;
    private final JTextField jtfStreet;

    private final JButton jlblAdmissionStatus;
    private final JComboBox jcmbAdmissionStatus;

    private final int registrationId;

    public UpdateRegistration(int registrationId, JDatePickerImpl dpBirthday, JButton jbtnRegister, JCheckBox jcbFatherContactEmergency, JComboBox jcmbGender, JCheckBox jcbGuardianContactEmergency, JCheckBox jcbMotherContactEmergency, JCheckBox jcbTransferee, JComboBox jcmbGradeLevel, JPanel jp_reglabel, JPanel jp_statuscont, JPanel jpnlCredentials, JPanel jpnlGuardianInfo, JPanel jpnlHomeAddress, JPanel jpnlParentInfo, JPanel jpnlPhoto, JPanel jpnlPictureContainer, JPanel jpnlStudentInfo, JTextField jtfBrgySubd, JTextField jtfCity, JTextField jtfFatherFirstname, JTextField jtfFatherLname, JTextField jtfFatherMiddleName, JTextField jtfFatherOccupation, JTextField jtfFatherOfficePhoneNo, JTextField jtfFatherMobile, JTextField jtfFirstName, JTextField jtfGuardianFirstName, JTextField jtfGuardianLastName, JTextField jtfGuardianMiddleName, JTextField jtfGuardianMobile, JTextField jtfGuardianOccupation, JTextField jtfGuardianRelationship, JTextField jtfLastName, JTextField jtfMiddleName, JTextField jtfMotherFirstName, JTextField jtfMotherLastName, JTextField jtfMotherMiddleName, JTextField jtfMotherOccupation, JTextField jtfMotherMobile, JTextField jtfNationality, JTextField jtfMotherOfficePhoneNo, JTextField jtfPlaceOfBirth, JTextField jtfRegion, JTextField jtfReligion, JTextField jtfRoomNo, JTextField jtfSchoolLastAttended, JTextField jtfSchoolLastAttendedAddress, JTextField jtfStreet, JButton jlblAdmissionStatus, JComboBox jcmbAdmissionStatus) {
        this.registrationId = registrationId;

        this.dpBirthday = dpBirthday;
        this.jbtnRegister = jbtnRegister;
        this.jcbFatherContactEmergency = jcbFatherContactEmergency;
        this.jcmbGender = jcmbGender;
        this.jcbGuardianContactEmergency = jcbGuardianContactEmergency;
        this.jcbMotherContactEmergency = jcbMotherContactEmergency;
        this.jcbTransferee = jcbTransferee;
        this.jcmbGradeLevel = jcmbGradeLevel;
        this.jp_reglabel = jp_reglabel;
        this.jp_statuscont = jp_statuscont;
        this.jpnlCredentials = jpnlCredentials;
        this.jpnlGuardianInfo = jpnlGuardianInfo;
        this.jpnlHomeAddress = jpnlHomeAddress;
        this.jpnlParentInfo = jpnlParentInfo;
        this.jpnlPhoto = jpnlPhoto;
        this.jpnlPictureContainer = jpnlPictureContainer;
        this.jpnlStudentInfo = jpnlStudentInfo;
        this.jtfBrgySubd = jtfBrgySubd;
        this.jtfCity = jtfCity;
        this.jtfFatherFirstname = jtfFatherFirstname;
        this.jtfFatherLname = jtfFatherLname;
        this.jtfFatherMiddleName = jtfFatherMiddleName;
        this.jtfFatherOccupation = jtfFatherOccupation;
        this.jtfFatherOfficePhoneNo = jtfFatherOfficePhoneNo;
        this.jtfFatherMobile = jtfFatherMobile;
        this.jtfFirstName = jtfFirstName;
        this.jtfGuardianFirstName = jtfGuardianFirstName;
        this.jtfGuardianLastName = jtfGuardianLastName;
        this.jtfGuardianMiddleName = jtfGuardianMiddleName;
        this.jtfGuardianMobile = jtfGuardianMobile;
        this.jtfGuardianOccupation = jtfGuardianOccupation;
        this.jtfGuardianRelationship = jtfGuardianRelationship;
        this.jtfLastName = jtfLastName;
        this.jtfMiddleName = jtfMiddleName;
        this.jtfMotherFirstName = jtfMotherFirstName;
        this.jtfMotherLastName = jtfMotherLastName;
        this.jtfMotherMiddleName = jtfMotherMiddleName;
        this.jtfMotherOccupation = jtfMotherOccupation;
        this.jtfMotherMobile = jtfMotherMobile;
        this.jtfNationality = jtfNationality;
        this.jtfMotherOfficePhoneNo = jtfMotherOfficePhoneNo;
        this.jtfPlaceOfBirth = jtfPlaceOfBirth;
        this.jtfRegion = jtfRegion;
        this.jtfReligion = jtfReligion;
        this.jtfRoomNo = jtfRoomNo;
        this.jtfSchoolLastAttended = jtfSchoolLastAttended;
        this.jtfSchoolLastAttendedAddress = jtfSchoolLastAttendedAddress;
        this.jtfStreet = jtfStreet;
        this.jlblAdmissionStatus = jlblAdmissionStatus;
        this.jcmbAdmissionStatus = jcmbAdmissionStatus;

        dateUtil = new DateUtil();
        registrationDaoImpl = new RegistrationDaoImpl();
        feeDaoImpl = new FeeDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        admissionDaoImpl = new AdmissionDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save Edit?", "Save Edit Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (update()) {
                JOptionPane.showMessageDialog(null, "Successfully saved changes.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save changes.");
            }
        }
    }

    private boolean update() {
        boolean isUpdated = false;
        Registration reg = getRegistration();
        if (jcmbAdmissionStatus.getSelectedItem().toString().trim().equalsIgnoreCase("Pending")) {
            isUpdated = updateRegistrationInfo(reg);
        } else if (jcmbAdmissionStatus.getSelectedItem().toString().trim().equalsIgnoreCase("Complete")) {
            isUpdated = (updateRegistrationInfo(reg)) && (completeAdmission(reg));
        }
        return isUpdated;
    }

    private boolean updateRegistrationInfo(Registration reg){
        boolean isUpdated = false;
        isUpdated = registrationDaoImpl.updateRegistration(reg);
        return isUpdated;
    }
    
    private boolean completeAdmission(Registration reg) {
        boolean isCompleted = false;
        List<Fee> feeList = new ArrayList<>();
        int gradeLevelId = gradeLevelDaoImpl.getId(reg.getGradeLevelNo());
        feeList = feeDaoImpl.getFeesByGradeLevelId(gradeLevelId);
        
        Admission admission = new Admission();
        admission.setRegistration(reg);
        admission.setFeeList(feeList);
        isCompleted = admissionDaoImpl.completeAdmission(admission);
        return isCompleted;
    }
    
    private Registration getRegistration() {
        Registration reg = new Registration();
        try {
            reg.setStudentType(jcbTransferee.isSelected() == true ? "T" : "N");
            reg.setGradeLevelNo(Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim()));
            reg.setLastName(jtfLastName.getText().trim());
            reg.setFirstName(jtfFirstName.getText().trim());
            reg.setMiddleName(jtfMiddleName.getText().trim());
            reg.setGender(jcmbGender.getSelectedItem().toString().trim());
            reg.setReligion(jtfReligion.getText().trim());
            reg.setNationality(jtfNationality.getText().trim());
            reg.setBirthday(dateUtil.toDate(dpBirthday.getJFormattedTextField().getText().trim()));
            reg.setPlaceOfBirth(jtfPlaceOfBirth.getText().trim());
            reg.setAddressRoomOrHouseNo(jtfRoomNo.getText().trim());
            reg.setAddressStreet(jtfStreet.getText().trim());
            reg.setAddressBrgyOrSubd(jtfBrgySubd.getText().trim());
            reg.setAddressCity(jtfCity.getText().trim());
            reg.setRegion(jtfRegion.getText().trim());
            reg.setSchoolYearYearFrom(SchoolYearDaoImpl.getCurrentSchoolYearFrom());
            reg.setFatherFirstName(jtfFatherFirstname.getText().trim());
            reg.setFatherMiddleName(jtfFatherFirstname.getText().trim());
            reg.setFatherLastName(jtfFatherLname.getText().trim());
            reg.setFatherOccupation(jtfFatherOccupation.getText().trim());
            reg.setFatherOfficePhoneNo(jtfFatherOfficePhoneNo.getText().trim());
            reg.setFatherMobileNo(jtfFatherMobile.getText().trim());
            reg.setIsFatherContactInCaseEmergency(jcbFatherContactEmergency.isSelected());
            reg.setMotherFirstName(jtfMotherFirstName.getText().trim());
            reg.setMotherMiddleName(jtfMotherMiddleName.getText().trim());
            reg.setMotherLastName(jtfMotherLastName.getText().trim());
            reg.setMotherOccupation(jtfMotherOccupation.getText().trim());
            reg.setMotherOfficePhoneNo(jtfMotherOfficePhoneNo.getText().trim());
            reg.setMotherMobileNo(jtfMotherMobile.getText().trim());
            reg.setIsMotherContactInCaseEmergency(jcbMotherContactEmergency.isSelected());
            reg.setGuardianFirstName(jtfGuardianFirstName.getText().trim());
            reg.setGuardianMiddleName(jtfGuardianMiddleName.getText().trim());
            reg.setGuardianLastName(jtfGuardianLastName.getText().trim());
            reg.setGuardianOccupation(jtfGuardianOccupation.getText().trim());
            reg.setGuardianMobileNo(jtfGuardianMobile.getText().trim());
            reg.setGuardianRelationToStudent(jtfGuardianRelationship.getText().trim());
            reg.setIsGuardianContactInCaseEmergency(jcbGuardianContactEmergency.isSelected());
            reg.setSchoolLastAttended(jtfSchoolLastAttended.getText().trim());
            reg.setSchoolLastAttendedAddress(jtfSchoolLastAttendedAddress.getText().trim());

            reg.setRegistrationId(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reg;
    }
}

