package dao;



import java.util.List;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;




public interface ISection{
    Section getSectionByStudentId(int aStudentId);
    boolean hasSchedule(Integer sectionId, Integer schoolYearId);
    List<Section> getAllSections();
    Integer getSectionIdByName(String aSectionName);
    boolean createSectionSettings(Section aSection, SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession, Faculty aFaculty);
    List<Section> getAllSectionsByGradeLevelId(GradeLevel aGradeLevel);
    List<Student> getAllStudentsBySection(Session aSession, Section aSection, GradeLevel aGradeLevel);
    
    boolean createSection(Section aSection);
    boolean createStudentSection(Section aSection, Student aStudent, SchoolYear aSchoolYear);
    int getSectionId(Section aSection);
    int getSectionSchoolYearId(Section aSection);
    List<Section> getCreatedSectionById(Section aSection);
    double getSectionAverageBySectionId(Section aSection);
    List<Section> getAllStudentsByGradeLevelId(GradeLevel aGradeLevel);
    List<Student> getAllStudentBySectionId(Section aSection,SchoolYear schoolYear);
    List getSessionIdBySectionId(Section aSection);
    List<Section> getAllSectionNameByGradeLevelId(GradeLevel aGradeLevel);
    List<Section> getAllAddedStudentBySectionId(GradeLevel aGradeLevel, Section aSection);
    boolean deleteStudentSectionById(Section aSection);
    boolean updateSectionName(Section aSection);
    boolean updateSectionSettingsById(SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession, Faculty aFaculty, Section aSection);
}