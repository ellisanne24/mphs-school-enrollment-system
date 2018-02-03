package dao;

import java.util.List;
import model.enrollment.Enrollment;
import model.schoolyear.SchoolYear;
import model.student.Student;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IEnrollment {
    
    boolean enroll(Student student);
    List<Student> getAllEnrolledBySchoolYearId(int schoolYearId);
}
