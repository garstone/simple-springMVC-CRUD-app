package kamenev.service;

import kamenev.model.Post;
import kamenev.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostDAO postDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    @Transactional
    public List<Post> allPosts() {
            return postDAO.allPosts();
    }

    @Override
    @Transactional
    public void create(Post post) {
        postDAO.create(post);
    }

    @Override
    @Transactional
    public Post getById(int id) {
        return postDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(Post post) {
        postDAO.update(post);
    }

    @Override
    @Transactional
    public void delete(Post post) {
        postDAO.delete(post);
    }
}
