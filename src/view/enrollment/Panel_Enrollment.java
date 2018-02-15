package view.enrollment;

import component_model_loader.EnrollmentJCompModelLoader;
import component_model_loader.GradeLevelJCompModelLoader;
import component_model_loader.RegistrationJCompModelLoader;
import component_renderers.Renderer_GradeLevel_JComboBox;
import controller.enrollment.DisplayAllEnrolledOnGradeLevelFilter;
import controller.enrollment.DisplayDialogSectionAssignment;
import controller.enrollment.RefreshEnrolledRecord;
import controller.registration.Controller_JButton_DisplayRegistrationJDialog;
import controller.registration.Controller_JComboBox_DisplayRegistrationRecordByAdmissionStatus;
import controller.registration.Controller_JButton_SearchRegistrationRecordByKeyword;
import controller.registration.Controller_JButton_RefreshRegistrationList;
import daoimpl.EnrollmentDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.user.User;
import utility.initializer.Initializer;

/**
 *
 * @author Jordan
 */
public class Panel_Enrollment extends javax.swing.JPanel implements Initializer{
    
    private final User user;
    private RegistrationJCompModelLoader registrationJCompModelLoader;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private EnrollmentDaoImpl enrollmentDaoImpl;
    private EnrollmentJCompModelLoader enrollmentJCompModelLoader;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;
            
