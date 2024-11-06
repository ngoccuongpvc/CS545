package edu.miu.lab05.repo;

import edu.miu.lab05.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getPostsByTitleContaining(String title);
}
