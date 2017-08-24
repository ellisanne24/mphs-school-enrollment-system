package daoimpl;

import dao.IUser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.role.Role;
import model.user.User;
import utility.database.DBType;
import utility.database.DBUtil;

public class UserDaoImpl implements IUser{

    @Override
    public Integer getAdviserIdByUserId(int userId) {
        Integer adviser_id = null;
        String SQL = "{CALL getAdviserIdByUserId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, userId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    adviser_id = rs.getInt("user_id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adviser_id;
    }

    
    
    @Override
    public Integer getIdByUsername(String username) {
        Integer userId = null;
        String SQL = "{CALL getUserIdByUserName(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setString(1,username);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    userId = rs.getInt("user_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }
    
    @Override
    public User getById(int userId) {
        User user = new User();
        Role role = new Role();
        String SQLa = "{CALL getUserById(?)}";
        String SQLb = "{CALL getRoleByUserId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement csa = con.prepareCall(SQLa);
                CallableStatement csb = con.prepareCall(SQLb);) {
            csa.setInt(1,userId);
            csb.setInt(1,userId);
            try (ResultSet rsa = csa.executeQuery();) {
                while (rsa.next()) {
                    user.setDateCreated(rsa.getDate("dateCreated"));
                    user.setFirstName(rsa.getString("firstname"));
                    user.setId(rsa.getInt("user_id"));
                    user.setIsActive(rsa.getBoolean("isActive"));
                    user.setIsLocked(rsa.getBoolean("isLocked"));
                    user.setLastLoginDate(rsa.getTimestamp("lastLoginDate"));
                    user.setLastName(rsa.getString("lastname"));
                    user.setMiddleName(rsa.getString("middlename"));
                    user.setPassword("password");
                }
            }
            try(ResultSet rsb = csb.executeQuery();){
                while(rsb.next()){
                    role.setId(rsb.getInt("role_id"));
                    role.setRoleName(rsb.getString("role"));
                    role.setIsActive(rsb.getBoolean("isActive"));
                    user.setRole(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String SQL = "{CALL getAllUserInfo()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    User u = new User();
                    u.setFirstName(rs.getString("firstname"));
                    u.setMiddleName(rs.getString("middlename"));
                    u.setLastName(rs.getString("lastname"));
                    u.setUsername(rs.getString("username"));
                    u.setId(rs.getInt("user_id"));
                    Role role = new Role();
                    int roleId = rs.getInt("role_id");
                    String roleName = rs.getString("role");
                    role.setId(roleId);
                    role.setRoleName(roleName);
                    u.setRole(role);
                    
                    userList.add(u);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    
    
    @Override
    public boolean add(User user) {
        boolean isAdded = false;
        String SQLa = "{CALL addUser(?,?,?,?,?,?)}";
        String SQLb = "{CALL addUserRole(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);){
            con.setAutoCommit(false);
            try(CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);){
            csa.setString(1, user.getUsername());
            csa.setString(2, user.getPassword());
            csa.setString(3, user.getLastName().trim());
            csa.setString(4, user.getFirstName().trim());
            csa.setString(5, user.getMiddleName().trim());
            csa.registerOutParameter(6, Types.INTEGER);
            csa.executeUpdate();
            int userId = csa.getInt(6);
            
            csb.setInt(1,userId);
            csb.setInt(2, user.getRole().getId());
            csb.executeUpdate();
            
            con.commit();
            isAdded = true;
            }catch(SQLException e ){
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdated = false;
        String SQL = "{CALL updateUser(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,user.getId());
            cs.setString(2, user.getUsername());
            cs.setString(3, user.getPassword());
            cs.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}
