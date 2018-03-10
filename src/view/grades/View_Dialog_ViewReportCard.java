package view.grades;

import component_renderers.Renderer_Faculty_JComboBox;
import component_renderers.Renderer_GradeLevel_JComboBox;
import component_renderers.Renderer_Grade_ReportCard_JTableCell;
import component_renderers.Renderer_ReportCard_StudentName_JComboBox;
import component_renderers.Renderer_Section_JComboBox;
import component_renderers.Renderer_Student_JComboBox;
import controller.global.Controller_JButton_ExitJDialog;
import daoimpl.GradeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import daoimpl.SectionDaoImpl;
import daoimpl.SubjectDaoImpl;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import model.subject.Subject;
import utility.initializer.Initializer;

public class View_Dialog_ViewReportCard extends javax.swing.JDialog implements Initializer {

    private final Student student;
    private SectionDaoImpl sectionDaoImpl;
    private SubjectDaoImpl subjectDaoImpl;
    private GradeDaoImpl gradeDaoImpl;
    private SchoolYearDaoImpl schoolYearDaoImpl;

    public View_Dialog_ViewReportCard(java.awt.Frame parent, boolean modal, Student student) {
        super(parent, modal);
        initComponents();
        this.student = student;

        UIManager.put("ComboBox.disabledBackground", new Color(212, 212, 210));
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);

        initDaoImpl();
        initRenderers();
        initJCompModelLoaders();
        initControllers();
        initViewComponents();

