/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.grades;

import component_model_loader.GradeLevelML;
import component_model_loader.GradeML;
import component_model_loader.StudentML;
import daoimpl.GradeLevelDaoImpl;

/**
 *
 * @author francisunoxx
 */
public class TOR extends javax.swing.JPanel {
    
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    
    GradeLevelML glml = new GradeLevelML();
    GradeML gml = new GradeML();
    StudentML sml = new StudentML();
    public TOR() {
        initComponents();
        cbGradeLevel.setModel(glml.getAllGradeLevels());
        jlistStudent.setModel(sml.getAllStudent());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbGradeLevel = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistStudent = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblStudentName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Grade Level:");
        jPanel5.add(jLabel2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel5.add(cbGradeLevel, gridBagConstraints);

        jPanel3.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jlistStudent);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        lblStudentName.setText("Student Name:");
        jPanel7.add(lblStudentName, new java.awt.GridBagConstraints());

        jLabel1.setText("Student Number:");
        jPanel7.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Grade Level", "Year", "Subjects", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading", "Final", "GWA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(650, 50));

        jButton1.setText("Generate Report");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGradeLevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> jlistStudent;
    private javax.swing.JLabel lblStudentName;
    // End of variables declaration//GEN-END:variables
}
