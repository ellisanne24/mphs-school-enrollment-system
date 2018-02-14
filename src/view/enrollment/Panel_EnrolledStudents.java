package view.enrollment;

public class Panel_EnrolledStudents extends javax.swing.JPanel {

    public Panel_EnrolledStudents() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        panel_control = new javax.swing.JPanel();
        Searchbox = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        lbl_show = new javax.swing.JLabel();
        combo_filter = new javax.swing.JComboBox<>();
        btn_Search1 = new javax.swing.JButton();
        lbl_show1 = new javax.swing.JLabel();
        lbl_show2 = new javax.swing.JLabel();
        btn_Search2 = new javax.swing.JButton();
        btn_Search3 = new javax.swing.JButton();
        lbl_show3 = new javax.swing.JLabel();
        combo_filter1 = new javax.swing.JComboBox<>();
        panel_masterrecord = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_control.setMinimumSize(new java.awt.Dimension(1200, 40));
        panel_control.setPreferredSize(new java.awt.Dimension(1200, 40));
        panel_control.setLayout(new java.awt.GridBagLayout());

        Searchbox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        Searchbox.setText("Search Student here...");
        Searchbox.setMinimumSize(new java.awt.Dimension(150, 30));
        Searchbox.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panel_control.add(Searchbox, gridBagConstraints);

        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        panel_control.add(btn_Search, gridBagConstraints);

        lbl_show.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show.setText("Show :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panel_control.add(lbl_show, gridBagConstraints);

        combo_filter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Sectioned", "No Section", "Kindergarten", " ", " ", " " }));
        combo_filter.setMinimumSize(new java.awt.Dimension(100, 30));
        combo_filter.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control.add(combo_filter, gridBagConstraints);

        btn_Search1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search1.setText("Sectioning");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 70, 0, 0);
        panel_control.add(btn_Search1, gridBagConstraints);

        lbl_show1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_show1.setText("Enrolled Students for SY :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_control.add(lbl_show1, gridBagConstraints);

        lbl_show2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_show2.setText("Sytext");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control.add(lbl_show2, gridBagConstraints);

        btn_Search2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search2.setText("Withdraw");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panel_control.add(btn_Search2, gridBagConstraints);

        btn_Search3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search3.setText("Refresh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        panel_control.add(btn_Search3, gridBagConstraints);

        lbl_show3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show3.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control.add(lbl_show3, gridBagConstraints);

        combo_filter1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_filter1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Kinder", "1", "2", "3", "4", "5", "6", "8", "9", "10", " ", " " }));
        combo_filter1.setMinimumSize(new java.awt.Dimension(70, 30));
        combo_filter1.setPreferredSize(new java.awt.Dimension(70, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_control.add(combo_filter1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel_toppanel.add(panel_control, gridBagConstraints);

        panel_masterrecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students Master List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_masterrecord.setMinimumSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setPreferredSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1185, 530));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1185, 530));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Last Name", "First Name", "Middle Name", "Type", "Grade Level", "Section", "Adviser", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jTable1.setMinimumSize(new java.awt.Dimension(1185, 530));
        jTable1.setPreferredSize(new java.awt.Dimension(1185, 530));
        jTable1.setRowHeight(20);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        panel_masterrecord.add(jScrollPane1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel_toppanel.add(panel_masterrecord, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(panel_toppanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Searchbox;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JButton btn_Search2;
    private javax.swing.JButton btn_Search3;
    private javax.swing.JComboBox<String> combo_filter;
    private javax.swing.JComboBox<String> combo_filter1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JLabel lbl_show1;
    private javax.swing.JLabel lbl_show2;
    private javax.swing.JLabel lbl_show3;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_masterrecord;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
