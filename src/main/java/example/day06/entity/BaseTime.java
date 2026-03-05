package example.day06.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 1) 엔티티 슈퍼클래스(상속용도 클래스)
@Getter // 2) 상속받은 엔티티가 멤버변수 사용
@EntityListeners( AuditingEntityListener.class ) // 4) 해당 엔티티 자동 감시 적용
public class BaseTime {
    @CreatedDate        // 3) 엔티티 생성날짜/시간 주입
    private LocalDateTime creatable;
    @LastModifiedDate   // 4) 엔티티 수정날짜/시간 주입
    private LocalDateTime updatable;
}
