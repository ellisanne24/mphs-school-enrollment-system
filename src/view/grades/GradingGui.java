
package view.grades;

import component_model_loader.FacultyML;
import component_model_loader.GradeLevelML;
import component_model_loader.GradeML;
import component_model_loader.SectionML;
import component_model_loader.StudentML;
import component_model_loader.SubjectML;
import daoimpl.GradeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import model.subject.Subject;


public class GradingGui extends javax.swing.JPanel{
    
   GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
   SubjectDaoImpl sbdi = new SubjectDaoImpl();
   SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
   StudentDaoImpl stdi = new StudentDaoImpl();
   GradeDaoImpl gdi = new GradeDaoImpl();
   SectionDaoImpl sdi = new SectionDaoImpl();
   
   GradeLevelML glml = new GradeLevelML();
   StudentML sml = new StudentML();
   GradeML gml = new GradeML();
   SectionML scml = new SectionML();
   FacultyML fml = new FacultyML();
   SubjectML sbml = new SubjectML();
   
   Subject subject = new Subject();
   Student student = new Student();
   Grade grade = new Grade();
   Section section = new Section();
   SchoolYear schoolYear = new SchoolYear();
   public GradingGui( ) {
        initComponents();
        jTabbedPane1.add(new Promotion(), "Promotion");
        jTabbedPane1.add(new Promoted(), "Promoted");
        cbSectionList.setModel(fml.getAllFacultySectionByFacultyId());
        jtbl_grades.getColumnModel().getColumn(0).setMinWidth(0);
        jtbl_grades.getColumnModel().getColumn(0).setMaxWidth(0);
        cbSectionList.setModel(new FacultyML().getAllFacultySectionByFacultyId());
        
        if(cbSectionList.getSelectedIndex() == 0)
        {
            section.setSectionName((String) cbSectionList.getSelectedItem());
            section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));
            
            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
            
            jlistStudent.setModel(scml.getAllStudentBySectionId(section, schoolYear));
            
            jtbl_grades.setModel(sbml.getAllStudentSubjectBySectionId(section));
            //Hide first column
            jtbl_grades.getColumnModel().getColumn(0).setMinWidth(0);
            jtbl_grades.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    
    
