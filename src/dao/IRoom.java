
package dao;

import java.util.List;
import model.Room;

public interface IRoom {
    
    
    public List<Room>getRoomInfo();
    Room getRoomByID(int aRoomID);
    public boolean addRoom(Room aRoom);
    public boolean updateRoom(Room aRoom);
    int getRoomID(String roomName,String BuildingName, String capacity);
    
    
    
    
}
