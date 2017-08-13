/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.grades;

import component_model_loader.FacultyML;
import component_model_loader.GradeML;
import daoimpl.SchoolYearDaoImpl;
import model.faculty.Faculty;
import model.schoolyear.SchoolYear;
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
    
    private SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    
    String selectedFaculty;
    String selectedStudent;
    String facultyId;
    String studentId;
    
    public Adviser() {
        initComponents();
        faculty.setFacultyID(Dashboard.userId);
        jlistFaculty.setModel(fml.getAllFacultyByAdviserId(faculty));
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
        jlistStudents.setModel(gml.getAllStudentByAdviserSectionId(faculty, schoolYear));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistFaculty = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistStudents = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableGrades = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Teachers in Section"));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jlistFaculty.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistFacultyValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jlistFaculty);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Students in Section"));
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

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jtableGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grading Period", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtableGrades);
        if (jtableGrades.getColumnModel().getColumnCount() > 0) {
            jtableGrades.getColumnModel().getColumn(0).setResizable(false);
            jtableGrades.getColumnModel().getColumn(1).setResizable(false);
            jtableGrades.getColumnModel().getColumn(2).setResizable(false);
            jtableGrades.getColumnModel().getColumn(3).setResizable(false);
            jtableGrades.getColumnModel().getColumn(4).setResizable(false);
            jtableGrades.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jlistFacultyValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistFacultyValueChanged
        
            selectedFaculty = jlistFaculty.getSelectedValue();
            facultyId = selectedFaculty.substring(selectedFaculty.indexOf("(") + 1, selectedFaculty.indexOf(")"));
        
    }//GEN-LAST:event_jlistFacultyValueChanged

    private void jlistStudentsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistStudentsValueChanged
        
            selectedStudent = jlistStudents.getSelectedValue();
            studentId = selectedStudent.substring(selectedStudent.indexOf("(") + 1, selectedStudent.indexOf(")"));
            
            faculty.setFacultyID(Integer.parseInt(facultyId));
            student.setStudentId(Integer.parseInt(studentId));
            
            //Set model on jtable
            jtableGrades.setModel(gml.getStudentGradeByFacultyStudentId(faculty, student));
            //Hide first column
            jtableGrades.getColumnModel().getColumn(0).setMinWidth(0);
            jtableGrades.getColumnModel().getColumn(0).setMaxWidth(0);
        
    }//GEN-LAST:event_jlistStudentsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> jlistFaculty;
    private javax.swing.JList<String> jlistStudents;
    private javax.swing.JTable jtableGrades;
    // End of variables declaration//GEN-END:variables
}
