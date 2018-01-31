
package model.subject;

import java.util.Date;
import model.gradelevel.GradeLevel;

public class Subject {
    private int subjectId;
    private String subjectTitle;
    private String subjectCode;
    private String subjectDescription;
    private String addedBy;
    private double subjectHours;
    private double totalHours;
    private Date dateAdded;
    private Date dateCreated;
    private boolean isActive;
    
    private GradeLevel gradeLevel;

    public boolean isIsActive() {
        return isActive;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public void setSubjectHours(double subjectHours)
    {
        this.subjectHours = subjectHours;
    }
    
    public double getSubjectHours()
    {
        return subjectHours;
    }
    
    private void setTotalHours(double totalHours)
    {
        this.totalHours = totalHours;
    }
    
    public double getTotalHours()
    {
        return totalHours;
    }
}
