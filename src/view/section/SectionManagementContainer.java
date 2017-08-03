package view.section;

import component_model_loader.FacultyML;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import component_model_loader.GradeLevelML;
import component_utility.JTableGUIUtil;
import component_model_loader.SchoolYearML;
import component_model_loader.SectionML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.FacultyDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;
import utility.layout.SectionUtility;

public class SectionManagementContainer extends javax.swing.JPanel {
    
    Object[] sessionList = new Object[]{"AM", "PM"};
    
    DefaultComboBoxModel sessionModel = new DefaultComboBoxModel(sessionList);
    DefaultComboBoxModel averageModel = new DefaultComboBoxModel();
    
    private SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    private SectionDaoImpl sdi = new SectionDaoImpl();
    private GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    private FacultyDaoImpl fdi = new FacultyDaoImpl();
    
    private GradeLevelML gl = new GradeLevelML();
    private SchoolYearML syml = new SchoolYearML();
    private SectionML sml = new SectionML();
    private FacultyML fml = new FacultyML();
            
    private SchoolYear schoolYear = new SchoolYear();
    
    private Section section = new Section();
    private GradeLevel gradeLevel = new GradeLevel();
    private Session session = new Session();
    private Student student = new Student();
    private Faculty faculty = new Faculty();
    private Grade grade = new Grade();
    
    private SectionUtility sectionUtility = new SectionUtility();
    
