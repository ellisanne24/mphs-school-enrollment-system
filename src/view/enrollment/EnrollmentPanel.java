package view.enrollment;

import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import component_model_loader.NavigationImpl;
import component_model_loader.RegistrationML;
import component_model_loader.StudentML;
import constants.DashboardMenuItem;
import controller.enrollment.DisplayRegistrationInformation;
import controller.enrollment.DisplayTablePopupMenu;
import controller.enrollment.FilterStudentRecordBtStatus;
import controller.navigation.UINavigationExit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.schoolyear.SchoolYear;
import utility.component.JInternalFrameUtil;
import view.templates.JDialogWithPrintOption;

/**
 *
 * @author Jordan
 */
public class EnrollmentPanel extends javax.swing.JPanel {
    
    private static RegistrationML registrationML;
    private static StudentML studentML;
    private static StudentDaoImpl studentDaoImpl;
    private static SchoolYearDaoImpl schoolYearDaoImpl ;
    private NavigationImpl navigationDaoImpl;
    
    public EnrollmentPanel() {
        initComponents();
        initializeComponents();
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        initializeModels();
        initializeDaoImpl();
        initializeControllers();
        
        loadActiveStudentsToJTable();
        loadRegisteredApplicantsToJTable();
        jtblRegistrationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtblStudentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void initializeComponents(){
        jtblRegistrationList.setRowHeight(30);
        jtblStudentsList.setRowHeight(30);
        jtpContainer.addTab("Promoted", new Promoted());
        jtpContainer.addTab("Promotion", new Promotion());
    }

    private void initializeDaoImpl(){
        studentDaoImpl  = new StudentDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        navigationDaoImpl = new NavigationImpl();
    }
    
    private void initializeControllers(){
        jmiExit.addActionListener(new UINavigationExit(this,DashboardMenuItem.ENROLLMENT));
        jtblStudentsList.addMouseListener(new DisplayTablePopupMenu(jtblStudentsList));
        jtblRegistrationList.addMouseListener(new DisplayRegistrationInformation(jtblRegistrationList));
        jcmbStatus.addActionListener(new FilterStudentRecordBtStatus(jtblStudentsList, jcmbStatus));
    }
    
    private void initializeModels(){
        studentML = new StudentML();
        registrationML = new RegistrationML();
    }
    
    private void initializeRenderers(){
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlContent = new javax.swing.JPanel();
        jtpContainer = new javax.swing.JTabbedPane();
        jpnlRegistered = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblSearch = new javax.swing.JLabel();
        jtfSearchRegistered = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistrationList = new javax.swing.JTable();
        jpnlStudents = new javax.swing.JPanel();
        jpnlStudentsFilter = new javax.swing.JPanel();
        jlblSearch1 = new javax.swing.JLabel();
        jtfSearchStudents = new javax.swing.JTextField();
        jlblStatus = new javax.swing.JLabel();
        jcmbStatus = new javax.swing.JComboBox<>();
        jspStudents = new javax.swing.JScrollPane();
        jtblStudentsList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiExitEnrollment = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlContent.setLayout(new java.awt.GridBagLayout());

        jpnlRegistered.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jlblSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblSearch.setText("Search Applicant");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jlblSearch, gridBagConstraints);

        jtfSearchRegistered.setColumns(12);
        jtfSearchRegistered.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearchRegistered.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchRegisteredKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jtfSearchRegistered, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRegistered.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRegistered.add(jPanel3, gridBagConstraints);

        jPanel4.setPreferredSize(new java.awt.Dimension(550, 410));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jtblRegistrationList.setAutoCreateRowSorter(true);
        jtblRegistrationList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registration ID", "Last Name", "First Name", "Middle Name", "Registered Grade Level", "School Year", "Registration Date", "Admission Status", "Downpayment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegistrationList.getTableHeader().setReorderingAllowed(false);
        jtblRegistrationList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRegistrationListMouseClicked(evt);
            }
        });
        jtblRegistrationList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblRegistrationListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRegistrationList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        jScrollPane2.setViewportView(jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRegistered.add(jScrollPane2, gridBagConstraints);

        jtpContainer.addTab("Registered", jpnlRegistered);

        jpnlStudents.setLayout(new java.awt.GridBagLayout());

        jpnlStudentsFilter.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        jpnlStudentsFilter.setLayout(new java.awt.GridBagLayout());

        jlblSearch1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblSearch1.setText("Search Student");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentsFilter.add(jlblSearch1, gridBagConstraints);

        jtfSearchStudents.setColumns(12);
        jtfSearchStudents.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearchStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchStudentsActionPerformed(evt);
            }
        });
        jtfSearchStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchStudentsKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentsFilter.add(jtfSearchStudents, gridBagConstraints);

        jlblStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlblStatus.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentsFilter.add(jlblStatus, gridBagConstraints);

        jcmbStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jcmbStatus.setSelectedIndex(-1);
        jcmbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbStatusItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentsFilter.add(jcmbStatus, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudents.add(jpnlStudentsFilter, gridBagConstraints);

        jspStudents.setBorder(javax.swing.BorderFactory.createTitledBorder("Student List"));
        jspStudents.setPreferredSize(new java.awt.Dimension(550, 402));

        jtblStudentsList.setAutoCreateRowSorter(true);
        jtblStudentsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "School Year", "Student Type", "Last Name", "First Name", "Middle Name", "Status", "Graduated", "Grade Level Last Taken", "School Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblStudentsList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtblStudentsList.getTableHeader().setReorderingAllowed(false);
        jtblStudentsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblStudentsListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblStudentsListMousePressed(evt);
            }
        });
        jspStudents.setViewportView(jtblStudentsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudents.add(jspStudents, gridBagConstraints);

        jtpContainer.addTab("Students", jpnlStudents);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlContent.add(jtpContainer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jpnlContent, gridBagConstraints);

        jmiExitEnrollment.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jmiExitEnrollment.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Edit");
        jmiExitEnrollment.add(jMenuItem2);

        jmiExit.setText("Exit");
        jmiExitEnrollment.add(jmiExit);

        jMenuBar1.add(jmiExitEnrollment);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel5.add(jInternalFrame1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel1.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public static void loadRegisteredApplicantsToJTable(){
        DefaultTableModel dtm = registrationML.getAllRegisteredApplicants(jtblRegistrationList);
        jtblRegistrationList.setModel(dtm);
    }
    
    private void jtfSearchRegisteredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchRegisteredKeyPressed
        if ((!jtfSearchRegistered.getText().isEmpty()) && (evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            DefaultTableModel dtm = registrationML.getAllRegisteredApplicantsByKeyword(jtblRegistrationList, jtfSearchRegistered.getText());
            jtblRegistrationList.setModel(dtm);
        }else{
            DefaultTableModel dtm = registrationML.getAllRegisteredApplicants(jtblRegistrationList);
            jtblRegistrationList.setModel(dtm);
        }
    }//GEN-LAST:event_jtfSearchRegisteredKeyPressed

    private void jtblRegistrationListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRegistrationListMouseClicked
        
    }//GEN-LAST:event_jtblRegistrationListMouseClicked

    private void jtblRegistrationListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblRegistrationListKeyPressed
    }//GEN-LAST:event_jtblRegistrationListKeyPressed

    private void jtfSearchStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchStudentsActionPerformed

    }//GEN-LAST:event_jtfSearchStudentsActionPerformed

    public static void loadAllStudentsToJTable(){
        int currentSchoolYearFrom = SchoolYearDaoImpl.getCurrentSchoolYearFrom();
        int aSchoolYearId = schoolYearDaoImpl.getId(currentSchoolYearFrom);
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setSchoolYearId(aSchoolYearId);

        DefaultTableModel model = studentML.getAllStudents(jtblStudentsList);
        
        if(model.getRowCount() > 0){
           jtblStudentsList.setModel(studentML.getAllStudents(jtblStudentsList));
        }
    }
    
    private void loadActiveStudentsToJTable(){
        DefaultTableModel dtm = studentML.getAllActiveStudentsOfCurrentSchoolYear(jtblStudentsList);
            jtblStudentsList.setModel(dtm);
    }
    
    private void jtfSearchStudentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchStudentsKeyPressed
        if(!jtfSearchStudents.getText().isEmpty() && evt.getKeyCode() == KeyEvent.VK_ENTER){
            DefaultTableModel dtm = studentML.getAllStudentByKeyword(jtblStudentsList, jtfSearchStudents.getText());
            jtblStudentsList.setModel(dtm);
        }else if(jtfSearchStudents.getText().isEmpty()){
            loadAllStudentsToJTable();
        }
    }//GEN-LAST:event_jtfSearchStudentsKeyPressed

    private void jcmbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbStatusItemStateChanged
       
    }//GEN-LAST:event_jcmbStatusItemStateChanged

    private void jtblStudentsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblStudentsListMouseClicked
        
    }//GEN-LAST:event_jtblStudentsListMouseClicked
    
    private void jtblStudentsListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblStudentsListMousePressed
    }//GEN-LAST:event_jtblStudentsListMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcmbStatus;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblSearch1;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenu jmiExitEnrollment;
    private javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlRegistered;
    private javax.swing.JPanel jpnlStudents;
    private javax.swing.JPanel jpnlStudentsFilter;
    private javax.swing.JScrollPane jspStudents;
    private static javax.swing.JTable jtblRegistrationList;
    public static javax.swing.JTable jtblStudentsList;
    private javax.swing.JTextField jtfSearchRegistered;
    private javax.swing.JTextField jtfSearchStudents;
    private javax.swing.JTabbedPane jtpContainer;
    // End of variables declaration//GEN-END:variables
}
