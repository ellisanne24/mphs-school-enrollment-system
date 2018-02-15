package view.grades;

import component_model_loader.StudentJCompModelLoader;
import component_renderers.Renderer_GradeLevel_JComboBox;
import component_renderers.Renderer_Grade_Dialog_OverrideGrading_GradingSheet_JTable;
import component_renderers.Renderer_Grade_Dialog_OverrideGrading_SubjectCode_JComboBox;
import component_renderers.Renderer_Section_JComboBox;
import controller.global.ExitJDialog;
import controller.grade.ActionListener_Dialog_OverrideGrade_Save_JButton;
import controller.grade.ItemListener_Dialog_OverrideGrading_Section_JComboBox;
import controller.grade.ItemListener_Dialog_OverrideGrading_SubjectCode_JComboBox;
import controller.grade.ItemListener_Dialog_OverrideGrading_Type_JComboBox;
import controller.grade.TableModelListener_Dialog_OverrideGrading_GradingSheet_JTable;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.user.User;
import utility.initializer.Initializer;


public class View_Dialog_OverrideGrading extends javax.swing.JDialog implements Initializer{

    private final User user;

    public View_Dialog_OverrideGrading(java.awt.Frame parent, boolean modal, User user) {
        super(parent, modal);
        initComponents();
        this.user = user;
        
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
    }

    @Override
    public void initRenderers() {
        jtblGradingSheet.setDefaultRenderer(Object.class, new Renderer_Grade_Dialog_OverrideGrading_GradingSheet_JTable());
        jcmbSection.setRenderer(new Renderer_Section_JComboBox());
        jcmbGradeLevel.setRenderer(new Renderer_GradeLevel_JComboBox());
        jcmbSubjectCode.setRenderer(new Renderer_Grade_Dialog_OverrideGrading_SubjectCode_JComboBox());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        
    }

    @Override
    public void initControllers() {
        jbtnCancel.addActionListener(new ExitJDialog(this));
        jcmbSubjectCode.addItemListener(new ItemListener_Dialog_OverrideGrading_SubjectCode_JComboBox(this));
        jbtnSaveAndClose.addActionListener(new ActionListener_Dialog_OverrideGrade_Save_JButton(this, user));
        jcmbType.addItemListener(new ItemListener_Dialog_OverrideGrading_Type_JComboBox(this, user));
        jcmbSection.addItemListener(new ItemListener_Dialog_OverrideGrading_Section_JComboBox(this, user));
        jtblGradingSheet.getModel().addTableModelListener(new TableModelListener_Dialog_OverrideGrading_GradingSheet_JTable(this));
    }

    @Override
    public void initDaoImpl() {
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }

    public JButton getJbtnRefresh() {
        return jbtnRefresh;
    }

    public JButton getJbtnReset() {
        return jbtnReset;
    }

    public JButton getJbtnSaveAndClose() {
        return jbtnSaveAndClose;
    }

    public JButton getJbtnSaveAndNew() {
        return jbtnSaveAndNew;
    }

    public JComboBox<String> getJcmbGradeLevel() {
        return jcmbGradeLevel;
    }

    public JComboBox<String> getJcmbSection() {
        return jcmbSection;
    }

    public JComboBox<String> getJcmbSubjectCode() {
        return jcmbSubjectCode;
    }

    public JComboBox<String> getJcmbType() {
        return jcmbType;
    }

    public JPanel getJpnlControl() {
        return jpnlControl;
    }

    public JPanel getJpnlStudentsList() {
        return jpnlStudentsList;
    }

    public JTable getJtblGradingSheet() {
        return jtblGradingSheet;
    }

    public JLabel getJlblType() {
        return jlblType;
    }

    public JLabel getJlblSection() {
        return jlblSection;
    }

    public JLabel getJlblGradeLevel() {
        return jlblGradeLevel;
    }

    public JLabel getJlblSubjectCode() {
        return jlblSubjectCode;
    }

    public JPanel getJpnlFooter() {
        return jpnlFooter;
    }

