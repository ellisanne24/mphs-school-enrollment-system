
package daoimpl;

import dao.IGrade;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.faculty.Faculty;
import model.student.Student;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
import model.section.Section;
import model.subject.Subject;
import utility.database.DBType;
import utility.database.DBUtil;
/**
 *
 * @author John Ferdinand Antonio
 */
public class GradeDaoImpl implements IGrade{

    @Override
    public boolean createStudentGrade(Grade grade) 
    {
        String sql = "call createStudentGrade(?,?,?,?,?)";
        boolean isSuccessful;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, grade.subject.getSubjectId());
            cs.setString(2, grade.getGrade());
            cs.setInt(3, grade.schoolYear.getSchoolYearId());
            cs.setInt(4, grade.getPeriodId());
            cs.setInt(5, grade.student.getStudentId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch (SQLException ex) 
        {
            isSuccessful = false;
            
            System.err.println("Error at createStudentGrade "+ex);
        }
        
        return isSuccessful;
    }   

    @Override
    public List<Grade> getAllStudentRemarksByGradeLevelId(GradeLevel gradeLevel, SchoolYear aSchoolYear) 
    {
        String sql = "call getAllStudentGradeByGradeLevelId(?,?)";
        
        List <Grade> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, gradeLevel.getId());
            cs.setInt(2, aSchoolYear.getSchoolYearId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.student.setStudentId(rs.getInt("student_id"));
                    grade.student.setFirstName(rs.getString("firstname"));
                    grade.student.setMiddleName(rs.getString("middlename"));
                    grade.student.setLastName(rs.getString("lastname"));
                    grade.gradeLevel.setLevel(rs.getInt("grade_level"));
                    grade.setGwa(rs.getDouble("gwa"));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllStudentGradeByGradeLevelId "+ex);
        }
        
