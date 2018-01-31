package view.payment;

import controller.payment.SearchStudent;
import daoimpl.FeeDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.PaymentTermDaoImpl;
import daoimpl.StudentDaoImpl;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import utility.initializer.Initializer;


public class Panel_Payment extends javax.swing.JPanel implements Initializer{
    private StudentDaoImpl studentDaoImpl;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private FeeDaoImpl feeDaoImpl;
    private PaymentTermDaoImpl paymentTermDaoImpl;

    public Panel_Payment() {
        initComponents();
        initDaoImpl();
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

    }

    @Override
    public void initControllers() {
        jtfSearchBoxMakePayment.addKeyListener(new SearchStudent(this, studentDaoImpl, gradeLevelDaoImpl, feeDaoImpl, paymentTermDaoImpl));
    }

    @Override
    public void initDaoImpl() {
        studentDaoImpl = new StudentDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        feeDaoImpl = new FeeDaoImpl();
        paymentTermDaoImpl = new PaymentTermDaoImpl();
    }

    public JTextField getSearchbox8() {
        return Searchbox8;
    }

    public JButton getBtn_Search10() {
        return btn_Search10;
    }

    public JButton getBtn_Search14() {
        return btn_Search14;
    }

    public JButton getBtn_Search15() {
        return btn_Search15;
    }

    public JButton getBtn_addDiscount() {
        return btn_addDiscount;
    }

    public JButton getBtn_removeDiscount() {
        return btn_removeDiscount;
    }

    public JComboBox<String> getCombo_filter5() {
        return combo_filter5;
    }

