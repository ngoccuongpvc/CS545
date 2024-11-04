package edu.miu.lab04.controller;


import edu.miu.lab04.aspect.annotation.ExecutionTime;
import edu.miu.lab04.entity.dtos.PostDto;
import edu.miu.lab04.entity.dtos.UserDto;
import edu.miu.lab04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ExecutionTime
    public UserDto getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getUserPosts(@PathVariable long id) {
        return userService.findUserPosts(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/posts/{count}")
    public List<UserDto> getUsersByNumberOfPosts(@PathVariable int count) {
        return userService.findUsersByNumberOfPost(count);
    }

    @GetMapping("/exception")
    public void testExceptionLogger() {
        throw new RuntimeException("Test Exception");
    }
}
