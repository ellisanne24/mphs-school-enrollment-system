
package daoimpl;

import dao.ISchedule;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.faculty.Faculty;
import model.schedule.Schedule;
import model.subject.Subject;


public class ScheduleDaoImpl implements ISchedule{

    SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
    SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();

    @Override
    public List<Schedule> getBySectionId(int sectionId) {
        List<Schedule> schedList = new ArrayList<>();
        String SQL = "{CALL getScheduleBySectionId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, sectionId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Schedule s = new Schedule();
//                    s.setScheduleId(sectionId);
//                    s.setDay(rs.getString("schedule_day"));
//                    s.setStartTime(rs.getInt("startTime"));
//                    s.setEndTime(rs.getInt("endTime"));
//                    s.setSubjectCode(rs.getString("code"));
//                    s.setRoomName(rs.getString("room_name_or_num"));
                    schedList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedList;
    }
    
    @Override
    public List<Schedule> getByFacultyId(int facultyId, int schoolYearId) {
        List<Schedule> scheduleList = new ArrayList<>();
        String SQL = "{CALL getScheduleByFacultyIdAndSchoolYearId(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,facultyId);
            cs.setInt(2,schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Faculty faculty = new Faculty();
                    faculty.setLastName(rs.getString("lastName"));
                    faculty.setFirstName(rs.getString("firstName"));
                    faculty.setMiddleName(rs.getString("middleName"));
                    faculty.setFacultyID(rs.getInt("faculty_id"));
                    
                    Schedule s = new Schedule();
//                    s.setScheduleId(rs.getInt("schedule_id"));
//                    s.setDay(rs.getString("schedule_day"));
//                    s.setStartTime(rs.getInt("startTime"));
//                    s.setEndTime(rs.getInt("endTime"));
//                    s.setRoomName(rs.getString("room_name_or_num"));
//                    s.setSectionName(rs.getString("sectionName"));
//                    s.setSubjectCode(rs.getString("title"));
//                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
//                    s.setFaculty(faculty);
                    scheduleList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
    
    @Override
    public boolean add(List<Schedule> scheduleList) {
        boolean isAdded = false;
        String SQLa = "{CALL addSchedule(?,?,?,?,?,?,?,?,?)}";
        String SQLb = "{CALL addScheduleToFaculty(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);

            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);) {
                for (Schedule schedule : scheduleList) {
                    Schedule s = (Schedule) schedule;
//                    csa.setString(1, s.getDay());
//                    csa.setInt(2, s.getStartTime());
//                    csa.setInt(3, s.getEndTime());
//                    csa.setInt(4, s.getSchoolYearId());

                    Subject subject = new Subject();
//                    subject.setSubjectCode(s.getSubjectCode());
                    csa.setInt(5, subjectDaoImpl.getSubjectId(subject));

//                    csa.setInt(6, sectionDaoImpl.getSectionIdByName(s.getSectionName().trim()));
//                    csa.setInt(7, roomDaoImpl.getRoomId(s.getRoomName().trim()));
//                    csa.setInt(8, s.getGradeLevelId());
                    csa.registerOutParameter(9, Types.INTEGER);
                    csa.executeUpdate();
                    int scheduleId = csa.getInt(9);

//                    csb.setInt(1, s.getFaculty().getFacultyID());
                    csb.setInt(2, scheduleId);
                    csb.executeUpdate();
                }
                con.commit();
                isAdded = true;
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean add(Schedule schedule) {
        boolean isAdded = false;
        return isAdded;
    }

    @Override
    public Schedule get(int gradeLevelId, int schoolYearId) {
        Schedule schedule = new Schedule();
        return schedule;
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> scheduleList = new ArrayList<>();
        return scheduleList;
    }

    @Override
    public List<Schedule> getAll(int schoolYearId) {
        List<Schedule> scheduleList = new ArrayList<>();
        String SQL = "{CALL getAllScheduleBySchoolYearId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1,schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Faculty faculty = new Faculty();
                    faculty.setLastName(rs.getString("lastName"));
                    faculty.setFirstName(rs.getString("firstName"));
                    faculty.setMiddleName(rs.getString("middleName"));
                    faculty.setFacultyID(rs.getInt("faculty_id"));
                    
                    Schedule s = new Schedule();
//                    s.setScheduleId(rs.getInt("schedule_id"));
//                    s.setDay(rs.getString("schedule_day"));
//                    s.setStartTime(rs.getInt("startTime"));
//                    s.setEndTime(rs.getInt("endTime"));
//                    s.setRoomName(rs.getString("room_name_or_num"));
//                    s.setSectionName(rs.getString("sectionName"));
//                    s.setSubjectCode(rs.getString("title"));
//                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
//                    s.setFaculty(faculty);
                    scheduleList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getAll(int subjectId, int schoolYearId) {
        List<Schedule> scheduleList = new ArrayList<>();
        String SQL = "{CALL getAllScheduleBySubjectIdAndSchoolYearId(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1,subjectId);
            cs.setInt(2,schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Faculty faculty = new Faculty();
                    faculty.setLastName(rs.getString("lastName"));
                    faculty.setFirstName(rs.getString("firstName"));
                    faculty.setMiddleName(rs.getString("middleName"));
                    faculty.setFacultyID(rs.getInt("faculty_id"));
                    
                    Schedule s = new Schedule();
//                    s.setScheduleId(rs.getInt("schedule_id"));
//                    s.setDay(rs.getString("schedule_day"));
//                    s.setStartTime(rs.getInt("startTime"));
//                    s.setEndTime(rs.getInt("endTime"));
//                    s.setRoomName(rs.getString("room_name_or_num"));
//                    s.setSectionName(rs.getString("sectionName"));
//                    s.setSubjectCode(rs.getString("title"));
//                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
//                    s.setFaculty(faculty);
                    scheduleList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
    
    
}
