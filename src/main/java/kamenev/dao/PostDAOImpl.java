package kamenev.dao;

import kamenev.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostDAOImpl implements PostDAO {
    //private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> allPosts() {
        try {
            Session session = sessionFactory.getCurrentSession();
            List postList = session.createQuery("from Post").getResultList();
            return postList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Post post) {
        Session session = sessionFactory.getCurrentSession();
        //post.setId(AUTO_ID.getAndIncrement());
        session.persist(post);
    }

    @Override
    public void update(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.update(post);
    }

    @Override
    public void delete(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(post);
    }

    @Override
    public Post getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Post.class, id);
    }
}
