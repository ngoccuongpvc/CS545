package edu.miu.lab02.service;

import edu.miu.lab02.entity.dtos.PostDto;
import edu.miu.lab02.entity.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto findUserById(Long id);
    void saveUser(UserDto user);
    List<PostDto> findUserPosts(Long id);
}
