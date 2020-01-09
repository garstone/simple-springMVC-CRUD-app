package kamenev.service;

import kamenev.dao.RoleDAO;
import kamenev.dao.UserDAO;
import kamenev.model.Role;
import kamenev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    /*@PersistenceContext
    EntityManager entityManager;

     */

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public boolean create(User user) {
        if (userDAO.getByName(user.getLogin()) != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(2, "ROLE_USER")));
        userDAO.create(user);
        return true;
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public User getByLogin(String name) {
        return userDAO.getByName(name);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found :(");
        }
        return user;
    }
}
