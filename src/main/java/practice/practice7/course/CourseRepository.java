package practice.practice7.course;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.practice7.student.StudentRepository;

public interface CourseRepository  extends JpaRepository<CourseRepository, Integer> {
}
