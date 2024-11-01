package edu.miu.lab02.repo;

import edu.miu.lab02.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, Long> {
}
