
package model.student;

import model.tuitionfee.Tuition;
import java.util.Date;
import model.admission.Admission;
import model.gradelevel.GradeLevel;
import model.paymentterm.PaymentTerm;
import model.registration.Registration;


public class Student {
    private int studentId;
    private int studentNo;
    private int studentType; 
    private Registration registration;
    private Admission admission;
    private PaymentTerm paymentTerm;
    private boolean exists;
    private boolean isActive;
    private boolean isGraduated;
    private Date entryDate;
    private Date dateGraduated;
    private Tuition tuitionFee;

    public int gradeLevelNo; //current gradelevelNo

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    
    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
    
    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }
    
    public int getGradeLevelNo() {
        return gradeLevelNo;
    }

    public void setGradeLevelNo(int gradeLevel) {
        this.gradeLevelNo = gradeLevel;
    }
    
    public Tuition getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Tuition tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
    
    public int getStudentType() {
        return studentType;
    }

    public void setStudentType(int studentType) {
        this.studentType = studentType;
    }

    public int getStudentId() {
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