        return list;
    }
    
    @Override
    public boolean promoteStudentById(Grade aGrade, GradeLevel aGradeLevel, Student aStudent, SchoolYear aSchoolYear)
    {
        boolean isSuccessful;
        String sql = "call promoteStudentById(?,?,?,?)";
        
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            cs.setInt(2, aStudent.getStudentId());
            cs.setInt(3, aGradeLevel.getId());
            cs.setBoolean(4, aGrade.getIsPassed());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at promoteStudentById "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public List<Grade> getAllPromotedBySchoolYearId(SchoolYear aSchoolYear) 
    {
        String sql = "call getAllPromotedBySchoolYearId(?)";
        List <Grade> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.student.setStudentId(rs.getInt("student_id"));
                    grade.student.setFirstName(rs.getString("firstname"));
                    grade.student.setMiddleName(rs.getString("middlename"));
                    grade.student.setLastName(rs.getString("lastname"));
                    grade.gradeLevel.setLevel(rs.getInt("grade_level"));
                
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllPromotedBySchoolYearId "+ex);
        }
        
        return list;
    }

    @Override
    public List<Grade> getAllPromotedStudent(SchoolYear aSchoolYear) 
    {
        String sql = "call getAllPromotedStudent(?)";
        List <Grade> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.student.setStudentId(rs.getInt("student_id"));
                    grade.student.setFirstName(rs.getString("firstname"));
                    grade.student.setMiddleName(rs.getString("middlename"));
                    grade.student.setLastName(rs.getString("lastname"));
                    grade.gradeLevel.setLevel(rs.getInt("grade_level"));
                
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllPromotedStudent "+ex);
        }
        
        return list;
    }

    

    @Override
    public List<Grade> getAllSummerStudent() 
    {
        String sql = "call getAllSummerStudent()";
        List <Grade> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.student.setStudentId(rs.getInt("student_id"));
                    grade.student.setFirstName(rs.getString("firstname"));
                    grade.student.setMiddleName(rs.getString("middlename"));
                    grade.student.setLastName(rs.getString("lastname"));
                    grade.gradeLevel.setLevel(rs.getInt("grade_level"));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllSummerStudent "+ex);
        }
        return list;
    }

    @Override
    public List<Grade> getAllStudentGradeByStudentId(Student aStudent) 
    {
        String sql = "call getAllStudentGradeByStudentId(?)";
        
        List <Grade> list = new ArrayList();
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aStudent.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.subject.setSubjectId(rs.getInt(1));
                    grade.subject.setSubjectTitle(rs.getString(2));
                    grade.setFirstQtr(rs.getString(3));
                    grade.setSecondQtr(rs.getString(4));
                    grade.setThirdQtr(rs.getString(5));
                    grade.setFourthQtr(rs.getString(6));
                    grade.setFinalGrade(rs.getDouble(7));
                    
                    list.add(grade);
                }
            }
        }
        catch (SQLException ex) 
        {
            System.err.println("Error at getAllStudentGradeByStudentId "+ex);
        }
        
        return list;
    }

    @Override
    public double getAllStudentGradeGWAByStudentId(Student aStudent) 
    {
        String sql = "call getAllStudentGradeGWAByStudentId(?)";
        double gwa = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aStudent.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    gwa = rs.getDouble(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllStudentGradeGWAByStudentId "+ex);
        }
        
        return gwa;
    }

    @Override
    public boolean updateGradeByStudentId(Grade grade) 
    {
        String sql = "call updateGradeByStudentId(?,?,?,?)";
        boolean isSuccessful;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setString(1, grade.getGrade());
            cs.setInt(2, grade.getPeriodId());
            cs.setInt(3, grade.student.getStudentId());
            cs.setInt(4, grade.subject.getSubjectId());
            
            cs.executeUpdate();
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at updateGradeByStudentId "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public List<Grade> getAllStudentByAdviserId(Faculty aFaculty, SchoolYear aSchoolYear) 
    {
        String sql = "call getAllStudentByAdviserSectionId(?,?)";
        List <Grade> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aFaculty.getFacultyID());
            cs.setInt(2, aSchoolYear.getSchoolYearId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.student.setStudentId(rs.getInt(1));
                    grade.student.setFirstName(rs.getString(2));
                    grade.student.setMiddleName(rs.getString(3));
                    grade.student.setLastName(rs.getString(4));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAllStudentByAdviserSectionId "+ex);
        }
        
        return list;
    }

    @Override
    public List<Grade> getStudentGradeByAdviserStudentId(Faculty aFaculty, Student aStudent) 
    {
        String sql = "call getStudentGradeByAdviserStudentId(?,?)";
        List<Grade> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aFaculty.getFacultyID());
            cs.setInt(2, aStudent.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.subject.setSubjectId(rs.getInt(1));
                    grade.subject.setSubjectTitle(rs.getString(2));
                    grade.setFirstQtr(rs.getString(3));
                    grade.setSecondQtr(rs.getString(4));
                    grade.setThirdQtr(rs.getString(5));
                    grade.setFourthQtr(rs.getString(6));
                    grade.setFinalGrade(rs.getDouble(7));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getStudentGradeByFacultyStudentId "+ex);
        }
        return list;
    }

    @Override
    public List<Grade> getStudentFailedSubjectById(Student aStudent) 
    {
        String sql = "call getStudentFailedSubjectById(?)";
        List<Grade> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aStudent.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.subject.setSubjectId(rs.getInt(1));
                    grade.subject.setSubjectTitle(rs.getString(2));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getStudentFailedSubjectById "+ex);
        }
        return list;
        
    }

    @Override
    public boolean createStudentSummer(SchoolYear aSchoolYear, Student aStudent, GradeLevel gradeLevel, Subject aSubject, Grade aGrade) 
    {
        String sql = "call createStudentSummer(?,?,?,?,?)";
        boolean isSuccessful;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            cs.setInt(2, aStudent.getStudentId());
            cs.setInt(3, gradeLevel.getId());
            cs.setInt(4, aSubject.getSubjectId());
            cs.setDouble(5, aGrade.getGwa());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at createStudentSummer "+ex);
        }
        
        return isSuccessful;
        
    }

    @Override
    public boolean promoteSummerStudentById(GradeLevel gradeLevel, Student aStudent, SchoolYear aSchoolYear) 
    {
        String sql = "call promoteSummerStudentById(?,?,?)";
        boolean isSuccessful;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSchoolYear.getSchoolYearId());
            cs.setInt(2, aStudent.getStudentId());
            cs.setInt(3, gradeLevel.getId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at createStudentSummer "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public List<Grade> getAllStudentGradeBySectionId(Section aSection, Faculty aFaculty) {
        String sql = "call getAllStudentGradeBySectionId(?,?)";
        List<Grade> list = new ArrayList();

        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(sql);) {
            
            cs.setInt(1, aFaculty.getFacultyID());
            cs.setInt(2, aSection.getSectionId());

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Grade grade = new Grade();

                    grade.subject.setSubjectId(rs.getInt("subject_id"));
                    grade.subject.setSubjectTitle(rs.getString("title"));
                    grade.student.setStudentId(rs.getInt("student_id"));
                    grade.gradingPeriod.setId(rs.getInt("gradingperiod_id"));
                    grade.student.setFirstName(rs.getString("firstname"));
                    grade.student.setMiddleName(rs.getString("middlename"));
                    grade.student.setLastName(rs.getString("lastname"));
                    grade.setFirstQtr(rs.getString("first"));
                    grade.setSecondQtr(rs.getString("second"));
                    grade.setThirdQtr(rs.getString("third"));
                    grade.setFourthQtr(rs.getString("fourth"));
                    grade.setFinalGrade(rs.getDouble("final"));
                    
                    list.add(grade);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error at getAllStudentGradeBySectionId " + ex);
        }

        return list;
    }

    @Override
    public boolean updateFinalGradeByStudentId(Grade aGrade) 
    {
        boolean isSuccessful;
        String sql = "call updateFinalGradeByStudentId(?,?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setDouble(1, aGrade.getFinalGrade());
            cs.setInt(2, aGrade.student.getStudentId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at updateFinalGradeByStudentId "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public String getGradeLevelOfSectionId(Section aSection) 
    {
        String sql = "call getGradeLevelOfSectionId(?)";
        String gradeLevel = "";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aSection.getSectionId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    gradeLevel = rs.getString("grade_level");
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getGradeLevelOfSectionId "+ex);
        }
        
        return gradeLevel;
    }

    @Override
    public String getAdviserSectionByAdviserId(Faculty aFaculty) 
    {
        String sql = "call getAdviserSectionByAdviserId(?)";
        String section = "";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            
            cs.setInt(1, aFaculty.getFacultyID());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                   section = rs.getString("sectionName");
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getAdviserSectionByAdviserId "+ex);
        }
        
        return section;
    }

    @Override
    public int getCurrentPeriodBySubjectId(Grade aGrade) 
    {
        String sql = "call getCurrentPeriodBySubjectId(?)";
        int period = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.subject.getSubjectId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    period = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getCurrentPeriodBySubjectId "+ex);
        }
        
        return period;
    }
    
    @Override
    public int getPeriodStatusByGradingPeriodId(Grade aGrade) 
    {
        String sql = "call getPeriodStatusByGradingPeriodId(?)";
        int status = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    status = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getPeriodStatusBySubjectId "+ex);
        }
        
        return status;
    }
    

    @Override
    public boolean submitStudentGrade(Grade aGrade) 
    {
        boolean isSuccessful;
        String sql = "call submitStudentGrade(?,?,?)";
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.student.getStudentId());
            cs.setInt(2, aGrade.gradingPeriod.getId());
            cs.setInt(3, aGrade.subject.getSubjectId());
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at submitStudentGrade "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public int getCurrentPeriodOfCharacterBldng(Grade aGrade) 
    {
        String sql = "call getCurrentPeriodOfCharacterBldng(?)";
        int period = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    period = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getCurrentPeriodOfCharacterBldng "+ex);
        }
        
        return period;
    }

    @Override
    public int getPeriodStatusOfCharacterBldng(Grade aGrade) 
    {
        String sql = "call getPeriodStatusOfCharacterBldng(?)";
        int status = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    status = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getPeriodStatusOfCharacterBldng "+ex);
        }
        
        return status;
    }

    @Override
    public int countStudentGradeByGradingId(Grade aGrade) 
    {
        String sql = "call countStudentGradeByGradingId(?)";
        int count = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at countStudentGradeByGradingId "+ex);
        }
        
        return count;
    }

    @Override
    public int countIsSubmittedByGradingId(Grade aGrade) 
    {
        String sql = "call countIsSubmittedByGradingId(?)";
        int count = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at countIsSubmittedByGradingId "+ex);
        }
        
        return count;
    }

    @Override
    public boolean createStudentCharacter(Grade aGrade) 
    {
        String sql = "call createStudentCharacter(?,?,?)";
        boolean isSuccessful;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.student.getStudentId());
            cs.setString(2, aGrade.getGrade());
            cs.setInt(3, aGrade.gradingPeriod.getId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at createStudentCharacter "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public int countCharSubmittedByGradingId(Grade aGrade) 
    {
        String sql = "call countCharSubmittedByGradingId(?)";
        int count = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.gradingPeriod.getId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at countCharSubmittedByGradingId "+ex);
        }
        
        return count;
    }

    @Override
    public boolean createStudentAttendance(Grade aGrade) 
    {
        String sql = "call createStudentAttendance(?,?,?,?,?,?)";
        boolean isSuccessful;
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
//            cs.setInt(1, aGrade.student.getStudentId());
//            cs.setInt(2, aGrade.attendance.getId());
//            cs.setInt(3, aGrade.attendance.getDays());
//            cs.setInt(4, aGrade.attendance.getTotal());
//            cs.setInt(5, aGrade.attendance.getType());
//            cs.setInt(6, aGrade.schoolYear.getSchoolYearId());
//            
//            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at createStudentAttendance "+ex);
        }
        
        return isSuccessful;
        
    }

    @Override
    public int countStudentAttendance(Grade aGrade) 
    {
        String sql = "call countStudentAttendance(?)";
        int count = 0;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.student.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at countStudentAttendance "+ex);
        }
        
        return count;
    }

    @Override
    public boolean submitStudentGradeGWA(Grade aGrade) 
    {
        String sql = "call submitStudentGradeGWA(?,?,?)";
        boolean isSuccessful;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
            cs.setInt(1, aGrade.student.getStudentId());
            cs.setDouble(2, aGrade.getGwa());
            cs.setInt(3, aGrade.schoolYear.getSchoolYearId());
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at submitStudentGradeGWA "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public boolean updateStudentAttendance(Grade aGrade) 
    {
        String sql = "call updateStudentAttendance(?,?,?,?)";
        boolean isSuccessful;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql))
        {
//            cs.setInt(1, aGrade.attendance.getDays());
//            cs.setDouble(2, aGrade.student.getStudentId());
//            cs.setInt(3, aGrade.schoolYear.getSchoolYearId());
//            cs.setInt(4, aGrade.attendance.getId());
            
            cs.executeUpdate();
            
            isSuccessful = true;
        }
        catch(SQLException ex)
        {
            isSuccessful = false;
            System.err.println("Error at updateStudentAttendance "+ex);
        }
        
        return isSuccessful;
    }

    @Override
    public List<Grade> getCharBuildingByStudentId(Grade aGrade) 
    {
        List <Grade> list = new ArrayList();
        String sql = "call getCharBuildingByStudentId(?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGrade.student.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.setFirstQtr(rs.getString(1));
                    grade.setSecondQtr(rs.getString(2));
                    grade.setThirdQtr(rs.getString(3));
                    grade.setFourthQtr(rs.getString(4));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getCharBuildingByStudentId "+ex);
        }
        
        
        return list;
    }

    @Override
    public List<Grade> getStudentAttendanceBySchoolDays(Grade aGrade) 
    {
        List <Grade> list = new ArrayList();
        String sql = "call getStudentAttendanceBySchoolDays(?)";
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGrade.student.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
//                    grade.attendance.setJun(rs.getInt(1));
//                    grade.attendance.setJul(rs.getInt(2));
//                    grade.attendance.setAug(rs.getInt(3));
//                    grade.attendance.setSept(rs.getInt(4));
//                    grade.attendance.setOct(rs.getInt(5));
//                    grade.attendance.setNov(rs.getInt(6));
//                    grade.attendance.setDec(rs.getInt(7));
//                    grade.attendance.setJun(rs.getInt(8));
//                    grade.attendance.setFeb(rs.getInt(9));
//                    grade.attendance.setMar(rs.getInt(10));
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getStudentAttendanceBySchoolDays "+ex);
        }
        
        
        return list;
    }

    @Override
    public List<Grade> getReportCardByStudentId(Grade aGrade) 
    {
        String sql = "call getReportCardByStudentId(?)";
        
        List <Grade> list = new ArrayList();
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, aGrade.student.getStudentId());
            
            try(ResultSet rs = cs.executeQuery())
            {
                while(rs.next())
                {
                    Grade grade = new Grade();
                    
                    grade.subject.setSubjectTitle(rs.getString(1));
                    grade.setFirstQtr(rs.getString(2));
                    grade.setSecondQtr(rs.getString(3));
                    grade.setThirdQtr(rs.getString(4));
                    grade.setFinalGrade(rs.getDouble(5));
                    grade.setGwa(rs.getDouble(6));
                    
                    
                    list.add(grade);
                }
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error at getReportCardByStudentId "+ex);
        }
        
        
        return list;
    }
    
    
}
