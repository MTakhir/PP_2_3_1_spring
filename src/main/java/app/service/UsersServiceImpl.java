package app.service;

import app.dao.UsersDao;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDao usersDao;

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
