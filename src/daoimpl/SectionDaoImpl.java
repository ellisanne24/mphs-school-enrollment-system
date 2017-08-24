package daoimpl;

import dao.ISection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.session.Session;
import model.student.Student;
import utility.database.DBType;
import utility.database.DBUtil;


public class SectionDaoImpl implements ISection {

    @Override
    public Section getSectionByStudentId(int aStudentId) {
        String SQL = "{CALL getSectionByStudentId(?)}";
        Section section = new Section();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,aStudentId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    System.out.println(rs.getString("sectionName"));
                    section.setSectionId(rs.getInt("section_id"));
                    section.setSectionName(rs.getString("sectionName"));
                    section.setIsActive(rs.getInt("isActive"));
                    section.setDateCreated(rs.getDate("date_created").toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }
    
    @Override
    public boolean hasSchedule(Integer sectionId, Integer schoolYearId) {
        boolean hasSchedule = false;
        int recordCount = 0;
        String SQL = "{CALL sectionhasSchedule(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,sectionId);
            cs.setInt(2,schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    recordCount = rs.getInt("recordCount");
                }
            }
            if(recordCount >0){
                hasSchedule = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasSchedule;
    }
    
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
                    section.gradeLevel.setLevel(rs.getInt(3));
                    section.faculty.setFirstName(rs.getString(4));
                    section.faculty.setMiddleName(rs.getString(5));
                    section.faculty.setLastName(rs.getString(6));
                    section.setRequiredAverage(rs.getString(7));
                    section.session.setSessionTitle(rs.getString(8));
                    section.schoolYear.setYearFrom(rs.getInt(9));
                    section.schoolYear.setYearTo(rs.getInt(10));
                    section.setIsActive(rs.getInt(11));
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
                    aSectionId = rs.getInt("section_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error at getSectionIdByName "+e);
        }
        return aSectionId;
    }


    @Override
    public boolean createSectionSettings(Section aSection, SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession, Faculty aFaculty) {
        boolean isSuccesful;
        String sql = "{call createSectionSettings(?,?,?,?,?,?)}";

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) 
        {
            cs.setInt(1, aSection.getSectionId());
            cs.setInt(2, aSchoolYear.getSchoolYearId());
            cs.setInt(3, aGradeLevel.getId());
            cs.setInt(4, aSession.getSessionId());
            cs.setInt(5, aFaculty.getFacultyID());
            cs.setString(6, aSection.getRequiredAverage());
            
            cs.executeUpdate();
            
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
                    section.gradeLevel.setLevel(rs.getInt(3));
                    section.faculty.setFirstName(rs.getString(4));
                    section.faculty.setMiddleName(rs.getString(5));
                    section.faculty.setLastName(rs.getString(6));
                    section.setRequiredAverage(rs.getString(7));
                    section.session.setSessionTitle(rs.getString(8));
                    section.schoolYear.setYearFrom(rs.getInt(9));
                    section.schoolYear.setYearTo(rs.getInt(10));
                    section.setIsActive(rs.getInt(11));
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
            System.out.println("Section Name :"+aSection.getSectionName());
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
    public List<Section> getAllStudentsByGradeLevelId(GradeLevel aGradeLevel) 
    {
        String sql = "call getAllStudentsByGradeLevelId(?)";
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
            System.out.println("Error at getAllStudentsByGradeLevelId "+ex);
        }
        
        return list;
    }
    
    @Override
    public List<Student> getAllStudentBySectionId(Section aSection, SchoolYear aSchoolYear) 
    {
        String sql = "{call getAllStudentBySectionId(?,?)}";
        List <Student> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSection.getSectionId());
            cs.setInt(2, aSchoolYear.getSchoolYearId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Student student = new Student();
                    
                    student.setStudentId(rs.getInt("student_id"));
                    student.setFirstName(rs.getString("firstname"));
                    student.setMiddleName(rs.getString("middlename"));
                    student.setLastName(rs.getString("lastname"));
                    
                    list.add(student);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllStudentBySectionId "+ex);
        }
        
        return list;
    }

    @Override
    public boolean createSection(Section aSection) 
    {
        String sql = "{call createSection(?,?)}";
        boolean isSuccessful;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setString(1, aSection.getSectionName());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            
            aSection.setSectionId(cs.getInt(2));
            
            isSuccessful = true;
        }
        catch(SQLException e)
        {
            isSuccessful = false;
            System.err.println("Error at createSection "+e);
        }
        
        return isSuccessful;
    }

   

    @Override
    public List getSessionIdBySectionId(Section aSection) 
    {
        List list = new ArrayList();
        String sql = "call getSessionIdBySectionId(?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSection.getSectionId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    list.add(rs.getInt("session_id"));
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getSectionDetailsById "+ex);
        }
        
        return list;
    }

    @Override
    public List<Section> getAllSectionNameByGradeLevelId(GradeLevel aGradeLevel) 
    {
        List<Section> list = new ArrayList();
        String sql = "call getAllSectionNameByGradeLevelId(?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGradeLevel.getId());
            
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
            System.err.println("Error at getAllSectionNameByGradeLevelId "+ex);
        }
        
        return list;
    }

    @Override
    public List<Section> getAllAddedStudentBySectionId(GradeLevel aGradeLevel, Section aSection) 
    {
        String sql = "call getAllAddedStudentBySectionId(?,?)";
        List <Section> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGradeLevel.getId());
            cs.setInt(2, aSection.getSectionId());
            
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
            System.out.println("Error at getAllAddedStudentBySectionId "+ex);
        }
        
        return list;
    }

    @Override
    public boolean deleteStudentSectionById(Section aSection) 
    {
        boolean isSuccessful;
        String sql = "call deleteStudentSectionById(?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSection.getSectionId());
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at deleteStudentSectionById "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public boolean updateSectionName(Section aSection) 
    {
        boolean isSuccessful;
        String sql = "call updateSectionName(?,?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSection.getSectionId());
            cs.setString(2, aSection.getSectionName());
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at updateSectionName "+ex);
        }
        
        return isSuccessful;
    }
    
    @Override
    public boolean updateSectionSettingsById(SchoolYear aSchoolYear, GradeLevel aGradeLevel, Session aSession, Faculty aFaculty, Section aSection) 
    {
        boolean isSuccessful;
        String sql = "call updateSectionSettingsById(?,?,?,?,?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            cs.setInt(2, aGradeLevel.getId());
            cs.setInt(3, aSession.getSessionId());
            cs.setInt(4, aFaculty.getFacultyID());
            cs.setInt(5, aSection.getSectionId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at updateSectionSettingsById "+ex);
        }
        
        return isSuccessful;
    }
}
