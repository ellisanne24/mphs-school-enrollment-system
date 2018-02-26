/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import constants.SchoolYearTable;
import constants.QuarterTable;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.schoolyear.SchoolYear;
import model.quarter.Quarter;
import dao.IQuarter;

/**
 *
 * @author Acer
 */
public class QuarterDaoImpl implements IQuarter{

    //HAS
    SchoolYearDaoImpl schoolYearDaoImpl = new SchoolYearDaoImpl();

    @Override
    public boolean addQuarter(Quarter aQuarter) {
        boolean isSuccessful = false;
        String SQL = "{CALL addQuarter()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            
        } catch (SQLException e) {
            isSuccessful = false;
            e.printStackTrace();
        }
        return isSuccessful;
    }
    
    
    
    @Override
    public List<Quarter> getAllQuarters() {
        List<Quarter> quarterList = new ArrayList<>();
        String SQL = "{CALL getAllQuarters()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    SchoolYear schoolYear = new SchoolYear();
                    Quarter quarter = new Quarter();
                    quarter.setQuarterId(rs.getInt(QuarterTable.QUARTERID));
                    quarter.setQuarterNo(rs.getInt(QuarterTable.QUARTERNO));
                    quarter.setDateAdded(rs.getDate(QuarterTable.DATEADDED));
                    quarter.setIsActive(rs.getBoolean(QuarterTable.ISACTIVE));
                    quarter.setDescription(rs.getString(QuarterTable.DESCRIPTION));
                    quarter.setIsCurrentQuarter(rs.getBoolean(QuarterTable.SchoolYearQuarter.ISCURRENTQUARTER));
                    quarter.setStartDate(rs.getDate(QuarterTable.SchoolYearQuarter.STARTDATE));
                    quarter.setEndDate(rs.getDate(QuarterTable.SchoolYearQuarter.ENDATE));
                    schoolYear.setYearFrom(rs.getInt(SchoolYearTable.YEARFROM));
                    schoolYear.setYearTo(rs.getInt(SchoolYearTable.YEARTO));
                    schoolYear.setSchoolYearId(rs.getInt(SchoolYearTable.SCHOOLYEARID));
                    quarter.setSchoolYear(schoolYear);
                    
                    quarterList.add(quarter);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getErrorCode()+"\n"+e.getMessage());
        }
        return quarterList;
    }

    @Override
    public List<Quarter> getQuarterBySchoolYear(SchoolYear aSchoolYear) {
        List<Quarter> quarterList = new ArrayList<>();
        return quarterList;
    }

    @Override
    public Quarter getCurrentQuarterOf(SchoolYear schoolYear) {
        Quarter currentQuarter = new Quarter();
        String SQL = "{CALL getCurrentQuarterOf(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1,schoolYear.getSchoolYearId());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    currentQuarter.setQuarterNo(rs.getInt("quarter_no"));
                    currentQuarter.setStartDate(rs.getDate("start_date"));
                    currentQuarter.setEndDate(rs.getDate("end_date"));
                    currentQuarter.setGradingDueDate(rs.getDate("grading_due_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentQuarter;
    }
    
}
