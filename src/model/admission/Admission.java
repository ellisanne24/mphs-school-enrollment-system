
package model.admission;

import java.util.Date;
import model.registration.Registration;
import model.schoolfees.SchoolFees;


public class Admission {
    private int studentId;
    private int schoolYearId;
    private int gradeLevelId;
    private int gradeLevel;
    private SchoolFees schoolFees;
    private int admissionId;
    private Registration registration;
    private boolean isCompleted;
    private Date completionDate;

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    

    public int getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(int gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public int getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(int schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public SchoolFees getSchoolFees() {
        return schoolFees;
    }

    public void setSchoolFees(SchoolFees schoolFees) {
        this.schoolFees = schoolFees;
    }
    
    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
    
    
}
