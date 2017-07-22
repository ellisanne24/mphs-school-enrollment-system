
package dao;

import java.util.List;
import model.room.Room;

public interface IRoom {
    
    int getId(String roomName);
    public List<Room>getRoomInfo();
    Room getRoomByID(int aRoomID);
    public boolean addRoom(Room aRoom);
    public boolean updateRoom(Room aRoom);
    int getRoomID(String roomName,String BuildingName, String capacity);
    
    
    
    
}
