package edu.miu.lab01.repo;

import edu.miu.lab01.entity.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post findById(long id);
    void save(Post post);
    void delete(long id);
    void update(long id, Post post);
    List<Post> findByAuthor(String author);
    List<Post> filterByAuthorName(String text);
}
