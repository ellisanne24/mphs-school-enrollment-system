/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import utility.database.DBType;
import utility.database.DBUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.discount.Discount;
import dao.IDiscount;
import model.user.User;

/**
 *
 * @author Acer
 */
public class DiscountDaoImpl implements IDiscount {

    @Override
    public List<Discount> getAllDiscount() {
        String SQL = "{CALL getAllDiscount()}";
        List<Discount> discountsList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    User createdBy = new User();
                    createdBy.setUserID(rs.getInt("user_id"));
                    createdBy.setUsername(rs.getString("username"));
                    createdBy.setPassword(rs.getString("password"));
                    createdBy.setLastName(rs.getString("lastname"));
                    createdBy.setFirstName(rs.getString("firstname"));
                    createdBy.setMiddleName(rs.getString("middlename"));
                    
                    Discount discount = new Discount();
                    discount.setDiscountID(rs.getInt("discount_id"));
                    discount.setDiscountName(rs.getString("discount_name"));
                    discount.setDescription(rs.getString("description"));
                    discount.setDateCreated(rs.getDate("date_created"));
                    discount.setPercent(rs.getInt("percentage"));
                    discount.setCreatedBy(createdBy);
                    discount.setIsActive(rs.getBoolean("isActive"));
                    discount.setProvision(rs.getString("provision"));
                    
                    discountsList.add(discount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discountsList;
    }
    
}
