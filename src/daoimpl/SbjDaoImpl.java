/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ISbj;
import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SbjDaoImpl implements ISbj{

    @Override
    public int getId(String subjectName) {
        int subjectId = 0;
        String SQL = "{CALL getSubjectIdByName(?)}";
        try (Connection con =  DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1,subjectName.trim());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    subjectId = rs.getInt("subject_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectId;
    }

    
}
