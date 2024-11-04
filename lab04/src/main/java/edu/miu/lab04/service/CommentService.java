package edu.miu.lab04.service;

import edu.miu.lab04.entity.dtos.CommentDto;

public interface CommentService {
    public void addCommentToPost(long postId, CommentDto commentDto);
}
