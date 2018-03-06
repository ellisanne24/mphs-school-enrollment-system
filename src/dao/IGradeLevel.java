
package dao;

import java.util.List;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;

/**
 *
 * @author Jordan
 */
public interface IGradeLevel {
    int getId(int level);
    int getId(GradeLevel gradeLevel);
    GradeLevel getById(int gradeLevelId);
    
    List<GradeLevel> getSummerGradeLevelsOf(SchoolYear schoolYear);
    List<GradeLevel> getAllGradeLevelsInfo();
    List<GradeLevel> getAllActiveGradeLevels();
}
