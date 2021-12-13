package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getInterfaceId(int id);

    void delete(int id);

    void edit(User u);
}
