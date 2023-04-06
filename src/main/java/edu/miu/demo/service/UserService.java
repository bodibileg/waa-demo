package edu.miu.demo.service;

import edu.miu.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getById(long id);

    void save(User user);

    void delete(long id);

    void update(long id, User user);

    List<User> findByPostsGreaterThan(int num);

    void seed(List<User> users);
}
