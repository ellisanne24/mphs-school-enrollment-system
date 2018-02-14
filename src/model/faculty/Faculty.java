package model.faculty;

import java.util.List;
import model.subjectcategory.SubjectCategory;
import model.user.User;

public class Faculty extends User{

    private int facultyID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String contactNo;
    private String email;
    private boolean status;
    private boolean isAdviser;
    private boolean hasAmAdvisory;
    private boolean hasPmAdvisory;
    private List<SubjectCategory> subjectCategories;

    public boolean isIsAdviser() {
        return isAdviser;
    }

    public void setIsAdviser(boolean isAdviser) {
        this.isAdviser = isAdviser;
    }

    public boolean isHasAmAdvisory() {
        return hasAmAdvisory;
    }

    public void setHasAmAdvisory(boolean hasAmAdvisory) {
        this.hasAmAdvisory = hasAmAdvisory;
    }

    public boolean isHasPmAdvisory() {
        return hasPmAdvisory;
    }

    public void setHasPmAdvisory(boolean hasPmAdvisory) {
        this.hasPmAdvisory = hasPmAdvisory;
    }
    
    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<SubjectCategory> getSubjectCategories() {
        return subjectCategories;
    }

    public void setSubjectCategories(List<SubjectCategory> subjectCategories) {
        this.subjectCategories = subjectCategories;
    }
    
}
