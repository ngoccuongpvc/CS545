package edu.miu.lab05.service.impl;

import edu.miu.lab05.entity.Comment;
import edu.miu.lab05.entity.Post;
import edu.miu.lab05.entity.dtos.CommentDto;
import edu.miu.lab05.repo.CommentRepo;
import edu.miu.lab05.repo.PostRepo;
import edu.miu.lab05.service.CommentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo, PostRepo postRepo, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCommentToPost(long postId, CommentDto commentDto) {
        final Post post = entityManager.getReference(Post.class, postId);
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        commentRepo.save(comment);
    }
}
