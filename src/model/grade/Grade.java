/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grade;


import model.gradelevel.GradeLevel;
import model.gradingperiod.GradingPeriod;
import model.schoolyear.SchoolYear;
import model.student.Student;
import model.subject.Subject;

/**
 *
 * @author John Ferdinand Antonio
 */
public class Grade {
    private int id;
    private int periodId;
    private String first_qtr;
    private String second_qtr;
    private String third_qtr;
    private String fourth_qtr;
    private double finalGrade;
    private double gwa;
    private String grade;
    private boolean isPassed;
    private boolean isActive;
    private boolean isSubmitted;
    private String coreValues;
    private String behavior;
    public Subject subject = new Subject();
    public Student student = new Student();
    public SchoolYear schoolYear = new SchoolYear();
    public GradeLevel gradeLevel = new GradeLevel();
    public GradingPeriod gradingPeriod = new GradingPeriod();
//    public Attendance attendance = new Attendance();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstQtr() {
        return first_qtr;
    }

    public void setFirstQtr(String first_qtr) {
        this.first_qtr = first_qtr;
    }

    public String getSecondQtr() {
        return second_qtr;
    }

    public void setSecondQtr(String second_qtr) {
        this.second_qtr = second_qtr;
    }

    public String getThirdQtr() {
        return third_qtr;
    }

    public void setThirdQtr(String third_qtr) {
        this.third_qtr = third_qtr;
    }

    public String getFourthQtr() {
        return fourth_qtr;
    }

    public void setFourthQtr(String fourth_qtr) {
        this.fourth_qtr = fourth_qtr;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public double getGwa() {
        return gwa;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }
    
    public void setIsPassed(boolean isPassed)
    {
        this.isPassed = isPassed;
    }
    
    public boolean getIsPassed()
    {
        return isPassed;
    }
    
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }
    
    public boolean getIsActive()
    {
        return isActive;
    }
    
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
    public String getGrade()
    {
        return grade;
    }
    
    public void setPeriodId(int periodId)
    {
        this.periodId = periodId;
    }
    
    public int getPeriodId()
    {
        return periodId;
    }
    
    public void setIsSubmitted(boolean isSubmitted)
    {
        this.isSubmitted = isSubmitted;
    }
    
    public boolean getIsSubmitted()
    {
        return isSubmitted;
    }

    public String getCoreValues() {
        return coreValues;
    }

    public void setCoreValues(String coreValues) {
        this.coreValues = coreValues;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