    public Panel_Enrollment(User user) {
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
        enrollmentJCompModelLoader = new EnrollmentJCompModelLoader(enrollmentDaoImpl);
        gradeLevelJCompModelLoader = new GradeLevelJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        jcmbEnrolledFilterGradeLevel.setRenderer(new Renderer_GradeLevel_JComboBox());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        jcmbEnrolledFilterGradeLevel.setModel(gradeLevelJCompModelLoader.getAllGradeLevels());
        jlblCurrentSchoolYearRegistered.setText(""+SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        jlblCurrentSchoolYearEnrolled.setText(""+SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel = registrationJCompModelLoader.getAllRegisteredApplicants(SchoolYearDaoImpl.getCurrentSchoolYearFrom(), jtblRegisteredMasterList);
        jtblRegisteredMasterList.setModel(tableModel);
        jtblEnrolledMasterList.setModel(enrollmentJCompModelLoader.getAllEnrolledOfCurrentSchoolYear(jtblEnrolledMasterList));
    }

    @Override
    public void initControllers() {
        jbtnSectioning.addActionListener(new DisplayDialogSectionAssignment());
        jbtnRefreshEnrolledRecords.addActionListener(new RefreshEnrolledRecord(this));
        jcmbEnrolledFilterGradeLevel.addItemListener(new DisplayAllEnrolledOnGradeLevelFilter(this));
        jcmbFilterRegistered.addItemListener(new Controller_JComboBox_DisplayRegistrationRecordByAdmissionStatus(jtblRegisteredMasterList, jcmbFilterRegistered));
        jbtnEditRegistration.addActionListener(new Controller_JButton_DisplayRegistrationJDialog(jtblRegisteredMasterList, jbtnEditRegistration.getActionCommand()));
        jbtnRefreshRegistrationList.addActionListener(new Controller_JButton_RefreshRegistrationList(jtblRegisteredMasterList));
        jbtnSearchRegistered.addActionListener(new Controller_JButton_SearchRegistrationRecordByKeyword(jtfSearchRegistered, jtblRegisteredMasterList));
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        enrollmentDaoImpl = new EnrollmentDaoImpl(schoolYearDaoImpl);
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JButton getJbtnEditRegistration() {
        return jbtnEditRegistration;
    }

    public void setJbtnEditRegistration(JButton jbtnEditRegistration) {
        this.jbtnEditRegistration = jbtnEditRegistration;
    }

    public JButton getJbtnEnrolledSearch() {
        return jbtnEnrolledSearch;
    }

    public void setJbtnEnrolledSearch(JButton jbtnEnrolledSearch) {
        this.jbtnEnrolledSearch = jbtnEnrolledSearch;
    }

    public JButton getJbtnRefreshEnrolledRecords() {
        return jbtnRefreshEnrolledRecords;
    }

    public void setJbtnRefreshEnrolledRecords(JButton jbtnRefreshEnrolledRecords) {
        this.jbtnRefreshEnrolledRecords = jbtnRefreshEnrolledRecords;
    }

    public JButton getJbtnRefreshRegistrationList() {
        return jbtnRefreshRegistrationList;
    }

    public void setJbtnRefreshRegistrationList(JButton jbtnRefreshRegistrationList) {
        this.jbtnRefreshRegistrationList = jbtnRefreshRegistrationList;
    }

    public JButton getJbtnSearchRegistered() {
        return jbtnSearchRegistered;
    }

    public void setJbtnSearchRegistered(JButton jbtnSearchRegistered) {
        this.jbtnSearchRegistered = jbtnSearchRegistered;
    }

    public JButton getJbtnSectioning() {
        return jbtnSectioning;
    }

    public void setJbtnSectioning(JButton jbtnSectioning) {
        this.jbtnSectioning = jbtnSectioning;
    }

    public JButton getJbtnWithdrawEnrollment() {
        return jbtnWithdrawEnrollment;
    }

    public void setJbtnWithdrawEnrollment(JButton jbtnWithdrawEnrollment) {
        this.jbtnWithdrawEnrollment = jbtnWithdrawEnrollment;
    }

    public JComboBox<String> getJcmbEnrolledFilterGradeLevel() {
        return jcmbEnrolledFilterGradeLevel;
    }

    public void setJcmbEnrolledFilterGradeLevel(JComboBox<String> jcmbEnrolledFilterGradeLevel) {
        this.jcmbEnrolledFilterGradeLevel = jcmbEnrolledFilterGradeLevel;
    }

    public JComboBox<String> getJcmbEnrolledShowFilter() {
        return jcmbEnrolledShowFilter;
    }

    public void setJcmbEnrolledShowFilter(JComboBox<String> jcmbEnrolledShowFilter) {
        this.jcmbEnrolledShowFilter = jcmbEnrolledShowFilter;
    }

    public JComboBox<String> getJcmbFilterRegistered() {
        return jcmbFilterRegistered;
    }

    public void setJcmbFilterRegistered(JComboBox<String> jcmbFilterRegistered) {
        this.jcmbFilterRegistered = jcmbFilterRegistered;
    }

    public JLabel getJlblCurrentSchoolYearEnrolled() {
        return jlblCurrentSchoolYearEnrolled;
    }

    public void setJlblCurrentSchoolYearEnrolled(JLabel jlblCurrentSchoolYearEnrolled) {
        this.jlblCurrentSchoolYearEnrolled = jlblCurrentSchoolYearEnrolled;
    }

    public JLabel getJlblCurrentSchoolYearRegistered() {
        return jlblCurrentSchoolYearRegistered;
    }

    public void setJlblCurrentSchoolYearRegistered(JLabel jlblCurrentSchoolYearRegistered) {
        this.jlblCurrentSchoolYearRegistered = jlblCurrentSchoolYearRegistered;
    }

    public JPanel getJpnlContent() {
        return jpnlContent;
    }

    public void setJpnlContent(JPanel jpnlContent) {
        this.jpnlContent = jpnlContent;
    }

    public JPanel getJpnlEnrolled() {
        return jpnlEnrolled;
    }

    public void setJpnlEnrolled(JPanel jpnlEnrolled) {
        this.jpnlEnrolled = jpnlEnrolled;
    }

    public JPanel getJpnlRegistered() {
        return jpnlRegistered;
    }

    public void setJpnlRegistered(JPanel jpnlRegistered) {
        this.jpnlRegistered = jpnlRegistered;
    }

    public JTable getJtblEnrolledMasterList() {
        return jtblEnrolledMasterList;
    }

    public void setJtblEnrolledMasterList(JTable jtblEnrolledMasterList) {
        this.jtblEnrolledMasterList = jtblEnrolledMasterList;
    }

    public JTable getJtblRegisteredMasterList() {
        return jtblRegisteredMasterList;
    }

    public void setJtblRegisteredMasterList(JTable jtblRegisteredMasterList) {
        this.jtblRegisteredMasterList = jtblRegisteredMasterList;
    }

    public JTextField getJtfEnrolledSearchBox() {
        return jtfEnrolledSearchBox;
    }

    public void setJtfEnrolledSearchBox(JTextField jtfEnrolledSearchBox) {
        this.jtfEnrolledSearchBox = jtfEnrolledSearchBox;
    }

    public JTextField getJtfSearchRegistered() {
        return jtfSearchRegistered;
    }

    public void setJtfSearchRegistered(JTextField jtfSearchRegistered) {
        this.jtfSearchRegistered = jtfSearchRegistered;
    }

    public JTabbedPane getJtpContainer() {
        return jtpContainer;
    }

    public void setJtpContainer(JTabbedPane jtpContainer) {
        this.jtpContainer = jtpContainer;
    }

    public JLabel getLbl_show() {
        return lbl_show;
    }

    public void setLbl_show(JLabel lbl_show) {
        this.lbl_show = lbl_show;
    }

    public JLabel getLbl_show1() {
        return lbl_show1;
    }

    public void setLbl_show1(JLabel lbl_show1) {
        this.lbl_show1 = lbl_show1;
    }

    public JLabel getLbl_show2() {
        return lbl_show2;
    }

    public void setLbl_show2(JLabel lbl_show2) {
        this.lbl_show2 = lbl_show2;
    }

    public JLabel getLbl_show3() {
        return lbl_show3;
    }

    public void setLbl_show3(JLabel lbl_show3) {
        this.lbl_show3 = lbl_show3;
    }

    public JLabel getLbl_show5() {
        return lbl_show5;
    }

    public void setLbl_show5(JLabel lbl_show5) {
        this.lbl_show5 = lbl_show5;
    }

    public JPanel getPanel_control() {
        return panel_control;
    }

    public void setPanel_control(JPanel panel_control) {
        this.panel_control = panel_control;
    }

    public JPanel getPanel_control1() {
        return panel_control1;
    }

    public void setPanel_control1(JPanel panel_control1) {
        this.panel_control1 = panel_control1;
    }

    public JPanel getPanel_masterrecord() {
        return panel_masterrecord;
    }

    public void setPanel_masterrecord(JPanel panel_masterrecord) {
        this.panel_masterrecord = panel_masterrecord;
    }

    public JPanel getPanel_masterrecord1() {
        return panel_masterrecord1;
    }

    public void setPanel_masterrecord1(JPanel panel_masterrecord1) {
        this.panel_masterrecord1 = panel_masterrecord1;
    }

    public JPanel getPanel_toppanel() {
        return panel_toppanel;
    }

    public void setPanel_toppanel(JPanel panel_toppanel) {
        this.panel_toppanel = panel_toppanel;
    }

    public JPanel getPanel_toppanel1() {
        return panel_toppanel1;
    }

    public void setPanel_toppanel1(JPanel panel_toppanel1) {
        this.panel_toppanel1 = panel_toppanel1;
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
        jtfEnrolledSearchBox = new javax.swing.JTextField();
        jbtnEnrolledSearch = new javax.swing.JButton();
        lbl_show2 = new javax.swing.JLabel();
        jcmbEnrolledShowFilter = new javax.swing.JComboBox<>();
        jbtnSectioning = new javax.swing.JButton();
        lbl_show3 = new javax.swing.JLabel();
        jlblCurrentSchoolYearEnrolled = new javax.swing.JLabel();
        jbtnWithdrawEnrollment = new javax.swing.JButton();
        jbtnRefreshEnrolledRecords = new javax.swing.JButton();
        lbl_show5 = new javax.swing.JLabel();
        jcmbEnrolledFilterGradeLevel = new javax.swing.JComboBox<>();
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
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1185, 1500));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1185, 1500));

