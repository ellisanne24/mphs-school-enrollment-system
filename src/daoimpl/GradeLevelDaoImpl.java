package daoimpl;

import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.gradelevel.GradeLevel;
import dao.IGradeLevel;
import model.student.Student;

/**
 *
 * GradeLevelDaoImpl class serves as base class for GradeLevelDaoImpl entity / object
 * @author Antonio, John Ferdinand
 */
public class GradeLevelDaoImpl implements IGradeLevel{

    @Override
    public int getId(int level) {
        int gradeLevelId = 0;
        String SQL = "{CALL getGradeLevelId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, level);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    gradeLevelId = rs.getInt("gradelevel_id");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"getGradeLevelId()\n"+e.getMessage());
        }
        return gradeLevelId;
    }

    @Override
    public List<GradeLevel> getAllGradeLevelsInfo() {
        List<GradeLevel> gradeLevelList = new ArrayList();
        String SQL = "{CALL getAllGradeLevelsInfo()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setGradeLevelID(rs.getInt("gradelevel_id"));
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    gradeLevel.setIsActive(rs.getBoolean("isActive"));
                    gradeLevelList.add(gradeLevel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeLevelList;
    }

    @Override
    public List<GradeLevel> getAllActiveGradeLevels() {
        List<GradeLevel> list = new ArrayList<>();
        String SQL = "{CALL getAllActiveGradeLevels()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setGradeLevelID(rs.getInt("gradelevel_id"));
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    gradeLevel.setIsActive(rs.getBoolean("isActive"));
                    list.add(gradeLevel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<GradeLevel> getAllInactiveGradeLevels() {
        List<GradeLevel> list = new ArrayList<>();
        String SQL = "{CALL getAllInActiveGradeLevels()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setGradeLevelID(rs.getInt("gradelevel_id"));
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    gradeLevel.setIsActive(rs.getBoolean("isActive"));
                    list.add(gradeLevel);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"getAllInactiveGradeLevels()\n"+e.getMessage());
        }
        return list;
    }

    @Override
    public int getId(GradeLevel gradelevel) {
        int gradeLevelId = 0;
        String SQL = "{CALL getGradeLevelId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, gradelevel.getLevelNo());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    gradeLevelId = rs.getInt("gradelevel_id");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"getGradeLevelId()\n"+e.getMessage());
        }
        return gradeLevelId;
    }

    @Override
    public GradeLevel getById(int gradeLevelId) {
        GradeLevel gradeLevel = new GradeLevel();
        String SQL = "{CALL getGradeLevelById(?)}";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, gradeLevelId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                   gradeLevel.setGradeLevelID(rs.getInt("gradelevel_id"));
                   gradeLevel.setLevelNo(rs.getInt("grade_level"));
                   gradeLevel.setIsActive(rs.getBoolean("isActive"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeLevel;
    }

    @Override
    public boolean addGradeLevel(GradeLevel gradelevel) {
        boolean isAdded = false;
        String SQL = "{CALL addGradeLevel(?)}";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, gradelevel.getLevelNo());
            isAdded = cs.executeUpdate() == 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"addGradeLevel()\n"+e.getMessage());
        }
        return isAdded;
    }

    @Override
    public boolean isGradeLevelActive(GradeLevel gradelevel) {
        boolean isActive = false;
        String SQL = "{isGradeLevelActive(?)}";
       
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, gradelevel.getLevelNo());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    isActive = rs.getInt("isActive")==1;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"isGradeLevelActive()\n"+e.getMessage());
        }
        return isActive;
    }

    @Override
    public boolean deactivateGradeLevel(GradeLevel gradelevel) {
        boolean isDeactivated = false;
        String SQL = "{CALL deactivateGradeLevel(?)}";
        int gradeLevelId = gradelevel.getGradeLevelId();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, gradeLevelId);
            isDeactivated = cs.executeUpdate() == 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"deactivateGradeLevel()\n"+e.getMessage());
        }
        return isDeactivated;
    }

    @Override
    public List<GradeLevel> getAllRegisteredSubjectGradeLevel() {
        List<GradeLevel> list = new ArrayList();
        String sql = "{call getAllRegisteredSubjectGradeLevel()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    list.add(gradeLevel);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error " + ex);
        }
        return list;
    }

    @Override
    public List<Student> getStudentNameByGradeLevelId(GradeLevel aGradeLevel) {
        String sql = "{call getStudentNameByGradeLevelId(?)}";
        List <Student> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGradeLevel.getGradeLevelId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Student student = new Student();
                    
//                    student.setFirstName(rs.getString("firstname"));
//                    student.setMiddleName(rs.getString("middlename"));
//                    student.setLastName(rs.getString("lastname"));
                    
                    list.add(student);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getStudentNameByGradeLevelId "+ex);
        }
        
        return list;
    }

  
    
    
}
