package edu.miu.demo.service.impl;

import edu.miu.demo.domain.Post;
import edu.miu.demo.repo.PostRepo;
import edu.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(long id) {
        return postRepo.getById(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, Post post) {
        postRepo.update(id, post);
    }
}
