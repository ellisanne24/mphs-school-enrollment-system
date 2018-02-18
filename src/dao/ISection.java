package dao;



import java.util.List;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;




public interface ISection{
    /*
    Jordan's
    */
    
    boolean addSection(Section section);
    boolean addStudentsToSection(Section section);
    boolean updateSection(Section section);
    boolean sectionExists(String sectionName);
    Section getSectionById(int sectionId);
    List<Section> getAllSections();
    List<Section> getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId(boolean isActive, int schoolyearId);
    List<Section> getSectionsWithNoAssignedScheduleBy_Status_SchoolYearId_GradeLevelId(boolean isActive, int schoolyearId, int gradeLevelId);
    List<Section> getAllSectionsByStatusAndSchoolYearId(boolean status, int schoolYearId);
    List<Section> getSectionsByWildCard(String wildCardChar);
    List<Section> getSectionsByGradeLevelNoAndSchoolYearId(int gradeLevelNo, int schoolYearId);
    List<Student> getSectionStudentsBySectionIdAndSchoolYearId(Section section);
    List<Section> getNonAdvisorySectionsOfFaculty(Faculty faculty, SchoolYear schoolYear);
    List<Section> getAdvisorySectionsOfFaculty(Faculty faculty, SchoolYear schoolYear);
    List<Section> getSectionsByGradeLevelNoSectionTypeAndSchoolYear(GradeLevel gradeLevel, String sectionType, SchoolYear schoolYear);
    List<Section> getSectionsWithNoAssignedSchedBySchoolYearGradeLevelAndSectionType(SchoolYear sy, GradeLevel g, String sectionType);
    Section getSectionByStudentAndSchoolYear(Student student, SchoolYear schoolYear);
    /*
    End 
    */
}