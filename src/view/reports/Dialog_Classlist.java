package view.reports;


public class Dialog_Classlist extends javax.swing.JDialog {

    public Dialog_Classlist(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        panel_control = new javax.swing.JPanel();
        btn_savennew = new javax.swing.JButton();
        btn_savennew1 = new javax.swing.JButton();
        panel_logocontainer = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_skulname = new javax.swing.JLabel();
        lbl_skuladdress = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_lineabove = new javax.swing.JPanel();
        panel_lineabelow = new javax.swing.JPanel();
        panel_officialcontainer = new javax.swing.JPanel();
        lbl_officialclasslst = new javax.swing.JLabel();
        lbl_sy = new javax.swing.JLabel();
        lbl_sydisplay = new javax.swing.JLabel();
        panel_control1 = new javax.swing.JPanel();
        lbl_gradelevel = new javax.swing.JLabel();
        lbl_gradelevel1 = new javax.swing.JLabel();
        lbl_gradelevel2 = new javax.swing.JLabel();
        lbl_gradelevel3 = new javax.swing.JLabel();
        lbl_gradelevel4 = new javax.swing.JLabel();
        lbl_gradelevel5 = new javax.swing.JLabel();
        lbl_gradelevel6 = new javax.swing.JLabel();
        lbl_gradelevel7 = new javax.swing.JLabel();
        lbl_gradelevel8 = new javax.swing.JLabel();
        lbl_gradelevel9 = new javax.swing.JLabel();
        lbl_gradelevel10 = new javax.swing.JLabel();
        lbl_gradelevel11 = new javax.swing.JLabel();
        panel_tablecontainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MOPH Official Class List");
        setMinimumSize(new java.awt.Dimension(600, 750));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(600, 750));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(600, 750));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_control.setMinimumSize(new java.awt.Dimension(495, 65));
        panel_control.setPreferredSize(new java.awt.Dimension(495, 65));
        panel_control.setLayout(new java.awt.GridBagLayout());

        btn_savennew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_savennew.setText("Print");
        btn_savennew.setMaximumSize(new java.awt.Dimension(102, 40));
        btn_savennew.setMinimumSize(new java.awt.Dimension(102, 40));
        btn_savennew.setPreferredSize(new java.awt.Dimension(102, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        panel_control.add(btn_savennew, gridBagConstraints);

        btn_savennew1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_savennew1.setText("Save as PDF");
        btn_savennew1.setMaximumSize(new java.awt.Dimension(115, 40));
        btn_savennew1.setMinimumSize(new java.awt.Dimension(115, 40));
        btn_savennew1.setPreferredSize(new java.awt.Dimension(115, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panel_control.add(btn_savennew1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 3);
        panel_toppanel.add(panel_control, gridBagConstraints);

        panel_logocontainer.setMinimumSize(new java.awt.Dimension(495, 105));
        panel_logocontainer.setPreferredSize(new java.awt.Dimension(495, 105));
        panel_logocontainer.setLayout(new java.awt.GridBagLayout());

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo2.png"))); // NOI18N
        lbl_logo.setMaximumSize(new java.awt.Dimension(90, 100));
        lbl_logo.setMinimumSize(new java.awt.Dimension(90, 100));
        lbl_logo.setPreferredSize(new java.awt.Dimension(90, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panel_logocontainer.add(lbl_logo, gridBagConstraints);

        lbl_skulname.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_skulname.setForeground(new java.awt.Color(0, 102, 255));
        lbl_skulname.setText("Mother of Perpetual Help School");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 0);
        panel_logocontainer.add(lbl_skulname, gridBagConstraints);

        lbl_skuladdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_skuladdress.setText("Iris Street, Dahlia, West Fairview, Quezon City\n");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panel_logocontainer.add(lbl_skuladdress, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("1118 Metro Manila, Philippines");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panel_logocontainer.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panel_toppanel.add(panel_logocontainer, gridBagConstraints);

        panel_lineabove.setBackground(new java.awt.Color(51, 51, 51));
        panel_lineabove.setMinimumSize(new java.awt.Dimension(0, 2));
        panel_lineabove.setPreferredSize(new java.awt.Dimension(600, 2));

        javax.swing.GroupLayout panel_lineaboveLayout = new javax.swing.GroupLayout(panel_lineabove);
        panel_lineabove.setLayout(panel_lineaboveLayout);
        panel_lineaboveLayout.setHorizontalGroup(
            panel_lineaboveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        panel_lineaboveLayout.setVerticalGroup(
            panel_lineaboveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        panel_toppanel.add(panel_lineabove, gridBagConstraints);

        panel_lineabelow.setBackground(new java.awt.Color(51, 51, 51));
        panel_lineabelow.setMinimumSize(new java.awt.Dimension(0, 2));
        panel_lineabelow.setPreferredSize(new java.awt.Dimension(600, 2));

        javax.swing.GroupLayout panel_lineabelowLayout = new javax.swing.GroupLayout(panel_lineabelow);
        panel_lineabelow.setLayout(panel_lineabelowLayout);
        panel_lineabelowLayout.setHorizontalGroup(
            panel_lineabelowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        panel_lineabelowLayout.setVerticalGroup(
            panel_lineabelowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        panel_toppanel.add(panel_lineabelow, gridBagConstraints);

        panel_officialcontainer.setMinimumSize(new java.awt.Dimension(0, 45));
        panel_officialcontainer.setPreferredSize(new java.awt.Dimension(0, 45));
        panel_officialcontainer.setLayout(new java.awt.GridBagLayout());

        lbl_officialclasslst.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_officialclasslst.setText("OFFICIAL CLASS LIST (Regular)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panel_officialcontainer.add(lbl_officialclasslst, gridBagConstraints);

        lbl_sy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_sy.setText("SCHOOL YEAR :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel_officialcontainer.add(lbl_sy, gridBagConstraints);

        lbl_sydisplay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_sydisplay.setText("2017-2018");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 20);
        panel_officialcontainer.add(lbl_sydisplay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel_toppanel.add(panel_officialcontainer, gridBagConstraints);

        panel_control1.setMinimumSize(new java.awt.Dimension(495, 55));
        panel_control1.setPreferredSize(new java.awt.Dimension(495, 55));
        panel_control1.setLayout(new java.awt.GridBagLayout());

        lbl_gradelevel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel.setText("Subject Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_control1.add(lbl_gradelevel, gridBagConstraints);

        lbl_gradelevel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel1.setText("Subject Code :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        panel_control1.add(lbl_gradelevel1, gridBagConstraints);

        lbl_gradelevel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel2.setText("English");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control1.add(lbl_gradelevel2, gridBagConstraints);

        lbl_gradelevel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel3.setText("G1English");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control1.add(lbl_gradelevel3, gridBagConstraints);

        lbl_gradelevel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel4.setText("Teacher :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        panel_control1.add(lbl_gradelevel4, gridBagConstraints);

        lbl_gradelevel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel5.setText("Mrs. Tan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control1.add(lbl_gradelevel5, gridBagConstraints);

        lbl_gradelevel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel6.setText("Section :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panel_control1.add(lbl_gradelevel6, gridBagConstraints);

        lbl_gradelevel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel7.setText("Mars");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panel_control1.add(lbl_gradelevel7, gridBagConstraints);

        lbl_gradelevel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel8.setText("Session :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panel_control1.add(lbl_gradelevel8, gridBagConstraints);

        lbl_gradelevel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel9.setText("AM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panel_control1.add(lbl_gradelevel9, gridBagConstraints);

        lbl_gradelevel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_gradelevel10.setText("Session :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panel_control1.add(lbl_gradelevel10, gridBagConstraints);

        lbl_gradelevel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel11.setText("Mrs. Chuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panel_control1.add(lbl_gradelevel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        panel_toppanel.add(panel_control1, gridBagConstraints);

        panel_tablecontainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_tablecontainer.setMinimumSize(new java.awt.Dimension(495, 100));
        panel_tablecontainer.setPreferredSize(new java.awt.Dimension(495, 100));
        panel_tablecontainer.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Student ID", "Last Name", "First Name", "Middle Name"
            }
        ));
        jTable1.setIntercellSpacing(new java.awt.Dimension(16, 1));
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        panel_tablecontainer.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        panel_toppanel.add(panel_tablecontainer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(panel_toppanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_savennew;
    private javax.swing.JButton btn_savennew1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_gradelevel;
    private javax.swing.JLabel lbl_gradelevel1;
    private javax.swing.JLabel lbl_gradelevel10;
    private javax.swing.JLabel lbl_gradelevel11;
    private javax.swing.JLabel lbl_gradelevel2;
    private javax.swing.JLabel lbl_gradelevel3;
    private javax.swing.JLabel lbl_gradelevel4;
    private javax.swing.JLabel lbl_gradelevel5;
    private javax.swing.JLabel lbl_gradelevel6;
    private javax.swing.JLabel lbl_gradelevel7;
    private javax.swing.JLabel lbl_gradelevel8;
    private javax.swing.JLabel lbl_gradelevel9;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_officialclasslst;
    private javax.swing.JLabel lbl_skuladdress;
    private javax.swing.JLabel lbl_skulname;
    private javax.swing.JLabel lbl_sy;
    private javax.swing.JLabel lbl_sydisplay;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_control1;
    private javax.swing.JPanel panel_lineabelow;
    private javax.swing.JPanel panel_lineabove;
    private javax.swing.JPanel panel_logocontainer;
    private javax.swing.JPanel panel_officialcontainer;
    private javax.swing.JPanel panel_tablecontainer;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
