/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import daoimpl.HolidayDaoImpl;
import static gui.SchoolYearManagementContainer.jlstHolidays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import model.Holiday;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AddHolidayToSchoolYear extends javax.swing.JDialog {

    private HolidayDaoImpl hdi = new HolidayDaoImpl();
    
    public AddHolidayToSchoolYear(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadExistingHolidays();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jlstHolidaySource = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jbtnAddHoliday = new javax.swing.JButton();
        jbtnRemoveHoliday = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstHolidayDestination = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jbtnOkay = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(70, 147));

        jScrollPane1.setViewportView(jlstHolidaySource);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jbtnAddHoliday.setText("Add");
        jbtnAddHoliday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddHolidayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jbtnAddHoliday, gridBagConstraints);

        jbtnRemoveHoliday.setText("Remove");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jbtnRemoveHoliday, gridBagConstraints);

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(70, 147));

        jScrollPane2.setViewportView(jlstHolidayDestination);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jbtnOkay.setText("OK");
        jbtnOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOkayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jbtnOkay, gridBagConstraints);

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        jPanel2.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void loadExistingHolidays(){
        List<Holiday> holidays = hdi.get();
        DefaultListModel dlm = new DefaultListModel();
        for(Holiday h : holidays){
            dlm.addElement(h.getName());
        }
        jlstHolidaySource.setModel(dlm);
    }
    
    private void jbtnAddHolidayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddHolidayActionPerformed
        int countOfSelected = jlstHolidaySource.getSelectedIndices().length;
        DefaultListModel dlm = new DefaultListModel();
        if (countOfSelected > 1) {
            List<String> holidays = jlstHolidaySource.getSelectedValuesList();
            for (String s : holidays) {
                dlm.addElement(s);
            }
            jlstHolidayDestination.setModel(dlm);
        } else {
            String selectedValue = jlstHolidaySource.getSelectedValue();
            dlm.addElement(selectedValue);
            jlstHolidayDestination.setModel(dlm);
        }
        
        
    }//GEN-LAST:event_jbtnAddHolidayActionPerformed

    private void jbtnOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOkayActionPerformed
        List<String> holidays = jlstHolidaySource.getSelectedValuesList();
        DefaultListModel dlm = new DefaultListModel();
        for(String s : holidays){
            dlm.addElement(s);
        }
        
        jlstHolidays.setModel(dlm);
        this.dispose();
    }//GEN-LAST:event_jbtnOkayActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAddHoliday;
    private javax.swing.JButton jbtnOkay;
    private javax.swing.JButton jbtnRemoveHoliday;
    private javax.swing.JList<String> jlstHolidayDestination;
    private javax.swing.JList<String> jlstHolidaySource;
    // End of variables declaration//GEN-END:variables
}
