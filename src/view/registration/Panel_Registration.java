package view.registration;

import component_model_loader.GradeLevelJCompModelLoader;
import component_renderers.GradeLevelJComboBoxRenderer;
import controller.registration.DisplayRegistrationRecordByAdmissionStatus;
import controller.registration.Register;
import controller.registration.UpdateRegistration;
import daoimpl.RegistrationDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Properties;
import model.registration.Registration;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import utility.date.DateLabelFormatter;
import utility.date.DateUtil;
import utility.initializer.Initializer;

public class Panel_Registration extends javax.swing.JPanel implements Initializer{

    private RegistrationDaoImpl registrationDaoImpl;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;
    private GradeLevelJComboBoxRenderer gradeLevelJComboBoxRenderer;
    
    private JDatePanelImpl dpnlBirthday;
    private JDatePickerImpl dpBirthday; 
    private DateLabelFormatter dateLabelFormatter;
    
    private String action;
    private int registrationIdOfSelected;
    
    public Panel_Registration(String action){
        initComponents();
        this.action = action;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
    }
    
    /**
     * Use this constructor when editing registration information of existing records
     * This constructor is also used when completing the admission of a registered applicant
     * @param user
     * @param registrationIdOfSelected 
     */
    public Panel_Registration(String action, int registrationIdOfSelected){
        initComponents();
        this.action = action;
        this.registrationIdOfSelected = registrationIdOfSelected;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
        
        initForm();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        gradeLevelJCompModelLoader = new GradeLevelJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        gradeLevelJComboBoxRenderer = new GradeLevelJComboBoxRenderer();
    }

    @Override
    public void initModels() {
    }

    private Properties getDateProperties() {
        Properties dateProperties = new Properties();
        dateProperties.put("text.today", "Today");
        dateProperties.put("text.month", "Month");
        dateProperties.put("text.year", "Year");
        return dateProperties;
    }
    
    private GridBagConstraints setPosition(int gridX, int gridY, double weightX, double weightY, int fillType, int anchorPos, Insets insets){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.weightx = weightX;
        gbc.weighty = weightY;
        gbc.fill = fillType;
        gbc.anchor = anchorPos;
        return gbc;
    }
    
    @Override
    public void initViewComponents() {
        if(action.equalsIgnoreCase("editregistration")){
            jbtnRegister.setVisible(false);
            jlblAdmissionStatus.setVisible(true);
            jcmbAdmissionStatus.setVisible(true);
            jbtnSaveEdit.setVisible(true);
        }else{
            jlblAdmissionStatus.setVisible(false);
            jcmbAdmissionStatus.setVisible(false);
            jbtnSaveEdit.setVisible(false);
        }
        
        dateLabelFormatter = new DateLabelFormatter();
        dpnlBirthday = new JDatePanelImpl(new UtilDateModel(), getDateProperties());
        dpBirthday = new JDatePickerImpl(dpnlBirthday, dateLabelFormatter);
        
        Insets i = new Insets(20,3,3,3);
        jpnlStudentInfo.add(dpBirthday,setPosition(5, 0, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, i));
        
        jlblCurrentSchoolYear.setText(""+SchoolYearDaoImpl.getCurrentSchoolYearFrom());
        jcmbGradeLevel.setModel(gradeLevelJCompModelLoader.getAllGradeLevels());
        jcmbGradeLevel.setRenderer(gradeLevelJComboBoxRenderer);
    }

    @Override
    public void initControllers() {
        jbtnRegister.addActionListener(new Register(
                dpBirthday, jbtnRegister, jcbFatherContactEmergency, jcmbGender,
                jcbGuardianContactEmergency, jcbMotherContactEmergency, jcbTransferee,
                jcmbGradeLevel, jp_reglabel, jp_statuscont, jpnlCredentials, jpnlGuardianInfo,
                jpnlHomeAddress, jpnlParentInfo, jpnlPhoto, jpnlPictureContainer, jpnlStudentInfo,
                jtfBrgySubd, jtfCity, jtfFatherFirstName, jtfFatherLastName, jtfFatherMiddleName,
                jtfFatherOccupation, jtfFatherOfficePhoneNo, jtfFatherMobile, jtfFirstName,
                jtfGuardianFirstName, jtfGuardianLastName, jtfGuardianMiddleName,
                jtfGuardianMobile, jtfGuardianOccupation, jtfGuardianRelationship,
                jtfLastName, jtfMiddleName, jtfMotherFirstName, jtfMotherLastName,
                jtfMotherMiddleName, jtfMotherOccupation, jtfMotherMobile,
                jtfNationality, jtfFatherOfficePhoneNo, jtfPlaceOfBirth,
                jtfRegion, jtfReligion, jtfRoomNo, jtfSchoolLastAttended,
                jtfSchoolLastAttendedAddress, jtfStreet)
        );
        
        jbtnSaveEdit.addActionListener(new UpdateRegistration(
                registrationIdOfSelected, dpBirthday, jbtnRegister, 
                jcbFatherContactEmergency, jcmbGender, jcbGuardianContactEmergency, 
                jcbMotherContactEmergency, jcbTransferee, jcmbGradeLevel, jp_reglabel, 
                jp_statuscont, jpnlCredentials, jpnlGuardianInfo, jpnlHomeAddress, 
                jpnlParentInfo, jpnlPhoto, jpnlPictureContainer, jpnlStudentInfo, 
                jtfBrgySubd, jtfCity, jtfFatherFirstName, jtfFatherLastName, 
                jtfFatherMiddleName, jtfFatherOccupation, jtfFatherOfficePhoneNo, 
                jtfFatherMobile, jtfFirstName, jtfGuardianFirstName, jtfGuardianLastName, 
                jtfGuardianMiddleName, jtfGuardianMobile, jtfGuardianOccupation, 
                jtfGuardianRelationship, jtfLastName, jtfMiddleName, jtfMotherFirstName, 
                jtfMotherLastName, jtfMotherMiddleName, jtfMotherOccupation, jtfMotherMobile, 
                jtfNationality, jtfFatherOfficePhoneNo, jtfPlaceOfBirth, jtfRegion, 
                jtfReligion, jtfRoomNo, jtfSchoolLastAttended, jtfSchoolLastAttendedAddress, 
                jtfStreet, jbtnRegister, jcmbAdmissionStatus)
        );
    }
    
