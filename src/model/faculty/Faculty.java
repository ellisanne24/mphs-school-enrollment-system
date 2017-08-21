package model.faculty;

import java.util.List;
import model.specialization.Specialization;

public class Faculty {

    private int facultyID;
    private List<Specialization> specializations;
    private String fullName;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String contact;
    private String emailAddress;
    private String degree;
    private boolean status;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setStatus(boolean status) {
        this.status = status;
        return this.status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
