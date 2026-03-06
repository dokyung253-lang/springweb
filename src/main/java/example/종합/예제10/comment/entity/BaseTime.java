package example.종합.예제10.comment.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 해당 클래스는 상속할 때 엔티티 매핑 포함
@Getter // 롬복 : 상속받은 클래스가 멤버변수 접근 허용
@EntityListeners( AuditingEntityListener.class ) // 해당 클래스의 JPA가 감사(Auditing)의 대상이 됨
public class BaseTime {
    @CreatedDate // 생성날짜/시간 주입
    private LocalDateTime createDate; // 생성날짜/시간
    @LastModifiedDate // 수정날짜/시간 주입
    private LocalDateTime updateDate; // 수정날짜/시간
}
