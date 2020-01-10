package kamenev.service;

import kamenev.dao.PostDAO;
import kamenev.dao.RoleDAO;
import kamenev.dao.UserDAO;
import kamenev.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PostDAO postDAO;

    public List<Post> allPosts() {
        return postDAO.findAll();
    }

    public void create(Post post) {
        postDAO.save(post);
    }

    public Post getById(int id) {
        Optional<Post> postFromDB = postDAO.findById(id);
        return postFromDB.orElse(new Post());
    }

    public void update(Post post) {
        if (postDAO.findById(post.getId()).isEmpty()) {
            return;
        }
        Post changedPost = postDAO.findById(post.getId()).get();
        changedPost.setText(post.getText());
        changedPost.setDate(post.getDate());
        changedPost.setAuthor(post.getAuthor());
        postDAO.save(changedPost);
    }

    public void delete(Post post) {
        postDAO.delete(post);
    }
}
