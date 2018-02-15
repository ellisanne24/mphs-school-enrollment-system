package view.grades;

import component_model_loader.StudentJCompModelLoader;
import controller.grade.ActionListener_Display_Dialog_OverrideGrading_JButton;
import controller.grade.ActionListener_Display_Dialog_ViewReportCard_JButton;
import controller.grade.TableModelListener_Panel_GradingSystem_MyAdvisoryGradesList_JTable;
import daoimpl.FacultyDaoImpl;
import daoimpl.GradeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.StudentDaoImpl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.faculty.Faculty;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.user.User;
import utility.initializer.Initializer;

/**
 *
 * @author Jordan
 */
public class View_Panel_GradingSystem extends javax.swing.JPanel implements Initializer{

    private final User user;
    private StudentJCompModelLoader studentJCompModelLoader;
    private SchoolYearDaoImpl schoolYearDaoImpl;
    private StudentDaoImpl studentDaoImpl;
    private FacultyDaoImpl facultyDaoImpl;
    
    public View_Panel_GradingSystem(User user) {
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
        studentJCompModelLoader = new StudentJCompModelLoader(studentDaoImpl);
    }

    @Override
    public void initRenderers() {
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
        if(user.getRole().getRoleName().trim().equalsIgnoreCase("Faculty")){
            Faculty faculty = facultyDaoImpl.getFacultyByUser(user);
            SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
            jtblAdvisoryGradesList.setModel(studentJCompModelLoader.getStudentsOfAdviser(jtblAdvisoryGradesList, faculty, schoolYear));
            test();
        }else if(user.getRole().getRoleName().trim().equalsIgnoreCase("Administrator")){
//            JOptionPane.showMessageDialog(null,"Administrator");
        }
    }

    private void test(){
        GradeDaoImpl gradeDaoImpl = new GradeDaoImpl();
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        if (jtblAdvisoryGradesList.getRowCount() > 0) {
                for (int row = 0; row < jtblAdvisoryGradesList.getRowCount(); row++) {
                    Student student = new Student();
                    student.setStudentId(Integer.parseInt(jtblAdvisoryGradesList.getValueAt(row, 0).toString().trim()));
                    for (int col = 0; col < jtblAdvisoryGradesList.getColumnCount(); col++) {
                        if (col == 5) {
                            int gradingPeriod = 1;
                            Grade grade = gradeDaoImpl.getGradeByStudentGradingPeriodAndSchoolYear(student, gradingPeriod, schoolYear);
                            jtblAdvisoryGradesList.setValueAt(grade.getValue(), row, col);
                        } else if (col == 6) {
                            int gradingPeriod = 2;
                            Grade grade = gradeDaoImpl.getGradeByStudentGradingPeriodAndSchoolYear(student, gradingPeriod, schoolYear);
                            jtblAdvisoryGradesList.setValueAt(grade.getValue(), row, col);
                        } else if (col == 7) {
                            int gradingPeriod = 3;
                            Grade grade = gradeDaoImpl.getGradeByStudentGradingPeriodAndSchoolYear(student, gradingPeriod, schoolYear);
                            jtblAdvisoryGradesList.setValueAt(grade.getValue(), row, col);
                        } else if (col == 8) {
                            int gradingPeriod = 4;
                            Grade grade = gradeDaoImpl.getGradeByStudentGradingPeriodAndSchoolYear(student, gradingPeriod, schoolYear);
                            jtblAdvisoryGradesList.setValueAt(grade.getValue(), row, col);
                        }
                    }
                }
            }
    }
    
    @Override
    public void initControllers() {
        jbtnViewReportCard.addActionListener(new ActionListener_Display_Dialog_ViewReportCard_JButton(this));
        jbtnInputGrades.addActionListener(new ActionListener_Display_Dialog_OverrideGrading_JButton(user));
        jtblAdvisoryGradesList.getModel().addTableModelListener(new TableModelListener_Panel_GradingSystem_MyAdvisoryGradesList_JTable(this));
    }

