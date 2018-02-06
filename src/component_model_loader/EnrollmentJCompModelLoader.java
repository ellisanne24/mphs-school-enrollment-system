package component_model_loader;

import daoimpl.EnrollmentDaoImpl;
import daoimpl.GradeLevelDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.enrollment.Enrollment;
import model.registration.Registration;
import model.student.Student;

/**
 *
 * @author Jordan
 */
public class EnrollmentJCompModelLoader {

    private final EnrollmentDaoImpl enrollmentDaoImpl;
    private final SchoolYearDaoImpl schoolYearDaoImpl;
    private final GradeLevelDaoImpl gradeLevelDaoImpl;

    public EnrollmentJCompModelLoader(EnrollmentDaoImpl enrollmentDaoImpl) {
        this.enrollmentDaoImpl = enrollmentDaoImpl;
        this.schoolYearDaoImpl = new SchoolYearDaoImpl();
        this.gradeLevelDaoImpl = new GradeLevelDaoImpl();
    }

    public DefaultTableModel getAllEnrolledOfCurrentSchoolYear(JTable t) {
        DefaultTableModel tableModel = (DefaultTableModel) t.getModel();
        tableModel.setRowCount(0);
        int currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        List<Student> studentList = enrollmentDaoImpl.getAllEnrolledBySchoolYearId(currentSchoolYearId);
        for (Student s : studentList) {
            Registration r = s.getRegistration();
            Enrollment e = s.getEnrollment();
            Object[] rowData = {
                s.getStudentId(), s.getStudentNo(), r.getLastName(), r.getFirstName(), r.getMiddleName(),
                s.getStudentType() == 1 ? "New" : "Old",
                s.getGradeLevelNo(), s.getSection().getSectionName(), 
                s.getSection().getAdviser().getLastName() +", "+ s.getSection().getAdviser().getFirstName() +" "+
                s.getSection().getAdviser().getMiddleName(),
                s.isActive() == true ? "Active" : "Inactive",
                e.getEnrollmentDate(), e.getEnrollmentType().equalsIgnoreCase("R") ? "Regular" : "Summer"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultTableModel getAllEnrolledOfCurrentSchoolYearByGradeLevel(JTable t, JComboBox jcmbGradeLevelFilter) {
        DefaultTableModel tableModel = (DefaultTableModel) t.getModel();
        tableModel.setRowCount(0);
        int currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        int gradeLevelId = gradeLevelDaoImpl.getId(Integer.parseInt(jcmbGradeLevelFilter.getSelectedItem().toString().trim()));
        List<Student> studentList = enrollmentDaoImpl.getAllEnrolledBySchoolYearIdAndGradeLevelId(currentSchoolYearId, gradeLevelId);
        for (Student s : studentList) {
            Registration r = s.getRegistration();
            Enrollment e = s.getEnrollment();
            Object[] rowData = {
                s.getStudentId(), s.getStudentNo(), r.getLastName(), r.getFirstName(), r.getMiddleName(),
                s.getStudentType() == 1 ? "New" : "Old",
                s.getGradeLevelNo(), "--section--", "--adviser--", s.isActive() == true ? "Active" : "Inactive",
                e.getEnrollmentDate(), e.getEnrollmentType().equalsIgnoreCase("R") ? "Regular" : "Summer"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public DefaultTableModel getAllEnrolledUnsectionedByGradeLevelIdAndSchoolYearId(JTable table, JComboBox jcmbGradeLevel, int schoolYearId) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int gradeLevelId = gradeLevelDaoImpl.getId(Integer.parseInt(jcmbGradeLevel.getSelectedItem().toString().trim()));
        List<Student> studentList = enrollmentDaoImpl.getAllEnrolledUnsectionedByGradeLevelIdAndSchoolYearId(gradeLevelId, schoolYearId);
        for (Student s : studentList) {
            Registration r = s.getRegistration();
            Enrollment e = s.getEnrollment();
            Object[] rowData = {
                s.getStudentId(), s.getStudentNo(), r.getLastName(), r.getFirstName(), r.getMiddleName(),
                s.getStudentType() == 1 ? "New" : "Old",
                s.getGradeLevelNo(), "--section--", "--adviser--", s.isActive() == true ? "Active" : "Inactive",
                e.getEnrollmentDate(), e.getEnrollmentType().equalsIgnoreCase("R") ? "Regular" : "Summer"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
