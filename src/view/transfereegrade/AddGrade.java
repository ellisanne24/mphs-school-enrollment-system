package view.transfereegrade;

import controller.transferee.SaveTransfereeGradesController;
import controller.transferee.TransfereeGradeFieldsController;
import daoimpl.AdmissionDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.admission.Admission;
import model.registration.Registration;
import model.schoolfees.SchoolFees;
import view.enrollment.EnrollmentPanel;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddGrade extends javax.swing.JDialog {
    
    private Admission admission;
    private final JComboBox jcmbAdmissionStatus;
    private final int registrationId;
    
    public AddGrade(java.awt.Frame parent,boolean modal,
            Admission admission,
            JComboBox jcmbAdmissionStatus) {
        super(parent, modal);
        this.admission = admission;
        this.registrationId = admission.getRegistration().getRegistrationId();
        this.jcmbAdmissionStatus = jcmbAdmissionStatus;

        initComponents();
        initializeControllers();
    }
    
    private void initializeControllers() {
        TransfereeGradeFieldsController transfereeGradeFieldsController = new TransfereeGradeFieldsController(jtfFirstQuarter, jtfSecondQuarter, jtfThirdQuarter, jtfFourthQuarter, jtfGwa, jbtnSaveGrades, registrationId);
        transfereeGradeFieldsController.control();

        jbtnSaveGrades.addActionListener(
                new SaveTransfereeGradesController(
                        jtfFirstQuarter, jtfSecondQuarter, 
                        jtfThirdQuarter, jtfFourthQuarter, jtfGwa, 
                        registrationId)
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfGwa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfFirstQuarter = new javax.swing.JTextField();
        jtfSecondQuarter = new javax.swing.JTextField();
        jtfThirdQuarter = new javax.swing.JTextField();
        jtfFourthQuarter = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jbtnSaveGrades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transferee Grades"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("GWA :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel5, gridBagConstraints);

        jtfGwa.setColumns(5);
        jtfGwa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfGwa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfGwa.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jtfGwa, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel1.setText("1st Quarter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("2nd Quarter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("3rd Quarter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("4th Quarter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel4, gridBagConstraints);

        jtfFirstQuarter.setColumns(5);
        jtfFirstQuarter.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jtfFirstQuarter, gridBagConstraints);

        jtfSecondQuarter.setColumns(5);
        jtfSecondQuarter.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfSecondQuarter.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfSecondQuarter.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jtfSecondQuarter, gridBagConstraints);

        jtfThirdQuarter.setColumns(5);
        jtfThirdQuarter.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfThirdQuarter.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfThirdQuarter.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jtfThirdQuarter, gridBagConstraints);

        jtfFourthQuarter.setColumns(5);
        jtfFourthQuarter.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfFourthQuarter.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfFourthQuarter.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jtfFourthQuarter, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setText("(press enter)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jButton1, gridBagConstraints);

        jbtnSaveGrades.setText("Save");
        jbtnSaveGrades.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jbtnSaveGrades, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reloadStudentsListView() {
        EnrollmentPanel.loadAllStudentsToJTable();
    }
    
    private void reloadRegisteredListView(){
        EnrollmentPanel.loadRegisteredApplicantsToJTable();
    }
    
    private void completeAdmission() {
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
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Cancel adding of grades? ", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            this.dispose();
        }else{
            completeAdmission();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtnSaveGrades;
    private javax.swing.JTextField jtfFirstQuarter;
    private javax.swing.JTextField jtfFourthQuarter;
    private javax.swing.JTextField jtfGwa;
    private javax.swing.JTextField jtfSecondQuarter;
    private javax.swing.JTextField jtfThirdQuarter;
    // End of variables declaration//GEN-END:variables
}
