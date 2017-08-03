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
import model.section.Section;
import model.specialization.Specialization;
import utility.database.DBType;
import utility.database.DBUtil;

public class FacultyDaoImpl implements IFaculty {

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

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement cs1 = con.prepareCall(SQl_addFaculty);
                    CallableStatement cs2 = con.prepareCall(SQL_addFacultyAndSpecialization);) {
                cs1.setString(1, faculty.getFirstName());
                cs1.setString(2, faculty.getLastName());
                cs1.setString(3, faculty.getMiddleName());
                cs1.setString(4, faculty.getEmailAddress());
                cs1.setString(5, faculty.getContact());
                cs1.setString(6, faculty.getDegree());
                cs1.registerOutParameter(7, Types.INTEGER);
                cs1.executeUpdate();
                int facultyId = cs1.getInt(7);

                List<Specialization> specializations = faculty.getSpecializations();
                for (Specialization s : specializations) {
                    cs2.setInt(1, facultyId);
                    cs2.setInt(2, s.getId());
                    cs2.executeUpdate();
                }
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
    
    @Override
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

}
