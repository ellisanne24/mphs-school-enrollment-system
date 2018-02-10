
package view.container;


import daoimpl.CredentialDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import component_model_loader.CredentialJCompModelLoader;
import constants.DashboardMenuItem;
import utility.component.JPanelUtil;
import controller.navigation.UINavigationExit;
import controller.settings.AddSettingsPanelToTabbedPaneOnMouseClick;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.credential.Credential;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import utility.component.JInternalFrameUtil;
import utility.initializer.Initializer;


public class SettingsPanel extends javax.swing.JPanel implements Initializer{

    private final CredentialDaoImpl credentialDaoImpl = new CredentialDaoImpl();
    private final GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
    private final SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
    private final CredentialJCompModelLoader credentialGUIUtil = new CredentialJCompModelLoader();
    
    public SettingsPanel() {
        initComponents();

        initRenderers();
        initViewComponents();
        initControllers();
        setCredentialsJList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlContent = new javax.swing.JPanel();
        jtpManagementTabbedPane = new javax.swing.JTabbedPane();
        jspSubjectMgmt = new javax.swing.JScrollPane();
        jpnlSubjectMgmt = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jspSubjectCatMgmt = new javax.swing.JScrollPane();
        jpnlSubjectCatMgmt = new javax.swing.JPanel();
        jspCurriculumMgmt = new javax.swing.JScrollPane();
        jpnlCurriculumMgmt = new javax.swing.JPanel();
        jspFacultyMgmt = new javax.swing.JScrollPane();
        jpnlFacultyMgmt = new javax.swing.JPanel();
        jspSectionMgmt = new javax.swing.JScrollPane();
        jpnlSectionMgmt = new javax.swing.JPanel();
        jspRoomMgmt = new javax.swing.JScrollPane();
        jpnlRoomMgmt = new javax.swing.JPanel();
        jspScheduleMgmt = new javax.swing.JScrollPane();
        jpnlScheduleMgmt = new javax.swing.JPanel();
        jpnlFeesMgmt = new javax.swing.JPanel();
        jspCredentialRequirementsManagement = new javax.swing.JScrollPane();
        jpnlCredentialsMgmt = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jpnlCreateCredential = new javax.swing.JPanel();
        jlblCredentialName = new javax.swing.JLabel();
        jtfCredentialName = new javax.swing.JTextField();
        jpnlCreateNewCredentialDescription = new javax.swing.JPanel();
        jspCredentialDescription = new javax.swing.JScrollPane();
        jtaCredentialDescription = new javax.swing.JTextArea();
        jlblGradeLevel = new javax.swing.JLabel();
        jpnlGradeLevelSelection = new javax.swing.JPanel();
        jcbKindergarten = new javax.swing.JCheckBox();
        jcbGradeOne = new javax.swing.JCheckBox();
        jcbGradeTwo = new javax.swing.JCheckBox();
        jcbGradeThree = new javax.swing.JCheckBox();
        jcbGradeFour = new javax.swing.JCheckBox();
        jcbGradeFive = new javax.swing.JCheckBox();
        jcbGradeSix = new javax.swing.JCheckBox();
        jcbGradeSeven = new javax.swing.JCheckBox();
        jcbGradeEight = new javax.swing.JCheckBox();
        jcbGradeNine = new javax.swing.JCheckBox();
        jcbGradeTen = new javax.swing.JCheckBox();
        jcbKindergartenCtg = new javax.swing.JCheckBox();
        jcbElementaryCtg = new javax.swing.JCheckBox();
        jcbJuniorHighCtg = new javax.swing.JCheckBox();
        jpnlCreateCredentialControls = new javax.swing.JPanel();
        jbtnClear = new javax.swing.JButton();
        jbtnCreateCredential = new javax.swing.JButton();
        jspCredentialsList = new javax.swing.JScrollPane();
        jlstCredentialNamesList = new javax.swing.JList<>();
        jpnlSortCredentialList = new javax.swing.JPanel();
        jlblYearCreated = new javax.swing.JLabel();
        jcmbYearCreated = new javax.swing.JComboBox<>();
        jpnlDeleteCredential = new javax.swing.JPanel();
        jbtnDeleteCredential = new javax.swing.JButton();
        jspPaymentScheduleMgmt = new javax.swing.JScrollPane();
        jpnlPaymentScheduleMgmt = new javax.swing.JPanel();
        jpnlDiscountsMgmt = new javax.swing.JPanel();
        jspLanMgmt = new javax.swing.JScrollPane();
        jpnlLanMgmt = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jspSchoolYearMgmt = new javax.swing.JScrollPane();
        jpnlSchoolYearMgmt = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnFile = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlContent.setLayout(new java.awt.GridBagLayout());

        jtpManagementTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpnlSubjectMgmt.setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());
        jpnlSubjectMgmt.add(jPanel7, new java.awt.GridBagConstraints());

