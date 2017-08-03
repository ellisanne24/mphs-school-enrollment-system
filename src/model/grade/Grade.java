/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grade;

import java.util.Date;
import model.gradelevel.GradeLevel;
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
    private double first_qtr;
    private double second_qtr;
    private double third_qtr;
    private double fourth_qtr;
    private double finalGrade;
    private double gwa;
    private double grade;
    private boolean isPassed;
    private boolean isActive;
    
    public Subject subject = new Subject();
    public Student student = new Student();
    public SchoolYear schoolYear = new SchoolYear();
    public GradeLevel gradeLevel = new GradeLevel();
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFirstQtr() {
        return first_qtr;
    }

    public void setFirsQtr(double first_qtr) {
        this.first_qtr = first_qtr;
    }

    public double getSecondQtr() {
        return second_qtr;
    }

    public void setSecondQtr(double second_qtr) {
        this.second_qtr = second_qtr;
    }

    public double getThirdQtr() {
        return third_qtr;
    }

    public void setThirdQtr(double third_qtr) {
        this.third_qtr = third_qtr;
    }

    public double getFourthQtr() {
        return fourth_qtr;
    }

    public void setFourthQtr(double fourth_qtr) {
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
    
    public void setGrade(double grade)
    {
        this.grade = grade;
    }
    
    public double getGrade()
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
}
