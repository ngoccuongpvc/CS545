package edu.miu.lab03.repo;

import edu.miu.lab03.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, Long> {
}
