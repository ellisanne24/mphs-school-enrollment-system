
package daoimpl;

import dao.ISchedule;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.org.objectweb.asm.Type;
import model.faculty.Faculty;
import model.schedule.Schedule;


public class ScheduleDaoImpl implements ISchedule{

    SbjDaoImpl sbjDaoImpl = new SbjDaoImpl();
    RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
    SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();

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
                    s.setScheduleId(rs.getInt("schedule_id"));
                    s.setDay(rs.getString("schedule_day"));
                    s.setStartTime(rs.getInt("startTime"));
                    s.setEndTime(rs.getInt("endTime"));
                    s.setRoomName(rs.getString("room_name_or_num"));
                    s.setSectionName(rs.getString("sectionName"));
                    s.setSubjectName(rs.getString("title"));
                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
                    s.setFaculty(faculty);
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
        String SQLa = "{CALL addSchedule(?,?,?,?,?,?,?,?)}";
        String SQLb = "{CALL addScheduleToFaculty(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);

            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);) {
                for (Schedule schedule : scheduleList) {
                    Schedule s = (Schedule) schedule;
                    csa.setString(1, s.getDay());
                    csa.setInt(2, s.getStartTime());
                    csa.setInt(3, s.getEndTime());
                    csa.setInt(4, s.getSchoolYearId());
                    csa.setInt(5, sbjDaoImpl.getId(s.getSubjectName().trim()));
                    csa.setInt(6, sectionDaoImpl.getSectionIdByName(s.getSectionName().trim()));
                    csa.setInt(7, roomDaoImpl.getId(s.getRoomName().trim()));
                    csa.registerOutParameter(8, Type.INT);
                    csa.executeUpdate();
                    int scheduleId = csa.getInt(8);
                    
                    csb.setInt(1, s.getFaculty().getFacultyID());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean get(int gradeLevelId, int schoolYearId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Schedule> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    s.setScheduleId(rs.getInt("schedule_id"));
                    s.setDay(rs.getString("schedule_day"));
                    s.setStartTime(rs.getInt("startTime"));
                    s.setEndTime(rs.getInt("endTime"));
                    s.setRoomName(rs.getString("room_name_or_num"));
                    s.setSectionName(rs.getString("sectionName"));
                    s.setSubjectName(rs.getString("title"));
                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
                    s.setFaculty(faculty);
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
                    s.setScheduleId(rs.getInt("schedule_id"));
                    s.setDay(rs.getString("schedule_day"));
                    s.setStartTime(rs.getInt("startTime"));
                    s.setEndTime(rs.getInt("endTime"));
                    s.setRoomName(rs.getString("room_name_or_num"));
                    s.setSectionName(rs.getString("sectionName"));
                    s.setSubjectName(rs.getString("title"));
                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
                    s.setFaculty(faculty);
                    scheduleList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
    
    
}
