package edu.miu.lab05.service;

import edu.miu.lab05.entity.dtos.PostDto;
import edu.miu.lab05.entity.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto findUserById(Long id);
    void saveUser(UserDto user);
    void deleteUser(Long id);
    List<PostDto> findUserPosts(Long id);
    List<UserDto> findUsersByNumberOfPost(int num);
}
