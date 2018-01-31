
package dao;

import java.util.List;
import model.room.Room;

public interface IRoom {
    
    int getRoomId(String roomName);
    public List<Room>getAllRoomInfo();
    Room getRoomById(int aRoomID);
    public boolean addRoom(Room aRoom);
    public boolean updateRoom(Room aRoom);
    int getRoomID(String roomName,String BuildingName, String capacity);
    List<Room>getAllRoomsInfoByWildCard(String wildCardChar);
    
}
