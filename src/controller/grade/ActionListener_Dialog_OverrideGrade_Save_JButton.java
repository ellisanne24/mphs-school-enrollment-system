package controller.grade;

import daoimpl.GradeDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.subject.Subject;
import model.user.User;
import view.grades.View_Dialog_OverrideGrading;

/**
 *
 * @author Jordan
 */
public class ActionListener_Dialog_OverrideGrade_Save_JButton implements ActionListener {

    private final View_Dialog_OverrideGrading view;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final GradeDaoImpl gradeDaoImpl;
    private final User user;

    public ActionListener_Dialog_OverrideGrade_Save_JButton(View_Dialog_OverrideGrading view, User user) {
        this.view = view;
        this.user = user;
        schoolYearDaoImpl = new SchoolYearDaoImpl();
        gradeDaoImpl = new GradeDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getJtblGradingSheet().getModel();
        Subject subject = (Subject) view.getJcmbSubjectCode().getSelectedItem();
        SchoolYear schoolYear = schoolYearDaoImpl.getCurrentSchoolYear();
        List<Grade> gradeList = new ArrayList<>();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Student student = new Student();
            student.setStudentId(Integer.parseInt(tableModel.getValueAt(row, 0).toString().trim()));
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                if (tableModel.getValueAt(row, col) != null) {
                    if (col == 3 || col == 4 || col == 5 || col == 6) {
                        Grade grade = new Grade();
                        grade.setStudentId(student.getStudentId());
                        grade.setSchoolYear(schoolYear);
                        grade.setSubjectId(subject.getSubjectId());
                        grade.setGradingPeriod(col - 2);//1st,2nd,3rd,4th 
                        grade.setGradeType("R");
                        grade.setValue(Integer.parseInt(tableModel.getValueAt(row, col).toString().trim()));
                        grade.setAddedBy(user);
                        gradeList.add(grade);
                    }
                }
            }
        }

        int choice = JOptionPane.showConfirmDialog(null, "Add Grades?", "Save Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            boolean isSuccessful = gradeDaoImpl.addStudentGrades(gradeList);
            if (isFormValid()) {
                if (isSuccessful) {
                    JOptionPane.showMessageDialog(null, "Successfully saved grades.");
                } else {
                    JOptionPane.showMessageDialog(null, "Encountered problems while adding grades. Please contact your support.");
                }
            }

        }
    }

    private boolean isFormValid() {
        boolean isValid = true;
        for (int row = 0; row < view.getJtblGradingSheet().getRowCount(); row++) {
            for (int col = 0; col < view.getJtblGradingSheet().getColumnCount(); col++) {
                if (col == 3 || col == 4 || col == 5 || col == 6) {
                    int value = Integer.parseInt(view.getJtblGradingSheet().getValueAt(row, col).toString().trim());
                    if (value > 100) {
                        isValid = isValid && false;
                        JOptionPane.showMessageDialog(null, "Grade values should not exceed 100");
                    }
                }
            }
        }
        return isValid;
    }

}
