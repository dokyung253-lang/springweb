package practice.practice7;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.practice7.student.StudentRepository;

public interface EnrollRepository  extends JpaRepository<EnrollRepository, Integer> {
}
