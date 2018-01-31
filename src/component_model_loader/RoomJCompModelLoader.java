/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.RoomDaoImpl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.room.Room;
import model.subject.Subject;

/**
 *
 * @author 
 */
public class RoomJCompModelLoader {
    
    private final RoomDaoImpl roomDaoImpl;
    
    public RoomJCompModelLoader(){        
        roomDaoImpl = new RoomDaoImpl();
    }
    
     public DefaultTableModel getAllRoomsInfo(JTable jTable){
       DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
       tableModel.setRowCount(0);
       Object[] roomList = roomDaoImpl.getAllRoomInfo().toArray();
       for(Object o : roomList){
           Room r  = (Room)o;
           Object[] rowData = {
               r.getRoom_id(), 
               r.getRoomName(), 
               r.getBuildingName(), 
               r.getCapacity(),
               r.getStatus() == true?"Yes":"No",
               r.getDateCreated(),
               r.getDescription()
           };
           tableModel.addRow(rowData);
       }
       return tableModel;
   }

    public DefaultTableModel getAllRoomsInfoByWildCard(JTextField jtfSearchBox, JTable jtblRoomMasterList){
        DefaultTableModel tableModel = (DefaultTableModel) jtblRoomMasterList.getModel();
        tableModel.setRowCount(0);
        Object[] roomList = roomDaoImpl.getAllRoomsInfoByWildCard(jtfSearchBox.getText().trim()).toArray();
        for(Object o : roomList){
            Room r = (Room)o;
            Object[] rowData = {
               r.getRoom_id(), 
               r.getRoomName(), 
               r.getBuildingName(), 
               r.getCapacity(),
               r.getStatus() == true?"Yes":"No",
               r.getDateCreated(),
               r.getDescription()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    
}