        initForm();
    }

    @Override
    public void initGridBagConstraints() {
    }

    @Override
    public void initJCompModelLoaders() {
    }

    @Override
    public void initRenderers() {
        jtblReportCard.setDefaultRenderer(Object.class, new Renderer_Grade_ReportCard_JTableCell(0));
        jcmbGradeLevel.setRenderer(new Renderer_GradeLevel_JComboBox());
        jcmbAdviser.setRenderer(new Renderer_Faculty_JComboBox());
        jcmbSection.setRenderer(new Renderer_Section_JComboBox());
        jcmbStudentId.setRenderer(new Renderer_Student_JComboBox());
        jcmbStudentName.setRenderer(new Renderer_ReportCard_StudentName_JComboBox());
    }

    @Override
    public void initModels() {
    }

    @Override
    public void initViewComponents() {
    }

    @Override
    public void initControllers() {
        jbtnCancel.addActionListener(new Controller_JButton_ExitJDialog(this));
        jtblReportCard.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 1 || e.getColumn() == 2 || e.getColumn() == 3 || e.getColumn() == 4) {
                    DefaultTableModel tableModel = (DefaultTableModel) jtblReportCard.getModel();
                    if (tableModel.getRowCount() > 0) {
                        for (int row = 0; row < tableModel.getRowCount(); row++) {
                            int sum = 0;
                            int divisor = 0;
                            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                                if (col == 1 || col == 2 || col == 3 || col == 4) {
                                    if (tableModel.getValueAt(row, col) != null) {
                                        sum += Integer.parseInt(tableModel.getValueAt(row, col).toString().trim());
                                        divisor++;
                                    }
                                }
                            }
                            if (divisor != 0) {
                                int finalGrade = sum / divisor;
                                tableModel.setValueAt(finalGrade, row, 5);
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void initDaoImpl() {
        gradeDaoImpl = new GradeDaoImpl();
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        sectionDaoImpl = new SectionDaoImpl();
        subjectDaoImpl = new SubjectDaoImpl();
    }

    private void initForm() {
        DefaultComboBoxModel studentComboModel = new DefaultComboBoxModel();
        studentComboModel.addElement(student);
        jcmbStudentId.setModel(studentComboModel);
        jcmbStudentName.setModel(studentComboModel);

        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        DefaultComboBoxModel sectionComboModel = new DefaultComboBoxModel();
        Section section = sectionDaoImpl.getSectionOf(student, schoolYear);
        sectionComboModel.addElement(section);
        jcmbSection.setModel(sectionComboModel);

        DefaultComboBoxModel adviserComboModel = new DefaultComboBoxModel();
        adviserComboModel.addElement(section.getAdviser());
        jcmbAdviser.setModel(adviserComboModel);

        jcmbSession.setSelectedItem(section.getSectionSession().trim());

        DefaultComboBoxModel gradeLevelComboModel = new DefaultComboBoxModel();
        gradeLevelComboModel.addElement(section.getGradeLevel());
        jcmbGradeLevel.setModel(gradeLevelComboModel);

        List<Subject> subjects = subjectDaoImpl.getAllSubjectsByGradeLevelId(section.getGradeLevel().getGradeLevelId());
        DefaultTableModel tableModel = (DefaultTableModel) jtblReportCard.getModel();
        for (Subject s : subjects) {
            Object[] rowData = {s};
            tableModel.addRow(rowData);
        }
        jtblReportCard.setModel(tableModel);

        setGradesToCells();
    }

    private void setGradesToCells() {
        DefaultTableModel tableModel = (DefaultTableModel) jtblReportCard.getModel();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Subject subject = (Subject) tableModel.getValueAt(row, 0);
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                if (col == 1) {
                    int gradingPeriod = 1;
                    Grade grade = gradeDaoImpl.getGradeBySubjectGradingPeriodSchoolYearAndStudent(subject, gradingPeriod, schoolYear, student);
                    tableModel.setValueAt(grade.getValue(), row, col);
                } else if (col == 2) {
                    int gradingPeriod = 2;
                    Grade grade = gradeDaoImpl.getGradeBySubjectGradingPeriodSchoolYearAndStudent(subject, gradingPeriod, schoolYear, student);
                    tableModel.setValueAt(grade.getValue(), row, col);
                } else if (col == 3) {
                    int gradingPeriod = 3;
                    Grade grade = gradeDaoImpl.getGradeBySubjectGradingPeriodSchoolYearAndStudent(subject, gradingPeriod, schoolYear, student);
                    tableModel.setValueAt(grade.getValue(), row, col);
                } else if (col == 4) {
                    int gradingPeriod = 4;
                    Grade grade = gradeDaoImpl.getGradeBySubjectGradingPeriodSchoolYearAndStudent(subject, gradingPeriod, schoolYear, student);
                    tableModel.setValueAt(grade.getValue(), row, col);
                }
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_toppanel = new javax.swing.JPanel();
        panel_details1 = new javax.swing.JPanel();
        lbl_name2 = new javax.swing.JLabel();
        jcmbStudentId = new javax.swing.JComboBox<>();
        lbl_name9 = new javax.swing.JLabel();
        jcmbGradeLevel = new javax.swing.JComboBox<>();
        lbl_name10 = new javax.swing.JLabel();
        lbl_name11 = new javax.swing.JLabel();
        jcmbSection = new javax.swing.JComboBox<>();
        jcmbStudentName = new javax.swing.JComboBox<>();
        lbl_name16 = new javax.swing.JLabel();
        jcmbAdviser = new javax.swing.JComboBox<>();
        lbl_name17 = new javax.swing.JLabel();
        jcmbSession = new javax.swing.JComboBox<>();
        panel_footer = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        jbtnRefresh = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        panel_gradingTable = new javax.swing.JPanel();
        panel_gradingtop = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblReportCard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Report Card");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(804, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_toppanel.setMinimumSize(new java.awt.Dimension(800, 700));
        panel_toppanel.setLayout(new java.awt.GridBagLayout());

        panel_details1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_details1.setMinimumSize(new java.awt.Dimension(795, 90));
        panel_details1.setPreferredSize(new java.awt.Dimension(795, 90));
        panel_details1.setLayout(new java.awt.GridBagLayout());

        lbl_name2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name2.setText("Student No :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name2, gridBagConstraints);

        jcmbStudentId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbStudentId.setEnabled(false);
        jcmbStudentId.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbStudentId.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbStudentId, gridBagConstraints);

        lbl_name9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name9.setText("Grade Level :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name9, gridBagConstraints);

        jcmbGradeLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbGradeLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        jcmbGradeLevel.setSelectedIndex(-1);
        jcmbGradeLevel.setEnabled(false);
        jcmbGradeLevel.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbGradeLevel.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbGradeLevel, gridBagConstraints);

        lbl_name10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name10.setText("Student Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name10, gridBagConstraints);

        lbl_name11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name11.setText("Section :");
        lbl_name11.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name11, gridBagConstraints);

        jcmbSection.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSection.setEnabled(false);
        jcmbSection.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbSection.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbSection, gridBagConstraints);

        jcmbStudentName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbStudentName.setEnabled(false);
        jcmbStudentName.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbStudentName.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbStudentName, gridBagConstraints);

        lbl_name16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name16.setText("Adviser :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name16, gridBagConstraints);

        jcmbAdviser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbAdviser.setEnabled(false);
        jcmbAdviser.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbAdviser.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbAdviser, gridBagConstraints);

        lbl_name17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name17.setText("Session :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(lbl_name17, gridBagConstraints);

        jcmbSession.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcmbSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM", "WD" }));
        jcmbSession.setSelectedIndex(-1);
        jcmbSession.setEnabled(false);
        jcmbSession.setMinimumSize(new java.awt.Dimension(150, 25));
        jcmbSession.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_details1.add(jcmbSession, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel_toppanel.add(panel_details1, gridBagConstraints);

        panel_footer.setMinimumSize(new java.awt.Dimension(795, 30));
        panel_footer.setPreferredSize(new java.awt.Dimension(795, 30));
        panel_footer.setLayout(new java.awt.GridBagLayout());

        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancel.setText("Cancel");
        jbtnCancel.setMaximumSize(new java.awt.Dimension(69, 40));
        jbtnCancel.setMinimumSize(new java.awt.Dimension(100, 30));
        jbtnCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnCancel, gridBagConstraints);

        jbtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setMaximumSize(new java.awt.Dimension(59, 40));
        jbtnSave.setMinimumSize(new java.awt.Dimension(100, 30));
        jbtnSave.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnSave, gridBagConstraints);

        jbtnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRefresh.setText("Refresh");
        jbtnRefresh.setMinimumSize(new java.awt.Dimension(100, 30));
        jbtnRefresh.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnRefresh, gridBagConstraints);

        jbtnPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPrint.setText("Print");
        jbtnPrint.setMinimumSize(new java.awt.Dimension(100, 30));
        jbtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_footer.add(jbtnPrint, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_toppanel.add(panel_footer, gridBagConstraints);

        panel_gradingTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grading Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel_gradingTable.setMinimumSize(new java.awt.Dimension(795, 480));
        panel_gradingTable.setPreferredSize(new java.awt.Dimension(795, 480));
        panel_gradingTable.setLayout(new java.awt.GridBagLayout());

        panel_gradingtop.setMinimumSize(new java.awt.Dimension(780, 455));
        panel_gradingtop.setPreferredSize(new java.awt.Dimension(780, 455));
        panel_gradingtop.setLayout(new java.awt.GridBagLayout());

        jtblReportCard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblReportCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter", "Final Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblReportCard.setRowHeight(35);
        jtblReportCard.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblReportCard);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_gradingtop.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        panel_gradingTable.add(panel_gradingtop, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel_toppanel.add(panel_gradingTable, gridBagConstraints);

        jScrollPane1.setViewportView(panel_toppanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<String> jcmbAdviser;
    private javax.swing.JComboBox<String> jcmbGradeLevel;
    private javax.swing.JComboBox<String> jcmbSection;
    private javax.swing.JComboBox<String> jcmbSession;
    private javax.swing.JComboBox<String> jcmbStudentId;
    private javax.swing.JComboBox<String> jcmbStudentName;
    private javax.swing.JTable jtblReportCard;
    private javax.swing.JLabel lbl_name10;
    private javax.swing.JLabel lbl_name11;
    private javax.swing.JLabel lbl_name16;
    private javax.swing.JLabel lbl_name17;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JLabel lbl_name9;
    private javax.swing.JPanel panel_details1;
    private javax.swing.JPanel panel_footer;
    private javax.swing.JPanel panel_gradingTable;
    private javax.swing.JPanel panel_gradingtop;
    private javax.swing.JPanel panel_toppanel;
    // End of variables declaration//GEN-END:variables
}
