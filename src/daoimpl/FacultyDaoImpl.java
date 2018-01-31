
package daoimpl;

import dao.IFaculty;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.faculty.Faculty;
import model.subjectcategory.SubjectCategory;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author Jordan
 */
public class FacultyDaoImpl implements IFaculty{
    
    
    @Override
    public void createFaculty(Faculty faculty) {
        String select = "{call checkFacultyExist(?,?,?,?)}";
        String create = "{call addFaculty(?,?,?,?,?)}";
        String result = "";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
            CallableStatement cs1 = con.prepareCall(create);
            
            cs.setString(1, faculty.getLastName());
            cs.setString(2, faculty.getFirstName());
            cs.setString(3, faculty.getMiddleName());
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            
            cs.executeUpdate();
            
            result = cs.getString(4);
            
            if(!result.equals("Duplicate")){
                cs1.setString(1, faculty.getFirstName());
                cs1.setString(2, faculty.getLastName());
                cs1.setString(3, faculty.getMiddleName());
                cs1.setString(4, faculty.getEmail());
                cs1.setString(5, faculty.getContactNo());
                
                cs1.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Successful!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Faculty already exist!");
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
    }

    @Override
    public List<Faculty> getFacultyByName(Faculty faculty) {
        List <Faculty> list = new ArrayList<Faculty>();
        String select = "{call getFacultyByName(?)}";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
            
            cs.setString(1, faculty.getLastName());
            
            try(ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    
                    faculty = new Faculty();
                    faculty.setFacultyID(rs.getInt(1));
                    faculty.setLastName(rs.getString(2));
                    faculty.setFirstName(rs.getString(3));
                    faculty.setMiddleName(rs.getString(4));
                    faculty.setContactNo(rs.getString(5));
                    faculty.setEmail(rs.getString(6));
                    faculty.setStatus(rs.getBoolean(7));
                    
                    list.add(faculty);
                }
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
        return list;
    }

    @Override
    public List<Faculty> getFacultyInfoById(Faculty faculty) {
        List <Faculty> list = new ArrayList<Faculty>();
        String select = "{call getFacultyInfoById(?)}";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
        
            cs.setInt(1, faculty.getFacultyID());
            
            try(ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    
                    faculty = new Faculty();
                    faculty.setLastName(rs.getString(1));
                    faculty.setFirstName(rs.getString(2));
                    faculty.setMiddleName(rs.getString(3));
                    faculty.setContactNo(rs.getString(4));
                    faculty.setEmail(rs.getString(5));
                    faculty.setStatus(rs.getBoolean(6));
                    
                    list.add(faculty);
                }
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
        return list;
    }
    
    @Override
    public int countFacultySpecialization(Faculty faculty) {
        String select = "{call countFacultySpecialization(?,?)}";
        int count = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
            
            cs.setInt(1, faculty.getFacultyID());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.executeUpdate();
            
            count = cs.getInt(2);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
        return count;
    }
    
    @Override
    public void createFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory) {
        String add = "{call addFacultyAndSpecialization(?,?)}";
        
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(add);
        
            
            cs.setInt(1, faculty.getFacultyID());
            cs.setInt(2, subjectCategory.getSubjectCategoryId());
                
            cs.executeUpdate();
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
    }

    @Override
    public void deleteFacultySpecialization(Faculty faculty) {
        String delete = "{call deleteFacultySpecialization(?)}";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(delete);
        
            
            cs.setInt(1, faculty.getFacultyID());
                
            cs.executeUpdate();
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
    }

    @Override
    public List<SubjectCategory> loadFacultySpecialization(Faculty faculty, SubjectCategory subjectCategory) {
        List <SubjectCategory> list = new ArrayList<SubjectCategory>();
        String select = "{call loadFacultySpecialization(?)}";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
        
            cs.setInt(1, faculty.getFacultyID());
             
            try(ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    subjectCategory = new SubjectCategory();
                    
                    subjectCategory.setSubjectCategoryId(rs.getInt(1));
                    subjectCategory.setSubjectCategoryName(rs.getString(2));
                    subjectCategory.setDescription(rs.getString(3));
                    subjectCategory.setIsActive(rs.getBoolean(4));
                    
                    list.add(subjectCategory);
                }
            }
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
        return list;
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        String update = "{call updateFaculty(?,?,?,?,?,?,?)}";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(update);
        
            cs.setInt(1, faculty.getFacultyID());
            cs.setString(2, faculty.getLastName());
            cs.setString(3, faculty.getFirstName());
            cs.setString(4, faculty.getMiddleName());
            cs.setString(5, faculty.getContactNo());
            cs.setString(6, faculty.getEmail());
            cs.setBoolean(7, faculty.isStatus());
            
            cs.executeUpdate();
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
    }

    @Override
    public List <Faculty> getAllFaculty(Faculty faculty) {
        String select = "{call getAllFaculty()}";
        List <Faculty> list = new ArrayList<Faculty>();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);){
            CallableStatement cs = con.prepareCall(select);
            
            try(ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    faculty = new Faculty();
                   
                    faculty.setFacultyID(rs.getInt(1));
                    faculty.setLastName(rs.getString(2));
                    faculty.setFirstName(rs.getString(3));
                    faculty.setMiddleName(rs.getString(4));
                    faculty.setContactNo(rs.getString(5));
                    faculty.setEmail(rs.getString(6));
                    faculty.setStatus(rs.getBoolean(7));
                    
                    list.add(faculty);
                }
            }
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + e.getMessage());
        }
        
        return list;
    }
}
