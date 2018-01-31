package view.student;

import controller.printer.PrintController;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import daoimpl.StudentDaoImpl;
import daoimpl.TuitionFeeDaoImpl;
import utility.component.ImageUtil;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.print.PrinterJob;
import javax.swing.table.JTableHeader;
import model.schoolyear.SchoolYear;
import model.student.Student;

public class JdlgStudentInfo extends javax.swing.JDialog {

    private final int studentId;
    private Image schoolLogo, studentPhoto;
    
    public JdlgStudentInfo(int studentId) {
        super(null, ModalityType.APPLICATION_MODAL);
        this.studentId = studentId;
        initComponents();
        initializeComponents();
        initializeControllers();
        initializeRenderers();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jpnlRegistration = new javax.swing.JPanel();
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
            jPanel1.repaint();
        }
    };
    jPanel10 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jpnlRegistrationNo = new javax.swing.JPanel();
    jlblRegistrationNo = new javax.swing.JLabel();
    jlblRegistrationIdText = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jpnlCertificateOfRegistration = new javax.swing.JPanel();
    jLabel4 = new javax.swing.JLabel();
    jPanel9 = new javax.swing.JPanel();
    jPanel12 = new javax.swing.JPanel();
    jlblSchoolYear = new javax.swing.JLabel();
    jlblSchoolYearText = new javax.swing.JLabel();
    jlblName = new javax.swing.JLabel();
    jlblNameText = new javax.swing.JLabel();
    jlblAddress = new javax.swing.JLabel();
    jlblAddressText = new javax.swing.JLabel();
    jlblStudentIdRegistrationform = new javax.swing.JLabel();
    jlblStudentIdRegistrationText = new javax.swing.JLabel();
    jlblStudentType = new javax.swing.JLabel();
    jlblGradeLevel = new javax.swing.JLabel();
    jlblGradeLevelText = new javax.swing.JLabel();
    jlblSection = new javax.swing.JLabel();
    jlblSectionText = new javax.swing.JLabel();
    jlblDate = new javax.swing.JLabel();
    jlblRegistrationDateText = new javax.swing.JLabel();
    jlblStudentTypeRegForm = new javax.swing.JLabel();
    jPanel13 = new javax.swing.JPanel();
    jPanel20 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jtblRegformSchedule = new javax.swing.JTable();
    jPanel5 = new javax.swing.JPanel();
    jpnlStudentFees = new javax.swing.JPanel();
    jpnlTuition = new javax.swing.JPanel();
    jlblTuitionHeader = new javax.swing.JLabel();
    jPanel15 = new javax.swing.JPanel();
    jLabel14 = new javax.swing.JLabel();
    jpnlMiscellaneous = new javax.swing.JPanel();
    jLabel15 = new javax.swing.JLabel();
    jPanel17 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtblMiscellaneous = new javax.swing.JTable();
    jpnlOthers = new javax.swing.JPanel();
    jLabel17 = new javax.swing.JLabel();
    jPanel19 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jtblOthers = new javax.swing.JTable();
    jpnlTotal = new javax.swing.JPanel();
    jLabel19 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jpnlStudentPhoto = new javax.swing.JPanel(){

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
    jPanel8 = new javax.swing.JPanel();
    jlblStudentId = new javax.swing.JLabel();
    jlblStudentIdText = new javax.swing.JLabel();
    jlblStatus = new javax.swing.JLabel();
    jlblStatusText = new javax.swing.JLabel();
    jlblLastName = new javax.swing.JLabel();
    jlblLastNameText = new javax.swing.JLabel();
    jlblFirstName = new javax.swing.JLabel();
    jlblFirstNameText = new javax.swing.JLabel();
    jlblMiddleName = new javax.swing.JLabel();
    jlblMiddleNameText = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jlblStudentTypeText = new javax.swing.JLabel();
    jPanel7 = new javax.swing.JPanel();
    jbtnCancelEnrollment = new javax.swing.JButton();
    jbtnPrintRegistrationForm = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Student Information");
    setMinimumSize(new java.awt.Dimension(800, 540));
    getContentPane().setLayout(new java.awt.GridBagLayout());

    jPanel1.setLayout(new java.awt.GridBagLayout());

    jPanel6.setLayout(new java.awt.GridBagLayout());

    jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTabbedPane1MouseClicked(evt);
        }
    });

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.setLayout(new java.awt.GridBagLayout());
    jTabbedPane1.addTab("Student", jPanel2);

    jpnlRegistration.setBackground(new java.awt.Color(255, 255, 255));
    jpnlRegistration.setForeground(new java.awt.Color(255, 255, 255));
    jpnlRegistration.setLayout(new java.awt.GridBagLayout());

    jpnlHeader.setBackground(new java.awt.Color(255, 255, 255));
    jpnlHeader.setForeground(new java.awt.Color(51, 51, 51));
    jpnlHeader.setLayout(new java.awt.GridBagLayout());

    jpnlLogo.setBackground(new java.awt.Color(255, 255, 255));
    jpnlLogo.setMinimumSize(new java.awt.Dimension(100, 100));
    jpnlLogo.setPreferredSize(new java.awt.Dimension(80, 80));
    jpnlLogo.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlHeader.add(jpnlLogo, gridBagConstraints);

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setMinimumSize(new java.awt.Dimension(418, 18));
    jPanel10.setPreferredSize(new java.awt.Dimension(420, 18));
    jPanel10.setLayout(new java.awt.GridBagLayout());

    jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 114, 188));
    jLabel5.setText("Mother of Perpetual Help School");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel10.add(jLabel5, gridBagConstraints);

    jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(51, 51, 51));
    jLabel7.setText("Iris Street Dahlia, West Fairview Quezon City");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel10.add(jLabel7, gridBagConstraints);

    jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(51, 51, 51));
    jLabel8.setText("1118 Metro Manila, Philippines");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel10.add(jLabel8, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlHeader.add(jPanel10, gridBagConstraints);

    jpnlRegistrationNo.setBackground(new java.awt.Color(255, 255, 255));
    jpnlRegistrationNo.setLayout(new java.awt.GridBagLayout());

    jlblRegistrationNo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jlblRegistrationNo.setForeground(new java.awt.Color(51, 51, 51));
    jlblRegistrationNo.setText("No.");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlRegistrationNo.add(jlblRegistrationNo, gridBagConstraints);

    jlblRegistrationIdText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jlblRegistrationIdText.setForeground(new java.awt.Color(51, 51, 51));
    jlblRegistrationIdText.setText("RegistrationNoText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlRegistrationNo.add(jlblRegistrationIdText, gridBagConstraints);

    jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(51, 51, 51));
    jLabel10.setText("Student's Copy");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlRegistrationNo.add(jLabel10, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
    jpnlHeader.add(jpnlRegistrationNo, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jpnlRegistration.add(jpnlHeader, gridBagConstraints);

    jpnlCertificateOfRegistration.setBackground(new java.awt.Color(255, 255, 255));
    jpnlCertificateOfRegistration.setLayout(new java.awt.GridBagLayout());

    jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 114, 188));
    jLabel4.setText("Certificate Of Registration");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlCertificateOfRegistration.add(jLabel4, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jpnlRegistration.add(jpnlCertificateOfRegistration, gridBagConstraints);

    jPanel9.setBackground(new java.awt.Color(255, 255, 255));
    jPanel9.setLayout(new java.awt.GridBagLayout());

    jPanel12.setBackground(new java.awt.Color(255, 255, 255));
    jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel12.setLayout(new java.awt.GridBagLayout());

    jlblSchoolYear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblSchoolYear.setForeground(new java.awt.Color(51, 51, 51));
    jlblSchoolYear.setText("School Year");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblSchoolYear, gridBagConstraints);

    jlblSchoolYearText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblSchoolYearText.setForeground(new java.awt.Color(51, 51, 51));
    jlblSchoolYearText.setText("SchoolYearText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblSchoolYearText, gridBagConstraints);

    jlblName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblName.setForeground(new java.awt.Color(51, 51, 51));
    jlblName.setText("Name :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblName, gridBagConstraints);

    jlblNameText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblNameText.setForeground(new java.awt.Color(51, 51, 51));
    jlblNameText.setText("NameText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblNameText, gridBagConstraints);

    jlblAddress.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblAddress.setForeground(new java.awt.Color(51, 51, 51));
    jlblAddress.setText("Address :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblAddress, gridBagConstraints);

    jlblAddressText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblAddressText.setForeground(new java.awt.Color(51, 51, 51));
    jlblAddressText.setText("AddressText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 9;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblAddressText, gridBagConstraints);

    jlblStudentIdRegistrationform.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblStudentIdRegistrationform.setForeground(new java.awt.Color(51, 51, 51));
    jlblStudentIdRegistrationform.setText("Student ID :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblStudentIdRegistrationform, gridBagConstraints);

    jlblStudentIdRegistrationText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblStudentIdRegistrationText.setForeground(new java.awt.Color(51, 51, 51));
    jlblStudentIdRegistrationText.setText("StudentIdText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblStudentIdRegistrationText, gridBagConstraints);

    jlblStudentType.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblStudentType.setForeground(new java.awt.Color(51, 51, 51));
    jlblStudentType.setText("Type :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblStudentType, gridBagConstraints);

    jlblGradeLevel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblGradeLevel.setForeground(new java.awt.Color(51, 51, 51));
    jlblGradeLevel.setText("Grade :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblGradeLevel, gridBagConstraints);

    jlblGradeLevelText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblGradeLevelText.setForeground(new java.awt.Color(51, 51, 51));
    jlblGradeLevelText.setText("GradeText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblGradeLevelText, gridBagConstraints);

    jlblSection.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblSection.setForeground(new java.awt.Color(51, 51, 51));
    jlblSection.setText("Section :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblSection, gridBagConstraints);

    jlblSectionText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblSectionText.setForeground(new java.awt.Color(51, 51, 51));
    jlblSectionText.setText("SectionText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblSectionText, gridBagConstraints);

    jlblDate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblDate.setForeground(new java.awt.Color(51, 51, 51));
    jlblDate.setText("Date :");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblDate, gridBagConstraints);

    jlblRegistrationDateText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblRegistrationDateText.setForeground(new java.awt.Color(51, 51, 51));
    jlblRegistrationDateText.setText("DateText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 7;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblRegistrationDateText, gridBagConstraints);

    jlblStudentTypeRegForm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jlblStudentTypeRegForm.setForeground(new java.awt.Color(51, 51, 51));
    jlblStudentTypeRegForm.setText("TypeText");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel12.add(jlblStudentTypeRegForm, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jPanel9.add(jPanel12, gridBagConstraints);

    jPanel13.setBackground(new java.awt.Color(255, 255, 255));
    jPanel13.setLayout(new java.awt.GridBagLayout());

    jPanel20.setBackground(new java.awt.Color(255, 255, 255));
    jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel20.setForeground(new java.awt.Color(51, 51, 51));
    jPanel20.setPreferredSize(new java.awt.Dimension(455, 300));
    jPanel20.setLayout(new java.awt.GridBagLayout());

    jScrollPane2.setBorder(null);
    jScrollPane2.setPreferredSize(new java.awt.Dimension(453, 250));

    jtblRegformSchedule.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Day", "Subject ", "Time", "Room"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane2.setViewportView(jtblRegformSchedule);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel20.add(jScrollPane2, gridBagConstraints);

    jPanel5.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPanel20.add(jPanel5, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel13.add(jPanel20, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel9.add(jPanel13, gridBagConstraints);

    jpnlStudentFees.setBackground(new java.awt.Color(255, 255, 255));
    jpnlStudentFees.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 114, 188)));
    jpnlStudentFees.setMinimumSize(new java.awt.Dimension(215, 215));
    jpnlStudentFees.setPreferredSize(new java.awt.Dimension(215, 400));
    jpnlStudentFees.setLayout(new java.awt.GridBagLayout());

    jpnlTuition.setBackground(new java.awt.Color(255, 255, 255));
    jpnlTuition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlTuition.setForeground(new java.awt.Color(51, 51, 51));
    jpnlTuition.setLayout(new java.awt.GridBagLayout());

    jlblTuitionHeader.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
    jlblTuitionHeader.setForeground(new java.awt.Color(51, 51, 51));
    jlblTuitionHeader.setText("Tuition");
    jpnlTuition.add(jlblTuitionHeader, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.5;
    jpnlStudentFees.add(jpnlTuition, gridBagConstraints);

    jPanel15.setBackground(new java.awt.Color(255, 255, 255));
    jPanel15.setForeground(new java.awt.Color(51, 51, 51));
    jPanel15.setLayout(new java.awt.GridBagLayout());

    jLabel14.setForeground(new java.awt.Color(51, 51, 51));
    jLabel14.setText("jLabel14");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jPanel15.add(jLabel14, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlStudentFees.add(jPanel15, gridBagConstraints);

    jpnlMiscellaneous.setBackground(new java.awt.Color(255, 255, 255));
    jpnlMiscellaneous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlMiscellaneous.setForeground(new java.awt.Color(51, 51, 51));
    jpnlMiscellaneous.setLayout(new java.awt.GridBagLayout());

    jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(51, 51, 51));
    jLabel15.setText(" Miscellaneous");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlMiscellaneous.add(jLabel15, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlStudentFees.add(jpnlMiscellaneous, gridBagConstraints);

    jPanel17.setBackground(new java.awt.Color(255, 255, 255));
    jPanel17.setForeground(new java.awt.Color(51, 51, 51));
    jPanel17.setPreferredSize(new java.awt.Dimension(453, 0));
    jPanel17.setLayout(new java.awt.GridBagLayout());

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    jtblMiscellaneous.setAutoCreateRowSorter(true);
    jtblMiscellaneous.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
    jtblMiscellaneous.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Description", "Amount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jtblMiscellaneous.setMinimumSize(new java.awt.Dimension(150, 64));
    jtblMiscellaneous.setPreferredSize(new java.awt.Dimension(150, 200));
    jScrollPane1.setViewportView(jtblMiscellaneous);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel17.add(jScrollPane1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlStudentFees.add(jPanel17, gridBagConstraints);

    jpnlOthers.setBackground(new java.awt.Color(255, 255, 255));
    jpnlOthers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlOthers.setForeground(new java.awt.Color(51, 51, 51));
    jpnlOthers.setLayout(new java.awt.GridBagLayout());

    jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(51, 51, 51));
    jLabel17.setText("Others");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    jpnlOthers.add(jLabel17, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlStudentFees.add(jpnlOthers, gridBagConstraints);

    jPanel19.setBackground(new java.awt.Color(255, 255, 255));
    jPanel19.setForeground(new java.awt.Color(51, 51, 51));
    jPanel19.setMinimumSize(new java.awt.Dimension(20, 100));
    jPanel19.setLayout(new java.awt.GridBagLayout());

    jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane3.setPreferredSize(new java.awt.Dimension(453, 300));

    jtblOthers.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
    jtblOthers.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Description", "Amount"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane3.setViewportView(jtblOthers);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jPanel19.add(jScrollPane3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlStudentFees.add(jPanel19, gridBagConstraints);

    jpnlTotal.setBackground(new java.awt.Color(255, 255, 255));
    jpnlTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlTotal.setForeground(new java.awt.Color(51, 51, 51));
    jpnlTotal.setLayout(new java.awt.GridBagLayout());

    jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(51, 51, 51));
    jLabel19.setText("Total");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTotal.add(jLabel19, gridBagConstraints);

    jLabel1.setText("jLabel1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jpnlTotal.add(jLabel1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jpnlStudentFees.add(jpnlTotal, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    jPanel9.add(jpnlStudentFees, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    jpnlRegistration.add(jPanel9, gridBagConstraints);

    jTabbedPane1.addTab("Certificate Of Registration", jpnlRegistration);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel6.add(jTabbedPane1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel1.add(jPanel6, gridBagConstraints);

    jPanel3.setLayout(new java.awt.GridBagLayout());

    jpnlStudentPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jpnlStudentPhoto.setMaximumSize(new java.awt.Dimension(200, 200));
    jpnlStudentPhoto.setMinimumSize(new java.awt.Dimension(200, 200));
    jpnlStudentPhoto.setPreferredSize(new java.awt.Dimension(200, 200));
    jpnlStudentPhoto.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel3.add(jpnlStudentPhoto, gridBagConstraints);

    jPanel8.setLayout(new java.awt.GridBagLayout());

    jlblStudentId.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblStudentId, gridBagConstraints);

    jlblStudentIdText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblStudentIdText, gridBagConstraints);

    jlblStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblStatus, gridBagConstraints);

    jlblStatusText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblStatusText, gridBagConstraints);

    jlblLastName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblLastName, gridBagConstraints);

    jlblLastNameText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblLastNameText, gridBagConstraints);

    jlblFirstName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblFirstName, gridBagConstraints);

    jlblFirstNameText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblFirstNameText, gridBagConstraints);

    jlblMiddleName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblMiddleName, gridBagConstraints);

    jlblMiddleNameText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblMiddleNameText, gridBagConstraints);

    jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jLabel2, gridBagConstraints);

    jlblStudentTypeText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel8.add(jlblStudentTypeText, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel3.add(jPanel8, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel1.add(jPanel3, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.weighty = 0.5;
    getContentPane().add(jPanel1, gridBagConstraints);

    jPanel7.setLayout(new java.awt.GridBagLayout());

    jbtnCancelEnrollment.setText("Cancel");
    jbtnCancelEnrollment.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbtnCancelEnrollmentActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    jPanel7.add(jbtnCancelEnrollment, gridBagConstraints);

    jbtnPrintRegistrationForm.setText("Print");
    jbtnPrintRegistrationForm.setEnabled(false);
    jbtnPrintRegistrationForm.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbtnPrintRegistrationFormActionPerformed(evt);
        }
    });
    jPanel7.add(jbtnPrintRegistrationForm, new java.awt.GridBagConstraints());

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    getContentPane().add(jPanel7, gridBagConstraints);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeComponents(){
        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        
        ImageUtil imageUtil = new ImageUtil();
        schoolLogo = imageUtil.getRenderedImageForJPanel("assets/logo.jpg", jpnlLogo);
        studentPhoto = imageUtil.getRenderedImageForJPanel("assets/usernameIcon.jpg", jpnlStudentPhoto);
        
        JTableHeader jtblHeader = jtblRegformSchedule.getTableHeader();
        jtblHeader.setBackground(Color.WHITE);
        jtblHeader.setForeground(Color.BLACK);
        jtblRegformSchedule.setShowGrid(false);
        jtblRegformSchedule.setShowHorizontalLines(false);
        jtblRegformSchedule.setShowVerticalLines(false);
        jtblMiscellaneous.setShowGrid(false);
        jtblMiscellaneous.setShowHorizontalLines(false);
        jtblMiscellaneous.setShowVerticalLines(false);
        
        setStudentInfo();
        setSchoolFeesModel();
    }
    
    private void setSchoolFeesModel(){
//        MiscellaneousFees m = sfdi.getMiscellaneous(studentId);
//        SchoolFees sf = getSchoolFees();
//        DefaultTableModel model = (DefaultTableModel)jtblMiscellaneous.getModel();
//        List<Fee> feeList = sf.getMiscellaneousFees().getFees();
//        model.setRowCount(0);
//        for(Fee f : feeList){
//            model.addRow(new Object[]{f.getName(),f.getAmount()});
//        }
//        jtblMiscellaneous.setModel(model);
//        System.out.println("SchoolFees Size :"+sf.getMiscellaneousFees().getFees().size());
//        
//        jLabel14.setText(sf.getBasicFee().getAmount()+"");
//        
//        DefaultTableModel otherModel = (DefaultTableModel) jtblOthers.getModel();
//        otherModel.setRowCount(0);
//        for(Fee f : feeList){
//            otherModel.addRow(new Object[]{f.getName(),f.getAmount()});
//        }
//        jtblOthers.setModel(otherModel);
//        jLabel1.setText(sf.getSum()+"");
//        
//        SectionDaoImpl secDaoImpl = new SectionDaoImpl();
////        int sectionId = secDaoImpl.getSectionIdByName(secDaoImpl.getSectionByStudentId(studentId).getSectionName());
////        ScheduleDaoImpl schedDaoImpl = new ScheduleDaoImpl();
////        List<Schedule> schedList = schedDaoImpl.getBySectionId(sectionId);
////        DefaultTableModel schedModel = (DefaultTableModel)jtblRegformSchedule.getModel();
////        schedModel.setRowCount(0);
////        for(Schedule s : schedList){
////            schedModel.addRow(new Object[]{s.getDay(),s.getSubjectCode(),s.getStartTime()+"-"+s.getEndTime(),s.getRoomName()});
////        }
////        jtblRegformSchedule.setModel(schedModel);
    }
    
    private void setStudentInfo() {
        StudentDaoImpl sdi = new StudentDaoImpl();
        SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
        SectionDaoImpl sedi = new SectionDaoImpl();
        TuitionFeeDaoImpl tfdi = new TuitionFeeDaoImpl();
        
        
        
        Student s = sdi.getStudentByStudentNo(studentId);
//        jlblStudentIdRegistrationText.setText(s.getStudentId() != null ? s.getStudentId() + "" : "");
        jlblStudentTypeRegForm.setText(s.getStudentType() == 0 ? "Old" : "New");
        jlblNameText.setText(
                s.getRegistration().getLastName() + ", "
                + s.getRegistration().getFirstName() + " "
                + s.getRegistration().getMiddleName());
        jlblAddressText.setText(
                s.getRegistration().getAddressRoomOrHouseNo()==null?"":s.getRegistration().getAddressRoomOrHouseNo()
                + " " + s.getRegistration().getAddressStreet()==null? "":s.getRegistration().getAddressStreet() + " "
                + s.getRegistration().getAddressBrgyOrSubd()== null? "":s.getRegistration().getAddressBrgyOrSubd()
                        + " "
                + s.getRegistration().getAddressCity());
        SchoolYear schoolYear = sydi.getSchoolYearById(sydi.getCurrentSchoolYearId());
        jlblSchoolYearText.setText(schoolYear.getYearFrom() + "");
        jlblRegistrationDateText.setText(s.getAdmission().getCompletionDate()+"");
        jlblRegistrationIdText.setText(s.getRegistration().getRegistrationId()+"");
//        jlblSectionText.setText(sedi.getSectionByStudentId(studentId).getSectionName());
        
        
        
    }
    
//    private SchoolFees getSchoolFees() {
//        int gradelevelId;
//        SchoolFeesDaoImpl sfdi = new SchoolFeesDaoImpl();
//        StudentDaoImpl sdi = new StudentDaoImpl();
//        Student s = sdi.getStudentById(studentId);
//        SchoolFees schoolFees;
//        EnrollmentDaoImpl edi = new EnrollmentDaoImpl();
//        boolean hasEnrollmentRecord = edi.hasEnrollmentRecord(s.getStudentId());
//
//        if (hasEnrollmentRecord) {
//            gradelevelId = sdi.getCurrentGradeLevelId(s.getStudentId());
//        } else {
//            gradelevelId = s.getRegistration().getGradeLevelNo();
//        }
//
//        schoolFees = sfdi.get(gradelevelId);
//        return schoolFees;
//    }
    
    private void initializeControllers(){
        jbtnPrintRegistrationForm.addActionListener(new PrintController(jpnlRegistration));
    }
    
    private void initializeRenderers(){
        
    }
    
    private void initializeDaoImpl(){
        
    }

    private void jbtnCancelEnrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelEnrollmentActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Exit?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_jbtnCancelEnrollmentActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if(jTabbedPane1.getSelectedIndex()==1){
            jbtnPrintRegistrationForm.setEnabled(true);
        }else{
            jbtnPrintRegistrationForm.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jbtnPrintRegistrationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintRegistrationFormActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.printDialog();
    }//GEN-LAST:event_jbtnPrintRegistrationFormActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnCancelEnrollment;
    private javax.swing.JButton jbtnPrintRegistrationForm;
    private javax.swing.JLabel jlblAddress;
    private javax.swing.JLabel jlblAddressText;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblFirstName;
    private javax.swing.JLabel jlblFirstNameText;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblGradeLevelText;
    private javax.swing.JLabel jlblLastName;
    private javax.swing.JLabel jlblLastNameText;
    private javax.swing.JLabel jlblMiddleName;
    private javax.swing.JLabel jlblMiddleNameText;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblNameText;
    private javax.swing.JLabel jlblRegistrationDateText;
    private javax.swing.JLabel jlblRegistrationIdText;
    private javax.swing.JLabel jlblRegistrationNo;
    private javax.swing.JLabel jlblSchoolYear;
    private javax.swing.JLabel jlblSchoolYearText;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JLabel jlblSectionText;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel jlblStatusText;
    private javax.swing.JLabel jlblStudentId;
    private javax.swing.JLabel jlblStudentIdRegistrationText;
    private javax.swing.JLabel jlblStudentIdRegistrationform;
    private javax.swing.JLabel jlblStudentIdText;
    private javax.swing.JLabel jlblStudentType;
    private javax.swing.JLabel jlblStudentTypeRegForm;
    private javax.swing.JLabel jlblStudentTypeText;
    private javax.swing.JLabel jlblTuitionHeader;
    private javax.swing.JPanel jpnlCertificateOfRegistration;
    private javax.swing.JPanel jpnlHeader;
    private javax.swing.JPanel jpnlLogo;
    private javax.swing.JPanel jpnlMiscellaneous;
    private javax.swing.JPanel jpnlOthers;
    private javax.swing.JPanel jpnlRegistration;
    private javax.swing.JPanel jpnlRegistrationNo;
    private javax.swing.JPanel jpnlStudentFees;
    private javax.swing.JPanel jpnlStudentPhoto;
    private javax.swing.JPanel jpnlTotal;
    private javax.swing.JPanel jpnlTuition;
    private javax.swing.JTable jtblMiscellaneous;
    private javax.swing.JTable jtblOthers;
    private javax.swing.JTable jtblRegformSchedule;
    // End of variables declaration//GEN-END:variables
}
