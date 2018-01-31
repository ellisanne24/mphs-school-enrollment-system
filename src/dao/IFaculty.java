 
package dao;

import java.util.List;
import model.faculty.Faculty;
import model.subjectcategory.SubjectCategory;

public interface IFaculty {
    void createFaculty(Faculty faculty);
    List <Faculty> getFacultyByName(Faculty faculty);
    List <Faculty> getFacultyInfoById(Faculty faculty);
    int countFacultySpecialization(Faculty faculty);
    void createFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory);
    void deleteFacultySpecialization(Faculty faculty);
    List <SubjectCategory> loadFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory);
    void updateFaculty(Faculty faculty);
    List getAllFaculty(Faculty faculty);
}
