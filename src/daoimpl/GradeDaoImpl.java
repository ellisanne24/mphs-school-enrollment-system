/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IGrade;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student.Student;
import model.grade.Grade;
import model.gradelevel.GradeLevel;
import model.schoolyear.SchoolYear;
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
        String sql = "call createStudentGrade(?,?,?,?,?,?,?,?)";
        boolean isSuccessful;
        
        try(Connection con = DBUtil.getConnection(DBType.MYSQL);
            CallableStatement cs = con.prepareCall(sql);)
        {
            cs.setInt(1, grade.subject.getSubjectId());
            cs.setDouble(2, grade.getGrade());
            cs.setInt(3, grade.schoolYear.getSchoolYearId());
            cs.setInt(4, grade.getPeriodId());
            cs.setDouble(5, grade.getFinalGrade());
            cs.setDouble(6, grade.getGwa());
            cs.setInt(7, grade.student.getStudentId());
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            
            grade.setGwa(cs.getDouble(8));
            
            isSuccessful = true;
        }
        catch (SQLException ex) 
        {
            isSuccessful = false;
            
            System.err.println("Error at createGrade "+ex);
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
                    grade.setFirsQtr(rs.getDouble(3));
                    grade.setSecondQtr(rs.getDouble(4));
                    grade.setThirdQtr(rs.getDouble(5));
                    grade.setFourthQtr(rs.getDouble(6));
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

   
}
