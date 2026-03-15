package example.day09.springBootDeveloprer.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data // toString, getter, setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)// NoArgsConstructor: 빈 생성자,  access=AccessLevel.PROTECTED: 접근제한자 설정(내부 파일만 접근 가능)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false) // updatable=false: 수정불가능
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

public void update( String title, String content){
    this.title=title;
    this.content=content;
    }

    @CreatedDate // 엔티티가 생성될 때 생성시간 저장
    @Column(name="created_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateAt;
}