        jspSubjectMgmt.setViewportView(jpnlSubjectMgmt);

        jtpManagementTabbedPane.addTab("Subjects", jspSubjectMgmt);

        jpnlSubjectCatMgmt.setLayout(new java.awt.BorderLayout());
        jspSubjectCatMgmt.setViewportView(jpnlSubjectCatMgmt);

        jtpManagementTabbedPane.addTab("Subject Category", jspSubjectCatMgmt);

        jpnlCurriculumMgmt.setLayout(new java.awt.BorderLayout());
        jspCurriculumMgmt.setViewportView(jpnlCurriculumMgmt);

        jtpManagementTabbedPane.addTab("Curriculum", jspCurriculumMgmt);

        jpnlFacultyMgmt.setLayout(new java.awt.BorderLayout());
        jspFacultyMgmt.setViewportView(jpnlFacultyMgmt);

        jtpManagementTabbedPane.addTab("Faculty", jspFacultyMgmt);

        jpnlSectionMgmt.setLayout(new java.awt.BorderLayout());
        jspSectionMgmt.setViewportView(jpnlSectionMgmt);

        jtpManagementTabbedPane.addTab("Section", jspSectionMgmt);

        jpnlRoomMgmt.setLayout(new java.awt.BorderLayout());
        jspRoomMgmt.setViewportView(jpnlRoomMgmt);

        jtpManagementTabbedPane.addTab("Room", jspRoomMgmt);

        jpnlScheduleMgmt.setLayout(new java.awt.BorderLayout());
        jspScheduleMgmt.setViewportView(jpnlScheduleMgmt);

        jtpManagementTabbedPane.addTab("Schedule", jspScheduleMgmt);

        jpnlFeesMgmt.setLayout(new java.awt.BorderLayout());
        jtpManagementTabbedPane.addTab("Fees", jpnlFeesMgmt);

        jpnlCredentialsMgmt.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jpnlCreateCredential.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Credential"));
        jpnlCreateCredential.setLayout(new java.awt.GridBagLayout());

        jlblCredentialName.setText("Credential Title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jlblCredentialName, gridBagConstraints);

        jtfCredentialName.setColumns(10);
        jtfCredentialName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCredentialNameKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jtfCredentialName, gridBagConstraints);

        jpnlCreateNewCredentialDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Credential Description"));
        jpnlCreateNewCredentialDescription.setLayout(new java.awt.GridBagLayout());

        jtaCredentialDescription.setColumns(20);
        jtaCredentialDescription.setRows(5);
        jspCredentialDescription.setViewportView(jtaCredentialDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateNewCredentialDescription.add(jspCredentialDescription, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jpnlCreateNewCredentialDescription, gridBagConstraints);

        jlblGradeLevel.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jlblGradeLevel, gridBagConstraints);

        jpnlGradeLevelSelection.setLayout(new java.awt.GridBagLayout());

        jcbKindergarten.setText("Kindergarten");
        jcbKindergarten.setEnabled(false);
        jpnlGradeLevelSelection.add(jcbKindergarten, new java.awt.GridBagConstraints());

