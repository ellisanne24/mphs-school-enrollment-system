
package dao;

import java.util.List;
import model.schedule.Schedule;

/**
 *
 * @author John Ferdinand Antonio
 */
public interface ISchedule {
    
    boolean add(List<Schedule> schedule);
    
    boolean add(Schedule schedule);

    boolean get(int gradeLevelId, int schoolYearId);

    List<Schedule> getAll();

    List<Schedule> getAll(int schoolYearId);
    
    List<Schedule> getAll(int subjectId , int schoolYearId);
    
    List<Schedule> getByFacultyId(int facultyId, int schoolYearId);
}
