package example.종합.예제10.comment.dto;

import example.종합.예제10.comment.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class CommentDto {
    private Integer bno;
    private String ccontent;
    private String cwriter;
    private String createDate;
    private String updateDate;

    // + dto ---> entity 변환 함수 : 주로 저장 *
    public CommentEntity toEntity(){
        return CommentEntity.builder()
                // bno, createDate, updateDate 자동이라서 생략 가능
                .ccontent(ccontent)
                .cwriter(cwriter)
                .build();
    }

}
