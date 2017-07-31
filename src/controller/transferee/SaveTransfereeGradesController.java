/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.transferee;

import daoimpl.AdmissionDaoImpl;
import daoimpl.TransfereeGradeDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.admission.Admission;
import model.transfereegrade.TransfereeGrade;
import view.enrollment.EnrollmentPanel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SaveTransfereeGradesController implements ActionListener{

    private final JComboBox jcmbAdmissionStatus;
    private final JTextField jtfFirstQuarterGrade;
    private final JTextField jtfSecondQuarterGrade;
    private final JTextField jtfThirdQuarterGrade;
    private final JTextField jtfFourthQuarterGrade;
    private final JTextField jtfGwa;
    private final int registrationId;
    private final Admission admission;
    private final JDialog jdlgAddGrades;
    
    public SaveTransfereeGradesController(
            JTextField jtfFirstQuarterGrade, JTextField jtfSecondQuarterGrade,
            JTextField jtfThirdQuarterGrade, JTextField jtfFourthQuarterGrade, 
            JTextField jtfGwa, Admission admission,JComboBox jcmbAdmissionStatus, 
            JDialog jdlgAddGrades
    ) {
        this.jtfFirstQuarterGrade = jtfFirstQuarterGrade;
        this.jtfSecondQuarterGrade = jtfSecondQuarterGrade;
        this.jtfThirdQuarterGrade = jtfThirdQuarterGrade;
        this.jtfFourthQuarterGrade = jtfFourthQuarterGrade;
        this.jtfGwa = jtfGwa;
        this.admission = admission;
        this.jcmbAdmissionStatus = jcmbAdmissionStatus;
        this.registrationId = admission.getRegistration().getRegistrationId();
        this.jdlgAddGrades = jdlgAddGrades;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null, "Complete admission and add grades?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (completeAdmission()) {
            if(addGrades()){
                jdlgAddGrades.dispose();
            }
        }
    }
    
    private void reloadStudentsListView() {
        EnrollmentPanel.loadAllStudentsToJTable();
    }
    
    private void reloadRegisteredListView(){
        EnrollmentPanel.loadRegisteredApplicantsToJTable();
    }
    
    private boolean completeAdmission() {
        AdmissionDaoImpl admissionDaoImpl = new AdmissionDaoImpl();
        boolean isSuccessful;
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
        return isSuccessful;
    }
    
    private boolean addGrades(){
        boolean isAdded = false;
        TransfereeGradeDaoImpl transfereeGradeDaoImpl = new TransfereeGradeDaoImpl();
        
        double firstQuarterGrade = !jtfFirstQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfFirstQuarterGrade.getText().trim()) : 0.00;
        double secondQuarterGrade = !jtfSecondQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfSecondQuarterGrade.getText().trim()) : 0.00;
        double thirdQuarterGrade = !jtfThirdQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfThirdQuarterGrade.getText().trim()) : 0.00;
        double fourthQuarterGrade = !jtfFourthQuarterGrade.getText().isEmpty()? Double.parseDouble(jtfFourthQuarterGrade.getText().trim()) : 0.00;

        double sum = firstQuarterGrade + secondQuarterGrade + thirdQuarterGrade + fourthQuarterGrade;
        if(sum == 0){
            JOptionPane.showMessageDialog(null,"Please input grades.");
        }else{
            double gwa = sum / 4;
            TransfereeGrade transfereeGrade = new TransfereeGrade();
            transfereeGrade.setFirstQuarterGrade(firstQuarterGrade);
            transfereeGrade.setSecondQuarterGrade(secondQuarterGrade);
            transfereeGrade.setThirdQuarterGrade(thirdQuarterGrade);
            transfereeGrade.setFourthQuarterGrade(fourthQuarterGrade);
            transfereeGrade.setGwa(gwa);
            transfereeGrade.setRegistrationId(registrationId);
            
            System.out.println("1st: "+firstQuarterGrade);
            System.out.println("2nd: "+secondQuarterGrade);
            System.out.println("3rd: "+thirdQuarterGrade);
            System.out.println("4th: "+fourthQuarterGrade);
            System.out.println("GWA: "+gwa);
            System.out.println("RegistrationId: "+registrationId);
            
            isAdded = transfereeGradeDaoImpl.add(transfereeGrade);
            if(isAdded){
                JOptionPane.showMessageDialog(null,"Grades successfully recorded.");
            }else{
                JOptionPane.showMessageDialog(null,"Error encountered while adding grades.");
            }
        }
        return isAdded;
    }
    
}
