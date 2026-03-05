package practice.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookDto {
    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCompany;
} // DTO : 데이터들을 이동하는 객체
// 기능 상황에 따라서 각 (등록·조회·수정·삭제)dto 생성, 왜? 보안상의 이유
