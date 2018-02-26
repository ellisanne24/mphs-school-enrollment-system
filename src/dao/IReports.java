
package dao;

import java.util.List;
import model.schedule.Schedule;
import model.schoolyear.SchoolYear;
import model.student.Student;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface IReports {
   
    Student getCOROf(int studentNo, SchoolYear schoolYear);
}
