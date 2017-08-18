package view.payment;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import component_model_loader.DiscountML;
import component_model_loader.PaymentTermML;
import utility.component.ImageUtil;
import component_model_loader.SchoolFeesML;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import model.gradelevel.CurrentGradeLevel;
import model.student.Student;
import constants.DashboardMenuItem;
import controller.navigation.UINavigationExit;
import controller.payment.DisplayPaymentFormController;
import controller.payment.EnablePaySelectedButton;
import controller.payment.SearchStudentController;
import controller.payment.DiscountChangeController;
import daoimpl.DiscountDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolFeesDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import java.text.DecimalFormat;
import model.balancebreakdownfee.BalanceBreakDownFee;
import model.discount.Discount;
import model.paymentterm.PaymentTerm;
import model.schoolfees.SchoolFees;
import model.tuitionfee.TuitionFee;
import service.TuitionFeeProcessor;
import threads.SchoolYearLoaderThread;
import utility.component.JInternalFrameUtil;

/**
 *
 * @author Jordan
 */
public class PaymentAndAssessmentForm extends javax.swing.JPanel {

    GUIManager guiManager = new GUIManager();
    private final GradeLevelDaoImpl gradeLevelDaoImpl = new GradeLevelDaoImpl();
    private final DiscountML discountML = new DiscountML();
    private final SchoolFeesML schoolFeesML = new SchoolFeesML();
    private static final SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
    private static final StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    private final SchoolFeesDaoImpl schoolFeesDaoImpl = new SchoolFeesDaoImpl();
    private final TuitionFeeDaoImpl tuitionFeeDaoImpl = new TuitionFeeDaoImpl();
    private DisplayPaymentFormController displayPaymentFormController;
    
    private int studentId;
    private final Image studentPhoto;
    
    public PaymentAndAssessmentForm() {
        initComponents();
        initializeComponents();
        initializeControllers();

        jlblStudentTypeText.setText("");
        jlblLastNameText.setText("");
        jlblFirstNameText.setText("");
        jlblMiddleNameText.setText("");
        jlblAdmissionGradeLevelText.setText("");
        jlblPresentGradeLevelText.setText("");
        jlblStudentStatusText.setText("");
        
//        guiManager.initializeRenderers();
        guiManager.initializeModels();
        guiManager.resetForm();
        studentPhoto = new ImageUtil().getResourceAsImage("assets/usernameIcon.jpg", 200,200);
        SchoolYearLoaderThread schoolYearLoaderThread = new SchoolYearLoaderThread(jlblCurrentSchoolYear);
        schoolYearLoaderThread.start();
    }

    private void initializeComponents(){
        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        UIManager.put("TextField.inactiveForeground", Color.BLACK);
        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        jScrollPane4.getVerticalScrollBar().setUnitIncrement(40);
        jspFeeCollectionItems.getVerticalScrollBar().setUnitIncrement(40);
        jScrollPane5.getVerticalScrollBar().setUnitIncrement(40);
        //jtblBalanceBreakdown.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCurrentDateJLabelText();
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        jtblDownPaymentFee.setRowHeight(30);
        jtblBasicFee.setRowHeight(30);
        jtblMiscFees.setRowHeight(30);
    }
    
