
package dao;

import java.util.List;
import model.schoolyear.SchoolYear;
import model.quarter.Quarter;

/**
 *
 * @author Acer
 */
public interface IQuarter {
    List<Quarter> getAllQuarters();
    Quarter getCurrentQuarterOf(SchoolYear schoolYear);
    List<Quarter> getQuarterBySchoolYear(SchoolYear aSchoolYear);
    boolean addQuarter(Quarter aQuarter);
}
