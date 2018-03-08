package view.reports;

import component_model_loader.GradeLevelJCompModelLoader;
import component_model_loader.SchoolYearJCompModelLoader;
import component_renderers.Renderer_GradeLevel_JComboBox;
import component_renderers.Renderer_Reports_COR_Schedule_Subject_JTableCell;
import component_renderers.Renderer_SchoolYear_JComboBox;
import component_renderers.Renderer_Section_JComboBox;
import controller.global.Controller_JTextField_ClearDefaultSearchText;
import controller.reports.Controller_Reports_CORtab_Search_JTextField;
import controller.reports.Controller_Reports_ClassList_GradeLevel_JComboBox;
import controller.reports.Controller_Reports_ClassList_SchoolYear_JComboBox;
import controller.reports.Controller_Reports_ClassList_Section_JComboBox;
import daoimpl.ReportsDaoImpl;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.schoolyear.SchoolYear;
import model.user.User;
import utility.component.ImageUtil;
import utility.jtable.JTableUtil;
import utility.initializer.Initializer;

public class Panel_Reports extends javax.swing.JPanel implements Initializer{

    private final User user;
    private final SchoolYear currentSchoolYear;
    private Image schoolLogo;
    
    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;
    private ReportsDaoImpl reportsDaoImpl;
    
    public Panel_Reports(User user, SchoolYear currentSchoolYear) {
        initComponents();
        schoolLogo = new ImageUtil().getResourceAsImage("assets/logo.jpg", 200, 200);
        this.user = user;
        this.currentSchoolYear = currentSchoolYear;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initViewComponents();
        initControllers();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        schoolYearJCompModelLoader = new SchoolYearJCompModelLoader();
        gradeLevelJCompModelLoader = new GradeLevelJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        jtblCORSchedule.setDefaultRenderer(Object.class, new Renderer_Reports_COR_Schedule_Subject_JTableCell(0));
        jcmbCorSchoolYear.setRenderer(new Renderer_SchoolYear_JComboBox());
        jcmbClassListGradeLevel.setRenderer(new Renderer_GradeLevel_JComboBox());
        jcmbClassListSchoolYear.setRenderer(new Renderer_SchoolYear_JComboBox());
        jcmbClassListSecttion.setRenderer(new Renderer_Section_JComboBox());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        clearCOR();
        clearClassList();
        jcmbCorSchoolYear.setModel(schoolYearJCompModelLoader.getAllSchoolYear());
        jcmbClassListSchoolYear.setModel(schoolYearJCompModelLoader.getAllSchoolYear());
        jcmbClassListGradeLevel.setModel(gradeLevelJCompModelLoader.getAllGradeLevels());
        JTableUtil.applyCustomHeaderRenderer(jtblClassList);
        JTableUtil.applyCustomHeaderRenderer(jtblReportCard);
        JTableUtil.applyCustomHeaderRenderer(jtblSchedules);
    }

    @Override
    public void initControllers() {
        jtfCorSearchBox.addMouseListener(new Controller_JTextField_ClearDefaultSearchText());
        jtfCorSearchBox.addKeyListener(new Controller_Reports_CORtab_Search_JTextField(this,user));
        jcmbClassListGradeLevel.addItemListener(new Controller_Reports_ClassList_GradeLevel_JComboBox(this));
        jcmbClassListSecttion.addItemListener(new Controller_Reports_ClassList_Section_JComboBox(this));
        jcmbClassListSchoolYear.addItemListener(new Controller_Reports_ClassList_SchoolYear_JComboBox(this));
    }

    @Override
    public void initDaoImpl() {
        reportsDaoImpl = new ReportsDaoImpl();
    }
    
    public void clearCOR(){
        jlblCORAddressText.setText("");
        jlblCORContact.setText("");
        jlblCORDateToday.setText("");
        jlblCORGradeLevelText.setText("");
        jlblCORSchoolYear.setText("");
        jlblCORSectionName.setText("");
        jlblCORStudentName.setText("");
        jlblCORStudentType.setText("");
        jlblUserCompleteName.setText("");
        jlblUserRole.setText("");
        jlblCORStudentNo.setText("");
        jlblAdviserName.setText("");
        jlblTotalAmount.setText("");
        ((DefaultTableModel)jtblCORSchedule.getModel()).setRowCount(0);
        ((DefaultTableModel)jtblCORTuition.getModel()).setRowCount(0);
        ((DefaultTableModel)jtblCORMiscellaneous.getModel()).setRowCount(0);
        ((DefaultTableModel)jtblCOROthers.getModel()).setRowCount(0);
        ((DefaultTableModel)jtblCORPaymentAssessment.getModel()).setRowCount(0);
    }
    
    public void clearClassList(){
        jlblClassListAdviserName.setText("");
        jlblClassListGradeLevelText.setText("");
        jlblClassListSchoolYear.setText("");
        jlblClassListSectionName.setText("");
        ((DefaultTableModel)jtblClassList.getModel()).setRowCount(0);
       
    }

    public JButton getJbtnClassListGenerateReport() {
        return jbtnClassListGenerateReport;
    }

    public JButton getJbtnClassListPrint() {
        return jbtnClassListPrint;
    }

    public JComboBox<String> getJcmbClassListGradeLevel() {
        return jcmbClassListGradeLevel;
    }

    public JComboBox<String> getJcmbClassListSchoolYear() {
        return jcmbClassListSchoolYear;
    }

    public JComboBox<String> getJcmbClassListSectionType() {
        return jcmbClassListSectionType;
    }

    public JComboBox<String> getJcmbClassListSecttion() {
        return jcmbClassListSecttion;
    }

    public JLabel getJlblClassListAdviserName() {
        return jlblClassListAdviserName;
    }

    public JLabel getJlblClassListGradeLevelText() {
        return jlblClassListGradeLevelText;
    }

    public JLabel getJlblClassListSchoolYear() {
        return jlblClassListSchoolYear;
    }

    public JLabel getJlblClassListSectionName() {
        return jlblClassListSectionName;
    }

    public JPanel getJpnlClassListLogo() {
        return jpnlClassListLogo;
    }

    public JPanel getJpnlClassListReportSummary() {
        return jpnlClassListReportSummary;
    }

    public JPanel getJpnlClassListTop() {
        return jpnlClassListTop;
    }

    public JTable getJtblClassList() {
        return jtblClassList;
    }
    
    
    

    public JLabel getJlblAdviserName() {
        return jlblAdviserName;
    }

    public JLabel getJlblTotalAmount() {
        return jlblTotalAmount;
    }
    
    public JButton getJbtnCorPrint() {
        return jbtnCorPrint;
    }

    public JButton getJbtnGenerateCOR() {
        return jbtnGenerateCOR;
    }

    public JComboBox<String> getJcmbCorSchoolYear() {
        return jcmbCorSchoolYear;
    }

    public JLabel getJlblCORAddressText() {
        return jlblCORAddressText;
    }

    public JLabel getJlblCORContact() {
        return jlblCORContact;
    }

    public JLabel getJlblCORDateToday() {
        return jlblCORDateToday;
    }

    public JLabel getJlblCORGradeLevelText() {
        return jlblCORGradeLevelText;
    }

    public JLabel getJlblCORSchoolYear() {
        return jlblCORSchoolYear;
    }

    public JLabel getJlblCORSectionName() {
        return jlblCORSectionName;
    }

    public JLabel getJlblCORStudentName() {
        return jlblCORStudentName;
    }

    public JLabel getJlblCORStudentNo() {
        return jlblCORStudentNo;
    }

    public JLabel getJlblCORStudentType() {
        return jlblCORStudentType;
    }

    public JLabel getJlblCertificateOfRegistration() {
        return jlblCertificateOfRegistration;
    }

    public JLabel getJlblUserCompleteName() {
        return jlblUserCompleteName;
    }

    public JLabel getJlblUserRole() {
        return jlblUserRole;
    }

    public JPanel getJpnlBody() {
        return jpnlBody;
    }

    public JPanel getJpnlFooter() {
        return jpnlFooter;
    }

    public JPanel getJpnlHeader() {
        return jpnlHeader;
    }

    public JPanel getJpnlLogo() {
        return jpnlLogo;
    }

    public JPanel getJpnlMiscellaneous() {
        return jpnlMiscellaneous;
    }

    public JPanel getJpnlOthers() {
        return jpnlOthers;
    }

    public JPanel getJpnlStudentDetails() {
        return jpnlStudentDetails;
    }

    public JPanel getJpnlTop() {
        return jpnlTop;
    }

    public JPanel getJpnlTuition() {
        return jpnlTuition;
    }

    public JTable getJtblCORMiscellaneous() {
        return jtblCORMiscellaneous;
    }

    public JTable getJtblCOROthers() {
        return jtblCOROthers;
    }

    public JTable getJtblCORPaymentAssessment() {
        return jtblCORPaymentAssessment;
    }

    public JTable getJtblCORSchedule() {
        return jtblCORSchedule;
    }