    @Override
    public void initDaoImpl() {
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        studentDaoImpl = new StudentDaoImpl();
        facultyDaoImpl = new FacultyDaoImpl();
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton2() {
        return jbtnViewReportCard;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JButton getJbtnInputGrades() {
        return jbtnInputGrades;
    }

    public JButton getJbtnOpen() {
        return jbtnOpen;
    }

    public JButton getJbtnPrint() {
        return jbtnPrint;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JButton getJbtnViewAll() {
        return jbtnViewAll;
    }

    public JComboBox<String> getJcmbSearchBy() {
        return jcmbSearchBy;
    }

    public JPanel getJpnlMyAdvisory() {
        return jpnlMyAdvisory;
    }

    public JTable getJtblAdvisoryGradesList() {
        return jtblAdvisoryGradesList;
    }

    public JTextField getJtfSearchBox() {
        return jtfSearchBox;
    }

    public JLabel getLbl_show() {
        return lbl_show;
    }

    public JPanel getPanel_control() {
        return panel_control;
    }

    public JPanel getPanel_toppanel() {
        return panel_toppanel;
    }

    
    
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panel_toppanel = new javax.swing.JPanel();
        panel_control = new javax.swing.JPanel();
        jbtnInputGrades = new javax.swing.JButton();
        jbtnViewAll = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jtfSearchBox = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        lbl_show = new javax.swing.JLabel();
        jcmbSearchBy = new javax.swing.JComboBox<>();
        jbtnOpen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jbtnViewReportCard = new javax.swing.JButton();
        jpnlMyAdvisory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAdvisoryGradesList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_control.setMinimumSize(new java.awt.Dimension(1200, 40));
        panel_control.setPreferredSize(new java.awt.Dimension(1200, 40));
        panel_control.setLayout(new java.awt.GridBagLayout());

        jbtnInputGrades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnInputGrades.setText("Input Grades");
        jbtnInputGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInputGradesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel_control.add(jbtnInputGrades, gridBagConstraints);

        jbtnViewAll.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnViewAll.setText("View All");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel_control.add(jbtnViewAll, gridBagConstraints);

        jbtnPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPrint.setText("Print");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnPrint, gridBagConstraints);

        jtfSearchBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSearchBox.setText("Search here");
        jtfSearchBox.setMinimumSize(new java.awt.Dimension(150, 25));
        jtfSearchBox.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jtfSearchBox, gridBagConstraints);

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        panel_control.add(jbtnSearch, gridBagConstraints);

        lbl_show.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_show.setText("Search by :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(lbl_show, gridBagConstraints);

        jcmbSearchBy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Grade Level", "Sebject Code", "Section" }));
        jcmbSearchBy.setMinimumSize(new java.awt.Dimension(100, 25));
        jcmbSearchBy.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jcmbSearchBy, gridBagConstraints);

        jbtnOpen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnOpen.setText("Open");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        panel_control.add(jbtnOpen, gridBagConstraints);

        jButton1.setText("Promotion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jButton1, gridBagConstraints);

        jbtnViewReportCard.setText("View Report Card");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_control.add(jbtnViewReportCard, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        panel_toppanel.add(panel_control, gridBagConstraints);

        jpnlMyAdvisory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Advisory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpnlMyAdvisory.setMinimumSize(new java.awt.Dimension(1200, 555));
        jpnlMyAdvisory.setPreferredSize(new java.awt.Dimension(1200, 555));
        jpnlMyAdvisory.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1185, 530));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1185, 530));

        jtblAdvisoryGradesList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblAdvisoryGradesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student No", "Student Name", "Grade Level", "Section", "1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter", "Final Grade", "Gen. Average", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblAdvisoryGradesList.setMinimumSize(new java.awt.Dimension(1185, 550));
        jtblAdvisoryGradesList.setPreferredSize(new java.awt.Dimension(1185, 550));
        jtblAdvisoryGradesList.setRowHeight(40);
        jtblAdvisoryGradesList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblAdvisoryGradesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        jpnlMyAdvisory.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panel_toppanel.add(jpnlMyAdvisory, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(panel_toppanel, gridBagConstraints);

        jPanel1.add(jPanel3, new java.awt.GridBagConstraints());

        jTabbedPane1.addTab("My Advisory", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Handled Students", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnInputGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInputGradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnInputGradesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnInputGrades;
    private javax.swing.JButton jbtnOpen;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnViewAll;
    private javax.swing.JButton jbtnViewReportCard;
    private javax.swing.JComboBox<String> jcmbSearchBy;
    private javax.swing.JPanel jpnlMyAdvisory;
    private javax.swing.JTable jtblAdvisoryGradesList;
    private javax.swing.JTextField jtfSearchBox;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}