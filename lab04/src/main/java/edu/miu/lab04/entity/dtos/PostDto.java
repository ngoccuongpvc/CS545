package edu.miu.lab04.entity.dtos;


import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private String id;
    private String title;
    private String content;
    private String author;
    private List<CommentDto> comments;
}
