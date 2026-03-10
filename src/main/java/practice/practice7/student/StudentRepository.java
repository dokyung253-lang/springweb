package practice.practice7.student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository< StudentEntity, Integer> {
}