    public JLabel getDisplay_remainingbalance2() {
        return display_remainingbalance2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane10() {
        return jScrollPane10;
    }

    public JScrollPane getjScrollPane11() {
        return jScrollPane11;
    }

    public JScrollPane getjScrollPane12() {
        return jScrollPane12;
    }

    public JScrollPane getjScrollPane13() {
        return jScrollPane13;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public JScrollPane getjScrollPane9() {
        return jScrollPane9;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JTable getjTable11() {
        return jTable11;
    }

    public JButton getJbtnAdjustmentPrint() {
        return jbtnAdjustmentPrint;
    }

    public JButton getJbtnAdjustmentsMakeAdjustment() {
        return jbtnAdjustmentsMakeAdjustment;
    }

    public JButton getJbtnAdjustmentsSearch() {
        return jbtnAdjustmentsSearch;
    }

    public JTextField getJbtnAdjustmentsSearchBox() {
        return jbtnAdjustmentsSearchBox;
    }

    public JButton getJbtnDiscountsPrint() {
        return jbtnDiscountsPrint;
    }

    public JButton getJbtnDiscountsSearch() {
        return jbtnDiscountsSearch;
    }

    public JComboBox<String> getJbtnDiscountsSearchBy() {
        return jbtnDiscountsSearchBy;
    }

    public JButton getJbtnDiscountsView() {
        return jbtnDiscountsView;
    }

    public JButton getJbtnMakePayment() {
        return jbtnMakePayment;
    }

    public JButton getJbtnPaymentHistorySearch() {
        return jbtnPaymentHistorySearch;
    }

    public JButton getJbtnReceiptsPrint() {
        return jbtnReceiptsPrint;
    }

    public JButton getJbtnReceiptsSearch() {
        return jbtnReceiptsSearch;
    }

    public JButton getJbtnReceiptsView() {
        return jbtnReceiptsView;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JCheckBox getJcbDiscount() {
        return jcbDiscount;
    }

    public JComboBox<String> getJcmbAdjustmentsSearchBy() {
        return jcmbAdjustmentsSearchBy;
    }

    public JComboBox<String> getJcmbDiscount() {
        return jcmbDiscount;
    }

    public JComboBox<String> getJcmbPaymentHistorySearchBy() {
        return jcmbPaymentHistorySearchBy;
    }

    public JComboBox<String> getJcmbPaymentTerm() {
        return jcmbPaymentTerm;
    }

    public JComboBox<String> getJcmbReceiptsSearchBy() {
        return jcmbReceiptsSearchBy;
    }

    public JLabel getJlblDiscountPercentText() {
        return jlblDiscountPercentText;
    }

    public JLabel getJlblRemainingBalanceText() {
        return jlblRemainingBalanceText;
    }

    public JLabel getJlblStudentNo() {
        return jlblStudentNo;
    }

    public JLabel getJlblTotalPaidText() {
        return jlblTotalPaidText;
    }

    public JPanel getJpnlBalanceBreakdown() {
        return jpnlBalanceBreakdown;
    }

    public JPanel getJpnlBalanceStatus() {
        return jpnlBalanceStatus;
    }

    public JPanel getJpnlBasic() {
        return jpnlBasic;
    }

    public JPanel getJpnlCurrentSchoolYearTuition() {
        return jpnlCurrentSchoolYearTuition;
    }

    public JPanel getJpnlDiscount() {
        return jpnlDiscount;
    }

    public JPanel getJpnlDownpayment() {
        return jpnlDownpayment;
    }

    public JPanel getJpnlFeesContainer() {
        return jpnlFeesContainer;
    }

    public JPanel getJpnlHistoryDetails() {
        return jpnlHistoryDetails;
    }

    public JPanel getJpnlMiscellaneous() {
        return jpnlMiscellaneous;
    }

    public JPanel getJpnlOthers() {
        return jpnlOthers;
    }

    public JPanel getJpnlPhotoContainer() {
        return jpnlPhotoContainer;
    }

    public JPanel getJpnlStudentAdjustments() {
        return jpnlStudentAdjustments;
    }

    public JPanel getJpnlStudentDetails() {
        return jpnlStudentDetails;
    }

    public JTable getJtblAdjustments() {
        return jtblAdjustments;
    }

    public JTable getJtblBalanceBreakDown() {
        return jtblBalanceBreakDown;
    }

    public JTable getJtblBasic() {
        return jtblBasic;
    }

    public JTable getJtblDiscounts() {
        return jtblDiscounts;
    }

    public JTable getJtblDownpayment() {
        return jtblDownpayment;
    }

    public JTable getJtblMiscellaneous() {
        return jtblMiscellaneous;
    }

    public JTable getJtblOthers() {
        return jtblOthers;
    }

    public JTable getJtblPaymentHistory() {
        return jtblPaymentHistory;
    }

    public JTable getJtblReceipts() {
        return jtblReceipts;
    }

    public JTextField getJtfBasicFee() {
        return jtfBasicFee;
    }

    public JTextField getJtfDiscount() {
        return jtfDiscount;
    }

    public JTextField getJtfDiscountsSearch() {
        return jtfDiscountsSearch;
    }

    public JTextField getJtfDownPayment() {
        return jtfDownPayment;
    }

    public JTextField getJtfFirstName() {
        return jtfFirstName;
    }

    public JTextField getJtfGradeLevel() {
        return jtfGradeLevel;
    }

    public JTextField getJtfLastName() {
        return jtfLastName;
    }

    public JTextField getJtfMiddleName() {
        return jtfMiddleName;
    }

    public JTextField getJtfMiscellaneous() {
        return jtfMiscellaneous;
    }

    public JTextField getJtfOtherFees() {
        return jtfOtherFees;
    }

    public JTextField getJtfPaymentHistorySearchBox() {
        return jtfPaymentHistorySearchBox;
    }

    public JTextField getJtfPaymentHistoryTotalCredit() {
        return jtfPaymentHistoryTotalCredit;
    }

    public JTextField getJtfPaymentHistoryTotalDebit() {
        return jtfPaymentHistoryTotalDebit;
    }

    public JTextField getJtfReceiptsSearchBox() {
        return jtfReceiptsSearchBox;
    }

    public JTextField getJtfSearchBoxMakePayment() {
        return jtfSearchBoxMakePayment;
    }

    public JTextField getJtfStatus() {
        return jtfStatus;
    }

    public JTextField getJtfStudentNo() {
        return jtfStudentNo;
    }

    public JTextField getJtfStudentType() {
        return jtfStudentType;
    }

    public JTextField getJtfTotal() {
        return jtfTotal;
    }

    public JLabel getLbl_basicfee() {
        return lbl_basicfee;
    }

    public JLabel getLbl_discount() {
        return lbl_discount;
    }

    public JLabel getLbl_firstname() {
        return lbl_firstname;
    }

    public JLabel getLbl_gradelevel() {
        return lbl_gradelevel;
    }

    public JLabel getLbl_lastname() {
        return lbl_lastname;
    }

    public JLabel getLbl_middlename() {
        return lbl_middlename;
    }

    public JLabel getLbl_misc() {
        return lbl_misc;
    }

    public JLabel getLbl_otherfees() {
        return lbl_otherfees;
    }

    public JLabel getLbl_paymentterm() {
        return lbl_paymentterm;
    }

    public JLabel getLbl_percent() {
        return lbl_percent;
    }

    public JLabel getLbl_remainingbalance() {
        return lbl_remainingbalance;
    }

    public JLabel getLbl_remainingbalance2() {
        return lbl_remainingbalance2;
    }

    public JLabel getLbl_show() {
        return lbl_show;
    }

    public JLabel getLbl_show1() {
        return lbl_show1;
    }

    public JLabel getLbl_show2() {
        return lbl_show2;
    }

    public JLabel getLbl_show3() {
        return lbl_show3;
    }

    public JLabel getLbl_show4() {
        return lbl_show4;
    }

    public JLabel getLbl_show5() {
        return lbl_show5;
    }

    public JLabel getLbl_show7() {
        return lbl_show7;
    }

    public JLabel getLbl_status() {
        return lbl_status;
    }

    public JLabel getLbl_total() {
        return lbl_total;
    }

    public JLabel getLbl_totalpaid() {
        return lbl_totalpaid;
    }

    public JLabel getLbl_type() {
        return lbl_type;
    }

    public JPanel getPanel_balancebreakdowncontainer2() {
        return panel_balancebreakdowncontainer2;
    }

    public JPanel getPanel_historycontrol() {
        return panel_historycontrol;
    }

    public JPanel getPanel_historycontrol1() {
        return panel_historycontrol1;
    }

    public JPanel getPanel_historycontrol2() {
        return panel_historycontrol2;
    }

    public JPanel getPanel_historycontrol3() {
        return panel_historycontrol3;
    }

    public JPanel getPanel_historycontrol5() {
        return panel_historycontrol5;
    }

    public JPanel getPanel_historydetails1() {
        return panel_historydetails1;
    }

    public JPanel getPanel_historydetails2() {
        return panel_historydetails2;
    }

    public JPanel getPanel_historydetails5() {
        return panel_historydetails5;
    }

    public JPanel getPanel_searchcontainer() {
        return panel_searchcontainer;
    }

    public JPanel getPanel_separator() {
        return panel_separator;
    }

    public JPanel getPanel_statuscontainer() {
        return panel_statuscontainer;
    }

    public JPanel getPanel_studentdetails() {
        return panel_studentdetails;
    }

    public JPanel getPanel_studentdetailscontainer() {
        return panel_studentdetailscontainer;
    }

    public JPanel getPanel_tabscontainer() {
        return panel_tabscontainer;
    }

    public JPanel getPanel_toppanel() {
        return panel_toppanel;
    }

    public JPanel getPanel_totalcontainer() {
        return panel_totalcontainer;
    }

    public JPanel getTabpanel_Adjustments() {
        return tabpanel_Adjustments;
    }

    public JPanel getTabpanel_Receipts() {
        return tabpanel_Receipts;
    }

    public JPanel getTabpanel_StatementofAccount() {
        return tabpanel_StatementofAccount;
    }

    public JPanel getTabpanel_accountbalance1() {
        return tabpanel_accountbalance1;
    }

    public JPanel getTabpanel_discounts() {
        return tabpanel_discounts;
    }

    public JPanel getTabpanel_makepayment() {
        return tabpanel_makepayment;
    }

    public JPanel getTabpanel_paymenthistory() {
        return tabpanel_paymenthistory;
    }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane10 = new javax.swing.JScrollPane();
        panel_toppanel = new javax.swing.JPanel();
        panel_searchcontainer = new javax.swing.JPanel();
        javax.swing.JLabel lbl_datetoday = new javax.swing.JLabel();
        javax.swing.JLabel jtfDateToday = new javax.swing.JLabel();
        javax.swing.JLabel lbl_separator = new javax.swing.JLabel();
        jtfSearchBoxMakePayment = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        panel_studentdetailscontainer = new javax.swing.JPanel();
        panel_studentdetails = new javax.swing.JPanel();
        jpnlPhotoContainer = new javax.swing.JPanel();
        panel_separator = new javax.swing.JPanel();
        jpnlStudentDetails = new javax.swing.JPanel();
        jlblStudentNo = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        lbl_lastname = new javax.swing.JLabel();
        lbl_firstname = new javax.swing.JLabel();
        lbl_middlename = new javax.swing.JLabel();
        lbl_gradelevel = new javax.swing.JLabel();
        lbl_paymentterm = new javax.swing.JLabel();
        jcmbPaymentTerm = new javax.swing.JComboBox<>();
        jtfStudentNo = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfGradeLevel = new javax.swing.JTextField();
        jtfStudentType = new javax.swing.JTextField();
        jtfFirstName = new javax.swing.JTextField();
        jtfStatus = new javax.swing.JTextField();
        jtfMiddleName = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jpnlCurrentSchoolYearTuition = new javax.swing.JPanel();
        lbl_basicfee = new javax.swing.JLabel();
        lbl_misc = new javax.swing.JLabel();
        lbl_otherfees = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfDownPayment = new javax.swing.JTextField();
        jtfBasicFee = new javax.swing.JTextField();
        jtfMiscellaneous = new javax.swing.JTextField();
        jtfOtherFees = new javax.swing.JTextField();
        jtfDiscount = new javax.swing.JTextField();
        jtfTotal = new javax.swing.JTextField();
        panel_statuscontainer = new javax.swing.JPanel();
        jpnlBalanceStatus = new javax.swing.JPanel();
        lbl_remainingbalance = new javax.swing.JLabel();
        jlblRemainingBalanceText = new javax.swing.JLabel();
        lbl_totalpaid = new javax.swing.JLabel();
        jlblTotalPaidText = new javax.swing.JLabel();
        jpnlDiscount = new javax.swing.JPanel();
        jcmbDiscount = new javax.swing.JComboBox<>();
        jlblDiscountPercentText = new javax.swing.JLabel();
        lbl_percent = new javax.swing.JLabel();
        btn_removeDiscount = new javax.swing.JButton();
        jcbDiscount = new javax.swing.JCheckBox();
        btn_addDiscount = new javax.swing.JButton();
        panel_tabscontainer = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabpanel_makepayment = new javax.swing.JPanel();
        jpnlFeesContainer = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jpnlMiscellaneous = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblMiscellaneous = new javax.swing.JTable();
        jpnlBasic = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblBasic = new javax.swing.JTable();
        jpnlOthers = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblOthers = new javax.swing.JTable();
        jpnlDownpayment = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDownpayment = new javax.swing.JTable();
        jpnlBalanceBreakdown = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblBalanceBreakDown = new javax.swing.JTable();
        panel_balancebreakdowncontainer2 = new javax.swing.JPanel();
        jbtnMakePayment = new javax.swing.JButton();
        tabpanel_paymenthistory = new javax.swing.JPanel();
        panel_historycontrol = new javax.swing.JPanel();
        jtfPaymentHistorySearchBox = new javax.swing.JTextField();
        jbtnPaymentHistorySearch = new javax.swing.JButton();
        lbl_show = new javax.swing.JLabel();
        jcmbPaymentHistorySearchBy = new javax.swing.JComboBox<>();
        jpnlHistoryDetails = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblPaymentHistory = new javax.swing.JTable();
        panel_totalcontainer = new javax.swing.JPanel();
        jtfPaymentHistoryTotalCredit = new javax.swing.JTextField();
        lbl_show1 = new javax.swing.JLabel();
        lbl_show2 = new javax.swing.JLabel();
        jtfPaymentHistoryTotalDebit = new javax.swing.JTextField();
        tabpanel_discounts = new javax.swing.JPanel();
        panel_historydetails2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtblDiscounts = new javax.swing.JTable();
        panel_historycontrol2 = new javax.swing.JPanel();
        jtfDiscountsSearch = new javax.swing.JTextField();
        jbtnDiscountsSearch = new javax.swing.JButton();
        lbl_show4 = new javax.swing.JLabel();
        jbtnDiscountsSearchBy = new javax.swing.JComboBox<>();
        jbtnDiscountsView = new javax.swing.JButton();
        jbtnDiscountsPrint = new javax.swing.JButton();
        tabpanel_Receipts = new javax.swing.JPanel();
        panel_historycontrol1 = new javax.swing.JPanel();
        jtfReceiptsSearchBox = new javax.swing.JTextField();
        jbtnReceiptsSearch = new javax.swing.JButton();
        lbl_show3 = new javax.swing.JLabel();
        jcmbReceiptsSearchBy = new javax.swing.JComboBox<>();
        jbtnReceiptsView = new javax.swing.JButton();
        jbtnReceiptsPrint = new javax.swing.JButton();
        panel_historydetails1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblReceipts = new javax.swing.JTable();
        tabpanel_Adjustments = new javax.swing.JPanel();
        panel_historycontrol3 = new javax.swing.JPanel();
        jbtnAdjustmentsSearchBox = new javax.swing.JTextField();
        jbtnAdjustmentsSearch = new javax.swing.JButton();
        lbl_show5 = new javax.swing.JLabel();
        jcmbAdjustmentsSearchBy = new javax.swing.JComboBox<>();
        jbtnAdjustmentPrint = new javax.swing.JButton();
        jbtnAdjustmentsMakeAdjustment = new javax.swing.JButton();
        jpnlStudentAdjustments = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtblAdjustments = new javax.swing.JTable();
        tabpanel_StatementofAccount = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tabpanel_accountbalance1 = new javax.swing.JPanel();
        panel_historycontrol5 = new javax.swing.JPanel();
        Searchbox8 = new javax.swing.JTextField();
        btn_Search10 = new javax.swing.JButton();
        lbl_show7 = new javax.swing.JLabel();
        combo_filter5 = new javax.swing.JComboBox<>();
        btn_Search14 = new javax.swing.JButton();
        btn_Search15 = new javax.swing.JButton();
        lbl_remainingbalance2 = new javax.swing.JLabel();
        display_remainingbalance2 = new javax.swing.JLabel();
        panel_historydetails5 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1200, 700));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1200, 700));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_searchcontainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
        panel_searchcontainer.setMinimumSize(new java.awt.Dimension(1195, 50));
        panel_searchcontainer.setPreferredSize(new java.awt.Dimension(1195, 50));
        panel_searchcontainer.setLayout(new java.awt.GridBagLayout());

