
package dao;

import java.util.List;
import model.room.Room;

public interface IRoom {
    
    int getRoomId(String roomName);
    List<Room>getAllRoomInfo();
    List<Room>getAllActiveRooms();
    Room getRoomById(int aRoomID);
    boolean addRoom(Room aRoom);
    boolean updateRoom(Room aRoom);
    int getRoomID(String roomName,String BuildingName, String capacity);
    List<Room>getAllRoomsInfoByWildCard(String wildCardChar);
    
}
