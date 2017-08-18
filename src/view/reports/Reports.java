package view.reports;

import component_model_loader.GradeLevelML;
import component_model_loader.SchoolYearML;
import component_renderers.GradeLevelJComboBoxRenderer;
import constants.DashboardMenuItem;
import controller.navigation.UINavigationExit;
import controller.printer.PrintController;
import controller.reports.EnrolleesReportFilterController;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.ReportsDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.Component;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.classlistreport.ClassListReport;
import printtest.PrintTest;
import utility.component.JInternalFrameUtil;
import utility.component.TableUtility;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Reports extends javax.swing.JPanel {

    private SchoolYearDaoImpl schoolYearDaoImpl;
    private GradeLevelDaoImpl gradeLevelDaoImpl;
    private SchoolYearML schoolYearML;
    private GradeLevelML gradeLevelML;
    
    public Reports() {
        initComponents();
        initializeModels();
        JInternalFrameUtil.removeTitleBar(jInternalFrame1);
        initializeControllers();
        jtblEnrollees.setRowHeight(30);
        jlblEnrolleesGradeLevelText.setText("");
        jlblEnrolleesSchoolYearText.setText("");
        TableUtility.setTableColumnWidth(jtblClassList);
        TableUtility.setTableColumnWidth(jtblEnrollees);
    }
    
    private void initializeModels(){
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
        
        schoolYearML = new SchoolYearML();
        gradeLevelML = new GradeLevelML();
        
        jcmbEnrolleesGradeLevel.setModel(gradeLevelML.getAllGradeLevels());
        jcmbClassListGradeLevel.setModel(gradeLevelML.getAllGradeLevels());
        jcmbEnrolleesSchoolYearFrom.setModel(schoolYearML.getAllSchoolYearStart());
        jcmbClassListSchoolYearFrom.setModel(schoolYearML.getAllSchoolYearStart());
        jcmbEnrolleesSchoolYearTo.setModel(schoolYearML.getAllSchoolYearEnd());
    }
    
    private void initializeControllers(){
//        jmiPrintEnrolleesReport.addActionListener(new PrintController(jpnlEnrolleesContainer));
//        jmiPrintClassListReport.addActionListener(new PrintController(jpnlClassListContainer));
        
        jmiPrintClassListReport.addActionListener(new PrintTest(jtblClassList,"MPHS - Class List"));
        jmiPrintEnrolleesReport.addActionListener(new PrintTest(jtblEnrollees,"MPHS - Enrollees"));
        
        
        jmiExit.addActionListener(new UINavigationExit(this, DashboardMenuItem.REPORTS));
//        jcmbEnrolleesSchoolYearFrom.addItemListener(new SchoolYearController(jcmbEnrolleesSchoolYearFrom, jcmbEnrolleesSchoolYearTo));
        jcmbEnrolleesSchoolYearFrom.addItemListener(new EnrolleesReportFilterController(
                        jcmbEnrolleesSchoolYearFrom, jcmbEnrolleesSchoolYearTo,
                        jcmbEnrolleesGradeLevel, jtblEnrollees,
                        jlblEnrolleesSchoolYearText,jlblEnrolleesGradeLevelText,jcbShowAll));
        jcmbEnrolleesGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        
        jcmbEnrolleesGradeLevel.addItemListener(new EnrolleesReportFilterController(
                        jcmbEnrolleesSchoolYearFrom, jcmbEnrolleesSchoolYearTo,
                jcmbEnrolleesGradeLevel, jtblEnrollees,
                        jlblEnrolleesSchoolYearText,jlblEnrolleesGradeLevelText,jcbShowAll));
        jcmbEnrolleesGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        jcmbClassListGradeLevel.setRenderer(new GradeLevelJComboBoxRenderer());
        jcbShowAll.addItemListener(
                new EnrolleesReportFilterController(
                        jcmbEnrolleesSchoolYearFrom, jcmbEnrolleesSchoolYearTo,
                        jcmbEnrolleesGradeLevel, jtblEnrollees, jlblEnrolleesSchoolYearText, 
                        jlblEnrolleesGradeLevelText, jcbShowAll));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jpnlContent = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jpnlEnrolleesFilter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcmbEnrolleesSchoolYearFrom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcmbEnrolleesGradeLevel = new javax.swing.JComboBox<>();
        jcmbEnrolleesSchoolYearTo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbShowAll = new javax.swing.JCheckBox();
        jpnlEnrolleesContainer = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlblEnrolleesSchoolYearText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblEnrolleesGradeLevelText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEnrollees = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcmbClassListSchoolYearFrom = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcmbClassListGradeLevel = new javax.swing.JComboBox<>();
        jcbShowAllClassList = new javax.swing.JCheckBox();
        jpnlClassListContainer = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblClassList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiPrintEnrolleesReport = new javax.swing.JMenuItem();
        jmiPrintClassListReport = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new java.awt.GridBagLayout());

        jpnlContent.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jpnlEnrolleesFilter.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jcmbEnrolleesSchoolYearFrom, gridBagConstraints);

        jLabel3.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jcmbEnrolleesGradeLevel, gridBagConstraints);

        jcmbEnrolleesSchoolYearTo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jcmbEnrolleesSchoolYearTo, gridBagConstraints);

        jLabel2.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jLabel2, gridBagConstraints);

        jcbShowAll.setText("Show All");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesFilter.add(jcbShowAll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel2.add(jpnlEnrolleesFilter, gridBagConstraints);

        jpnlEnrolleesContainer.setLayout(new java.awt.GridBagLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jlblEnrolleesSchoolYearText.setText("SchoolYearText");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblEnrolleesSchoolYearText, gridBagConstraints);

        jLabel4.setText("School Year :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel4, gridBagConstraints);

        jLabel9.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jLabel9, gridBagConstraints);

        jlblEnrolleesGradeLevelText.setText("Grade Level Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel6.add(jlblEnrolleesGradeLevelText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jpnlEnrolleesContainer.add(jPanel6, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 800));

        jtblEnrollees.setAutoCreateRowSorter(true);
        jtblEnrollees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade Level", "Student Id", "Student Name", "Date Enrolled", "Withdrawn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblEnrollees.setPreferredSize(new java.awt.Dimension(800, 800));
        jScrollPane1.setViewportView(jtblEnrollees);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlEnrolleesContainer.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jpnlEnrolleesContainer, gridBagConstraints);

        jTabbedPane1.addTab("Enrollees", jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("School Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(jLabel5, gridBagConstraints);

        jcmbClassListSchoolYearFrom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbClassListSchoolYearFromItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(jcmbClassListSchoolYearFrom, gridBagConstraints);

        jLabel6.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(jLabel6, gridBagConstraints);

        jcmbClassListGradeLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbClassListGradeLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(jcmbClassListGradeLevel, gridBagConstraints);

        jcbShowAllClassList.setText("Show All");
        jcbShowAllClassList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbShowAllClassListItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel8.add(jcbShowAllClassList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel7.add(jPanel8, gridBagConstraints);

        jpnlClassListContainer.setLayout(new java.awt.GridBagLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jpnlClassListContainer.add(jPanel10, gridBagConstraints);

        jtblClassList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Section Name", "Adviser Name", "Student Id", "Student Name", "Grade Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtblClassList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jpnlClassListContainer.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(jpnlClassListContainer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(jPanel7, gridBagConstraints);

        jTabbedPane1.addTab("Class List", jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlContent.add(jTabbedPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jInternalFrame1.getContentPane().add(jpnlContent, gridBagConstraints);

        jMenu1.setText("File");

        jmiPrintEnrolleesReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiPrintEnrolleesReport.setText("Print Enrollees");
        jMenu1.add(jmiPrintEnrolleesReport);

        jmiPrintClassListReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiPrintClassListReport.setText("Print Class List");
        jMenu1.add(jmiPrintClassListReport);

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmiExit.setText("Exit");
        jMenu1.add(jmiExit);

        jMenuBar1.add(jMenu1);

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
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbClassListSchoolYearFromItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbClassListSchoolYearFromItemStateChanged
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
        ReportsDaoImpl rdi = new ReportsDaoImpl();
        DefaultTableModel tableModel = (DefaultTableModel)jtblClassList.getModel();
        if(jcmbClassListSchoolYearFrom.getSelectedIndex()>-1 && jcmbClassListGradeLevel.getSelectedIndex() == -1){
            int schoolYearStart = Integer.parseInt(jcmbClassListSchoolYearFrom.getSelectedItem().toString().trim());
            int schoolYearId = sydi.getId(schoolYearStart);
            List<ClassListReport> list = rdi.getClassList(schoolYearId);
            tableModel.setRowCount(0);
            
            for(ClassListReport clr : list){
                tableModel.addRow(new Object[]{
                    clr.getSectionName(),
                    clr.getAdviserLastName()==null? "":clr.getAdviserLastName()
                            +", "+clr.getAdviserFirstName() == null? "":clr.getAdviserFirstName(),
                    clr.getStudentId(),
                    clr.getStudentLastName()+", "+clr.getStudentFirstName()+" "+clr.getStudentMiddleName(),
                    clr.getGradeLevel()== 0? "Kindergarten":clr.getGradeLevel()
                });
            }
            jtblClassList.setModel(tableModel);
        }else if(jcmbClassListSchoolYearFrom.getSelectedIndex()>-1 && jcmbClassListGradeLevel.getSelectedIndex() > -1){
            int schoolYearStart = Integer.parseInt(jcmbClassListSchoolYearFrom.getSelectedItem().toString().trim());
            int schoolYearId = sydi.getId(schoolYearStart);
            int gradeLevel = Integer.parseInt(jcmbClassListGradeLevel.getSelectedItem().toString().trim());
            int gradeLevelId = gldi.getId(gradeLevel);
            List<ClassListReport> list = rdi.getAllClassList(schoolYearId, gradeLevelId);
            tableModel.setRowCount(0);
            
            for(ClassListReport clr : list){
                tableModel.addRow(new Object[]{
                    clr.getSectionName(),
                    clr.getAdviserLastName()==null? "":clr.getAdviserLastName()
                            +", "+clr.getAdviserFirstName() == null? "":clr.getAdviserFirstName(),
                    clr.getStudentId(),
                    clr.getStudentLastName()+", "+clr.getStudentFirstName()+" "+clr.getStudentMiddleName(),
                    clr.getGradeLevel()== 0? "Kindergarten":clr.getGradeLevel()
                });
            }
            jtblClassList.setModel(tableModel);
        }
    }//GEN-LAST:event_jcmbClassListSchoolYearFromItemStateChanged

    private void jcbShowAllClassListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbShowAllClassListItemStateChanged
        if (jcbShowAllClassList.isSelected()) {
            jcmbClassListGradeLevel.setSelectedItem(null);
            jcmbClassListSchoolYearFrom.setSelectedItem(null);

            GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
            SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
            ReportsDaoImpl rdi = new ReportsDaoImpl();
            DefaultTableModel tableModel = (DefaultTableModel) jtblClassList.getModel();

            List<ClassListReport> list = rdi.getAllClassList();
            tableModel.setRowCount(0);

            for (ClassListReport clr : list) {
                tableModel.addRow(new Object[]{
                    clr.getSectionName(),
                    clr.getAdviserLastName()==null? "":clr.getAdviserLastName()
                            +", "+clr.getAdviserFirstName() == null? "":clr.getAdviserFirstName(),
                    clr.getStudentId(),
                    clr.getStudentLastName() + ", " + clr.getStudentFirstName() + " " + clr.getStudentMiddleName(),
                    clr.getGradeLevel() == 0? "Kindergarten":clr.getGradeLevel()
                });
            }
            jtblClassList.setModel(tableModel);
        }
    }//GEN-LAST:event_jcbShowAllClassListItemStateChanged

    private void jcmbClassListGradeLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbClassListGradeLevelItemStateChanged
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
        ReportsDaoImpl rdi = new ReportsDaoImpl();
        DefaultTableModel tableModel = (DefaultTableModel)jtblClassList.getModel();
        if(jcmbClassListSchoolYearFrom.getSelectedIndex()>-1 && jcmbClassListGradeLevel.getSelectedIndex() == -1){
            int schoolYearStart = Integer.parseInt(jcmbClassListSchoolYearFrom.getSelectedItem().toString().trim());
            int schoolYearId = sydi.getId(schoolYearStart);
            List<ClassListReport> list = rdi.getClassList(schoolYearId);
            tableModel.setRowCount(0);
            
            for(ClassListReport clr : list){
                tableModel.addRow(new Object[]{
                    clr.getSectionName(),
                    clr.getAdviserLastName()==null? "":clr.getAdviserLastName()
                            +", "+clr.getAdviserFirstName() == null? "":clr.getAdviserFirstName(),
                    clr.getStudentId(),
                    clr.getStudentLastName()+", "+clr.getStudentFirstName()+" "+clr.getStudentMiddleName(),
                    clr.getGradeLevel()== 0? "Kindergarten":clr.getGradeLevel()
                });
            }
            jtblClassList.setModel(tableModel);
        }else if(jcmbClassListSchoolYearFrom.getSelectedIndex()>-1 && jcmbClassListGradeLevel.getSelectedIndex() > -1){
            int schoolYearStart = Integer.parseInt(jcmbClassListSchoolYearFrom.getSelectedItem().toString().trim());
            int schoolYearId = sydi.getId(schoolYearStart);
            int gradeLevel = Integer.parseInt(jcmbClassListGradeLevel.getSelectedItem().toString().trim());
            int gradeLevelId = gldi.getId(gradeLevel);
            List<ClassListReport> list = rdi.getAllClassList(schoolYearId, gradeLevelId);
            tableModel.setRowCount(0);
            
            for(ClassListReport clr : list){
                tableModel.addRow(new Object[]{
                    clr.getSectionName(),
                    clr.getAdviserLastName()==null? "":clr.getAdviserLastName()
                            +", "+clr.getAdviserFirstName() == null? "":clr.getAdviserFirstName(),
                    clr.getStudentId(),
                    clr.getStudentLastName()+", "+clr.getStudentFirstName()+" "+clr.getStudentMiddleName(),
                    clr.getGradeLevel()== 0? "Kindergarten":clr.getGradeLevel()
                });
            }
            jtblClassList.setModel(tableModel);
        }
    }//GEN-LAST:event_jcmbClassListGradeLevelItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox jcbShowAll;
    private javax.swing.JCheckBox jcbShowAllClassList;
    private javax.swing.JComboBox<String> jcmbClassListGradeLevel;
    private javax.swing.JComboBox<String> jcmbClassListSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbEnrolleesGradeLevel;
    private javax.swing.JComboBox<String> jcmbEnrolleesSchoolYearFrom;
    private javax.swing.JComboBox<String> jcmbEnrolleesSchoolYearTo;
    private javax.swing.JLabel jlblEnrolleesGradeLevelText;
    private javax.swing.JLabel jlblEnrolleesSchoolYearText;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiPrintClassListReport;
    private javax.swing.JMenuItem jmiPrintEnrolleesReport;
    private javax.swing.JPanel jpnlClassListContainer;
    private javax.swing.JPanel jpnlContent;
    private javax.swing.JPanel jpnlEnrolleesContainer;
    private javax.swing.JPanel jpnlEnrolleesFilter;
    private javax.swing.JTable jtblClassList;
    private javax.swing.JTable jtblEnrollees;
    // End of variables declaration//GEN-END:variables
}
