package example.종합.예제10.comment.entity;

import example.종합.예제10.comment.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder // 롬복
@Entity @Table( name = "comment")
public class CommentEntity extends BaseTime {
    @Id // pk
    @GeneratedValue( strategy = GenerationType.IDENTITY) // auto_increment
    private Integer bno;
    @Column( columnDefinition = "longtext not null") // 직접 sql 설정
    private String ccontent;
    @Column(length = 30, nullable = false ) // not null
    private String cwriter;
    // + 생성/수정 날짜/시간은 BaseTime 으로 상속받기

    // + entity --> dto 변환함수 : 주로 조회 +
    public CommentDto toDto(){
        return CommentDto.builder()
                .bno(bno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                .createDate(getCreateDate().toString()) // localdate(): 날짜만 출력, localtime(): 시간만
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
