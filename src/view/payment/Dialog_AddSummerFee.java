
package view.payment;

import controller.global.Controller_JButton_ExitJDialog;
import daoimpl.FeeDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.fee.Fee;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.subject.Subject;
import utility.initializer.Initializer;

/**
 *
 * @author Jordan
 */
public class Dialog_AddSummerFee extends javax.swing.JDialog implements Initializer{

    private final Student student;
    private final SchoolYear currentSchoolYear;
    private SubjectDaoImpl subjectDaoImpl;
    private FeeDaoImpl feeDaoImpl;
    
    public Dialog_AddSummerFee(java.awt.Frame parent, boolean modal, Student student, SchoolYear currentSchoolYear) {
        super(parent, modal);
        initComponents();
        
        this.student = student;
        this.currentSchoolYear = currentSchoolYear;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initViewComponents();
        initControllers();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
    }

    @Override
    public void initRenderers() {
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        loadSummerSubjects();
        jlblStudentNo.setText(""+student.getStudentNo());
        String studentLastName = student.getRegistration().getLastName();
        String studentFirstName = student.getRegistration().getFirstName();
        String studentMiddleName = student.getRegistration().getMiddleName();
        jlblStudentName.setText(studentLastName+", "+studentFirstName+" "+studentMiddleName);
        jlblCurrentSchoolYear.setText(currentSchoolYear.getYearFrom() +" - "+currentSchoolYear.getYearTo());
    }

    @Override
    public void initControllers() {
        jbtnCancel.addActionListener(new Controller_JButton_ExitJDialog(this));
    }

    @Override
    public void initDaoImpl() {
        subjectDaoImpl = new SubjectDaoImpl();
        feeDaoImpl = new FeeDaoImpl();
    }

    private void loadSummerSubjects(){
        DefaultTableModel tableModel = (DefaultTableModel) jtblSummerFees.getModel();
        tableModel.setRowCount(0);
        Fee fee = feeDaoImpl.getSummerFeePerSubject();
        List<Subject> subjectList = subjectDaoImpl.getSummerSubjectsOf(student, currentSchoolYear);
        for(Subject s : subjectList){
            Object feeName = fee.getName();
            Object feeAmount = fee.getAmount();
            Object feeCategory = fee.getFeeCategory().getName();
            Object[] rowData = {"Summer - "+s.getSubjectCode(),s.getSubjectTitle(),feeAmount,feeCategory};
            tableModel.addRow(rowData);
        }
        jtblSummerFees.setModel(tableModel);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlStudentDetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblStudentNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblStudentName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlblCurrentSchoolYear = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSummerFees = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel lbl_datetoday4 = new javax.swing.JLabel();
        display_lastname3 = new javax.swing.JLabel();
        javax.swing.JLabel jlblTotal = new javax.swing.JLabel();
        jlblTotalPhp = new javax.swing.JLabel();
        javax.swing.JLabel jlblReceived = new javax.swing.JLabel();
        jlblReceivedPhp = new javax.swing.JLabel();
        jtfTendered = new javax.swing.JTextField();
        jtfSubtotal = new javax.swing.JTextField();
        jtfTotal = new javax.swing.JTextField();
        javax.swing.JLabel jlblCharged = new javax.swing.JLabel();
        jlblChargedPhp = new javax.swing.JLabel();
        jtfAmountCharged = new javax.swing.JTextField();
        jpnlControl = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnAssignFees = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assign Summer Fees");
        setPreferredSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlStudentDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Details"));
        jpnlStudentDetails.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlStudentDetails.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Student No :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jLabel1, gridBagConstraints);

        jlblStudentNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblStudentNo.setText("StudentNoText");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jlblStudentNo, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jLabel3, gridBagConstraints);

        jlblStudentName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblStudentName.setText("StudentNameText");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jlblStudentName, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SY: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jLabel2, gridBagConstraints);

        jlblCurrentSchoolYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblCurrentSchoolYear.setText("SYTEXT");
        jpnlStudentDetails.add(jlblCurrentSchoolYear, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlStudentDetails, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jtblSummerFees.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblSummerFees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fee Name", "Subject Name (Summer)", "Amount", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSummerFees.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblSummerFees);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 130));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 130));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbl_datetoday4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_datetoday4.setText("Subtotal :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(lbl_datetoday4, gridBagConstraints);

        display_lastname3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        display_lastname3.setText("Php");
        display_lastname3.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname3.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname3.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(display_lastname3, gridBagConstraints);

        jlblTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblTotal.setForeground(new java.awt.Color(0, 51, 102));
        jlblTotal.setText("Total :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblTotal, gridBagConstraints);

        jlblTotalPhp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblTotalPhp.setForeground(new java.awt.Color(0, 51, 102));
        jlblTotalPhp.setText("Php");
        jlblTotalPhp.setMaximumSize(new java.awt.Dimension(30, 20));
        jlblTotalPhp.setMinimumSize(new java.awt.Dimension(30, 20));
        jlblTotalPhp.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblTotalPhp, gridBagConstraints);

        jlblReceived.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblReceived.setForeground(new java.awt.Color(0, 153, 102));
        jlblReceived.setText("Received");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblReceived, gridBagConstraints);

        jlblReceivedPhp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblReceivedPhp.setForeground(new java.awt.Color(0, 153, 102));
        jlblReceivedPhp.setText("Php");
        jlblReceivedPhp.setMaximumSize(new java.awt.Dimension(30, 20));
        jlblReceivedPhp.setMinimumSize(new java.awt.Dimension(30, 20));
        jlblReceivedPhp.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblReceivedPhp, gridBagConstraints);

        jtfTendered.setBackground(new java.awt.Color(0, 153, 102));
        jtfTendered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTendered.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfTendered.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jtfTendered, gridBagConstraints);

        jtfSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfSubtotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfSubtotal.setEnabled(false);
        jtfSubtotal.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfSubtotal.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jtfSubtotal, gridBagConstraints);

        jtfTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfTotal.setEnabled(false);
        jtfTotal.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfTotal.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jtfTotal, gridBagConstraints);

        jlblCharged.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblCharged.setForeground(new java.awt.Color(0, 153, 102));
        jlblCharged.setText("Charged :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblCharged, gridBagConstraints);

        jlblChargedPhp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblChargedPhp.setForeground(new java.awt.Color(0, 153, 102));
        jlblChargedPhp.setText("Php");
        jlblChargedPhp.setMaximumSize(new java.awt.Dimension(30, 20));
        jlblChargedPhp.setMinimumSize(new java.awt.Dimension(30, 20));
        jlblChargedPhp.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jlblChargedPhp, gridBagConstraints);

        jtfAmountCharged.setBackground(new java.awt.Color(0, 153, 102));
        jtfAmountCharged.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfAmountCharged.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfAmountCharged.setPreferredSize(new java.awt.Dimension(100, 25));
        jtfAmountCharged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAmountChargedActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jtfAmountCharged, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel2, gridBagConstraints);

        jpnlControl.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jpnlControl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlControl.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlControl.add(jbtnCancel, gridBagConstraints);

        jbtnAssignFees.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAssignFees.setText("Pay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlControl.add(jbtnAssignFees, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlControl, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAmountChargedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAmountChargedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAmountChargedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel display_lastname3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAssignFees;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JLabel jlblChargedPhp;
    private javax.swing.JLabel jlblCurrentSchoolYear;
    private javax.swing.JLabel jlblReceivedPhp;
    private javax.swing.JLabel jlblStudentName;
    private javax.swing.JLabel jlblStudentNo;
    private javax.swing.JLabel jlblTotalPhp;
    private javax.swing.JPanel jpnlControl;
    private javax.swing.JPanel jpnlStudentDetails;
    private javax.swing.JTable jtblSummerFees;
    private javax.swing.JTextField jtfAmountCharged;
    private javax.swing.JTextField jtfSubtotal;
    private javax.swing.JTextField jtfTendered;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
