/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import controller.user.AddUserPermissionsPanel;
import utility.component.JInternalFrameUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class UserInfo extends javax.swing.JDialog {

    /**
     * Creates new form UserInfo
     */
    public UserInfo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initializeControllers();
    }

    private void initializeControllers(){
        jcmbUserRole.addItemListener(new AddUserPermissionsPanel(jcmbUserRole, jpnlInfo));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpnlInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcmbUserRole = new javax.swing.JComboBox<>();
        jpnlControls = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlInfo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Username ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel1, gridBagConstraints);

        jTextField1.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jTextField1, gridBagConstraints);

        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel2, gridBagConstraints);

        jPasswordField1.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jPasswordField1, gridBagConstraints);

        jLabel4.setText("First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel4, gridBagConstraints);

        jTextField2.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jTextField2, gridBagConstraints);

        jLabel6.setText("Middle Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel7, gridBagConstraints);

        jTextField3.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jTextField3, gridBagConstraints);

        jTextField4.setColumns(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jTextField4, gridBagConstraints);

        jLabel3.setText("Role ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jLabel3, gridBagConstraints);

        jcmbUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Cashier", "Registrar", "Faculty" }));
        jcmbUserRole.setSelectedIndex(-1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlInfo.add(jcmbUserRole, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlInfo, gridBagConstraints);

        jpnlControls.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setText("Cancel");
        jpnlControls.add(jbtnCancel, new java.awt.GridBagConstraints());

        jbtnSave.setText("Save");
        jpnlControls.add(jbtnSave, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlControls, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<String> jcmbUserRole;
    private javax.swing.JPanel jpnlControls;
    private javax.swing.JPanel jpnlInfo;
    // End of variables declaration//GEN-END:variables
}
