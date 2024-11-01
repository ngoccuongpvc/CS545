package edu.miu.lab02.service.impl;

import edu.miu.lab02.entity.dtos.PostDto;
import edu.miu.lab02.entity.dtos.UserDto;
import edu.miu.lab02.repo.UserRepo;
import edu.miu.lab02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    private ModelMapper modelMapper;

    @Autowired
    UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long id) {
        return modelMapper.map(userRepo.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public void saveUser(UserDto user) {

    }

    @Override
    public List<PostDto> findUserPosts(Long id) {
        return Objects.requireNonNull(userRepo.findById(id).orElse(null)).getPosts().stream().map(user -> modelMapper.map(user, PostDto.class)).collect(Collectors.toList());
    }
}
