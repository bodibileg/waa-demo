package edu.miu.demo.service.impl;

import edu.miu.demo.domain.Post;
import edu.miu.demo.repo.PostRepo;
import edu.miu.demo.repo.UserRepo;
import edu.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public List<Post> findAll(long user_id) {
        var user = userRepo.findById(user_id).get();
        return user.getPosts();
    }

    @Override
    public Post getById(long id, long user_id) {
        var user = userRepo.findById(user_id).get();
        var post = user.getPosts().stream().filter(p -> p.getId() == id).findFirst().get();
        return post;
    }

    @Override
    public void save(Post p, long user_id) {
        var user = userRepo.findById(user_id).get();
        var posts = user.getPosts();
        posts.add(p);
        user.setPosts(posts);
        userRepo.save(user);
    }

    @Override
    public void delete(long id, long user_id) {
        var user = userRepo.findById(user_id).get();
        var posts = user.getPosts();
        posts = posts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
        user.setPosts(posts);
        userRepo.save(user);
    }

    @Override
    public void update(long id, Post post) {
    }
}
