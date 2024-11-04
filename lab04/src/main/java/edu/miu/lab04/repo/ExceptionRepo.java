package edu.miu.lab04.repo;

import edu.miu.lab04.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepo extends JpaRepository<Exception, Long> {
}
