package edu.miu.demo.repo;

import edu.miu.demo.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment,Long> {

    List<Comment> findAll();
}
