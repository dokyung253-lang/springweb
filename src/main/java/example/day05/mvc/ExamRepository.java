package example.day05.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository< ExamEntity, Integer > {
    // extends JpaRepository< 조작할 엔티티명, PK타입 >
} // Repository 데이터베이스의 특정한 엔티티/테이블( DML )을 조작하는 인터페이스