        lbl_datetoday.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_datetoday.setText("Date Today :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_searchcontainer.add(lbl_datetoday, gridBagConstraints);

        jtfDateToday.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jtfDateToday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jtfDateToday.setMaximumSize(new java.awt.Dimension(200, 35));
        jtfDateToday.setMinimumSize(new java.awt.Dimension(200, 35));
        jtfDateToday.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_searchcontainer.add(jtfDateToday, gridBagConstraints);

        lbl_separator.setBackground(new java.awt.Color(204, 204, 204));
        lbl_separator.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_separator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_separator.setMaximumSize(new java.awt.Dimension(3, 50));
        lbl_separator.setMinimumSize(new java.awt.Dimension(3, 50));
        lbl_separator.setPreferredSize(new java.awt.Dimension(3, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        panel_searchcontainer.add(lbl_separator, gridBagConstraints);

        jtfSearchBoxMakePayment.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfSearchBoxMakePayment.setMinimumSize(new java.awt.Dimension(200, 30));
        jtfSearchBoxMakePayment.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 520, 0, 0);
        panel_searchcontainer.add(jtfSearchBoxMakePayment, gridBagConstraints);

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.setMaximumSize(new java.awt.Dimension(85, 30));
        jbtnSearch.setMinimumSize(new java.awt.Dimension(85, 30));
        jbtnSearch.setPreferredSize(new java.awt.Dimension(85, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_searchcontainer.add(jbtnSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_searchcontainer, gridBagConstraints);

        panel_studentdetailscontainer.setMinimumSize(new java.awt.Dimension(906, 310));
        panel_studentdetailscontainer.setPreferredSize(new java.awt.Dimension(906, 310));
        panel_studentdetailscontainer.setLayout(new java.awt.GridBagLayout());

        panel_studentdetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_studentdetails.setMinimumSize(new java.awt.Dimension(900, 140));
        panel_studentdetails.setPreferredSize(new java.awt.Dimension(900, 140));
        panel_studentdetails.setLayout(new java.awt.GridBagLayout());

        jpnlPhotoContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpnlPhotoContainer.setMinimumSize(new java.awt.Dimension(110, 110));
        jpnlPhotoContainer.setPreferredSize(new java.awt.Dimension(110, 110));
        jpnlPhotoContainer.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_studentdetails.add(jpnlPhotoContainer, gridBagConstraints);

        panel_separator.setBackground(new java.awt.Color(187, 187, 187));
        panel_separator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panel_separator.setMinimumSize(new java.awt.Dimension(3, 120));
        panel_separator.setPreferredSize(new java.awt.Dimension(3, 120));
        panel_separator.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_studentdetails.add(panel_separator, gridBagConstraints);

        jpnlStudentDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpnlStudentDetails.setMinimumSize(new java.awt.Dimension(750, 110));
        jpnlStudentDetails.setPreferredSize(new java.awt.Dimension(750, 110));
        jpnlStudentDetails.setLayout(new java.awt.GridBagLayout());

        jlblStudentNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblStudentNo.setText("Student No :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlStudentDetails.add(jlblStudentNo, gridBagConstraints);

        lbl_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_type.setText("Type :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jpnlStudentDetails.add(lbl_type, gridBagConstraints);

        lbl_status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_status.setText("Status :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jpnlStudentDetails.add(lbl_status, gridBagConstraints);

        lbl_lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_lastname.setText("Last Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlStudentDetails.add(lbl_lastname, gridBagConstraints);

        lbl_firstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_firstname.setText("First Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jpnlStudentDetails.add(lbl_firstname, gridBagConstraints);

        lbl_middlename.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_middlename.setText("Middle Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jpnlStudentDetails.add(lbl_middlename, gridBagConstraints);

        lbl_gradelevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jpnlStudentDetails.add(lbl_gradelevel, gridBagConstraints);

        lbl_paymentterm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_paymentterm.setText("Payment Term :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jpnlStudentDetails.add(lbl_paymentterm, gridBagConstraints);

        jcmbPaymentTerm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jpnlStudentDetails.add(jcmbPaymentTerm, gridBagConstraints);

        jtfStudentNo.setColumns(10);
        jtfStudentNo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfStudentNo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfStudentNo, gridBagConstraints);

        jtfLastName.setColumns(10);
        jtfLastName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfLastName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfLastName, gridBagConstraints);

        jtfGradeLevel.setColumns(10);
        jtfGradeLevel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfGradeLevel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfGradeLevel, gridBagConstraints);

        jtfStudentType.setColumns(10);
        jtfStudentType.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfStudentType.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfStudentType, gridBagConstraints);

        jtfFirstName.setColumns(10);
        jtfFirstName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfFirstName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfFirstName, gridBagConstraints);

        jtfStatus.setColumns(10);
        jtfStatus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfStatus.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfStatus, gridBagConstraints);

        jtfMiddleName.setColumns(10);
        jtfMiddleName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfMiddleName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentDetails.add(jtfMiddleName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_studentdetails.add(jpnlStudentDetails, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_studentdetailscontainer.add(panel_studentdetails, gridBagConstraints);

        jScrollPane12.setMinimumSize(new java.awt.Dimension(320, 140));
        jScrollPane12.setPreferredSize(new java.awt.Dimension(320, 140));

        jpnlCurrentSchoolYearTuition.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current SY Tuition", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlCurrentSchoolYearTuition.setMinimumSize(new java.awt.Dimension(300, 120));
        jpnlCurrentSchoolYearTuition.setPreferredSize(new java.awt.Dimension(300, 120));
        jpnlCurrentSchoolYearTuition.setLayout(new java.awt.GridBagLayout());

        lbl_basicfee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_basicfee.setText("Basic Fee :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jpnlCurrentSchoolYearTuition.add(lbl_basicfee, gridBagConstraints);

        lbl_misc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_misc.setText("Miscellaneous :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jpnlCurrentSchoolYearTuition.add(lbl_misc, gridBagConstraints);

        lbl_otherfees.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_otherfees.setText("Other Fees :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jpnlCurrentSchoolYearTuition.add(lbl_otherfees, gridBagConstraints);

        lbl_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_discount.setText("Discount :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jpnlCurrentSchoolYearTuition.add(lbl_discount, gridBagConstraints);

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_total.setText("Total :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jpnlCurrentSchoolYearTuition.add(lbl_total, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Downpayment :");
        jpnlCurrentSchoolYearTuition.add(jLabel1, new java.awt.GridBagConstraints());

        jtfDownPayment.setColumns(5);
        jtfDownPayment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfDownPayment.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfDownPayment, gridBagConstraints);

        jtfBasicFee.setColumns(5);
        jtfBasicFee.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfBasicFee.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfBasicFee, gridBagConstraints);

        jtfMiscellaneous.setColumns(5);
        jtfMiscellaneous.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfMiscellaneous.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfMiscellaneous, gridBagConstraints);

        jtfOtherFees.setColumns(5);
        jtfOtherFees.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfOtherFees.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfOtherFees, gridBagConstraints);

        jtfDiscount.setColumns(5);
        jtfDiscount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfDiscount.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfDiscount, gridBagConstraints);

        jtfTotal.setColumns(5);
        jtfTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtfTotal.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlCurrentSchoolYearTuition.add(jtfTotal, gridBagConstraints);

        jScrollPane12.setViewportView(jpnlCurrentSchoolYearTuition);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_studentdetailscontainer.add(jScrollPane12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_studentdetailscontainer, gridBagConstraints);

        panel_statuscontainer.setLayout(new java.awt.GridBagLayout());

        jpnlBalanceStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlBalanceStatus.setMinimumSize(new java.awt.Dimension(600, 50));
        jpnlBalanceStatus.setPreferredSize(new java.awt.Dimension(600, 50));
        jpnlBalanceStatus.setLayout(new java.awt.GridBagLayout());

        lbl_remainingbalance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_remainingbalance.setText("Remaining Balance : ");
        lbl_remainingbalance.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlBalanceStatus.add(lbl_remainingbalance, gridBagConstraints);

        jlblRemainingBalanceText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblRemainingBalanceText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblRemainingBalanceText.setMaximumSize(new java.awt.Dimension(150, 20));
        jlblRemainingBalanceText.setMinimumSize(new java.awt.Dimension(150, 20));
        jlblRemainingBalanceText.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlBalanceStatus.add(jlblRemainingBalanceText, gridBagConstraints);

        lbl_totalpaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_totalpaid.setText("Total Paid :");
        lbl_totalpaid.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jpnlBalanceStatus.add(lbl_totalpaid, gridBagConstraints);

        jlblTotalPaidText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblTotalPaidText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblTotalPaidText.setMaximumSize(new java.awt.Dimension(150, 20));
        jlblTotalPaidText.setMinimumSize(new java.awt.Dimension(150, 20));
        jlblTotalPaidText.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 30);
        jpnlBalanceStatus.add(jlblTotalPaidText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_statuscontainer.add(jpnlBalanceStatus, gridBagConstraints);

        jpnlDiscount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Discount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlDiscount.setMinimumSize(new java.awt.Dimension(600, 50));
        jpnlDiscount.setPreferredSize(new java.awt.Dimension(600, 50));
        jpnlDiscount.setLayout(new java.awt.GridBagLayout());

        jcmbDiscount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbDiscount.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbDiscount.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jpnlDiscount.add(jcmbDiscount, gridBagConstraints);

        jlblDiscountPercentText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblDiscountPercentText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jlblDiscountPercentText.setMaximumSize(new java.awt.Dimension(30, 30));
        jlblDiscountPercentText.setMinimumSize(new java.awt.Dimension(30, 30));
        jlblDiscountPercentText.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jpnlDiscount.add(jlblDiscountPercentText, gridBagConstraints);

        lbl_percent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_percent.setText("%");
        lbl_percent.setMaximumSize(new java.awt.Dimension(20, 30));
        lbl_percent.setMinimumSize(new java.awt.Dimension(20, 30));
        lbl_percent.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jpnlDiscount.add(lbl_percent, gridBagConstraints);

        btn_removeDiscount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_removeDiscount.setText("Remove");
        btn_removeDiscount.setMaximumSize(new java.awt.Dimension(100, 30));
        btn_removeDiscount.setMinimumSize(new java.awt.Dimension(100, 30));
        btn_removeDiscount.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 90);
        jpnlDiscount.add(btn_removeDiscount, gridBagConstraints);

        jcbDiscount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbDiscount.setText("Discount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlDiscount.add(jcbDiscount, gridBagConstraints);

        btn_addDiscount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_addDiscount.setText("Add");
        btn_addDiscount.setActionCommand("add");
        btn_addDiscount.setMaximumSize(new java.awt.Dimension(80, 30));
        btn_addDiscount.setMinimumSize(new java.awt.Dimension(80, 30));
        btn_addDiscount.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jpnlDiscount.add(btn_addDiscount, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_statuscontainer.add(jpnlDiscount, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel_toppanel.add(panel_statuscontainer, gridBagConstraints);

        panel_tabscontainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_tabscontainer.setMinimumSize(new java.awt.Dimension(1199, 460));
        panel_tabscontainer.setPreferredSize(new java.awt.Dimension(1199, 460));
        panel_tabscontainer.setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1197, 460));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1197, 460));

        tabpanel_makepayment.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_makepayment.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_makepayment.setLayout(new java.awt.GridBagLayout());

        jpnlFeesContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlFeesContainer.setMinimumSize(new java.awt.Dimension(330, 430));
        jpnlFeesContainer.setPreferredSize(new java.awt.Dimension(330, 430));
        jpnlFeesContainer.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpnlMiscellaneous.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Miscellaneous", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlMiscellaneous.setMinimumSize(new java.awt.Dimension(100, 100));
        jpnlMiscellaneous.setPreferredSize(new java.awt.Dimension(100, 100));
        jpnlMiscellaneous.setLayout(new java.awt.GridBagLayout());

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 125));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 125));

