package kamenev.dao;

import kamenev.model.Post;

import java.util.List;

public interface PostDAO {
    List<Post> allPosts();
    void create(Post post);
    Post getById(int id);
    void update(Post post);
    void delete(Post post);
}
