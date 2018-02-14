
package dao;

import java.util.List;
import model.faculty.Faculty;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;


public interface IStudent {
    List<Student> getStudentsBySectionAndSchoolYear(Section section, SchoolYear schoolYear);
    List<Student> getStudentsOfAdviser(Faculty faculty, SchoolYear schoolYear);
    Student getStudentByStudentId(int studentId);
    Student getStudentByStudentNo(int studentNo);
    boolean studentExist(int studentNo);
    boolean hasTuitionRecord(int studentNo, int schoolyearId);
}
