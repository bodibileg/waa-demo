package edu.miu.demo.repo;

import edu.miu.demo.domain.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    public Post getById(long id);

    public void save(Post p);

    public void delete(long id);

    public void update(long id, Post p);

}
