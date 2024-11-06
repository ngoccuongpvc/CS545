package edu.miu.lab05.entity.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long id;
    private String username;

    private List<PostDto> posts;
}
