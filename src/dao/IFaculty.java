 
package dao;

import java.util.List;
import model.faculty.Faculty;
import model.subjectcategory.SubjectCategory;

public interface IFaculty {
    boolean createFaculty(Faculty faculty);
    List <Faculty> getFacultyByName(Faculty faculty);
    List <Faculty> getFacultyInfoById(Faculty faculty);
    int countFacultySpecialization(Faculty faculty);
    void createFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory);
    void deleteFacultySpecialization(Faculty faculty);
    List <SubjectCategory> loadFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory);
    void updateFaculty(Faculty faculty);
    List getAllFaculty(Faculty faculty);
    
    // Jordan
    List<Faculty> getAllFacultyWithNoAdvisory();
    List<Faculty> getAllFaculty();
    List<Faculty> getAllFacultyByStatus(boolean isAtive);
    List<Faculty> getAllFacultyHandlingSubjectBySubjectCode(String subjectCode, int schoolyearId);
    int getFacultyIdByName(String lastName, String firstName, String middleName);
    Faculty getFacultyById(int facultyId);
}
