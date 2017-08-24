package dao;

import java.util.List;
import model.user.User;

/**
 *
 * @author Acer
 */
public interface IUser {
    Integer getIdByUsername(String username);
    User getById(int userId);
    boolean add(User user);
    boolean update(User user);
    List<User> getAll();
    Integer getAdviserIdByUserId(int userId);
}
