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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.registration.Registration;
import utility.date.DateUtil;
import utility.form.FormValidator;
import view.registration.View_Panel_Registration;

/**
 *
 * @author Jordan
 */
public class Controller_JButton_Register implements ActionListener, FormValidator {

    private final View_Panel_Registration view;
    private final DateUtil dateUtil;
    private final RegistrationDaoImpl registrationDaoImpl;

    public Controller_JButton_Register(View_Panel_Registration view) {
        this.view = view;
        dateUtil = new DateUtil();
        registrationDaoImpl = new RegistrationDaoImpl();
    }

    private void clearForm() {
        List<Component[]> components = new ArrayList<>();
        components.add(view.getJpnlHomeAddress().getComponents());
        components.add(view.getJpnlParentInfo().getComponents());
        components.add(view.getJpnlGuardianInfo().getComponents());
        components.add(view.getJpnlStatusCont().getComponents());
        components.add(view.getJpnlCredentials().getComponents());
        components.add(view.getJpnlStudentInfo().getComponents());
        for (int i = 0; i < components.size(); i++) {
            for (Component c : components.get(i)) {
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
        int choice = JOptionPane.showConfirmDialog(null, "Save Registration?", "Registration Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (register()) {
                JOptionPane.showMessageDialog(null, "Successfully registered.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register.");
            }
        }
    }

    private boolean register() {
        boolean isRegistered = false;
        isRegistered = registrationDaoImpl.addRegistration(getRegistration());
        return isRegistered;
    }

    private Registration getRegistration() {
        Registration r = new Registration();
        try {
            r.setStudentType(view.getJcbTransferee().isSelected() == true ? "T" : "N");
            r.setGradeLevelNo(Integer.parseInt(view.getJcmbGradeLevel().getSelectedItem().toString().trim()));
            r.setLastName(view.getJtfLastName().getText().trim());
            r.setFirstName(view.getJtfFirstName().getText().trim());
            r.setMiddleName(view.getJtfMiddleName().getText().trim());
            r.setGender(view.getJcmbGender().getSelectedItem().toString().trim());
            r.setReligion(view.getJtfReligion().getText().trim());
            r.setNationality(view.getJtfNationality().getText().trim());
            r.setBirthday(dateUtil.toDate(view.getDpBirthday().getJFormattedTextField().getText().trim()));
            r.setPlaceOfBirth(view.getJtfPlaceOfBirth().getText().trim());
            r.setAddressRoomOrHouseNo(view.getJtfRoomNo().getText().trim());
            r.setAddressStreet(view.getJtfStreet().getText().trim());
            r.setAddressBrgyOrSubd(view.getJtfBrgySubd().getText().trim());
            r.setAddressCity(view.getJtfCity().getText().trim());
            r.setRegion(view.getJtfRegion().getText().trim());
            r.setSchoolYearYearFrom(SchoolYearDaoImpl.getCurrentSchoolYearFrom());
            r.setFatherFirstName(view.getJtfFatherFirstName().getText().trim());
            r.setFatherMiddleName(view.getJtfFatherFirstName().getText().trim());
            r.setFatherLastName(view.getJtfFatherLastName().getText().trim());
            r.setFatherOccupation(view.getJtfFatherOccupation().getText().trim());
            r.setFatherOfficePhoneNo(view.getJtfFatherOfficePhoneNo().getText().trim());
            r.setFatherMobileNo(view.getJtfFatherMobile().getText().trim());
            r.setIsFatherContactInCaseEmergency(view.getJcbFatherContactEmergency().isSelected());
            r.setMotherFirstName(view.getJtfMotherFirstName().getText().trim());
            r.setMotherMiddleName(view.getJtfMotherMiddleName().getText().trim());
            r.setMotherLastName(view.getJtfMotherLastName().getText().trim());
            r.setMotherOccupation(view.getJtfMotherOccupation().getText().trim());
            r.setMotherOfficePhoneNo(view.getJtfMotherOfficePhoneNo().getText().trim());
            r.setMotherMobileNo(view.getJtfMotherMobile().getText().trim());
            r.setIsMotherContactInCaseEmergency(view.getJcbMotherContactEmergency().isSelected());
            r.setGuardianFirstName(view.getJtfGuardianFirstName().getText().trim());
            r.setGuardianMiddleName(view.getJtfGuardianMiddleName().getText().trim());
            r.setGuardianLastName(view.getJtfGuardianLastName().getText().trim());
            r.setGuardianOccupation(view.getJtfGuardianOccupation().getText().trim());
            r.setGuardianMobileNo(view.getJtfGuardianMobile().getText().trim());
            r.setGuardianRelationToStudent(view.getJtfGuardianRelationship().getText().trim());
            r.setIsGuardianContactInCaseEmergency(view.getJcbGuardianContactEmergency().isSelected());
            r.setSchoolLastAttended(view.getJtfSchoolLastAttended().getText().trim());
            r.setSchoolLastAttendedAddress(view.getJtfSchoolLastAttendedAddress().getText().trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean formIsValid() {
        boolean isValid = false;
        List<Component[]> components = new ArrayList<>();
        components.add(view.getJpnlStudentInfo().getComponents());
        for (int i = 0; i < components.size(); i++) {
            for (Component c : components.get(i)) {
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