        jcbGradeOne.setText("Grade 1");
        jcbGradeOne.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeOne, gridBagConstraints);

        jcbGradeTwo.setText("Grade 2");
        jcbGradeTwo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeTwo, gridBagConstraints);

        jcbGradeThree.setText("Grade 3");
        jcbGradeThree.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeThree, gridBagConstraints);

        jcbGradeFour.setText("Grade 4");
        jcbGradeFour.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeFour, gridBagConstraints);

        jcbGradeFive.setText("Grade 5");
        jcbGradeFive.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeFive, gridBagConstraints);

        jcbGradeSix.setText("Grade 6");
        jcbGradeSix.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeSix, gridBagConstraints);

        jcbGradeSeven.setText("Grade 7");
        jcbGradeSeven.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeSeven, gridBagConstraints);

        jcbGradeEight.setText("Grade 8");
        jcbGradeEight.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeEight, gridBagConstraints);

        jcbGradeNine.setText("Grade 9");
        jcbGradeNine.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeNine, gridBagConstraints);

        jcbGradeTen.setText("Grade 10");
        jcbGradeTen.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGradeLevelSelection.add(jcbGradeTen, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jpnlGradeLevelSelection, gridBagConstraints);

        jcbKindergartenCtg.setText("Kindergarten");
        jcbKindergartenCtg.setEnabled(false);
        jcbKindergartenCtg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbKindergartenCtgItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jcbKindergartenCtg, gridBagConstraints);

        jcbElementaryCtg.setText("Elementary");
        jcbElementaryCtg.setEnabled(false);
        jcbElementaryCtg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbElementaryCtgItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jcbElementaryCtg, gridBagConstraints);

        jcbJuniorHighCtg.setText("Junior HS");
        jcbJuniorHighCtg.setEnabled(false);
        jcbJuniorHighCtg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbJuniorHighCtgItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jcbJuniorHighCtg, gridBagConstraints);

        jpnlCreateCredentialControls.setLayout(new java.awt.GridBagLayout());

        jbtnClear.setText("Clear");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredentialControls.add(jbtnClear, gridBagConstraints);

        jbtnCreateCredential.setText("Create");
        jbtnCreateCredential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateCredentialActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredentialControls.add(jbtnCreateCredential, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCreateCredential.add(jpnlCreateCredentialControls, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlCreateCredential, gridBagConstraints);

        jspCredentialsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Credentials Created"));
        jspCredentialsList.setPreferredSize(new java.awt.Dimension(200, 250));
        jspCredentialsList.setViewportView(jlstCredentialNamesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jspCredentialsList, gridBagConstraints);

        jpnlSortCredentialList.setBorder(javax.swing.BorderFactory.createTitledBorder("Sort List"));
        jpnlSortCredentialList.setLayout(new java.awt.GridBagLayout());

        jlblYearCreated.setText("Year Created");
        jpnlSortCredentialList.add(jlblYearCreated, new java.awt.GridBagConstraints());

        jcmbYearCreated.setModel(new component_model_loader.SchoolYearJCompModelLoader().getAllSchoolYearStart());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlSortCredentialList.add(jcmbYearCreated, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlSortCredentialList, gridBagConstraints);

        jpnlDeleteCredential.setLayout(new java.awt.GridBagLayout());

        jbtnDeleteCredential.setText("Delete");
        jbtnDeleteCredential.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteCredentialActionPerformed(evt);
            }
        });
        jpnlDeleteCredential.add(jbtnDeleteCredential, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlDeleteCredential, gridBagConstraints);

        jpnlCredentialsMgmt.add(jPanel3, java.awt.BorderLayout.CENTER);

        jspCredentialRequirementsManagement.setViewportView(jpnlCredentialsMgmt);

        jtpManagementTabbedPane.addTab("Credentials", jspCredentialRequirementsManagement);

        jpnlPaymentScheduleMgmt.setLayout(new java.awt.BorderLayout());
        jspPaymentScheduleMgmt.setViewportView(jpnlPaymentScheduleMgmt);

        jtpManagementTabbedPane.addTab("Payment Schedules", jspPaymentScheduleMgmt);
        jtpManagementTabbedPane.addTab("Discounts", jpnlDiscountsMgmt);

        jpnlLanMgmt.setLayout(new java.awt.GridBagLayout());

        jPanel8.setLayout(new java.awt.GridBagLayout());
        jpnlLanMgmt.add(jPanel8, new java.awt.GridBagConstraints());

        jspLanMgmt.setViewportView(jpnlLanMgmt);

        jtpManagementTabbedPane.addTab("Lan", jspLanMgmt);

        jspSchoolYearMgmt.setViewportView(jpnlSchoolYearMgmt);

        jtpManagementTabbedPane.addTab("School Year", jspSchoolYearMgmt);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlContent.add(jtpManagementTabbedPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jpnlContent, gridBagConstraints);

        jmnFile.setText("File");

        jmiExit.setText("Exit");
        jmnFile.add(jmiExit);

        jMenuBar1.add(jmnFile);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel1.add(jInternalFrame1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel4.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDeleteCredentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteCredentialActionPerformed
        boolean itemIsSelectedOnList = jlstCredentialNamesList.getSelectedIndex() > -1;
        if (itemIsSelectedOnList) {

            String aCredentialName = jlstCredentialNamesList.getSelectedValue().trim();
            int choice = JOptionPane.showConfirmDialog(null, "Remove " + aCredentialName + "?", "Remove Confirmation", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                int aCredentialId = credentialDaoImpl.getCredentialIdByName(aCredentialName);
                boolean isRemoved = credentialDaoImpl.removeCredentialById(aCredentialId);
                if (isRemoved) {
                    JOptionPane.showMessageDialog(null, "Successfully removed " + aCredentialName);
                    setCredentialJList();
                } else {
                    JOptionPane.showMessageDialog(null, "Error encountered while removing " + aCredentialName);
                }
            }
        }
    }//GEN-LAST:event_jbtnDeleteCredentialActionPerformed

    private void jbtnCreateCredentialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateCredentialActionPerformed

        if (credentialDaoImpl.alreadyExists(jtfCredentialName.getText().trim())) {
            String credentialName = jtfCredentialName.getText().trim();
            JOptionPane.showMessageDialog(null,credentialName+" already exists on record.\nPlease try a different name");
        } else {
            int selected = JOptionPane.showConfirmDialog(null, "Add Credential?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
            if (selected==JOptionPane.YES_OPTION) {
                String credentialDescription = jtaCredentialDescription.getText();
                String credentialName = jtfCredentialName.getText().trim();

                SchoolYear yearCreated = new SchoolYear();
                yearCreated.setSchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId());

                Credential credential = new Credential();
                credential.setCredentialName(credentialName);
                credential.setCredentialDescription(credentialDescription);
                credential.setGradeLevelsAssigned(getGradeLevelsAssigned());
                credential.setSchoolYearCreated(yearCreated);

                boolean isSuccessfullyAdded = credentialDaoImpl.addCredential(credential);
                if (isSuccessfullyAdded) {
                    JOptionPane.showMessageDialog(null, "Successfully added " + credential.getCredentialName());
                    resetCreateCredentialFormPanel();
                    setCredentialsJList();
                } else {
                    JOptionPane.showMessageDialog(null, "Adding of " + credential.getCredentialName()+ " failed.");
                }
            }
        }
    }//GEN-LAST:event_jbtnCreateCredentialActionPerformed

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
        resetCreateCredentialFormPanel();
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jcbJuniorHighCtgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbJuniorHighCtgItemStateChanged
        if(jcbJuniorHighCtg.isSelected()){
            jcbGradeSeven.setSelected(true);
            jcbGradeEight.setSelected(true);
            jcbGradeNine.setSelected(true);
            jcbGradeTen.setSelected(true);
        }else if(!jcbJuniorHighCtg.isSelected()){
            jcbGradeSeven.setSelected(false);
            jcbGradeEight.setSelected(false);
            jcbGradeNine.setSelected(false);
            jcbGradeTen.setSelected(false);
        }
    }//GEN-LAST:event_jcbJuniorHighCtgItemStateChanged

    private void jcbElementaryCtgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbElementaryCtgItemStateChanged
        if(jcbElementaryCtg.isSelected()){
            jcbGradeOne.setSelected(true);
            jcbGradeTwo.setSelected(true);
            jcbGradeThree.setSelected(true);
            jcbGradeFour.setSelected(true);
            jcbGradeFive.setSelected(true);
            jcbGradeSix.setSelected(true);
        }else if(!jcbElementaryCtg.isSelected()){
            jcbGradeOne.setSelected(false);
            jcbGradeTwo.setSelected(false);
            jcbGradeThree.setSelected(false);
            jcbGradeFour.setSelected(false);
            jcbGradeFive.setSelected(false);
            jcbGradeSix.setSelected(false);
        }
    }//GEN-LAST:event_jcbElementaryCtgItemStateChanged

    private void jcbKindergartenCtgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbKindergartenCtgItemStateChanged
        if(jcbKindergartenCtg.isSelected()){
            JPanelUtil.uncheckCheckBoxes(jpnlGradeLevelSelection);
            jcbKindergarten.setSelected(true);
        }else{
            jcbKindergarten.setSelected(false);
        }
    }//GEN-LAST:event_jcbKindergartenCtgItemStateChanged

    private void jtfCredentialNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCredentialNameKeyPressed
        boolean credentialNameIsNotEmpty = !jtfCredentialName.getText().trim().isEmpty();
        if(credentialNameIsNotEmpty && evt.getKeyCode() == KeyEvent.VK_ENTER){
            jcbElementaryCtg.setEnabled(true);
            jcbJuniorHighCtg.setEnabled(true);
            jcbKindergartenCtg.setEnabled(true);
            JPanelUtil.enableCheckBoxes(jpnlGradeLevelSelection);
        }
    }//GEN-LAST:event_jtfCredentialNameKeyPressed

    @Override
    public void initRenderers() {
    }
    
    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
    }

    @Override
    public void initControllers() {
        jtpManagementTabbedPane.addMouseListener(
                new AddSettingsPanelToTabbedPaneOnMouseClick(
                        jtpManagementTabbedPane, jpnlSubjectMgmt, jpnlSubjectCatMgmt, 
                        jpnlCurriculumMgmt, jpnlFacultyMgmt, jpnlSectionMgmt, 
                        jpnlRoomMgmt, jpnlScheduleMgmt, jpnlFeesMgmt, 
                        jpnlCredentialsMgmt, jpnlPaymentScheduleMgmt, 
                        jpnlDiscountsMgmt, jpnlLanMgmt, jpnlSchoolYearMgmt)
        );
        jmiExit.addActionListener(new UINavigationExit(this,DashboardMenuItem.SETTINGS));
    }

    @Override
    public void initDaoImpl() {

    }
    
    private void resetCreateCredentialFormPanel(){
        JPanelUtil.uncheckCheckBoxes(jpnlGradeLevelSelection);
        JPanelUtil.disableAllJCheckBox(jpnlGradeLevelSelection);
        jtfCredentialName.setText("");
        jtaCredentialDescription.setText(null);
    }
    
    private List<GradeLevel> getGradeLevelsAssigned() {
        List<GradeLevel> gradeLevelList = new ArrayList<>();
        List<Integer> levelsList = new ArrayList<>();
        Component[] comp = jpnlGradeLevelSelection.getComponents();
        for (Component c : comp) {
            if (c instanceof JCheckBox) {
                if (((JCheckBox) c).isSelected() && !((JCheckBox) c).getText().equals("Kindergarten")) {
                    String glStr = ((JCheckBox) c).getText().replaceAll("[^-?0-9]+", " "); //takes out all numeric from string 
                    String gl = glStr.replaceAll("\\s+", ""); // removes all whitespace
                    if (!gl.isEmpty()) {
                        int glInt = Integer.parseInt(gl);
                        levelsList.add(glInt);
                    }
                } else if (((JCheckBox) c).isSelected() && ((JCheckBox) c).getText().equals("Kindergarten")) {
                    int gInt = 0;
                    levelsList.add(gInt);
                }
            }
        }
        for (int index = 0; index < levelsList.size(); index++) {
            GradeLevel gradeLevel = new GradeLevel();
            gradeLevel.setLevelNo(levelsList.get(index));
            int gradeLevelId = gradeLevelDaoImpl.getId(gradeLevel);
            gradeLevel.setId(gradeLevelId);
            gradeLevelList.add(gradeLevel);
            System.out.println("LevelId: " + gradeLevelId);
        }
        return gradeLevelList;
    }
    
    
    private void setCredentialsJList(){
        jlstCredentialNamesList.setModel(credentialGUIUtil.getAllCredentialNames());
    }
    
    private void setCredentialJList(){
        jlstCredentialNamesList.setModel(credentialGUIUtil.getAllCredentialNames());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnCreateCredential;
    private javax.swing.JButton jbtnDeleteCredential;
    private javax.swing.JCheckBox jcbElementaryCtg;
    private javax.swing.JCheckBox jcbGradeEight;
    private javax.swing.JCheckBox jcbGradeFive;
    private javax.swing.JCheckBox jcbGradeFour;
    private javax.swing.JCheckBox jcbGradeNine;
    private javax.swing.JCheckBox jcbGradeOne;
    private javax.swing.JCheckBox jcbGradeSeven;
    private javax.swing.JCheckBox jcbGradeSix;
    private javax.swing.JCheckBox jcbGradeTen;
    private javax.swing.JCheckBox jcbGradeThree;
    private javax.swing.JCheckBox jcbGradeTwo;
    private javax.swing.JCheckBox jcbJuniorHighCtg;
    private javax.swing.JCheckBox jcbKindergarten;
    private javax.swing.JCheckBox jcbKindergartenCtg;
    private javax.swing.JComboBox<String> jcmbYearCreated;
    private javax.swing.JLabel jlblCredentialName;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblYearCreated;
    private javax.swing.JList<String> jlstCredentialNamesList;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenu jmnFile;
    public static javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlCreateCredential;
    private javax.swing.JPanel jpnlCreateCredentialControls;
    private javax.swing.JPanel jpnlCreateNewCredentialDescription;
    private javax.swing.JPanel jpnlCredentialsMgmt;
    private javax.swing.JPanel jpnlCurriculumMgmt;
    private javax.swing.JPanel jpnlDeleteCredential;
    private javax.swing.JPanel jpnlDiscountsMgmt;
    private javax.swing.JPanel jpnlFacultyMgmt;
    private javax.swing.JPanel jpnlFeesMgmt;
    private javax.swing.JPanel jpnlGradeLevelSelection;
    private javax.swing.JPanel jpnlLanMgmt;
    private javax.swing.JPanel jpnlPaymentScheduleMgmt;
    private javax.swing.JPanel jpnlRoomMgmt;
    private javax.swing.JPanel jpnlScheduleMgmt;
    private javax.swing.JPanel jpnlSchoolYearMgmt;
    private javax.swing.JPanel jpnlSectionMgmt;
    private javax.swing.JPanel jpnlSortCredentialList;
    private javax.swing.JPanel jpnlSubjectCatMgmt;
    private javax.swing.JPanel jpnlSubjectMgmt;
    private javax.swing.JScrollPane jspCredentialDescription;
    private javax.swing.JScrollPane jspCredentialRequirementsManagement;
    private javax.swing.JScrollPane jspCredentialsList;
    private javax.swing.JScrollPane jspCurriculumMgmt;
    private javax.swing.JScrollPane jspFacultyMgmt;
    private javax.swing.JScrollPane jspLanMgmt;
    private javax.swing.JScrollPane jspPaymentScheduleMgmt;
    private javax.swing.JScrollPane jspRoomMgmt;
    private javax.swing.JScrollPane jspScheduleMgmt;
    private javax.swing.JScrollPane jspSchoolYearMgmt;
    private javax.swing.JScrollPane jspSectionMgmt;
    private javax.swing.JScrollPane jspSubjectCatMgmt;
    private javax.swing.JScrollPane jspSubjectMgmt;
    private javax.swing.JTextArea jtaCredentialDescription;
    private javax.swing.JTextField jtfCredentialName;
    private javax.swing.JTabbedPane jtpManagementTabbedPane;
    // End of variables declaration//GEN-END:variables
}
