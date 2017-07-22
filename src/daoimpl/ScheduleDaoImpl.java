
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
import model.schedule.Schedule;


public class ScheduleDaoImpl implements ISchedule{

    SbjDaoImpl sbjDaoImpl = new SbjDaoImpl();
    RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
    SectionDaoImpl sectionDaoImpl = new SectionDaoImpl();

    @Override
    public boolean assignFaculty(Schedule schedule) {
        boolean isAssigned = false;
        String SQL = "{CALL assignScheduleToFaculty(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, schedule.getScheduleId());
            cs.setInt(2, schedule.getFaculty().getFacultyID());
            System.out.println(schedule.getFaculty().getFacultyID());
            cs.executeUpdate();
            isAssigned = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAssigned;
    }
    
    
    
    @Override
    public boolean add(List<Schedule> scheduleList) {
        boolean isAdded = false;
        String SQL = "{CALL addSchedule(?,?,?,?,?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);

            try (CallableStatement cs = con.prepareCall(SQL);) {
                for (Schedule s : scheduleList) {
                    Schedule schedule = (Schedule) s;
                    cs.setString(1, schedule.getDay());
                    cs.setInt(2, schedule.getStartTime());
                    cs.setInt(3, schedule.getEndTime());
                    cs.setInt(4, schedule.getSchoolYearId());
                    cs.setInt(5, sbjDaoImpl.getId(schedule.getSubjectName().trim()));
                    cs.setInt(6, sectionDaoImpl.getSectionIdByName(schedule.getSectionName().trim()));
                    cs.setInt(7, roomDaoImpl.getId(schedule.getRoomName().trim()));
                    cs.executeUpdate();
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
                    Schedule s = new Schedule();
                    s.setScheduleId(rs.getInt("schedule_id"));
                    s.setDay(rs.getString("schedule_day"));
                    s.setStartTime(rs.getInt("startTime"));
                    s.setEndTime(rs.getInt("endTime"));
                    s.setRoomName(rs.getString("room_name_or_num"));
                    s.setSectionName(rs.getString("sectionName"));
                    s.setSubjectName(rs.getString("title"));
                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
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
                    Schedule s = new Schedule();
                    s.setScheduleId(rs.getInt("schedule_id"));
                    s.setDay(rs.getString("schedule_day"));
                    s.setStartTime(rs.getInt("startTime"));
                    s.setEndTime(rs.getInt("endTime"));
                    s.setRoomName(rs.getString("room_name_or_num"));
                    s.setSectionName(rs.getString("sectionName"));
                    s.setSubjectName(rs.getString("title"));
                    s.setSchoolYearId(rs.getInt("schoolyear_id"));
                    scheduleList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }
    
    
}
