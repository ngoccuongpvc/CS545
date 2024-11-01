package edu.miu.lab02.repo;

import edu.miu.lab02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
