package edu.miu.lab02.service;

import edu.miu.lab02.entity.dtos.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
    PostDto findPostById(long id);
    void addPost(PostDto postDto);
    void deletePost(long id);
    void updatePost(long id, PostDto postDto);
}
