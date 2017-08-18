 
package dao;
import java.util.List;
import model.faculty.Faculty;
import model.section.Section;

public interface IFaculty {
    
    int getIdByName(String lastName, String firstName, String middleName);
    int getFacultyId(Faculty aFaculty);
    int getFacultyIdByUserId(int pUserId);
    
    boolean add(Faculty aFaculty);
    boolean update(Faculty aFaculty);
    
    List<Faculty>getAll();
    List<Faculty> getAllFaculty();
    List<Faculty> getById(int pFacultyId); 
    List<Section> getAllFacultySectionByFacultyId(Faculty pFaculty);
    List<Faculty> getAllFacultyByAdviserId(Faculty pFaculty);
}
