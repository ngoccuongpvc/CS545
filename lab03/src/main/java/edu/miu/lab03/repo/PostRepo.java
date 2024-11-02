package edu.miu.lab03.repo;

import edu.miu.lab03.entity.Post;
import edu.miu.lab03.entity.dtos.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getPostsByTitleContaining(String title);
}
