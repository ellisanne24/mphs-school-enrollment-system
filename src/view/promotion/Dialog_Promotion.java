package view.promotion;

import component_model_loader.SectionJCompModelLoader;
import component_renderers.Renderer_Promotion_Students_JTable;
import component_renderers.Renderer_Section_JComboBox;
import controller.global.Controller_JTextField_ClearDefaultSearchText;
import controller.promotion.Controller_ItemListener_Section_JComboBox;
import controller.promotion.Controller_Promotion_Students_JTable_TableModel;
import daoimpl.FacultyDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.faculty.Faculty;
import model.schoolyear.SchoolYear;
import model.user.User;
import utility.initializer.Initializer;
import utility.jtable.JTableUtil;


public class Dialog_Promotion extends javax.swing.JDialog implements Initializer{

    private SectionJCompModelLoader sectionJCompModelLoader;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private FacultyDaoImpl facultyDaoImpl;
    private User user;
    
    public Dialog_Promotion(java.awt.Frame parent, boolean modal, User user) {
        super(parent, modal);
        initComponents();
        
        this.user = user;
        
        initDaoImpl();
        initJCompModelLoaders();
        initRenderers();
        initControllers();
        initViewComponents();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
        sectionJCompModelLoader = new SectionJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        jcmbSections.setRenderer(new Renderer_Section_JComboBox());
        jtblStudents.setDefaultRenderer(Object.class, new Renderer_Promotion_Students_JTable());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        JTableUtil.applyCustomHeaderRenderer(jtblStudents);
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        Faculty faculty = facultyDaoImpl.getFacultyByUser(user);
        jcmbSections.setModel(sectionJCompModelLoader.getAdvisorySectionsOfFaculty(faculty, schoolYear));
    }

    @Override
    public void initControllers() {
        jtblStudents.getModel().addTableModelListener(new Controller_Promotion_Students_JTable_TableModel());
        jtfSearchBox.addMouseListener(new Controller_JTextField_ClearDefaultSearchText());
        jcmbSections.addItemListener(new Controller_ItemListener_Section_JComboBox(this));
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        facultyDaoImpl = new FacultyDaoImpl(schoolYearDaoImpl);
    }

    public JComboBox<String> getJcmbSections() {
        return jcmbSections;
    }

    public JTextField getJtfSearchBox() {
        return jtfSearchBox;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

    public JButton getJbtnPromote() {
        return jbtnPromote;
    }

    public JButton getJbtnPromoteAll() {
        return jbtnPromoteAll;
    }

    public JButton getJbtnRetain() {
        return jbtnRetain;
    }

    public JButton getJbtnSaveAndClose() {
        return jbtnSaveAndClose;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JLabel getJlblSection() {
        return jlblSection;
    }

    public JPanel getJpnlControl() {
        return jpnlControl;
    }

    public JPanel getJpnlStudents() {
        return jpnlStudents;
    }

    public JTable getJtblStudents() {
        return jtblStudents;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        jpnlControl = new javax.swing.JPanel();
        jlblSection = new javax.swing.JLabel();
        jcmbSections = new javax.swing.JComboBox<>();
        jtfSearchBox = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jbtnPromote = new javax.swing.JButton();
        jbtnRetain = new javax.swing.JButton();
        jbtnPromoteAll = new javax.swing.JButton();
        jpnlStudents = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblStudents = new javax.swing.JTable();
        panel_footer = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnSaveAndClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Promotion");
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1000, 700));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1000, 700));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        jpnlControl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlControl.setMinimumSize(new java.awt.Dimension(1000, 70));
        jpnlControl.setPreferredSize(new java.awt.Dimension(1000, 70));
        jpnlControl.setLayout(new java.awt.GridBagLayout());

        jlblSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSection.setText("Section :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpnlControl.add(jlblSection, gridBagConstraints);

        jcmbSections.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSections.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbSections.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jpnlControl.add(jcmbSections, gridBagConstraints);

        jtfSearchBox.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jtfSearchBox.setText("Search here");
        jtfSearchBox.setMinimumSize(new java.awt.Dimension(150, 25));
        jtfSearchBox.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnlControl.add(jtfSearchBox, gridBagConstraints);

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jpnlControl.add(jbtnSearch, gridBagConstraints);

        jbtnPromote.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPromote.setText("Promote");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpnlControl.add(jbtnPromote, gridBagConstraints);

        jbtnRetain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRetain.setText("Retain");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jpnlControl.add(jbtnRetain, gridBagConstraints);

        jbtnPromoteAll.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPromoteAll.setText("Promote All");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        jpnlControl.add(jbtnPromoteAll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(jpnlControl, gridBagConstraints);

        jpnlStudents.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlStudents.setMinimumSize(new java.awt.Dimension(1000, 555));
        jpnlStudents.setPreferredSize(new java.awt.Dimension(1000, 555));
        jpnlStudents.setLayout(new java.awt.GridBagLayout());

        jtblStudents.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Student Number", "Grade Level", "Average", "Remarks", "Promoted", "Recommended For"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblStudents.setRowHeight(30);
        jtblStudents.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblStudents);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlStudents.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(jpnlStudents, gridBagConstraints);

        panel_footer.setMinimumSize(new java.awt.Dimension(550, 40));
        panel_footer.setPreferredSize(new java.awt.Dimension(550, 40));
        panel_footer.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.setMaximumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setMinimumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setPreferredSize(new java.awt.Dimension(120, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnCancel, gridBagConstraints);

        jbtnSaveAndClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveAndClose.setText("Save & Close");
        jbtnSaveAndClose.setMaximumSize(new java.awt.Dimension(110, 40));
        jbtnSaveAndClose.setMinimumSize(new java.awt.Dimension(110, 40));
        jbtnSaveAndClose.setPreferredSize(new java.awt.Dimension(120, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnSaveAndClose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_footer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(panel_toppanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnPromote;
    private javax.swing.JButton jbtnPromoteAll;
    private javax.swing.JButton jbtnRetain;
    private javax.swing.JButton jbtnSaveAndClose;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JComboBox<String> jcmbSections;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JPanel jpnlControl;
    private javax.swing.JPanel jpnlStudents;
    private javax.swing.JTable jtblStudents;
    private javax.swing.JTextField jtfSearchBox;
    private javax.swing.JPanel panel_footer;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
