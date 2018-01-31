package view.enrollment;

import component_model_loader.RegistrationJCompModelLoader;
import controller.registration.DisplayRegistrationJDialog;
import controller.registration.DisplayRegistrationRecordByAdmissionStatus;
import controller.registration.DisplayRegistrationRecordByWildCard;
import controller.registration.RefreshRegistrationList;
import daoimpl.SchoolYearDaoImpl;
import javax.swing.table.DefaultTableModel;
import model.user.User;
import utility.initializer.Initializer;

/**
 *
 * @author Jordan
 */
public class EnrollmentPanel extends javax.swing.JPanel implements Initializer{
    
    private final User user;
    private RegistrationJCompModelLoader registrationJCompModelLoader;
    
    public EnrollmentPanel(User user) {
        initComponents();
        this.user = user;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        registrationJCompModelLoader = new RegistrationJCompModelLoader();
    }

    @Override
    public void initRenderers() {
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        jlblCurrentSchoolYearRegistered.setText(""+SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        jlblCurrentSchoolYearEnrolled.setText(""+SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel = registrationJCompModelLoader.getAllRegisteredApplicants(SchoolYearDaoImpl.getCurrentSchoolYearFrom(), jtblRegisteredMasterList);
        jtblRegisteredMasterList.setModel(tableModel);
    }

    @Override
    public void initControllers() {
        jcmbFilterRegistered.addItemListener(new DisplayRegistrationRecordByAdmissionStatus(jtblRegisteredMasterList, jcmbFilterRegistered));
        jbtnEditRegistration.addActionListener(new DisplayRegistrationJDialog(jtblRegisteredMasterList, jbtnEditRegistration.getActionCommand()));
        jbtnRefreshRegistrationList.addActionListener(new RefreshRegistrationList(jtblRegisteredMasterList));
        jbtnSearchRegistered.addActionListener(new DisplayRegistrationRecordByWildCard(jtfSearchRegistered, jtblRegisteredMasterList));
    }

    @Override
    public void initDaoImpl() {
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jpnlContent = new javax.swing.JPanel();
        jtpContainer = new javax.swing.JTabbedPane();
        jpnlRegistered = new javax.swing.JPanel();
        panel_toppanel = new javax.swing.JPanel();
        panel_control = new javax.swing.JPanel();
        jtfSearchRegistered = new javax.swing.JTextField();
        jbtnSearchRegistered = new javax.swing.JButton();
        lbl_show = new javax.swing.JLabel();
        jcmbFilterRegistered = new javax.swing.JComboBox<>();
        jbtnRefreshRegistrationList = new javax.swing.JButton();
        lbl_show1 = new javax.swing.JLabel();
        jlblCurrentSchoolYearRegistered = new javax.swing.JLabel();
        jbtnEditRegistration = new javax.swing.JButton();
        panel_masterrecord = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegisteredMasterList = new javax.swing.JTable();
        jpnlEnrolled = new javax.swing.JPanel();
        panel_toppanel1 = new javax.swing.JPanel();
        panel_control1 = new javax.swing.JPanel();
        Searchbox = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        lbl_show2 = new javax.swing.JLabel();
        combo_filter = new javax.swing.JComboBox<>();
        jbtnSectioning = new javax.swing.JButton();
        lbl_show3 = new javax.swing.JLabel();
        jlblCurrentSchoolYearEnrolled = new javax.swing.JLabel();
        jbtnWithdrawEnrollment = new javax.swing.JButton();
        jbtnRefreshEnrolledRecords = new javax.swing.JButton();
        lbl_show5 = new javax.swing.JLabel();
        combo_filter1 = new javax.swing.JComboBox<>();
        panel_masterrecord1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblEnrolledMasterList = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpnlContent.setLayout(new java.awt.GridBagLayout());

        jpnlRegistered.setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_control.setMinimumSize(new java.awt.Dimension(1200, 40));
        panel_control.setPreferredSize(new java.awt.Dimension(1200, 40));
        panel_control.setLayout(new java.awt.GridBagLayout());

        jtfSearchRegistered.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfSearchRegistered.setMinimumSize(new java.awt.Dimension(200, 30));
        jtfSearchRegistered.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jtfSearchRegistered, gridBagConstraints);

        jbtnSearchRegistered.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearchRegistered.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnSearchRegistered, gridBagConstraints);

        lbl_show.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show.setText("Show :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(lbl_show, gridBagConstraints);

        jcmbFilterRegistered.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbFilterRegistered.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Pending", "Complete" }));
        jcmbFilterRegistered.setMinimumSize(new java.awt.Dimension(100, 30));
        jcmbFilterRegistered.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jcmbFilterRegistered, gridBagConstraints);

        jbtnRefreshRegistrationList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRefreshRegistrationList.setText("Refresh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnRefreshRegistrationList, gridBagConstraints);

        lbl_show1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_show1.setText("Registered Students for SY :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(lbl_show1, gridBagConstraints);

        jlblCurrentSchoolYearRegistered.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblCurrentSchoolYearRegistered.setText("Sytext");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jlblCurrentSchoolYearRegistered, gridBagConstraints);

        jbtnEditRegistration.setText("Edit Registration");
        jbtnEditRegistration.setActionCommand("editregistration");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnEditRegistration, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_control, gridBagConstraints);

        panel_masterrecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registered Students List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_masterrecord.setMinimumSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setPreferredSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1185, 530));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1185, 530));

        jtblRegisteredMasterList.setAutoCreateRowSorter(true);
        jtblRegisteredMasterList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblRegisteredMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg. ID", "Last Name", "First Name", "Middle Name", "Registered Grade Level", "Registration Date", "Admission Status", "Downpayment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegisteredMasterList.setMinimumSize(new java.awt.Dimension(1185, 530));
        jtblRegisteredMasterList.setPreferredSize(new java.awt.Dimension(1185, 530));
        jtblRegisteredMasterList.setRowHeight(20);
        jtblRegisteredMasterList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblRegisteredMasterList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_masterrecord.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_masterrecord, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlRegistered.add(panel_toppanel, gridBagConstraints);

        jtpContainer.addTab("Registered", jpnlRegistered);

        jpnlEnrolled.setLayout(new java.awt.GridBagLayout());

        panel_toppanel1.setMinimumSize(new java.awt.Dimension(1200, 600));
        panel_toppanel1.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel_toppanel1.setLayout(new java.awt.GridBagLayout());

        panel_control1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_control1.setMinimumSize(new java.awt.Dimension(1200, 40));
        panel_control1.setPreferredSize(new java.awt.Dimension(1200, 40));
        panel_control1.setLayout(new java.awt.GridBagLayout());

        Searchbox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        Searchbox.setMinimumSize(new java.awt.Dimension(150, 30));
        Searchbox.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(Searchbox, gridBagConstraints);

        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(btn_Search, gridBagConstraints);

        lbl_show2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show2.setText("Show :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(lbl_show2, gridBagConstraints);

        combo_filter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Sectioned", "No Section", "Kindergarten", " ", " ", " " }));
        combo_filter.setMinimumSize(new java.awt.Dimension(100, 30));
        combo_filter.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(combo_filter, gridBagConstraints);

        jbtnSectioning.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSectioning.setText("Sectioning");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jbtnSectioning, gridBagConstraints);

        lbl_show3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_show3.setText("Enrolled Students for SY :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(lbl_show3, gridBagConstraints);

        jlblCurrentSchoolYearEnrolled.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblCurrentSchoolYearEnrolled.setText("Sytext");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jlblCurrentSchoolYearEnrolled, gridBagConstraints);

        jbtnWithdrawEnrollment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnWithdrawEnrollment.setText("Withdraw");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jbtnWithdrawEnrollment, gridBagConstraints);

        jbtnRefreshEnrolledRecords.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRefreshEnrolledRecords.setText("Refresh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jbtnRefreshEnrolledRecords, gridBagConstraints);

        lbl_show5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show5.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(lbl_show5, gridBagConstraints);

        combo_filter1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_filter1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Kinder", "1", "2", "3", "4", "5", "6", "8", "9", "10", " ", " " }));
        combo_filter1.setMinimumSize(new java.awt.Dimension(70, 30));
        combo_filter1.setPreferredSize(new java.awt.Dimension(70, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(combo_filter1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel1.add(panel_control1, gridBagConstraints);

        panel_masterrecord1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students Master List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_masterrecord1.setMinimumSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord1.setPreferredSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord1.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setMinimumSize(new java.awt.Dimension(1185, 530));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1185, 530));

        jtblEnrolledMasterList.setAutoCreateRowSorter(true);
        jtblEnrolledMasterList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblEnrolledMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Last Name", "First Name", "Middle Name", "Type", "Grade Level", "Section", "Adviser", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblEnrolledMasterList.setMinimumSize(new java.awt.Dimension(1185, 530));
        jtblEnrolledMasterList.setPreferredSize(new java.awt.Dimension(1185, 530));
        jtblEnrolledMasterList.setRowHeight(20);
        jtblEnrolledMasterList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblEnrolledMasterList);

        panel_masterrecord1.add(jScrollPane2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel1.add(panel_masterrecord1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolled.add(panel_toppanel1, gridBagConstraints);

        jtpContainer.addTab("Enrolled", jpnlEnrolled);

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
        jPanel1.add(jpnlContent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Searchbox;
    private javax.swing.JButton btn_Search;
    private javax.swing.JComboBox<String> combo_filter;
    private javax.swing.JComboBox<String> combo_filter1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnEditRegistration;
    private javax.swing.JButton jbtnRefreshEnrolledRecords;
    private javax.swing.JButton jbtnRefreshRegistrationList;
    private javax.swing.JButton jbtnSearchRegistered;
    private javax.swing.JButton jbtnSectioning;
    private javax.swing.JButton jbtnWithdrawEnrollment;
    private javax.swing.JComboBox<String> jcmbFilterRegistered;
    private javax.swing.JLabel jlblCurrentSchoolYearEnrolled;
    private javax.swing.JLabel jlblCurrentSchoolYearRegistered;
    private javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlEnrolled;
    private javax.swing.JPanel jpnlRegistered;
    private javax.swing.JTable jtblEnrolledMasterList;
    private javax.swing.JTable jtblRegisteredMasterList;
    private javax.swing.JTextField jtfSearchRegistered;
    private javax.swing.JTabbedPane jtpContainer;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JLabel lbl_show1;
    private javax.swing.JLabel lbl_show2;
    private javax.swing.JLabel lbl_show3;
    private javax.swing.JLabel lbl_show5;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_control1;
    private javax.swing.JPanel panel_masterrecord;
    private javax.swing.JPanel panel_masterrecord1;
    private javax.swing.JPanel panel_toppanel;
    private javax.swing.JPanel panel_toppanel1;
    // End of variables declaration//GEN-END:variables
}
