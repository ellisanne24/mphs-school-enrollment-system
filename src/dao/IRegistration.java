package dao;

import java.util.List;
import model.registration.Registration;

/**
 *
 * @author Acer
 */
public interface IRegistration {
    
    List<Registration> getAllRegistrationInfo();
    List<Registration> getAllRegistrationInfoByWildCard(String wildCardChar);
    List<Registration> getAllRegistrationInfoBySyYearFrom(int aSchoolYearYearFrom);
    List<Registration> getAllRegistrationInfoByAdmissionStatus(int admissionStatus);
    
    Registration getRegistrationInfoById(int registrationId);
    
    String getRegistrationPaymentTermByStudentId(Integer aStudentId);
    
    boolean addRegistration(Registration registration); //Register student
    boolean updateRegistration(Registration registration); // modify student registration info if necessary
    boolean deleteRegistration(Registration registration); 
    boolean isDuplicateRegistration(Registration registration);
}
