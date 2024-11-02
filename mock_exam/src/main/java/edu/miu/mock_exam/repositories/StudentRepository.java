package edu.miu.mock_exam.repositories;

import edu.miu.mock_exam.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
