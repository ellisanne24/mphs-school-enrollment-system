
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
import model.user.User;
import view.container.Dashboard;
import view.login.LoginForm;


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
   User user = new User();
   
   String selected;
   String result;
   
   public GradingGui() {
        initComponents();
        jTabbedPane1.add(new Promotion(), "Promotion");
        jTabbedPane1.add(new Promoted(), "Promoted");
        jTabbedPane1.add(new SummerClass(), "Summer Class");
        jTabbedPane1.add(new TOR(), "TOR");
        
        user.setId(Dashboard.userId);
        cbSectionList.setModel(fml.getAllFacultySectionByFacultyId(user));
        jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
        
        if(cbSectionList.getSelectedIndex() == 0)
        {
            section.setSectionName((String) cbSectionList.getSelectedItem());
            section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));
            
            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
            
            jlistStudent.setModel(scml.getAllStudentBySectionId(section, schoolYear));
            
            jtblGrades.setModel(sbml.getAllStudentSubjectBySectionId(section));
            //Hide first column
            jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
            jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    
    
    private void computeFinal()
    {
        double finalGrade = 0;
        double grades = 0;
        double genAve = 0;
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        
        if(jtblGrades.getRowCount() != 0)
        {
            for(int row = 0; row < jtblGrades.getRowCount(); row++)
            {
                for(int column = 2; column < jtblGrades.getColumnCount() - 1; column++)
                {
                    grades = Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, column)));
                    
                    finalGrade += grades + 0.0;
                }
                jtblGrades.setValueAt(finalGrade / 4, row, 6);
                //Revert to 0.0 after loop
                finalGrade = 0.0;
                
                genAve += Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, 6)));
            }
            
            //Settext at tfGenAve
            tfGenAve.setText(df.format(genAve / jtblGrades.getRowCount()));
            
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
        jtblGrades = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tfGenAve = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 700));
        setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(null);
        jPanel9.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(null);
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 554));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel31.setBorder(null);
        jPanel31.setPreferredSize(new java.awt.Dimension(100, 218));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jlistStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistStudentMouseClicked(evt);
            }
        });
        jlistStudent.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistStudentValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jlistStudent);

        jPanel31.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel37.setBorder(null);
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

        jPanel3.setBorder(null);
        jPanel3.setPreferredSize(new java.awt.Dimension(751, 554));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel49.setBorder(null);
        jPanel49.setPreferredSize(new java.awt.Dimension(384, 544));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(null);
        jPanel5.setPreferredSize(new java.awt.Dimension(374, 50));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("REPORT CARD");
        jPanel5.add(jLabel14, new java.awt.GridBagConstraints());

        jPanel49.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel10.setBorder(null);
        jPanel10.setPreferredSize(new java.awt.Dimension(374, 384));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jtblGrades.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblGrades.setRowHeight(30);
        jtblGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblGradesMouseClicked(evt);
            }
        });
        jtblGrades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblGradesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtblGrades);
        if (jtblGrades.getColumnModel().getColumnCount() > 0) {
            jtblGrades.getColumnModel().getColumn(0).setResizable(false);
            jtblGrades.getColumnModel().getColumn(1).setResizable(false);
            jtblGrades.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblGrades.getColumnModel().getColumn(2).setResizable(false);
            jtblGrades.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(3).setResizable(false);
            jtblGrades.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(4).setResizable(false);
            jtblGrades.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(5).setResizable(false);
            jtblGrades.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(6).setResizable(false);
            jtblGrades.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel49.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel12.setBorder(null);
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

        jPanel17.setBorder(null);
        jPanel17.setPreferredSize(new java.awt.Dimension(751, 50));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        Save.setText("Save");
        Save.setMaximumSize(new java.awt.Dimension(77, 29));
        Save.setMinimumSize(new java.awt.Dimension(77, 29));
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
        jButton2.setName(""); // NOI18N
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jtblGradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblGradesMouseClicked
        
      
    }//GEN-LAST:event_jtblGradesMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        selected = jlistStudent.getSelectedValue();
        result = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
        
        //Setter call
        for(int row = 0; row < jtblGrades.getModel().getRowCount(); row++)
        {
            for(int column = 2; column < jtblGrades.getModel().getColumnCount() - 1; column++)
            {
                grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                grade.setFinalGrade(Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, 6))));
                grade.setGwa(Double.parseDouble(tfGenAve.getText()));
                grade.setGrade(Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, column))));
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

    private void jtblGradesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblGradesKeyPressed
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
    }//GEN-LAST:event_jtblGradesKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        computeFinal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbSectionListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSectionListItemStateChanged
        //Setter call from Section
        section.setSectionName((String) cbSectionList.getSelectedItem());
        section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));
        //Setter call from SchoolYear
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());

        //Set model on jlist
        jlistStudent.setModel(scml.getAllStudentBySectionId(section, schoolYear));

        //Set model on jtable
        jtblGrades.setModel(sbml.getAllStudentSubjectBySectionId(section));
        //Hide first column
        jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);

    }//GEN-LAST:event_cbSectionListItemStateChanged

    private void jlistStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistStudentMouseClicked
        
    }//GEN-LAST:event_jlistStudentMouseClicked

    private void jlistStudentValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistStudentValueChanged
        if(jlistStudent.getSelectedIndex() > 0)
        {
            selected = jlistStudent.getSelectedValue();
            result = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
            
            //Setter call from Student
            student.setStudentId(Integer.parseInt(result));
        
            if(gml.getAllStudentGradeByStudentId(student).length == 0)
            {
                //Set model on jtable
                jtblGrades.setModel(sbml.getAllStudentSubjectBySectionId(section));
                tfGenAve.setText("");
            }
            else
            {
                for(int row = 0; row < jtblGrades.getRowCount(); row++)
                {
                    for(int column = 0; column < jtblGrades.getColumnCount(); column++)
                    {
                        switch(column)
                        {
                            case 0:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 0);
                                break;
                            case 1:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 1);
                                break;
                            case 2:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 2);
                                break;
                            case 3:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 3);
                                break;
                            case 4:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 4);
                                break;
                            case 5:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 5);
                                break;
                            case 6:
                                jtblGrades.setValueAt(gml.getAllStudentGradeByStudentId(student)[row][column], row, 6);
                                break;
                        }
                    }
                }
            
                tfGenAve.setText(String.valueOf(gdi.getAllStudentGradeGWAByStudentId(student)));
            }
            
        }
        else
        {
            jtblGrades.setModel(sbml.getAllStudentSubjectBySectionId(section));
        }
        
        

        
        
        //Hide first column
        jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
    }//GEN-LAST:event_jlistStudentValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> cbSectionList;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> jlistStudent;
    private javax.swing.JTable jtblGrades;
    private javax.swing.JTextField tfGenAve;
    // End of variables declaration//GEN-END:variables
}
