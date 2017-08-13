/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.faculty.Faculty;
import model.student.Student;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;



/**
 *
 * @author John Ferdinand Antonio
 */
public interface IGrade {
    boolean createStudentGrade(Grade grade);
    boolean promoteStudentById(Grade aGrade, GradeLevel gradeLevel, Student aStudent, SchoolYear aSchoolYear);
    List <Grade> getAllStudentRemarksByGradeLevelId(GradeLevel gradeLevel, SchoolYear aSchoolYear);
    List <Grade> getAllPromotedBySchoolYearId(SchoolYear aSchoolYear);
    List <Grade> getAllPromotedStudent(SchoolYear aSchoolYear);
    List <Grade> getAllSummerStudent();
    List <Grade> getAllStudentGradeByStudentId(Student aStudent);
    double getAllStudentGradeGWAByStudentId(Student aStudent);
    void deleteGradeByStudentId(Grade grade);
    List <Grade> getAllStudentByAdviserSectionId(Faculty aFaculty, SchoolYear aSchoolYear);
    List <Grade> getStudentGradeByFacultyStudentId(Faculty aFaculty, Student aStudent);
}
