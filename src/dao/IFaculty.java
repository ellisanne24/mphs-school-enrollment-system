 
package dao;
import java.util.List;
import model.faculty.Faculty;
import model.section.Section;
import model.user.User;

public interface IFaculty {
    List<Faculty>getAll();
    int getIdByName(String lastName, String firstName, String middleName);
    boolean add(Faculty aFaculty);
    boolean update(Faculty aFaculty);
    List<Faculty> getById(int aFacultyID); 
    List<Section> getAllFacultySectionByFacultyId(Faculty aFaculty);
    List<Faculty> getAllFaculty();
    int getFacultyId(Faculty aFaculty);
    List<Faculty> getAllFacultyByAdviserId(Faculty aFaculty);
}
