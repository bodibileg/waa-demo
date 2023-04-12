package edu.miu.demo.repo;

import edu.miu.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    List<User> findAll();

    //@Query( "select p from Product p where count(p.reviews) >= :num" )

//    @Query("select u from User u where count(u.posts) >= :num")
    @Query("SELECT u FROM User u JOIN u.posts p GROUP BY u.id HAVING SIZE(u.posts) = :num ")
    List<User> findByPostsGreaterThan(int num);

    User findByEmail(String username);
}
