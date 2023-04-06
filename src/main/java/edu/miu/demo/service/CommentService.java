package edu.miu.demo.service;

import edu.miu.demo.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll(long post_id);

    Comment findById(long id, long post_id);

    void save(Comment comment, long post_id);

    void delete(long id, long post_id);

    void update(long id, Comment comment);

}
