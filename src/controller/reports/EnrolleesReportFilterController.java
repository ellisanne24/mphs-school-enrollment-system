package controller.reports;

import daoimpl.GradeLevelDaoImpl;
import daoimpl.ReportsDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.enrolleesreport.EnrolleesReport;

/**
 *
 * @author John Ferdinand Antonio
 */
public class EnrolleesReportFilterController implements ItemListener {

    private final JLabel jlblEnrolleesSchoolYearText;
    private final JLabel jlblEnrolleesGradeLevelText;
    private final JComboBox jcmbEnrolleesSchoolYearFrom;
    private final JComboBox jcmbEnrolleesSchoolYearTo;
    private final JComboBox jcmbEnrolleesGradeLevel;
    private final JTable jtblEnrollees;
    private final JCheckBox jcbShowAll;

    public EnrolleesReportFilterController(
            JComboBox jcmbEnrolleesSchoolYearFrom, JComboBox jcmbEnrolleesSchoolYearTo,
            JComboBox jcmbEnrolleesGradeLevel, JTable jtblEnrollees,
            JLabel jlblEnrolleesSchoolYearText, JLabel jlblEnrolleesGradeLevelText, JCheckBox jcbShowAll) {
        this.jcmbEnrolleesSchoolYearFrom = jcmbEnrolleesSchoolYearFrom;
        this.jcmbEnrolleesSchoolYearTo = jcmbEnrolleesSchoolYearTo;
        this.jcmbEnrolleesGradeLevel = jcmbEnrolleesGradeLevel;
        this.jtblEnrollees = jtblEnrollees;
        this.jlblEnrolleesGradeLevelText = jlblEnrolleesGradeLevelText;
        this.jlblEnrolleesSchoolYearText = jlblEnrolleesSchoolYearText;
        this.jcbShowAll = jcbShowAll;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        jcmbEnrolleesSchoolYearTo.setSelectedIndex(jcmbEnrolleesSchoolYearFrom.getSelectedIndex());
        GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
        SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();
        ReportsDaoImpl rdi = new ReportsDaoImpl();
        if (e.getSource() == jcmbEnrolleesSchoolYearFrom || e.getSource() == jcmbEnrolleesGradeLevel) {
            DefaultTableModel tableModel = (DefaultTableModel) jtblEnrollees.getModel();
            if (jcmbEnrolleesSchoolYearFrom.getSelectedIndex() > -1 && jcmbEnrolleesGradeLevel.getSelectedIndex() == -1) {
                jlblEnrolleesGradeLevelText.setText("(Showing all)");
                jlblEnrolleesSchoolYearText.setText(jcmbEnrolleesSchoolYearFrom.getSelectedItem().toString().trim());
                int schoolyear = Integer.parseInt(jcmbEnrolleesSchoolYearFrom.getSelectedItem().toString().trim());
                int schoolYearId = sydi.getId(schoolyear);
                List<EnrolleesReport> list = rdi.getAllEnrollees(schoolYearId);
                tableModel.setRowCount(0);
                for (EnrolleesReport er : list) {
                    tableModel.addRow(new Object[]{
                        er.getGradelevel() == 0 ? "Kindergarten" : "Grade " + er.getGradelevel(),
                        er.getStudentId(),
                        er.getStudentLastName() + ", " + er.getStudentFirstName() + ", " + er.getStudentMiddleName(),
                        er.getDateOfEnrollment(),
                        er.isIsWithdrawn() == false ? "No" : "Yes"
                    });
                }
                jtblEnrollees.setModel(tableModel);
            } else if (jcmbEnrolleesSchoolYearFrom.getSelectedIndex() > -1 && jcmbEnrolleesGradeLevel.getSelectedIndex() > -1) {
                jlblEnrolleesGradeLevelText.setText(
                        jcmbEnrolleesGradeLevel.getSelectedItem().toString().equals("0")
                        ? "Kindergarten" : "Grade " + jcmbEnrolleesGradeLevel.getSelectedItem().toString());
                jlblEnrolleesSchoolYearText.setText(jcmbEnrolleesSchoolYearFrom.getSelectedItem().toString().trim());
                int schoolyear = Integer.parseInt(jcmbEnrolleesSchoolYearFrom.getSelectedItem().toString().trim());
                int schoolYearId = sydi.getId(schoolyear);
                int gradeLevel = Integer.parseInt(jcmbEnrolleesGradeLevel.getSelectedItem().toString());
                int gradeLevelId = gldi.getId(gradeLevel);
                List<EnrolleesReport> list = rdi.getAllEnrollees(schoolYearId, gradeLevelId);
                tableModel.setRowCount(0);
                for (EnrolleesReport er : list) {
                    tableModel.addRow(new Object[]{
                        er.getGradelevel() == 0 ? "Kindergarten" : "Grade " + er.getGradelevel(),
                        er.getStudentId(),
                        er.getStudentLastName() + ", " + er.getStudentFirstName() + ", " + er.getStudentMiddleName(),
                        er.getDateOfEnrollment(),
                        er.isIsWithdrawn() == false ? "No" : "Yes"
                    });
                }
            }
        } else if (e.getSource() == jcbShowAll) {
            if (jcbShowAll.isSelected() == true) {
                jcmbEnrolleesGradeLevel.setSelectedItem(null);
                jcmbEnrolleesSchoolYearFrom.setSelectedItem(null);
                jlblEnrolleesGradeLevelText.setText("(All Grade Levels)");
                jlblEnrolleesSchoolYearText.setText("(All School Years)");
                List<EnrolleesReport> list = rdi.getAllEnrollees();
                DefaultTableModel tableModel = (DefaultTableModel) jtblEnrollees.getModel();
                tableModel.setRowCount(0);
                for (EnrolleesReport er : list) {
                    tableModel.addRow(new Object[]{
                        er.getGradelevel() == 0 ? "Kindergarten" : "Grade " + er.getGradelevel(),
                        er.getStudentId(),
                        er.getStudentLastName() + ", " + er.getStudentFirstName() + ", " + er.getStudentMiddleName(),
                        er.getDateOfEnrollment(),
                        er.isIsWithdrawn() == false ? "No" : "Yes"
                    });
                }
            }
        }

    }

}
