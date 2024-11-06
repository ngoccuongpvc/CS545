package edu.miu.lab05.service;

import edu.miu.lab05.entity.dtos.CommentDto;

public interface CommentService {
    public void addCommentToPost(long postId, CommentDto commentDto);
}
