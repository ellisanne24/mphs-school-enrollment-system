/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ITransfereeGrade;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.transfereegrade.TransfereeGrade;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class TransfereeGradeDaoImpl implements ITransfereeGrade{
    
    
    @Override
    public boolean add(TransfereeGrade transfereeGrade) {
        boolean isAdded = false;
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        
        int studentId = studentDaoImpl.getId(transfereeGrade.getRegistrationId());
        System.out.println("StudentId: "+studentId);
        String SQL = "{CALL addTransfereeGrade(?,?,?,?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, studentId);
            cs.setDouble(2,transfereeGrade.getFirstQuarterGrade());
            cs.setDouble(3, transfereeGrade.getSecondQuarterGrade());
            cs.setDouble(4, transfereeGrade.getThirdQuarterGrade());
            cs.setDouble(5, transfereeGrade.getFourthQuarterGrade());
            cs.setDouble(6, transfereeGrade.getGwa());
            cs.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
}
