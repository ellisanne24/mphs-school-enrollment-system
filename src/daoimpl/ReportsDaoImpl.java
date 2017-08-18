/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IReports;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.classlistreport.ClassListReport;
import model.enrolleesreport.EnrolleesReport;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class ReportsDaoImpl implements IReports{

    @Override
    public List<EnrolleesReport> getAllEnrollees() {
        List<EnrolleesReport> list = new ArrayList<>();
        String SQL = "{CALL `getAllEnrollees`()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    EnrolleesReport er = new EnrolleesReport();
                    er.setDateOfEnrollment(rs.getDate("date_of_enrollment"));
                    er.setEnrollmentId(rs.getInt("enrollment_id"));
                    er.setGradelevel(rs.getInt("grade_level"));
                    er.setIsWithdrawn(rs.getBoolean ("withdrawn"));
                    er.setSchoolYear(rs.getInt("schoolYear"));
                    er.setStudentFirstName(rs.getString("firstname"));
                    er.setStudentId(rs.getInt("student_id"));
                    er.setStudentLastName(rs.getString("lastname"));
                    er.setStudentMiddleName(rs.getString("middlename"));
                    list.add(er);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<EnrolleesReport> getAllEnrollees(int schoolyearId) {
        List<EnrolleesReport> list = new ArrayList<>();
        String SQL = "{CALL `getAllEnrolleesBySchoolYearId`(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, schoolyearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    EnrolleesReport er = new EnrolleesReport();
                    er.setDateOfEnrollment(rs.getDate("date_of_enrollment"));
                    er.setEnrollmentId(rs.getInt("enrollment_id"));
                    er.setGradelevel(rs.getInt("grade_level"));
                    er.setIsWithdrawn(rs.getBoolean ("withdrawn"));
                    er.setSchoolYear(rs.getInt("schoolYear"));
                    er.setStudentFirstName(rs.getString("firstname"));
                    er.setStudentId(rs.getInt("student_id"));
                    er.setStudentLastName(rs.getString("lastname"));
                    er.setStudentMiddleName(rs.getString("middlename"));
                    list.add(er);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<EnrolleesReport> getAllEnrollees(int schoolyearId, int gradelevelId) {
        List<EnrolleesReport> list = new ArrayList<>();
        String SQL = "{CALL `getAllEnrolleesBySchoolYearIdAndGradeLevelId`(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,schoolyearId);
            cs.setInt(2, gradelevelId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    EnrolleesReport er = new EnrolleesReport();
                    er.setDateOfEnrollment(rs.getDate("date_of_enrollment"));
                    er.setEnrollmentId(rs.getInt("enrollment_id"));
                    er.setGradelevel(rs.getInt("grade_level"));
                    er.setIsWithdrawn(rs.getBoolean ("withdrawn"));
                    er.setSchoolYear(rs.getInt("schoolYear"));
                    er.setStudentFirstName(rs.getString("firstname"));
                    er.setStudentId(rs.getInt("student_id"));
                    er.setStudentLastName(rs.getString("lastname"));
                    er.setStudentMiddleName(rs.getString("middlename"));
                    list.add(er);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ClassListReport> getAllClassList() {
        List<ClassListReport> list = new ArrayList<>();
        String SQL = "{CALL getAllClassList()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
                try(ResultSet rs = cs.executeQuery();){
                    while(rs.next()){
                        ClassListReport clr = new ClassListReport();
                        clr.setAdviserFirstName(rs.getString("adviser_firstname"));
                        clr.setAdviserLastName(rs.getString("adviser_lastname"));
                        clr.setSectionName(rs.getString("sectionName"));
                        clr.setStudentFirstName(rs.getString("firstname"));
                        clr.setStudentId(rs.getInt("student_id"));
                        clr.setStudentLastName(rs.getString("lastname"));
                        clr.setStudentMiddleName(rs.getString("middlename"));
                        clr.setGradeLevel(rs.getInt("grade_level"));
                        list.add(clr);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ClassListReport> getClassList(int schoolYearId) {
        List<ClassListReport> list = new ArrayList<>();
        String SQL = "{CALL `getClassListBySchoolYearId`(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, schoolYearId);
                try(ResultSet rs = cs.executeQuery();){
                    while(rs.next()){
                        ClassListReport clr = new ClassListReport();
                        clr.setAdviserFirstName(rs.getString("adviser_firstname"));
                        clr.setAdviserLastName(rs.getString("adviser_lastname"));
                        clr.setSectionName(rs.getString("sectionName"));
                        clr.setStudentFirstName(rs.getString("firstname"));
                        clr.setStudentId(rs.getInt("student_id"));
                        clr.setStudentLastName(rs.getString("lastname"));
                        clr.setStudentMiddleName(rs.getString("middlename"));
                        clr.setGradeLevel(rs.getInt("grade_level"));
                        list.add(clr);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ClassListReport> getAllClassList(int schoolYearId, int gradeLevelId) {
        List<ClassListReport> list = new ArrayList<>();
        String SQL = "{CALL `getClassListBySchoolYearIdAndGradeLevelId`(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,schoolYearId);
            cs.setInt(2,gradeLevelId);
                try(ResultSet rs = cs.executeQuery();){
                    while(rs.next()){
                        ClassListReport clr = new ClassListReport();
                        clr.setAdviserFirstName(rs.getString("adviser_firstname"));
                        clr.setAdviserLastName(rs.getString("adviser_lastname"));
                        clr.setSectionName(rs.getString("sectionName"));
                        clr.setStudentFirstName(rs.getString("firstname"));
                        clr.setStudentId(rs.getInt("student_id"));
                        clr.setStudentLastName(rs.getString("lastname"));
                        clr.setStudentMiddleName(rs.getString("middlename"));
                        clr.setGradeLevel(rs.getInt("grade_level"));
                        list.add(clr);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
}
