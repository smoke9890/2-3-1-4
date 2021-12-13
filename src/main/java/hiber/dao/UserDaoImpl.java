package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getInterfaceId(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        em.remove(getInterfaceId(id));
    }

    @Override
    public void edit(User u) {
        em.merge(u);
    }


}