        jtblRegisteredMasterList.setAutoCreateRowSorter(true);
        jtblRegisteredMasterList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblRegisteredMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg. ID", "Last Name", "First Name", "Middle Name", "Registered Grade Level", "Registration Date", "Admission Status", "Student No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegisteredMasterList.setMinimumSize(new java.awt.Dimension(1185, 3000));
        jtblRegisteredMasterList.setPreferredSize(new java.awt.Dimension(1185, 3000));
        jtblRegisteredMasterList.setRowHeight(35);
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

        jtfEnrolledSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfEnrolledSearchBox.setMinimumSize(new java.awt.Dimension(150, 30));
        jtfEnrolledSearchBox.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jtfEnrolledSearchBox, gridBagConstraints);

        jbtnEnrolledSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEnrolledSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jbtnEnrolledSearch, gridBagConstraints);

        lbl_show2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show2.setText("Show :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(lbl_show2, gridBagConstraints);

        jcmbEnrolledShowFilter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbEnrolledShowFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sectioned", "No Section" }));
        jcmbEnrolledShowFilter.setSelectedIndex(-1);
        jcmbEnrolledShowFilter.setMinimumSize(new java.awt.Dimension(100, 30));
        jcmbEnrolledShowFilter.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jcmbEnrolledShowFilter, gridBagConstraints);

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

        jcmbEnrolledFilterGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbEnrolledFilterGradeLevel.setMinimumSize(new java.awt.Dimension(70, 30));
        jcmbEnrolledFilterGradeLevel.setPreferredSize(new java.awt.Dimension(70, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control1.add(jcmbEnrolledFilterGradeLevel, gridBagConstraints);

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
        jScrollPane2.setMinimumSize(new java.awt.Dimension(1185, 800));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1185, 800));

        jtblEnrolledMasterList.setAutoCreateRowSorter(true);
        jtblEnrolledMasterList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblEnrolledMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student No", "Student Name", "Student Type", "Grade Level", "Section", "Adviser", "Status", "Date Enrolled", "Enrollment Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblEnrolledMasterList.setMinimumSize(new java.awt.Dimension(1185, 1500));
        jtblEnrolledMasterList.setPreferredSize(new java.awt.Dimension(1185, 1500));
        jtblEnrolledMasterList.setRowHeight(35);
        jtblEnrolledMasterList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblEnrolledMasterList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_masterrecord1.add(jScrollPane2, gridBagConstraints);

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnEditRegistration;
    private javax.swing.JButton jbtnEnrolledSearch;
    private javax.swing.JButton jbtnRefreshEnrolledRecords;
    private javax.swing.JButton jbtnRefreshRegistrationList;
    private javax.swing.JButton jbtnSearchRegistered;
    private javax.swing.JButton jbtnSectioning;
    private javax.swing.JButton jbtnWithdrawEnrollment;
    private javax.swing.JComboBox<String> jcmbEnrolledFilterGradeLevel;
    private javax.swing.JComboBox<String> jcmbEnrolledShowFilter;
    private javax.swing.JComboBox<String> jcmbFilterRegistered;
    private javax.swing.JLabel jlblCurrentSchoolYearEnrolled;
    private javax.swing.JLabel jlblCurrentSchoolYearRegistered;
    private javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlEnrolled;
    private javax.swing.JPanel jpnlRegistered;
    private javax.swing.JTable jtblEnrolledMasterList;
    private javax.swing.JTable jtblRegisteredMasterList;
    private javax.swing.JTextField jtfEnrolledSearchBox;
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