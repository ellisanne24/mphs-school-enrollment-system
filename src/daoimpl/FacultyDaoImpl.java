package daoimpl;

import dao.IFaculty;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.faculty.Faculty;
import model.role.Role;
import model.section.Section;
import model.specialization.Specialization;
import model.user.User;
import utility.database.DBType;
import utility.database.DBUtil;

public class FacultyDaoImpl implements IFaculty {

    @Override
    public List<Section> getAllFacultySectionByFacultyId(User user) 
    {
        String sql = "call getAllFacultySectionByFacultyId(?)";

        List<Section> list = new ArrayList();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, user.getId());

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Section section = new Section();

                    section.setSectionName(rs.getString("sectionName"));

                    list.add(section);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error at getAllFacultySectionByFacultyId" + ex);
        }

        return list;
    }
    
    @Override
    public int getIdByName(String lastName, String firstName, String middleName) {
        Integer facultyId = null;
        String SQL = "{CALL `getFacultyIdByName`(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1, lastName.trim());
            cs.setString(2,firstName.trim());
            cs.setString(3, middleName.trim());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    facultyId = rs.getInt("faculty_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facultyId;
    }
    
    @Override
    public List<Faculty> getById(int aFacultyID) {
        List<Faculty> list = new ArrayList();
        String SQL = "{CALL getFacultyBySpecializationID(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, aFacultyID);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Faculty aFaculty = new Faculty();
                    aFaculty.setFacultyID(rs.getInt("faculty_id"));
                    aFaculty.setFirstName(rs.getString("firstName"));
                    aFaculty.setLastName(rs.getString("lastName"));
                    aFaculty.setMiddleName(rs.getString("middleName"));
                    aFaculty.setEmailAddress(rs.getString("email"));
                    aFaculty.setContact(rs.getString("contact"));
                    aFaculty.setDegree(rs.getString("degree"));
                    list.add(aFaculty);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Faculty> getAll() {

        List<Faculty> list = new ArrayList();
        String SQL = "{CALL getFacultyAndSpecialization()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Faculty faculty = new Faculty();
                    faculty.setFacultyID(rs.getInt("faculty_ID"));
                    faculty.setFirstName(rs.getString("firstName"));
                    faculty.setLastName(rs.getString("lastName"));
                    faculty.setMiddleName(rs.getString("middleName"));
                    faculty.setContact(rs.getString("contact"));
                    faculty.setEmailAddress(rs.getString("email"));
                    faculty.setDegree(rs.getString("degree"));
                    faculty.setStatus(rs.getBoolean("Status"));
                    list.add(faculty);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    

    @Override
    public boolean add(Faculty faculty) {
        boolean isAdded = false;
        String SQl_addFaculty = "{CALL addFaculty(?,?,?,?,?,?,?)}";
        String SQL_addFacultyAndSpecialization = "{CALL addFacultyandSpecialization(?,?)}";
        String SQL_addFacultyAsUser = "{CALL addUser(?,?,?,?,?,?)}";
        String SQL_addUserRole = "{CALL addUserRole(?,?)}";
        
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csA = con.prepareCall(SQl_addFaculty);
                    CallableStatement csB = con.prepareCall(SQL_addFacultyAndSpecialization);
                    CallableStatement csC = con.prepareCall(SQL_addFacultyAsUser);
                    CallableStatement csD = con.prepareCall(SQL_addUserRole);) {
                csA.setString(1, faculty.getFirstName());
                csA.setString(2, faculty.getLastName());
                csA.setString(3, faculty.getMiddleName());
                csA.setString(4, faculty.getEmailAddress());
                csA.setString(5, faculty.getContact());
                csA.setString(6, faculty.getDegree());
                csA.registerOutParameter(7, Types.INTEGER);
                csA.executeUpdate();
                int facultyId = csA.getInt(7);

                List<Specialization> specializations = faculty.getSpecializations();
                for (Specialization s : specializations) {
                    csB.setInt(1, facultyId);
                    csB.setInt(2, s.getId());
                    csB.executeUpdate();
                }
                
                RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
                int roleId = roleDaoImpl.getId("Faculty");
                Role role = new Role();
                role.setId(roleId);
                
                UserDaoImpl userDaoImpl = new UserDaoImpl();
                User user = new User();
                user.setRole(role);
                user.setFirstName(faculty.getFirstName());
                user.setMiddleName(faculty.getMiddleName());
                user.setLastName(faculty.getLastName());
                user.setPassword("facultymember");
                user.setUsername(faculty.getFirstName().toLowerCase()+""+faculty.getLastName().toLowerCase());
                
                csC.setString(1, user.getUsername());
                csC.setString(2, user.getPassword());
                csC.setString(3, user.getLastName().trim());
                csC.setString(4, user.getFirstName().trim());
                csC.setString(5, user.getMiddleName().trim());
                csC.registerOutParameter(6, Types.INTEGER);
                csC.executeUpdate();
                int userId = csC.getInt(6);
                
                csD.setInt(1, userId);
                csD.setInt(2, user.getRole().getId());
                csD.executeUpdate();
                
                con.commit();
                isAdded = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            isAdded = false;
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean update(Faculty aFaculty) {

        boolean isUpdated;
        String SQl = "{CALL updateFaculty(?,?,?,?,?,?,?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQl);) {

            cs.setInt(1, aFaculty.getFacultyID());
            cs.setString(2, aFaculty.getFirstName());
            cs.setString(3, aFaculty.getLastName());
            cs.setString(4, aFaculty.getMiddleName());
            cs.setString(5, aFaculty.getEmailAddress());
            cs.setString(6, aFaculty.getContact());
            cs.setString(8, aFaculty.getDegree());
            cs.setBoolean(9, aFaculty.getStatus());
            cs.executeUpdate();
            isUpdated = true;

        } catch (SQLException e) {
            isUpdated = false;
            e.printStackTrace();
        }
        return isUpdated;
    }
    
//    @Override
    public List<Section> getAllFacultySectionByFacultyId() 
    {
        String sql = "call getAllFacultySectionByFacultyId()";
        
        List <Section> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Section section = new Section();
                    
                    section.setSectionName(rs.getString("sectionName"));
                    
                    list.add(section);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllFacultySectionByFacultyId"+ex);
        }
        
        return list;
    }

    @Override
    public List<Faculty> getAllFaculty() 
    {
        List <Faculty> list = new ArrayList();
        String sql = "call getAllFaculty()";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Faculty faculty = new Faculty();
                    
                    faculty.setFirstName(rs.getString(1));
                    faculty.setMiddleName(rs.getString(2));
                    faculty.setLastName(rs.getString(3));
                    
                    list.add(faculty);
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error at getAllFaculty "+ex);
        }
        return list;
    }

    @Override
    public int getFacultyId(Faculty aFaculty) 
    {
        String sql = "call getFacultyId(?)";
        int id = 0;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setString(1, aFaculty.getFullName());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    id = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error at getAllFaculty "+ex);
        }
        return id;
    }
    
    

}
