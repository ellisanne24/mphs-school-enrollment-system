/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.grades;

import java.awt.GridBagConstraints;
import utility.component.JInternalFrameUtil;
import view.container.Dashboard;

/**
 *
 * @author John Ferdinand Antonio
 */
public class GradesRecord extends javax.swing.JPanel {



    /**
     * Creates new form GradesRecord
     */
    public GradesRecord( ) {
        initComponents();
       
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        
        jpnlContent.add(new view.grades.GradingGui(),getLayoutConstraint());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jpnlContent = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Record");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Edit Selected");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jInternalFrame1, gridBagConstraints);

        jpnlContent.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade Content Here"));
        jpnlContent.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jpnlContent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private GridBagConstraints getLayoutConstraint(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        return gc;
    }
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Dashboard.jtpTopTabbedPane.remove(this);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpnlContent;
    // End of variables declaration//GEN-END:variables
}