    private void computeFinal()
    {
        double finalGrade = 0;
        double grades = 0;
        double genAve = 0;
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        
        if(jtbl_grades.getRowCount() != 0)
        {
            for(int row = 0; row < jtbl_grades.getRowCount(); row++)
            {
                for(int column = 2; column < jtbl_grades.getColumnCount() - 1; column++)
                {
                    grades = Double.parseDouble(String.valueOf(jtbl_grades.getValueAt(row, column)));
                    
                    finalGrade += grades + 0.0;
                }
                jtbl_grades.setValueAt(finalGrade / 4, row, 6);
                //Revert to 0.0 after loop
                finalGrade = 0.0;
                
                genAve += Double.parseDouble(String.valueOf(jtbl_grades.getValueAt(row, 6)));
            }
            
            //Settext at tfGenAve
            tfGenAve.setText(df.format(genAve / jtbl_grades.getRowCount()));
            
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlistStudent = new javax.swing.JList<>();
        jPanel37 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSectionList = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_grades = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tfGenAve = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel47 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 700));
        setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 554));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel31.setPreferredSize(new java.awt.Dimension(100, 218));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setViewportView(jlistStudent);

        jPanel31.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel37.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Section:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel37.add(jLabel1, gridBagConstraints);

        cbSectionList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSectionListItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel37.add(cbSectionList, gridBagConstraints);

        jPanel2.add(jPanel37, java.awt.BorderLayout.NORTH);

        jPanel9.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(751, 554));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel49.setPreferredSize(new java.awt.Dimension(384, 544));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(null);
        jPanel5.setPreferredSize(new java.awt.Dimension(374, 50));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("REPORT CARD");
        jPanel5.add(jLabel14, new java.awt.GridBagConstraints());

        jPanel49.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(374, 384));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jtbl_grades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_grades.setRowHeight(30);
        jtbl_grades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_gradesMouseClicked(evt);
            }
        });
        jtbl_grades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_gradesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_grades);
        if (jtbl_grades.getColumnModel().getColumnCount() > 0) {
            jtbl_grades.getColumnModel().getColumn(0).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(1).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_grades.getColumnModel().getColumn(2).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_grades.getColumnModel().getColumn(3).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_grades.getColumnModel().getColumn(4).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_grades.getColumnModel().getColumn(5).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtbl_grades.getColumnModel().getColumn(6).setResizable(false);
            jtbl_grades.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel49.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(374, 50));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel16.setText("General Average");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel16, gridBagConstraints);

        tfGenAve.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(tfGenAve, gridBagConstraints);

        jPanel49.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel49, gridBagConstraints);

        jPanel9.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setPreferredSize(new java.awt.Dimension(751, 50));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        Save.setText("Save");
        Save.setPreferredSize(new java.awt.Dimension(77, 29));
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel17.add(Save, gridBagConstraints);

        jButton2.setText("Compute");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton2, new java.awt.GridBagConstraints());

        jPanel9.add(jPanel17, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(jPanel9, gridBagConstraints);

        jTabbedPane1.addTab("New", jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setPreferredSize(new java.awt.Dimension(950, 50));
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel19.add(jLabel18, gridBagConstraints);

        jTextField3.setColumns(10);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel19.add(jTextField3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jPanel19, gridBagConstraints);

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setPreferredSize(new java.awt.Dimension(950, 600));
        jPanel20.setLayout(new java.awt.GridBagLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setPreferredSize(new java.awt.Dimension(400, 590));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel22.setPreferredSize(new java.awt.Dimension(390, 50));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel20, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("WholeNameLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel21, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Grade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel22, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("GradeLevelLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel23, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Section:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel24, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("SectionLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel22.add(jLabel25, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel18.add(jPanel22, gridBagConstraints);

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel23.setPreferredSize(new java.awt.Dimension(390, 530));
        jPanel23.setLayout(new java.awt.GridBagLayout());

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel24.setPreferredSize(new java.awt.Dimension(380, 420));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel36.setLayout(new java.awt.BorderLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Subjects", "1", "2", "3", "4", "Final Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(30);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable4.getColumnModel().getColumn(3).setResizable(false);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable4.getColumnModel().getColumn(4).setResizable(false);
            jTable4.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable4.getColumnModel().getColumn(5).setResizable(false);
            jTable4.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel36.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel36, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel23.add(jPanel24, gridBagConstraints);

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel25.setPreferredSize(new java.awt.Dimension(380, 50));
        jPanel25.setLayout(new java.awt.GridBagLayout());

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel34.setText("Learning");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel25.add(jLabel34, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel23.add(jPanel25, gridBagConstraints);

        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel38.setPreferredSize(new java.awt.Dimension(380, 50));
        jPanel38.setLayout(new java.awt.GridBagLayout());

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel35.setText("General Average:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel38.add(jLabel35, gridBagConstraints);

        jTextField4.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel38.add(jTextField4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel23.add(jPanel38, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel18.add(jPanel23, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel20.add(jPanel18, gridBagConstraints);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel21.setPreferredSize(new java.awt.Dimension(400, 590));
        jPanel21.setLayout(new java.awt.GridBagLayout());

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel26.setPreferredSize(new java.awt.Dimension(390, 60));
        jPanel26.setLayout(new java.awt.GridBagLayout());

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel29.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel29.setLayout(new java.awt.GridBagLayout());

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel26.setText("2017-2018");
        jPanel29.add(jLabel26, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel26.add(jPanel29, gridBagConstraints);

        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel30.setPreferredSize(new java.awt.Dimension(235, 50));
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel27.setText("Grading Period");
        jPanel30.add(jLabel27, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel26.add(jPanel30, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel21.add(jPanel26, gridBagConstraints);

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel27.setPreferredSize(new java.awt.Dimension(390, 353));
        jPanel27.setLayout(new java.awt.GridBagLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Values", "1", "2", "3", "4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setRowHeight(30);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setResizable(false);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTable5.getColumnModel().getColumn(1).setResizable(false);
            jTable5.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable5.getColumnModel().getColumn(2).setResizable(false);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable5.getColumnModel().getColumn(3).setResizable(false);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable5.getColumnModel().getColumn(4).setResizable(false);
            jTable5.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel27.add(jScrollPane5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel21.add(jPanel27, gridBagConstraints);

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel28.setPreferredSize(new java.awt.Dimension(390, 160));
        jPanel28.setLayout(new java.awt.GridBagLayout());

        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel32.setPreferredSize(new java.awt.Dimension(386, 156));
        jPanel32.setLayout(new java.awt.GridBagLayout());

        jPanel33.setPreferredSize(new java.awt.Dimension(375, 35));
        jPanel33.setLayout(new java.awt.GridBagLayout());

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel28.setText("EVALUATION CODE");
        jPanel33.add(jLabel28, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel32.add(jPanel33, gridBagConstraints);

        jPanel34.setPreferredSize(new java.awt.Dimension(375, 70));
        jPanel34.setLayout(new java.awt.GridBagLayout());

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel29.setText("A (90-95) - Exemplary");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel34.add(jLabel29, gridBagConstraints);

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel30.setText("B (85-89) - Very Good");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel34.add(jLabel30, gridBagConstraints);

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel31.setText("D (75-79) - Marginally Good");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 10, 10);
        jPanel34.add(jLabel31, gridBagConstraints);

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel32.setText("C (80-84) - Good");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 10, 10);
        jPanel34.add(jLabel32, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel32.add(jPanel34, gridBagConstraints);

        jPanel35.setPreferredSize(new java.awt.Dimension(375, 35));
        jPanel35.setLayout(new java.awt.GridBagLayout());

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel33.setText("E (70-75) - Needs Improvement");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        jPanel35.add(jLabel33, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel32.add(jPanel35, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel28.add(jPanel32, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel21.add(jPanel28, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel20.add(jPanel21, gridBagConstraints);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 590));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jButton3.setText("print");
        jButton3.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel11.add(jButton3, gridBagConstraints);

        jButton1.setText("Update");
        jButton1.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel11.add(jButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel20.add(jPanel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jPanel20, gridBagConstraints);

        jPanel8.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Existing", jPanel8);

        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel44.setLayout(new java.awt.GridBagLayout());

        jPanel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel45.setPreferredSize(new java.awt.Dimension(950, 50));
        jPanel45.setLayout(new java.awt.GridBagLayout());

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel37.setText("Search:");
        jPanel45.add(jLabel37, new java.awt.GridBagConstraints());

        jTextField6.setPreferredSize(new java.awt.Dimension(170, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel45.add(jTextField6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel44.add(jPanel45, gridBagConstraints);

        jPanel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel46.setPreferredSize(new java.awt.Dimension(950, 454));
        jPanel46.setLayout(new java.awt.BorderLayout());

        jPanel48.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student Number", "First Name", "Last name", "Middle Name", "Grade Level", "General Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jScrollPane8.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel48.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jScrollPane6.setViewportView(jPanel48);

        jPanel46.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel44.add(jPanel46, gridBagConstraints);

        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel47.setPreferredSize(new java.awt.Dimension(950, 50));
        jPanel47.setLayout(new java.awt.GridBagLayout());

        jButton5.setText("Enroll");
        jButton5.setPreferredSize(new java.awt.Dimension(130, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel47.add(jButton5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel44.add(jPanel47, gridBagConstraints);

        jPanel42.add(jPanel44, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Summer Class", jPanel42);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        if (evt.getClickCount() == 2) {
            PrintGradesDialog print = new PrintGradesDialog(null, true);
            print.pack();
            print.setLocationRelativeTo(null);
            print.setVisible(true);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
       
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PrintGradesDialog grades = new PrintGradesDialog(null,true);
         grades.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtbl_gradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_gradesMouseClicked
        
      
    }//GEN-LAST:event_jtbl_gradesMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        String selected = jlistStudent.getSelectedValue();
        String result = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
        
        //Setter call
        for(int row = 0; row < jtbl_grades.getModel().getRowCount(); row++)
        {
            for(int column = 2; column < jtbl_grades.getModel().getColumnCount() - 1; column++)
            {
                grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtbl_grades.getValueAt(row, 0))));
                System.out.println("Subject Id "+grade.subject.getSubjectId());
                grade.setFinalGrade(Double.parseDouble(String.valueOf(jtbl_grades.getValueAt(row, 6))));
                System.out.println("Final Grade "+grade.getFinalGrade());
                grade.setGwa(Double.parseDouble(tfGenAve.getText()));
                System.out.println("GWA "+grade.getGwa());
                grade.setGrade(Double.parseDouble(String.valueOf(jtbl_grades.getValueAt(row, column))));
                System.out.println("Grade "+grade.getGrade());
                grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                
                if(column == 2)
                {
                    grade.setPeriodId(7000);
                }
                else if(column == 3)
                {
                    grade.setPeriodId(7001);
                }
                else if(column == 4)
                {
                    grade.setPeriodId(7002);
                }
                else
                {
                    grade.setPeriodId(7003);
                }
                
                grade.student.setStudentId(Integer.parseInt(result));

                gdi.createStudentGrade(grade);

//                if(row == jtbl_grades.getModel().getRowCount() - 1)
//                {
//                    JOptionPane.showMessageDialog(null, "Successful!");
//                }
            }
            
            
        }
        JOptionPane.showMessageDialog(null, "Successful!");
        
    }//GEN-LAST:event_SaveActionPerformed

    private void jtbl_gradesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_gradesKeyPressed
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//        
//            DefaultTableModel dtm = (DefaultTableModel)jtbl_grades.getModel();
//            dtm.addRow(new Object[]{});
//        }
//        else if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)
//        {
//            DefaultTableModel dtm = (DefaultTableModel)jtbl_grades.getModel();
//            dtm.removeRow(jtbl_grades.getSelectedRow());
//        }
    }//GEN-LAST:event_jtbl_gradesKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbSectionListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSectionListItemStateChanged
        //Setter call from Section
        section.setSectionName((String) cbSectionList.getSelectedItem());
        section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));
        //Setter call from SchoolYear
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
        
        //Set model on jlist
        jlistStudent.setModel(scml.getAllStudentBySectionId(section, schoolYear));
        
        //Set model on jtable
        jtbl_grades.setModel(sbml.getAllStudentSubjectBySectionId(section));
        //Hide first column
        jtbl_grades.getColumnModel().getColumn(0).setMinWidth(0);
        jtbl_grades.getColumnModel().getColumn(0).setMaxWidth(0);
        
    }//GEN-LAST:event_cbSectionListItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        computeFinal();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> cbSectionList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JList<String> jlistStudent;
    private javax.swing.JTable jtbl_grades;
    private javax.swing.JTextField tfGenAve;
    // End of variables declaration//GEN-END:variables
}
