package kamenev.dao;

import kamenev.model.Post;
import kamenev.model.Role;
import kamenev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select a from User a where a.name = :login")
    User findByName(@Param("login") String login);
}
