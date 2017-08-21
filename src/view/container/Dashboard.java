package view.container;

import controller.admintools.DisplayRecordGeneratorController;
import daoimpl.FacultyDaoImpl;
import daoimpl.PermissionDaoImpl;
import view.enrollment.EnrollmentPanel;
import view.user.AllUsersRecord;
import view.registration.RegistrationForm;
import utility.calendar.CalendarUtil;
import utility.layout.CardLayoutUtil;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import utility.component.ImageUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import model.permission.dashboardpermission.DashboardPermission;
import model.role.Role;
import model.testdata.SubjectTestDataModel;
import model.user.User;
import threads.SchoolYearLoaderThread;
import view.grades.GradesRecord;
import view.payment.PaymentAndAssessmentForm;
import view.reports.Reports;

public class Dashboard extends javax.swing.JFrame {

    private Image imageSchoolLogo;
    private Image imageEnrollment;
    private Image imageRegistration;
    private Image imageGrades;
    private Image imageManagement;
    private Image imageAccounts;
    private Image imagePayments;
    private Image imageReports;
    private Image imageHeader;
    private Image imageCalendar;
    private Image imageUser;

    private ImageIcon imageIconHome;

    private final GUIManager guiManager = new GUIManager();

    private static int REGISTRATION_TAB_INDEX;
    private static int ENROLLMENT_TAB_INDEX;
    private static int GRADES_TAB_INDEX;
    private static int REPORTS_TAB_INDEX;
    private static int MANAGEMENT_TAB_INDEX;
    private static int ACCOUNTS_TAB_INDEX;
    private static int PAYMENTS_TAB_INDEX;

    private static int REGISTRATION_INSTANCE = 0;
    private static int ENROLLMENT_INSTANCE = 0;
    private static int GRADES_INSTANCE = 0;
    private static int REPORTS_INSTANCE = 0;
    private static int MANAGEMENT_INSTANCE = 0;
    private static int ACCOUNTS_INSTANCE = 0;
    private static int PAYMENTS_INSTANCE = 0;

    private boolean hasRegistrationAccess;
    private boolean hasReportsAccess;
    private boolean hasEnrollmentAccess;
    private boolean hasPaymentAccess;
    private boolean hasAccountsAccess;
    private boolean hasGradesAccess;
    private boolean hasSettingsAccess;

    private final User user;
    public static int userId;
    public static int facultyId;

    public Dashboard(User user) {
        initComponents();
        this.user = user;
        userId = user.getId();
        loadFacultyId();
        
        setUILookAndFeel();
        initDashboardPermissions();
        guiManager.prepareImageBackgrounds();
        guiManager.setGUIComponentProperties();

        initThreads();
        setUserInfo();
        initControllers();
        
        //
        SubjectTestDataModel stdm = new SubjectTestDataModel();
        stdm.getDescription();
    }
    
    private void loadFacultyId(){
        Role role = user.getRole();
        String roleName = role.getRoleName();
        if(roleName.toLowerCase().equals("faculty")){
            FacultyDaoImpl facultyDaoImpl = new FacultyDaoImpl();
            facultyId = facultyDaoImpl.getFacultyIdByUserId(userId);
            System.out.println("Faculty Id Is :"+facultyId);
        }
    }

    private void setUILookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initControllers() {
        lbl_RoleLabel.addMouseListener(new DisplayRecordGeneratorController());
    }

    private void initThreads() {
        SchoolYearLoaderThread schoolYearThread = new SchoolYearLoaderThread(jlblCurrentSchoolYear);
        schoolYearThread.start();
    }

    private void setUserInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(user.getLastLoginDate());
        String time = timeFormat.format(user.getLastLoginDate());

