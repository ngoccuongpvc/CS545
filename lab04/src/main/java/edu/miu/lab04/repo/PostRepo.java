package edu.miu.lab04.repo;

import edu.miu.lab04.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getPostsByTitleContaining(String title);
}
