package view.section;

import component_model_loader.FacultyML;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import component_model_loader.GradeLevelML;
import component_model_loader.SchoolYearML;
import component_model_loader.SectionML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.FacultyDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;
import utility.component.JTableUtil;
import utility.layout.SectionUtility;

public class SectionManagementContainer extends javax.swing.JPanel {
    
    
    
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
    
    private JTableUtil jtu = new JTableUtil();
    
    private SectionUtility sectionUtility = new SectionUtility();
    
    public SectionManagementContainer() 
    {
        initComponents();
        
        jTabbedPane2.add(new New(), "New");
        
        //Set model
        tblCreatedSections.setModel(sml.getAllSections());
        
        //Hide first column
        tblCreatedSections.getColumnModel().getColumn(0).setMinWidth(0);
        tblCreatedSections.getColumnModel().getColumn(0).setMaxWidth(0);
        
                
        cbGradeLevelList.setModel(gl.getAllGradeLevels());
        
        cbAssignGradeLevel.setModel(gl.getAllGradeLevels());
        
        
//        cbAssignSection2.setModel(sml.getAllSectionName());
        cbAssignSection2.setPrototypeDisplayValue("XXXXXXXX");
        
        
        cbGradeLevelList.setRenderer(new GradeLevelJComboBoxRenderer());
        cbAssignGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        
        sectionTab.setEnabledAt(0, false);
        sectionTab.setEnabledAt(1, false);
        sectionTab.setEnabledAt(2, false);
        
        
        if(cbAssignSection2.getSelectedIndex() == 0)
        {
            //Setter call from Section
            section.setSectionName(String.valueOf(cbAssignSection2.getSelectedItem()));
            section.setSectionId(sdi.getSectionId(section));
            
            
            for(int i = 0; i < sdi.getSessionIdBySectionId(section).size(); i++)
            {
                if(sdi.getSessionIdBySectionId(section).get(i).equals(1))
                {
                    sectionTab.setEnabledAt(0, true);
                }
                else if(sdi.getSessionIdBySectionId(section).get(i).equals(2))
                {
                    sectionTab.setEnabledAt(1, true);
                }
                else
                {
                    sectionTab.setEnabledAt(2, true);
                }
            }
            
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
        else if(cbAssignSection2.getSelectedIndex() == -1)
        {
            radioGWA.setEnabled(false);
                lblRequiredGWA.setEnabled(false);
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
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAssign = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        sectionTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAM = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPM = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDefault = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbAssignGradeLevel = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
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

            },
            new String [] {
                "Id", "Section Name", "Grade Level", "Adviser", "Required Grade", "Session", "SchoolYear", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCreatedSections.setRowHeight(30);
        jScrollPane1.setViewportView(tblCreatedSections);
        if (tblCreatedSections.getColumnModel().getColumnCount() > 0) {
            tblCreatedSections.getColumnModel().getColumn(0).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(1).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(2).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(3).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(4).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(5).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(6).setResizable(false);
            tblCreatedSections.getColumnModel().getColumn(7).setResizable(false);
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

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(500, 402));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblAssign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "General Average"
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

        btnAdd.setText("Transfer");
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

        jPanel16.setPreferredSize(new java.awt.Dimension(500, 450));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(452, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tblAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAMMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblAM);
        if (tblAM.getColumnModel().getColumnCount() > 0) {
            tblAM.getColumnModel().getColumn(0).setResizable(false);
            tblAM.getColumnModel().getColumn(1).setResizable(false);
            tblAM.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        sectionTab.addTab("AM", jPanel2);

        jPanel4.setLayout(new java.awt.BorderLayout());

        tblPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPMMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPM);
        if (tblPM.getColumnModel().getColumnCount() > 0) {
            tblPM.getColumnModel().getColumn(0).setResizable(false);
            tblPM.getColumnModel().getColumn(1).setResizable(false);
            tblPM.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel4.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        sectionTab.addTab("PM", jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        tblDefault.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDefault.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDefaultMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDefault);
        if (tblDefault.getColumnModel().getColumnCount() > 0) {
            tblDefault.getColumnModel().getColumn(0).setResizable(false);
            tblDefault.getColumnModel().getColumn(1).setResizable(false);
            tblDefault.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel5.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        sectionTab.addTab("Default", jPanel5);

        jPanel16.add(sectionTab, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel10.add(jPanel16, gridBagConstraints);

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Controls"));
        jPanel11.setPreferredSize(new java.awt.Dimension(1012, 130));
        jPanel11.setLayout(new java.awt.BorderLayout());

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
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel12.add(cbAssignGradeLevel, gridBagConstraints);

        jPanel11.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel13.setPreferredSize(new java.awt.Dimension(500, 150));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel13.setText("Section Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel13.add(jLabel13, gridBagConstraints);

        cbAssignSection2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssignSection2ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
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

        jPanel11.add(jPanel13, java.awt.BorderLayout.EAST);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UpdateSection updateSection;
        
        //Setter call from Section
        section.setSectionId((int) tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 0));
        
        updateSection = new UpdateSection(section.getSectionId());
        
        //Set text on textfields
        updateSection.getTfSectionName().setText((String) tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 1));
        updateSection.getCbGradeLevel().setSelectedItem(tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 2));
        updateSection.getPnlStudentList().setBorder(new TitledBorder("Students in "+updateSection.getTfSectionName().getText() +" Section"));
        
        if(tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 3).equals("No adviser"))
        {
            updateSection.getCbAdviser().setModel(fml.getAllFacultyName());
        }
        else
        {
            updateSection.getCbAdviser().setModel(fml.getAllFacultyNameWithAssigned((String) tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 3)));
        }
        
        
        if(tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 5).equals("AM"))
        {
            updateSection.getChbAM().setSelected(true);
        }
        else if(tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 5).equals("PM"))
        {
            updateSection.getChbPM().setSelected(true);
        }
        else if(tblCreatedSections.getValueAt(tblCreatedSections.getSelectedRow(), 5).equals("Default"))
        {
            updateSection.getChbDefault().setSelected(true);
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbAssignGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssignGradeLevelItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbAssignGradeLevel.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        
        //Set model on tblAssign
        tblAssign.setModel(sml.getAllStudentsByGradeLevelId(gradeLevel));
        //Set Model on cbAssignSection2
        cbAssignSection2.setModel(sml.getAllSectionNameByGradeLevelId(gradeLevel));
        
        if(cbAssignSection2.getSelectedIndex() == 0)
        {
            //Setter call from Section
            section.setSectionName(String.valueOf(cbAssignSection2.getSelectedItem()));
            section.setSectionId(sdi.getSectionId(section));
            
            for(int i = 0; i < sdi.getSessionIdBySectionId(section).size(); i++)
            {
                if(sdi.getSessionIdBySectionId(section).get(i).equals(1))
                {
                    sectionTab.setEnabledAt(0, true);
                    
                    if(sectionTab.isEnabledAt(0))
                    {
                        sectionTab.setSelectedIndex(0);
                    }
                }
                else if(sdi.getSessionIdBySectionId(section).get(i).equals(2))
                {
                    sectionTab.setEnabledAt(1, true);
                    
                    if(sectionTab.isEnabledAt(1))
                    {
                        sectionTab.setSelectedIndex(1);
                    }
                }
                else
                {
                    sectionTab.setEnabledAt(2, true);
                    
                    if(sectionTab.isEnabledAt(2))
                    {
                        sectionTab.setSelectedIndex(2);
                    }
                }
            }
            
            
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
        else if(cbAssignSection2.getSelectedIndex() == -1)
        {
            radioGWA.setEnabled(false);
            lblRequiredGWA.setEnabled(false);
        }
    }//GEN-LAST:event_cbAssignGradeLevelItemStateChanged

    private void tblAssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssignMouseClicked
        if (tblAssign.getSelectedRow() > -1) {
            btnAdd.setEnabled(true);
        }
        if (evt.getSource().equals(tblAssign)) {
            if (evt.getClickCount() == 2) {
                
                if(sectionTab.getSelectedIndex() == 0)
                {
                    jtu.copyTableSectionData(tblAssign, tblAM, grade.getGwa());
                }
                else if(sectionTab.getSelectedIndex() == 1)
                {
                    jtu.copyTableSectionData(tblAssign, tblPM, grade.getGwa());
                }
                else
                {
                    jtu.copyTableSectionData(tblAssign, tblDefault, grade.getGwa());
                }
                
            }
        }
    }//GEN-LAST:event_tblAssignMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(sectionTab.getSelectedIndex() == 0)
        {
            jtu.copyTableSectionData(tblAssign, tblAM, grade.getGwa());
        }
        else if(sectionTab.getSelectedIndex() == 1)
        {
            jtu.copyTableSectionData(tblAssign, tblPM, grade.getGwa());
        }
        else
        {
            jtu.copyTableSectionData(tblAssign, tblDefault, grade.getGwa());
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        //Setter call from Section while getting the section id
        section.setSectionName((String) cbAssignSection2.getSelectedItem());
        section.setSectionId(sdi.getSectionId(section));
        //Setter call from SchoolYear
        schoolYear.setSchoolYearId(sdi.getSectionSchoolYearId(section));
        
        if(tblAM.getRowCount() == 0 && tblPM.getRowCount() == 0 && tblDefault.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Cannot create empty section");
        }
        else
        {
            for(int z = 0; z < 3; z++)
            {
                if(z == 0)
                {
                    if(tblAM.getRowCount() != 0)
                    {
                        for(int i = 0; i< tblAM.getRowCount(); i++)
                        {
                            //Setter call from Student
                            student.setStudentId((int) tblAM.getValueAt(i, 0));

                            //Method call from SectionDaoImpl
                            sdi.createStudentSection(section, student, schoolYear);
                        }   
                    }
                }
                else if(z == 1)
                {
                    if(tblPM.getRowCount() != 0)
                    {
                        for(int i = 0; i< tblPM.getRowCount(); i++)
                        {
                            //Setter call from Student
                            student.setStudentId((int) tblPM.getValueAt(i, 0));
                    
                            //Method call from SectionDaoImpl
                            sdi.createStudentSection(section, student, schoolYear);
                        }
                    }
                }
                else
                {
                    if(tblDefault.getRowCount() != 0)
                    {
                        for(int i = 0; i< tblDefault.getRowCount(); i++)
                        {
                            //Setter call from Student
                            student.setStudentId((int) tblDefault.getValueAt(i, 0));
                    
                            //Method call from SectionDaoImpl
                            sdi.createStudentSection(section, student, schoolYear);
                        }
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, "Successful!");
        }
        


        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbAssignGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAssignGradeLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAssignGradeLevelActionPerformed

    private void cbAssignSection2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssignSection2ItemStateChanged
        sectionTab.setEnabledAt(0, false);
        sectionTab.setEnabledAt(1, false);
        sectionTab.setEnabledAt(2, false);
        //Setter call from Section
        section.setSectionName((String) cbAssignSection2.getSelectedItem());
        section.setSectionId(sdi.getSectionId(section));
        
        for(int i = 0; i < sdi.getSessionIdBySectionId(section).size(); i++)
        {
            if(sdi.getSessionIdBySectionId(section).get(i).equals(1))
            {
                sectionTab.setEnabledAt(0, true);
            }
            else if(sdi.getSessionIdBySectionId(section).get(i).equals(2))
            {
                sectionTab.setEnabledAt(1, true);
            }
            else
            {
                sectionTab.setEnabledAt(2, true);
            }
        }
        
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

    private void radioGWAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioGWAItemStateChanged
        if (radioGWA.isSelected()) {
            grade.setGwa(sdi.getSectionAverageBySectionId(section));
        } else {
            grade.setGwa(0);
        }
    }//GEN-LAST:event_radioGWAItemStateChanged

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if(sectionTab.getSelectedIndex() == 0)
        {
            jtu.returnCopyData(tblAM, tblAssign);
        }
        else if(sectionTab.getSelectedIndex() == 1)
        {
            jtu.returnCopyData(tblPM, tblAssign);
        }
        else
        {
            jtu.returnCopyData(tblDefault, tblAssign);
        }
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAMMouseClicked
        jtu.returnCopyData(tblAM, tblAssign);
    }//GEN-LAST:event_tblAMMouseClicked

    private void tblPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPMMouseClicked
        jtu.returnCopyData(tblPM, tblAssign);
    }//GEN-LAST:event_tblPMMouseClicked

    private void tblDefaultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDefaultMouseClicked
        jtu.returnCopyData(tblDefault, tblAssign);
    }//GEN-LAST:event_tblDefaultMouseClicked

    public JTable getTblCreatedSection()
    {
        return tblCreatedSections;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreate;
    private javax.swing.ButtonGroup btnFilterGroup;
    private javax.swing.ButtonGroup btnOldNewGroup;
    private javax.swing.JButton btnRemove;
    private javax.swing.ButtonGroup btnSessionGroup;
    private javax.swing.ButtonGroup btnSessionGroup2;
    private javax.swing.JComboBox<String> cbAssignGradeLevel;
    private javax.swing.JComboBox<String> cbAssignSection2;
    private javax.swing.JComboBox<String> cbGradeLevelList;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblRequiredGWA;
    private javax.swing.JRadioButton radioGWA;
    private javax.swing.JTabbedPane sectionTab;
    private javax.swing.JTable tblAM;
    private javax.swing.JTable tblAssign;
    private javax.swing.JTable tblCreatedSections;
    private javax.swing.JTable tblDefault;
    private javax.swing.JTable tblPM;
    // End of variables declaration//GEN-END:variables
}
