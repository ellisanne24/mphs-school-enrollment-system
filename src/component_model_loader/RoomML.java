/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component_model_loader;

import daoimpl.RoomDaoImpl;
import javax.swing.DefaultComboBoxModel;
import model.Room;

/**
 *
 * @author John Ferdinand Antonio
 */
public class RoomML {
    RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
    public DefaultComboBoxModel getRoomNames(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Object[] roomList = roomDaoImpl.getRoomInfo().toArray();
        for(Object o : roomList){
            Room room = (Room)o;
            String roomName = room.getRoomName();
            model.addElement(roomName);
        }
        return model;
    }
}
