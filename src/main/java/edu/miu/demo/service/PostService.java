package edu.miu.demo.service;

import edu.miu.demo.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<Post> findAll(long user_id);

    Post getById(long id, long user_id);

    void save(Post p, long user_id);

    void delete(long id, long user_id);

    void update(long id, Post post);

    List<Post> findPostByTitleContainingIgnoreCase(String str);
}
