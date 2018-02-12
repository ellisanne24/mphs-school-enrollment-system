package view.schedule;

import component_model_loader.FacultyJCompModelLoader;
import component_model_loader.SchoolYearJCompModelLoader;
import component_renderers.Renderer_SchoolYear_JComboBox;
import controller.schedule.ActionListener_Schedule_Display_Create_Dialog_JButton;
import daoimpl.SchoolYearDaoImpl;
import utility.initializer.Initializer;


public class Panel_ClassSchedules extends javax.swing.JPanel implements Initializer{

    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private FacultyJCompModelLoader facultyJCompModelLoader;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    
    public Panel_ClassSchedules() {
        initComponents();
        
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
        facultyJCompModelLoader = new FacultyJCompModelLoader();
    }

    @Override
    public void initRenderers() {
        jcmbSchoolYear.setRenderer(new Renderer_SchoolYear_JComboBox());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        jcmbSchoolYear.setModel(schoolYearJCompModelLoader.getCurrentSchoolYear());
    }

    @Override
    public void initControllers() {
        jbtnCreate.addActionListener(new ActionListener_Schedule_Display_Create_Dialog_JButton());
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        jpnlControls = new javax.swing.JPanel();
        jbtnCreate = new javax.swing.JButton();
        jbtnEdit = new javax.swing.JButton();
        jbtnView = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        lbl_sy = new javax.swing.JLabel();
        jcmbSchoolYear = new javax.swing.JComboBox<>();
        lbl_sy1 = new javax.swing.JLabel();
        jcmbFaculty = new javax.swing.JComboBox<>();
        panel_masterrecord = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbtnScheduleMasterList = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1200, 600));
        setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        jpnlControls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlControls.setMinimumSize(new java.awt.Dimension(1200, 40));
        jpnlControls.setPreferredSize(new java.awt.Dimension(1200, 40));
        jpnlControls.setLayout(new java.awt.GridBagLayout());

        jbtnCreate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCreate.setText("Create New Schedule");
        jbtnCreate.setActionCommand("create");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jpnlControls.add(jbtnCreate, gridBagConstraints);

        jbtnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEdit.setText("Edit");
        jbtnEdit.setActionCommand("edit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jpnlControls.add(jbtnEdit, gridBagConstraints);

        jbtnView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnView.setText("View");
        jbtnView.setActionCommand("view");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpnlControls.add(jbtnView, gridBagConstraints);

        jbtnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.setActionCommand("delete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jpnlControls.add(jbtnDelete, gridBagConstraints);

        jbtnPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPrint.setText("Print");
        jbtnPrint.setActionCommand("print");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jpnlControls.add(jbtnPrint, gridBagConstraints);

        jtfSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSearch.setText("Search here");
        jtfSearch.setMinimumSize(new java.awt.Dimension(150, 25));
        jtfSearch.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        jpnlControls.add(jtfSearch, gridBagConstraints);

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.setActionCommand("search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jpnlControls.add(jbtnSearch, gridBagConstraints);

        lbl_sy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sy.setText("School Year :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 5);
        jpnlControls.add(lbl_sy, gridBagConstraints);

        jcmbSchoolYear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSchoolYear.setEnabled(false);
        jcmbSchoolYear.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbSchoolYear.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jpnlControls.add(jcmbSchoolYear, gridBagConstraints);

        lbl_sy1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sy1.setText("Faculty :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jpnlControls.add(lbl_sy1, gridBagConstraints);

        jcmbFaculty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbFaculty.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbFaculty.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 10);
        jpnlControls.add(jcmbFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel_toppanel.add(jpnlControls, gridBagConstraints);

        panel_masterrecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schedule Master List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_masterrecord.setMinimumSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setPreferredSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1185, 530));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1185, 530));

        jbtnScheduleMasterList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnScheduleMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Day", "Start Time", "End Time", "Section", "Subject", "Room", "Faculty", "Session"
            }
        ));
        jbtnScheduleMasterList.setMinimumSize(new java.awt.Dimension(1185, 530));
        jbtnScheduleMasterList.setPreferredSize(new java.awt.Dimension(1185, 530));
        jbtnScheduleMasterList.setRowHeight(20);
        jScrollPane1.setViewportView(jbtnScheduleMasterList);

        panel_masterrecord.add(jScrollPane1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel_toppanel.add(panel_masterrecord, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(panel_toppanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JTable jbtnScheduleMasterList;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnView;
    private javax.swing.JComboBox<String> jcmbFaculty;
    private javax.swing.JComboBox<String> jcmbSchoolYear;
    private javax.swing.JPanel jpnlControls;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JLabel lbl_sy;
    private javax.swing.JLabel lbl_sy1;
    private javax.swing.JPanel panel_masterrecord;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
