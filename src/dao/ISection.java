package dao;



import java.util.List;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;




public interface ISection{
    /*
    Jordan's
    */
    
    boolean addSection(Section section);
    boolean updateSection(Section section);
    Section getSectionById(int sectionId);
    List<Section> getAllSections();
    List<Section> getSectionsByWildCard(String wildCardChar);
    List<Section> getSectionsByGradeLevelNo(int gradeLevelNo);
    
    /*
    End 
    */
}