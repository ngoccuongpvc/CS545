package edu.miu.lab05.repo;

import edu.miu.lab05.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Log, Long> {
}