        jtblMiscellaneous.setAutoCreateRowSorter(true);
        jtblMiscellaneous.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblMiscellaneous.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblMiscellaneous.setEnabled(false);
        jtblMiscellaneous.setRowHeight(20);
        jtblMiscellaneous.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtblMiscellaneous);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlMiscellaneous.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlMiscellaneous, gridBagConstraints);

        jpnlBasic.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Basic", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlBasic.setMinimumSize(new java.awt.Dimension(100, 100));
        jpnlBasic.setPreferredSize(new java.awt.Dimension(100, 100));
        jpnlBasic.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 403));

        jtblBasic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblBasic.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblBasic.setEnabled(false);
        jtblBasic.setRowHeight(25);
        jScrollPane2.setViewportView(jtblBasic);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlBasic.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlBasic, gridBagConstraints);

        jpnlOthers.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Others", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlOthers.setMinimumSize(new java.awt.Dimension(100, 100));
        jpnlOthers.setPreferredSize(new java.awt.Dimension(100, 100));
        jpnlOthers.setLayout(new java.awt.GridBagLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(300, 80));

        jtblOthers.setAutoCreateRowSorter(true);
        jtblOthers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblOthers.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblOthers.setEnabled(false);
        jtblOthers.setRowHeight(20);
        jScrollPane4.setViewportView(jtblOthers);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlOthers.add(jScrollPane4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlOthers, gridBagConstraints);

        jpnlDownpayment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Downpayment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlDownpayment.setMinimumSize(new java.awt.Dimension(100, 100));
        jpnlDownpayment.setPreferredSize(new java.awt.Dimension(100, 100));
        jpnlDownpayment.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 50));

        jtblDownpayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblDownpayment.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblDownpayment.setEnabled(false);
        jtblDownpayment.setRowHeight(25);
        jtblDownpayment.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblDownpayment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlDownpayment.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jpnlDownpayment, gridBagConstraints);

        jScrollPane11.setViewportView(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFeesContainer.add(jScrollPane11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        tabpanel_makepayment.add(jpnlFeesContainer, gridBagConstraints);

        jpnlBalanceBreakdown.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tuition Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlBalanceBreakdown.setMinimumSize(new java.awt.Dimension(860, 300));
        jpnlBalanceBreakdown.setPreferredSize(new java.awt.Dimension(860, 300));
        jpnlBalanceBreakdown.setLayout(new java.awt.GridBagLayout());

        jScrollPane5.setMinimumSize(new java.awt.Dimension(840, 275));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(840, 275));

        jtblBalanceBreakDown.setAutoCreateRowSorter(true);
        jtblBalanceBreakDown.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblBalanceBreakDown.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Amount Due", "Balance", "Due Date", "Paid", "Penalty", "OR #"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblBalanceBreakDown.setEnabled(false);
        jtblBalanceBreakDown.setRowHeight(20);
        jtblBalanceBreakDown.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtblBalanceBreakDown);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlBalanceBreakdown.add(jScrollPane5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        tabpanel_makepayment.add(jpnlBalanceBreakdown, gridBagConstraints);

        panel_balancebreakdowncontainer2.setMinimumSize(new java.awt.Dimension(590, 100));
        panel_balancebreakdowncontainer2.setPreferredSize(new java.awt.Dimension(590, 100));
        panel_balancebreakdowncontainer2.setLayout(new java.awt.GridBagLayout());

        jbtnMakePayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnMakePayment.setText("Make Payment");
        jbtnMakePayment.setEnabled(false);
        jbtnMakePayment.setMaximumSize(new java.awt.Dimension(200, 50));
        jbtnMakePayment.setMinimumSize(new java.awt.Dimension(200, 50));
        jbtnMakePayment.setPreferredSize(new java.awt.Dimension(200, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_balancebreakdowncontainer2.add(jbtnMakePayment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        tabpanel_makepayment.add(panel_balancebreakdowncontainer2, gridBagConstraints);

        jTabbedPane1.addTab("Make Payment", tabpanel_makepayment);

        tabpanel_paymenthistory.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_paymenthistory.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_paymenthistory.setLayout(new java.awt.GridBagLayout());

        panel_historycontrol.setMinimumSize(new java.awt.Dimension(1190, 80));
        panel_historycontrol.setPreferredSize(new java.awt.Dimension(1190, 80));
        panel_historycontrol.setLayout(new java.awt.GridBagLayout());

        jtfPaymentHistorySearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfPaymentHistorySearchBox.setText("Search here");
        jtfPaymentHistorySearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
        jtfPaymentHistorySearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 750, 0, 0);
        panel_historycontrol.add(jtfPaymentHistorySearchBox, gridBagConstraints);

        jbtnPaymentHistorySearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPaymentHistorySearch.setText("Search");
        jbtnPaymentHistorySearch.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnPaymentHistorySearch.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnPaymentHistorySearch.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        panel_historycontrol.add(jbtnPaymentHistorySearch, gridBagConstraints);

        lbl_show.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        panel_historycontrol.add(lbl_show, gridBagConstraints);

        jcmbPaymentHistorySearchBy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbPaymentHistorySearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OR Number", "Transaction Description" }));
        jcmbPaymentHistorySearchBy.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbPaymentHistorySearchBy.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 100);
        panel_historycontrol.add(jcmbPaymentHistorySearchBy, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        tabpanel_paymenthistory.add(panel_historycontrol, gridBagConstraints);

        jpnlHistoryDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "History Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlHistoryDetails.setMinimumSize(new java.awt.Dimension(1195, 320));
        jpnlHistoryDetails.setPreferredSize(new java.awt.Dimension(1195, 320));
        jpnlHistoryDetails.setLayout(new java.awt.GridBagLayout());

        jScrollPane6.setMinimumSize(new java.awt.Dimension(1182, 300));
        jScrollPane6.setName(""); // NOI18N
        jScrollPane6.setPreferredSize(new java.awt.Dimension(1182, 300));

        jtblPaymentHistory.setAutoCreateRowSorter(true);
        jtblPaymentHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OR Number", "Date", "Transaction Description", "Credit", "Debit", "Document Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPaymentHistory.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jtblPaymentHistory.setRowHeight(20);
        jtblPaymentHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jtblPaymentHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jpnlHistoryDetails.add(jScrollPane6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        tabpanel_paymenthistory.add(jpnlHistoryDetails, gridBagConstraints);

        panel_totalcontainer.setMinimumSize(new java.awt.Dimension(1190, 40));
        panel_totalcontainer.setPreferredSize(new java.awt.Dimension(1190, 40));
        panel_totalcontainer.setLayout(new java.awt.GridBagLayout());

        jtfPaymentHistoryTotalCredit.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfPaymentHistoryTotalCredit.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfPaymentHistoryTotalCredit.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_totalcontainer.add(jtfPaymentHistoryTotalCredit, gridBagConstraints);

        lbl_show1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show1.setText("Total Credit :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 750, 0, 0);
        panel_totalcontainer.add(lbl_show1, gridBagConstraints);

        lbl_show2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show2.setText("Total Debit :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panel_totalcontainer.add(lbl_show2, gridBagConstraints);

        jtfPaymentHistoryTotalDebit.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfPaymentHistoryTotalDebit.setMinimumSize(new java.awt.Dimension(100, 25));
        jtfPaymentHistoryTotalDebit.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_totalcontainer.add(jtfPaymentHistoryTotalDebit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        tabpanel_paymenthistory.add(panel_totalcontainer, gridBagConstraints);

        jTabbedPane1.addTab("Payment History", tabpanel_paymenthistory);

        tabpanel_discounts.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_discounts.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_discounts.setLayout(new java.awt.GridBagLayout());

        panel_historydetails2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students Discounts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_historydetails2.setMinimumSize(new java.awt.Dimension(1195, 390));
        panel_historydetails2.setPreferredSize(new java.awt.Dimension(1195, 390));
        panel_historydetails2.setLayout(new java.awt.GridBagLayout());

        jScrollPane8.setMinimumSize(new java.awt.Dimension(1182, 360));
        jScrollPane8.setName(""); // NOI18N
        jScrollPane8.setPreferredSize(new java.awt.Dimension(1182, 360));

        jtblDiscounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "School Year", "Discount Type", "Percentage", "Amount", "Date Applied"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblDiscounts.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jtblDiscounts.setRowHeight(20);
        jtblDiscounts.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jtblDiscounts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historydetails2.add(jScrollPane8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        tabpanel_discounts.add(panel_historydetails2, gridBagConstraints);

        panel_historycontrol2.setMinimumSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol2.setPreferredSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol2.setLayout(new java.awt.GridBagLayout());

        jtfDiscountsSearch.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfDiscountsSearch.setText("Search here");
        jtfDiscountsSearch.setMinimumSize(new java.awt.Dimension(200, 25));
        jtfDiscountsSearch.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panel_historycontrol2.add(jtfDiscountsSearch, gridBagConstraints);

        jbtnDiscountsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDiscountsSearch.setText("Search");
        jbtnDiscountsSearch.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsSearch.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsSearch.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        panel_historycontrol2.add(jbtnDiscountsSearch, gridBagConstraints);

        lbl_show4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show4.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panel_historycontrol2.add(lbl_show4, gridBagConstraints);

        jbtnDiscountsSearchBy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDiscountsSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Discount Type", "School Year", " " }));
        jbtnDiscountsSearchBy.setMinimumSize(new java.awt.Dimension(150, 25));
        jbtnDiscountsSearchBy.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_historycontrol2.add(jbtnDiscountsSearchBy, gridBagConstraints);

        jbtnDiscountsView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDiscountsView.setText("View");
        jbtnDiscountsView.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsView.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsView.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historycontrol2.add(jbtnDiscountsView, gridBagConstraints);

        jbtnDiscountsPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDiscountsPrint.setText("Print");
        jbtnDiscountsPrint.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsPrint.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnDiscountsPrint.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 500);
        panel_historycontrol2.add(jbtnDiscountsPrint, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        tabpanel_discounts.add(panel_historycontrol2, gridBagConstraints);

        jTabbedPane1.addTab("Discounts", tabpanel_discounts);

        tabpanel_Receipts.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_Receipts.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_Receipts.setLayout(new java.awt.GridBagLayout());

        panel_historycontrol1.setMinimumSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol1.setPreferredSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol1.setLayout(new java.awt.GridBagLayout());

        jtfReceiptsSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfReceiptsSearchBox.setText("Search here");
        jtfReceiptsSearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
        jtfReceiptsSearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panel_historycontrol1.add(jtfReceiptsSearchBox, gridBagConstraints);

        jbtnReceiptsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnReceiptsSearch.setText("Search");
        jbtnReceiptsSearch.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsSearch.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsSearch.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        panel_historycontrol1.add(jbtnReceiptsSearch, gridBagConstraints);

        lbl_show3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show3.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panel_historycontrol1.add(lbl_show3, gridBagConstraints);

        jcmbReceiptsSearchBy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbReceiptsSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OR Number", "Transaction Description", "School Year" }));
        jcmbReceiptsSearchBy.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbReceiptsSearchBy.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_historycontrol1.add(jcmbReceiptsSearchBy, gridBagConstraints);

        jbtnReceiptsView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnReceiptsView.setText("View");
        jbtnReceiptsView.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsView.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsView.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historycontrol1.add(jbtnReceiptsView, gridBagConstraints);

        jbtnReceiptsPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnReceiptsPrint.setText("Print");
        jbtnReceiptsPrint.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsPrint.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnReceiptsPrint.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 500);
        panel_historycontrol1.add(jbtnReceiptsPrint, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        tabpanel_Receipts.add(panel_historycontrol1, gridBagConstraints);

        panel_historydetails1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Receipts Master List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_historydetails1.setMinimumSize(new java.awt.Dimension(1195, 390));
        panel_historydetails1.setPreferredSize(new java.awt.Dimension(1195, 390));
        panel_historydetails1.setLayout(new java.awt.GridBagLayout());

        jScrollPane7.setMinimumSize(new java.awt.Dimension(1182, 360));
        jScrollPane7.setName(""); // NOI18N
        jScrollPane7.setPreferredSize(new java.awt.Dimension(1182, 360));

        jtblReceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OR Number", "Date", "Transaction Description", "School Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblReceipts.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jtblReceipts.setRowHeight(20);
        jtblReceipts.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jtblReceipts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historydetails1.add(jScrollPane7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        tabpanel_Receipts.add(panel_historydetails1, gridBagConstraints);

        jTabbedPane1.addTab("Receipts", tabpanel_Receipts);

        tabpanel_Adjustments.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_Adjustments.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_Adjustments.setLayout(new java.awt.GridBagLayout());

        panel_historycontrol3.setMinimumSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol3.setPreferredSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol3.setLayout(new java.awt.GridBagLayout());

        jbtnAdjustmentsSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jbtnAdjustmentsSearchBox.setText("Search here");
        jbtnAdjustmentsSearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
        jbtnAdjustmentsSearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panel_historycontrol3.add(jbtnAdjustmentsSearchBox, gridBagConstraints);

        jbtnAdjustmentsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAdjustmentsSearch.setText("Search");
        jbtnAdjustmentsSearch.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnAdjustmentsSearch.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnAdjustmentsSearch.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        panel_historycontrol3.add(jbtnAdjustmentsSearch, gridBagConstraints);

        lbl_show5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show5.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panel_historycontrol3.add(lbl_show5, gridBagConstraints);

        jcmbAdjustmentsSearchBy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbAdjustmentsSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "School Year", "Adjustment Description", "Amount", "Approved", "Approved By", "Document Number" }));
        jcmbAdjustmentsSearchBy.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbAdjustmentsSearchBy.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_historycontrol3.add(jcmbAdjustmentsSearchBy, gridBagConstraints);

        jbtnAdjustmentPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAdjustmentPrint.setText("Print");
        jbtnAdjustmentPrint.setMaximumSize(new java.awt.Dimension(71, 30));
        jbtnAdjustmentPrint.setMinimumSize(new java.awt.Dimension(71, 30));
        jbtnAdjustmentPrint.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 420);
        panel_historycontrol3.add(jbtnAdjustmentPrint, gridBagConstraints);

        jbtnAdjustmentsMakeAdjustment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAdjustmentsMakeAdjustment.setText("Make Adjustment");
        jbtnAdjustmentsMakeAdjustment.setMaximumSize(new java.awt.Dimension(150, 30));
        jbtnAdjustmentsMakeAdjustment.setMinimumSize(new java.awt.Dimension(150, 30));
        jbtnAdjustmentsMakeAdjustment.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historycontrol3.add(jbtnAdjustmentsMakeAdjustment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        tabpanel_Adjustments.add(panel_historycontrol3, gridBagConstraints);

        jpnlStudentAdjustments.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Adjustments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlStudentAdjustments.setMinimumSize(new java.awt.Dimension(1195, 390));
        jpnlStudentAdjustments.setPreferredSize(new java.awt.Dimension(1195, 390));
        jpnlStudentAdjustments.setLayout(new java.awt.GridBagLayout());

        jScrollPane9.setMinimumSize(new java.awt.Dimension(1182, 360));
        jScrollPane9.setName(""); // NOI18N
        jScrollPane9.setPreferredSize(new java.awt.Dimension(1182, 360));

        jtblAdjustments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date Applied", "Adjustment Description", "Amount", "Requested By", "Approved By", "School Year", "Document Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblAdjustments.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jtblAdjustments.setRowHeight(20);
        jtblAdjustments.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jtblAdjustments);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jpnlStudentAdjustments.add(jScrollPane9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        tabpanel_Adjustments.add(jpnlStudentAdjustments, gridBagConstraints);

        jTabbedPane1.addTab("Adjustments", tabpanel_Adjustments);

        tabpanel_StatementofAccount.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_StatementofAccount.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_StatementofAccount.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Statement of Account", tabpanel_StatementofAccount);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        tabpanel_accountbalance1.setMinimumSize(new java.awt.Dimension(1195, 450));
        tabpanel_accountbalance1.setPreferredSize(new java.awt.Dimension(1195, 450));
        tabpanel_accountbalance1.setLayout(new java.awt.GridBagLayout());

        panel_historycontrol5.setMinimumSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol5.setPreferredSize(new java.awt.Dimension(1190, 40));
        panel_historycontrol5.setLayout(new java.awt.GridBagLayout());

        Searchbox8.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        Searchbox8.setText("Search here");
        Searchbox8.setMinimumSize(new java.awt.Dimension(200, 25));
        Searchbox8.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 0);
        panel_historycontrol5.add(Searchbox8, gridBagConstraints);

        btn_Search10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search10.setText("Search");
        btn_Search10.setMaximumSize(new java.awt.Dimension(71, 30));
        btn_Search10.setMinimumSize(new java.awt.Dimension(71, 30));
        btn_Search10.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        panel_historycontrol5.add(btn_Search10, gridBagConstraints);

        lbl_show7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show7.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        panel_historycontrol5.add(lbl_show7, gridBagConstraints);

        combo_filter5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combo_filter5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "School Year", "Adjustment Description", "Amount", "Approved", "Approved By", "Document Number" }));
        combo_filter5.setMinimumSize(new java.awt.Dimension(130, 25));
        combo_filter5.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_historycontrol5.add(combo_filter5, gridBagConstraints);

        btn_Search14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search14.setText("Print");
        btn_Search14.setMaximumSize(new java.awt.Dimension(71, 30));
        btn_Search14.setMinimumSize(new java.awt.Dimension(71, 30));
        btn_Search14.setPreferredSize(new java.awt.Dimension(71, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel_historycontrol5.add(btn_Search14, gridBagConstraints);

        btn_Search15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Search15.setText("Pay Balance");
        btn_Search15.setMaximumSize(new java.awt.Dimension(150, 30));
        btn_Search15.setMinimumSize(new java.awt.Dimension(150, 30));
        btn_Search15.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historycontrol5.add(btn_Search15, gridBagConstraints);

        lbl_remainingbalance2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_remainingbalance2.setText("Total Balance :");
        lbl_remainingbalance2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 0);
        panel_historycontrol5.add(lbl_remainingbalance2, gridBagConstraints);

        display_remainingbalance2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        display_remainingbalance2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
        display_remainingbalance2.setMaximumSize(new java.awt.Dimension(150, 20));
        display_remainingbalance2.setMinimumSize(new java.awt.Dimension(150, 20));
        display_remainingbalance2.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_historycontrol5.add(display_remainingbalance2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        tabpanel_accountbalance1.add(panel_historycontrol5, gridBagConstraints);

        panel_historydetails5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Balance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_historydetails5.setMinimumSize(new java.awt.Dimension(1195, 390));
        panel_historydetails5.setPreferredSize(new java.awt.Dimension(1195, 390));
        panel_historydetails5.setLayout(new java.awt.GridBagLayout());

        jScrollPane13.setMinimumSize(new java.awt.Dimension(1182, 360));
        jScrollPane13.setName(""); // NOI18N
        jScrollPane13.setPreferredSize(new java.awt.Dimension(1182, 360));

        jTable11.setAutoCreateRowSorter(true);
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Balance Description", "Amount", "Paid", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.setIntercellSpacing(new java.awt.Dimension(20, 1));
        jTable11.setRowHeight(20);
        jTable11.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(jTable11);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_historydetails5.add(jScrollPane13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        tabpanel_accountbalance1.add(panel_historydetails5, gridBagConstraints);

        jPanel2.add(tabpanel_accountbalance1, new java.awt.GridBagConstraints());

        jTabbedPane1.addTab("Account Balance", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_tabscontainer.add(jTabbedPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_tabscontainer, gridBagConstraints);

        jScrollPane10.setViewportView(panel_toppanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jScrollPane10, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Searchbox8;
    private javax.swing.JButton btn_Search10;
    private javax.swing.JButton btn_Search14;
    private javax.swing.JButton btn_Search15;
    private javax.swing.JButton btn_addDiscount;
    private javax.swing.JButton btn_removeDiscount;
    private javax.swing.JComboBox<String> combo_filter5;
    private javax.swing.JLabel display_remainingbalance2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable11;
    private javax.swing.JButton jbtnAdjustmentPrint;
    private javax.swing.JButton jbtnAdjustmentsMakeAdjustment;
    private javax.swing.JButton jbtnAdjustmentsSearch;
    private javax.swing.JTextField jbtnAdjustmentsSearchBox;
    private javax.swing.JButton jbtnDiscountsPrint;
    private javax.swing.JButton jbtnDiscountsSearch;
    private javax.swing.JComboBox<String> jbtnDiscountsSearchBy;
    private javax.swing.JButton jbtnDiscountsView;
    private javax.swing.JButton jbtnMakePayment;
    private javax.swing.JButton jbtnPaymentHistorySearch;
    private javax.swing.JButton jbtnReceiptsPrint;
    private javax.swing.JButton jbtnReceiptsSearch;
    private javax.swing.JButton jbtnReceiptsView;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JCheckBox jcbDiscount;
    private javax.swing.JComboBox<String> jcmbAdjustmentsSearchBy;
    private javax.swing.JComboBox<String> jcmbDiscount;
    private javax.swing.JComboBox<String> jcmbPaymentHistorySearchBy;
    private javax.swing.JComboBox<String> jcmbPaymentTerm;
    private javax.swing.JComboBox<String> jcmbReceiptsSearchBy;
    private javax.swing.JLabel jlblDiscountPercentText;
    private javax.swing.JLabel jlblRemainingBalanceText;
    private javax.swing.JLabel jlblStudentNo;
    private javax.swing.JLabel jlblTotalPaidText;
    private javax.swing.JPanel jpnlBalanceBreakdown;
    private javax.swing.JPanel jpnlBalanceStatus;
    private javax.swing.JPanel jpnlBasic;
    private javax.swing.JPanel jpnlCurrentSchoolYearTuition;
    private javax.swing.JPanel jpnlDiscount;
    private javax.swing.JPanel jpnlDownpayment;
    private javax.swing.JPanel jpnlFeesContainer;
    private javax.swing.JPanel jpnlHistoryDetails;
    private javax.swing.JPanel jpnlMiscellaneous;
    private javax.swing.JPanel jpnlOthers;
    private javax.swing.JPanel jpnlPhotoContainer;
    private javax.swing.JPanel jpnlStudentAdjustments;
    private javax.swing.JPanel jpnlStudentDetails;
    private javax.swing.JTable jtblAdjustments;
    private javax.swing.JTable jtblBalanceBreakDown;
    private javax.swing.JTable jtblBasic;
    private javax.swing.JTable jtblDiscounts;
    private javax.swing.JTable jtblDownpayment;
    private javax.swing.JTable jtblMiscellaneous;
    private javax.swing.JTable jtblOthers;
    private javax.swing.JTable jtblPaymentHistory;
    private javax.swing.JTable jtblReceipts;
    private javax.swing.JTextField jtfBasicFee;
    private javax.swing.JTextField jtfDiscount;
    private javax.swing.JTextField jtfDiscountsSearch;
    private javax.swing.JTextField jtfDownPayment;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfGradeLevel;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfMiddleName;
    private javax.swing.JTextField jtfMiscellaneous;
    private javax.swing.JTextField jtfOtherFees;
    private javax.swing.JTextField jtfPaymentHistorySearchBox;
    private javax.swing.JTextField jtfPaymentHistoryTotalCredit;
    private javax.swing.JTextField jtfPaymentHistoryTotalDebit;
    private javax.swing.JTextField jtfReceiptsSearchBox;
    private javax.swing.JTextField jtfSearchBoxMakePayment;
    private javax.swing.JTextField jtfStatus;
    private javax.swing.JTextField jtfStudentNo;
    private javax.swing.JTextField jtfStudentType;
    private javax.swing.JTextField jtfTotal;
    private javax.swing.JLabel lbl_basicfee;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_firstname;
    private javax.swing.JLabel lbl_gradelevel;
    private javax.swing.JLabel lbl_lastname;
    private javax.swing.JLabel lbl_middlename;
    private javax.swing.JLabel lbl_misc;
    private javax.swing.JLabel lbl_otherfees;
    private javax.swing.JLabel lbl_paymentterm;
    private javax.swing.JLabel lbl_percent;
    private javax.swing.JLabel lbl_remainingbalance;
    private javax.swing.JLabel lbl_remainingbalance2;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JLabel lbl_show1;
    private javax.swing.JLabel lbl_show2;
    private javax.swing.JLabel lbl_show3;
    private javax.swing.JLabel lbl_show4;
    private javax.swing.JLabel lbl_show5;
    private javax.swing.JLabel lbl_show7;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalpaid;
    private javax.swing.JLabel lbl_type;
    private javax.swing.JPanel panel_balancebreakdowncontainer2;
    private javax.swing.JPanel panel_historycontrol;
    private javax.swing.JPanel panel_historycontrol1;
    private javax.swing.JPanel panel_historycontrol2;
    private javax.swing.JPanel panel_historycontrol3;
    private javax.swing.JPanel panel_historycontrol5;
    private javax.swing.JPanel panel_historydetails1;
    private javax.swing.JPanel panel_historydetails2;
    private javax.swing.JPanel panel_historydetails5;
    private javax.swing.JPanel panel_searchcontainer;
    private javax.swing.JPanel panel_separator;
    private javax.swing.JPanel panel_statuscontainer;
    private javax.swing.JPanel panel_studentdetails;
    private javax.swing.JPanel panel_studentdetailscontainer;
    private javax.swing.JPanel panel_tabscontainer;
    private javax.swing.JPanel panel_toppanel;
    private javax.swing.JPanel panel_totalcontainer;
    private javax.swing.JPanel tabpanel_Adjustments;
    private javax.swing.JPanel tabpanel_Receipts;
    private javax.swing.JPanel tabpanel_StatementofAccount;
    private javax.swing.JPanel tabpanel_accountbalance1;
    private javax.swing.JPanel tabpanel_discounts;
    private javax.swing.JPanel tabpanel_makepayment;
    private javax.swing.JPanel tabpanel_paymenthistory;
    // End of variables declaration//GEN-END:variables
}