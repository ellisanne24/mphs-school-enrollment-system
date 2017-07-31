package daoimpl;

import dao.ISection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;
import utility.database.DBType;
import utility.database.DBUtil;


public class SectionDaoImpl implements ISection {

    @Override
    public List<Section> getAllSections() {
        List<Section> list = new ArrayList<>();
        String SQL = "{call getAllSections()}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section section = new Section();
                    section.setSectionId(rs.getInt(1));
                    section.setSectionName(rs.getString(2));
                    section.setRequiredAverage(rs.getString(3));
                    section.session.setSessionTitle(rs.getString(4));
                    section.schoolYear.setYearFrom(rs.getInt(5));
                    section.schoolYear.setYearTo(rs.getInt(6));
                    section.setIsActive(rs.getInt(7));
                    list.add(section);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at getAllSections" +e);
        }
        return list;
    }

    @Override
    public Integer getSectionIdByName(String aSectionName) {
        String SQL = "{CALL getSectionIdByName(?)}";
        Integer aSectionId = null;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setString(1, aSectionName);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    aSectionId = rs.getInt("aSectionId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error at getSectionIdByName "+e);
        }
        return aSectionId;
    }


    @Override
    public boolean createSectionSettings(Section aSection, SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession) {
        boolean isSuccesful;
        String sql = "{call createSectionSettings(?,?,?,?,?,?)}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) 
        {
            cs.setString(1, aSection.getSectionName());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.setInt(3, aSchoolYear.getSchoolYearId());
            cs.setInt(4, aGradeLevel.getId());
            cs.setInt(5, aSession.getSessionId());
            cs.setString(6, aSection.getRequiredAverage());
            cs.executeUpdate();
            
            aSection.setSectionId(cs.getInt(2));

            isSuccesful = true;
        } catch (SQLException ex) {
            isSuccesful = false;
            ex.printStackTrace();
            System.err.println("Error at createSectionSettings " + ex);
        }
        return isSuccesful;
    }

    @Override
    public List<Section> getAllSectionsByGradeLevelId(GradeLevel aGradeLevel) {
        List<Section> list = new ArrayList();
        String sql = "{call getAllSectionsByGradeLevelId(?)}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            cs.setInt(1, aGradeLevel.getId());
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Section section = new Section();
                    section.setSectionId(rs.getInt(1));
                    section.setSectionName(rs.getString(2));
                    section.setRequiredAverage(rs.getString(3));
                    section.session.setSessionTitle(rs.getString(4));
                    section.schoolYear.setYearFrom(rs.getInt(5));
                    section.schoolYear.setYearTo(rs.getInt(6));
                    section.setIsActive(rs.getInt(7));
                    list.add(section);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error at getAllSectionsByGradeLevelId " + ex);
        }
        return list;
    }

    @Override
    public List<Student> getAllStudentsBySection(Session aSession, Section aSection, GradeLevel aGradeLevel) {
        String sql = "{call getAllStudentsBySection(?,?,?)}";
        List<Student> list = new ArrayList();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) 
        {
            cs.setInt(1, aSession.getSessionId());
            cs.setInt(2, aGradeLevel.getId());
            cs.setString(3, aSection.getSectionName());
            try (ResultSet rs = cs.executeQuery()) 
            {
                while (rs.next()) 
                {
                    Student student = new Student();
                    student.setStudentId(rs.getInt(1));
                    student.setFirstName(rs.getString(2));
                    student.setMiddleName(rs.getString(3));
                    student.setLastName(rs.getString(4));
                    list.add(student);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error at getAllStudentsBySection " + ex);
        }
        return list;
    }


    @Override
    public boolean createStudentSection(Section aSection, Student aStudent, SchoolYear aSchoolYear) {
        String sql = "{call createStudentSection(?,?,?)}";
        boolean isSuccessful;

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            cs.setInt(1, aSection.getSectionId());
            cs.setInt(2, aStudent.getStudentId());
            cs.setInt(3, aSchoolYear.getSchoolYearId());
            cs.executeUpdate();
            isSuccessful = true;
        } catch (SQLException ex) {
            isSuccessful = false;
            ex.printStackTrace();
            System.err.println("Error at createStudentSection " + ex);
        }
        return isSuccessful;
    }

    @Override
    public int getSectionId(Section aSection) {
        String sql = "{call getSectionId(?)}";
        Integer id = null;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            cs.setString(1, aSection.getSectionName());
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error at getSectionId" + ex);
        }
        return id;
    }

    @Override
    public int getSectionSchoolYearId(Section aSection) {
        String sql = "{call getSectionSchoolYearId(?)}";
        Integer schoolYearId = null;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            cs.setString(1, aSection.getSectionName());
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    schoolYearId = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error at getSectionSchoolYearId " + ex);
        }
        return schoolYearId;
    }

    @Override
    public List<Section> getCreatedSectionById(Section aSection) {
        String sql = "{call getCreatedSectionById(?)}";
        List<Section> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            cs.setInt(1, aSection.getSectionId());
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Section section = new Section();
                    section.setSectionName(rs.getString(1));
                    section.gradeLevel.setLevel(rs.getInt(2));
                    section.schoolYear.setYearFrom(rs.getInt(3));
                    section.schoolYear.setYearTo(rs.getInt(4));
                    section.setCategory(rs.getString(7));
                    section.session.setCapacity(rs.getInt(8));
                    section.session.setSessionTitle(rs.getString(9));
                    list.add(section);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Error at getCreatedSectionById " + ex);
        }
        return list;
    }

    
    
    @Override
    public boolean addSection(Section aSection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> getSectionsBySchoolYear(int aSchoolYearId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> getSectionsByGradeLevel(int aGradeLevelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> getSectionsBySchoolYearAndGradeLevel(int aSchoolYearId, int aGradeLevelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getSectionStudents(int aSectionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Section> getAllNewStudentsByGradeLevelId(GradeLevel aGradeLevel) 
    {
        String sql = "call getAllNewStudentsByGradeLevelId(?)";
        
        List <Section> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGradeLevel.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Section section = new Section();
                    
                    section.student.setStudentId(rs.getInt(1));
                    section.student.setFirstName(rs.getString(2));
                    section.student.setMiddleName(rs.getString(3));
                    section.student.setLastName(rs.getString(4));
                    section.grade.setGwa(rs.getDouble(5));
                    list.add(section);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllNewStudentsByGradeLevelId "+ex);
        }
        
        return list;
    }

    @Override
    public double getSectionAverageBySectionId(Section aSection) 
    {
        String sql = "call getSectionAverageBySectionId(?)";
        double average = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSection.getSectionId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    average = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getSectionAverageBySectionId "+ex);
        }
        
        return average;
    }

    @Override
    public List<Section> getAllOldStudentsByGradeLevelId(GradeLevel aGradeLevel) 
    {
        String sql = "call getAllOldStudentsByGradeLevelId(?)";
        List <Section> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGradeLevel.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Section section = new Section();
                    
                    section.student.setStudentId(rs.getInt(1));
                    section.student.setFirstName(rs.getString(2));
                    section.student.setMiddleName(rs.getString(3));
                    section.student.setLastName(rs.getString(4));
                    section.grade.setGwa(rs.getDouble(5));
                    
                    list.add(section);
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error at getAllOldStudentsByGradeLevelId "+ex);
        }
        
        return list;
    }

}
