package view.payment;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import model.tuitionfee.TuitionFee;
import utility.initializer.Initializer;

public class Dialog_MakePayment extends javax.swing.JDialog implements Initializer{

    private final TuitionFee tuitionFee;
    
    public Dialog_MakePayment(java.awt.Frame parent, boolean modal, TuitionFee tuitionFee) {
        super(parent, modal);
        this.tuitionFee = tuitionFee;
        initComponents();
        
        initViewComponents();
        initControllers();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
    }

    @Override
    public void initRenderers() {
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        initBalanceBreakDownJCombo();
    }

    private void initBalanceBreakDownJCombo(){
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cbModel.addElement("Select");
        cbModel.addElement("All");
        for(int i = 0; i<tuitionFee.getBalanceBreakDownFees().size(); i++){
            cbModel.addElement(tuitionFee.getBalanceBreakDownFees().get(i).getName().trim());
        }
        jcmbBalance.setModel(cbModel);
    }
    
    @Override
    public void initControllers() {
        jcbBalance.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jcmbBalance.setEnabled(jcbBalance.isSelected());
            }
        });
        jcbOthers.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jcmbOthers.setEnabled(jcbOthers.isSelected());
            }
        });
    }

    @Override
    public void initDaoImpl() {
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        panel_datetodaycontainer = new javax.swing.JPanel();
        javax.swing.JLabel lbl_datetoday = new javax.swing.JLabel();
        jlblDateToday = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday1 = new javax.swing.JLabel();
        jlblOrNo = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday2 = new javax.swing.JLabel();
        jcmbModeOfPayment = new javax.swing.JComboBox<>();
        javax.swing.JLabel lbl_datetoday3 = new javax.swing.JLabel();
        jlblCashierName = new javax.swing.JLabel();
        panel_datetodaycontainer1 = new javax.swing.JPanel();
        jcbDownPayment = new javax.swing.JCheckBox();
        jcbBalance = new javax.swing.JCheckBox();
        jcbOthers = new javax.swing.JCheckBox();
        jcmbOthers = new javax.swing.JComboBox<>();
        jcmbBalance = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel_datetodaycontainer2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPaymentBreakDown = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel lbl_datetoday4 = new javax.swing.JLabel();
        display_lastname3 = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday5 = new javax.swing.JLabel();
        display_lastname5 = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday6 = new javax.swing.JLabel();
        display_lastname7 = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday7 = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday8 = new javax.swing.JLabel();
        display_lastname10 = new javax.swing.JLabel();
        javax.swing.JLabel lbl_datetoday9 = new javax.swing.JLabel();
        display_lastname12 = new javax.swing.JLabel();
        jtfTendered = new javax.swing.JTextField();
        jtfSubtotal = new javax.swing.JTextField();
        jtfDiscount = new javax.swing.JTextField();
        jtfPenalty = new javax.swing.JTextField();
        jtfPenaltyName = new javax.swing.JTextField();
        jtfTotal = new javax.swing.JTextField();
        panel_footer = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_saveandclose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Make Payment");
        setMinimumSize(new java.awt.Dimension(500, 600));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(500, 600));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(500, 600));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_datetodaycontainer.setMinimumSize(new java.awt.Dimension(490, 70));
        panel_datetodaycontainer.setPreferredSize(new java.awt.Dimension(490, 70));
        panel_datetodaycontainer.setLayout(new java.awt.GridBagLayout());

        lbl_datetoday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_datetoday.setText("Date Today :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panel_datetodaycontainer.add(lbl_datetoday, gridBagConstraints);

        jlblDateToday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblDateToday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblDateToday.setMaximumSize(new java.awt.Dimension(150, 20));
        jlblDateToday.setMinimumSize(new java.awt.Dimension(150, 20));
        jlblDateToday.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panel_datetodaycontainer.add(jlblDateToday, gridBagConstraints);

        lbl_datetoday1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_datetoday1.setText("OR # :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panel_datetodaycontainer.add(lbl_datetoday1, gridBagConstraints);

        jlblOrNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblOrNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblOrNo.setMaximumSize(new java.awt.Dimension(150, 20));
        jlblOrNo.setMinimumSize(new java.awt.Dimension(150, 20));
        jlblOrNo.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panel_datetodaycontainer.add(jlblOrNo, gridBagConstraints);

        lbl_datetoday2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_datetoday2.setText("Mode of Payment :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panel_datetodaycontainer.add(lbl_datetoday2, gridBagConstraints);

        jcmbModeOfPayment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbModeOfPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cash" }));
        jcmbModeOfPayment.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbModeOfPayment.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_datetodaycontainer.add(jcmbModeOfPayment, gridBagConstraints);

        lbl_datetoday3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_datetoday3.setText("Cashier :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_datetodaycontainer.add(lbl_datetoday3, gridBagConstraints);

        jlblCashierName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblCashierName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblCashierName.setMaximumSize(new java.awt.Dimension(150, 20));
        jlblCashierName.setMinimumSize(new java.awt.Dimension(150, 20));
        jlblCashierName.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_datetodaycontainer.add(jlblCashierName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_toppanel.add(panel_datetodaycontainer, gridBagConstraints);

        panel_datetodaycontainer1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_datetodaycontainer1.setMinimumSize(new java.awt.Dimension(490, 100));
        panel_datetodaycontainer1.setPreferredSize(new java.awt.Dimension(490, 100));
        panel_datetodaycontainer1.setLayout(new java.awt.GridBagLayout());

        jcbDownPayment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbDownPayment.setText("Downpayment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jcbDownPayment, gridBagConstraints);

        jcbBalance.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbBalance.setText("Balance");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jcbBalance, gridBagConstraints);

        jcbOthers.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbOthers.setText("Others");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jcbOthers, gridBagConstraints);

        jcmbOthers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbOthers.setEnabled(false);
        jcmbOthers.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbOthers.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jcmbOthers, gridBagConstraints);

        jcmbBalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbBalance.setEnabled(false);
        jcmbBalance.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbBalance.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jcmbBalance, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_datetodaycontainer1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel_toppanel.add(panel_datetodaycontainer1, gridBagConstraints);

        panel_datetodaycontainer2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Breakdown", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_datetodaycontainer2.setMinimumSize(new java.awt.Dimension(490, 400));
        panel_datetodaycontainer2.setPreferredSize(new java.awt.Dimension(490, 400));
        panel_datetodaycontainer2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(480, 150));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(480, 150));

        jtblPaymentBreakDown.setAutoCreateRowSorter(true);
        jtblPaymentBreakDown.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtblPaymentBreakDown.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Particular", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPaymentBreakDown.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jtblPaymentBreakDown.setRowHeight(20);
        jtblPaymentBreakDown.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblPaymentBreakDown);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_datetodaycontainer2.add(jScrollPane1, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(250, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 200));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbl_datetoday4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_datetoday4.setText("Subtotal :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday4, gridBagConstraints);

        display_lastname3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        display_lastname3.setText("Php");
        display_lastname3.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname3.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname3.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel1.add(display_lastname3, gridBagConstraints);

        lbl_datetoday5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_datetoday5.setText("Discount :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday5, gridBagConstraints);

        display_lastname5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        display_lastname5.setText("Php");
        display_lastname5.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname5.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname5.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel1.add(display_lastname5, gridBagConstraints);

        lbl_datetoday6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_datetoday6.setText("Penalty :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday6, gridBagConstraints);

        display_lastname7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        display_lastname7.setText("Php");
        display_lastname7.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname7.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname7.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel1.add(display_lastname7, gridBagConstraints);

        lbl_datetoday7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_datetoday7.setText("Panalty name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday7, gridBagConstraints);

        lbl_datetoday8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_datetoday8.setForeground(new java.awt.Color(0, 51, 102));
        lbl_datetoday8.setText("Total :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday8, gridBagConstraints);

        display_lastname10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        display_lastname10.setForeground(new java.awt.Color(0, 51, 102));
        display_lastname10.setText("Php");
        display_lastname10.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname10.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname10.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel1.add(display_lastname10, gridBagConstraints);

        lbl_datetoday9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_datetoday9.setForeground(new java.awt.Color(0, 153, 102));
        lbl_datetoday9.setText("Tendered :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(lbl_datetoday9, gridBagConstraints);

        display_lastname12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        display_lastname12.setForeground(new java.awt.Color(0, 153, 102));
        display_lastname12.setText("Php");
        display_lastname12.setMaximumSize(new java.awt.Dimension(30, 20));
        display_lastname12.setMinimumSize(new java.awt.Dimension(30, 20));
        display_lastname12.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel1.add(display_lastname12, gridBagConstraints);

        jtfTendered.setBackground(new java.awt.Color(0, 153, 102));
        jtfTendered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTendered.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfTendered.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jtfTendered, gridBagConstraints);

        jtfSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfSubtotal.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfSubtotal.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jtfSubtotal, gridBagConstraints);

        jtfDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfDiscount.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfDiscount.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jtfDiscount, gridBagConstraints);

        jtfPenalty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPenalty.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfPenalty.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jtfPenalty, gridBagConstraints);

        jtfPenaltyName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPenaltyName.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfPenaltyName.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        jPanel1.add(jtfPenaltyName, gridBagConstraints);

        jtfTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfTotal.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfTotal.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jtfTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panel_datetodaycontainer2.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel_toppanel.add(panel_datetodaycontainer2, gridBagConstraints);

        panel_footer.setMinimumSize(new java.awt.Dimension(490, 50));
        panel_footer.setPreferredSize(new java.awt.Dimension(490, 50));
        panel_footer.setLayout(new java.awt.GridBagLayout());

        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.setMaximumSize(new java.awt.Dimension(69, 40));
        btn_cancel.setMinimumSize(new java.awt.Dimension(69, 40));
        btn_cancel.setPreferredSize(new java.awt.Dimension(69, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        panel_footer.add(btn_cancel, gridBagConstraints);

        btn_saveandclose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_saveandclose.setText("Proceed Payment");
        btn_saveandclose.setMaximumSize(new java.awt.Dimension(200, 40));
        btn_saveandclose.setMinimumSize(new java.awt.Dimension(200, 40));
        btn_saveandclose.setPreferredSize(new java.awt.Dimension(200, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        panel_footer.add(btn_saveandclose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        panel_toppanel.add(panel_footer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        getContentPane().add(panel_toppanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_saveandclose;
    private javax.swing.JLabel display_lastname10;
    private javax.swing.JLabel display_lastname12;
    private javax.swing.JLabel display_lastname3;
    private javax.swing.JLabel display_lastname5;
    private javax.swing.JLabel display_lastname7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbBalance;
    private javax.swing.JCheckBox jcbDownPayment;
    private javax.swing.JCheckBox jcbOthers;
    private javax.swing.JComboBox<String> jcmbBalance;
    private javax.swing.JComboBox<String> jcmbModeOfPayment;
    private javax.swing.JComboBox<String> jcmbOthers;
    private javax.swing.JLabel jlblCashierName;
    private javax.swing.JLabel jlblDateToday;
    private javax.swing.JLabel jlblOrNo;
    private javax.swing.JTable jtblPaymentBreakDown;
    private javax.swing.JTextField jtfDiscount;
    private javax.swing.JTextField jtfPenalty;
    private javax.swing.JTextField jtfPenaltyName;
    private javax.swing.JTextField jtfSubtotal;
    private javax.swing.JTextField jtfTendered;
    private javax.swing.JTextField jtfTotal;
    private javax.swing.JPanel panel_datetodaycontainer;
    private javax.swing.JPanel panel_datetodaycontainer1;
    private javax.swing.JPanel panel_datetodaycontainer2;
    private javax.swing.JPanel panel_footer;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
