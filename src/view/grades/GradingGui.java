package view.grades;

//import component_editor.LetterCellEditor;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.faculty.Faculty;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import model.subject.Subject;
import view.container.Dashboard;

public class GradingGui extends javax.swing.JPanel {

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
    Faculty faculty = new Faculty();

    List<Object> gradingPeriodList = new ArrayList();
    List<Object> isSubmittedList = new ArrayList();

    String selected;
    String result;
    double gwa;

    public GradingGui() {
        initComponents();
        jTabbedPane1.add(new Adviser(), "My Advisory");

        faculty.setFacultyID(Dashboard.facultyId);
        cbSectionList.setModel(fml.getAllFacultySectionByFacultyId(faculty));

//        jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
//        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
//        jtblGrades.getColumnModel().getColumn(0).setMinWidth(1);
//        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(1);
//        jtblGrades.getColumnModel().getColumn(0).setMinWidth(2);
//        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(2);
//        
        if (cbSectionList.getSelectedIndex() == 0) {
            section.setSectionName((String) cbSectionList.getSelectedItem());
            section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));

            //Setter call from SchoolYear
            schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());

            //Method call from GradeDaoImpl
            if (gdi.getGradeLevelOfSectionId(section) == "0") {
                jtblGrades.setModel(gml.getAllKinderGradeBySectionId(section, faculty));
                //Hide first column
                jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
                jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
                jtblGrades.getColumnModel().getColumn(1).setMinWidth(1);
                jtblGrades.getColumnModel().getColumn(1).setMaxWidth(1);
                jtblGrades.getColumnModel().getColumn(2).setMinWidth(2);
                jtblGrades.getColumnModel().getColumn(2).setMaxWidth(2);
                jtblGrades.getModel().addTableModelListener(new TblGradesListener());

                TableColumnModel tcm = jtblGrades.getColumnModel();
                TableColumn tc1 = tcm.getColumn(4);
                TableColumn tc2 = tcm.getColumn(5);
                TableColumn tc3 = tcm.getColumn(6);
                TableColumn tc4 = tcm.getColumn(7);
                //Setting jspinner editor at desired column
//                tc1.setCellEditor(new LetterCellEditor());
//                tc2.setCellEditor(new LetterCellEditor());
//                tc3.setCellEditor(new LetterCellEditor());
//                tc4.setCellEditor(new LetterCellEditor());
            } else {
                jtblGrades.setModel(gml.getAllGradeSchGradeBySectionId(section, faculty, grade));
                //Hide first column
                jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
                jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
                jtblGrades.getColumnModel().getColumn(1).setMinWidth(1);
                jtblGrades.getColumnModel().getColumn(1).setMaxWidth(1);
                jtblGrades.getColumnModel().getColumn(2).setMinWidth(2);
                jtblGrades.getColumnModel().getColumn(2).setMaxWidth(2);
                jtblGrades.getModel().addTableModelListener(new TblGradesListener());
            }

//            getCurrentPeriodByStudentId(grade);
        }
    }

    @SuppressWarnings("unchecked")

    private void computeFinal() {
        double finalGrade = 0;
        double grades = 0;
        double genAve = 0;
        int counter = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        try {
            for (int row = 0; row < jtblGrades.getRowCount(); row++) {
                for (int column = 5; column < jtblGrades.getColumnCount() - 1; column++) {
                    if (jtblGrades.getValueAt(row, column) != null) {
                        grades = Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, column)));
//                    counter++;
                    } else {
                        grades = 0.0;
                    }
                    finalGrade += grades + 0.0;
                }
                jtblGrades.setValueAt(finalGrade / 4, row, 9);

                if (jtblGrades.getValueAt(row, 6) != null) {
                    genAve += Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, 9)));
                    gwa = Double.parseDouble(df.format(genAve / jtblGrades.getRowCount()));
                }
