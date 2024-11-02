package edu.miu.lab03.entity.dtos;


import lombok.Data;

@Data
public class PostDto {
    private String id;
    private String title;
    private String content;
    private String author;
}
