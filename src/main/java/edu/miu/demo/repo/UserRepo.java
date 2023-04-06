package edu.miu.demo.repo;

import edu.miu.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    List<User> findAll();

    List<User> findUsersByPostsGreaterThan(int num);
}