//            if(counter == 4)
//            {
//                jtblGrades.setValueAt(finalGrade / 4, row, 8);
//                
//                //Collect all value that is not null at column 6
//                if(jtblGrades.getValueAt(row, 6) != null)
//                {
//                    genAve += Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, 6)));
//                }
//                
//                //Set text to the last loop
//                if(row == jtblGrades.getRowCount() - 1)
//                {
//                    //Settext at tfGenAve
////                    tfGenAve.setText(df.format(genAve / jtblGrades.getRowCount()));
//                }
//                
//            }
                //Revert to 0.0 after loop
                finalGrade = 0.0;
//            counter = 0;
            }
        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "HAHA");
        }
    }

//    private void getCurrentPeriodByStudentId(Grade aGrade)
//    {
//        Object[] obj = gdi.getCurrentPeriodByStudentId(aGrade).toArray();
//        
//        for(Object o : obj)
//        {
//            Grade grade = (Grade) o;
//            
//            gradingPeriodList.add(grade.gradingPeriod.getGradingPeriod());
//            isSubmittedList.add(grade.getIsSubmitted());
//        }
//    }
    private class TblGradesListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == 5 || column == 6 || column == 7 || column == 8) {
                if (jtblGrades.getValueAt(row, 5) != ""
                        && jtblGrades.getValueAt(row, 6) != ""
                        && jtblGrades.getValueAt(row, 7) != ""
                        && jtblGrades.getValueAt(row, 8) != "") {
                    computeFinal();
                }
            }
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSectionList = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblGrades = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 700));
        setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel9.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(751, 554));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel49.setPreferredSize(new java.awt.Dimension(384, 544));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(374, 50));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Section:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel5.add(jLabel1, gridBagConstraints);

        cbSectionList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSectionListItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel5.add(cbSectionList, gridBagConstraints);

        jPanel49.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel10.setPreferredSize(new java.awt.Dimension(374, 384));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jtblGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Id", "Student Id", "Grading Id", "Student Name", "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            jtblGrades.getColumnModel().getColumn(2).setResizable(false);
            jtblGrades.getColumnModel().getColumn(3).setResizable(false);
            jtblGrades.getColumnModel().getColumn(4).setResizable(false);
            jtblGrades.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtblGrades.getColumnModel().getColumn(5).setResizable(false);
            jtblGrades.getColumnModel().getColumn(5).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(6).setResizable(false);
            jtblGrades.getColumnModel().getColumn(6).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(7).setResizable(false);
            jtblGrades.getColumnModel().getColumn(7).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(8).setResizable(false);
            jtblGrades.getColumnModel().getColumn(8).setPreferredWidth(30);
            jtblGrades.getColumnModel().getColumn(9).setResizable(false);
            jtblGrades.getColumnModel().getColumn(9).setPreferredWidth(80);
        }

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel49.add(jPanel10, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel49, gridBagConstraints);

        jPanel9.add(jPanel3, java.awt.BorderLayout.CENTER);

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

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton1, new java.awt.GridBagConstraints());

        jPanel9.add(jPanel17, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(jPanel9, gridBagConstraints);

        jTabbedPane1.addTab("My Students", jPanel7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleName("My Students");
    }// </editor-fold>//GEN-END:initComponents

    private void jtblGradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblGradesMouseClicked


    }//GEN-LAST:event_jtblGradesMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try {
            for (int x = 0; x < 5; x++) {
                if (x == 0) {
                    grade.setPeriodId(7000);

                    if (gdi.countStudentGradeByGradingId(grade) != 0) {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 5)));

                            gdi.updateGradeByStudentId(grade);
                        }
                    } else {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 5)));

                            gdi.createStudentGrade(grade);
                        }
                    }
                } else if (x == 1) {
                    grade.setPeriodId(7001);

                    if (gdi.countStudentGradeByGradingId(grade) != 0) {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 6)));

                            gdi.updateGradeByStudentId(grade);
                        }
                    } else {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 6)));

                            gdi.createStudentGrade(grade);
                        }
                    }
                } else if (x == 2) {
                    grade.setPeriodId(7002);

                    if (gdi.countStudentGradeByGradingId(grade) != 0) {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 7)));

                            gdi.updateGradeByStudentId(grade);
                        }
                    } else {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 7)));

                            gdi.createStudentGrade(grade);
                        }
                    }
                } else if (x == 3) {
                    grade.setPeriodId(7003);
                    if (gdi.countStudentGradeByGradingId(grade) != 0) {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 8)));

                            gdi.updateGradeByStudentId(grade);
                        }
                    } else {
                        for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                            grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
                            grade.setGrade(String.valueOf(jtblGrades.getValueAt(row, 8)));

                            gdi.createStudentGrade(grade);
                            gdi.updateFinalGradeByStudentId(grade);
                        }
                    }
                } else {
                    for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                        grade.setFinalGrade(Double.parseDouble(String.valueOf(jtblGrades.getValueAt(row, 9))));
                        grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));
                        gdi.updateFinalGradeByStudentId(grade);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Successful!");
        } catch (NumberFormatException ex) {
        }


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

    private void cbSectionListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSectionListItemStateChanged
        //Setter call from Section
        section.setSectionName((String) cbSectionList.getSelectedItem());
        section.setSectionId(sdi.getSectionIdByName(section.getSectionName()));
        //Setter call from SchoolYear
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());

