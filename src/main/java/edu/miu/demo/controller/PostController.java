package edu.miu.demo.controller;

import edu.miu.demo.domain.Post;
import edu.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{user_id}/posts")
public class PostController {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> findAll(@PathVariable long user_id) {

        return postService.findAll(user_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getById(@PathVariable long id, @PathVariable long user_id) {
        return postService.getById(id, user_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Post p, @PathVariable long user_id) {
        postService.save(p, user_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id, @PathVariable long user_id) {
        postService.delete(id, user_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Post post) {
        postService.update(id, post);
    }
}
