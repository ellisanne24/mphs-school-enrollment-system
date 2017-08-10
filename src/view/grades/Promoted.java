/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.grades;

import component_model_loader.GradeLevelML;
import component_model_loader.GradeML;
import component_renderers.GradeLevelJComboBoxRenderer;
import daoimpl.SchoolYearDaoImpl;
import model.schoolyear.SchoolYear;


/**
 *
 * @author francisunoxx
 */
public class Promoted extends javax.swing.JPanel {
    
    GradeML gml = new GradeML();
    SchoolYear schoolYear = new SchoolYear();
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
    public Promoted() {
        initComponents();
        jComboBox1.setModel(new GradeLevelML().getAllGradeLevels());
        jComboBox1.setRenderer(new GradeLevelJComboBoxRenderer());
        schoolYear.setSchoolYearId(sydi.getCurrentSchoolYearId());
        tblPromoted.setModel(gml.getAllPromotedStudent(schoolYear));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPromoted = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        tblPromoted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Number", "Student Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPromoted.setRowHeight(30);
        jScrollPane1.setViewportView(tblPromoted);
        if (tblPromoted.getColumnModel().getColumnCount() > 0) {
            tblPromoted.getColumnModel().getColumn(0).setResizable(false);
            tblPromoted.getColumnModel().getColumn(1).setResizable(false);
            tblPromoted.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Open");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel3.add(jButton1, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Grade Level:");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jPanel1.add(jComboBox1, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPromoted;
    // End of variables declaration//GEN-END:variables
}
