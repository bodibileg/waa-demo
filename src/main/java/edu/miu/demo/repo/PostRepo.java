package edu.miu.demo.repo;

import edu.miu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post,Long> {

    List<Post> findAll();

    List<Post> findPostByTitleContainingIgnoreCase(String str);
}