//        //Set model on jtable
//        jtblGrades.setModel(gml.getAllStudentGradeBySectionId(section, faculty));
//        //Hide first column
//        jtblGrades.getColumnModel().getColumn(0).setMinWidth(0);
//        jtblGrades.getColumnModel().getColumn(0).setMaxWidth(0);
//        jtblGrades.getColumnModel().getColumn(1).setMinWidth(1);
//        jtblGrades.getColumnModel().getColumn(1).setMaxWidth(1);

    }//GEN-LAST:event_cbSectionListItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i = 0; i < jtblGrades.getRowCount(); i++) {
            if (jtblGrades.getValueAt(i, 4) == ""
                    && jtblGrades.getValueAt(i, 5) == ""
                    && jtblGrades.getValueAt(i, 6) == ""
                    && jtblGrades.getValueAt(i, 7) == "") {
                if (i == jtblGrades.getRowCount() - 1) {
                    JOptionPane.showMessageDialog(null, "Cannot submit empty grades!");

                }
            }
        }

        for (int x = 0; x < 4; x++) {
            if (x == 0) {
                grade.setPeriodId(7000);

                if (gdi.countIsSubmittedByGradingId(grade) != 0) {
                    for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                        grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                        grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));

                        gdi.submitStudentGrade(grade);
                    }
                }
            } else if (x == 1) {
                grade.setPeriodId(7001);

                if (gdi.countIsSubmittedByGradingId(grade) != 0) {
                    for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                        grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                        grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));

                        gdi.submitStudentGrade(grade);
                    }
                }
            } else if (x == 2) {
                grade.setPeriodId(7002);

                if (gdi.countIsSubmittedByGradingId(grade) != 0) {
                    for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                        grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                        grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));

                        gdi.submitStudentGrade(grade);
                    }
                }
            } else {
                grade.setPeriodId(7003);

                if (gdi.countIsSubmittedByGradingId(grade) != 0) {
                    for (int row = 0; row < jtblGrades.getModel().getRowCount(); row++) {
                        grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 0))));
                        grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(row, 1))));

                        gdi.submitStudentGrade(grade);
                    }
                }
            }
        }

//        for(int x = 0; x < jtblGrades.getRowCount(); x++)
//        {
//            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 0))));
//            grade.gradingPeriod.setId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 2))));
//            
//            if(x == jtblGrades.getRowCount() - 1)
//            {
//            
//                if(gdi.getCurrentPeriodBySubjectId(grade) == 1 && 
//                   gdi.getPeriodStatusByGradingPeriodId(grade) == 0)
//                {   
        for (int i = 0; i < jtblGrades.getRowCount(); i++) {
            grade.gradingPeriod.setGradingPeriod(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 2))));
            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
            grade.gradingPeriod.setId(7000);

            gdi.submitStudentGrade(grade);

        }
//                }
//            }
//        }

