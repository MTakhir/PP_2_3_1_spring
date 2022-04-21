package app.dao;

import app.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UsersDaoImpl implements UsersDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UsersDaoImpl() {
    }

    public UsersDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    {
        entityManager.persist(new User("User_1","user_1@mail.com"));
        entityManager.persist(new User("User_2","user_2@mail.com"));
        entityManager.persist(new User("User_3","user_3@mail.com"));
        entityManager.persist(new User("User_4","user_4@mail.com"));
        entityManager.persist(new User("User_5","user_5@mail.com"));

    }
    @Override
    public List<User> getUsers(String count) {
            return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(int id) {
        return (User) entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = (User) entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
