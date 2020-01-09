package kamenev.service;

import kamenev.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    boolean create(User user);
    User getById(int id);
    void update(User user);
    void delete(User user);
    User getByLogin(String username);
}
