package app.dao;

import app.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao{
    private int counter;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++counter,"User_1","user_1@mail.com"));
        users.add(new User(++counter,"User_2","user_2@mail.com"));
        users.add(new User(++counter,"User_3","user_3@mail.com"));
        users.add(new User(++counter,"User_4","user_4@mail.com"));
        users.add(new User(++counter,"User_5","user_5@mail.com"));
    }
    @Override
    public List<User> getUsers(String count) {
        if (count != null && Integer.parseInt(count) < 5 && Integer.parseInt(count) > 0) {
            return users.subList(0, Integer.parseInt(count));
        }
        return users;
    }

    @Override
    public void save(User user) {
        user.setId(++counter);
        users.add(user);
    }

    @Override
    public User findUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(User user, int id) {
        User changedUser = findUser(id);
        changedUser.setName(user.getName());
        changedUser.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }


}
