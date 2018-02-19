package view.schoolyear;

import component_model_loader.GradeLevelJCompModelLoader;
import component_model_loader.SchoolYearJCompModelLoader;
import controller.global.Controller_JTextField_ClearDefaultSearchText;
import controller.schoolyear.Controller_Open_Close_SchoolYear_JButton;
import controller.schoolyear.DisplaySchoolYearCrudDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import utility.initializer.Initializer;

public class Panel_SchoolYear extends javax.swing.JPanel implements Initializer{

    private SchoolYearJCompModelLoader schoolYearJCompModelLoader;
    private GradeLevelJCompModelLoader gradeLevelJCompModelLoader;

    public Panel_SchoolYear() {
        initComponents();
        
        initJCompModelLoaders();
        initRenderers();
        initModels();
        initViewComponents();
        initControllers();
        initDaoImpl();
    }

    @Override
    public void initRenderers() {
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
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        jtblSchoolYearMasterList.setModel(schoolYearJCompModelLoader.getAllSchoolYearInfo(jtblSchoolYearMasterList));
    }

    @Override
    public void initControllers() {
        jbtnOpenSchoolYear.addActionListener(new Controller_Open_Close_SchoolYear_JButton(this));
        jbtnCloseSchoolYear.addActionListener(new Controller_Open_Close_SchoolYear_JButton(this));
        jtfSearchBox.addMouseListener(new Controller_JTextField_ClearDefaultSearchText());
        jbtnCreate.addActionListener(new DisplaySchoolYearCrudDialog(jtblSchoolYearMasterList));
        jbtnEdit.addActionListener(new DisplaySchoolYearCrudDialog(jtblSchoolYearMasterList));
        jbtnView.addActionListener(new DisplaySchoolYearCrudDialog(jtblSchoolYearMasterList));
    }

    @Override
    public void initDaoImpl() {
        
    }

    public JButton getJbtnCloseSchoolYear() {
        return jbtnCloseSchoolYear;
    }

    public JButton getJbtnCreate() {
        return jbtnCreate;
    }

    public JButton getJbtnEdit() {
        return jbtnEdit;
    }

    public JButton getJbtnOpenSchoolYear() {
        return jbtnOpenSchoolYear;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JButton getJbtnView() {
        return jbtnView;
    }

    public JTable getJtblSchoolYearMasterList() {
        return jtblSchoolYearMasterList;
    }

    public JTextField getJtfSearchBox() {
        return jtfSearchBox;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_toppanel = new javax.swing.JPanel();
        panel_control = new javax.swing.JPanel();
        jbtnCreate = new javax.swing.JButton();
        jbtnEdit = new javax.swing.JButton();
        jbtnView = new javax.swing.JButton();
        jtfSearchBox = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jbtnOpenSchoolYear = new javax.swing.JButton();
        jbtnCloseSchoolYear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_masterrecord = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblSchoolYearMasterList = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1200, 600));
        setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setPreferredSize(new java.awt.Dimension(1200, 600));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_control.setMinimumSize(new java.awt.Dimension(1200, 40));
        panel_control.setPreferredSize(new java.awt.Dimension(1200, 40));
        panel_control.setLayout(new java.awt.GridBagLayout());

        jbtnCreate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCreate.setText("Create New");
        jbtnCreate.setActionCommand("create");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnCreate, gridBagConstraints);

        jbtnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEdit.setText("Edit");
        jbtnEdit.setActionCommand("edit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnEdit, gridBagConstraints);

        jbtnView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnView.setText("View");
        jbtnView.setActionCommand("view");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnView, gridBagConstraints);

        jtfSearchBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSearchBox.setText("Search here");
        jtfSearchBox.setMinimumSize(new java.awt.Dimension(150, 25));
        jtfSearchBox.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 360, 0, 0);
        panel_control.add(jtfSearchBox, gridBagConstraints);

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        panel_control.add(jbtnSearch, gridBagConstraints);

        jbtnOpenSchoolYear.setText("Open School Year");
        jbtnOpenSchoolYear.setActionCommand("open");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        panel_control.add(jbtnOpenSchoolYear, gridBagConstraints);

        jbtnCloseSchoolYear.setText("Close School Year");
        jbtnCloseSchoolYear.setActionCommand("close");
        panel_control.add(jbtnCloseSchoolYear, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_control, gridBagConstraints);

        panel_masterrecord.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Record Master List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_masterrecord.setMinimumSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setPreferredSize(new java.awt.Dimension(1200, 555));
        panel_masterrecord.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtblSchoolYearMasterList.setAutoCreateRowSorter(true);
        jtblSchoolYearMasterList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblSchoolYearMasterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "School Year", "SY Start Date", "SY End Date", "Enrollment Start", "Enrollment End", "Summer Enrollment Start", "Summer Enrollment End", "Summer Start", "Summer End", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSchoolYearMasterList.setMinimumSize(new java.awt.Dimension(1185, 530));
        jtblSchoolYearMasterList.setPreferredSize(new java.awt.Dimension(1185, 530));
        jtblSchoolYearMasterList.setRowHeight(20);
        jtblSchoolYearMasterList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblSchoolYearMasterList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_masterrecord.add(jScrollPane2, gridBagConstraints);

        jScrollPane1.setViewportView(panel_masterrecord);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(panel_toppanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnCloseSchoolYear;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnOpenSchoolYear;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnView;
    private javax.swing.JTable jtblSchoolYearMasterList;
    private javax.swing.JTextField jtfSearchBox;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_masterrecord;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables

}
