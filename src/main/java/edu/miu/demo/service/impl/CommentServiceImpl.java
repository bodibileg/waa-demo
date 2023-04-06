package edu.miu.demo.service.impl;

import edu.miu.demo.domain.Comment;
import edu.miu.demo.repo.CommentRepo;
import edu.miu.demo.repo.PostRepo;
import edu.miu.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;


    @Override
    public List<Comment> findAll(long post_id) {
        var post = postRepo.findById(post_id).orElseThrow(() -> new NoSuchElementException("Post with ID " + post_id + " not found."));;
        return post.getComments();
    }

    @Override
    public Comment findById(long id, long post_id) {
        var post = postRepo.findById(post_id).orElseThrow(() -> new NoSuchElementException("Post with ID " + post_id + " not found."));
        var comment = post.getComments().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if(comment != null) return comment;
        else throw new NoSuchElementException("Comment with ID " + id + " not found.");
    }

    @Override
    public void save(Comment comment, long post_id) {
        var post = postRepo.findById(post_id).orElseThrow(() -> new NoSuchElementException("Post with ID " + post_id + " not found."));
        var comments = post.getComments();
        comments.add(comment);
        post.setComments(comments);
        System.out.println("post ==> " + post);
        postRepo.save(post);
//        commentRepo.save(comment);
    }

    @Override
    public void delete(long id, long post_id) {
        var post = postRepo.findById(post_id).orElseThrow(() -> new NoSuchElementException("Post with ID " + post_id + " not found."));
        var comments = post.getComments();
        comments = comments.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        post.setComments(comments);
        postRepo.save(post);
        commentRepo.deleteById(id);
    }

    @Override
    public void update(long id, Comment comment) {

    }
}
