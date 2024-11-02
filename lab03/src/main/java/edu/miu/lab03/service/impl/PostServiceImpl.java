package edu.miu.lab03.service.impl;

import edu.miu.lab03.entity.Post;
import edu.miu.lab03.entity.dtos.PostDto;
import edu.miu.lab03.repo.PostRepo;
import edu.miu.lab03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    private ModelMapper modelMapper;

    @Autowired
    PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> findAllPosts() {
        return postRepo.findAll().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostsByTitle(String title) {
        return postRepo.getPostsByTitleContaining(title).stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findPostById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void addPost(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        Post post = postRepo.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(postDto.getTitle());
            post.setAuthor(postDto.getAuthor());
            post.setContent(postDto.getContent());
            postRepo.saveAndFlush(post);
        }
    }
}
