package springweb.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.board.entity.BoardEntity;


@Builder @NoArgsConstructor@AllArgsConstructor @Data
public class BoardDto {
    private Long bno; // 게시물번호
    private String btitle; // 게시물제목
    private String bcontent; // 게시물 내용
    private String bfile; // 게시물 첨부파일 , 만약 게시물당 첨부파일 여러개면 엔티티 분리

    // 조회용
    // + DTO에는 엔티티 정보를 포함하지 않고 필요한 정보만 멤버변수에 저장
    private Long mno; // 회원번호
    private String mname; // 회원닉네임
    // + BaseTime
    private String CreateDate;
    private String updateDate;

    // + toEntity
    public BoardEntity toEntity(){
        return BoardEntity .builder()
                // .bno(bno)는 자동 생성
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                // .memberEntity() fk는 서비스에서 대입
                .build();
    }
}
