package edu.miu.lab04.service;

import edu.miu.lab04.entity.dtos.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
    List<PostDto> findPostsByTitle(String title);
    PostDto findPostById(long id);
    void addPost(PostDto postDto);
    void deletePost(long id);
    void updatePost(long id, PostDto postDto);
}
