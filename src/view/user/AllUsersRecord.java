
package view.user;

import controller.user.DisplayCreateUser;
import controller.user.DisplayEditUser;
import utility.component.JInternalFrameUtil;

public class AllUsersRecord extends javax.swing.JPanel {
    public AllUsersRecord() {
        initComponents();
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        initializeControllers();
    }

    private void initializeControllers(){
        jmiNewUser.addActionListener(new DisplayCreateUser());
        jmiEditUser.addActionListener(new DisplayEditUser());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlYourContent = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbAllUsers = new javax.swing.JCheckBox();
        jcbAdministrator = new javax.swing.JCheckBox();
        jcbCashier = new javax.swing.JCheckBox();
        jcbRegistrar = new javax.swing.JCheckBox();
        jcbFaculty = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiNewUser = new javax.swing.JMenuItem();
        jmiEditUser = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlYourContent.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());
        jpnlYourContent.add(jPanel3, new java.awt.GridBagConstraints());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Sort by :");
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        buttonGroup1.add(jcbAllUsers);
        jcbAllUsers.setText("All Users");
        jPanel4.add(jcbAllUsers, new java.awt.GridBagConstraints());

        buttonGroup1.add(jcbAdministrator);
        jcbAdministrator.setText("Administrator");
        jPanel4.add(jcbAdministrator, new java.awt.GridBagConstraints());

        buttonGroup1.add(jcbCashier);
        jcbCashier.setText("Cashier");
        jPanel4.add(jcbCashier, new java.awt.GridBagConstraints());

        buttonGroup1.add(jcbRegistrar);
        jcbRegistrar.setText("Registrar");
        jPanel4.add(jcbRegistrar, new java.awt.GridBagConstraints());

        buttonGroup1.add(jcbFaculty);
        jcbFaculty.setText("Faculty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcbFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlYourContent.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Id", "Username", "Role", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlYourContent.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jpnlYourContent, gridBagConstraints);

        jMenu1.setText("File");

        jmiNewUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiNewUser.setText("New");
        jMenu1.add(jmiNewUser);

        jmiEditUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiEditUser.setText("Edit");
        jMenu1.add(jmiEditUser);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel2.add(jInternalFrame1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel1.add(jPanel2, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox jcbAdministrator;
    private javax.swing.JCheckBox jcbAllUsers;
    private javax.swing.JCheckBox jcbCashier;
    private javax.swing.JCheckBox jcbFaculty;
    private javax.swing.JCheckBox jcbRegistrar;
    private javax.swing.JMenuItem jmiEditUser;
    private javax.swing.JMenuItem jmiNewUser;
    private javax.swing.JPanel jpnlYourContent;
    // End of variables declaration//GEN-END:variables
}
