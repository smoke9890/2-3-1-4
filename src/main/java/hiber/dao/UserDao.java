package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getInterfaceId(int id);

    void delete(int id);

    void edit(User u);


}
