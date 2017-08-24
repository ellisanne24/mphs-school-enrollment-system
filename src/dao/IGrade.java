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
import model.section.Section;
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
    boolean updateGradeByStudentId(Grade grade);
    List <Grade> getAllStudentByAdviserId(Faculty aFaculty, SchoolYear aSchoolYear);
    List <Grade> getStudentGradeByAdviserStudentId(Faculty aFaculty, Student aStudent);
    List <Grade> getStudentFailedSubjectById(Student aStudent);
    boolean createStudentSummer(SchoolYear aSchoolYear, Student aStudent, GradeLevel gradeLevel, Subject aSubject, Grade aGrade);
    boolean promoteSummerStudentById(GradeLevel gradeLevel, Student aStudent, SchoolYear aSchoolYear);
    List <Grade> getAllStudentGradeBySectionId(Section aSection, Faculty aFaculty);
    boolean updateFinalGradeByStudentId(Grade aGrade);
    String getGradeLevelOfSectionId(Section aSection);
    String getAdviserSectionByAdviserId(Faculty aFaculty);
    int getCurrentPeriodBySubjectId(Grade aGrade);
    int getPeriodStatusByGradingPeriodId(Grade aGrade);
    boolean submitStudentGrade(Grade aGrade);
    int getCurrentPeriodOfCharacterBldng(Grade aGrade);
    int getPeriodStatusOfCharacterBldng(Grade aGrade);
    int countStudentGradeByGradingId(Grade aGrade);
    int countIsSubmittedByGradingId(Grade aGrade);
    boolean createStudentCharacter(Grade aGrade);
    int countCharSubmittedByGradingId(Grade aGrade);
    boolean createStudentAttendance(Grade aGrade);
    int countStudentAttendance(Grade aGrade);
    boolean submitStudentGradeGWA(Grade aGrade);
    boolean updateStudentAttendance(Grade aGrade);
    List <Grade> getCharBuildingByStudentId(Grade aGrade);
    List <Grade> getStudentAttendanceBySchoolDays(Grade aGrade);
    List <Grade> getReportCardByStudentId(Grade aGrade);
}
