package practice.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // db 테이블과 자바 객체와 매핑(연결)
@Table( name = "book")
@Data @NoArgsConstructor @AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name= "bookId", nullable = false)
    // name 은 생략 시 , 자바 멤버변수명으로 자동 설정
    // @Column : 자바 카멜표기법 적용 X -> bookID = book_id
    // nullable 생략 => true 설정, length 생략 => 255 설정
    private Integer bookId;

    @Column( name = "bookTitle", length = 100, nullable = true )
    private String bookTitle;
    @Column( name = "bookAuthor", length = 30, nullable = true )
    private String bookAuthor;
    @Column( name = "bookCompany", length = 30, nullable = true )
    private String bookCompany;
} // 데이터들의 실재(Entity) <----> 영속성(Dto)
