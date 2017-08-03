/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;



/**
 *
 * @author John Ferdinand Antonio
 */
public interface IGrade {
    boolean createStudentGrade(Grade grade);
    boolean promoteStudentById(Grade aGrade, GradeLevel gradeLeve);
    List <Grade> getAllStudentGradeByGradeLevelId(GradeLevel gradeLevel, SchoolYear aSchoolYear);
    List <Grade> getAllPromotedBySchoolYearId(SchoolYear aSchoolYear);
    List <Grade> getAllPromotedStudent();
}
