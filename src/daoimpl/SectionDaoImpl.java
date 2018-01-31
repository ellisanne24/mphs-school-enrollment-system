package daoimpl;

import dao.ISection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
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
        String SQLb = "{CALL addSectionSetting(?,?,?,?)}"; //add a 5th parameter to store faculty/adviser id when faculty module is finished
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
                //add a 5th parameter to store faculty/adviser id when faculty module is finished
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
    public boolean updateSection(Section section) {
        boolean isUpdated = false;
        String SQLa = "{CALL updateSection(?,?,?)}";
        String SQLb = "{CALL updateSectionSettings(?,?,?,?)}";
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
                    gradeLevel.setLevel(rs.getInt("grade_level"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setSectionSession(rs.getString("session"));
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
                    gradeLevel.setLevel(rs.getInt("grade_level"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setSectionSession(rs.getString("session"));
                    sectionList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectionList;
    }

    @Override
    public List<Section> getSectionsByGradeLevelNo(int gradeLevelNo) {
        List<Section> sectionList = new ArrayList<>();
        String SQL = "{CALL getSectionsByGradeLevelNo(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            cs.setInt(1,gradeLevelNo);
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
                    gradeLevel.setLevel(rs.getInt("grade_level"));
                    
                    s.setGradeLevel(gradeLevel);
                    s.setSectionSession(rs.getString("session"));
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
                    gradeLevel.setLevel(rs.getInt("grade_level"));
                    
                    section.setGradeLevel(gradeLevel);
                    
                    section.setSectionSession(rs.getString("session"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }
    
    //End of Jordan's
}
