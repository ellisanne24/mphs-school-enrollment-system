/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.fee.Fee;
import model.feecategory.FeeCategory;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;

/**
 *
 * @author Acer
 */
public interface IFee {
    List<String> getNames();

    List<Fee> getAll();

    List<Fee> getByGradeLevel(GradeLevel aGradeLevel);

    List<Fee> getFeesByGradeLevelAndCategory(GradeLevel aGradeLevel, FeeCategory aFeeCategory);

    List<Fee> getFeesBySchoolYear(SchoolYear aSchoolYear);

    List<Fee> getByCategory(String feeCategory);

    double getSumByGradeLevel(GradeLevel aGradeLevel);

    double getSumOfTuitionFeesByGradeLevelId(Integer aGradeLevelId);

    double getSumOfOtherFeesByGradeLevelId(Integer aGradeLevelId);

    double getSumOfMiscellaneousFeesByGradeLevelId(Integer aGradeLevelId);

    double getDownpaymentFeeByGradeLevel(GradeLevel aGradeLevel);

    List<GradeLevel> getGradeLevelAssignment(int aFeeId);
    
    Fee getById(int feeId);
    int getId(String feeName);
    boolean add(Fee fee);
    boolean update(Fee fee);
    boolean delete(int feeId);
    boolean exists(String feeName);
}
