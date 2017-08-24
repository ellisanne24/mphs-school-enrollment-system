/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.grades;

import component_model_loader.FacultyML;
import component_model_loader.GradeML;
//import component_renderers.MultipleLineRenderer;
import daoimpl.GradeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import view.container.Dashboard;

/**
 *
 * @author francisunoxx
 */
public class Adviser extends javax.swing.JPanel {

    private FacultyML fml = new FacultyML();
    private GradeML gml = new GradeML();
    
    private Student student = new Student();
    private Faculty faculty = new Faculty();
    private SchoolYear schoolYear = new SchoolYear();
    private GradeLevel gradeLevel = new GradeLevel();
    private SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    private Section section = new Section();
    private Grade grade = new Grade();
    
//    private MultipleLineRenderer renderer = new MultipleLineRenderer();
    
    private GradeDaoImpl gdi = new GradeDaoImpl();
    private SectionDaoImpl sdi = new SectionDaoImpl();
    
    String selectedFaculty;
    String selectedStudent;
    String facultyId;
    String studentId;
    
    public Adviser() {
        initComponents();
        
//        faculty.setFacultyID(Dashboard.userId);
        
        //To be produce
        faculty.setFacultyID(Dashboard.adviserId);
        jPanel4.setBorder(new TitledBorder("Section "+gdi.getAdviserSectionByAdviserId(faculty)));
        
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
        jlistStudents.setModel(gml.getAllStudentByAdviserSectionId(faculty, schoolYear));
        
        
        jtableGrades.getColumnModel().getColumn(0).setMinWidth(0);
        jtableGrades.getColumnModel().getColumn(0).setMaxWidth(0);
        
//        section.setSectionName(gdi.getAdviserSectionByAdviserId(faculty));
//        section.setSectionId(sdi.getSectionId(section));
        
        
//        if(sdi.getGradeLevelOfSectionByAdviserId(section) == 0)
//        {
//            jtableCharacter.setModel(gml.getAllKinderCharBuilding(gradeLevel, section));
//            
//            TableColumnModel tcm = jtableCharacter.getColumnModel();
//            TableColumn tc1 = tcm.getColumn(2);
//            TableColumn tc2 = tcm.getColumn(3);
//            TableColumn tc3 = tcm.getColumn(4);
//            TableColumn tc4 = tcm.getColumn(5);
//            //Setting jspinner editor at desired column
//            tc1.setCellEditor(new LetterCellEditor());
//            tc2.setCellEditor(new LetterCellEditor());
//            tc3.setCellEditor(new LetterCellEditor());
//            tc4.setCellEditor(new LetterCellEditor());
//        }
//        else
//        {
//            jtableCharacter.setModel(gml.getAllGradeSchCharBuilding(gradeLevel, section));
//            jtableCharacter.setDefaultRenderer(String[].class, renderer);
//            jtableCharacter.getColumnModel().getColumn(1).setCellRenderer(renderer);
//            
//            TableColumnModel tcm = jtableCharacter.getColumnModel();
//            TableColumn tc1 = tcm.getColumn(2);
//            TableColumn tc2 = tcm.getColumn(3);
//            TableColumn tc3 = tcm.getColumn(4);
//            TableColumn tc4 = tcm.getColumn(5);
//            //Setting jspinner editor at desired column
//            tc1.setCellEditor(new LetterCellEditor());
//            tc2.setCellEditor(new LetterCellEditor());
//            tc3.setCellEditor(new LetterCellEditor());
//            tc4.setCellEditor(new LetterCellEditor());
//        }
//        
//        jtableAttendance.setModel(gml.getAttendanceModel());
//        adjustTableColumn();
    }

//    private void adjustTableColumn()
//    {
//        TableColumn tblColumn;
//        
//        for(int i = 0; i < jtableAttendance.getColumnCount(); i++)
//        {
//            tblColumn = jtableAttendance.getColumnModel().getColumn(i);
//            
//            if(i == 0)
//            {
//                tblColumn.setPreferredWidth(300);
//            }
//        }
//    }
    
