package practice.practice5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository < BookEntity, Integer >{
}// JPA에서 CPUD 제공받기 위한 JpaRepository 상속 받기
