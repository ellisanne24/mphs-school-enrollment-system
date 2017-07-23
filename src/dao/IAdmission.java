
package dao;

import model.admission.Admission;

/**
 *
 * @author Acer
 */
public interface IAdmission {
    Admission getAdmissionInfoByRegistrationId(int aRegistrationId);
    Admission getAdmissionInfoByStudentId(int aStudentId);
    boolean completeAdmission(Admission admission);
}
