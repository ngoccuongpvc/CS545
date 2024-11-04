package edu.miu.lab04.repo;

import edu.miu.lab04.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Log, Long> {
}
