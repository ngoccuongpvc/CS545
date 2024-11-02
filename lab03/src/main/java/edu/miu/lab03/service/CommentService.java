package edu.miu.lab03.service;

import edu.miu.lab03.entity.dtos.CommentDto;

public interface CommentService {
    public void addCommentToPost(long postId, CommentDto commentDto);
}
