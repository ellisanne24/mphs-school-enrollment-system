
package view.enrollment;

import component_model_loader.GradeLevelML;
import component_model_loader.GradeML;
import component_model_loader.StudentML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.GradeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SubjectDaoImpl;
import javax.swing.JOptionPane;
import model.student.Student;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;

/**
 *
 * @author francisunoxx
 */
public class Promotion extends javax.swing.JPanel {

    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    SubjectDaoImpl sdi = new SubjectDaoImpl();
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    GradeDaoImpl gdi = new GradeDaoImpl();

    GradeLevelML glml = new GradeLevelML();
    StudentML studentML = new StudentML();
    GradeML gml = new GradeML();

    Grade grade = new Grade();
    Subject subject = new Subject();
    GradeLevel gradeLevel = new GradeLevel();
    SchoolYear schoolYear = new SchoolYear();
    Student student = new Student();

    public Promotion() {
        initComponents();
        cbGradeLevelPromotion.setModel(glml.getAllGradeLevels());
        cbGradeLevelPromotion.setRenderer(new GradeLevelJComboBoxRenderer());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel42 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbGradeLevelPromotion = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPromotion = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Controls"));
        jPanel38.setPreferredSize(new java.awt.Dimension(950, 50));
        jPanel38.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Grade Level:");
        jPanel38.add(jLabel6, new java.awt.GridBagConstraints());

        cbGradeLevelPromotion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGradeLevelPromotionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel38.add(cbGradeLevelPromotion, gridBagConstraints);

        jPanel42.add(jPanel38, java.awt.BorderLayout.NORTH);

        jPanel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel44.setPreferredSize(new java.awt.Dimension(950, 454));
        jPanel44.setLayout(new java.awt.BorderLayout());

        jPanel45.setLayout(new java.awt.BorderLayout());

        tblPromotion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student Number", "Student Name", "Grade Level", "General Average", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPromotion.setRowHeight(30);
        jScrollPane6.setViewportView(tblPromotion);
        if (tblPromotion.getColumnModel().getColumnCount() > 0) {
            tblPromotion.getColumnModel().getColumn(0).setResizable(false);
            tblPromotion.getColumnModel().getColumn(1).setResizable(false);
            tblPromotion.getColumnModel().getColumn(2).setResizable(false);
            tblPromotion.getColumnModel().getColumn(3).setResizable(false);
            tblPromotion.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel45.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jScrollPane5.setViewportView(jPanel45);

        jPanel44.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel42.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel46.setPreferredSize(new java.awt.Dimension(950, 50));
        jPanel46.setLayout(new java.awt.GridBagLayout());

        jButton5.setText("Promote All");
        jButton5.setPreferredSize(new java.awt.Dimension(130, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel46.add(jButton5, gridBagConstraints);

        jPanel42.add(jPanel46, java.awt.BorderLayout.SOUTH);

        add(jPanel42, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbGradeLevelPromotionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGradeLevelPromotionItemStateChanged
        //Setter call from GradeLevel
        gradeLevel.setLevel((Integer) cbGradeLevelPromotion.getSelectedItem());
        gradeLevel.setId(gldi.getId(gradeLevel));
        //Setter call from SchoolYear
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());

        //Set model on tblPromotion
        tblPromotion.setModel(gml.getAllStudentRemarksByGradeLevelId(gradeLevel, schoolYear));
    }//GEN-LAST:event_cbGradeLevelPromotionItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        for (int y = 0; y < tblPromotion.getRowCount(); y++) {
            if (tblPromotion.getValueAt(y, 4) == "Failed") {
                student.setStudentId((int) tblPromotion.getValueAt(y, 0));

                gradeLevel.setLevel((Integer) tblPromotion.getValueAt(y, 2));
                gradeLevel.setId(gldi.getId(gradeLevel));

                grade.setIsPassed(false);

                System.out.println("SC ID" + grade.schoolYear.getSchoolYearId());
                System.out.println("STUD ID" + grade.student.getStudentId());
                System.out.println("GRADE ID " + grade.gradeLevel.getId());

                //Method call
                if (gdi.promoteStudentById(grade, gradeLevel, student, schoolYear) == true) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                }
            } else {
                student.setStudentId((int) tblPromotion.getValueAt(y, 0));

                gradeLevel.setLevel((Integer) tblPromotion.getValueAt(y, 2));
                gradeLevel.setId(gldi.getId(gradeLevel));

                grade.setIsPassed(true);

                System.out.println(gradeLevel.getId());

                //Method call
                if (gdi.promoteStudentById(grade, gradeLevel, student, schoolYear) == true) {
                    JOptionPane.showMessageDialog(null, "Successful!");
                }
            }
        }
//            JComboBox combo = new JComboBox(glml.getAllGradeLevels());
//            combo.setEditable(true);
//            
//            JOptionPane.showMessageDialog(null, combo, "Select Grade Level", JOptionPane.QUESTION_MESSAGE);
//            int reply = JOptionPane.showConfirmDialog(null, "Confirm?", "", JOptionPane.YES_NO_OPTION);

//            if(reply == JOptionPane.YES_NO_OPTION)
//            {

    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGradeLevelPromotion;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblPromotion;
    // End of variables declaration//GEN-END:variables
}