package app.service;

import app.models.User;

import java.util.List;

public interface UsersService {
    List<User> getUsers();
    void save(User user);
    User findUser(int id);
    void update(User user, int id);
    void delete(int id);
}
