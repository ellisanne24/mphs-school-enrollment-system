
package dao;

import java.util.List;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.student.Student;

/**
 *
 * @author Jordan
 */
public interface IPromotion {
    boolean promoteStudents(List<Student> studentsPromoted);
    boolean areAllStudentGradePerSubjectSubmitted(Student student, SchoolYear schoolYear, GradeLevel gradeLevel);
}
