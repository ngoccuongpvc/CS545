package edu.miu.lab01.controller;

import edu.miu.lab01.entity.dtos.PostDto;
import edu.miu.lab01.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<PostDto> getPosts() {
        return postService.findAllPosts();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable int id) {
        return postService.findPostById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id, @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto);
    }
}
