/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registration;

import daoimpl.AdmissionDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.admission.Admission;
import model.registration.Registration;
import model.schoolfees.SchoolFees;
import view.enrollment.EnrollmentPanel;
import view.transfereegrade.AddGrade;

/**
 *
 * @author John Ferdinand Antonio
 */
public class CompleteAdmissionController implements ActionListener{

    private final int registrationId;
    private final JComboBox jcmbAdmissionStatus;
    private final JCheckBox jcbTransferee;
    private final JComboBox jcmbGradeLevel;
    
    public CompleteAdmissionController(int registrationId, JComboBox jcmbAdmissionStatus,JCheckBox jcbTransferee, JComboBox jcmbGradeLevel){
        this.registrationId = registrationId;
        this.jcmbAdmissionStatus = jcmbAdmissionStatus;
        this.jcbTransferee = jcbTransferee;
        this.jcmbGradeLevel = jcmbGradeLevel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean transferee = jcbTransferee.isSelected();
        int gradeLevel = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        boolean gradeSchool = (gradeLevel <= 6);

        int choice = JOptionPane.showConfirmDialog(null, "Complete Admission?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (transferee) {
                inputPreviousSchoolGrades();
//                completeAdmission();
            } 
//            else if (gradeSchool) {
//                completeAdmission();
//            } 
            else {
                inputEntranceExamGrade();
                completeAdmission();
            }
        }
    }
    
    private void completeAdmission() {
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        AdmissionDaoImpl admissionDaoImpl = new AdmissionDaoImpl();
        
        boolean isSuccessful;
        Registration registration = new Registration();
        registration.setRegistrationId(registrationId);
        registration.setStudentType(jcbTransferee.isSelected()==true?"Transferee":"New");
        
        GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
        int gradeLevel = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
        int gradeLevelId = gradeLevelDaoImpl.getId(gradeLevel);
        
        SchoolFeesDaoImpl schoolFeesDaoImpl = new SchoolFeesDaoImpl();
        SchoolFees schoolFees = schoolFeesDaoImpl.get(gradeLevelId);
        
        Admission admission = new Admission();
        admission.setRegistration(registration);
        admission.setSchoolFees(schoolFees);
        admission.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());
        
        isSuccessful = admissionDaoImpl.completeAdmission(admission);
        if (isSuccessful) {
            JOptionPane.showMessageDialog(null, "Applicant officially admitted. ");
            jcmbAdmissionStatus.setSelectedItem("Completed");
            jcmbAdmissionStatus.setEnabled(false);
            reloadRegisteredListView();
            reloadStudentsListView();
        } else {
            JOptionPane.showMessageDialog(null, "Error encountered. Failed to complete admission process.\nContact your administrator.");
        }
    }
    
    private void reloadStudentsListView() {
        EnrollmentPanel.loadAllStudentsToJTable();
    }
    
    private void reloadRegisteredListView(){
        EnrollmentPanel.loadRegisteredApplicantsToJTable();
    }
    
    private void inputPreviousSchoolGrades() {
        boolean transferee = jcbTransferee.isSelected();
        if (transferee) {
            SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
            AdmissionDaoImpl admissionDaoImpl = new AdmissionDaoImpl();

            Registration registration = new Registration();
            registration.setRegistrationId(registrationId);
            registration.setStudentType(jcbTransferee.isSelected() == true ? "Transferee" : "New");

            GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
            int gradeLevel = Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim());
            int gradeLevelId = gradeLevelDaoImpl.getId(gradeLevel);

            SchoolFeesDaoImpl schoolFeesDaoImpl = new SchoolFeesDaoImpl();
            SchoolFees schoolFees = schoolFeesDaoImpl.get(gradeLevelId);

            Admission admission = new Admission();
            admission.setRegistration(registration);
            admission.setSchoolFees(schoolFees);
            admission.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());

            AddGrade addGrade = new AddGrade(null, true, admission,jcmbAdmissionStatus);
            addGrade.setPreferredSize(new Dimension(650, 250));
            addGrade.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            addGrade.pack();
            addGrade.setLocationRelativeTo(null);
            addGrade.setVisible(true);

        } else {

        }
    }
    
    private void inputEntranceExamGrade(){
        
    }
}
