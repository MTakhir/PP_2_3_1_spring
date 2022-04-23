package app.dao;

import app.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UsersDaoImpl implements UsersDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers(String count) {
            return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(int id) {
        return (User) entityManager.find(User.class,id);
    }

    @Override
    public void update(User user, int id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        User user = (User) entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
