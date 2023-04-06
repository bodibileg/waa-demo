package edu.miu.demo.controller;

import edu.miu.demo.domain.Comment;
import edu.miu.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{user_id}/posts/{post_id}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> findAll(@PathVariable long post_id) {
        return commentService.findAll(post_id);
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable long id, @PathVariable long post_id) {
        return commentService.findById(id, post_id);
    }

    @PostMapping
    public void save(@RequestBody Comment comment, @PathVariable long post_id) {
        commentService.save(comment, post_id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id, @PathVariable long post_id) {
        commentService.delete(id, post_id);
    }
}