    public JPanel getJpnlTopPanel() {
        return jpnlTopPanel;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        jpnlTopPanel = new javax.swing.JPanel();
        jpnlControl = new javax.swing.JPanel();
        jbtnReset = new javax.swing.JButton();
        jlblType = new javax.swing.JLabel();
        jcmbType = new javax.swing.JComboBox<>();
        jbtnRefresh = new javax.swing.JButton();
        jlblSection = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jlblGradeLevel = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        jlblSubjectCode = new javax.swing.JLabel();
        jcmbSubjectCode = new javax.swing.JComboBox<>();
        jpnlStudentsList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblGradingSheet = new javax.swing.JTable();
        jpnlFooter = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnSaveAndClose = new javax.swing.JButton();
        jbtnSaveAndNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Override Grading");
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlTopPanel.setMinimumSize(new java.awt.Dimension(1000, 700));
        jpnlTopPanel.setPreferredSize(new java.awt.Dimension(1000, 700));
        jpnlTopPanel.setLayout(new java.awt.GridBagLayout());

        jpnlControl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlControl.setMinimumSize(new java.awt.Dimension(990, 80));
        jpnlControl.setPreferredSize(new java.awt.Dimension(990, 80));
        jpnlControl.setLayout(new java.awt.GridBagLayout());

        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnReset.setText("Reset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlControl.add(jbtnReset, gridBagConstraints);

        jlblType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblType.setText("Type :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jpnlControl.add(jlblType, gridBagConstraints);

        jcmbType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Advisory", "Handled" }));
        jcmbType.setSelectedIndex(-1);
        jcmbType.setMinimumSize(new java.awt.Dimension(130, 25));
        jcmbType.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlControl.add(jcmbType, gridBagConstraints);

        jbtnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRefresh.setText("Refresh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 120, 5, 0);
        jpnlControl.add(jbtnRefresh, gridBagConstraints);

        jlblSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSection.setText("Section :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        jpnlControl.add(jlblSection, gridBagConstraints);

        jcmbSection.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSection.setMinimumSize(new java.awt.Dimension(130, 25));
        jcmbSection.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlControl.add(jcmbSection, gridBagConstraints);

        jlblGradeLevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblGradeLevel.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jpnlControl.add(jlblGradeLevel, gridBagConstraints);

        jcmbGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbGradeLevel.setEnabled(false);
        jcmbGradeLevel.setMinimumSize(new java.awt.Dimension(130, 25));
        jcmbGradeLevel.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlControl.add(jcmbGradeLevel, gridBagConstraints);

        jlblSubjectCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSubjectCode.setText("Subject Code :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 5, 5);
        jpnlControl.add(jlblSubjectCode, gridBagConstraints);

        jcmbSubjectCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSubjectCode.setMinimumSize(new java.awt.Dimension(130, 25));
        jcmbSubjectCode.setPreferredSize(new java.awt.Dimension(130, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jpnlControl.add(jcmbSubjectCode, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlTopPanel.add(jpnlControl, gridBagConstraints);

        jpnlStudentsList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlStudentsList.setMinimumSize(new java.awt.Dimension(1000, 550));
        jpnlStudentsList.setPreferredSize(new java.awt.Dimension(1000, 550));
        jpnlStudentsList.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(990, 520));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(990, 520));

        jtblGradingSheet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblGradingSheet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student No", "Student Name", "Ist (TG)", "2nd (TG)", "3rd (TG)", "4th (TG)", "Total", "Final Grade", "Gen. Average", "Remedial Grade", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblGradingSheet.setRowHeight(20);
        jtblGradingSheet.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblGradingSheet);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jpnlStudentsList.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jpnlTopPanel.add(jpnlStudentsList, gridBagConstraints);

        jScrollPane2.setViewportView(jpnlTopPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jpnlFooter.setMinimumSize(new java.awt.Dimension(1000, 50));
        jpnlFooter.setPreferredSize(new java.awt.Dimension(1000, 50));
        jpnlFooter.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.setMaximumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setMinimumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFooter.add(jbtnCancel, gridBagConstraints);

        jbtnSaveAndClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveAndClose.setText("Save & Close");
        jbtnSaveAndClose.setMaximumSize(new java.awt.Dimension(120, 40));
        jbtnSaveAndClose.setMinimumSize(new java.awt.Dimension(120, 40));
        jbtnSaveAndClose.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFooter.add(jbtnSaveAndClose, gridBagConstraints);

        jbtnSaveAndNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSaveAndNew.setLabel("Save & New");
        jbtnSaveAndNew.setMaximumSize(new java.awt.Dimension(120, 40));
        jbtnSaveAndNew.setMinimumSize(new java.awt.Dimension(120, 40));
        jbtnSaveAndNew.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlFooter.add(jbtnSaveAndNew, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jpnlFooter, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnSaveAndClose;
    private javax.swing.JButton jbtnSaveAndNew;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JComboBox<String> jcmbSubjectCode;
    private javax.swing.JComboBox<String> jcmbType;
    private javax.swing.JLabel jlblGradeLevel;
    private javax.swing.JLabel jlblSection;
    private javax.swing.JLabel jlblSubjectCode;
    private javax.swing.JLabel jlblType;
    private javax.swing.JPanel jpnlControl;
    private javax.swing.JPanel jpnlFooter;
    private javax.swing.JPanel jpnlStudentsList;
    private javax.swing.JPanel jpnlTopPanel;
    private javax.swing.JTable jtblGradingSheet;
    // End of variables declaration//GEN-END:variables
}
