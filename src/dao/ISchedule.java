
package dao;

import java.util.List;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ISchedule {
    
    boolean add(List<Schedule> schedule);
    List<Schedule> getAllSchedulesBySchoolYearFacultyAndStatus(int schoolYearId, int facultyId, boolean isSchedActive);
    List<Schedule> getSchedulesByWildCardSchoolYearIdAndStatus(String aWildCardChar, int schoolYearId, boolean isActive);
    List<Schedule> getSchedulesByDaySchoolYearAndStatus(String day, int schoolyearId, boolean isActive);
}
