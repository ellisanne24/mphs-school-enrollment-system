package view.section;

import component_model_loader.GradeLevelJCompModelLoader;
import component_model_loader.SectionJCompModelLoader;
import component_renderers.GradeLevelJComboBoxRenderer;
import controller.global.ExitJDialog;
import controller.section.CreateSection;
import controller.section.EditSection;
import daoimpl.SectionDaoImpl;
import model.section.Section;
import utility.initializer.Initializer;

public class DialogSectionCrud extends javax.swing.JDialog implements Initializer{

    private int sectionIdOfSelected;
    private String action;
    private SectionJCompModelLoader sectionJCompModelLoader;
    
    private GradeLevelJComboBoxRenderer gradeLevelJComboBoxRenderer;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;
    
    private SectionDaoImpl sectionDaoImpl;
    
    public DialogSectionCrud(java.awt.Frame parent, boolean modal, String action) {
        super(parent, modal);
        initComponents();
        
        this.action = action;
        
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
        initDaoImpl();
    }

    /**
     * Use this constructor during VIEW or EDIT operations.
     * This requires a sectionId of what was selected in record to be supplied.
     * @param parent
     * @param model
     * @param action
     * @param sectionIdOfSelected 
     */
    public DialogSectionCrud(java.awt.Frame parent, boolean model, String action, int sectionIdOfSelected){
        super(parent,model);
        initComponents();
        this.action = action;
        this.sectionIdOfSelected = sectionIdOfSelected;
        
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
        initDaoImpl();
        
        initForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        panel_subjectdetails = new javax.swing.JPanel();
        lbl_subcode = new javax.swing.JLabel();
        jtfSectionName = new javax.swing.JTextField();
        jlblRequiredAverage = new javax.swing.JLabel();
        lbl_subcode1 = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSession = new javax.swing.JLabel();
        jcmbSession = new javax.swing.JComboBox<>();
        jlblAverage = new javax.swing.JLabel();
        lbl_subcode3 = new javax.swing.JLabel();
        jcmbAdviser = new javax.swing.JComboBox<>();
        jlblStatus = new javax.swing.JLabel();
        jcmbStatus = new javax.swing.JComboBox<>();
        panel_footer = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnClear = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        jbtnSaveAndNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Section");
        setMinimumSize(new java.awt.Dimension(555, 260));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(555, 270));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(555, 270));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_subjectdetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Section Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_subjectdetails.setMinimumSize(new java.awt.Dimension(550, 150));
        panel_subjectdetails.setPreferredSize(new java.awt.Dimension(550, 150));
        panel_subjectdetails.setLayout(new java.awt.GridBagLayout());

        lbl_subcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_subcode.setText("Section Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panel_subjectdetails.add(lbl_subcode, gridBagConstraints);

        jtfSectionName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSectionName.setMinimumSize(new java.awt.Dimension(150, 25));
        jtfSectionName.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
        panel_subjectdetails.add(jtfSectionName, gridBagConstraints);

        jlblRequiredAverage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblRequiredAverage.setText("Required Average :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 10, 0);
        panel_subjectdetails.add(jlblRequiredAverage, gridBagConstraints);

        lbl_subcode1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_subcode1.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panel_subjectdetails.add(lbl_subcode1, gridBagConstraints);

        jcmbGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbGradeLevel.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbGradeLevel.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
        panel_subjectdetails.add(jcmbGradeLevel, gridBagConstraints);

        jlblSession.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSession.setText("Session :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        panel_subjectdetails.add(jlblSession, gridBagConstraints);

        jcmbSession.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jcmbSession.setSelectedIndex(-1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 0);
        panel_subjectdetails.add(jcmbSession, gridBagConstraints);

        jlblAverage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblAverage.setText("80.00");
        jlblAverage.setMaximumSize(new java.awt.Dimension(50, 17));
        jlblAverage.setMinimumSize(new java.awt.Dimension(50, 17));
        jlblAverage.setPreferredSize(new java.awt.Dimension(50, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 50);
        panel_subjectdetails.add(jlblAverage, gridBagConstraints);

        lbl_subcode3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_subcode3.setText("Adviser :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panel_subjectdetails.add(lbl_subcode3, gridBagConstraints);

        jcmbAdviser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbAdviser.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbAdviser.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_subjectdetails.add(jcmbAdviser, gridBagConstraints);

        jlblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblStatus.setText("Active :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panel_subjectdetails.add(jlblStatus, gridBagConstraints);

        jcmbStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_subjectdetails.add(jcmbStatus, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 3);
        panel_toppanel.add(panel_subjectdetails, gridBagConstraints);

        panel_footer.setMinimumSize(new java.awt.Dimension(550, 50));
        panel_footer.setPreferredSize(new java.awt.Dimension(550, 50));
        panel_footer.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.setMaximumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setMinimumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setPreferredSize(new java.awt.Dimension(69, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        panel_footer.add(jbtnCancel, gridBagConstraints);

        jbtnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClear.setText("Clear");
        jbtnClear.setMaximumSize(new java.awt.Dimension(60, 40));
        jbtnClear.setMinimumSize(new java.awt.Dimension(60, 40));
        jbtnClear.setPreferredSize(new java.awt.Dimension(60, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel_footer.add(jbtnClear, gridBagConstraints);

        jbtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setMaximumSize(new java.awt.Dimension(59, 40));
        jbtnSave.setMinimumSize(new java.awt.Dimension(59, 40));
        jbtnSave.setPreferredSize(new java.awt.Dimension(59, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        panel_footer.add(jbtnSave, gridBagConstraints);

        jbtnSaveAndNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveAndNew.setText("Save & New");
        jbtnSaveAndNew.setMaximumSize(new java.awt.Dimension(102, 40));
        jbtnSaveAndNew.setMinimumSize(new java.awt.Dimension(102, 40));
        jbtnSaveAndNew.setPreferredSize(new java.awt.Dimension(102, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        panel_footer.add(jbtnSaveAndNew, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 30, 0);
        panel_toppanel.add(panel_footer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(panel_toppanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void initRenderers() {
        gradeLevelJComboBoxRenderer = new GradeLevelJComboBoxRenderer();
    }
    
    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        sectionJCompModelLoader = new SectionJCompModelLoader();
        gradeLevelJCompModelLoader = new GradeLevelJCompModelLoader();
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        jcmbGradeLevel.setModel(gradeLevelJCompModelLoader.getAllGradeLevels());
        jcmbGradeLevel.setRenderer(gradeLevelJComboBoxRenderer);
        
        if (action.equalsIgnoreCase("create")) {
            jcmbStatus.setVisible(false);
            jlblStatus.setVisible(false);
        } else if (action.equalsIgnoreCase("edit")) {
            
        } else if (action.equalsIgnoreCase("view")) {
            jtfSectionName.setEnabled(false);
            jcmbGradeLevel.setEnabled(false);
            jcmbAdviser.setEnabled(false);
            jcmbSession.setEnabled(false);
            jcmbStatus.setEnabled(false);
        }
    }

    @Override
    public void initControllers() {
        jbtnCancel.addActionListener(new ExitJDialog(this));
        if (action.equalsIgnoreCase("create")) {
            jbtnSave.addActionListener(new CreateSection(this, jtfSectionName, jcmbGradeLevel, jcmbAdviser, jcmbSession));
        } else if (action.equalsIgnoreCase("edit")) {
            jbtnSave.addActionListener(new EditSection(sectionIdOfSelected, this, jtfSectionName, jcmbGradeLevel, jcmbAdviser, jcmbSession, jcmbStatus));
        }
    }

    @Override
    public void initDaoImpl() {
        sectionDaoImpl = new SectionDaoImpl();
    }
    
    private void initForm(){
        Section section = sectionDaoImpl.getSectionById(sectionIdOfSelected);
        jtfSectionName.setText(section.getSectionName());
        jcmbGradeLevel.setSelectedItem(section.getGradeLevel().getLevel());
        jcmbSession.setSelectedItem(section.getSectionSession());
        jcmbStatus.setSelectedItem(section.getIsActive()==true? "Yes":"No");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnSaveAndNew;
    private javax.swing.JComboBox<String> jcmbAdviser;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbSession;
    private javax.swing.JComboBox<String> jcmbStatus;
    private javax.swing.JLabel jlblAverage;
    private javax.swing.JLabel jlblRequiredAverage;
    private javax.swing.JLabel jlblSession;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JTextField jtfSectionName;
    private javax.swing.JLabel lbl_subcode;
    private javax.swing.JLabel lbl_subcode1;
    private javax.swing.JLabel lbl_subcode3;
    private javax.swing.JPanel panel_footer;
    private javax.swing.JPanel panel_subjectdetails;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
