package kamenev.dao;

import kamenev.model.Post;
import kamenev.model.Role;
import kamenev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByName(String username);
}