    private void initializeControllers() {
        jmiExit.addActionListener(new UINavigationExit(this, DashboardMenuItem.PAYMENTS));

        jtfStudentID.addKeyListener(new SearchStudentController(
                jtfTotalFeesWithDiscount, jbtnRemoveDiscount,
                jcmbPaymentTerm, jtfStudentID, jcmbSchoolYearFrom, jlblStudentTypeText,
                jlblLastNameText, jlblFirstNameText, jlblMiddleNameText,
                jlblAdmissionGradeLevelText, jlblPresentGradeLevelText,
                jlblStudentStatusText, jtfBasicFee, jtfMiscellaneousFee,
                jtfOtherFee, jtfTotalFees, jtfTotalPaid, jtfRemainingBalance,
                jcmbDiscount, jtfDiscountPercentage, jtfDiscounts, jtblBalanceBreakdown,
                jtblDownPaymentFee, jtblBasicFee, jtblMiscFees, jtblOtherFees));

        displayPaymentFormController = new DisplayPaymentFormController(
                jtfStudentID, jcmbSchoolYearFrom, jtblBalanceBreakdown, jcmbDiscount, jcmbPaymentTerm);
        jbtnPaySelected.addActionListener(displayPaymentFormController);
        jtblBalanceBreakdown.addMouseListener(new EnablePaySelectedButton(jtblBalanceBreakdown, jbtnPaySelected));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnGrpStudentType = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jpnlStudentInfo = new javax.swing.JPanel();
        jlblStudentID = new javax.swing.JLabel();
        jlblLastName = new javax.swing.JLabel();
        jlblFirstName = new javax.swing.JLabel();
        jlblMiddleName = new javax.swing.JLabel();
        jlblPreviousGradeLevel = new javax.swing.JLabel();
        jtfStudentID = new javax.swing.JTextField();
        jlblLastNameText = new javax.swing.JLabel();
        jlblFirstNameText = new javax.swing.JLabel();
        jlblMiddleNameText = new javax.swing.JLabel();
        jlblPresentGradeLevelText = new javax.swing.JLabel();
        jlblStudentType = new javax.swing.JLabel();
        jlblStudentTypeText = new javax.swing.JLabel();
        jlblAdmissionGradeLevel = new javax.swing.JLabel();
        jlblAdmissionGradeLevelText = new javax.swing.JLabel();
        jlblStudentStatus = new javax.swing.JLabel();
        jlblStudentStatusText = new javax.swing.JLabel();
        jpnlFeeSummary = new javax.swing.JPanel();
        jlblTotalFees = new javax.swing.JLabel();
        jtfBasicFee = new javax.swing.JTextField();
        jtfDiscounts = new javax.swing.JTextField();
        jlblDiscounts = new javax.swing.JLabel();
        jlblTotalPaid = new javax.swing.JLabel();
        jtfTotalPaid = new javax.swing.JTextField();
        jlblRemainingBalance = new javax.swing.JLabel();
        jtfRemainingBalance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfOtherFee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfTotalFees = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfMiscellaneousFee = new javax.swing.JTextField();
        jlblTotalFeesWithDiscount = new javax.swing.JLabel();
        jtfTotalFeesWithDiscount = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlblCurrentSchoolYear = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblDateToday = new javax.swing.JLabel();
        jpnlPhotoContainer = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.8f));
            g2d.drawImage(studentPhoto, 0, 0, getWidth(), getHeight(), null);
            jPanel1.repaint();
        }

    };
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jpnlFeeCollectionItems = new javax.swing.JPanel();
    jspFeeCollectionItems = new javax.swing.JScrollPane();
    jPanel14 = new javax.swing.JPanel();
    jpnlBreakdownOfFees = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jPanel11 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jtblDownPaymentFee = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jspOtherFees = new javax.swing.JScrollPane();
    jtblOtherFees = new javax.swing.JTable();
    jspMiscFees = new javax.swing.JScrollPane();
    jtblMiscFees = new javax.swing.JTable();
    jspAcademicFees = new javax.swing.JScrollPane();
    jtblBasicFee = new javax.swing.JTable();
    jPanel7 = new javax.swing.JPanel();
    jpnlBalanceBreakdown = new javax.swing.JPanel();
    jspFeesPerPaymentTerm = new javax.swing.JScrollPane();
    jtblBalanceBreakdown = new javax.swing.JTable();
    jPanel9 = new javax.swing.JPanel();
    jbtnPaySelected = new javax.swing.JButton();
    jpnlPaymentTermSelection = new javax.swing.JPanel();
    jlblPaymentTerm = new javax.swing.JLabel();
    jcmbPaymentTerm = new javax.swing.JComboBox<>();
    jpnlApplyDiscount = new javax.swing.JPanel();
    jlblDiscount = new javax.swing.JLabel();
    jcmbDiscount = new javax.swing.JComboBox<>();
    jlblPercentOfDiscount = new javax.swing.JLabel();
    jtfDiscountPercentage = new javax.swing.JTextField();
    jbtnRemoveDiscount = new javax.swing.JButton();
    jpnlFilter = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
    jLabel8 = new javax.swing.JLabel();
    jcmbSchoolYearTo = new javax.swing.JComboBox<>();
    jPanel4 = new javax.swing.JPanel();
    jpnlTransactionHistory = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jtblTransactionHistory = new javax.swing.JTable();
    jpnlTransactionSchoolYearFilter = new javax.swing.JPanel();
    jlblTransactionSchoolYear = new javax.swing.JLabel();
    jcmbTransactionSyYearFrom = new javax.swing.JComboBox<>();
    jPanel10 = new javax.swing.JPanel();
    jpnlReceipts = new javax.swing.JPanel();
    jpnlDiscounts = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtblDiscountsInformation = new javax.swing.JTable();
    jPanel8 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jmiExit = new javax.swing.JMenuItem();

    setLayout(new java.awt.GridBagLayout());

    jPanel13.setLayout(new java.awt.GridBagLayout());

    jInternalFrame1.setVisible(true);
    jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

    jpnlContent.setLayout(new java.awt.GridBagLayout());

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setPreferredSize(new java.awt.Dimension(1133, 900));
    jPanel1.setLayout(new java.awt.GridBagLayout());

    jPanel2.setLayout(new java.awt.GridBagLayout());

    jPanel5.setLayout(new java.awt.GridBagLayout());

    jpnlStudentInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));
    jpnlStudentInfo.setLayout(new java.awt.GridBagLayout());

    jlblStudentID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblStudentID.setText("Student ID");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblStudentID, gridBagConstraints);

    jlblLastName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblLastName.setText("Last Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblLastName, gridBagConstraints);

    jlblFirstName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblFirstName.setText("First Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblFirstName, gridBagConstraints);

    jlblMiddleName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblMiddleName.setText("Middle Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblMiddleName, gridBagConstraints);

    jlblPreviousGradeLevel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblPreviousGradeLevel.setText("Present :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblPreviousGradeLevel, gridBagConstraints);

    jtfStudentID.setColumns(10);
    jtfStudentID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jtfStudentID, gridBagConstraints);

    jlblLastNameText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jlblLastNameText.setText("LastNameText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblLastNameText, gridBagConstraints);

    jlblFirstNameText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jlblFirstNameText.setText("FirstNameText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblFirstNameText, gridBagConstraints);

    jlblMiddleNameText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jlblMiddleNameText.setText("MiddleNameText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblMiddleNameText, gridBagConstraints);

    jlblPresentGradeLevelText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jlblPresentGradeLevelText.setText("PresentGradeLevelText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblPresentGradeLevelText, gridBagConstraints);

    jlblStudentType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblStudentType.setText("Student Type :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblStudentType, gridBagConstraints);

    jlblStudentTypeText.setText("StudentTypeText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblStudentTypeText, gridBagConstraints);

    jlblAdmissionGradeLevel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblAdmissionGradeLevel.setText("Admission :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblAdmissionGradeLevel, gridBagConstraints);

    jlblAdmissionGradeLevelText.setText("AdmissionGradeLevelText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblAdmissionGradeLevelText, gridBagConstraints);

    jlblStudentStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jlblStudentStatus.setText("Status :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblStudentStatus, gridBagConstraints);

    jlblStudentStatusText.setText("ActiveOrInactive");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentInfo.add(jlblStudentStatusText, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel5.add(jpnlStudentInfo, gridBagConstraints);

    jpnlFeeSummary.setBorder(javax.swing.BorderFactory.createTitledBorder("Tuition For SY"));
    jpnlFeeSummary.setLayout(new java.awt.GridBagLayout());

    jlblTotalFees.setText("Basic Fee");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jlblTotalFees, gridBagConstraints);

    jtfBasicFee.setColumns(10);
    jtfBasicFee.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfBasicFee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfBasicFee.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfBasicFee, gridBagConstraints);

    jtfDiscounts.setColumns(10);
    jtfDiscounts.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfDiscounts.setForeground(new java.awt.Color(0, 0, 0));
    jtfDiscounts.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfDiscounts.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfDiscounts, gridBagConstraints);

    jlblDiscounts.setText("Discount");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jlblDiscounts, gridBagConstraints);

    jlblTotalPaid.setText("Total Paid");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jlblTotalPaid, gridBagConstraints);

    jtfTotalPaid.setColumns(10);
    jtfTotalPaid.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfTotalPaid.setForeground(new java.awt.Color(0, 0, 0));
    jtfTotalPaid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfTotalPaid.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfTotalPaid, gridBagConstraints);

    jlblRemainingBalance.setText("Remaining Balance");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jlblRemainingBalance, gridBagConstraints);

    jtfRemainingBalance.setColumns(10);
    jtfRemainingBalance.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfRemainingBalance.setForeground(new java.awt.Color(0, 0, 0));
    jtfRemainingBalance.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfRemainingBalance.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfRemainingBalance, gridBagConstraints);

    jLabel5.setText("Other Fees");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jLabel5, gridBagConstraints);

    jtfOtherFee.setColumns(10);
    jtfOtherFee.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfOtherFee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfOtherFee.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfOtherFee, gridBagConstraints);

    jLabel9.setText("Total Fees");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jLabel9, gridBagConstraints);

    jtfTotalFees.setColumns(10);
    jtfTotalFees.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfTotalFees.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfTotalFees.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfTotalFees, gridBagConstraints);

    jLabel10.setText("Miscellaneous Fees");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jLabel10, gridBagConstraints);

    jtfMiscellaneousFee.setColumns(10);
    jtfMiscellaneousFee.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfMiscellaneousFee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfMiscellaneousFee.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfMiscellaneousFee, gridBagConstraints);

    jlblTotalFeesWithDiscount.setText("Total Fees w / Discount");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jlblTotalFeesWithDiscount, gridBagConstraints);

    jtfTotalFeesWithDiscount.setColumns(10);
    jtfTotalFeesWithDiscount.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    jtfTotalFeesWithDiscount.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfTotalFeesWithDiscount.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeSummary.add(jtfTotalFeesWithDiscount, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel5.add(jpnlFeeSummary, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel2.add(jPanel5, gridBagConstraints);

    jPanel6.setLayout(new java.awt.GridBagLayout());

    jPanel16.setLayout(new java.awt.GridBagLayout());

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel6.setText("Current School Year :  ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel16.add(jLabel6, gridBagConstraints);

    jlblCurrentSchoolYear.setText("SY");
    jlblCurrentSchoolYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jlblCurrentSchoolYearPropertyChange(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel16.add(jlblCurrentSchoolYear, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel6.add(jPanel16, gridBagConstraints);

    jLabel1.setBackground(new java.awt.Color(255, 255, 0));
    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setText("Date Today: ");
    jLabel1.setOpaque(true);
    jPanel17.add(jLabel1);

    jlblDateToday.setBackground(new java.awt.Color(255, 255, 0));
    jlblDateToday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlblDateToday.setText("Date Goes Here");
    jlblDateToday.setOpaque(true);
    jPanel17.add(jlblDateToday);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel6.add(jPanel17, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jPanel2.add(jPanel6, gridBagConstraints);

    jpnlPhotoContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlPhotoContainer.setMaximumSize(new java.awt.Dimension(200, 200));
    jpnlPhotoContainer.setMinimumSize(new java.awt.Dimension(200, 200));
    jpnlPhotoContainer.setPreferredSize(new java.awt.Dimension(200, 200));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel2.add(jpnlPhotoContainer, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jPanel1.add(jPanel2, gridBagConstraints);

    jpnlFeeCollectionItems.setMinimumSize(new java.awt.Dimension(381, 56));
    jpnlFeeCollectionItems.setLayout(new java.awt.GridBagLayout());

    jspFeeCollectionItems.setPreferredSize(new java.awt.Dimension(1115, 300));

    jPanel14.setLayout(new java.awt.GridBagLayout());

    jpnlBreakdownOfFees.setBorder(javax.swing.BorderFactory.createTitledBorder("School Fees"));
    jpnlBreakdownOfFees.setMinimumSize(new java.awt.Dimension(550, 550));
    jpnlBreakdownOfFees.setPreferredSize(new java.awt.Dimension(550, 550));
    jpnlBreakdownOfFees.setLayout(new java.awt.GridBagLayout());

    jScrollPane4.setPreferredSize(new java.awt.Dimension(462, 700));

    jPanel11.setLayout(new java.awt.GridBagLayout());

    jScrollPane3.setMinimumSize(new java.awt.Dimension(20, 50));
    jScrollPane3.setPreferredSize(new java.awt.Dimension(453, 60));

    jtblDownPaymentFee.setAutoCreateRowSorter(true);
    jtblDownPaymentFee.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null}
        },
        new String [] {
            "Downpayment", "Amount"
        }
    ));
    jtblDownPaymentFee.getTableHeader().setReorderingAllowed(false);
    jScrollPane3.setViewportView(jtblDownPaymentFee);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jScrollPane3, gridBagConstraints);

    jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel4.setText("Other");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jLabel4, gridBagConstraints);

    jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel3.setText("Miscellaneous");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jLabel3, gridBagConstraints);

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel2.setText("Tuition");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jLabel2, gridBagConstraints);

    jspOtherFees.setMinimumSize(new java.awt.Dimension(500, 100));
    jspOtherFees.setPreferredSize(new java.awt.Dimension(200, 130));

    jtblOtherFees.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Name", "Amount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblOtherFees.getTableHeader().setReorderingAllowed(false);
    jspOtherFees.setViewportView(jtblOtherFees);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jspOtherFees, gridBagConstraints);

    jspMiscFees.setMinimumSize(new java.awt.Dimension(500, 300));
    jspMiscFees.setPreferredSize(new java.awt.Dimension(300, 250));

    jtblMiscFees.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Name", "Amount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblMiscFees.getTableHeader().setReorderingAllowed(false);
    jspMiscFees.setViewportView(jtblMiscFees);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jspMiscFees, gridBagConstraints);

    jspAcademicFees.setMaximumSize(new java.awt.Dimension(20, 50));
    jspAcademicFees.setMinimumSize(new java.awt.Dimension(20, 50));
    jspAcademicFees.setPreferredSize(new java.awt.Dimension(20, 50));

    jtblBasicFee.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null}
        },
        new String [] {
            "Name", "Amount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblBasicFee.setMinimumSize(new java.awt.Dimension(30, 26));
    jtblBasicFee.setPreferredSize(new java.awt.Dimension(150, 26));
    jtblBasicFee.getTableHeader().setReorderingAllowed(false);
    jspAcademicFees.setViewportView(jtblBasicFee);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel11.add(jspAcademicFees, gridBagConstraints);

    jScrollPane4.setViewportView(jPanel11);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlBreakdownOfFees.add(jScrollPane4, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel14.add(jpnlBreakdownOfFees, gridBagConstraints);

    jPanel7.setMinimumSize(new java.awt.Dimension(550, 550));
    jPanel7.setPreferredSize(new java.awt.Dimension(550, 550));
    jPanel7.setLayout(new java.awt.GridBagLayout());

    jpnlBalanceBreakdown.setBorder(javax.swing.BorderFactory.createTitledBorder("Balance Breakdown"));
    jpnlBalanceBreakdown.setPreferredSize(new java.awt.Dimension(266, 150));
    jpnlBalanceBreakdown.setLayout(new java.awt.GridBagLayout());

    jspFeesPerPaymentTerm.setPreferredSize(new java.awt.Dimension(250, 230));

    jtblBalanceBreakdown.setAutoCreateRowSorter(true);
    jtblBalanceBreakdown.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Description", "Amount", "Balance", "Deadline"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblBalanceBreakdown.getTableHeader().setReorderingAllowed(false);
    jspFeesPerPaymentTerm.setViewportView(jtblBalanceBreakdown);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlBalanceBreakdown.add(jspFeesPerPaymentTerm, gridBagConstraints);

    jPanel9.setLayout(new java.awt.GridBagLayout());

    jbtnPaySelected.setText("Pay Selected");
    jPanel9.add(jbtnPaySelected, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weighty = 0.5;
    jpnlBalanceBreakdown.add(jPanel9, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel7.add(jpnlBalanceBreakdown, gridBagConstraints);

    jpnlPaymentTermSelection.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Term"));
    jpnlPaymentTermSelection.setLayout(new java.awt.GridBagLayout());

    jlblPaymentTerm.setText("Payment Term");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlPaymentTermSelection.add(jlblPaymentTerm, gridBagConstraints);

    jcmbPaymentTerm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jcmbPaymentTerm.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlPaymentTermSelection.add(jcmbPaymentTerm, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    jPanel7.add(jpnlPaymentTermSelection, gridBagConstraints);

    jpnlApplyDiscount.setBorder(javax.swing.BorderFactory.createTitledBorder("Discounts"));
    jpnlApplyDiscount.setLayout(new java.awt.GridBagLayout());

    jlblDiscount.setText("Discount");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlApplyDiscount.add(jlblDiscount, gridBagConstraints);

    jcmbDiscount.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlApplyDiscount.add(jcmbDiscount, gridBagConstraints);

    jlblPercentOfDiscount.setText("%");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlApplyDiscount.add(jlblPercentOfDiscount, gridBagConstraints);

    jtfDiscountPercentage.setColumns(2);
    jtfDiscountPercentage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jtfDiscountPercentage.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jtfDiscountPercentage.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlApplyDiscount.add(jtfDiscountPercentage, gridBagConstraints);

    jbtnRemoveDiscount.setText("Remove Discount");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlApplyDiscount.add(jbtnRemoveDiscount, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    jPanel7.add(jpnlApplyDiscount, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel14.add(jPanel7, gridBagConstraints);

    jpnlFilter.setMinimumSize(new java.awt.Dimension(425, 70));
    jpnlFilter.setPreferredSize(new java.awt.Dimension(425, 30));
    jpnlFilter.setLayout(new java.awt.GridBagLayout());

    jLabel7.setText("School Year");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlFilter.add(jLabel7, gridBagConstraints);

    jcmbSchoolYearFrom.setModel(new component_model_loader.SchoolYearML().getAllSchoolYearStart());
    jcmbSchoolYearFrom.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jcmbSchoolYearFromItemStateChanged(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlFilter.add(jcmbSchoolYearFrom, gridBagConstraints);

    jLabel8.setText("-");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlFilter.add(jLabel8, gridBagConstraints);

    jcmbSchoolYearTo.setModel(new component_model_loader.SchoolYearML().getAllSchoolYearEnd());
    jcmbSchoolYearTo.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlFilter.add(jcmbSchoolYearTo, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jPanel14.add(jpnlFilter, gridBagConstraints);

    jspFeeCollectionItems.setViewportView(jPanel14);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFeeCollectionItems.add(jspFeeCollectionItems, gridBagConstraints);

    jTabbedPane1.addTab("Fee Collection Items", jpnlFeeCollectionItems);

    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel4.setLayout(new java.awt.GridBagLayout());

    jpnlTransactionHistory.setLayout(new java.awt.GridBagLayout());

    jtblTransactionHistory.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Payment ID", "Payment Term", "Balance Breakdown ID", "Description", "Amount Of Payment", "OR Number", "Date Of Payment", "School Year"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblTransactionHistory.getTableHeader().setReorderingAllowed(false);
    jScrollPane2.setViewportView(jtblTransactionHistory);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTransactionHistory.add(jScrollPane2, gridBagConstraints);

    jpnlTransactionSchoolYearFilter.setLayout(new java.awt.GridBagLayout());

    jlblTransactionSchoolYear.setText("School Year");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTransactionSchoolYearFilter.add(jlblTransactionSchoolYear, gridBagConstraints);

    jcmbTransactionSyYearFrom.setModel(new component_model_loader.SchoolYearML().getAllSchoolYearStart());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTransactionSchoolYearFilter.add(jcmbTransactionSyYearFrom, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTransactionHistory.add(jpnlTransactionSchoolYearFilter, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 0.5;
    jPanel4.add(jpnlTransactionHistory, gridBagConstraints);

    jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel10.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    jPanel4.add(jPanel10, gridBagConstraints);

    jTabbedPane1.addTab("Payment History", jPanel4);

    jpnlReceipts.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("Receipts", jpnlReceipts);

    jpnlDiscounts.setLayout(new java.awt.GridBagLayout());

    jtblDiscountsInformation.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "School Year", "Discount Type", "Discount Percentage", "Amount of Discount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(jtblDiscountsInformation);

    jpnlDiscounts.add(jScrollPane1, new java.awt.GridBagConstraints());

    jTabbedPane1.addTab("Discounts", jpnlDiscounts);

    jPanel8.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("Adjustments", jPanel8);

    jPanel3.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("SOA", jPanel3);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel1.add(jTabbedPane1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlContent.add(jPanel1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jInternalFrame1.getContentPane().add(jpnlContent, gridBagConstraints);

    jMenu1.setText("File");

    jmiExit.setText("Exit");
    jMenu1.add(jmiExit);

    jMenuBar1.add(jMenu1);

    jInternalFrame1.setJMenuBar(jMenuBar1);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel13.add(jInternalFrame1, gridBagConstraints);

    jScrollPane5.setViewportView(jPanel13);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    add(jScrollPane5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    class GUIManager {
        private void resetForm(){
//            jlblStudentStatusText.setText("");
//            jtfStudentID.setText("");
//            jlblStudentTypeText.setText("");
//            jlblLastNameText.setText("");
//            jlblFirstNameText.setText("");
//            jlblMiddleNameText.setText("");
//            jlblAdmissionGradeLevelText.setText("");
//            jlblPresentGradeLevelText.setText("");
//            jtfBasicFee.setText("");
//            jtfMiscellaneousFee.setText("");
//            jtfOtherFee.setText("");
//            jtfTotalFees.setText("");
//            jtfDiscounts.setText("");
//            jtfTotalFeesWithDiscount.setText("");
//            jtfTotalPaid.setText("");
//            jtfRemainingBalance.setText("");
//            DefaultTableModel jtblDownPaymentFeeModel = (DefaultTableModel) jtblDownPaymentFee.getModel();
//            jtblDownPaymentFeeModel.setRowCount(0);
//            DefaultTableModel jtblTuitionFeeModel = (DefaultTableModel)jtblBasicFee.getModel();
//            jtblTuitionFeeModel.setRowCount(0);
//            DefaultTableModel jtblMiscFeesModel = (DefaultTableModel) jtblMiscFees.getModel();
//            jtblMiscFeesModel.setRowCount(0);
//            DefaultTableModel jtblOtherFeesModel = (DefaultTableModel) jtblOtherFees.getModel();
//            jtblOtherFeesModel.setRowCount(0);
//            jcmbPaymentTerm.setSelectedIndex(-1);
////            jcmbPaymentTerm.setEnabled(false);
//            jcmbDiscount.setSelectedIndex(-1);
////            jcmbDiscount.setEnabled(false);
//            jtfDiscountPercentage.setText("");
//            jbtnResetDiscount.setEnabled(false);
//            DefaultTableModel jtblBalanceBreakdownModel = (DefaultTableModel) jtblBalanceBreakdown.getModel();
//            jtblBalanceBreakdownModel.setRowCount(0);
////            jbtnPaySelected.setEnabled(false);
//            DefaultTableModel jtblTransactionHistoryModel = (DefaultTableModel)jtblTransactionHistory.getModel();
//            jtblTransactionHistoryModel.setRowCount(0);
//            int schoolYearFrom = Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString());
//            int schoolYearTo = Integer.parseInt(jcmbSchoolYearTo.getSelectedItem().toString());
//            TitledBorder titledBorder;
//            titledBorder = BorderFactory.createTitledBorder("Tuition Summary School Year: "+schoolYearFrom+"-"+schoolYearTo);
//            jpnlFeeSummary.setBorder(titledBorder);
        }
        
        private void initializeModels(){
            PaymentTermML paymentTermML = new PaymentTermML();
            jcmbPaymentTerm.setModel(paymentTermML.getNames());
            jcmbDiscount.setModel(discountML.getListOfDiscountNamesAsComboBoxModel());
        }
    }

    private void setCurrentDateJLabelText() {
        DateTime rawDateTime = new DateTime();
        //DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        String formattedDateTime = formatter.print(rawDateTime);
        jlblDateToday.setText(formattedDateTime);
    }

    public static void setFeeSummaryPanelFields(int aStudentId, int aSchoolYearId) {
        int schoolYearFrom = Integer.parseInt(jcmbSchoolYearFrom.getSelectedItem().toString());
        int schoolYearTo = Integer.parseInt(jcmbSchoolYearTo.getSelectedItem().toString());
        TitledBorder titledBorder;
        titledBorder = BorderFactory.createTitledBorder("Tuition Summary School Year: " + schoolYearFrom + "-" + schoolYearTo);
        jpnlFeeSummary.setBorder(titledBorder);
    }
    
    private class FeeCollectionLoader{
        private final Student student;
        private final SchoolFees schoolFees;
        private final TuitionFee tuitionFee;
//        private final DecimalFormat decimalFormatter = new DecimalFormat("#0.00");
        private final DecimalFormat decimalFormatter = new DecimalFormat("#,#00.00");
        
        public FeeCollectionLoader(Student student,SchoolFees schoolFees,TuitionFee tuitionFee){
            this.student = student;
            this.schoolFees = schoolFees;
            this.tuitionFee = tuitionFee;
        }
        
        private void setForm() {
            String studentType = student.getStudentType() == 0 ? "Old" : "New";
            String lastName = student.getRegistration().getLastName();
            String firstName = student.getRegistration().getFirstName();
            String middleName = student.getRegistration().getMiddleName();
            String admissionStatus = student.getAdmission().isCompleted() == true ? "Complete" : "Pending";
            String presentGradeLevel = student.getCurrentGradeLevel().getLevel()==0? "Kindergarten":"Grade "+student.getCurrentGradeLevel().getLevel();
            String studentStatus = student.isActive() == true ? "Active" : "Inactive";
            String basicFee = decimalFormatter.format(schoolFees.getBasicFee().getAmount());
            String miscellaneousFee = decimalFormatter.format(schoolFees.getMiscellaneousFees().getSum());
            String otherFee = decimalFormatter.format(schoolFees.getOtherFees().getSum());
            String totalFees = decimalFormatter.format(tuitionFee.getTotalFees());
            String totalPaid = decimalFormatter.format(tuitionFee.getTotalPaid());
            String remainingBalance = decimalFormatter.format(tuitionFee.getBalance());
            String paymentTerm = tuitionFee.getPaymentTerm().getName();
            String discount = tuitionFee.getDiscount().getDiscountName();
            String discountPercentage = tuitionFee.hasDiscount()? 
                    tuitionFee.getDiscount().getPercentOfDiscount()+"" : "";
            String discountAmount = tuitionFee.hasDiscount()?
                    tuitionFee.getDiscount().getAmount()+"" : "";
            
            jlblStudentTypeText.setText(studentType);
            jlblLastNameText.setText(lastName);
            jlblFirstNameText.setText(firstName);
            jlblMiddleNameText.setText(middleName);
            jlblAdmissionGradeLevelText.setText(admissionStatus);
            jlblPresentGradeLevelText.setText(presentGradeLevel);
            jlblStudentStatusText.setText(studentStatus);
            
            jtfBasicFee.setText(basicFee);
            jtfMiscellaneousFee.setText(miscellaneousFee);
            jtfOtherFee.setText(otherFee);
            
            jtfTotalFees.setText(totalFees);
            jtfTotalPaid.setText(totalPaid);
            jtfRemainingBalance.setText(remainingBalance);
            
            jcmbPaymentTerm.setSelectedItem(paymentTerm);
            jcmbDiscount.setSelectedItem(discount);
            jtfDiscountPercentage.setText(discountPercentage);
            jtfDiscounts.setText(discountAmount);
            
            List<BalanceBreakDownFee> balanceBreakDownFee = tuitionFee.getBalanceBreakDownFees();
            DefaultTableModel dtm = (DefaultTableModel) jtblBalanceBreakdown.getModel();
            dtm.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                Object[] rowData = {
                    b.getDescription(),
                    decimalFormatter.format(b.getAmount()),
                    decimalFormatter.format(b.getBalance())
                };
                dtm.addRow(rowData);
            }
            jtblBalanceBreakdown.setModel(dtm);
        }
        
        
        private void changePaymentTerm(){
            String studentType = student.getStudentType() == 0 ? "Old" : "New";
            String lastName = student.getRegistration().getLastName();
            String firstName = student.getRegistration().getFirstName();
            String middleName = student.getRegistration().getMiddleName();
            String admissionStatus = student.getAdmission().isCompleted() == true ? "Complete" : "Not Completed";
            String presentGradeLevel = student.getCurrentGradeLevel().getLevel()==0? "Kindergarten":"Grade "+student.getCurrentGradeLevel().getLevel();
            String studentStatus = student.isActive() == true ? "Active" : "Inactive";
            String basicFee = decimalFormatter.format(schoolFees.getBasicFee().getAmount());
            String miscellaneousFee = decimalFormatter.format(schoolFees.getMiscellaneousFees().getSum());
            String otherFee = decimalFormatter.format(schoolFees.getOtherFees().getSum());
            String totalFees = decimalFormatter.format(tuitionFee.getTotalFees());
            String totalPaid = decimalFormatter.format(tuitionFee.getTotalPaid());
            String remainingBalance = decimalFormatter.format(tuitionFee.getBalance());
            String discount = tuitionFee.getDiscount().getDiscountName();
            String discountPercentage = tuitionFee.getDiscount().getPercentOfDiscount()+"";
            
            jlblStudentTypeText.setText(studentType);
            jlblLastNameText.setText(lastName);
            jlblFirstNameText.setText(firstName);
            jlblMiddleNameText.setText(middleName);
            jlblAdmissionGradeLevelText.setText(admissionStatus);
            jlblPresentGradeLevelText.setText(presentGradeLevel);
            jlblStudentStatusText.setText(studentStatus);
            
            jtfBasicFee.setText(basicFee);
            jtfMiscellaneousFee.setText(miscellaneousFee);
            jtfOtherFee.setText(otherFee);
            
            jtfTotalFees.setText(totalFees);
            jtfTotalPaid.setText(totalPaid);
            jtfRemainingBalance.setText(remainingBalance);
            
            jcmbDiscount.setSelectedItem(discount);
            jtfDiscountPercentage.setText(discountPercentage);
            
            List<BalanceBreakDownFee> balanceBreakDownFee = tuitionFee.getBalanceBreakDownFees();
            DefaultTableModel dtm = (DefaultTableModel) jtblBalanceBreakdown.getModel();
            dtm.setRowCount(0);
            for (BalanceBreakDownFee b : balanceBreakDownFee) {
                Object[] rowData = {
                    b.getDescription(),
                    decimalFormatter.format(b.getAmount()),
                    decimalFormatter.format(b.getBalance())
                };
                dtm.addRow(rowData);
            }
            jtblBalanceBreakdown.setModel(dtm);
        }
    }
    
    private void jcmbSchoolYearFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbSchoolYearFromItemStateChanged
        jcmbSchoolYearTo.setSelectedIndex(jcmbSchoolYearFrom.getSelectedIndex());
    }//GEN-LAST:event_jcmbSchoolYearFromItemStateChanged

    private void jlblCurrentSchoolYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jlblCurrentSchoolYearPropertyChange
        jcmbSchoolYearFrom.setSelectedItem(SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        jcmbTransactionSyYearFrom.setSelectedItem(SchoolYearDaoImpl.getCurrentSchoolYearFrom());
    }//GEN-LAST:event_jlblCurrentSchoolYearPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpStudentType;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnPaySelected;
    private javax.swing.JButton jbtnRemoveDiscount;
    private javax.swing.JComboBox<String> jcmbDiscount;
    private javax.swing.JComboBox<String> jcmbPaymentTerm;
    public static javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    public static javax.swing.JComboBox<String> jcmbSchoolYearTo;
    public static javax.swing.JComboBox<String> jcmbTransactionSyYearFrom;
    private javax.swing.JLabel jlblAdmissionGradeLevel;
    private static javax.swing.JLabel jlblAdmissionGradeLevelText;
    private javax.swing.JLabel jlblCurrentSchoolYear;
    private javax.swing.JLabel jlblDateToday;
    private javax.swing.JLabel jlblDiscount;
    private javax.swing.JLabel jlblDiscounts;
    private javax.swing.JLabel jlblFirstName;
    private static javax.swing.JLabel jlblFirstNameText;
    private javax.swing.JLabel jlblLastName;
    private static javax.swing.JLabel jlblLastNameText;
    private javax.swing.JLabel jlblMiddleName;
    private static javax.swing.JLabel jlblMiddleNameText;
    private javax.swing.JLabel jlblPaymentTerm;
    private javax.swing.JLabel jlblPercentOfDiscount;
    private static javax.swing.JLabel jlblPresentGradeLevelText;
    private javax.swing.JLabel jlblPreviousGradeLevel;
    private javax.swing.JLabel jlblRemainingBalance;
    private javax.swing.JLabel jlblStudentID;
    private javax.swing.JLabel jlblStudentStatus;
    private static javax.swing.JLabel jlblStudentStatusText;
    private javax.swing.JLabel jlblStudentType;
    private static javax.swing.JLabel jlblStudentTypeText;
    private javax.swing.JLabel jlblTotalFees;
    private javax.swing.JLabel jlblTotalFeesWithDiscount;
    private javax.swing.JLabel jlblTotalPaid;
    private javax.swing.JLabel jlblTransactionSchoolYear;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JPanel jpnlApplyDiscount;
    private javax.swing.JPanel jpnlBalanceBreakdown;
    private javax.swing.JPanel jpnlBreakdownOfFees;
    private javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlDiscounts;
    private javax.swing.JPanel jpnlFeeCollectionItems;
    public static javax.swing.JPanel jpnlFeeSummary;
    private javax.swing.JPanel jpnlFilter;
    private javax.swing.JPanel jpnlPaymentTermSelection;
    private javax.swing.JPanel jpnlPhotoContainer;
    private javax.swing.JPanel jpnlReceipts;
    private javax.swing.JPanel jpnlStudentInfo;
    private javax.swing.JPanel jpnlTransactionHistory;
    private javax.swing.JPanel jpnlTransactionSchoolYearFilter;
    private javax.swing.JScrollPane jspAcademicFees;
    private javax.swing.JScrollPane jspFeeCollectionItems;
    private javax.swing.JScrollPane jspFeesPerPaymentTerm;
    private javax.swing.JScrollPane jspMiscFees;
    private javax.swing.JScrollPane jspOtherFees;
    public static javax.swing.JTable jtblBalanceBreakdown;
    private javax.swing.JTable jtblBasicFee;
    private javax.swing.JTable jtblDiscountsInformation;
    private javax.swing.JTable jtblDownPaymentFee;
    private javax.swing.JTable jtblMiscFees;
    private javax.swing.JTable jtblOtherFees;
    public static javax.swing.JTable jtblTransactionHistory;
    public static javax.swing.JTextField jtfBasicFee;
    private javax.swing.JTextField jtfDiscountPercentage;
    public static javax.swing.JTextField jtfDiscounts;
    private javax.swing.JTextField jtfMiscellaneousFee;
    private javax.swing.JTextField jtfOtherFee;
    public static javax.swing.JTextField jtfRemainingBalance;
    private static javax.swing.JTextField jtfStudentID;
    private javax.swing.JTextField jtfTotalFees;
    private javax.swing.JTextField jtfTotalFeesWithDiscount;
    public static javax.swing.JTextField jtfTotalPaid;
    // End of variables declaration//GEN-END:variables
}
