package view.reports;


public class Dialog_GenerateClasslist extends javax.swing.JDialog {

    /**
     * Creates new form dialog_generateclasslist
     */
    public Dialog_GenerateClasslist(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_roombldg = new javax.swing.JLabel();
        combo_status1 = new javax.swing.JComboBox<>();
        lbl_roombldg1 = new javax.swing.JLabel();
        combo_status2 = new javax.swing.JComboBox<>();
        lbl_roombldg2 = new javax.swing.JLabel();
        combo_status3 = new javax.swing.JComboBox<>();
        lbl_roombldg3 = new javax.swing.JLabel();
        combo_status4 = new javax.swing.JComboBox<>();
        lbl_roombldg4 = new javax.swing.JLabel();
        combo_status5 = new javax.swing.JComboBox<>();
        lbl_roombldg5 = new javax.swing.JLabel();
        combo_status6 = new javax.swing.JComboBox<>();
        lbl_roombldg6 = new javax.swing.JLabel();
        combo_status7 = new javax.swing.JComboBox<>();
        panel_footer = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_cancel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Class List");
        setMinimumSize(new java.awt.Dimension(300, 410));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(300, 410));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(300, 410));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(300, 410));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbl_roombldg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg.setText("Faculty :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg, gridBagConstraints);

        combo_status1.setEditable(true);
        combo_status1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Regular", "Summer" }));
        combo_status1.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status1.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status1, gridBagConstraints);

        lbl_roombldg1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg1.setText("Subject Code :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg1, gridBagConstraints);

        combo_status2.setEditable(true);
        combo_status2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        combo_status2.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status2.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status2, gridBagConstraints);

        lbl_roombldg2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg2.setText("Section :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg2, gridBagConstraints);

        combo_status3.setEditable(true);
        combo_status3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        combo_status3.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status3.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status3, gridBagConstraints);

        lbl_roombldg3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg3.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg3, gridBagConstraints);

        combo_status4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        combo_status4.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status4.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status4, gridBagConstraints);

        lbl_roombldg4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg4.setText("Session :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg4, gridBagConstraints);

        combo_status5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        combo_status5.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status5.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status5, gridBagConstraints);

        lbl_roombldg5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg5.setText("Adviser :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg5, gridBagConstraints);

        combo_status6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        combo_status6.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status6.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status6, gridBagConstraints);

        lbl_roombldg6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_roombldg6.setText("Class Type: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(lbl_roombldg6, gridBagConstraints);

        combo_status7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_status7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        combo_status7.setMinimumSize(new java.awt.Dimension(150, 25));
        combo_status7.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 8, 0);
        jPanel1.add(combo_status7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        panel_toppanel.add(jPanel1, gridBagConstraints);

        panel_footer.setMinimumSize(new java.awt.Dimension(550, 100));
        panel_footer.setPreferredSize(new java.awt.Dimension(550, 100));
        panel_footer.setLayout(new java.awt.GridBagLayout());

        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel.setText("Generate Class List");
        btn_cancel.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_cancel.setMinimumSize(new java.awt.Dimension(200, 50));
        btn_cancel.setPreferredSize(new java.awt.Dimension(200, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        panel_footer.add(btn_cancel, gridBagConstraints);

        btn_cancel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel1.setText("Cancel");
        btn_cancel1.setMaximumSize(new java.awt.Dimension(200, 50));
        btn_cancel1.setMinimumSize(new java.awt.Dimension(200, 50));
        btn_cancel1.setPreferredSize(new java.awt.Dimension(200, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        panel_footer.add(btn_cancel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 30, 0);
        panel_toppanel.add(panel_footer, gridBagConstraints);

        getContentPane().add(panel_toppanel, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_cancel1;
    private javax.swing.JComboBox<String> combo_status1;
    private javax.swing.JComboBox<String> combo_status2;
    private javax.swing.JComboBox<String> combo_status3;
    private javax.swing.JComboBox<String> combo_status4;
    private javax.swing.JComboBox<String> combo_status5;
    private javax.swing.JComboBox<String> combo_status6;
    private javax.swing.JComboBox<String> combo_status7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_roombldg;
    private javax.swing.JLabel lbl_roombldg1;
    private javax.swing.JLabel lbl_roombldg2;
    private javax.swing.JLabel lbl_roombldg3;
    private javax.swing.JLabel lbl_roombldg4;
    private javax.swing.JLabel lbl_roombldg5;
    private javax.swing.JLabel lbl_roombldg6;
    private javax.swing.JPanel panel_footer;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
