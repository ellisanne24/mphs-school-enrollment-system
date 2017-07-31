 
package dao;
import java.util.List;
import model.faculty.Faculty;

public interface IFaculty {
    List<Faculty>getAll();
    int getIdByName(String lastName, String firstName, String middleName);
    boolean add(Faculty aFaculty);
    boolean update(Faculty aFaculty);
    List<Faculty> getById(int aFacultyID); 
}
