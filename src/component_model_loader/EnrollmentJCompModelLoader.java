
package component_model_loader;

import daoimpl.EnrollmentDaoImpl;
import daoimpl.SchoolYearDaoImpl;
import java.util.List;
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

    public EnrollmentJCompModelLoader(EnrollmentDaoImpl enrollmentDaoImpl) {
        this.enrollmentDaoImpl = enrollmentDaoImpl;
    }
    
    public DefaultTableModel getAllEnrolledOfCurrentSchoolYear(JTable t){
        DefaultTableModel tableModel = (DefaultTableModel) t.getModel();
        tableModel.setRowCount(0);
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        int currentSchoolYearId = schoolYearDaoImpl.getCurrentSchoolYearId();
        List<Student> studentList = enrollmentDaoImpl.getAllEnrolledBySchoolYearId(currentSchoolYearId);
        for(Student s : studentList){
            Registration r = s.getRegistration();
            Enrollment e = s.getEnrollment();
            Object[] rowData = {
                s.getStudentId(), s.getStudentNo(), r.getLastName(), r.getFirstName(), r.getMiddleName(),
                s.getStudentType() == 1 ? "New" : "Old",
                s.getGradeLevelNo(), "--section--", "--adviser--", s.isActive() == true ? "Active" : "Inactive",
                e.getEnrollmentDate(), e.getEnrollmentType().equalsIgnoreCase("R")? "Regular" : "Summer"
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