        lbl_FirstNameText.setText(user.getFirstName());
        lbl_LastNameText.setText(user.getLastName());
        lbl_MiddleNameText.setText(user.getMiddleName());
        jlblUserIdText.setText(user.getId() + "");
        jlblLastLoginText.setText("" + user.getLastLoginDate());
        jlblLastLoginText.setText(date);
        jlblTimeText.setText(time);
        jlblHelloUserNameText.setText(user.getFirstName());
        jlblRoleText.setText(user.getRole().getRoleName());
    }

    private void initDashboardPermissions() {
        PermissionDaoImpl pdi = new PermissionDaoImpl();
        DashboardPermission dbp = pdi.getDashBoardPermissionByRoleId(user.getRole().getId());
        hasAccountsAccess = dbp.hasAccountsAccess();
        hasEnrollmentAccess = dbp.hasEnrollmentAccess();
        hasGradesAccess = dbp.hasGradeAccess();
        hasPaymentAccess = dbp.hasPaymentAccess();
        hasRegistrationAccess = dbp.hasRegistrationAccess();
        hasSettingsAccess = dbp.hasSettingsAccess();
        hasReportsAccess = dbp.hasReportsAccess();
    }

    public static int getREGISTRATION_INSTANCE() {
        return REGISTRATION_INSTANCE;
    }

    public static void setREGISTRATION_INSTANCE(int REGISTRATION_INSTANCE) {
        Dashboard.REGISTRATION_INSTANCE = REGISTRATION_INSTANCE;
    }

    public static int getENROLLMENT_INSTANCE() {
        return ENROLLMENT_INSTANCE;
    }

    public static void setENROLLMENT_INSTANCE(int ENROLLMENT_INSTANCE) {
        Dashboard.ENROLLMENT_INSTANCE = ENROLLMENT_INSTANCE;
    }

    public static int getGRADES_INSTANCE() {
        return GRADES_INSTANCE;
    }

    public static void setGRADES_INSTANCE(int GRADES_INSTANCE) {
        Dashboard.GRADES_INSTANCE = GRADES_INSTANCE;
    }

    public static int getREPORTS_INSTANCE() {
        return REPORTS_INSTANCE;
    }

    public static void setREPORTS_INSTANCE(int REPORTS_INSTANCE) {
        Dashboard.REPORTS_INSTANCE = REPORTS_INSTANCE;
    }

    public static int getMANAGEMENT_INSTANCE() {
        return MANAGEMENT_INSTANCE;
    }

    public static void setMANAGEMENT_INSTANCE(int MANAGEMENT_INSTANCE) {
        Dashboard.MANAGEMENT_INSTANCE = MANAGEMENT_INSTANCE;
    }

    public static int getACCOUNTS_INSTANCE() {
        return ACCOUNTS_INSTANCE;
    }

    public static void setACCOUNTS_INSTANCE(int ACCOUNTS_INSTANCE) {
        Dashboard.ACCOUNTS_INSTANCE = ACCOUNTS_INSTANCE;
    }

    public static int getPAYMENTS_INSTANCE() {
        return PAYMENTS_INSTANCE;
    }

    public static void setPAYMENTS_INSTANCE(int PAYMENTS_INSTANCE) {
        Dashboard.PAYMENTS_INSTANCE = PAYMENTS_INSTANCE;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jspTopMost = new javax.swing.JScrollPane();
        jpnlTopPanel = new javax.swing.JPanel();
        jtpTopTabbedPane = new javax.swing.JTabbedPane();
        jpnlTopCardContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpnlTopCard = new javax.swing.JPanel();
        jpnlHeader = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.8f));
            g2d.drawImage(imageHeader, 0, 0, getWidth(), getHeight(), null);
            jpnlTopPanel.repaint();
        }
    };
    iconsContainer = new javax.swing.JPanel();
    jpnlSchoolYear = new javax.swing.JPanel();
    jlblCurrentSchoolYear = new javax.swing.JLabel();
    jpnlBody = new javax.swing.JPanel();
    jspCardContainer = new javax.swing.JScrollPane();
    cardContainer = new javax.swing.JPanel();
    jpnlLaunchPad = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jpnlCalendar = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageCalendar, 0, 0, getWidth(), getHeight(), null);

        jpnlTopPanel.repaint();
    }
    };
    calendarPanel = new javax.swing.JPanel();
    jlblDayToday = new javax.swing.JLabel();
    jlblDateToday = new javax.swing.JLabel();
    jpnlButtons = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){

            g.drawImage(imageSchoolLogo,0,0,getWidth(),getHeight(),this);
            super.repaint();
        }
    };
    jpnlPaymentButton = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imagePayments, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblPayment = new javax.swing.JLabel();
    jlblAssessmentText = new javax.swing.JLabel();
    jpnlRegistrationButton = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageRegistration, 0, 0, getWidth(), getHeight(), null);
        super.repaint();
    }
    };
    jlblRegistration = new javax.swing.JLabel();
    jpnlEnrollmentButton = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageEnrollment, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblEnrollment = new javax.swing.JLabel();
    jpnlGradesButton = new javax.swing.JPanel() {
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageGrades, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblGrades = new javax.swing.JLabel();
    jpnlManagementButton = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageManagement, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblSettings = new javax.swing.JLabel();
    jpnlAccountsButton = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageAccounts, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblAccounts = new javax.swing.JLabel();
    jpnlReportsButton = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageReports, 0, 0, getWidth(), getHeight(), null);

        super.repaint();
    }
    };
    jlblReports = new javax.swing.JLabel();
    jpnlUserInformation = new javax.swing.JPanel();
    jpnlUserImage = new javax.swing.JPanel(){
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g2d.drawImage(imageUser, 0, 0, getWidth(), getHeight(), null);
        super.repaint();
    }
    };
    jpnlAccountInformation = new javax.swing.JPanel();
    jlblChangePassword = new javax.swing.JLabel();
    jlblStatus = new javax.swing.JLabel();
    jlblLastLoginText = new javax.swing.JLabel();
    jlblUserIdLabel = new javax.swing.JLabel();
    jlblUserIdText = new javax.swing.JLabel();
    jlblLastNameLabel = new javax.swing.JLabel();
    lbl_LastNameText = new javax.swing.JLabel();
    jlblFirstNameLabel = new javax.swing.JLabel();
    lbl_FirstNameText = new javax.swing.JLabel();
    jlblMiddleNameLabel = new javax.swing.JLabel();
    lbl_MiddleNameText = new javax.swing.JLabel();
    lbl_RoleLabel = new javax.swing.JLabel();
    jlblRoleText = new javax.swing.JLabel();
    jlblTimeText = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jlblLogout = new javax.swing.JLabel();
    jpnlHelloUser = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jlblHelloUserNameText = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Enrollment System");
    setBounds(new java.awt.Rectangle(0, 0, 0, 0));
    setMinimumSize(new java.awt.Dimension(800, 600));
    addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            formKeyPressed(evt);
        }
    });
    getContentPane().setLayout(new java.awt.GridBagLayout());

    jspTopMost.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    jspTopMost.setFocusCycleRoot(true);
    jspTopMost.setMinimumSize(new java.awt.Dimension(900, 650));
    jspTopMost.setPreferredSize(new java.awt.Dimension(900, 900));

    jpnlTopPanel.setBackground(new java.awt.Color(0, 114, 187));
    jpnlTopPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jpnlTopPanel.setMinimumSize(new java.awt.Dimension(900, 400));
    jpnlTopPanel.setPreferredSize(new java.awt.Dimension(900, 400));
    jpnlTopPanel.setLayout(new java.awt.BorderLayout());

    jtpTopTabbedPane.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jtpTopTabbedPane.setMinimumSize(new java.awt.Dimension(900, 650));
    jtpTopTabbedPane.setPreferredSize(new java.awt.Dimension(900, 400));
    jtpTopTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jtpTopTabbedPaneMouseClicked(evt);
        }
    });

    jpnlTopCardContainer.setPreferredSize(new java.awt.Dimension(900, 400));
    jpnlTopCardContainer.setLayout(new java.awt.BorderLayout());

    jPanel2.setMinimumSize(new java.awt.Dimension(900, 400));
    jPanel2.setPreferredSize(new java.awt.Dimension(900, 400));
    jPanel2.setLayout(new java.awt.BorderLayout());

    jpnlTopCard.setBackground(new java.awt.Color(0, 114, 187));
    jpnlTopCard.setPreferredSize(new java.awt.Dimension(1560, 400));
    jpnlTopCard.setLayout(new java.awt.GridBagLayout());

    jpnlHeader.setBackground(new java.awt.Color(0, 114, 188));
    jpnlHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlHeader.setPreferredSize(new java.awt.Dimension(1200, 100));
    jpnlHeader.setLayout(new java.awt.GridBagLayout());

    iconsContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    iconsContainer.setOpaque(false);
    iconsContainer.setPreferredSize(new java.awt.Dimension(200, 75));
    iconsContainer.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader.add(iconsContainer, gridBagConstraints);

    jpnlSchoolYear.setOpaque(false);
    jpnlSchoolYear.setLayout(new java.awt.GridBagLayout());

    jlblCurrentSchoolYear.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 48)); // NOI18N
    jlblCurrentSchoolYear.setForeground(new java.awt.Color(255, 255, 255));
    jlblCurrentSchoolYear.setText("School Year: ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlSchoolYear.add(jlblCurrentSchoolYear, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHeader.add(jpnlSchoolYear, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    jpnlTopCard.add(jpnlHeader, gridBagConstraints);

    jpnlBody.setBackground(new java.awt.Color(255, 255, 255));
    jpnlBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlBody.setMaximumSize(new java.awt.Dimension(1080, 328));
    jpnlBody.setMinimumSize(new java.awt.Dimension(1080, 328));
    jpnlBody.setPreferredSize(new java.awt.Dimension(1100, 400));
    jpnlBody.setLayout(new java.awt.BorderLayout());

    jspCardContainer.setPreferredSize(new java.awt.Dimension(900, 326));

    cardContainer.setMinimumSize(new java.awt.Dimension(920, 400));
    cardContainer.setOpaque(false);
    cardContainer.setPreferredSize(new java.awt.Dimension(920, 300));
    cardContainer.setLayout(new java.awt.BorderLayout());

    jpnlLaunchPad.setMinimumSize(new java.awt.Dimension(928, 400));
    jpnlLaunchPad.setOpaque(false);
    jpnlLaunchPad.setPreferredSize(new java.awt.Dimension(1010, 400));
    jpnlLaunchPad.setLayout(new java.awt.BorderLayout());

    jPanel1.setMinimumSize(new java.awt.Dimension(850, 400));
    jPanel1.setPreferredSize(new java.awt.Dimension(850, 400));
    jPanel1.setLayout(new java.awt.GridBagLayout());

    jpnlCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlCalendar.setMinimumSize(new java.awt.Dimension(210, 180));
    jpnlCalendar.setPreferredSize(new java.awt.Dimension(210, 180));
    jpnlCalendar.setLayout(new java.awt.GridBagLayout());

    calendarPanel.setOpaque(false);
    calendarPanel.setLayout(new java.awt.GridBagLayout());

    jlblDayToday.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
    jlblDayToday.setForeground(new java.awt.Color(255, 255, 255));
    jlblDayToday.setText("dayTodayText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(20, 220, 0, 0);
    calendarPanel.add(jlblDayToday, gridBagConstraints);

    jlblDateToday.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
    jlblDateToday.setForeground(new java.awt.Color(255, 255, 255));
    jlblDateToday.setText("dateTodayText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 220, 0, 0);
    calendarPanel.add(jlblDateToday, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlCalendar.add(calendarPanel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 0.5;
    jPanel1.add(jpnlCalendar, gridBagConstraints);

    jpnlButtons.setBackground(new java.awt.Color(255, 255, 255));
    jpnlButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlButtons.setMinimumSize(new java.awt.Dimension(850, 442));
    jpnlButtons.setPreferredSize(new java.awt.Dimension(850, 442));
    jpnlButtons.setLayout(new java.awt.GridBagLayout());

    jpnlPaymentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlPaymentButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlPaymentButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlPaymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlPaymentButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlPaymentButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlPaymentButtonMouseExited(evt);
        }
    });
    jpnlPaymentButton.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jpnlPaymentButtonKeyPressed(evt);
        }
    });
    jpnlPaymentButton.setLayout(new java.awt.GridBagLayout());

    jlblPayment.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblPayment.setForeground(new java.awt.Color(255, 255, 255));
    jlblPayment.setText("Payment & ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlPaymentButton.add(jlblPayment, gridBagConstraints);

    jlblAssessmentText.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblAssessmentText.setForeground(new java.awt.Color(255, 255, 255));
    jlblAssessmentText.setText("Assessment");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlPaymentButton.add(jlblAssessmentText, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlPaymentButton, gridBagConstraints);

    jpnlRegistrationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlRegistrationButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlRegistrationButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlRegistrationButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlRegistrationButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlRegistrationButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlRegistrationButtonMouseExited(evt);
        }
    });
    jpnlRegistrationButton.setLayout(new java.awt.GridBagLayout());

    jlblRegistration.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblRegistration.setForeground(new java.awt.Color(255, 255, 255));
    jlblRegistration.setText("Registration");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlRegistrationButton.add(jlblRegistration, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlRegistrationButton, gridBagConstraints);

    jpnlEnrollmentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlEnrollmentButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlEnrollmentButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlEnrollmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlEnrollmentButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlEnrollmentButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlEnrollmentButtonMouseExited(evt);
        }
    });
    jpnlEnrollmentButton.setLayout(new java.awt.GridBagLayout());

    jlblEnrollment.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblEnrollment.setForeground(new java.awt.Color(255, 255, 255));
    jlblEnrollment.setText("Enrollment");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlEnrollmentButton.add(jlblEnrollment, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlEnrollmentButton, gridBagConstraints);

    jpnlGradesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlGradesButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlGradesButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlGradesButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlGradesButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlGradesButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlGradesButtonMouseExited(evt);
        }
    });
    jpnlGradesButton.setLayout(new java.awt.GridBagLayout());

    jlblGrades.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblGrades.setForeground(new java.awt.Color(255, 255, 255));
    jlblGrades.setText("Grading System");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlGradesButton.add(jlblGrades, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlGradesButton, gridBagConstraints);

    jpnlManagementButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlManagementButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlManagementButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlManagementButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlManagementButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlManagementButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlManagementButtonMouseExited(evt);
        }
    });
    jpnlManagementButton.setLayout(new java.awt.GridBagLayout());

    jlblSettings.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblSettings.setForeground(new java.awt.Color(255, 255, 255));
    jlblSettings.setText("Settings");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlManagementButton.add(jlblSettings, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlManagementButton, gridBagConstraints);

    jpnlAccountsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlAccountsButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlAccountsButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlAccountsButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlAccountsButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlAccountsButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlAccountsButtonMouseExited(evt);
        }
    });
    jpnlAccountsButton.setLayout(new java.awt.GridBagLayout());

    jlblAccounts.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 30)); // NOI18N
    jlblAccounts.setForeground(new java.awt.Color(255, 255, 255));
    jlblAccounts.setText("User Accounts");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlAccountsButton.add(jlblAccounts, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlAccountsButton, gridBagConstraints);

    jpnlReportsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jpnlReportsButton.setMinimumSize(new java.awt.Dimension(1000, 1000));
    jpnlReportsButton.setPreferredSize(new java.awt.Dimension(1000, 1000));
    jpnlReportsButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jpnlReportsButtonMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jpnlReportsButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jpnlReportsButtonMouseExited(evt);
        }
    });
    jpnlReportsButton.setLayout(new java.awt.GridBagLayout());

    jlblReports.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
    jlblReports.setForeground(new java.awt.Color(255, 255, 255));
    jlblReports.setText("Reports");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
    jpnlReportsButton.add(jlblReports, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlButtons.add(jpnlReportsButton, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 0.5;
    jPanel1.add(jpnlButtons, gridBagConstraints);

    jpnlLaunchPad.add(jPanel1, java.awt.BorderLayout.CENTER);

    cardContainer.add(jpnlLaunchPad, java.awt.BorderLayout.CENTER);

    jspCardContainer.setViewportView(cardContainer);

    jpnlBody.add(jspCardContainer, java.awt.BorderLayout.CENTER);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlTopCard.add(jpnlBody, gridBagConstraints);

    jpnlUserInformation.setBackground(new java.awt.Color(0, 114, 187));
    jpnlUserInformation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlUserInformation.setMinimumSize(new java.awt.Dimension(250, 250));
    jpnlUserInformation.setPreferredSize(new java.awt.Dimension(250, 250));
    jpnlUserInformation.setLayout(new java.awt.GridBagLayout());

    jpnlUserImage.setMaximumSize(new java.awt.Dimension(200, 200));
    jpnlUserImage.setMinimumSize(new java.awt.Dimension(200, 200));
    jpnlUserImage.setOpaque(false);
    jpnlUserImage.setPreferredSize(new java.awt.Dimension(200, 200));
    jpnlUserImage.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlUserInformation.add(jpnlUserImage, gridBagConstraints);

    jpnlAccountInformation.setMinimumSize(new java.awt.Dimension(150, 150));
    jpnlAccountInformation.setOpaque(false);
    jpnlAccountInformation.setPreferredSize(new java.awt.Dimension(150, 149));
    jpnlAccountInformation.setLayout(new java.awt.GridBagLayout());

    jlblChangePassword.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblChangePassword.setForeground(new java.awt.Color(255, 255, 255));
    jlblChangePassword.setText("Edit Account");
    jlblChangePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlblChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlblChangePasswordMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblChangePassword, gridBagConstraints);

    jlblStatus.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblStatus.setForeground(new java.awt.Color(255, 255, 255));
    jlblStatus.setText("Last login date :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblStatus, gridBagConstraints);

    jlblLastLoginText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblLastLoginText.setForeground(new java.awt.Color(0, 0, 0));
    jlblLastLoginText.setText("date text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblLastLoginText, gridBagConstraints);

    jlblUserIdLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblUserIdLabel.setForeground(new java.awt.Color(255, 255, 255));
    jlblUserIdLabel.setText("Account ID :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblUserIdLabel, gridBagConstraints);

    jlblUserIdText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblUserIdText.setForeground(new java.awt.Color(0, 0, 0));
    jlblUserIdText.setText("Account ID Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblUserIdText, gridBagConstraints);

    jlblLastNameLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblLastNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    jlblLastNameLabel.setText("Last Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblLastNameLabel, gridBagConstraints);

    lbl_LastNameText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    lbl_LastNameText.setForeground(new java.awt.Color(0, 0, 0));
    lbl_LastNameText.setText("Last Name Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(lbl_LastNameText, gridBagConstraints);

    jlblFirstNameLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblFirstNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    jlblFirstNameLabel.setText("First Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblFirstNameLabel, gridBagConstraints);

    lbl_FirstNameText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    lbl_FirstNameText.setForeground(new java.awt.Color(0, 0, 0));
    lbl_FirstNameText.setText("First Name Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(lbl_FirstNameText, gridBagConstraints);

    jlblMiddleNameLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblMiddleNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    jlblMiddleNameLabel.setText("Middle Name : ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblMiddleNameLabel, gridBagConstraints);

    lbl_MiddleNameText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    lbl_MiddleNameText.setForeground(new java.awt.Color(0, 0, 0));
    lbl_MiddleNameText.setText("Middle Name Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(lbl_MiddleNameText, gridBagConstraints);

    lbl_RoleLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    lbl_RoleLabel.setForeground(new java.awt.Color(255, 255, 255));
    lbl_RoleLabel.setText("Role :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(lbl_RoleLabel, gridBagConstraints);

    jlblRoleText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblRoleText.setForeground(new java.awt.Color(0, 0, 0));
    jlblRoleText.setText("Role Text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblRoleText, gridBagConstraints);

    jlblTimeText.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblTimeText.setForeground(new java.awt.Color(0, 0, 0));
    jlblTimeText.setText("time text");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblTimeText, gridBagConstraints);

    jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Last login time :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jLabel4, gridBagConstraints);

    jSeparator1.setForeground(new java.awt.Color(0, 204, 204));
    jSeparator1.setPreferredSize(new java.awt.Dimension(0, 5));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jSeparator1, gridBagConstraints);

    jlblLogout.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
    jlblLogout.setForeground(new java.awt.Color(255, 255, 255));
    jlblLogout.setText("Log out");
    jlblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jlblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jlblLogoutMouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlAccountInformation.add(jlblLogout, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlUserInformation.add(jpnlAccountInformation, gridBagConstraints);

    jpnlHelloUser.setOpaque(false);
    jpnlHelloUser.setPreferredSize(new java.awt.Dimension(800, 12));
    jpnlHelloUser.setLayout(new java.awt.GridBagLayout());

    jPanel3.setOpaque(false);
    jPanel3.setLayout(new java.awt.GridBagLayout());

    jlblHelloUserNameText.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
    jlblHelloUserNameText.setForeground(new java.awt.Color(255, 255, 255));
    jlblHelloUserNameText.setText("username");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel3.add(jlblHelloUserNameText, gridBagConstraints);

    jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Hello");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel3.add(jLabel2, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlHelloUser.add(jPanel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlUserInformation.add(jpnlHelloUser, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    jpnlTopCard.add(jpnlUserInformation, gridBagConstraints);

    jPanel2.add(jpnlTopCard, java.awt.BorderLayout.CENTER);

    jpnlTopCardContainer.add(jPanel2, java.awt.BorderLayout.CENTER);

    jtpTopTabbedPane.addTab("", jpnlTopCardContainer);

    jpnlTopPanel.add(jtpTopTabbedPane, java.awt.BorderLayout.CENTER);

    jspTopMost.setViewportView(jpnlTopPanel);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    getContentPane().add(jspTopMost, gridBagConstraints);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    public class GUIManager {
        private void setGUIComponentProperties() {
            jlblDateToday.setText(CalendarUtil.getDateToday());
            jlblDayToday.setText(CalendarUtil.getDayToday());
            jtpTopTabbedPane.setIconAt(0, imageIconHome);
            jspTopMost.getVerticalScrollBar().setUnitIncrement(26);
            jspCardContainer.getVerticalScrollBar().setUnitIncrement(26);
        }
        private void prepareImageBackgrounds() {
            String registrationImgPath = hasRegistrationAccess == true
                    ? ("assets/registrationNoText.jpg") : ("assets/registrationlocked1.png");
            String enrollmentImgPath = hasEnrollmentAccess == true
                    ? ("assets/enrollmentNoText.jpg") : ("assets/enrollmentlocked1.png");
            String gradesImgPath = hasGradesAccess == true
                    ? ("assets/gradesNoText.jpg") : ("assets/gradeslocked1.png");
            String settingsImgPath = hasSettingsAccess == true
                    ? ("assets/managementNoText.jpg") : ("assets/settingslocked1.png");
            String accountsImgPath = hasAccountsAccess == true
                    ? ("assets/accountsNoText.jpg") : ("assets/accountslocked1.png");
            String paymentsImgPath = hasPaymentAccess == true
                    ? ("assets/paymentsNotext.jpg") : ("assets/paymentslocked1.png");

            ImageUtil imgUtil = new ImageUtil();

            imageHeader = imgUtil.getRenderedImageForJPanel("assets/headerNoText.jpg", jpnlHeader);
            imageSchoolLogo = imgUtil.getRenderedImageForJPanel("assets/LaunchPadBg.jpg", jpnlLaunchPad);
            imageReports = imgUtil.getRenderedImageForJPanel("assets/reportsNoText.jpg", jpnlReportsButton);
            imageRegistration = imgUtil.getRenderedImageForJPanel(registrationImgPath, jpnlRegistrationButton);
            imageEnrollment = imgUtil.getRenderedImageForJPanel(enrollmentImgPath, jpnlEnrollmentButton);
            imageGrades = imgUtil.getRenderedImageForJPanel(gradesImgPath, jpnlGradesButton);
            imageManagement = imgUtil.getRenderedImageForJPanel(settingsImgPath, jpnlManagementButton);
            imageAccounts = imgUtil.getRenderedImageForJPanel(accountsImgPath, jpnlAccountsButton);
            imagePayments = imgUtil.getRenderedImageForJPanel(paymentsImgPath, jpnlPaymentButton);
            imageCalendar = imgUtil.getRenderedImageForJPanel("assets/calendarNoText.jpg", jpnlCalendar);
            imageUser = imgUtil.getRenderedImageForJPanel("assets/usernameIcon.jpg", jpnlUserImage);
            imageIconHome = imgUtil.getResourceAsImageIcon("/assets/home.png", 20, 20);
        }
    }

    public static void flipCardToLaunchPad() {
        CardLayoutUtil.flipCardTo(cardContainer, jpnlLaunchPad);
    }

    private void jpnlRegistrationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlRegistrationButtonMouseClicked
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasRegistrationAccess) {
                if (REGISTRATION_INSTANCE <= 0) {
                    RegistrationForm registrationForm = new RegistrationForm();
                    jtpTopTabbedPane.addTab("Registration", registrationForm);
                    jtpTopTabbedPane.setSelectedComponent(registrationForm);
                    setREGISTRATION_INSTANCE(1);
                    REGISTRATION_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(REGISTRATION_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(REGISTRATION_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblRegistration.getText() + " Module.");
            }
        }
    }//GEN-LAST:event_jpnlRegistrationButtonMouseClicked

    private void jpnlEnrollmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlEnrollmentButtonMouseClicked
//        CardLayoutUtil.flipCardTo(jpnlTopCardContainer, new EnrollmentPanel());
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasEnrollmentAccess) {
                if (ENROLLMENT_INSTANCE <= 0) {
                    EnrollmentPanel enrollmentPanel = new EnrollmentPanel();
                    jtpTopTabbedPane.addTab("Enrollment", enrollmentPanel);
                    jtpTopTabbedPane.setSelectedComponent(enrollmentPanel);
                    setENROLLMENT_INSTANCE(1);
                    ENROLLMENT_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(ENROLLMENT_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(ENROLLMENT_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblEnrollment.getText() + " Module.");
            }
        }
    }//GEN-LAST:event_jpnlEnrollmentButtonMouseClicked

    private void jpnlGradesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlGradesButtonMouseClicked
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasGradesAccess) {
                if (GRADES_INSTANCE <= 0) {
                    GradesRecord gr = new GradesRecord();
                    jtpTopTabbedPane.add("Grades", gr);
                    jtpTopTabbedPane.setSelectedComponent(gr);
                    setGRADES_INSTANCE(1);
                    GRADES_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(GRADES_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(GRADES_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblGrades.getText() + " Module.");
            }

        }
    }//GEN-LAST:event_jpnlGradesButtonMouseClicked

    private void jpnlPaymentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlPaymentButtonMouseClicked
//        CardLayoutUtil.flipCardTo(jpnlTopCardContainer, new PaymentsPanel());
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasPaymentAccess) {
                if (PAYMENTS_INSTANCE <= 0) {
                    PaymentAndAssessmentForm paymentPanel = new PaymentAndAssessmentForm();
                    jtpTopTabbedPane.add("Payment", paymentPanel);
                    jtpTopTabbedPane.setSelectedComponent(paymentPanel);
                    setPAYMENTS_INSTANCE(1);
                    PAYMENTS_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(PAYMENTS_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(PAYMENTS_TAB_INDEX - 1);
                }

            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblPayment.getText() + " Module.");
            }

        }
    }//GEN-LAST:event_jpnlPaymentButtonMouseClicked

    private void jpnlManagementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlManagementButtonMouseClicked
//        CardLayoutUtil.flipCardTo(jpnlTopCardContainer, new SettingsPanel());

        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasSettingsAccess) {
                if (MANAGEMENT_INSTANCE <= 0) {
                    SettingsPanel settings = new SettingsPanel();
                    jtpTopTabbedPane.add("Settings", settings);
                    jtpTopTabbedPane.setSelectedComponent(settings);
                    setMANAGEMENT_INSTANCE(1);
                    MANAGEMENT_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(MANAGEMENT_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(MANAGEMENT_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblSettings.getText() + " Module.");
            }

        }
    }//GEN-LAST:event_jpnlManagementButtonMouseClicked

    private void jpnlAccountsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlAccountsButtonMouseClicked
//        CardLayoutUtil.flipCardTo(jpnlTopCardContainer, new AllUsersRecord());
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasAccountsAccess) {
                if (ACCOUNTS_INSTANCE <= 0) {
                    AllUsersRecord accountsPanel = new AllUsersRecord();
                    jtpTopTabbedPane.add("Accounts", accountsPanel);
                    jtpTopTabbedPane.setSelectedComponent(accountsPanel);
                    setACCOUNTS_INSTANCE(1);
                    ACCOUNTS_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(ACCOUNTS_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(ACCOUNTS_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblAccounts.getText() + " Module.");
            }
        }
    }//GEN-LAST:event_jpnlAccountsButtonMouseClicked

    private void jpnlReportsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlReportsButtonMouseClicked
//           CardLayoutUtil.flipCardTo(jpnlTopCardContainer, new AllUsersRecord());
        if (evt.getClickCount() >= 1) {
            initDashboardPermissions();
            if (hasReportsAccess) {
                if (ACCOUNTS_INSTANCE <= 0) {
                    Reports reports = new Reports();
                    jtpTopTabbedPane.add("Reports", reports);
                    jtpTopTabbedPane.setSelectedComponent(reports);
                    setREPORTS_INSTANCE(1);
                    REPORTS_TAB_INDEX = jtpTopTabbedPane.getTabCount();
                } else if (jtpTopTabbedPane.getTabCount() == 0) {
                    jtpTopTabbedPane.setSelectedIndex(REPORTS_TAB_INDEX - 1);
                } else {
                    jtpTopTabbedPane.setSelectedIndex(REPORTS_TAB_INDEX - 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You don't have privileges to access " + jlblReports.getText() + " Module.");
            }
        }
    }//GEN-LAST:event_jpnlReportsButtonMouseClicked

    private void jpnlPaymentButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpnlPaymentButtonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnlPaymentButtonKeyPressed

    private void jpnlRegistrationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlRegistrationButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlRegistrationButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlRegistrationButtonMouseEntered

    private void jpnlRegistrationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlRegistrationButtonMouseExited
        jpnlRegistrationButton.setBorder(null);
    }//GEN-LAST:event_jpnlRegistrationButtonMouseExited

    private void jpnlManagementButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlManagementButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlManagementButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlManagementButtonMouseEntered

    private void jpnlManagementButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlManagementButtonMouseExited
        jpnlManagementButton.setBorder(null);
    }//GEN-LAST:event_jpnlManagementButtonMouseExited

    private void jpnlEnrollmentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlEnrollmentButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlEnrollmentButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlEnrollmentButtonMouseEntered

    private void jpnlEnrollmentButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlEnrollmentButtonMouseExited
        jpnlEnrollmentButton.setBorder(null);
    }//GEN-LAST:event_jpnlEnrollmentButtonMouseExited

    private void jpnlAccountsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlAccountsButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlAccountsButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlAccountsButtonMouseEntered

    private void jpnlAccountsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlAccountsButtonMouseExited
        jpnlAccountsButton.setBorder(null);
    }//GEN-LAST:event_jpnlAccountsButtonMouseExited

    private void jpnlGradesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlGradesButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlGradesButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlGradesButtonMouseEntered

    private void jpnlGradesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlGradesButtonMouseExited
        jpnlGradesButton.setBorder(null);
    }//GEN-LAST:event_jpnlGradesButtonMouseExited

    private void jpnlPaymentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlPaymentButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlPaymentButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlPaymentButtonMouseEntered

    private void jpnlPaymentButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlPaymentButtonMouseExited
        jpnlPaymentButton.setBorder(null);
    }//GEN-LAST:event_jpnlPaymentButtonMouseExited

    private void jpnlReportsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlReportsButtonMouseEntered
        Border myBorder = new LineBorder(Color.YELLOW, 4);
        jpnlReportsButton.setBorder(myBorder);
    }//GEN-LAST:event_jpnlReportsButtonMouseEntered

    private void jpnlReportsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlReportsButtonMouseExited
        jpnlReportsButton.setBorder(null);
    }//GEN-LAST:event_jpnlReportsButtonMouseExited

    private void jtpTopTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpTopTabbedPaneMouseClicked
        if (evt.getClickCount() >= 1) {
            if (jtpTopTabbedPane.getSelectedIndex() == 0) {
                CardLayoutUtil.flipCardTo(jpnlTopCardContainer, jpnlTopCard);
            }
        }
    }//GEN-LAST:event_jtpTopTabbedPaneMouseClicked

    private void jlblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Exit Program?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_jlblLogoutMouseClicked

    private void jlblChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblChangePasswordMouseClicked
        EditAccount editAccountJDialog = new EditAccount(null, true, user);
        editAccountJDialog.setTitle("Edit Account");
        editAccountJDialog.setPreferredSize(new Dimension(370, 193));
        editAccountJDialog.pack();
        editAccountJDialog.setLocationRelativeTo(null);
        editAccountJDialog.setVisible(true);
    }//GEN-LAST:event_jlblChangePasswordMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarPanel;
    public static javax.swing.JPanel cardContainer;
    private javax.swing.JPanel iconsContainer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlblAccounts;
    private javax.swing.JLabel jlblAssessmentText;
    private javax.swing.JLabel jlblChangePassword;
    private javax.swing.JLabel jlblCurrentSchoolYear;
    private javax.swing.JLabel jlblDateToday;
    private javax.swing.JLabel jlblDayToday;
    private javax.swing.JLabel jlblEnrollment;
    private javax.swing.JLabel jlblFirstNameLabel;
    private javax.swing.JLabel jlblGrades;
    private javax.swing.JLabel jlblHelloUserNameText;
    private javax.swing.JLabel jlblLastLoginText;
    private javax.swing.JLabel jlblLastNameLabel;
    private javax.swing.JLabel jlblLogout;
    private javax.swing.JLabel jlblMiddleNameLabel;
    private javax.swing.JLabel jlblPayment;
    private javax.swing.JLabel jlblRegistration;
    private javax.swing.JLabel jlblReports;
    private javax.swing.JLabel jlblRoleText;
    private javax.swing.JLabel jlblSettings;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel jlblTimeText;
    private javax.swing.JLabel jlblUserIdLabel;
    private javax.swing.JLabel jlblUserIdText;
    private javax.swing.JPanel jpnlAccountInformation;
    private javax.swing.JPanel jpnlAccountsButton;
    private javax.swing.JPanel jpnlBody;
    private javax.swing.JPanel jpnlButtons;
    private javax.swing.JPanel jpnlCalendar;
    private javax.swing.JPanel jpnlEnrollmentButton;
    private javax.swing.JPanel jpnlGradesButton;
    private javax.swing.JPanel jpnlHeader;
    private javax.swing.JPanel jpnlHelloUser;
    public static javax.swing.JPanel jpnlLaunchPad;
    private javax.swing.JPanel jpnlManagementButton;
    private javax.swing.JPanel jpnlPaymentButton;
    private javax.swing.JPanel jpnlRegistrationButton;
    private javax.swing.JPanel jpnlReportsButton;
    private javax.swing.JPanel jpnlSchoolYear;
    public static javax.swing.JPanel jpnlTopCard;
    public static javax.swing.JPanel jpnlTopCardContainer;
    private javax.swing.JPanel jpnlTopPanel;
    private javax.swing.JPanel jpnlUserImage;
    private javax.swing.JPanel jpnlUserInformation;
    private javax.swing.JScrollPane jspCardContainer;
    private javax.swing.JScrollPane jspTopMost;
    public static javax.swing.JTabbedPane jtpTopTabbedPane;
    private javax.swing.JLabel lbl_FirstNameText;
    private javax.swing.JLabel lbl_LastNameText;
    private javax.swing.JLabel lbl_MiddleNameText;
    private javax.swing.JLabel lbl_RoleLabel;
    // End of variables declaration//GEN-END:variables
}
