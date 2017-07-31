package model.section;

import java.util.List;
import model.faculty.Faculty;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.session.Session;
import model.student.Student;

public class Section {

    private int sectionId;
    private int sectionCategoryId;
    private String sectionName;
    private List<Session> sessionList; //AM or PM or BOTH AM and PM
    private List<Student> students;
    private int isActive;
    private String dateCreated;
//    private SchoolYear schoolYear;
//    private GradeLevel gradeLevel;
    private Faculty adviser;
    private String requiredAverage;
    private String category;

    public SchoolYear schoolYear = new SchoolYear();
    public GradeLevel gradeLevel = new GradeLevel();
    public Session session = new Session();
    public Grade grade = new Grade();
    public Faculty faculty = new Faculty();
    public Student student = new Student();

    public Faculty getAdviser() {
        return adviser;
    }

    public void setAdviser(Faculty adviser) {
        this.adviser = adviser;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public void setRequiredAverage(String requiredAverage) {
        this.requiredAverage = requiredAverage;
    }

    public String getRequiredAverage() {
        return requiredAverage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setSectionCategoryId(int sectionCategoryId) {
        this.sectionCategoryId = sectionCategoryId;
    }

    public int getSectionCategoryId() {
        return sectionCategoryId;
    }
}
