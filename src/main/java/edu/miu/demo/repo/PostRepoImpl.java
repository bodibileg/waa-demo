package edu.miu.demo.repo;

import edu.miu.demo.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static long postId = 5;

    static {
        posts = new ArrayList<>();

        posts.add(new Post(1, "The Art of Programming", "Programming is both an art and a science. It requires creativity and logic to create elegant and efficient code.", "John Doe"));
        posts.add(new Post(2, "Why Learning a Second Language is Important", "Learning a second language can expand your cultural horizons, improve your job prospects, and even delay the onset of Alzheimer's disease.", "Jane Smith"));
        posts.add(new Post(3, "The Benefits of Yoga", "Yoga can improve flexibility, reduce stress, and increase mindfulness. It's a great way to stay healthy and centered.", "David Kim"));
        posts.add(new Post(4, "The Science of Sleep", "Getting enough sleep is crucial for physical and mental health. It helps improve memory, boost creativity, and regulate mood.", "Sarah Jones"));

    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(long id) {
        var post = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void update(long id, Post p) {
        Post toUpdate = getById(id);
        if(p.getAuthor() != null) toUpdate.setAuthor(p.getAuthor());
        if(p.getContent() != null) toUpdate.setContent(p.getContent());
        if(p.getTitle() != null) toUpdate.setTitle(p.getTitle());
    }
}
