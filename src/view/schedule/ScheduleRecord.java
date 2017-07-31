/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.schedule;

import component_model_loader.FacultyML;
import component_model_loader.SbjML;
import component_model_loader.ScheduleML;
import component_model_loader.SchoolYearML;
import utility.component.JInternalFrameUtil;
import controller.global.SchoolYearController;
import controller.schedule.FilterScheduleRecordController;
import controller.schedule.DisplayCreateController;
import controller.schedule.ScheduleTableRecordController;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Color;
import javax.swing.UIManager;

public class ScheduleRecord extends javax.swing.JPanel {

    SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
    
    public ScheduleRecord() {
        initComponents();
        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        initializeModels();
        initializeControllers();
    }

    private void initializeControllers() {
        FilterScheduleRecordController filterScheduleRecordController = new FilterScheduleRecordController(
                jcmbSchoolYearFrom, jcmbSubject, jtblSchedule, jcbAllSubjects, jcmbFaculty);
        filterScheduleRecordController.control();
        jmiNewSchedule.addActionListener(new DisplayCreateController());
        jtblSchedule.addMouseListener(new ScheduleTableRecordController(jtblSchedule));
        SchoolYearController schoolYearController = new SchoolYearController(jcmbSchoolYearFrom, jcmbSchoolYearTo);
        jcmbSchoolYearFrom.addItemListener(schoolYearController);
    }

    private void initializeModels() {
        jcmbSchoolYearFrom.setModel(new SchoolYearML().getAllSchoolYearStart());
        jcmbSchoolYearTo.setModel(new SchoolYearML().getAllSchoolYearEnd());
        jcmbSubject.setModel(new SbjML().getSubjectNames());
        jcmbSubject.setSelectedIndex(-1);
        jtblSchedule.setModel(new ScheduleML().getAllBySchoolYearId(schoolYearDaoImpl.getCurrentSchoolYearId(), jtblSchedule));
        jtblSchedule.setAutoCreateRowSorter(true);
        jcmbFaculty.setModel(new FacultyML().getAllFacultyNames());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jpnlCardContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlYourContent = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcmbSchoolYearFrom = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcmbSchoolYearTo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcmbSubject = new javax.swing.JComboBox<>();
        jcbAllSubjects = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jlblFaculty = new javax.swing.JLabel();
        jcmbFaculty = new javax.swing.JComboBox<>();
        jpnlScheduleTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSchedule = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuFile = new javax.swing.JMenu();
        jmiNewSchedule = new javax.swing.JMenuItem();
        jmiEdit = new javax.swing.JMenuItem();
        jmiSaveChanges = new javax.swing.JMenuItem();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jpnlCardContainer.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlYourContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlYourContent.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("School Year ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcmbSchoolYearFrom, gridBagConstraints);

        jLabel2.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcmbSchoolYearTo, gridBagConstraints);

        jLabel3.setText("Subject");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcmbSubject, gridBagConstraints);

        jcbAllSubjects.setText("All Subjects");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcbAllSubjects, gridBagConstraints);

        jLabel4.setText("Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel4, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" }));
        jComboBox1.setSelectedIndex(-1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jComboBox1, gridBagConstraints);

        jlblFaculty.setText("Faculty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jlblFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jcmbFaculty, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlYourContent.add(jPanel4, gridBagConstraints);

        jpnlScheduleTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpnlScheduleTable.setPreferredSize(new java.awt.Dimension(600, 410));
        jpnlScheduleTable.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 402));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 402));

        jtblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule Id", "Day", "Start Time", "End Time", "Section", "Subject", "Room", "Faculty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblSchedule.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblSchedule);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlScheduleTable.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlYourContent.add(jpnlScheduleTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jpnlYourContent, gridBagConstraints);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(31, 23));

        jmenuFile.setText("File");

        jmiNewSchedule.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiNewSchedule.setText("New");
        jmenuFile.add(jmiNewSchedule);

        jmiEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiEdit.setText("Edit");
        jmenuFile.add(jmiEdit);

        jmiSaveChanges.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSaveChanges.setText("Save");
        jmenuFile.add(jmiSaveChanges);

        jMenuBar1.add(jmenuFile);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel1.add(jInternalFrame1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel2.add(jPanel1, gridBagConstraints);

        jpnlCardContainer.add(jPanel2, "card2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jPanel3.add(jpnlCardContainer, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAllSubjects;
    private javax.swing.JComboBox<String> jcmbFaculty;
    private javax.swing.JComboBox<String> jcmbSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbSchoolYearTo;
    private javax.swing.JComboBox<String> jcmbSubject;
    private javax.swing.JLabel jlblFaculty;
    private javax.swing.JMenu jmenuFile;
    private javax.swing.JMenuItem jmiEdit;
    private javax.swing.JMenuItem jmiNewSchedule;
    private javax.swing.JMenuItem jmiSaveChanges;
    public static javax.swing.JPanel jpnlCardContainer;
    private javax.swing.JPanel jpnlScheduleTable;
    private javax.swing.JPanel jpnlYourContent;
    public static javax.swing.JTable jtblSchedule;
    // End of variables declaration//GEN-END:variables
}
