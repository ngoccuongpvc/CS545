package edu.miu.lab01.repo.impl;

import edu.miu.lab01.entity.Post;
import edu.miu.lab01.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
public class PostRepoImpl implements PostRepo {
    private static final List<Post> posts = new ArrayList<>();
    static {
        posts.add(new Post(1, "Post 1", "This is a post 1", "MrA"));
        posts.add(new Post(2, "Post 2", "This is a post 2", "MrA"));
        posts.add(new Post(3, "Post 3", "This is a post 3", "Bob"));
        posts.add(new Post(4, "Post 4", "This is a post 4", "Charlie"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    @Override
    public void delete(long id) {
        Post found = findById(id);
        if (found != null) {
            posts.remove(found);
        }
    }

    @Override
    public void update(long id, Post post) {
        Post found = findById(id);
        if (found != null) {
            found.setTitle(post.getTitle());
            found.setContent(post.getContent());
            found.setAuthor(post.getAuthor());
        }
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream().filter(post -> Objects.equals(post.getAuthor(), author)).collect(Collectors.toList());
    }

    @Override
    public List<Post> filterByAuthorName(String text) {
        return List.of();
    }
}
