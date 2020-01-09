package kamenev.dao;

import kamenev.model.Post;
import kamenev.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void create(User user);
    User getById(int id);
    void update(User user);
    void delete(User user);
    User getByName(String username);
}
