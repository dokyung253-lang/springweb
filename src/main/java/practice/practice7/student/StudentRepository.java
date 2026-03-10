package practice.practice7.student;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.practice7.EnrollRepository;

public interface StudentRepository extends JpaRepository<StudentRepository, Integer> {
}