    private void computeGWA()
    {
        double gwa = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        
        try
        {
            for(int i = 0; i < jtableGrades.getRowCount(); i++)
            {
                if(jtableGrades.getValueAt(i, 6) != null)
                {
                    gwa += Double.parseDouble(String.valueOf(jtableGrades.getValueAt(i, 6)));
                }
            }
            tfGWA.setText(df.format(gwa / jtableGrades.getRowCount()));
        }
        catch(NumberFormatException ex)
        {
        }
    }
    
//    private void loopThroughAttendance(int row, int column)
//    {
////        grade.attendance.setType(1);
//        try
//        {
//        if(column == 1)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                //Jun
//                grade.attendance.setId(1);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                //Jun
//                grade.attendance.setId(1);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 2)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(2);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(2);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 3)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(3);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(3);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 4)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(4);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(4);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 5)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(5);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(5);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 6)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(6);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(6);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 7)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(7);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(7);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 8)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(8);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(8);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 9)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(9);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(9);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        else if(column == 10)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setId(10);
//                grade.attendance.setDays(0);
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setId(10);
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setTotal(0);  
//            
//                gdi.createStudentAttendance(grade);
//            }
//        }
//        }
//        catch(NumberFormatException ex)
//        {
//            
//        }
//    }
//    
//    private void loopAttendanceForUpdate(int row, int column)
//    {
//        try
//        {
//        if(column == 1)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                //Jun
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(1);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                //Jun
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(1);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 2)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(2);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(2);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 3)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(3);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(3);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 4)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(4);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(4);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 5)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(5);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(5);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 6)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(6);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(6);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 7)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(7);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(7);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 8)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(8);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(8);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 9)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(9);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(9);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        else if(column == 10)
//        {
//            if(jtableAttendance.getValueAt(row, column) == null)
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(10);
//                gdi.updateStudentAttendance(grade);
//            }
//            else
//            {
//                grade.attendance.setDays(Integer.parseInt((String) jtableAttendance.getValueAt(row, column)));
//                grade.attendance.setId(10);
//                gdi.updateStudentAttendance(grade);
//            }
//        }
//        }
//        catch(NumberFormatException ex)
//        {
//            
//        }
//   
//    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistStudents = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableGrades = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfGWA = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jlistStudents.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistStudentsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlistStudents);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel10.add(btnSubmit, gridBagConstraints);

        jPanel3.add(jPanel10, java.awt.BorderLayout.SOUTH);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodic Rating"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 200));

        jtableGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Id", "Learning Areas", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableGrades.setRowHeight(30);
        jScrollPane2.setViewportView(jtableGrades);
        if (jtableGrades.getColumnModel().getColumnCount() > 0) {
            jtableGrades.getColumnModel().getColumn(0).setResizable(false);
            jtableGrades.getColumnModel().getColumn(1).setResizable(false);
            jtableGrades.getColumnModel().getColumn(2).setResizable(false);
            jtableGrades.getColumnModel().getColumn(3).setResizable(false);
            jtableGrades.getColumnModel().getColumn(4).setResizable(false);
            jtableGrades.getColumnModel().getColumn(5).setResizable(false);
            jtableGrades.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("General Average:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel7.add(jLabel1, gridBagConstraints);

        tfGWA.setEditable(false);
        tfGWA.setPreferredSize(new java.awt.Dimension(50, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel7.add(tfGWA, gridBagConstraints);

        jPanel5.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel2, java.awt.BorderLayout.CENTER);

        jScrollPane5.setViewportView(jPanel8);

        add(jScrollPane5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jlistStudentsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistStudentsValueChanged
        if(jlistStudents.getSelectedIndex() >= 0)
        {
            selectedStudent = jlistStudents.getSelectedValue();
            studentId = selectedStudent.substring(selectedStudent.indexOf("(") + 1, selectedStudent.indexOf(")"));
            
//            faculty.setFacultyID(Integer.parseInt(facultyId));
            student.setStudentId(Integer.parseInt(studentId));
            grade.student.setStudentId(Integer.parseInt(studentId));
            
//            if(sdi.getGradeLevelOfSectionByAdviserId(section) == 0)
//            {
//            
//                
//            }
//            else
//            {
//                if(gdi.getCharBuildingByStudentId(grade).size() == 0 &&
//                   gdi.getStudentAttendanceBySchoolDays(grade).size() == 0)
//                {
//                    jtableCharacter.setModel(gml.getAllGradeSchCharBuilding(gradeLevel, section));
//                    jtableCharacter.setDefaultRenderer(String[].class, renderer);
//                    jtableCharacter.getColumnModel().getColumn(1).setCellRenderer(renderer);
//
//                    TableColumnModel tcm = jtableCharacter.getColumnModel();
//                    TableColumn tc1 = tcm.getColumn(2);
//                    TableColumn tc2 = tcm.getColumn(3);
//                    TableColumn tc3 = tcm.getColumn(4);
//                    TableColumn tc4 = tcm.getColumn(5);
//                    //Setting jspinner editor at desired column
//                    tc1.setCellEditor(new LetterCellEditor());
//                    tc2.setCellEditor(new LetterCellEditor());
//                    tc3.setCellEditor(new LetterCellEditor());
//                    tc4.setCellEditor(new LetterCellEditor());
//                    
//                    jtableAttendance.setModel(gml.getAttendanceModel());
//                }
//                else
//                {
//                    //JtableCharacter
//                    for(int x = 0; x < jtableCharacter.getRowCount(); x++)
//                    {
//                        for(int y = 2; y < jtableCharacter.getColumnCount(); y++)
//                        {
//                            jtableCharacter.setValueAt(gml.getCharBuildingByStudentId(grade)[x][y], x, y);
//                        }
//                    }
//                    
////                    jtableCharacter.setModel(gml.getCharBuildingByStudentId(grade));
////                    jtableAttendance.setModel(gml.getAllStudentAttendanceByStudentId(grade));
//                }
//            }
            
            //Set model on jtable
            jtableGrades.setModel(gml.getStudentGradeByAdviserStudentId(faculty, student));

            //Hide first column
            jtableGrades.getColumnModel().getColumn(0).setMinWidth(0);
            jtableGrades.getColumnModel().getColumn(0).setMaxWidth(0);
            
            computeGWA();
            
            
            
        }
    }//GEN-LAST:event_jlistStudentsValueChanged

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if(jlistStudents.getSelectedIndex() >= 0)
        {
            grade.student.setStudentId(Integer.parseInt(studentId));
            grade.setGwa(Double.parseDouble(tfGWA.getText()));
            grade.schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());

            gdi.submitStudentGradeGWA(grade);

            JOptionPane.showMessageDialog(null, "Successful!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No student selected!");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> jlistStudents;
    private javax.swing.JTable jtableGrades;
    private javax.swing.JTextField tfGWA;
    // End of variables declaration//GEN-END:variables
}
