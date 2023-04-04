package edu.miu.demo.service;

import edu.miu.demo.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post getById(long id);

    void save(Post p);

    void delete(long id);

    void update(long id, Post post);
}
