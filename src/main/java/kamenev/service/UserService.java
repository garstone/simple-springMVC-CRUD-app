package kamenev.service;

import kamenev.dao.RoleDAO;
import kamenev.dao.UserDAO;
import kamenev.model.Role;
import kamenev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<User> allUsers() {
        return userDAO.findAll();
    }

    public boolean create(User user) {
        if (userDAO.findByName(user.getUsername()) != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userDAO.save(user);
        return true;
    }

    public User getById(int id) {
        Optional<User> userFromDb = userDAO.findById(id);
        return userFromDb.orElse(new User());
    }

    public void update(User user) {
        if (userDAO.findById(user.getId()).isEmpty()) {
            return;
        }
        User changedUser = userDAO.findById(user.getId()).get();
        changedUser.setPassword(user.getPassword());
        changedUser.setRoles(user.getRoles());
        changedUser.setName(user.getName());
        changedUser.setLogin(user.getLogin());
        userDAO.save(changedUser);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

}
