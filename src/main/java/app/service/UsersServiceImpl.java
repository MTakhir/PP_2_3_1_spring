package app.service;

import app.dao.UsersDao;
import app.dao.UsersDaoImpl;
import app.models.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsersServiceImpl implements UsersService{

    private UsersDao usersDao = new UsersDaoImpl();

    @Override
    public List<User> getUsers(String count) {
        return usersDao.getUsers(count);
    }

    @Override
    public void save(User user) {
        usersDao.save(user);
    }

    @Override
    public User findUser(int id) {
        return usersDao.findUser(id);
    }

    @Override
    public void update(User user, int id) {
        usersDao.update(user,id);
    }

    @Override
    public void delete(int id) {
        usersDao.delete(id);
    }
}
