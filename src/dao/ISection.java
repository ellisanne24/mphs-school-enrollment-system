package dao;



import java.util.List;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;




public interface ISection{
    boolean addSection(Section aSection);
    List<Section> getSectionsBySchoolYear(int aSchoolYearId);
    List<Section> getSectionsByGradeLevel(int aGradeLevelId);
    List<Section> getSectionsBySchoolYearAndGradeLevel(int aSchoolYearId, int aGradeLevelId);
    List<Student> getSectionStudents(int aSectionId);
    List<Section> getAllSections();
    Integer getSectionIdByName(String aSectionName);
    boolean createSectionSettings(Section aSection, SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession);
    List<Section> getAllSectionsByGradeLevelId(GradeLevel aGradeLevel);
    List<Student> getAllStudentsBySection(Session aSession, Section aSection, GradeLevel aGradeLevel);
    
    boolean createStudentSection(Section aSection, Student aStudent, SchoolYear aSchoolYear);
    int getSectionId(Section aSection);
    int getSectionSchoolYearId(Section aSection);
    List<Section> getCreatedSectionById(Section aSection);
    List<Section> getAllNewStudentsByGradeLevelId(GradeLevel aGradeLevel);
    double getSectionAverageBySectionId(Section aSection);
    List<Section> getAllOldStudentsByGradeLevelId(GradeLevel aGradeLevel);
}