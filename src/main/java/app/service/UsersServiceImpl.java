package app.service;

import app.dao.UsersDao;
import app.dao.UsersDaoImpl;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService{


    private UsersDao usersDao;

    public UsersServiceImpl() {
    }

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> getUsers(String count) {
        return usersDao.getUsers(count);
    }

    @Override
    @Transactional
    public void save(User user) {
        usersDao.save(user);
    }

    @Override
    public User findUser(int id) {
        return usersDao.findUser(id);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        usersDao.update(user,id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usersDao.delete(id);
    }
}
