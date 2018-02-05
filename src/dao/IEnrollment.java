package dao;

import java.util.List;
import model.student.Student;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IEnrollment {
    
    boolean enroll(Student student);
    List<Student> getAllEnrolledBySchoolYearId(int schoolYearId);
    List<Student> getAllEnrolledBySchoolYearIdAndGradeLevelId(int schoolyearId, int gradelevelId);
    List<Student> getAllEnrolledUnsectionedByGradeLevelIdAndSchoolYearId(int gradelevelId, int schoolYearId);
}
