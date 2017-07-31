/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IAssignedFees;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.assignedfees.AssignedFees;
import model.basicfee.BasicFee;
import model.downpayment.DownPaymentFee;
import model.fee.Fee;
import model.miscellaneousfees.MiscellaneousFees;
import model.otherfees.OtherFees;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class AssignedFeesDaoImpl implements IAssignedFees{

    @Override
    public AssignedFees get(int aStudentId, int aSchoolYearId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MiscellaneousFees getAssignedMiscellaneous(int aStudentId, int aSchoolYearId) {
        MiscellaneousFees miscellaneousFees = new MiscellaneousFees();
        List<Fee> feeList = new ArrayList<>();
        String SQL = "{getAssignedMiscellaneousFees(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    Fee f = new Fee();
//                    f.setAmount(rs.getDouble("fee_amount"));
//                    f.setDescription("");
//                    f.setExists(true);
//                    f.setFeeCategory("");
//                    f.setId("");
//                    f.setIsActive(true);
//                    f.setName("");
//                    f.setSchoolYear("");
//                    feeList.add(f);
                }
            }
            miscellaneousFees.setFees(feeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miscellaneousFees;
    }

    @Override
    public DownPaymentFee getAssignedDownPayment(int aStudentId, int aSchoolYearId) {
        DownPaymentFee downPaymentFee = new DownPaymentFee();
        String SQL = "{getAssignedDownPaymentFee(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return downPaymentFee;
    }

    @Override
    public OtherFees getAssignedOther(int aStudentId, int aSchoolYearId) {
        OtherFees otherFees = new OtherFees();
        String SQL = "{getAssignedOtherFees(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return otherFees;
    }

    @Override
    public BasicFee getAssignedBasic(int aStudentId, int aSchoolYearId) {
        BasicFee basicFee = new BasicFee();
        String SQL = "{getAssignedOtherFees(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return basicFee;
    }

    @Override
    public boolean remove(int aStudentId, int aSchoolYearId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
