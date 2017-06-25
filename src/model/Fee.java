/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.GradeLevel;
import model.SchoolYear;

/**
 *
 * @author Acer
 */
public class Fee {
    private int id;
    private String name;
    private double amount;
    private FeeCategory feeCategory; // miscellaneous, other, tuition, etc
    private GradeLevel gradeLevel;
    private List<GradeLevel> assignedGradeLevels;
    private SchoolYear schoolYear;
    private String description;
    private boolean isActive;
    private boolean exists;

    public boolean exists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public List<GradeLevel> getAssignedGradeLevels() {
        return assignedGradeLevels;
    }

    public void setAssignedGradeLevels(List<GradeLevel> assignedGradeLevels) {
        this.assignedGradeLevels = assignedGradeLevels;
    }
    
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    
    public FeeCategory getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(FeeCategory feeCategory) {
        this.feeCategory = feeCategory;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    
    
    
}