//        for(int x = 0; x < jtblGrades.getRowCount(); x++)
//        {
//            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 0))));
//            grade.gradingPeriod.setId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 2))));
//            
//            if(x == jtblGrades.getRowCount() - 1)
//            {
//            
//                if(gdi.getCurrentPeriodBySubjectId(grade) == 2 && 
//                   gdi.getPeriodStatusByGradingPeriodId(grade) == 0)
//                {   
        for (int i = 0; i < jtblGrades.getRowCount(); i++) {
            grade.gradingPeriod.setGradingPeriod(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 2))));
            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
            grade.gradingPeriod.setId(7001);

            gdi.submitStudentGrade(grade);

        }
//                }
//            }
//        }

//        for(int x = 0; x < jtblGrades.getRowCount(); x++)
//        {
//            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 0))));
//            grade.gradingPeriod.setId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 2))));
//            
//            if(x == jtblGrades.getRowCount() - 1)
//            {
//            
//                if(gdi.getCurrentPeriodBySubjectId(grade) == 3 && 
//                   gdi.getPeriodStatusByGradingPeriodId(grade) == 0)
//                {   
        for (int i = 0; i < jtblGrades.getRowCount(); i++) {
            grade.gradingPeriod.setGradingPeriod(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 2))));
            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
            grade.gradingPeriod.setId(7002);

            gdi.submitStudentGrade(grade);

        }
//                }
//            }
//        }

//        for(int x = 0; x < jtblGrades.getRowCount(); x++)
//        {
//            grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 0))));
//            grade.gradingPeriod.setId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(x, 2))));
//            
//            if(x == jtblGrades.getRowCount() - 1)
//            {
//            
//                if(gdi.getCurrentPeriodBySubjectId(grade) == 4 && 
//                   gdi.getPeriodStatusByGradingPeriodId(grade) == 0)
//                {   
        for (int i = 0; i < jtblGrades.getRowCount(); i++) {
            grade.gradingPeriod.setGradingPeriod(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 2))));
            grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
            grade.gradingPeriod.setId(7003);

            gdi.submitStudentGrade(grade);

        }
//                }
//            }
//        }

//        else if(gdi.getCurrentPeriodBySubjectId(grade) == 2 && 
//                gdi.getPeriodStatusBySubjectId(grade) == 1)
//        { 
//            for(int i = 0; i < jtblGrades.getRowCount(); i++)
//            {
//                grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 0))));
//                grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
//            
//                grade.gradingPeriod.setId(7001);
//                
//                gdi.submitStudentGrade(grade);
//            
//                if(i == jtblGrades.getRowCount() - 1)
//                {
//                    JOptionPane.showMessageDialog(null, "Successful!");
//                }
//            }
//        }
//        else if(gdi.getCurrentPeriodBySubjectId(grade) == 3 && 
//                gdi.getPeriodStatusBySubjectId(grade) == 0)
//        { 
//            for(int i = 0; i < jtblGrades.getRowCount(); i++)
//            {
//                grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 0))));
//                grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
//            
//                grade.gradingPeriod.setId(7003);
//                
//                gdi.submitStudentGrade(grade);
//            
//                if(i == jtblGrades.getRowCount() - 1)
//                {
//                    JOptionPane.showMessageDialog(null, "Successful!");
//                }
//            }
//        }
//        else if(gdi.getCurrentPeriodBySubjectId(grade) == 4 && 
//                gdi.getPeriodStatusBySubjectId(grade) == 0)
//        { 
//            for(int i = 0; i < jtblGrades.getRowCount(); i++)
//            {
//                grade.subject.setSubjectId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 0))));
//                grade.student.setStudentId(Integer.parseInt(String.valueOf(jtblGrades.getValueAt(i, 1))));
//            
//                grade.gradingPeriod.setId(7004);
//                
//                gdi.submitStudentGrade(grade);
//            
//                if(i == jtblGrades.getRowCount() - 1)
//                {
//                    JOptionPane.showMessageDialog(null, "Successful!");
//                }
//            }
//        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> cbSectionList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtblGrades;
    // End of variables declaration//GEN-END:variables
}
