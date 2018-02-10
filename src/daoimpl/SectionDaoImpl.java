package daoimpl;

import dao.ISection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.faculty.Faculty;
import model.gradelevel.GradeLevel;
import model.registration.Registration;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.student.Student;
import utility.database.DBType;
import utility.database.DBUtil;


public class SectionDaoImpl implements ISection {

    private GradeLevelDaoImpl gradeLevelDaoImpl;
    
    public SectionDaoImpl(){
        gradeLevelDaoImpl = new GradeLevelDaoImpl();
    }
    
    //Jordan's
    
    @Override
    public boolean addSection(Section section) {
        boolean isAdded = false;
        String SQLa = "{CALL addSection(?,?)}";
        String SQLb = "{CALL addSectionSetting(?,?,?,?,?,?)}"; //add a 5th parameter to store faculty/adviser id when faculty module is finished
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);) {
                csa.setString(1, section.getSectionName());
                csa.registerOutParameter(2, Types.INTEGER);
                csa.executeUpdate();
                int sectionId = csa.getInt(2);

                csb.setInt(1, sectionId);
                csb.setInt(2, section.getSchoolYear().getSchoolYearId());
                csb.setInt(3, section.getGradeLevel().getId());
                csb.setString(4, section.getSectionSession());
                csb.setInt(5, section.getAdviser().getFacultyID());
                csb.setInt(6, section.getCapacity());
                
                csb.executeUpdate();
                con.commit();
                isAdded = true;
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean addStudentsToSection(Section section) {
        boolean isSuccessful = false;
        SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();
        String SQLa = "{CALL removeStudentsFromSectionBySectionIdandSchoolYearId(?,?) }";
        String SQLb = "{CALL addStudentToSection(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);){
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);){
                csa.setInt(1, section.getSectionId());
                csa.setInt(2, schoolYearDaoImpl.getCurrentSchoolYearId());
                csa.executeUpdate();
                for(Student s : section.getStudents()){
                    csb.setInt(1, s.getStudentId());
                    csb.setInt(2, section.getSectionId());
                    csb.setInt(3, schoolYearDaoImpl.getCurrentSchoolYearId());
                    csb.executeUpdate();
                }
                con.commit();
                isSuccessful = true;
            } catch (SQLException e) {
                con.rollback();
                con.setAutoCommit(true);
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }

    @Override
    public boolean updateSection(Section section) {
        boolean isUpdated = false;
        String SQLa = "{CALL updateSection(?,?,?)}";
        String SQLb = "{CALL updateSectionSettings(?,?,?,?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);) {
            con.setAutoCommit(false);
            try (CallableStatement csa = con.prepareCall(SQLa);
                    CallableStatement csb = con.prepareCall(SQLb);) {
                
                csa.setInt(1,section.getSectionId());
                csa.setString(2, section.getSectionName());
                csa.setBoolean(3, section.getIsActive());
                csa.executeUpdate();
                
                csb.setInt(1, section.getSectionId());
                csb.setInt(2, section.getSchoolYear().getSchoolYearId());
                csb.setInt(3, section.getGradeLevel().getId());
                csb.setString(4, section.getSectionSession().trim());
                csb.setInt(5,section.getAdviser().getFacultyID());
                csb.setInt(6, section.getCapacity());
                csb.executeUpdate();
                
                con.commit();
                isUpdated = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public List<Student> getSectionStudentsBySectionIdAndSchoolYearId(Section section) {
        List<Student> studentList = new ArrayList<>();
        String SQL = "{CALL getSectionStudentsBySectionIdAndSchoolYearId(?,?)}";
        int sectionId = section.getSectionId();
        int schoolYearId = section.getSchoolYear().getSchoolYearId();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, sectionId);
            cs.setInt(2, schoolYearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Registration r = new Registration();
                    r.setLastName(rs.getString("lastname"));
                    r.setFirstName(rs.getString("firstname"));
                    r.setMiddleName(rs.getString("middlename"));
                    
                    Student s = new Student();
                    s.setRegistration(r);
                    s.setStudentId(rs.getInt("student_id"));
                    s.setStudentNo(rs.getInt("student_no"));
                    s.setStudentType(rs.getString("finalStudentType").equalsIgnoreCase("O") == true ? 0 : 1);
                    s.setGradeLevelNo(rs.getInt("currentGradeLevel"));
                    
                    studentList.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Section> getAllSections() {
        List<Section> sectionList = new ArrayList<>();
        String SQL = "{CALL getAllSections()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section s = new Section();
                    s.setSectionId(rs.getInt("section_id"));
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    s.setSchoolYear(schoolYear);
                    s.setSectionName(rs.getString("sectionName"));
                    s.setIsActive(rs.getBoolean("isActive"));
                    s.setDateCreated(rs.getString("date_created"));
                    
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));

                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("faculty_id"));
                    adviser.setLastName(rs.getString("lastName"));
                    adviser.setFirstName(rs.getString("firstName"));
                    adviser.setMiddleName(rs.getString("middleName"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setAdviser(adviser);
                    s.setSectionSession(rs.getString("session"));
                    s.setCapacity(rs.getInt("capacity"));
                    
                    sectionList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }

    @Override
    public List<Section> getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId(boolean isActive, int schoolyearId) {
        String SQL = "{CALL getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId(?,?)}";
        List<Section> sectionList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, isActive == true ? 1 : 0);
            cs.setInt(2, schoolyearId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section section = new Section();
                    section.setSectionId(rs.getInt("section_id"));
                    section.setSectionName(rs.getString("sectionName"));
                    section.setIsActive(rs.getBoolean("isActive"));
                    section.setDateCreated(rs.getString("date_created"));
                    section.setSectionSession(rs.getString("session"));
                    sectionList.add(section);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }
    
    
    @Override
    public List<Section> getSectionsWithNoAssignedScheduleBy_Status_SchoolYearId_GradeLevelId(boolean isActive, int schoolyearId, int gradeLevelId) {
        String SQL = "{CALL getSectionsWithNoAssignedScheduleBySchoolYearIdGradeLevelId(?,?,?)}";
        List<Section> sectionList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, isActive == true ? 1 : 0);
            cs.setInt(2, schoolyearId);
            cs.setInt(3, gradeLevelId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section section = new Section();
                    section.setSectionId(rs.getInt("section_id"));
                    section.setSectionName(rs.getString("sectionName"));
                    section.setIsActive(rs.getBoolean("isActive"));
                    section.setDateCreated(rs.getString("date_created"));
                    section.setSectionSession(rs.getString("session"));
                    sectionList.add(section);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }
            
            
    @Override
    public List<Section> getAllSectionsByStatusAndSchoolYearId(boolean status, int schoolYearId) {
        List<Section> sectionList = new ArrayList<>();
        String SQL = "{CALL getAllSectionsByStatusAndSchoolYear(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, status==true? 1: 0);
            cs.setInt(2, schoolYearId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section s = new Section();
                    s.setSectionId(rs.getInt("section_id"));
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    s.setSchoolYear(schoolYear);
                    s.setSectionName(rs.getString("sectionName"));
                    s.setIsActive(rs.getBoolean("isActive"));
                    s.setDateCreated(rs.getString("date_created"));
                    
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));

                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("faculty_id"));
                    adviser.setLastName(rs.getString("lastName"));
                    adviser.setFirstName(rs.getString("firstName"));
                    adviser.setMiddleName(rs.getString("middleName"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setAdviser(adviser);
                    s.setSectionSession(rs.getString("session"));
                    s.setCapacity(rs.getInt("capacity"));
                    
                    sectionList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }
    
    @Override
    public List<Section> getSectionsByWildCard(String wildCardChar) {
        List<Section> sectionList = new ArrayList<>();
        String SQL = "{CALL getSectionsByWildCard(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setString(1,wildCardChar);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section s = new Section();
                    s.setSectionId(rs.getInt("section_id"));
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    s.setSchoolYear(schoolYear);
                    s.setSectionName(rs.getString("sectionName"));
                    s.setIsActive(rs.getBoolean("isActive"));
                    s.setDateCreated(rs.getString("date_created"));
                    
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    
                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("faculty_id"));
                    adviser.setLastName(rs.getString("lastName"));
                    adviser.setFirstName(rs.getString("firstName"));
                    adviser.setMiddleName(rs.getString("middleName"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setSectionSession(rs.getString("session"));
                    s.setAdviser(adviser);
                    s.setCapacity(rs.getInt("capacity"));
                    
                    sectionList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }

    @Override
    public List<Section> getSectionsByGradeLevelNoAndSchoolYearId(int gradeLevelNo, int schoolYearId) {
        List<Section> sectionList = new ArrayList<>();
        String SQL = "{CALL getSectionsByGradeLevelNoAndSchoolYearId(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1,gradeLevelNo);
            cs.setInt(2,schoolYearId);
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Section s = new Section();
                    s.setSectionId(rs.getInt("section_id"));
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    s.setSchoolYear(schoolYear);
                    s.setSectionName(rs.getString("sectionName"));
                    s.setIsActive(rs.getBoolean("isActive"));
                    s.setDateCreated(rs.getString("date_created"));
                    
                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    
                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("faculty_id"));
                    adviser.setLastName(rs.getString("lastName"));
                    adviser.setFirstName(rs.getString("firstName"));
                    adviser.setMiddleName(rs.getString("middleName"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setSectionSession(rs.getString("session"));
                    s.setAdviser(adviser);
                    s.setCapacity(rs.getInt("capacity"));
                    
                    sectionList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }
    

    @Override
    public Section getSectionById(int sectionId) {
        Section section = new Section();
        String SQL = "{CALL getSectionById(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1, sectionId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    section.setSectionId(rs.getInt("section_id"));
                    SchoolYear schoolYear = new SchoolYear();
                    schoolYear.setYearFrom(rs.getInt("yearFrom"));
                    section.setSchoolYear(schoolYear);
                    section.setSectionName(rs.getString("sectionName"));
                    section.setIsActive(rs.getBoolean("isActive"));
                    section.setDateCreated(rs.getString("date_created"));

                    GradeLevel gradeLevel = new GradeLevel();
                    gradeLevel.setLevelNo(rs.getInt("grade_level"));
                    
                    Faculty adviser = new Faculty();
                    adviser.setFacultyID(rs.getInt("faculty_id"));
                    adviser.setLastName(rs.getString("lastName"));
                    adviser.setFirstName(rs.getString("firstName"));
                    adviser.setMiddleName(rs.getString("middleName"));
                    
                    section.setGradeLevel(gradeLevel);
                    section.setAdviser(adviser);
                    section.setSectionSession(rs.getString("session"));
                    section.setCapacity(rs.getInt("capacity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }
    
    
    
    //End of Jordan's

    @Override
    public boolean sectionExists(String sectionName) {
        boolean exists = false;
        String SQL = "{CALL sectionExists(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1, sectionName.toLowerCase().trim());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    exists = rs.getBoolean("sectionExists");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
