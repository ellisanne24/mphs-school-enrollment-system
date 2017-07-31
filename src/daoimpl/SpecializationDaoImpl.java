/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ISpecialization;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.specialization.Specialization;
import utility.database.DBType;
import utility.database.DBUtil;

/**
 *
 * @author John Ferdinand Antonio
 */
public class SpecializationDaoImpl implements ISpecialization{

    @Override
    public boolean add(Specialization specialization) {
        boolean isAdded = false;
        String SQL = "{CALL addSpecialization(?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1,specialization.getName().trim());
            cs.setString(2, specialization.getDescription());
            cs.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public List<Specialization> getAll() {
        List<Specialization> specializationList = new ArrayList<>();
        String SQL = "{CALL getAllSpecializations()}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            try (ResultSet rs = cs.executeQuery();) {
                while (rs.next()) {
                    Specialization s = new Specialization();
                    s.setDateCreated(rs.getDate("date_created"));
                    s.setDescription(rs.getString("description"));
                    s.setIsActive(rs.getBoolean("isActive"));
                    s.setName(rs.getString("specialization_title"));
                    s.setId(rs.getInt("specialization_id"));
                    specializationList.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specializationList;
    }

    @Override
    public Specialization getById(int specializationId) {
        String SQL = "{CALL getSpecializationById(?)}";
        Specialization specialization = new Specialization();
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);) {
            
            cs.setInt(1, specializationId);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    specialization.setId(rs.getInt("specialization_id"));
                    specialization.setName(rs.getString("specialization_title"));
                    specialization.setDescription(rs.getString("description"));
                    specialization.setIsActive(rs.getBoolean("isActive"));
                    specialization.setDateCreated(rs.getDate("date_created"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialization;
    }

    @Override
    public boolean update(Specialization specialization) {
        boolean isUpdated;
        String SQL = "{CALL updateSpecialization(?,?,?)}";
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL)) {
            cs.setInt(1, specialization.getId());
            cs.setString(2, specialization.getName());
            cs.setString(3, specialization.getDescription());
            cs.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            isUpdated = false;
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public int getId(String specializationName) {
        String SQL = "{CALL getSpecializationIdByName(?)}";
        Integer specializationId = null;
        try (Connection con = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement cs = con.prepareCall(SQL);){
            cs.setString(1,specializationName.trim());
            try(ResultSet rs = cs.executeQuery();){
                while(rs.next()){
                    specializationId = rs.getInt("specialization_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specializationId;
    }
    
    
}
