
package daoimpl;

import dao.IOrNo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author Jordan
 */
public class OrNoDaoImpl implements IOrNo{

    @Override
    public String getNextAvailableOrNoForPaymentBySchoolYearId(int schoolyearId) {
        String OrNo = "";
        String SQL = "{CALL getNextAvailableORNOforPaymentBySchoolYearId(?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setInt(1, schoolyearId);
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                   OrNo = rs.getString("ORNO");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OrNo;
    }
    
}
