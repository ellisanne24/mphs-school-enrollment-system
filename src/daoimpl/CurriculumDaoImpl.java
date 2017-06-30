/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import constants.CurriculumTable;
import database_utility.DBType;
import database_utility.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curriculum;
import model.GradeLevel;
import model.SchoolYear;
import model.Subject;
import dao.ICurriculum;

/**
 *
 * @author Acer
 */
public class CurriculumDaoImpl implements ICurriculum {

    // HAS - A
    // HAS the ff classes
    GradeLevelDaoImpl gldi = new GradeLevelDaoImpl();
    SchoolYearDaoImpl sydi = new SchoolYearDaoImpl();

    @Override
    public int getCurriculumId(Curriculum aCurriculum) {
        int curriculumId = 0; //initial value
        int schoolYearId = sydi.getSchoolYearId(aCurriculum.getSchoolYear().getYearFrom());
        int gradelevelId = gldi.getId(aCurriculum.getGradeLevel());

        String SQL = "{CALL getCurriculumId(?,?)}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, gradelevelId);
            cs.setInt(2, schoolYearId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    curriculumId = rs.getInt(CurriculumTable.CURRICULUMID);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return curriculumId;
    }

    @Override
    public List<Subject> getCurriculumSubjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GradeLevel getCurriculumGradeLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SchoolYear getCurriculumSchoolYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCurriculum(Curriculum aCurriculum, SchoolYear aSchoolYear, GradeLevel aGradeLevel) 
    {
        boolean isSuccesful;
        String sql = "{call createCurriculumSubjects(?,?,?,?,?,?,?,?)}";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.setInt(2, aGradeLevel.getLevel());
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.setInt(4, aSchoolYear.getYearFrom());
            cs.setString(5, aCurriculum.getCurriculumDescription());
            cs.setInt(6, aCurriculum.getIsActive());
            cs.setString(7, aCurriculum.getDateCreated());
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            cs.executeUpdate();
            //Returning curriculum id.. Execute update should call first if you wanted to get the id after insert.
//            System.out.println(cs.getInt(8));
            aCurriculum.setCurriculumId(cs.getInt(8));
            isSuccesful = true;
        }

        catch(SQLException e)
        {
            isSuccesful = false;
            System.out.println("Error "+e);
        }
        
        return isSuccesful;
    }

    @Override
    public boolean curriculumExists(Curriculum aCurriculum) {
        boolean exists = false;
        int schoolYearId = sydi.getSchoolYearId(aCurriculum.getSchoolYear().getYearFrom());
        int gradelevelId = gldi.getId(aCurriculum.getGradeLevel());

        JOptionPane.showMessageDialog(null, "test: " + schoolYearId + " " + gradelevelId);
        String SQL = "{CALL curriculumExists(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, gradelevelId);
            cs.setInt(2, schoolYearId);
            try (ResultSet rs = cs.executeQuery()) {
                int rowCount = 0;
                while (rs.next()) {
                    rowCount++; //increment if record found
                }
                exists = rowCount > 0; // returns 0 or any number of rows > 1
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode() + "\n" + e.getMessage());
        }
        return exists;
    }

    @Override
    public List<Subject> getEachSubjectByGradeLevelForCurriculum(GradeLevel aGradeLevel) 
    {
        String sql = "{call getEachSubjectByGradeLevelForCurriculum(?)}";
        List <Subject> listSubject = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGradeLevel.getLevel());
            try(ResultSet rs = cs.executeQuery();)
            {
                while(rs.next())
                {
                    Subject aSubject = new Subject(); 
                    aSubject.setSubjectCode(rs.getString("code"));
                    aSubject.setSubjectTitle(rs.getString("title"));
                    aSubject.setSubjectDescription(rs.getString("description"));
                    aSubject.gradeLevel.setLevel(rs.getInt("grade_level"));
                    listSubject.add(aSubject);
                }
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error "+e);
        }
        
        return listSubject;
    }

    @Override
    public List<Subject> getAllSubjectForCurriculum() 
    {
        String sql = "{call getAllSubjectForCurriculum()}";
        List<Subject> listSubject = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Subject aSubject = new Subject();
                    aSubject.setSubjectCode(rs.getString("code"));
                    aSubject.setSubjectTitle(rs.getString("title"));
                    aSubject.setSubjectDescription(rs.getString("description"));
                    aSubject.gradeLevel.setLevel(rs.getInt("grade_level"));
                    listSubject.add(aSubject);
                }
            }
        }
        catch(SQLException e)
        {
             System.err.println("Error "+e);
        }
        
        return listSubject;
    }

    @Override
    public boolean addCurriculumWithSubjects(Curriculum aCurriculum) 
    {
        boolean isSuccesful;
        String sql = "call addCurriculumWithSubjects(?,?,?)";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.setString(2, aCurriculum.s.getSubjectCode());
            cs.setInt(3, aCurriculum.getCurriculumId());
            cs.executeUpdate();
            isSuccesful = true;
            JOptionPane.showMessageDialog(null, "Succesful!");
        }
        catch(SQLException e)
        {
            isSuccesful = false;
            System.out.println("Error "+e);
        }
        
        return isSuccesful;
    }

    @Override
    public List<Curriculum> getAllCurriculum() 
    {
        String sql = "{call getAllCurriculum()}";
        List<Curriculum> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Curriculum aCurriculum = new Curriculum();
                    aCurriculum.schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    aCurriculum.schoolYear.setYearTo(rs.getInt("yearTo"));
                    aCurriculum.gradeLevel.setLevel(rs.getInt("grade_level"));
                    aCurriculum.setCurriculumDescription(rs.getString("description"));
                    aCurriculum.setDateCreated(rs.getString("date_created"));
                    list.add(aCurriculum);
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error "+e);
        }
        
        return list;
    }

    @Override
    public List<Curriculum> getEachCurriculum(Curriculum aCurriculum, SchoolYear aSchoolYear) 
    {
        String sql = "{call getEachCurriculum(?,?)}";
        List<Curriculum> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSchoolYear.getYearFrom());
            cs.setString(2, aCurriculum.getCurriculumDescription());
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Curriculum curriculum = new Curriculum();
                    curriculum.schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    curriculum.schoolYear.setYearTo(rs.getInt("yearTo"));
                    curriculum.gradeLevel.setLevel(rs.getInt("grade_level"));
                    curriculum.setCurriculumDescription(rs.getString("description"));
                    curriculum.setDateCreated(rs.getString("date_created"));
                    list.add(curriculum);
                }
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error "+e);
        }
        
        return list;
    }
    

}