    public SectionManagementContainer() 
    {
        initComponents();
        
        for(int i = 75; i < 100; i++)
        {
            averageModel.addElement(i);
        }
        
        cbAverage.setModel(averageModel);
        cbAverage.setSelectedIndex(-1);
//        
//        btnFilterGroup.add(radioGradeLevel);
        
        btnOldNewGroup.add(radioNew);
        btnOldNewGroup.add(radioOld);
        
        cbGradeLevel.setModel(gl.getAllGradeLevels());
        cbGradeLevel.setSelectedIndex(-1);
        
        
        cbSession.setModel(sessionModel);
        cbSession.setSelectedIndex(-1);
        
        //Set model
        tblCreatedSections.setModel(sml.getAllSections());
        
        //Hide first column
        tblCreatedSections.getColumnModel().getColumn(0).setMinWidth(0);
        tblCreatedSections.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblAssign.getColumnModel().getColumn(0).setMinWidth(0);
        tblAssign.getColumnModel().getColumn(0).setMaxWidth(0);
        
        tblAssign2.getColumnModel().getColumn(0).setMinWidth(0);
        tblAssign2.getColumnModel().getColumn(0).setMaxWidth(0);
                
        cbGradeLevelList.setModel(gl.getAllGradeLevels());
        
        cbAssignGradeLevel.setModel(gl.getAllGradeLevels());
        
        cbAssignSection2.setModel(sml.getAllSectionName());
        cbAssignSection2.setPrototypeDisplayValue("XXXXXXXX");
        
        cbAssignGradeLevel2.setModel(gl.getAllGradeLevels());
        
        
        cbGradeLevelList.setRenderer(new GradeLevelJComboBoxRenderer());
        cbAssignGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        cbAssignGradeLevel2.setRenderer(new GradeLevelJComboBoxRenderer());
        
        cbGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        
        if(cbAssignSection2.getSelectedIndex() == 0)
        {
            //Setter call from Section
            section.setSectionName((String) cbAssignSection2.getSelectedItem());
            section.setSectionId(sdi.getSectionId(section));

        
            if(sdi.getSectionAverageBySectionId(section) == 0)
            {
                radioGWA.setEnabled(false);
                lblRequiredGWA.setEnabled(false);
            }
            else
            {
                radioGWA.setEnabled(true);
                lblRequiredGWA.setEnabled(true);
                lblRequiredGWA.setText("Required GWA: "+sdi.getSectionAverageBySectionId(section)); 
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnFilterGroup = new javax.swing.ButtonGroup();
        btnSessionGroup2 = new javax.swing.ButtonGroup();
        btnSessionGroup = new javax.swing.ButtonGroup();
        btnOldNewGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbGradeLevelList = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCreatedSections = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSubjectName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbGradeLevel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbSession = new javax.swing.JComboBox<>();
        chbBoth = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cbAverage = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssign = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAssign2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbAssignGradeLevel = new javax.swing.JComboBox<>();
        radioNew = new javax.swing.JRadioButton();
        radioOld = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbAssignGradeLevel2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbAssignSection2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        radioGWA = new javax.swing.JRadioButton();
        lblRequiredGWA = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Control"));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("Grade Level:");
        jPanel7.add(jLabel9, new java.awt.GridBagConstraints());

        cbGradeLevelList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelListItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel7.add(cbGradeLevelList, gridBagConstraints);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.BorderLayout());

        tblCreatedSections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Section Name", "Required Grade", "Session", "SchoolYear", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCreatedSections);
        if (tblCreatedSections.getColumnModel().getColumnCount() > 0) {
            tblCreatedSections.getColumnModel().getColumn(0).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(1).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(2).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(3).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(4).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel8.add(jButton2, gridBagConstraints);

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jTabbedPane2.addTab("Existing", jPanel3);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Section"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(tfSubjectName, gridBagConstraints);

        jLabel6.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel6, gridBagConstraints);

        cbGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbGradeLevel, gridBagConstraints);

        jLabel10.setText("Session:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel4.add(jLabel10, gridBagConstraints);

        cbSession.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSessionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbSession, gridBagConstraints);

        chbBoth.setText("Both");
        chbBoth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbBothItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel4.add(chbBoth, gridBagConstraints);

        jLabel4.setText("Required Average:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel4.add(cbAverage, gridBagConstraints);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnSave.setText("Create");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel5.add(btnSave, gridBagConstraints);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jTabbedPane2.addTab("New", jPanel2);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(500, 402));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblAssign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAssign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssignMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAssign);
        if (tblAssign.getColumnModel().getColumnCount() > 0) {
            tblAssign.getColumnModel().getColumn(0).setResizable(false);
            tblAssign.getColumnModel().getColumn(1).setResizable(false);
            tblAssign.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel14.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel10.add(jPanel14, gridBagConstraints);

        jPanel15.setPreferredSize(new java.awt.Dimension(190, 402));
        jPanel15.setLayout(new java.awt.GridBagLayout());

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel15.add(btnAdd, gridBagConstraints);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel15.add(btnRemove, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        jPanel10.add(jPanel15, gridBagConstraints);

        jPanel16.setPreferredSize(new java.awt.Dimension(500, 402));
        jPanel16.setLayout(new java.awt.BorderLayout());

        tblAssign2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAssign2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssign2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAssign2);
        if (tblAssign2.getColumnModel().getColumnCount() > 0) {
            tblAssign2.getColumnModel().getColumn(0).setResizable(false);
            tblAssign2.getColumnModel().getColumn(1).setResizable(false);
            tblAssign2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel16.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel10.add(jPanel16, gridBagConstraints);

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Controls"));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jPanel12.setBorder(null);
        jPanel12.setPreferredSize(new java.awt.Dimension(500, 150));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel12.add(jLabel11, gridBagConstraints);

        cbAssignGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssignGradeLevelItemStateChanged(evt);
            }
        });
        cbAssignGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAssignGradeLevelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel12.add(cbAssignGradeLevel, gridBagConstraints);

        radioNew.setText("Transferee");
        radioNew.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioNewItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel12.add(radioNew, gridBagConstraints);

        radioOld.setText("Old");
        radioOld.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioOldItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel12.add(radioOld, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        jPanel11.add(jPanel12, gridBagConstraints);

        jPanel13.setBorder(null);
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 150));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel12.setText("Grade Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(jLabel12, gridBagConstraints);

        cbAssignGradeLevel2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssignGradeLevel2ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(cbAssignGradeLevel2, gridBagConstraints);

        jLabel13.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(jLabel13, gridBagConstraints);

        cbAssignSection2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssignSection2ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(cbAssignSection2, gridBagConstraints);
        jPanel13.add(jLabel3, new java.awt.GridBagConstraints());

        radioGWA.setText("GWA");
        radioGWA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioGWAItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(radioGWA, gridBagConstraints);

        lblRequiredGWA.setText("Required GWA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel13.add(lblRequiredGWA, gridBagConstraints);

        jPanel11.add(jPanel13, new java.awt.GridBagConstraints());

        jPanel9.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel17.setLayout(new java.awt.GridBagLayout());

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel17.add(btnCreate, gridBagConstraints);

        jPanel9.add(jPanel17, java.awt.BorderLayout.PAGE_END);

        jTabbedPane2.addTab("Assign", jPanel9);

        jPanel1.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (chbBoth.isSelected())
        {
            for (int i = 0; i < 2; i++) 
            {
                if(i == 0)
                {
                    //Setter call from Section
                    section.setSectionName(tfSubjectName.getText());
                    section.setRequiredAverage( cbAverage.getSelectedItem().toString().trim());
                    section.setSectionId(section.getSectionId());
                    //Setter call from SchoolYear
                    schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                    //Setter call from GradeLevel
                    gradeLevel.setId(gldi.getId(gradeLevel));
                    //Setter call from Session
                    session.setSessionId(1);
                    
                    //Method call from SectionDaoImpl
                    sdi.createSectionSettings(section, schoolYear, gradeLevel, session);
                }
                else {
                    //Setter call from Section
                    section.setSectionName(tfSubjectName.getText());
                    section.setRequiredAverage( cbAverage.getSelectedItem().toString().trim());
                    section.setSectionId(section.getSectionId());
                    //Setter call from SchoolYear
                    schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                    //Setter call from GradeLevel
                    gradeLevel.setId(gldi.getId(gradeLevel));
                    //Setter call from Session
                    session.setSessionId(2);

                    //Method call from SectionDaoImpl
                    sdi.createSectionSettings(section, schoolYear, gradeLevel, session);

                    JOptionPane.showMessageDialog(null, "Successfully creating " + tfSubjectName.getText() + " section!");
                }
            }
        }
        else {
            //Setter call from Section
            section.setSectionName(tfSubjectName.getText());
            section.setRequiredAverage( cbAverage.getSelectedItem().toString().trim());
            section.setSectionId(section.getSectionId());
            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
            //Setter call from GradeLevel
            gradeLevel.setId(gldi.getId(gradeLevel));
            //Setter call from Session
            session.setSessionId(session.getSessionId());

            //Method call from SectionDaoImpl
            sdi.createSectionSettings(section, schoolYear, gradeLevel, session);

            JOptionPane.showMessageDialog(null, "Successfully creating " + tfSubjectName.getText() + " section!");
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbGradeLevel.getSelectedItem());

    }//GEN-LAST:event_cbGradeLevelItemStateChanged

    private void cbSessionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSessionItemStateChanged
        if (cbSession.getSelectedIndex() == 0) {
            session.setSessionId(1);

        } else {
            session.setSessionId(2);

        }
    }//GEN-LAST:event_cbSessionItemStateChanged

