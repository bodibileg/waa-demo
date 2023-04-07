package edu.miu.demo.controller;

import edu.miu.demo.aspect.annotation.ExecutionTime;
import edu.miu.demo.domain.User;
import edu.miu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(
//            @RequestParam(name = "post-count", required = false) String num
    ) {
//        if(num != null) return userService.findUsersByPostsGreaterThanEqual(Integer.parseInt(num));
//        else
            return userService.findAll();
    }

    @GetMapping("/post-count/{num}")
    public List<User> findByPostCount(@PathVariable int num) {
        return userService.findByPostsGreaterThan(num);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public User findById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("seed")
    public void save(@RequestBody List<User> users) {
        userService.seed(users);
    }
}