    public JTable getJtblCORTuition() {
        return jtblCORTuition;
    }

    public JTextField getJtfCorSearchBox() {
        return jtfCorSearchBox;
    }

    public JTextField getJtfReceiptsSearchBox() {
        return jtfReceiptsSearchBox;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnGroup = new javax.swing.ButtonGroup();
        panel_toppanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_sttudentreports = new javax.swing.JPanel();
        panel_details = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        combo_gradelevel = new javax.swing.JComboBox<>();
        lbl_name1 = new javax.swing.JLabel();
        combo_gradelevel1 = new javax.swing.JComboBox<>();
        lbl_name2 = new javax.swing.JLabel();
        combo_gradelevel2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        panel_controls = new javax.swing.JPanel();
        btn_Search1 = new javax.swing.JButton();
        btn_Search3 = new javax.swing.JButton();
        lbl_name3 = new javax.swing.JLabel();
        lbl_name4 = new javax.swing.JLabel();
        combo_gradelevel3 = new javax.swing.JComboBox<>();
        panel_summary = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_facultyreports = new javax.swing.JPanel();
        panel_details1 = new javax.swing.JPanel();
        lbl_name5 = new javax.swing.JLabel();
        combo_gradelevel4 = new javax.swing.JComboBox<>();
        lbl_name6 = new javax.swing.JLabel();
        combo_gradelevel5 = new javax.swing.JComboBox<>();
        lbl_name7 = new javax.swing.JLabel();
        combo_gradelevel6 = new javax.swing.JComboBox<>();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        panel_controls1 = new javax.swing.JPanel();
        btn_Search4 = new javax.swing.JButton();
        btn_Search5 = new javax.swing.JButton();
        btn_Search6 = new javax.swing.JButton();
        lbl_name8 = new javax.swing.JLabel();
        lbl_name9 = new javax.swing.JLabel();
        combo_gradelevel7 = new javax.swing.JComboBox<>();
        panel_summary1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panel_accounts = new javax.swing.JPanel();
        panel_COR = new javax.swing.JPanel();
        panel_details2 = new javax.swing.JPanel();
        lbl_name10 = new javax.swing.JLabel();
        jcmbCorSchoolYear = new javax.swing.JComboBox<>();
        jtfCorSearchBox = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        panel_controls2 = new javax.swing.JPanel();
        jbtnGenerateCOR = new javax.swing.JButton();
        jbtnCorPrint = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        panel_summary2 = new javax.swing.JPanel();
        jpnlTop = new javax.swing.JPanel();
        jpnlFooter = new javax.swing.JPanel();
        jpnlStudentDetails = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlblCORSchoolYear = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlblCORStudentNo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblCORStudentType = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlblCORSectionName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlblCORStudentName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlblCORContact = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlblCORGradeLevelText = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlblCORDateToday = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jlblCORAddressText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblAdviserName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlblUserRole = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlblUserCompleteName = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblCORPaymentAssessment = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblCORSchedule = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jpnlTuition = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtblCORTuition = new javax.swing.JTable();
        jpnlMiscellaneous = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtblCORMiscellaneous = new javax.swing.JTable();
        jpnlOthers = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtblCOROthers = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblTotalAmount = new javax.swing.JLabel();
        jpnlBody = new javax.swing.JPanel();
        jlblCertificateOfRegistration = new javax.swing.JLabel();
        jpnlHeader = new javax.swing.JPanel();
        jpnlLogo = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.8f));
            g2d.drawImage(schoolLogo, 0, 0, getWidth(), getHeight(), null);
            jpnlHeader.repaint();
        }
    };
    jPanel10 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    panel_receipts = new javax.swing.JPanel();
    panel_details3 = new javax.swing.JPanel();
    lbl_name11 = new javax.swing.JLabel();
    combo_gradelevel9 = new javax.swing.JComboBox<>();
    lbl_name12 = new javax.swing.JLabel();
    combo_gradelevel10 = new javax.swing.JComboBox<>();
    jtfReceiptsSearchBox = new javax.swing.JTextField();
    btn_Search14 = new javax.swing.JButton();
    lbl_name17 = new javax.swing.JLabel();
    combo_gradelevel13 = new javax.swing.JComboBox<>();
    panel_controls3 = new javax.swing.JPanel();
    btn_Search10 = new javax.swing.JButton();
    btn_Search11 = new javax.swing.JButton();
    btn_Search12 = new javax.swing.JButton();
    lbl_name15 = new javax.swing.JLabel();
    btn_Search13 = new javax.swing.JButton();
    panel_summary3 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jtblReceipts = new javax.swing.JTable();
    panel_classlist = new javax.swing.JPanel();
    panel_details4 = new javax.swing.JPanel();
    lbl_name14 = new javax.swing.JLabel();
    jcmbClassListSchoolYear = new javax.swing.JComboBox<>();
    lbl_name16 = new javax.swing.JLabel();
    jcmbClassListSectionType = new javax.swing.JComboBox<>();
    lbl_name18 = new javax.swing.JLabel();
    jcmbClassListGradeLevel = new javax.swing.JComboBox<>();
    lbl_name21 = new javax.swing.JLabel();
    jcmbClassListSecttion = new javax.swing.JComboBox<>();
    panel_controls4 = new javax.swing.JPanel();
    jbtnClassListGenerateReport = new javax.swing.JButton();
    jbtnClassListPrint = new javax.swing.JButton();
    jpnlClassListReportSummary = new javax.swing.JPanel();
    jpnlClassListTop = new javax.swing.JPanel();
    jpnlFooter1 = new javax.swing.JPanel();
    jpnlSectionDetails = new javax.swing.JPanel();
    jLabel22 = new javax.swing.JLabel();
    jlblClassListSectionName = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jlblClassListGradeLevelText = new javax.swing.JLabel();
    jLabel28 = new javax.swing.JLabel();
    jlblClassListAdviserName = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jlblClassListSchoolYear = new javax.swing.JLabel();
    jpnlBody1 = new javax.swing.JPanel();
    jlblCertificateOfRegistration1 = new javax.swing.JLabel();
    jpnlHeader1 = new javax.swing.JPanel();
    jpnlClassListLogo = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(schoolLogo, 0, 0, getWidth(), getHeight(), null);
        jpnlClassListTop.repaint();
    }
    };
    jPanel14 = new javax.swing.JPanel();
    jLabel34 = new javax.swing.JLabel();
    jLabel35 = new javax.swing.JLabel();
    jLabel36 = new javax.swing.JLabel();
    jPanel7 = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jtblClassList = new javax.swing.JTable();
    panel_classschedules = new javax.swing.JPanel();
    panel_details5 = new javax.swing.JPanel();
    lbl_name22 = new javax.swing.JLabel();
    combo_gradelevel15 = new javax.swing.JComboBox<>();
    lbl_name24 = new javax.swing.JLabel();
    combo_gradelevel17 = new javax.swing.JComboBox<>();
    lbl_name25 = new javax.swing.JLabel();
    combo_gradelevel18 = new javax.swing.JComboBox<>();
    lbl_name28 = new javax.swing.JLabel();
    combo_gradelevel19 = new javax.swing.JComboBox<>();
    lbl_name29 = new javax.swing.JLabel();
    combo_gradelevel20 = new javax.swing.JComboBox<>();
    panel_controls5 = new javax.swing.JPanel();
    btn_Search19 = new javax.swing.JButton();
    btn_Search20 = new javax.swing.JButton();
    btn_Search21 = new javax.swing.JButton();
    lbl_name26 = new javax.swing.JLabel();
    lbl_name27 = new javax.swing.JLabel();
    lbl_name30 = new javax.swing.JLabel();
    btn_Search22 = new javax.swing.JButton();
    panel_summary5 = new javax.swing.JPanel();
    jScrollPane5 = new javax.swing.JScrollPane();
    jtblSchedules = new javax.swing.JTable();
    panel_reportcards = new javax.swing.JPanel();
    panel_details6 = new javax.swing.JPanel();
    lbl_name31 = new javax.swing.JLabel();
    jmcbReportCardFilterBySchoolYear = new javax.swing.JComboBox<>();
    jtfReportCardSearchBox = new javax.swing.JTextField();
    jbtnReportCardsSearchBox = new javax.swing.JButton();
    lbl_name39 = new javax.swing.JLabel();
    combo_gradelevel26 = new javax.swing.JComboBox<>();
    panel_controls6 = new javax.swing.JPanel();
    btn_Search23 = new javax.swing.JButton();
    btn_Search24 = new javax.swing.JButton();
    btn_Search25 = new javax.swing.JButton();
    lbl_name36 = new javax.swing.JLabel();
    lbl_name37 = new javax.swing.JLabel();
    lbl_name38 = new javax.swing.JLabel();
    btn_Search26 = new javax.swing.JButton();
    panel_summary6 = new javax.swing.JPanel();
    jpnlClassListTop1 = new javax.swing.JPanel();
    jpnlFooter2 = new javax.swing.JPanel();
    jpnlSectionDetails1 = new javax.swing.JPanel();
    jLabel23 = new javax.swing.JLabel();
    jlblClassListSectionName1 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    jlblClassListGradeLevelText1 = new javax.swing.JLabel();
    jLabel29 = new javax.swing.JLabel();
    jlblClassListAdviserName1 = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jlblClassListSchoolYear1 = new javax.swing.JLabel();
    jpnlBody2 = new javax.swing.JPanel();
    jlblCertificateOfRegistration2 = new javax.swing.JLabel();
    jpnlHeader2 = new javax.swing.JPanel();
    jpnlClassListLogo1 = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(schoolLogo, 0, 0, getWidth(), getHeight(), null);
        jpnlClassListTop.repaint();
    }
    };
    jPanel15 = new javax.swing.JPanel();
    jLabel37 = new javax.swing.JLabel();
    jLabel38 = new javax.swing.JLabel();
    jLabel39 = new javax.swing.JLabel();
    jPanel8 = new javax.swing.JPanel();
    jspReportCard = new javax.swing.JScrollPane();
    jtblReportCard = new javax.swing.JTable();
    jLabel20 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    panel_settings = new javax.swing.JPanel();

    setMinimumSize(new java.awt.Dimension(1300, 700));
    setPreferredSize(new java.awt.Dimension(1300, 700));
    setLayout(new java.awt.GridBagLayout());

    panel_toppanel.setLayout(new java.awt.GridBagLayout());

    jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    panel_sttudentreports.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_sttudentreports.setLayout(new java.awt.GridBagLayout());

    panel_details.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details.setLayout(new java.awt.GridBagLayout());

    lbl_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(lbl_name, gridBagConstraints);

    combo_gradelevel.setEditable(true);
    combo_gradelevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel.setMinimumSize(new java.awt.Dimension(100, 25));
    combo_gradelevel.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details.add(combo_gradelevel, gridBagConstraints);

    lbl_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name1.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(lbl_name1, gridBagConstraints);

    combo_gradelevel1.setEditable(true);
    combo_gradelevel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel1.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel1.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details.add(combo_gradelevel1, gridBagConstraints);

    lbl_name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name2.setText("Student Type :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(lbl_name2, gridBagConstraints);

    combo_gradelevel2.setEditable(true);
    combo_gradelevel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All", "Regular", "Transferee", " " }));
    combo_gradelevel2.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel2.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details.add(combo_gradelevel2, gridBagConstraints);

    btnGroup.add(jCheckBox1);
    jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox1.setText("Registered");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(jCheckBox1, gridBagConstraints);

    btnGroup.add(jCheckBox2);
    jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox2.setText("Enrolled");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(jCheckBox2, gridBagConstraints);

    btnGroup.add(jCheckBox3);
    jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox3.setText("Withdrawn");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(jCheckBox3, gridBagConstraints);

    btnGroup.add(jCheckBox4);
    jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox4.setText("Summer");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 9;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details.add(jCheckBox4, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_sttudentreports.add(panel_details, gridBagConstraints);

    panel_controls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls.setLayout(new java.awt.GridBagLayout());

    btn_Search1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search1.setText("Export To PDF");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls.add(btn_Search1, gridBagConstraints);

    btn_Search3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search3.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    panel_controls.add(btn_Search3, gridBagConstraints);

    lbl_name3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name3.setText("Result Count :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls.add(lbl_name3, gridBagConstraints);

    lbl_name4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name4.setText("Show :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    panel_controls.add(lbl_name4, gridBagConstraints);

    combo_gradelevel3.setEditable(true);
    combo_gradelevel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
    combo_gradelevel3.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel3.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
    panel_controls.add(combo_gradelevel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_sttudentreports.add(panel_controls, gridBagConstraints);

    panel_summary.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_summary.setLayout(new java.awt.GridBagLayout());

    jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "School Year", "Grade Level", "Student Type", "Student Name", "Status"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTable1.setIntercellSpacing(new java.awt.Dimension(16, 1));
    jTable1.setRowHeight(20);
    jScrollPane1.setViewportView(jTable1);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_summary.add(jScrollPane1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_sttudentreports.add(panel_summary, gridBagConstraints);

    jTabbedPane1.addTab("Students", panel_sttudentreports);

    panel_facultyreports.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_facultyreports.setLayout(new java.awt.GridBagLayout());

    panel_details1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details1.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details1.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details1.setLayout(new java.awt.GridBagLayout());

    lbl_name5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name5.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details1.add(lbl_name5, gridBagConstraints);

    combo_gradelevel4.setEditable(true);
    combo_gradelevel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
    combo_gradelevel4.setMinimumSize(new java.awt.Dimension(100, 25));
    combo_gradelevel4.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details1.add(combo_gradelevel4, gridBagConstraints);

    lbl_name6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name6.setText("Faculty/Subject :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details1.add(lbl_name6, gridBagConstraints);

    combo_gradelevel5.setEditable(true);
    combo_gradelevel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All", "Mother Tongue", "Filipino", "English", "Math", "Science", "EPP", "AP", "MAPEH", " ", " " }));
    combo_gradelevel5.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel5.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details1.add(combo_gradelevel5, gridBagConstraints);

    lbl_name7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name7.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details1.add(lbl_name7, gridBagConstraints);

    combo_gradelevel6.setEditable(true);
    combo_gradelevel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All", "Kindergarten", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
    combo_gradelevel6.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel6.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 70);
    panel_details1.add(combo_gradelevel6, gridBagConstraints);

    jCheckBox5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox5.setText("Adviser");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 160, 0, 0);
    panel_details1.add(jCheckBox5, gridBagConstraints);

    jCheckBox6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox6.setText("Non-Adviser");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details1.add(jCheckBox6, gridBagConstraints);

    jCheckBox7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jCheckBox7.setText("Summer");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details1.add(jCheckBox7, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_facultyreports.add(panel_details1, gridBagConstraints);

    panel_controls1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls1.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls1.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls1.setLayout(new java.awt.GridBagLayout());

    btn_Search4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search4.setText("Generate Report");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls1.add(btn_Search4, gridBagConstraints);

    btn_Search5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search5.setText("Reset");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    panel_controls1.add(btn_Search5, gridBagConstraints);

    btn_Search6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search6.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    panel_controls1.add(btn_Search6, gridBagConstraints);

    lbl_name8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name8.setText("Result Count :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls1.add(lbl_name8, gridBagConstraints);

    lbl_name9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name9.setText("Show :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    panel_controls1.add(lbl_name9, gridBagConstraints);

    combo_gradelevel7.setEditable(true);
    combo_gradelevel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
    combo_gradelevel7.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel7.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
    panel_controls1.add(combo_gradelevel7, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_facultyreports.add(panel_controls1, gridBagConstraints);

    panel_summary1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_summary1.setLayout(new java.awt.GridBagLayout());

    jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "School Year", "Faculty Name", "Status"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTable2.setIntercellSpacing(new java.awt.Dimension(16, 1));
    jTable2.setRowHeight(20);
    jScrollPane2.setViewportView(jTable2);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_summary1.add(jScrollPane2, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_facultyreports.add(panel_summary1, gridBagConstraints);

    jTabbedPane1.addTab("Faculty", panel_facultyreports);

    panel_accounts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_accounts.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("Accounts", panel_accounts);

    panel_COR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_COR.setLayout(new java.awt.GridBagLayout());

    panel_details2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details2.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details2.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details2.setLayout(new java.awt.GridBagLayout());

    lbl_name10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name10.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details2.add(lbl_name10, gridBagConstraints);

    jcmbCorSchoolYear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jcmbCorSchoolYear.setMinimumSize(new java.awt.Dimension(100, 25));
    jcmbCorSchoolYear.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details2.add(jcmbCorSchoolYear, gridBagConstraints);

    jtfCorSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
    jtfCorSearchBox.setText("Search By Student No");
    jtfCorSearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
    jtfCorSearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    panel_details2.add(jtfCorSearchBox, gridBagConstraints);

    btn_Search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search.setText("Search");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
    panel_details2.add(btn_Search, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_COR.add(panel_details2, gridBagConstraints);

    panel_controls2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls2.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls2.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls2.setLayout(new java.awt.GridBagLayout());

    jbtnGenerateCOR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jbtnGenerateCOR.setText("Export To PDF");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls2.add(jbtnGenerateCOR, gridBagConstraints);

    jbtnCorPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jbtnCorPrint.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_controls2.add(jbtnCorPrint, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_COR.add(panel_controls2, gridBagConstraints);

    panel_summary2.setBackground(new java.awt.Color(255, 255, 255));
    panel_summary2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certificate of Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
    panel_summary2.setLayout(new java.awt.GridBagLayout());

    jpnlTop.setBackground(new java.awt.Color(255, 255, 255));
    jpnlTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlTop.setForeground(new java.awt.Color(0, 0, 0));
    jpnlTop.setPreferredSize(new java.awt.Dimension(800, 599));
    jpnlTop.setLayout(new java.awt.GridBagLayout());

    jpnlFooter.setBackground(new java.awt.Color(255, 255, 255));
    jpnlFooter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlFooter.setForeground(new java.awt.Color(0, 0, 0));
    jpnlFooter.setMinimumSize(new java.awt.Dimension(795, 222));
    jpnlFooter.setPreferredSize(new java.awt.Dimension(1180, 1375));
    jpnlFooter.setLayout(new java.awt.GridBagLayout());

    jpnlStudentDetails.setBackground(new java.awt.Color(255, 255, 255));
    jpnlStudentDetails.setForeground(new java.awt.Color(0, 0, 0));
    jpnlStudentDetails.setLayout(new java.awt.GridBagLayout());

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel2, gridBagConstraints);

    jlblCORSchoolYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORSchoolYear.setText("SY Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORSchoolYear, gridBagConstraints);

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Student No :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel4, gridBagConstraints);

    jlblCORStudentNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORStudentNo.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORStudentNo.setText("Student No Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORStudentNo, gridBagConstraints);

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Student Type :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel9, gridBagConstraints);

    jlblCORStudentType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORStudentType.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORStudentType.setText("Student Type Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORStudentType, gridBagConstraints);

    jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
    jLabel11.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel11, gridBagConstraints);

    jlblCORSectionName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORSectionName.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORSectionName.setText("Section Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORSectionName, gridBagConstraints);

    jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(0, 0, 0));
    jLabel13.setText("Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel13, gridBagConstraints);

    jlblCORStudentName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORStudentName.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORStudentName.setText("Name Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORStudentName, gridBagConstraints);

    jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(0, 0, 0));
    jLabel15.setText("Contact :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel15, gridBagConstraints);

    jlblCORContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORContact.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORContact.setText("Contact Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORContact, gridBagConstraints);

    jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(0, 0, 0));
    jLabel17.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel17, gridBagConstraints);

    jlblCORGradeLevelText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORGradeLevelText.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORGradeLevelText.setText("Grade Level Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORGradeLevelText, gridBagConstraints);

    jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(0, 0, 0));
    jLabel19.setText("Date :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel19, gridBagConstraints);

    jlblCORDateToday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORDateToday.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORDateToday.setText("Date Today Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORDateToday, gridBagConstraints);

    jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel21.setForeground(new java.awt.Color(0, 0, 0));
    jLabel21.setText("Address :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel21, gridBagConstraints);

    jlblCORAddressText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblCORAddressText.setForeground(new java.awt.Color(0, 0, 0));
    jlblCORAddressText.setText("Address Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblCORAddressText, gridBagConstraints);

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Adviser :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jLabel1, gridBagConstraints);

    jlblAdviserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblAdviserName.setForeground(new java.awt.Color(0, 0, 0));
    jlblAdviserName.setText("Adviser Name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlStudentDetails.add(jlblAdviserName, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFooter.add(jpnlStudentDetails, gridBagConstraints);

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.setLayout(new java.awt.GridBagLayout());

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel4.setForeground(new java.awt.Color(0, 0, 0));
    jPanel4.setMinimumSize(new java.awt.Dimension(256, 250));
    jPanel4.setLayout(new java.awt.GridBagLayout());

    jPanel5.setBackground(new java.awt.Color(255, 255, 255));
    jPanel5.setForeground(new java.awt.Color(0, 0, 0));
    jPanel5.setMinimumSize(new java.awt.Dimension(220, 17));
    jPanel5.setPreferredSize(new java.awt.Dimension(200, 17));
    jPanel5.setLayout(new java.awt.GridBagLayout());

    jlblUserRole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jlblUserRole.setForeground(new java.awt.Color(0, 0, 0));
    jlblUserRole.setText("User Role");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel5.add(jlblUserRole, gridBagConstraints);

    jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(0, 0, 0));
    jLabel16.setText("_________________");
    jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jLabel16.setMinimumSize(new java.awt.Dimension(153, 5));
    jLabel16.setPreferredSize(new java.awt.Dimension(153, 5));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    jPanel5.add(jLabel16, gridBagConstraints);

    jlblUserCompleteName.setBackground(new java.awt.Color(255, 255, 255));
    jlblUserCompleteName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jlblUserCompleteName.setForeground(new java.awt.Color(0, 0, 0));
    jlblUserCompleteName.setText("User Complete Name");
    jPanel5.add(jlblUserCompleteName, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel4.add(jPanel5, gridBagConstraints);

    jPanel6.setBackground(new java.awt.Color(255, 255, 255));
    jPanel6.setForeground(new java.awt.Color(0, 0, 0));
    jPanel6.setMinimumSize(new java.awt.Dimension(22, 100));
    jPanel6.setLayout(new java.awt.GridBagLayout());

    jtblCORPaymentAssessment.setBackground(new java.awt.Color(255, 255, 255));
    jtblCORPaymentAssessment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jtblCORPaymentAssessment.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    jtblCORPaymentAssessment.setForeground(new java.awt.Color(0, 0, 0));
    jtblCORPaymentAssessment.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Description", "Amount", "Balance", "Due Date"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblCORPaymentAssessment.setShowHorizontalLines(false);
    jtblCORPaymentAssessment.setShowVerticalLines(false);
    jtblCORPaymentAssessment.getTableHeader().setReorderingAllowed(false);
    jScrollPane7.setViewportView(jtblCORPaymentAssessment);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel6.add(jScrollPane7, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel4.add(jPanel6, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel2.add(jPanel4, gridBagConstraints);

    jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jScrollPane6.setMinimumSize(new java.awt.Dimension(19, 200));
    jScrollPane6.setPreferredSize(new java.awt.Dimension(452, 300));

    jtblCORSchedule.setBackground(new java.awt.Color(255, 255, 255));
    jtblCORSchedule.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jtblCORSchedule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jtblCORSchedule.setForeground(new java.awt.Color(0, 0, 0));
    jtblCORSchedule.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Subject", "Day(s) / Time", "Room", "Teacher"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblCORSchedule.setGridColor(new java.awt.Color(0, 0, 0));
    jtblCORSchedule.setShowHorizontalLines(false);
    jtblCORSchedule.setShowVerticalLines(false);
    jtblCORSchedule.getTableHeader().setReorderingAllowed(false);
    jScrollPane6.setViewportView(jtblCORSchedule);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jPanel2.add(jScrollPane6, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFooter.add(jPanel2, gridBagConstraints);

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel3.setForeground(new java.awt.Color(0, 0, 0));
    jPanel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jPanel3.setMinimumSize(new java.awt.Dimension(150, 45));
    jPanel3.setLayout(new java.awt.GridBagLayout());

    jpnlTuition.setBackground(new java.awt.Color(255, 255, 255));
    jpnlTuition.setForeground(new java.awt.Color(0, 0, 0));
    jpnlTuition.setLayout(new java.awt.GridBagLayout());

    jLabel10.setBackground(new java.awt.Color(255, 255, 255));
    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setText("Tuition");
    jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTuition.add(jLabel10, gridBagConstraints);

    jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane8.setForeground(new java.awt.Color(0, 0, 0));
    jScrollPane8.setMinimumSize(new java.awt.Dimension(20, 50));
    jScrollPane8.setPreferredSize(new java.awt.Dimension(453, 100));

    jtblCORTuition.setBackground(new java.awt.Color(255, 255, 255));
    jtblCORTuition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jtblCORTuition.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    jtblCORTuition.setForeground(new java.awt.Color(0, 0, 0));
    jtblCORTuition.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "", ""
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblCORTuition.setShowHorizontalLines(false);
    jtblCORTuition.setShowVerticalLines(false);
    jtblCORTuition.getTableHeader().setReorderingAllowed(false);
    jScrollPane8.setViewportView(jtblCORTuition);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlTuition.add(jScrollPane8, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    jPanel3.add(jpnlTuition, gridBagConstraints);

    jpnlMiscellaneous.setBackground(new java.awt.Color(255, 255, 255));
    jpnlMiscellaneous.setForeground(new java.awt.Color(0, 0, 0));
    jpnlMiscellaneous.setLayout(new java.awt.GridBagLayout());

    jLabel12.setBackground(new java.awt.Color(255, 255, 255));
    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel12.setText("Miscellaneous");
    jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlMiscellaneous.add(jLabel12, gridBagConstraints);

    jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane9.setForeground(new java.awt.Color(0, 0, 0));

    jtblCORMiscellaneous.setBackground(new java.awt.Color(255, 255, 255));
    jtblCORMiscellaneous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jtblCORMiscellaneous.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    jtblCORMiscellaneous.setForeground(new java.awt.Color(0, 0, 0));
    jtblCORMiscellaneous.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "", ""
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblCORMiscellaneous.setShowHorizontalLines(false);
    jtblCORMiscellaneous.setShowVerticalLines(false);
    jtblCORMiscellaneous.getTableHeader().setReorderingAllowed(false);
    jScrollPane9.setViewportView(jtblCORMiscellaneous);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlMiscellaneous.add(jScrollPane9, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel3.add(jpnlMiscellaneous, gridBagConstraints);

    jpnlOthers.setBackground(new java.awt.Color(255, 255, 255));
    jpnlOthers.setForeground(new java.awt.Color(0, 0, 0));
    jpnlOthers.setLayout(new java.awt.GridBagLayout());

    jLabel14.setBackground(new java.awt.Color(255, 255, 255));
    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(0, 0, 0));
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel14.setText("Others");
    jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlOthers.add(jLabel14, gridBagConstraints);

    jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane10.setForeground(new java.awt.Color(0, 0, 0));

    jtblCOROthers.setBackground(new java.awt.Color(255, 255, 255));
    jtblCOROthers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jtblCOROthers.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    jtblCOROthers.setForeground(new java.awt.Color(0, 0, 0));
    jtblCOROthers.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "", ""
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblCOROthers.setShowHorizontalLines(false);
    jtblCOROthers.setShowVerticalLines(false);
    jtblCOROthers.getTableHeader().setReorderingAllowed(false);
    jScrollPane10.setViewportView(jtblCOROthers);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlOthers.add(jScrollPane10, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel3.add(jpnlOthers, gridBagConstraints);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setForeground(new java.awt.Color(0, 0, 0));
    jPanel1.setLayout(new java.awt.GridBagLayout());

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Total :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel1.add(jLabel3, gridBagConstraints);

    jlblTotalAmount.setBackground(new java.awt.Color(255, 255, 255));
    jlblTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jlblTotalAmount.setForeground(new java.awt.Color(0, 0, 0));
    jlblTotalAmount.setText("TotalAmount");
    jPanel1.add(jlblTotalAmount, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel3.add(jPanel1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFooter.add(jPanel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTop.add(jpnlFooter, gridBagConstraints);

    jpnlBody.setBackground(new java.awt.Color(255, 255, 255));
    jpnlBody.setForeground(new java.awt.Color(0, 0, 0));
    jpnlBody.setLayout(new java.awt.GridBagLayout());

    jlblCertificateOfRegistration.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    jlblCertificateOfRegistration.setForeground(new java.awt.Color(0, 102, 204));
    jlblCertificateOfRegistration.setText("Certificate of Registration");
    jpnlBody.add(jlblCertificateOfRegistration, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTop.add(jpnlBody, gridBagConstraints);

    jpnlHeader.setBackground(new java.awt.Color(255, 255, 255));
    jpnlHeader.setForeground(new java.awt.Color(0, 0, 0));
    jpnlHeader.setLayout(new java.awt.GridBagLayout());

    jpnlLogo.setBackground(new java.awt.Color(255, 255, 255));
    jpnlLogo.setForeground(new java.awt.Color(0, 0, 0));
    jpnlLogo.setMinimumSize(new java.awt.Dimension(100, 100));
    jpnlLogo.setPreferredSize(new java.awt.Dimension(120, 120));
    jpnlLogo.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader.add(jpnlLogo, gridBagConstraints);

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setForeground(new java.awt.Color(0, 0, 0));
    jPanel10.setMinimumSize(new java.awt.Dimension(600, 18));
    jPanel10.setPreferredSize(new java.awt.Dimension(600, 18));
    jPanel10.setLayout(new java.awt.GridBagLayout());

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 102, 204));
    jLabel5.setText("Mother of Perpetual Help School");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel10.add(jLabel5, gridBagConstraints);

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(51, 51, 51));
    jLabel7.setText("Iris Street Dahlia, West Fairview Quezon City");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel10.add(jLabel7, gridBagConstraints);

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(51, 51, 51));
    jLabel8.setText("1118 Metro Manila, Philippines");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel10.add(jLabel8, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader.add(jPanel10, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTop.add(jpnlHeader, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_summary2.add(jpnlTop, gridBagConstraints);

    jScrollPane11.setViewportView(panel_summary2);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_COR.add(jScrollPane11, gridBagConstraints);

    jTabbedPane1.addTab("COR", panel_COR);

    panel_receipts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_receipts.setLayout(new java.awt.GridBagLayout());

    panel_details3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details3.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details3.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details3.setLayout(new java.awt.GridBagLayout());

    lbl_name11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name11.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details3.add(lbl_name11, gridBagConstraints);

    combo_gradelevel9.setEditable(true);
    combo_gradelevel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel9.setMinimumSize(new java.awt.Dimension(100, 25));
    combo_gradelevel9.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details3.add(combo_gradelevel9, gridBagConstraints);

    lbl_name12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name12.setText("Receipts/Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details3.add(lbl_name12, gridBagConstraints);

    combo_gradelevel10.setEditable(true);
    combo_gradelevel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel10.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel10.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details3.add(combo_gradelevel10, gridBagConstraints);

    jtfReceiptsSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
    jtfReceiptsSearchBox.setText("Search Here");
    jtfReceiptsSearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
    jtfReceiptsSearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    panel_details3.add(jtfReceiptsSearchBox, gridBagConstraints);

    btn_Search14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search14.setText("Search");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    panel_details3.add(btn_Search14, gridBagConstraints);

    lbl_name17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name17.setText("Search by :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
    panel_details3.add(lbl_name17, gridBagConstraints);

    combo_gradelevel13.setEditable(true);
    combo_gradelevel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student ID", "Student Name", "Grade Level", "Receipt Number", " ", " ", " ", " " }));
    combo_gradelevel13.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel13.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
    panel_details3.add(combo_gradelevel13, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_receipts.add(panel_details3, gridBagConstraints);

    panel_controls3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls3.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls3.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls3.setLayout(new java.awt.GridBagLayout());

    btn_Search10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search10.setText("Generate Report");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls3.add(btn_Search10, gridBagConstraints);

    btn_Search11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search11.setText("Reset");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    panel_controls3.add(btn_Search11, gridBagConstraints);

    btn_Search12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search12.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    panel_controls3.add(btn_Search12, gridBagConstraints);

    lbl_name15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name15.setText("Result Count :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls3.add(lbl_name15, gridBagConstraints);

    btn_Search13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search13.setText("View");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    panel_controls3.add(btn_Search13, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_receipts.add(panel_controls3, gridBagConstraints);

    panel_summary3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_summary3.setLayout(new java.awt.GridBagLayout());

    jScrollPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jtblReceipts.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "School Year", "Receipt Number", "Student Number", "Student Name", "Grade Level"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblReceipts.setIntercellSpacing(new java.awt.Dimension(16, 1));
    jtblReceipts.setRowHeight(20);
    jtblReceipts.getTableHeader().setReorderingAllowed(false);
    jScrollPane3.setViewportView(jtblReceipts);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_summary3.add(jScrollPane3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_receipts.add(panel_summary3, gridBagConstraints);

    jTabbedPane1.addTab("Receipts", panel_receipts);

    panel_classlist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_classlist.setLayout(new java.awt.GridBagLayout());

    panel_details4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details4.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details4.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details4.setLayout(new java.awt.GridBagLayout());

    lbl_name14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name14.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details4.add(lbl_name14, gridBagConstraints);

    jcmbClassListSchoolYear.setBackground(new java.awt.Color(255, 255, 255));
    jcmbClassListSchoolYear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jcmbClassListSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
    jcmbClassListSchoolYear.setMinimumSize(new java.awt.Dimension(100, 25));
    jcmbClassListSchoolYear.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details4.add(jcmbClassListSchoolYear, gridBagConstraints);

    lbl_name16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name16.setText("Class Type :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details4.add(lbl_name16, gridBagConstraints);

    jcmbClassListSectionType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jcmbClassListSectionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Regular", "Summer", "" }));
    jcmbClassListSectionType.setMinimumSize(new java.awt.Dimension(150, 25));
    jcmbClassListSectionType.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details4.add(jcmbClassListSectionType, gridBagConstraints);

    lbl_name18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name18.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details4.add(lbl_name18, gridBagConstraints);

    jcmbClassListGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jcmbClassListGradeLevel.setMinimumSize(new java.awt.Dimension(150, 25));
    jcmbClassListGradeLevel.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details4.add(jcmbClassListGradeLevel, gridBagConstraints);

    lbl_name21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name21.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details4.add(lbl_name21, gridBagConstraints);

    jcmbClassListSecttion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jcmbClassListSecttion.setEnabled(false);
    jcmbClassListSecttion.setMinimumSize(new java.awt.Dimension(150, 25));
    jcmbClassListSecttion.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details4.add(jcmbClassListSecttion, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_classlist.add(panel_details4, gridBagConstraints);

    panel_controls4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls4.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls4.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls4.setLayout(new java.awt.GridBagLayout());

    jbtnClassListGenerateReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jbtnClassListGenerateReport.setText("Export To PDF");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_controls4.add(jbtnClassListGenerateReport, gridBagConstraints);

    jbtnClassListPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jbtnClassListPrint.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_controls4.add(jbtnClassListPrint, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_classlist.add(panel_controls4, gridBagConstraints);

    jpnlClassListReportSummary.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    jpnlClassListReportSummary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jpnlClassListReportSummary.setLayout(new java.awt.GridBagLayout());

    jpnlClassListTop.setBackground(new java.awt.Color(255, 255, 255));
    jpnlClassListTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlClassListTop.setForeground(new java.awt.Color(0, 0, 0));
    jpnlClassListTop.setPreferredSize(new java.awt.Dimension(700, 599));
    jpnlClassListTop.setLayout(new java.awt.GridBagLayout());

    jpnlFooter1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlFooter1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlFooter1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlFooter1.setMinimumSize(new java.awt.Dimension(795, 30));
    jpnlFooter1.setPreferredSize(new java.awt.Dimension(1180, 30));
    jpnlFooter1.setLayout(new java.awt.GridBagLayout());

    jpnlSectionDetails.setBackground(new java.awt.Color(255, 255, 255));
    jpnlSectionDetails.setForeground(new java.awt.Color(0, 0, 0));
    jpnlSectionDetails.setLayout(new java.awt.GridBagLayout());

    jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(0, 0, 0));
    jLabel22.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jLabel22, gridBagConstraints);

    jlblClassListSectionName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListSectionName.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListSectionName.setText("Section Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jlblClassListSectionName, gridBagConstraints);

    jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(0, 0, 0));
    jLabel25.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jLabel25, gridBagConstraints);

    jlblClassListGradeLevelText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListGradeLevelText.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListGradeLevelText.setText("Grade Level Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jlblClassListGradeLevelText, gridBagConstraints);

    jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(0, 0, 0));
    jLabel28.setText("Adviser :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jLabel28, gridBagConstraints);

    jlblClassListAdviserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListAdviserName.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListAdviserName.setText("Adviser Name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jlblClassListAdviserName, gridBagConstraints);

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
    jLabel6.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jLabel6, gridBagConstraints);

    jlblClassListSchoolYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListSchoolYear.setText("SY Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails.add(jlblClassListSchoolYear, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFooter1.add(jpnlSectionDetails, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop.add(jpnlFooter1, gridBagConstraints);

    jpnlBody1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlBody1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlBody1.setLayout(new java.awt.GridBagLayout());

    jlblCertificateOfRegistration1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    jlblCertificateOfRegistration1.setForeground(new java.awt.Color(0, 0, 0));
    jlblCertificateOfRegistration1.setText("OFFICIAL CLASS LIST");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlBody1.add(jlblCertificateOfRegistration1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop.add(jpnlBody1, gridBagConstraints);

    jpnlHeader1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlHeader1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlHeader1.setLayout(new java.awt.GridBagLayout());

    jpnlClassListLogo.setBackground(new java.awt.Color(255, 255, 255));
    jpnlClassListLogo.setForeground(new java.awt.Color(0, 0, 0));
    jpnlClassListLogo.setMinimumSize(new java.awt.Dimension(100, 100));
    jpnlClassListLogo.setPreferredSize(new java.awt.Dimension(120, 120));
    jpnlClassListLogo.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader1.add(jpnlClassListLogo, gridBagConstraints);

    jPanel14.setBackground(new java.awt.Color(255, 255, 255));
    jPanel14.setForeground(new java.awt.Color(0, 0, 0));
    jPanel14.setMinimumSize(new java.awt.Dimension(600, 18));
    jPanel14.setPreferredSize(new java.awt.Dimension(600, 18));
    jPanel14.setLayout(new java.awt.GridBagLayout());

    jLabel34.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
    jLabel34.setForeground(new java.awt.Color(0, 102, 204));
    jLabel34.setText("Mother of Perpetual Help School");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel14.add(jLabel34, gridBagConstraints);

    jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel35.setForeground(new java.awt.Color(51, 51, 51));
    jLabel35.setText("Iris Street Dahlia, West Fairview Quezon City");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel14.add(jLabel35, gridBagConstraints);

    jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel36.setForeground(new java.awt.Color(51, 51, 51));
    jLabel36.setText("1118 Metro Manila, Philippines");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel14.add(jLabel36, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader1.add(jPanel14, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop.add(jpnlHeader1, gridBagConstraints);

    jPanel7.setBackground(new java.awt.Color(255, 255, 255));
    jPanel7.setMinimumSize(new java.awt.Dimension(600, 300));
    jPanel7.setPreferredSize(new java.awt.Dimension(500, 300));
    jPanel7.setLayout(new java.awt.GridBagLayout());

    jtblClassList.setBackground(new java.awt.Color(255, 255, 255));
    jtblClassList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jtblClassList.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "No", "Student No", "Last Name", "First Name", "MiddleName"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblClassList.setRowHeight(30);
    jtblClassList.getTableHeader().setReorderingAllowed(false);
    jScrollPane4.setViewportView(jtblClassList);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel7.add(jScrollPane4, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop.add(jPanel7, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListReportSummary.add(jpnlClassListTop, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_classlist.add(jpnlClassListReportSummary, gridBagConstraints);

    jTabbedPane1.addTab("Class List", panel_classlist);

    panel_classschedules.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_classschedules.setLayout(new java.awt.GridBagLayout());

    panel_details5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details5.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details5.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details5.setLayout(new java.awt.GridBagLayout());

    lbl_name22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name22.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details5.add(lbl_name22, gridBagConstraints);

    combo_gradelevel15.setEditable(true);
    combo_gradelevel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
    combo_gradelevel15.setMinimumSize(new java.awt.Dimension(100, 25));
    combo_gradelevel15.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details5.add(combo_gradelevel15, gridBagConstraints);

    lbl_name24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name24.setText("Class Schedule by :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details5.add(lbl_name24, gridBagConstraints);

    combo_gradelevel17.setEditable(true);
    combo_gradelevel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Adviser", "Non-Adviser", "Summer Teacher", " ", " ", " " }));
    combo_gradelevel17.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel17.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details5.add(combo_gradelevel17, gridBagConstraints);

    lbl_name25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name25.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details5.add(lbl_name25, gridBagConstraints);

    combo_gradelevel18.setEditable(true);
    combo_gradelevel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Kindergarten", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " ", " " }));
    combo_gradelevel18.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel18.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details5.add(combo_gradelevel18, gridBagConstraints);

    lbl_name28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name28.setText("Faculty Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details5.add(lbl_name28, gridBagConstraints);

    combo_gradelevel19.setEditable(true);
    combo_gradelevel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", " " }));
    combo_gradelevel19.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel19.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details5.add(combo_gradelevel19, gridBagConstraints);

    lbl_name29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name29.setText("Subject Code :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details5.add(lbl_name29, gridBagConstraints);

    combo_gradelevel20.setEditable(true);
    combo_gradelevel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", " " }));
    combo_gradelevel20.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel20.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 9;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 20);
    panel_details5.add(combo_gradelevel20, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_classschedules.add(panel_details5, gridBagConstraints);

    panel_controls5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls5.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls5.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls5.setLayout(new java.awt.GridBagLayout());

    btn_Search19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search19.setText("Generate Report");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls5.add(btn_Search19, gridBagConstraints);

    btn_Search20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search20.setText("Reset");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    panel_controls5.add(btn_Search20, gridBagConstraints);

    btn_Search21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search21.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    panel_controls5.add(btn_Search21, gridBagConstraints);

    lbl_name26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name26.setText("Result Count :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls5.add(lbl_name26, gridBagConstraints);

    lbl_name27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name27.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls5.add(lbl_name27, gridBagConstraints);

    lbl_name30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name30.setText("Adviser :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls5.add(lbl_name30, gridBagConstraints);

    btn_Search22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search22.setText("View");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    panel_controls5.add(btn_Search22, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_classschedules.add(panel_controls5, gridBagConstraints);

    panel_summary5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_summary5.setLayout(new java.awt.GridBagLayout());

    jScrollPane5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jtblSchedules.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "School Year", "Depende sa report", "Depende nga"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblSchedules.setIntercellSpacing(new java.awt.Dimension(16, 1));
    jtblSchedules.setRowHeight(20);
    jScrollPane5.setViewportView(jtblSchedules);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_summary5.add(jScrollPane5, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_classschedules.add(panel_summary5, gridBagConstraints);

    jTabbedPane1.addTab("Class Schedules", panel_classschedules);

    panel_reportcards.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_reportcards.setLayout(new java.awt.GridBagLayout());

    panel_details6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_details6.setMinimumSize(new java.awt.Dimension(995, 70));
    panel_details6.setPreferredSize(new java.awt.Dimension(995, 70));
    panel_details6.setLayout(new java.awt.GridBagLayout());

    lbl_name31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name31.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_details6.add(lbl_name31, gridBagConstraints);

    jmcbReportCardFilterBySchoolYear.setEditable(true);
    jmcbReportCardFilterBySchoolYear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jmcbReportCardFilterBySchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
    jmcbReportCardFilterBySchoolYear.setMinimumSize(new java.awt.Dimension(100, 25));
    jmcbReportCardFilterBySchoolYear.setPreferredSize(new java.awt.Dimension(100, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    panel_details6.add(jmcbReportCardFilterBySchoolYear, gridBagConstraints);

    jtfReportCardSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
    jtfReportCardSearchBox.setText("Search Here");
    jtfReportCardSearchBox.setMinimumSize(new java.awt.Dimension(200, 25));
    jtfReportCardSearchBox.setPreferredSize(new java.awt.Dimension(200, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    panel_details6.add(jtfReportCardSearchBox, gridBagConstraints);

    jbtnReportCardsSearchBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jbtnReportCardsSearchBox.setText("Search");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    panel_details6.add(jbtnReportCardsSearchBox, gridBagConstraints);

    lbl_name39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name39.setText("Search by :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
    panel_details6.add(lbl_name39, gridBagConstraints);

    combo_gradelevel26.setEditable(true);
    combo_gradelevel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    combo_gradelevel26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student ID", "Student Name", "Grade Level", "Receipt Number", " ", " ", " ", " " }));
    combo_gradelevel26.setMinimumSize(new java.awt.Dimension(150, 25));
    combo_gradelevel26.setPreferredSize(new java.awt.Dimension(150, 25));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
    panel_details6.add(combo_gradelevel26, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    panel_reportcards.add(panel_details6, gridBagConstraints);

    panel_controls6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
    panel_controls6.setMinimumSize(new java.awt.Dimension(995, 50));
    panel_controls6.setPreferredSize(new java.awt.Dimension(995, 50));
    panel_controls6.setLayout(new java.awt.GridBagLayout());

    btn_Search23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search23.setText("Generate Report");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls6.add(btn_Search23, gridBagConstraints);

    btn_Search24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search24.setText("Reset");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    panel_controls6.add(btn_Search24, gridBagConstraints);

    btn_Search25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search25.setText("Print");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    panel_controls6.add(btn_Search25, gridBagConstraints);

    lbl_name36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name36.setText("Result Count :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls6.add(lbl_name36, gridBagConstraints);

    lbl_name37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name37.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls6.add(lbl_name37, gridBagConstraints);

    lbl_name38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lbl_name38.setText("Adviser :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
    panel_controls6.add(lbl_name38, gridBagConstraints);

    btn_Search26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btn_Search26.setText("View");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    panel_controls6.add(btn_Search26, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
    panel_reportcards.add(panel_controls6, gridBagConstraints);

    panel_summary6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
    panel_summary6.setLayout(new java.awt.GridBagLayout());

    jpnlClassListTop1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlClassListTop1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlClassListTop1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlClassListTop1.setPreferredSize(new java.awt.Dimension(700, 599));
    jpnlClassListTop1.setLayout(new java.awt.GridBagLayout());

    jpnlFooter2.setBackground(new java.awt.Color(255, 255, 255));
    jpnlFooter2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlFooter2.setForeground(new java.awt.Color(0, 0, 0));
    jpnlFooter2.setMinimumSize(new java.awt.Dimension(795, 30));
    jpnlFooter2.setPreferredSize(new java.awt.Dimension(1180, 30));
    jpnlFooter2.setLayout(new java.awt.GridBagLayout());

    jpnlSectionDetails1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlSectionDetails1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlSectionDetails1.setLayout(new java.awt.GridBagLayout());

    jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(0, 0, 0));
    jLabel23.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jLabel23, gridBagConstraints);

    jlblClassListSectionName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListSectionName1.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListSectionName1.setText("Section Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jlblClassListSectionName1, gridBagConstraints);

    jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(0, 0, 0));
    jLabel26.setText("Grade Level :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jLabel26, gridBagConstraints);

    jlblClassListGradeLevelText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListGradeLevelText1.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListGradeLevelText1.setText("Grade Level Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jlblClassListGradeLevelText1, gridBagConstraints);

    jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel29.setForeground(new java.awt.Color(0, 0, 0));
    jLabel29.setText("Adviser :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jLabel29, gridBagConstraints);

    jlblClassListAdviserName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListAdviserName1.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListAdviserName1.setText("Adviser Name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jlblClassListAdviserName1, gridBagConstraints);

    jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(0, 0, 0));
    jLabel18.setText("School Year :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jLabel18, gridBagConstraints);

    jlblClassListSchoolYear1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jlblClassListSchoolYear1.setForeground(new java.awt.Color(0, 0, 0));
    jlblClassListSchoolYear1.setText("SY Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSectionDetails1.add(jlblClassListSchoolYear1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlFooter2.add(jpnlSectionDetails1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop1.add(jpnlFooter2, gridBagConstraints);

    jpnlBody2.setBackground(new java.awt.Color(255, 255, 255));
    jpnlBody2.setForeground(new java.awt.Color(0, 0, 0));
    jpnlBody2.setLayout(new java.awt.GridBagLayout());

    jlblCertificateOfRegistration2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    jlblCertificateOfRegistration2.setForeground(new java.awt.Color(0, 0, 0));
    jlblCertificateOfRegistration2.setText("REPORT CARD");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlBody2.add(jlblCertificateOfRegistration2, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop1.add(jpnlBody2, gridBagConstraints);

    jpnlHeader2.setBackground(new java.awt.Color(255, 255, 255));
    jpnlHeader2.setForeground(new java.awt.Color(0, 0, 0));
    jpnlHeader2.setLayout(new java.awt.GridBagLayout());

    jpnlClassListLogo1.setBackground(new java.awt.Color(255, 255, 255));
    jpnlClassListLogo1.setForeground(new java.awt.Color(0, 0, 0));
    jpnlClassListLogo1.setMinimumSize(new java.awt.Dimension(100, 100));
    jpnlClassListLogo1.setPreferredSize(new java.awt.Dimension(120, 120));
    jpnlClassListLogo1.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader2.add(jpnlClassListLogo1, gridBagConstraints);

    jPanel15.setBackground(new java.awt.Color(255, 255, 255));
    jPanel15.setForeground(new java.awt.Color(0, 0, 0));
    jPanel15.setMinimumSize(new java.awt.Dimension(600, 18));
    jPanel15.setPreferredSize(new java.awt.Dimension(600, 18));
    jPanel15.setLayout(new java.awt.GridBagLayout());

    jLabel37.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
    jLabel37.setForeground(new java.awt.Color(0, 102, 204));
    jLabel37.setText("Mother of Perpetual Help School");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel15.add(jLabel37, gridBagConstraints);

    jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel38.setForeground(new java.awt.Color(51, 51, 51));
    jLabel38.setText("Iris Street Dahlia, West Fairview Quezon City");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel15.add(jLabel38, gridBagConstraints);

    jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel39.setForeground(new java.awt.Color(51, 51, 51));
    jLabel39.setText("1118 Metro Manila, Philippines");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
    jPanel15.add(jLabel39, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader2.add(jPanel15, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop1.add(jpnlHeader2, gridBagConstraints);

    jPanel8.setBackground(new java.awt.Color(255, 255, 255));
    jPanel8.setMinimumSize(new java.awt.Dimension(600, 300));
    jPanel8.setPreferredSize(new java.awt.Dimension(500, 300));
    jPanel8.setLayout(new java.awt.GridBagLayout());

    jtblReportCard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jtblReportCard.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Subject", "1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter", "Final Grade"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, true, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblReportCard.setEnabled(false);
    jtblReportCard.setRowHeight(35);
    jtblReportCard.getTableHeader().setReorderingAllowed(false);
    jspReportCard.setViewportView(jtblReportCard);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jspReportCard, gridBagConstraints);

    jLabel20.setBackground(new java.awt.Color(255, 255, 255));
    jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel20.setForeground(new java.awt.Color(0, 0, 0));
    jLabel20.setText("General Average :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jLabel20, gridBagConstraints);

    jTextField1.setBackground(new java.awt.Color(255, 255, 255));
    jTextField1.setColumns(8);
    jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jTextField1.setForeground(new java.awt.Color(0, 0, 0));
    jTextField1.setEnabled(false);
    jTextField1.setMinimumSize(new java.awt.Dimension(50, 23));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jTextField1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlClassListTop1.add(jPanel8, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    panel_summary6.add(jpnlClassListTop1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_reportcards.add(panel_summary6, gridBagConstraints);

    jTabbedPane1.addTab("Report Cards", panel_reportcards);

    panel_settings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    panel_settings.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("Settings", panel_settings);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    panel_toppanel.add(jTabbedPane1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    add(panel_toppanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_Search1;
    private javax.swing.JButton btn_Search10;
    private javax.swing.JButton btn_Search11;
    private javax.swing.JButton btn_Search12;
    private javax.swing.JButton btn_Search13;
    private javax.swing.JButton btn_Search14;
    private javax.swing.JButton btn_Search19;
    private javax.swing.JButton btn_Search20;
    private javax.swing.JButton btn_Search21;
    private javax.swing.JButton btn_Search22;
    private javax.swing.JButton btn_Search23;
    private javax.swing.JButton btn_Search24;
    private javax.swing.JButton btn_Search25;
    private javax.swing.JButton btn_Search26;
    private javax.swing.JButton btn_Search3;
    private javax.swing.JButton btn_Search4;
    private javax.swing.JButton btn_Search5;
    private javax.swing.JButton btn_Search6;
    private javax.swing.JComboBox<String> combo_gradelevel;
    private javax.swing.JComboBox<String> combo_gradelevel1;
    private javax.swing.JComboBox<String> combo_gradelevel10;
    private javax.swing.JComboBox<String> combo_gradelevel13;
    private javax.swing.JComboBox<String> combo_gradelevel15;
    private javax.swing.JComboBox<String> combo_gradelevel17;
    private javax.swing.JComboBox<String> combo_gradelevel18;
    private javax.swing.JComboBox<String> combo_gradelevel19;
    private javax.swing.JComboBox<String> combo_gradelevel2;
    private javax.swing.JComboBox<String> combo_gradelevel20;
    private javax.swing.JComboBox<String> combo_gradelevel26;
    private javax.swing.JComboBox<String> combo_gradelevel3;
    private javax.swing.JComboBox<String> combo_gradelevel4;
    private javax.swing.JComboBox<String> combo_gradelevel5;
    private javax.swing.JComboBox<String> combo_gradelevel6;
    private javax.swing.JComboBox<String> combo_gradelevel7;
    private javax.swing.JComboBox<String> combo_gradelevel9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtnClassListGenerateReport;
    private javax.swing.JButton jbtnClassListPrint;
    private javax.swing.JButton jbtnCorPrint;
    private javax.swing.JButton jbtnGenerateCOR;
    private javax.swing.JButton jbtnReportCardsSearchBox;
    private javax.swing.JComboBox<String> jcmbClassListGradeLevel;
    private javax.swing.JComboBox<String> jcmbClassListSchoolYear;
    private javax.swing.JComboBox<String> jcmbClassListSectionType;
    private javax.swing.JComboBox<String> jcmbClassListSecttion;
    private javax.swing.JComboBox<String> jcmbCorSchoolYear;
    private javax.swing.JLabel jlblAdviserName;
    private javax.swing.JLabel jlblCORAddressText;
    private javax.swing.JLabel jlblCORContact;
    private javax.swing.JLabel jlblCORDateToday;
    private javax.swing.JLabel jlblCORGradeLevelText;
    private javax.swing.JLabel jlblCORSchoolYear;
    private javax.swing.JLabel jlblCORSectionName;
    private javax.swing.JLabel jlblCORStudentName;
    private javax.swing.JLabel jlblCORStudentNo;
    private javax.swing.JLabel jlblCORStudentType;
    private javax.swing.JLabel jlblCertificateOfRegistration;
    private javax.swing.JLabel jlblCertificateOfRegistration1;
    private javax.swing.JLabel jlblCertificateOfRegistration2;
    private javax.swing.JLabel jlblClassListAdviserName;
    private javax.swing.JLabel jlblClassListAdviserName1;
    private javax.swing.JLabel jlblClassListGradeLevelText;
    private javax.swing.JLabel jlblClassListGradeLevelText1;
    private javax.swing.JLabel jlblClassListSchoolYear;
    private javax.swing.JLabel jlblClassListSchoolYear1;
    private javax.swing.JLabel jlblClassListSectionName;
    private javax.swing.JLabel jlblClassListSectionName1;
    private javax.swing.JLabel jlblTotalAmount;
    private javax.swing.JLabel jlblUserCompleteName;
    private javax.swing.JLabel jlblUserRole;
    private javax.swing.JComboBox<String> jmcbReportCardFilterBySchoolYear;
    private javax.swing.JPanel jpnlBody;
    private javax.swing.JPanel jpnlBody1;
    private javax.swing.JPanel jpnlBody2;
    private javax.swing.JPanel jpnlClassListLogo;
    private javax.swing.JPanel jpnlClassListLogo1;
    private javax.swing.JPanel jpnlClassListReportSummary;
    private javax.swing.JPanel jpnlClassListTop;
    private javax.swing.JPanel jpnlClassListTop1;
    private javax.swing.JPanel jpnlFooter;
    private javax.swing.JPanel jpnlFooter1;
    private javax.swing.JPanel jpnlFooter2;
    private javax.swing.JPanel jpnlHeader;
    private javax.swing.JPanel jpnlHeader1;
    private javax.swing.JPanel jpnlHeader2;
    private javax.swing.JPanel jpnlLogo;
    private javax.swing.JPanel jpnlMiscellaneous;
    private javax.swing.JPanel jpnlOthers;
    private javax.swing.JPanel jpnlSectionDetails;
    private javax.swing.JPanel jpnlSectionDetails1;
    private javax.swing.JPanel jpnlStudentDetails;
    private javax.swing.JPanel jpnlTop;
    private javax.swing.JPanel jpnlTuition;
    private javax.swing.JScrollPane jspReportCard;
    private javax.swing.JTable jtblCORMiscellaneous;
    private javax.swing.JTable jtblCOROthers;
    private javax.swing.JTable jtblCORPaymentAssessment;
    private javax.swing.JTable jtblCORSchedule;
    private javax.swing.JTable jtblCORTuition;
    private javax.swing.JTable jtblClassList;
    private javax.swing.JTable jtblReceipts;
    private javax.swing.JTable jtblReportCard;
    private javax.swing.JTable jtblSchedules;
    private javax.swing.JTextField jtfCorSearchBox;
    private javax.swing.JTextField jtfReceiptsSearchBox;
    private javax.swing.JTextField jtfReportCardSearchBox;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_name10;
    private javax.swing.JLabel lbl_name11;
    private javax.swing.JLabel lbl_name12;
    private javax.swing.JLabel lbl_name14;
    private javax.swing.JLabel lbl_name15;
    private javax.swing.JLabel lbl_name16;
    private javax.swing.JLabel lbl_name17;
    private javax.swing.JLabel lbl_name18;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JLabel lbl_name21;
    private javax.swing.JLabel lbl_name22;
    private javax.swing.JLabel lbl_name24;
    private javax.swing.JLabel lbl_name25;
    private javax.swing.JLabel lbl_name26;
    private javax.swing.JLabel lbl_name27;
    private javax.swing.JLabel lbl_name28;
    private javax.swing.JLabel lbl_name29;
    private javax.swing.JLabel lbl_name3;
    private javax.swing.JLabel lbl_name30;
    private javax.swing.JLabel lbl_name31;
    private javax.swing.JLabel lbl_name36;
    private javax.swing.JLabel lbl_name37;
    private javax.swing.JLabel lbl_name38;
    private javax.swing.JLabel lbl_name39;
    private javax.swing.JLabel lbl_name4;
    private javax.swing.JLabel lbl_name5;
    private javax.swing.JLabel lbl_name6;
    private javax.swing.JLabel lbl_name7;
    private javax.swing.JLabel lbl_name8;
    private javax.swing.JLabel lbl_name9;
    private javax.swing.JPanel panel_COR;
    private javax.swing.JPanel panel_accounts;
    private javax.swing.JPanel panel_classlist;
    private javax.swing.JPanel panel_classschedules;
    private javax.swing.JPanel panel_controls;
    private javax.swing.JPanel panel_controls1;
    private javax.swing.JPanel panel_controls2;
    private javax.swing.JPanel panel_controls3;
    private javax.swing.JPanel panel_controls4;
    private javax.swing.JPanel panel_controls5;
    private javax.swing.JPanel panel_controls6;
    private javax.swing.JPanel panel_details;
    private javax.swing.JPanel panel_details1;
    private javax.swing.JPanel panel_details2;
    private javax.swing.JPanel panel_details3;
    private javax.swing.JPanel panel_details4;
    private javax.swing.JPanel panel_details5;
    private javax.swing.JPanel panel_details6;
    private javax.swing.JPanel panel_facultyreports;
    private javax.swing.JPanel panel_receipts;
    private javax.swing.JPanel panel_reportcards;
    private javax.swing.JPanel panel_settings;
    private javax.swing.JPanel panel_sttudentreports;
    private javax.swing.JPanel panel_summary;
    private javax.swing.JPanel panel_summary1;
    private javax.swing.JPanel panel_summary2;
    private javax.swing.JPanel panel_summary3;
    private javax.swing.JPanel panel_summary5;
    private javax.swing.JPanel panel_summary6;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