    private void cbGradeLevelListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelListItemStateChanged
        //Setter call from GradeLevel & Method call from GradeLevelDaoImpl
        gradeLevel.setLevel((Integer) cbGradeLevelList.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        
        //Set model on tblCreatedSections
        tblCreatedSections.setModel(sml.getAllSectionsByGradeLevelId(gradeLevel));
        
        //Hide first column
        tblCreatedSections.getColumnModel().getColumn(0).setMinWidth(0);
        tblCreatedSections.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_cbGradeLevelListItemStateChanged

    private void chbBothItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbBothItemStateChanged
        if(chbBoth.isSelected())
        {
            cbSession.setEnabled(false);
        }
        else
        {
            cbSession.setEnabled(true);
        }
    }//GEN-LAST:event_chbBothItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UpdateSection updateSection = new UpdateSection();
        
        //Setter call from Section
        section.setSectionId((int) tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 0));
        
        //Set text on textfields and jcomboboxes
        updateSection.getTfSectionName().setText((String) sectionUtility.getCreatedSectionById(section).get(0));
        updateSection.getCbGradeLevel().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(1));
        updateSection.getCbSchoolYearFrom().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(2));
        updateSection.getCbSchoolYearTo().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(3));
        updateSection.getCbGradeLevelFrom().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(4));
        updateSection.getCbGradeLevelTo().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(5));
        updateSection.getCbMethod().setSelectedItem(sectionUtility.getCreatedSectionById(section).get(6));
        
        if(sectionUtility.getCreatedSectionById(section).size() > 1)
        {
            //Set checked
            updateSection.getChbBoth().setSelected(true);
            for(int i = 0; i < 2; i++)
            {
                if(i == 0)
                {
                    updateSection.getTfAM().setText(sectionUtility.getCreatedSectionById(section).get(7).toString());
                }
                else
                {
                    updateSection.getTfPM().setText((String) sectionUtility.getCreatedSectionById(section).get(7).toString());
                }
            }
        }
        else
        {
            //Remove checked
            updateSection.getChbBoth().setSelected(false);
            updateSection.getTfAM().setText((String) sectionUtility.getCreatedSectionById(section).get(8));
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbAssignGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssignGradeLevelItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbAssignGradeLevel.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        
        if (radioNew.isSelected()) {
            tblAssign.setModel(sml.getAllNewStudentsByGradeLevelId(gradeLevel));

            //Hide first column
            tblAssign.getColumnModel().getColumn(0).setMinWidth(0);
            tblAssign.getColumnModel().getColumn(0).setMaxWidth(0);
        } else {
            tblAssign.setModel(sml.getAllOldStudentsByGradeLevelId(gradeLevel));

            //Hide first column
            tblAssign.getColumnModel().getColumn(0).setMinWidth(0);
            tblAssign.getColumnModel().getColumn(0).setMaxWidth(0);
        }
        
    }//GEN-LAST:event_cbAssignGradeLevelItemStateChanged

    private void tblAssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssignMouseClicked
        if (tblAssign.getSelectedRow() > -1) {
            btnAdd.setEnabled(true);
        }
        if (evt.getSource().equals(tblAssign)) {
            if (evt.getClickCount() == 2) {
                JTableGUIUtil jtm = new JTableGUIUtil();
                jtm.copyTableSectionData(tblAssign, tblAssign2, grade.getGwa(), cbAssignGradeLevel, cbAssignGradeLevel2);
            }
        }
    }//GEN-LAST:event_tblAssignMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

          JTableGUIUtil jtm = new JTableGUIUtil();
          jtm.copyTableSectionData(tblAssign, tblAssign2, grade.getGwa(), cbAssignGradeLevel, cbAssignGradeLevel2);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if(tblAssign2.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Cannot create empty section");
        }
        else
        {
            for(int i = 0; i< tblAssign2.getRowCount(); i++)
            {
                //Setter call from Section while getting the section id
                section.setSectionId(sdi.getSectionId(section));
                //Setter call from Student
                student.setStudentId((int) tblAssign2.getValueAt(i, 0));
                //Setter call from SchoolYear
                schoolYear.setSchoolYearId(sdi.getSectionSchoolYearId(section));
                System.out.println("Section Id "+section.getSectionId());
                System.out.println("Student Id "+student.getStudentId());
                System.out.println("Section SchoolYear Id "+schoolYear.getSchoolYearId());
                
                //Method call from SectionDaoImpl
                sdi.createStudentSection(section, student, schoolYear);
                
                if(i == tblAssign2.getRowCount() - 1)
                {
                    JOptionPane.showMessageDialog(null, "Successfully adding " +tblAssign2.getRowCount() + " students to "+cbAssignSection2.getSelectedItem());
                }
            }
            
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbAssignGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAssignGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAssignGradeLevelActionPerformed

    private void cbAssignSection2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssignSection2ItemStateChanged
        //Setter call from Section
        section.setSectionName((String) cbAssignSection2.getSelectedItem());
        section.setSectionId(sdi.getSectionId(section));

        
        if(sdi.getSectionAverageBySectionId(section) == 0)
        {
            radioGWA.setEnabled(false);
            lblRequiredGWA.setEnabled(false);
        }
        else
        {
            radioGWA.setEnabled(true);
            lblRequiredGWA.setEnabled(true);
            lblRequiredGWA.setText("Required GWA: "+sdi.getSectionAverageBySectionId(section)); 
        }
        
    }//GEN-LAST:event_cbAssignSection2ItemStateChanged

    private void cbAssignGradeLevel2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssignGradeLevel2ItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbAssignGradeLevel2.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        
        //Set Model
        cbAssignSection2.setModel(sml.getAllSectionByGradeLevelId(gradeLevel));
        
    }//GEN-LAST:event_cbAssignGradeLevel2ItemStateChanged

    private void radioNewItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioNewItemStateChanged
        
    }//GEN-LAST:event_radioNewItemStateChanged

    private void radioOldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioOldItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radioOldItemStateChanged

    private void radioGWAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioGWAItemStateChanged
        if (radioGWA.isSelected()) {
            grade.setGwa(sdi.getSectionAverageBySectionId(section));
        } else {
            grade.setGwa(0);
        }
    }//GEN-LAST:event_radioGWAItemStateChanged

    private void tblAssign2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssign2MouseClicked
        DefaultTableModel model = (DefaultTableModel)tblAssign2.getModel();
        model.removeRow(tblAssign2.getSelectedRow());
    }//GEN-LAST:event_tblAssign2MouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblAssign2.getModel();
        model.removeRow(tblAssign2.getSelectedRow());
    }//GEN-LAST:event_btnRemoveActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreate;
    private javax.swing.ButtonGroup btnFilterGroup;
    private javax.swing.ButtonGroup btnOldNewGroup;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btnSessionGroup;
    private javax.swing.ButtonGroup btnSessionGroup2;
    private javax.swing.JComboBox<String> cbAssignGradeLevel;
    private javax.swing.JComboBox<String> cbAssignGradeLevel2;
    private javax.swing.JComboBox<String> cbAssignSection2;
    private javax.swing.JComboBox<String> cbAverage;
    private javax.swing.JComboBox<String> cbGradeLevel;
    private javax.swing.JComboBox<String> cbGradeLevelList;
    private javax.swing.JComboBox<String> cbSession;
    private javax.swing.JCheckBox chbBoth;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblRequiredGWA;
    private javax.swing.JRadioButton radioGWA;
    private javax.swing.JRadioButton radioNew;
    private javax.swing.JRadioButton radioOld;
    private javax.swing.JTable tblAssign;
    private javax.swing.JTable tblAssign2;
    private javax.swing.JTable tblCreatedSections;
    private javax.swing.JTextField tfSubjectName;
    // End of variables declaration//GEN-END:variables
}
