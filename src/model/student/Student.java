
package model.student;

import model.tuitionfee.TuitionFee;
import java.util.Date;
import model.admission.Admission;
import model.gradelevel.GradeLevel;
import model.gradelevel.CurrentGradeLevel;
import model.gradelevel.PromotedGradeLevel;
import model.registration.Registration;
import model.schoolyear.SchoolYear;


public class Student {
    private Integer studentId;
    private int studentType; 
    private Registration registration;
    private Admission admission;
    private GradeLevel admissionGradeLevel;
    private PromotedGradeLevel promotedGradeLevel;
    private SchoolYear schoolYearEnrolled;
    private CurrentGradeLevel currentGradeLevel;
    private GradeLevel recommendedGradeLevelToEnroll;
    private GradeLevel lastGradeLevelEnrolled;
    private SchoolYear lastGradeLevelEnrolledSchoolYear;
    private boolean isActive;
    private boolean isGraduated;
    private boolean isNew;
    private Date entryDate;
    private Date dateGraduated;
    private TuitionFee tuitionFee;

    private String firstName;
    private String lastName;
    private String middleName;
    public GradeLevel gradeLevel;

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    
    
    public TuitionFee getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(TuitionFee tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
    
    public GradeLevel getRecommendedGradeLevelToEnroll() {
        return recommendedGradeLevelToEnroll;
    }

    public void setRecommendedGradeLevelToEnroll(GradeLevel recommendedGradeLevelToEnroll) {
        this.recommendedGradeLevelToEnroll = recommendedGradeLevelToEnroll;
    }
    
    public int getStudentType() {
        return studentType;
    }

    public void setStudentType(int studentType) {
        this.studentType = studentType;
    }

    public GradeLevel getAdmissionGradeLevel() {
        return admissionGradeLevel;
    }

    public void setAdmissionGradeLevel(GradeLevel admissionGradeLevel) {
        this.admissionGradeLevel = admissionGradeLevel;
    }

    public PromotedGradeLevel getPromotedGradeLevel() {
        return promotedGradeLevel;
    }

    public void setPromotedGradeLevel(PromotedGradeLevel promotedGradeLevel) {
        this.promotedGradeLevel = promotedGradeLevel;
    }

    public GradeLevel getLastGradeLevelEnrolled() {
        return lastGradeLevelEnrolled;
    }

    public void setLastGradeLevelEnrolled(GradeLevel lastGradeLevelEnrolled) {
        this.lastGradeLevelEnrolled = lastGradeLevelEnrolled;
    }

    public SchoolYear getSchoolYearEnrolled() {
        return schoolYearEnrolled;
    }

    public void setSchoolYearEnrolled(SchoolYear schoolYearEnrolled) {
        this.schoolYearEnrolled = schoolYearEnrolled;
    }
    
    public SchoolYear getLastGradeLevelEnrolledSchoolYear() {
        return lastGradeLevelEnrolledSchoolYear;
    }

    public void setLastGradeLevelEnrolledSchoolYear(SchoolYear lastGradeLevelEnrolledSchoolYear) {
        this.lastGradeLevelEnrolledSchoolYear = lastGradeLevelEnrolledSchoolYear;
    }

    
    public CurrentGradeLevel getCurrentGradeLevel() {
        return currentGradeLevel;
    }

    public void setCurrentGradeLevel(CurrentGradeLevel currentGradeLevel) {
        this.currentGradeLevel = currentGradeLevel;
    }

    
    
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDateGraduated() {
        return dateGraduated;
    }

    public void setDateGraduated(Date dateGraduated) {
        this.dateGraduated = dateGraduated;
    }
    
        
}
