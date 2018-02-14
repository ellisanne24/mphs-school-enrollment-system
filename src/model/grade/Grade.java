
package model.grade;

import java.util.Date;
import model.schoolyear.SchoolYear;
import model.user.User;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Grade {
   private int studentId;
   private int subjectId;
   private int gradeId;
   private int value;
   private int gradingPeriod;
   private String gradeType; //summer or regular
   private SchoolYear schoolYear;
   private Date dateSubmitted;
   private User addedBy;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
   
    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
   
   

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGradingPeriod() {
        return gradingPeriod;
    }

    public void setGradingPeriod(int gradingPeriod) {
        this.gradingPeriod = gradingPeriod;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }
    
   
}