    private void initForm(){
        Registration r = registrationDaoImpl.getRegistrationInfoById(registrationIdOfSelected);
        jcbTransferee.setSelected(r.getStudentType().equalsIgnoreCase("T")?true:false);
        jcmbAdmissionStatus.setSelectedItem(r.getIsAdmissionComplete() == true? "Complete" : "Pending");
        jcmbGradeLevel.setSelectedItem(r.getGradeLevelNo());
        jtfLastName.setText(r.getLastName());
        jtfFirstName.setText(r.getFirstName());
        jtfMiddleName.setText(r.getMiddleName());
        jcmbGender.setSelectedItem(r.getGender());
        jtfReligion.setText(r.getReligion());
        jtfNationality.setText(r.getNationality());
        dpBirthday.getJFormattedTextField().setText(""+r.getBirthday());
        jtfPlaceOfBirth.setText(r.getPlaceOfBirth());
        jtfRoomNo.setText(r.getAddressRoomOrHouseNo());
        jtfStreet.setText(r.getAddressStreet());
        jtfBrgySubd.setText(r.getAddressBrgyOrSubd());
        jtfCity.setText(r.getAddressCity());
        jtfRegion.setText(r.getRegion());
        jtfFatherLastName.setText(r.getFatherLastName());
        jtfFatherMiddleName.setText(r.getFatherMiddleName());
        jtfFatherFirstName.setText(r.getFatherFirstName());
        jtfFatherOccupation.setText(r.getFatherOccupation());
        jtfFatherOfficePhoneNo.setText(r.getFatherOfficePhoneNo());
        jtfFatherMobile.setText(r.getFatherMobileNo());
        jcbFatherContactEmergency.setSelected(r.getIsFatherContactInCaseEmergency());
        jtfMotherLastName.setText(r.getMotherLastName());
        jtfMotherMiddleName.setText(r.getMotherMiddleName());
        jtfMotherFirstName.setText(r.getMotherFirstName());
        jtfMotherOccupation.setText(r.getMotherOccupation());
        jtfMotherOfficePhoneNo.setText(r.getMotherOfficePhoneNo());
        jtfMotherMobile.setText(r.getMotherMobileNo());
        jcbMotherContactEmergency.setSelected(r.getIsMotherContactInCaseEmergency());
        jtfGuardianLastName.setText(r.getGuardianLastName());
        jtfGuardianMiddleName.setText(r.getGuardianMiddleName());
        jtfGuardianFirstName.setText(r.getGuardianFirstName());
        jtfGuardianOccupation.setText(r.getGuardianOccupation());
        jtfGuardianMobile.setText(r.getGuardianMobileNo());
        jcbGuardianContactEmergency.setSelected(r.getIsGuardianContactInCaseEmergency());
        jtfGuardianRelationship.setText(r.getGuardianRelationToStudent());
        jtfSchoolLastAttended.setText(r.getSchoolLastAttended());
        jtfSchoolLastAttendedAddress.setText(r.getSchoolLastAttendedAddress());
    }

