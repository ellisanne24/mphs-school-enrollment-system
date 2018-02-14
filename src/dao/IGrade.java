
package dao;

import java.util.List;
import model.grade.Grade;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.subject.Subject;



/**
 *
 * @author John Ferdinand Antonio
 */
public interface IGrade {
    boolean addStudentGrades(List<Grade> gradeList);
    List<Grade> getGradesByStudentSubjectAndSchoolYear(Student student, Subject subject, SchoolYear schoolYear);
    Grade getGradeByStudentGradingPeriodAndSchoolYear(Student student, int gradingPeriod, SchoolYear schoolYear);
    Grade getGradeBySubjectGradingPeriodSchoolYearAndStudent(Subject subject, int gradingPeriod, SchoolYear schoolYear,Student student);
}
