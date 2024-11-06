package edu.miu.lab05.repo;

import edu.miu.lab05.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepo extends JpaRepository<Exception, Long> {
}