    @Override
    public void initDaoImpl() {
        registrationDaoImpl = new RegistrationDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jp_reglabel = new javax.swing.JPanel();
        lbl_regname = new javax.swing.JLabel();
        lbl_sy = new javax.swing.JLabel();
        jlblCurrentSchoolYear = new javax.swing.JLabel();
        jp_statuscont = new javax.swing.JPanel();
        jcbTransferee = new javax.swing.JCheckBox();
        lbl_gradelevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblAdmissionStatus = new javax.swing.JLabel();
        jcmbAdmissionStatus = new javax.swing.JComboBox<>();
        panel3 = new javax.swing.JPanel();
        jpnlCredentials = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstCredentials = new javax.swing.JList<>();
        jpnlPhoto = new javax.swing.JPanel();
        jpnlPictureContainer = new javax.swing.JPanel();
        jbtnCamera = new javax.swing.JButton();
        jbtnUpload = new javax.swing.JButton();
        panel4 = new javax.swing.JPanel();
        jpnlStudentInfo = new javax.swing.JPanel();
        lbl_lname = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        lbl_middle = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        jcmbGender = new javax.swing.JComboBox<>();
        lbl_religion = new javax.swing.JLabel();
        tf_religion = new javax.swing.JTextField();
        lbl_nationality = new javax.swing.JLabel();
        lbl_dob = new javax.swing.JLabel();
        lbl_placeofbirth = new javax.swing.JLabel();
        tf_placeofbirth = new javax.swing.JTextField();
        lbl_lname1 = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jtfMiddleName = new javax.swing.JTextField();
        jtfReligion = new javax.swing.JTextField();
        jtfNationality = new javax.swing.JTextField();
        jtfPlaceOfBirth = new javax.swing.JTextField();
        jpnlHomeAddress = new javax.swing.JPanel();
        lbl_room = new javax.swing.JLabel();
        jtfRoomNo = new javax.swing.JTextField();
        lbl_street = new javax.swing.JLabel();
        jtfStreet = new javax.swing.JTextField();
        lbl_brgy = new javax.swing.JLabel();
        jtfBrgySubd = new javax.swing.JTextField();
        lbl_city = new javax.swing.JLabel();
        jtfCity = new javax.swing.JTextField();
        lbl_region = new javax.swing.JLabel();
        jtfRegion = new javax.swing.JTextField();
        jpnlParentInfo = new javax.swing.JPanel();
        lbl_father = new javax.swing.JLabel();
        jtfFatherLastName = new javax.swing.JTextField();
        lnl_fatherlname = new javax.swing.JLabel();
        jtfFatherFirstName = new javax.swing.JTextField();
        lbl_fatherfname = new javax.swing.JLabel();
        jtfFatherMiddleName = new javax.swing.JTextField();
        lbl_fathermiddle = new javax.swing.JLabel();
        lbl_fatheroccupation = new javax.swing.JLabel();
        jtfFatherOccupation = new javax.swing.JTextField();
        lbl_officenumber = new javax.swing.JLabel();
        jtfFatherOfficePhoneNo = new javax.swing.JTextField();
        jlblFatherMobile = new javax.swing.JLabel();
        jtfFatherMobile = new javax.swing.JTextField();
        lbl_mother = new javax.swing.JLabel();
        jtfMotherLastName = new javax.swing.JTextField();
        jtfMotherFirstName = new javax.swing.JTextField();
        jtfMotherMiddleName = new javax.swing.JTextField();
        lbl_motheroccupation = new javax.swing.JLabel();
        jtfMotherOccupation = new javax.swing.JTextField();
        lbl_motheroffice = new javax.swing.JLabel();
        jtfMotherOfficePhoneNo = new javax.swing.JTextField();
        lbl_mothermobile = new javax.swing.JLabel();
        jtfMotherMobile = new javax.swing.JTextField();
        lbl_motherfname = new javax.swing.JLabel();
        lbl_motherlname = new javax.swing.JLabel();
        lbl_mothermiddle = new javax.swing.JLabel();
        jcbFatherContactEmergency = new javax.swing.JCheckBox();
        jcbMotherContactEmergency = new javax.swing.JCheckBox();
        jpnlGuardianInfo = new javax.swing.JPanel();
        lbl_guardian = new javax.swing.JLabel();
        jtfGuardianLastName = new javax.swing.JTextField();
        jlbltGuardianLastName = new javax.swing.JLabel();
        jtfGuardianFirstName = new javax.swing.JTextField();
        jtfGuardianMiddleName = new javax.swing.JTextField();
        jlbltGuardianFirstName = new javax.swing.JLabel();
        jlblGuardianMiddleName = new javax.swing.JLabel();
        jlblGuardianRel = new javax.swing.JLabel();
        jtfGuardianRelationship = new javax.swing.JTextField();
        jcbGuardianContactEmergency = new javax.swing.JCheckBox();
        jlblGuardianOccup = new javax.swing.JLabel();
        jtfGuardianOccupation = new javax.swing.JTextField();
        jlblGuradianMobile = new javax.swing.JLabel();
        jtfGuardianMobile = new javax.swing.JTextField();
        jlblSchoolLastAttended = new javax.swing.JLabel();
        jtfSchoolLastAttended = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfSchoolLastAttendedAddress = new javax.swing.JTextField();
        panel_control = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnClear = new javax.swing.JButton();
        jbtnRegister = new javax.swing.JButton();
        jbtnSaveEdit = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1300, 700));
        setPreferredSize(new java.awt.Dimension(1300, 700));
        setLayout(new java.awt.GridBagLayout());

        jp_reglabel.setMinimumSize(new java.awt.Dimension(1300, 50));
        jp_reglabel.setLayout(new java.awt.GridBagLayout());

        lbl_regname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_regname.setText("Registration (New & Transferees)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jp_reglabel.add(lbl_regname, gridBagConstraints);

        lbl_sy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_sy.setText("SY: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jp_reglabel.add(lbl_sy, gridBagConstraints);

        jlblCurrentSchoolYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblCurrentSchoolYear.setText("Yeartext");
        jlblCurrentSchoolYear.setMaximumSize(new java.awt.Dimension(150, 29));
        jlblCurrentSchoolYear.setMinimumSize(new java.awt.Dimension(150, 29));
        jlblCurrentSchoolYear.setPreferredSize(new java.awt.Dimension(150, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jp_reglabel.add(jlblCurrentSchoolYear, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jp_reglabel, gridBagConstraints);

        jp_statuscont.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jp_statuscont.setMinimumSize(new java.awt.Dimension(1295, 40));
        jp_statuscont.setPreferredSize(new java.awt.Dimension(1295, 40));
        jp_statuscont.setLayout(new java.awt.GridBagLayout());

        jcbTransferee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbTransferee.setText("Transferee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jp_statuscont.add(jcbTransferee, gridBagConstraints);

        lbl_gradelevel.setBackground(new java.awt.Color(204, 204, 255));
        lbl_gradelevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gradelevel.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jp_statuscont.add(lbl_gradelevel, gridBagConstraints);

        jcmbGradeLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcmbGradeLevel.setMinimumSize(new java.awt.Dimension(100, 27));
        jcmbGradeLevel.setPreferredSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jp_statuscont.add(jcmbGradeLevel, gridBagConstraints);

        jlblAdmissionStatus.setText("Admission Status : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jp_statuscont.add(jlblAdmissionStatus, gridBagConstraints);

        jcmbAdmissionStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Complete" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jp_statuscont.add(jcmbAdmissionStatus, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jp_statuscont, gridBagConstraints);

        panel3.setMinimumSize(new java.awt.Dimension(1295, 600));
        panel3.setPreferredSize(new java.awt.Dimension(1295, 600));
        panel3.setLayout(new java.awt.GridBagLayout());

        jpnlCredentials.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credentials", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlCredentials.setMinimumSize(new java.awt.Dimension(180, 350));
        jpnlCredentials.setPreferredSize(new java.awt.Dimension(180, 350));
        jpnlCredentials.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(175, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(175, 400));

        jlstCredentials.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlstCredentials.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Birth Certificate", "Good Moral", "Form 132", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlstCredentials.setMinimumSize(new java.awt.Dimension(175, 340));
        jScrollPane1.setViewportView(jlstCredentials);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlCredentials.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel3.add(jpnlCredentials, gridBagConstraints);

        jpnlPhoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlPhoto.setMinimumSize(new java.awt.Dimension(180, 250));
        jpnlPhoto.setPreferredSize(new java.awt.Dimension(180, 250));
        jpnlPhoto.setLayout(new java.awt.GridBagLayout());

        jpnlPictureContainer.setBackground(new java.awt.Color(187, 187, 187));
        jpnlPictureContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlPictureContainer.setMinimumSize(new java.awt.Dimension(150, 150));
        jpnlPictureContainer.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout jpnlPictureContainerLayout = new javax.swing.GroupLayout(jpnlPictureContainer);
        jpnlPictureContainer.setLayout(jpnlPictureContainerLayout);
        jpnlPictureContainerLayout.setHorizontalGroup(
            jpnlPictureContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jpnlPictureContainerLayout.setVerticalGroup(
            jpnlPictureContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jpnlPhoto.add(jpnlPictureContainer, gridBagConstraints);

        jbtnCamera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCamera.setText("Camera");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jpnlPhoto.add(jbtnCamera, gridBagConstraints);

        jbtnUpload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnUpload.setText("Upload");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        jpnlPhoto.add(jbtnUpload, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel3.add(jpnlPhoto, gridBagConstraints);

        panel4.setMinimumSize(new java.awt.Dimension(1115, 600));
        panel4.setPreferredSize(new java.awt.Dimension(1115, 600));
        panel4.setLayout(new java.awt.GridBagLayout());

        jpnlStudentInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlStudentInfo.setMinimumSize(new java.awt.Dimension(1116, 200));
        jpnlStudentInfo.setPreferredSize(new java.awt.Dimension(1116, 200));
        jpnlStudentInfo.setLayout(new java.awt.GridBagLayout());

        lbl_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_lname.setText("Last Name :");
        lbl_lname.setAlignmentX(0.5F);
        lbl_lname.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_lname.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_lname.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_lname.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        jpnlStudentInfo.add(lbl_lname, gridBagConstraints);

        jtfLastName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfLastName.setBorder(null);
        jtfLastName.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfLastName.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfLastName.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        jpnlStudentInfo.add(jtfLastName, gridBagConstraints);

        lbl_middle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_middle.setText("Middle Name :");
        lbl_middle.setAlignmentX(0.5F);
        lbl_middle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_middle.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_middle.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_middle.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(lbl_middle, gridBagConstraints);

        lbl_gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gender.setText("Gender : ");
        lbl_gender.setAlignmentX(0.5F);
        lbl_gender.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_gender.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_gender.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_gender.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        jpnlStudentInfo.add(lbl_gender, gridBagConstraints);

        jcmbGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));
        jcmbGender.setBorder(null);
        jcmbGender.setMaximumSize(new java.awt.Dimension(160, 160));
        jcmbGender.setMinimumSize(new java.awt.Dimension(160, 20));
        jcmbGender.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        jpnlStudentInfo.add(jcmbGender, gridBagConstraints);

        lbl_religion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_religion.setText("Religion : ");
        lbl_religion.setAlignmentX(0.5F);
        lbl_religion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_religion.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_religion.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_religion.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(lbl_religion, gridBagConstraints);

        tf_religion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_religion.setToolTipText("");
        tf_religion.setBorder(null);
        tf_religion.setMaximumSize(new java.awt.Dimension(160, 160));
        tf_religion.setPreferredSize(new java.awt.Dimension(160, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 3;
        jpnlStudentInfo.add(tf_religion, gridBagConstraints);

        lbl_nationality.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_nationality.setText("Nationality : ");
        lbl_nationality.setAlignmentX(0.5F);
        lbl_nationality.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_nationality.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_nationality.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_nationality.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(lbl_nationality, gridBagConstraints);

        lbl_dob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_dob.setText("Date of Birth : ");
        lbl_dob.setAlignmentX(0.5F);
        lbl_dob.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_dob.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_dob.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_dob.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        jpnlStudentInfo.add(lbl_dob, gridBagConstraints);

        lbl_placeofbirth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_placeofbirth.setText("Place of Birth : ");
        lbl_placeofbirth.setAlignmentX(0.5F);
        lbl_placeofbirth.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_placeofbirth.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_placeofbirth.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_placeofbirth.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(lbl_placeofbirth, gridBagConstraints);

        tf_placeofbirth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_placeofbirth.setBorder(null);
        tf_placeofbirth.setMaximumSize(new java.awt.Dimension(160, 160));
        tf_placeofbirth.setPreferredSize(new java.awt.Dimension(160, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jpnlStudentInfo.add(tf_placeofbirth, gridBagConstraints);

        lbl_lname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_lname1.setText("First Name :");
        lbl_lname1.setAlignmentX(0.5F);
        lbl_lname1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_lname1.setMaximumSize(new java.awt.Dimension(160, 160));
        lbl_lname1.setMinimumSize(new java.awt.Dimension(160, 20));
        lbl_lname1.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(lbl_lname1, gridBagConstraints);

        jtfFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfFirstName.setBorder(null);
        jtfFirstName.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfFirstName.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfFirstName.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(jtfFirstName, gridBagConstraints);

        jtfMiddleName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfMiddleName.setBorder(null);
        jtfMiddleName.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfMiddleName.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfMiddleName.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(jtfMiddleName, gridBagConstraints);

        jtfReligion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfReligion.setBorder(null);
        jtfReligion.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfReligion.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfReligion.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(jtfReligion, gridBagConstraints);

        jtfNationality.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfNationality.setBorder(null);
        jtfNationality.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfNationality.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfNationality.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(jtfNationality, gridBagConstraints);

        jtfPlaceOfBirth.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPlaceOfBirth.setBorder(null);
        jtfPlaceOfBirth.setMaximumSize(new java.awt.Dimension(160, 160));
        jtfPlaceOfBirth.setMinimumSize(new java.awt.Dimension(160, 20));
        jtfPlaceOfBirth.setPreferredSize(new java.awt.Dimension(160, 160));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudentInfo.add(jtfPlaceOfBirth, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel4.add(jpnlStudentInfo, gridBagConstraints);

        jpnlHomeAddress.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Home Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlHomeAddress.setMinimumSize(new java.awt.Dimension(1116, 60));
        jpnlHomeAddress.setPreferredSize(new java.awt.Dimension(1116, 60));
        jpnlHomeAddress.setLayout(new java.awt.GridBagLayout());

        lbl_room.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_room.setText("Room/House No. : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(lbl_room, gridBagConstraints);

        jtfRoomNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfRoomNo.setBorder(null);
        jtfRoomNo.setMinimumSize(new java.awt.Dimension(130, 20));
        jtfRoomNo.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(jtfRoomNo, gridBagConstraints);

        lbl_street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_street.setText("Street : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(lbl_street, gridBagConstraints);

        jtfStreet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfStreet.setBorder(null);
        jtfStreet.setMinimumSize(new java.awt.Dimension(130, 20));
        jtfStreet.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(jtfStreet, gridBagConstraints);

        lbl_brgy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_brgy.setText("Brgy/Subd : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(lbl_brgy, gridBagConstraints);

        jtfBrgySubd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfBrgySubd.setBorder(null);
        jtfBrgySubd.setMinimumSize(new java.awt.Dimension(130, 20));
        jtfBrgySubd.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(jtfBrgySubd, gridBagConstraints);

        lbl_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_city.setText("City : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(lbl_city, gridBagConstraints);

        jtfCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfCity.setBorder(null);
        jtfCity.setMinimumSize(new java.awt.Dimension(130, 20));
        jtfCity.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(jtfCity, gridBagConstraints);

        lbl_region.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        lbl_region.setText("Region : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(lbl_region, gridBagConstraints);

        jtfRegion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfRegion.setBorder(null);
        jtfRegion.setMinimumSize(new java.awt.Dimension(130, 20));
        jtfRegion.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlHomeAddress.add(jtfRegion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel4.add(jpnlHomeAddress, gridBagConstraints);

        jpnlParentInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parents Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlParentInfo.setMinimumSize(new java.awt.Dimension(1116, 165));
        jpnlParentInfo.setPreferredSize(new java.awt.Dimension(1116, 165));
        jpnlParentInfo.setLayout(new java.awt.GridBagLayout());

        lbl_father.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_father.setText("Father : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jpnlParentInfo.add(lbl_father, gridBagConstraints);

        jtfFatherLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherLastName.setBorder(null);
        jtfFatherLastName.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherLastName.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfFatherLastName, gridBagConstraints);

        lnl_fatherlname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lnl_fatherlname.setText("Last Name");
        lnl_fatherlname.setMaximumSize(new java.awt.Dimension(60, 15));
        lnl_fatherlname.setMinimumSize(new java.awt.Dimension(60, 15));
        lnl_fatherlname.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jpnlParentInfo.add(lnl_fatherlname, gridBagConstraints);

        jtfFatherFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherFirstName.setBorder(null);
        jtfFatherFirstName.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherFirstName.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jpnlParentInfo.add(jtfFatherFirstName, gridBagConstraints);

        lbl_fatherfname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_fatherfname.setText("First Name");
        lbl_fatherfname.setMaximumSize(new java.awt.Dimension(60, 15));
        lbl_fatherfname.setMinimumSize(new java.awt.Dimension(60, 15));
        lbl_fatherfname.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jpnlParentInfo.add(lbl_fatherfname, gridBagConstraints);

        jtfFatherMiddleName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherMiddleName.setBorder(null);
        jtfFatherMiddleName.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherMiddleName.setPreferredSize(new java.awt.Dimension(110, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfFatherMiddleName, gridBagConstraints);

        lbl_fathermiddle.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_fathermiddle.setText("Middle Name");
        lbl_fathermiddle.setMaximumSize(new java.awt.Dimension(75, 15));
        lbl_fathermiddle.setMinimumSize(new java.awt.Dimension(75, 15));
        lbl_fathermiddle.setPreferredSize(new java.awt.Dimension(75, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jpnlParentInfo.add(lbl_fathermiddle, gridBagConstraints);

        lbl_fatheroccupation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_fatheroccupation.setText("Occupation : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jpnlParentInfo.add(lbl_fatheroccupation, gridBagConstraints);

        jtfFatherOccupation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherOccupation.setBorder(null);
        jtfFatherOccupation.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherOccupation.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfFatherOccupation, gridBagConstraints);

        lbl_officenumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_officenumber.setText("Office Phone : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jpnlParentInfo.add(lbl_officenumber, gridBagConstraints);

        jtfFatherOfficePhoneNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherOfficePhoneNo.setBorder(null);
        jtfFatherOfficePhoneNo.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherOfficePhoneNo.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        jpnlParentInfo.add(jtfFatherOfficePhoneNo, gridBagConstraints);

        jlblFatherMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblFatherMobile.setText("Mobile : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jpnlParentInfo.add(jlblFatherMobile, gridBagConstraints);

        jtfFatherMobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfFatherMobile.setBorder(null);
        jtfFatherMobile.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfFatherMobile.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        jpnlParentInfo.add(jtfFatherMobile, gridBagConstraints);

        lbl_mother.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_mother.setText("Mother : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jpnlParentInfo.add(lbl_mother, gridBagConstraints);

        jtfMotherLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherLastName.setBorder(null);
        jtfMotherLastName.setMinimumSize(new java.awt.Dimension(150, 15));
        jtfMotherLastName.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfMotherLastName, gridBagConstraints);

        jtfMotherFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherFirstName.setBorder(null);
        jtfMotherFirstName.setMinimumSize(new java.awt.Dimension(150, 15));
        jtfMotherFirstName.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jpnlParentInfo.add(jtfMotherFirstName, gridBagConstraints);

        jtfMotherMiddleName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherMiddleName.setBorder(null);
        jtfMotherMiddleName.setPreferredSize(new java.awt.Dimension(110, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfMotherMiddleName, gridBagConstraints);

        lbl_motheroccupation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_motheroccupation.setText("Occupation : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        jpnlParentInfo.add(lbl_motheroccupation, gridBagConstraints);

        jtfMotherOccupation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherOccupation.setBorder(null);
        jtfMotherOccupation.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jpnlParentInfo.add(jtfMotherOccupation, gridBagConstraints);

        lbl_motheroffice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_motheroffice.setText("Office Phone : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        jpnlParentInfo.add(lbl_motheroffice, gridBagConstraints);

        jtfMotherOfficePhoneNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherOfficePhoneNo.setBorder(null);
        jtfMotherOfficePhoneNo.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        jpnlParentInfo.add(jtfMotherOfficePhoneNo, gridBagConstraints);

        lbl_mothermobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_mothermobile.setText("Mobile : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jpnlParentInfo.add(lbl_mothermobile, gridBagConstraints);

        jtfMotherMobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfMotherMobile.setBorder(null);
        jtfMotherMobile.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        jpnlParentInfo.add(jtfMotherMobile, gridBagConstraints);

        lbl_motherfname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_motherfname.setText("First Name");
        lbl_motherfname.setMaximumSize(new java.awt.Dimension(60, 15));
        lbl_motherfname.setMinimumSize(new java.awt.Dimension(60, 15));
        lbl_motherfname.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jpnlParentInfo.add(lbl_motherfname, gridBagConstraints);

        lbl_motherlname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_motherlname.setText("Last Name");
        lbl_motherlname.setMaximumSize(new java.awt.Dimension(60, 15));
        lbl_motherlname.setMinimumSize(new java.awt.Dimension(60, 15));
        lbl_motherlname.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jpnlParentInfo.add(lbl_motherlname, gridBagConstraints);

        lbl_mothermiddle.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lbl_mothermiddle.setText("Middle Name");
        lbl_mothermiddle.setMaximumSize(new java.awt.Dimension(75, 15));
        lbl_mothermiddle.setMinimumSize(new java.awt.Dimension(75, 15));
        lbl_mothermiddle.setPreferredSize(new java.awt.Dimension(75, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        jpnlParentInfo.add(lbl_mothermiddle, gridBagConstraints);

        jcbFatherContactEmergency.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbFatherContactEmergency.setText("Contact in case of emergency.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnlParentInfo.add(jcbFatherContactEmergency, gridBagConstraints);

        jcbMotherContactEmergency.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbMotherContactEmergency.setText("Contact in case of emergency.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnlParentInfo.add(jcbMotherContactEmergency, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel4.add(jpnlParentInfo, gridBagConstraints);

        jpnlGuardianInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Guardian's Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jpnlGuardianInfo.setMinimumSize(new java.awt.Dimension(1116, 150));
        jpnlGuardianInfo.setPreferredSize(new java.awt.Dimension(1116, 150));
        jpnlGuardianInfo.setLayout(new java.awt.GridBagLayout());

        lbl_guardian.setBackground(new java.awt.Color(204, 204, 255));
        lbl_guardian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_guardian.setText("Guardian : ");
        lbl_guardian.setMinimumSize(new java.awt.Dimension(80, 20));
        lbl_guardian.setPreferredSize(new java.awt.Dimension(80, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(lbl_guardian, gridBagConstraints);

        jtfGuardianLastName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianLastName.setBorder(null);
        jtfGuardianLastName.setMinimumSize(new java.awt.Dimension(100, 20));
        jtfGuardianLastName.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianLastName, gridBagConstraints);

        jlbltGuardianLastName.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jlbltGuardianLastName.setText("Last Name");
        jlbltGuardianLastName.setMaximumSize(new java.awt.Dimension(60, 15));
        jlbltGuardianLastName.setMinimumSize(new java.awt.Dimension(60, 15));
        jlbltGuardianLastName.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jpnlGuardianInfo.add(jlbltGuardianLastName, gridBagConstraints);

        jtfGuardianFirstName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianFirstName.setBorder(null);
        jtfGuardianFirstName.setMinimumSize(new java.awt.Dimension(100, 20));
        jtfGuardianFirstName.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianFirstName, gridBagConstraints);

        jtfGuardianMiddleName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianMiddleName.setBorder(null);
        jtfGuardianMiddleName.setMinimumSize(new java.awt.Dimension(100, 20));
        jtfGuardianMiddleName.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianMiddleName, gridBagConstraints);

        jlbltGuardianFirstName.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jlbltGuardianFirstName.setText("First Name");
        jlbltGuardianFirstName.setMaximumSize(new java.awt.Dimension(60, 15));
        jlbltGuardianFirstName.setMinimumSize(new java.awt.Dimension(60, 15));
        jlbltGuardianFirstName.setPreferredSize(new java.awt.Dimension(60, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jpnlGuardianInfo.add(jlbltGuardianFirstName, gridBagConstraints);

        jlblGuardianMiddleName.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jlblGuardianMiddleName.setText("Middle Name");
        jlblGuardianMiddleName.setMaximumSize(new java.awt.Dimension(75, 15));
        jlblGuardianMiddleName.setMinimumSize(new java.awt.Dimension(75, 15));
        jlblGuardianMiddleName.setPreferredSize(new java.awt.Dimension(75, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jpnlGuardianInfo.add(jlblGuardianMiddleName, gridBagConstraints);

        jlblGuardianRel.setBackground(new java.awt.Color(204, 204, 255));
        jlblGuardianRel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblGuardianRel.setText("Relationship :  ");
        jlblGuardianRel.setMaximumSize(new java.awt.Dimension(90, 17));
        jlblGuardianRel.setMinimumSize(new java.awt.Dimension(90, 17));
        jlblGuardianRel.setPreferredSize(new java.awt.Dimension(90, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jlblGuardianRel, gridBagConstraints);

        jtfGuardianRelationship.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianRelationship.setBorder(null);
        jtfGuardianRelationship.setMinimumSize(new java.awt.Dimension(150, 20));
        jtfGuardianRelationship.setPreferredSize(new java.awt.Dimension(150, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianRelationship, gridBagConstraints);

        jcbGuardianContactEmergency.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbGuardianContactEmergency.setText("Contact in case of emergency.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jcbGuardianContactEmergency, gridBagConstraints);

        jlblGuardianOccup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblGuardianOccup.setText("Occupation : ");
        jlblGuardianOccup.setMinimumSize(new java.awt.Dimension(100, 20));
        jlblGuardianOccup.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jlblGuardianOccup, gridBagConstraints);

        jtfGuardianOccupation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianOccupation.setBorder(null);
        jtfGuardianOccupation.setMinimumSize(new java.awt.Dimension(100, 20));
        jtfGuardianOccupation.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianOccupation, gridBagConstraints);

        jlblGuradianMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblGuradianMobile.setText("Mobile : ");
        jlblGuradianMobile.setMinimumSize(new java.awt.Dimension(100, 20));
        jlblGuradianMobile.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jlblGuradianMobile, gridBagConstraints);

        jtfGuardianMobile.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtfGuardianMobile.setBorder(null);
        jtfGuardianMobile.setMinimumSize(new java.awt.Dimension(100, 20));
        jtfGuardianMobile.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfGuardianMobile, gridBagConstraints);

        jlblSchoolLastAttended.setText("School Last Attended");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jlblSchoolLastAttended, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfSchoolLastAttended, gridBagConstraints);

        jLabel1.setText("School Last Attended Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlGuardianInfo.add(jtfSchoolLastAttendedAddress, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel4.add(jpnlGuardianInfo, gridBagConstraints);

        panel_control.setMinimumSize(new java.awt.Dimension(1200, 80));
        panel_control.setPreferredSize(new java.awt.Dimension(1200, 80));
        panel_control.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.setMaximumSize(new java.awt.Dimension(75, 40));
        jbtnCancel.setMinimumSize(new java.awt.Dimension(75, 40));
        jbtnCancel.setPreferredSize(new java.awt.Dimension(75, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 750, 0, 0);
        panel_control.add(jbtnCancel, gridBagConstraints);

        jbtnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClear.setText("Clear");
        jbtnClear.setMaximumSize(new java.awt.Dimension(75, 40));
        jbtnClear.setMinimumSize(new java.awt.Dimension(75, 40));
        jbtnClear.setPreferredSize(new java.awt.Dimension(75, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panel_control.add(jbtnClear, gridBagConstraints);

        jbtnRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRegister.setText("Register");
        jbtnRegister.setMaximumSize(new java.awt.Dimension(100, 40));
        jbtnRegister.setMinimumSize(new java.awt.Dimension(100, 40));
        jbtnRegister.setPreferredSize(new java.awt.Dimension(100, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panel_control.add(jbtnRegister, gridBagConstraints);

        jbtnSaveEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveEdit.setText("Save Edit");
        jbtnSaveEdit.setMaximumSize(new java.awt.Dimension(100, 40));
        jbtnSaveEdit.setMinimumSize(new java.awt.Dimension(100, 40));
        jbtnSaveEdit.setPreferredSize(new java.awt.Dimension(100, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnSaveEdit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel4.add(panel_control, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel3.add(panel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(panel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCamera;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnRegister;
    private javax.swing.JButton jbtnSaveEdit;
    private javax.swing.JButton jbtnUpload;
    private javax.swing.JCheckBox jcbFatherContactEmergency;
    private javax.swing.JCheckBox jcbGuardianContactEmergency;
    private javax.swing.JCheckBox jcbMotherContactEmergency;
    private javax.swing.JCheckBox jcbTransferee;
    private javax.swing.JComboBox<String> jcmbAdmissionStatus;
    private javax.swing.JComboBox<String> jcmbGender;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JLabel jlblAdmissionStatus;
    private javax.swing.JLabel jlblCurrentSchoolYear;
    private javax.swing.JLabel jlblFatherMobile;
    private javax.swing.JLabel jlblGuardianMiddleName;
    private javax.swing.JLabel jlblGuardianOccup;
    private javax.swing.JLabel jlblGuardianRel;
    private javax.swing.JLabel jlblGuradianMobile;
    private javax.swing.JLabel jlblSchoolLastAttended;
    private javax.swing.JLabel jlbltGuardianFirstName;
    private javax.swing.JLabel jlbltGuardianLastName;
    private javax.swing.JList<String> jlstCredentials;
    private javax.swing.JPanel jp_reglabel;
    private javax.swing.JPanel jp_statuscont;
    private javax.swing.JPanel jpnlCredentials;
    private javax.swing.JPanel jpnlGuardianInfo;
    private javax.swing.JPanel jpnlHomeAddress;
    private javax.swing.JPanel jpnlParentInfo;
    private javax.swing.JPanel jpnlPhoto;
    private javax.swing.JPanel jpnlPictureContainer;
    private javax.swing.JPanel jpnlStudentInfo;
    private javax.swing.JTextField jtfBrgySubd;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfFatherFirstName;
    private javax.swing.JTextField jtfFatherLastName;
    private javax.swing.JTextField jtfFatherMiddleName;
    private javax.swing.JTextField jtfFatherMobile;
    private javax.swing.JTextField jtfFatherOccupation;
    private javax.swing.JTextField jtfFatherOfficePhoneNo;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfGuardianFirstName;
    private javax.swing.JTextField jtfGuardianLastName;
    private javax.swing.JTextField jtfGuardianMiddleName;
    private javax.swing.JTextField jtfGuardianMobile;
    private javax.swing.JTextField jtfGuardianOccupation;
    private javax.swing.JTextField jtfGuardianRelationship;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfMiddleName;
    private javax.swing.JTextField jtfMotherFirstName;
    private javax.swing.JTextField jtfMotherLastName;
    private javax.swing.JTextField jtfMotherMiddleName;
    private javax.swing.JTextField jtfMotherMobile;
    private javax.swing.JTextField jtfMotherOccupation;
    private javax.swing.JTextField jtfMotherOfficePhoneNo;
    private javax.swing.JTextField jtfNationality;
    private javax.swing.JTextField jtfPlaceOfBirth;
    private javax.swing.JTextField jtfRegion;
    private javax.swing.JTextField jtfReligion;
    private javax.swing.JTextField jtfRoomNo;
    private javax.swing.JTextField jtfSchoolLastAttended;
    private javax.swing.JTextField jtfSchoolLastAttendedAddress;
    private javax.swing.JTextField jtfStreet;
    private javax.swing.JLabel lbl_brgy;
    private javax.swing.JLabel lbl_city;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_father;
    private javax.swing.JLabel lbl_fatherfname;
    private javax.swing.JLabel lbl_fathermiddle;
    private javax.swing.JLabel lbl_fatheroccupation;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_gradelevel;
    private javax.swing.JLabel lbl_guardian;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_lname1;
    private javax.swing.JLabel lbl_middle;
    private javax.swing.JLabel lbl_mother;
    private javax.swing.JLabel lbl_motherfname;
    private javax.swing.JLabel lbl_motherlname;
    private javax.swing.JLabel lbl_mothermiddle;
    private javax.swing.JLabel lbl_mothermobile;
    private javax.swing.JLabel lbl_motheroccupation;
    private javax.swing.JLabel lbl_motheroffice;
    private javax.swing.JLabel lbl_nationality;
    private javax.swing.JLabel lbl_officenumber;
    private javax.swing.JLabel lbl_placeofbirth;
    private javax.swing.JLabel lbl_region;
    private javax.swing.JLabel lbl_regname;
    private javax.swing.JLabel lbl_religion;
    private javax.swing.JLabel lbl_room;
    private javax.swing.JLabel lbl_street;
    private javax.swing.JLabel lbl_sy;
    private javax.swing.JLabel lnl_fatherlname;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel_control;
    private javax.swing.JTextField tf_placeofbirth;
    private javax.swing.JTextField tf_religion;
    // End of variables declaration//GEN-END:variables
}