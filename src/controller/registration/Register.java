package controller.registration;

import daoimpl.RegistrationDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.registration.Registration;
import org.jdatepicker.impl.JDatePickerImpl;
import utility.date.DateUtil;
import utility.form.FormValidator;

/**
 *
 * @author Jordan
 */
public class Register implements ActionListener, FormValidator{
    private DateUtil dateUtil;
    private final RegistrationDaoImpl registrationDaoImpl;

    private JDatePickerImpl dpBirthday;
    
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

    public Register(JDatePickerImpl dpBirthday, JButton jbtnRegister, JCheckBox jcbFatherContactEmergency, JComboBox jcmbGender, JCheckBox jcbGuardianContactEmergency, JCheckBox jcbMotherContactEmergency, JCheckBox jcbTransferee, JComboBox jcmbGradeLevel, JPanel jp_reglabel, JPanel jp_statuscont, JPanel jpnlCredentials, JPanel jpnlGuardianInfo, JPanel jpnlHomeAddress, JPanel jpnlParentInfo, JPanel jpnlPhoto, JPanel jpnlPictureContainer, JPanel jpnlStudentInfo, JTextField jtfBrgySubd, JTextField jtfCity, JTextField jtfFatherFirstname, JTextField jtfFatherLname, JTextField jtfFatherMiddleName, JTextField jtfFatherOccupation, JTextField jtfFatherOfficePhoneNo, JTextField jtfFatherMobile, JTextField jtfFirstName, JTextField jtfGuardianFirstName, JTextField jtfGuardianLastName, JTextField jtfGuardianMiddleName, JTextField jtfGuardianMobile, JTextField jtfGuardianOccupation, JTextField jtfGuardianRelationship, JTextField jtfLastName, JTextField jtfMiddleName, JTextField jtfMotherFirstName, JTextField jtfMotherLastName, JTextField jtfMotherMiddleName, JTextField jtfMotherOccupation, JTextField jtfMotherMobile, JTextField jtfNationality, JTextField jtfMotherOfficePhoneNo, JTextField jtfPlaceOfBirth, JTextField jtfRegion, JTextField jtfReligion, JTextField jtfRoomNo, JTextField jtfSchoolLastAttended, JTextField jtfSchoolLastAttendedAddress, JTextField jtfStreet) {
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
        
        dateUtil = new DateUtil();
        registrationDaoImpl = new RegistrationDaoImpl();
    }
    
    private void clearForm() {
        List<Component[]> componentArr = new ArrayList<>();
        componentArr.add(jpnlHomeAddress.getComponents());
        componentArr.add(jpnlParentInfo.getComponents());
        componentArr.add(jpnlGuardianInfo.getComponents());
        componentArr.add(jp_statuscont.getComponents());
        componentArr.add(jpnlCredentials.getComponents());
        componentArr.add(jpnlStudentInfo.getComponents());
        for (int i = 0; i < componentArr.size(); i++) {
            for (Component c : componentArr.get(i)) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText("");
                } else if (c instanceof JComboBox) {
                    ((JComboBox) c).setSelectedIndex(-1);
                } else if (c instanceof JCheckBox) {
                    ((JCheckBox) c).setSelected(false);
                } else if (c instanceof JList) {
                    ((DefaultListModel) ((JList) c).getModel()).removeAllElements();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Save Registration?", "Registration Confirmation",JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            if(register()){
                JOptionPane.showMessageDialog(null, "Successfully registered.");
                clearForm();
            }else{
                JOptionPane.showMessageDialog(null, "Failed to register.");
            }
        }
    }
    
    private boolean register(){
        boolean isRegistered = false;
        isRegistered = registrationDaoImpl.addRegistration(getRegistration());
        return isRegistered;
    }
    
    private Registration getRegistration() {
        Registration r = new Registration();
        try {
            r.setStudentType(jcbTransferee.isSelected() == true ? "T" : "N");
            r.setGradeLevelNo(Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim()));
            r.setLastName(jtfLastName.getText().trim());
            r.setFirstName(jtfFirstName.getText().trim());
            r.setMiddleName(jtfMiddleName.getText().trim());
            r.setGender(jcmbGender.getSelectedItem().toString().trim());
            r.setReligion(jtfReligion.getText().trim());
            r.setNationality(jtfNationality.getText().trim());
            r.setBirthday(dateUtil.toDate(dpBirthday.getJFormattedTextField().getText().trim()));
            r.setPlaceOfBirth(jtfPlaceOfBirth.getText().trim());
            r.setAddressRoomOrHouseNo(jtfRoomNo.getText().trim());
            r.setAddressStreet(jtfStreet.getText().trim());
            r.setAddressBrgyOrSubd(jtfBrgySubd.getText().trim());
            r.setAddressCity(jtfCity.getText().trim());
            r.setRegion(jtfRegion.getText().trim());
            r.setSchoolYearYearFrom(SchoolYearDaoImpl.getCurrentSchoolYearFrom());
            r.setFatherFirstName(jtfFatherFirstname.getText().trim());
            r.setFatherMiddleName(jtfFatherFirstname.getText().trim());
            r.setFatherLastName(jtfFatherLname.getText().trim());
            r.setFatherOccupation(jtfFatherOccupation.getText().trim());
            r.setFatherOfficePhoneNo(jtfFatherOfficePhoneNo.getText().trim());
            r.setFatherMobileNo(jtfFatherMobile.getText().trim());
            r.setIsFatherContactInCaseEmergency(jcbFatherContactEmergency.isSelected());
            r.setMotherFirstName(jtfMotherFirstName.getText().trim());
            r.setMotherMiddleName(jtfMotherMiddleName.getText().trim());
            r.setMotherLastName(jtfMotherLastName.getText().trim());
            r.setMotherOccupation(jtfMotherOccupation.getText().trim());
            r.setMotherOfficePhoneNo(jtfMotherOfficePhoneNo.getText().trim());
            r.setMotherMobileNo(jtfMotherMobile.getText().trim());
            r.setIsMotherContactInCaseEmergency(jcbMotherContactEmergency.isSelected());
            r.setGuardianFirstName(jtfGuardianFirstName.getText().trim());
            r.setGuardianMiddleName(jtfGuardianMiddleName.getText().trim());
            r.setGuardianLastName(jtfGuardianLastName.getText().trim());
            r.setGuardianOccupation(jtfGuardianOccupation.getText().trim());
            r.setGuardianMobileNo(jtfGuardianMobile.getText().trim());
            r.setGuardianRelationToStudent(jtfGuardianRelationship.getText().trim());
            r.setIsGuardianContactInCaseEmergency(jcbGuardianContactEmergency.isSelected());
            r.setSchoolLastAttended(jtfSchoolLastAttended.getText().trim());
            r.setSchoolLastAttendedAddress(jtfSchoolLastAttendedAddress.getText().trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean formIsValid() {
        boolean isValid = false;
        List<Component[]> compArr = new ArrayList<>();
        compArr.add(jpnlStudentInfo.getComponents());
        for (int i = 0; i < compArr.size(); i++) {
            for (Component c : compArr.get(i)) {
                if (c instanceof JTextField) {
                    isValid = isValid && ((JTextField) c).getText().isEmpty();
                }
                if (c instanceof JComboBox) {
                    isValid = isValid && ((JComboBox) c).getSelectedIndex() == -1;
                }
            }
        }
        return isValid;
    }
}
