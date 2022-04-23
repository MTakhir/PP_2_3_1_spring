package app.dao;

import app.models.User;
import java.util.List;

public interface UsersDao {
    List<User> getUsers(String count);
    void save(User user);
    User findUser(int id);
    void update(User user, int id);
    void delete(int id);
}
