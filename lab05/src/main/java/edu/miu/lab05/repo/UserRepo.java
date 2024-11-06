package edu.miu.lab05.repo;

import edu.miu.lab05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where size(u.posts) >= :n")
    public List<User> findAllByNumberOfPost(int n);

    public User findByEmail(String email);
}
