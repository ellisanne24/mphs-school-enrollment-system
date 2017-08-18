/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.curriculum.Curriculum;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.subject.Subject;

public interface ICurriculum {
    List<Subject> getCurriculumSubjects();
    GradeLevel getCurriculumGradeLevel();
    SchoolYear getCurriculumSchoolYear();
    List<Subject> getAllSubjectForCurriculum();
    boolean createCurriculum(Curriculum aCurriculum, SchoolYear aSchoolYear, GradeLevel aGradeLevel);
    boolean createCurriculumSubjects(Curriculum aCurriculum, Subject aSubject, GradeLevel aGradeLevel);
    boolean curriculumExists(Curriculum aCurriculum); // to check for duplicates
    boolean checkCurriculumExists(Curriculum aCurriculum, SchoolYear aSchoolYear);
    boolean checkCurriculumSubjectExists(Curriculum aCurriculum);
    int getCurriculumId(Curriculum aCurriculum);    
    List<Curriculum> getAllCurriculum();
    List<Curriculum> getEachCurriculum(Curriculum aCurriculum, SchoolYear aSchoolYear);
    List<SchoolYear> getCurriculumYearStartEndByGradeLevel(GradeLevel aGradeLevel);
    List<Curriculum> getAllCurriculumByStartYear(SchoolYear aSchoolYear);
    List<Curriculum> getAllSubjectsOfCurriculumByName(Curriculum aCurriculum);
    List<Curriculum> getCreatedCurriculumById(Curriculum aCurriculum);
    List<Curriculum> getAllCreatedCurriculumInfo();
    List<Curriculum> getAllCurriculumNameByGradeLevel(GradeLevel aGradeLevel);
    List<Curriculum> checkCurriculumChanges(Curriculum aCurriculum);
    void deleteCurriculumById(Curriculum aCurriculum);
    boolean updateCurriculumById(Curriculum aCurriculum, SchoolYear aSchoolYear);
    boolean updateSubjectIsAddedById(Subject aSubject);
}
