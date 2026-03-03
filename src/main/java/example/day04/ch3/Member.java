package example.day04.ch3;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor( access = AccessLevel.PROTECTED) // 빈생성자 이면서 protected 접근 제한
@AllArgsConstructor // 전체매개변수를 갖는 (자동생성) 생성자
@Getter // getter(자동생성) 메소드
@Entity // DB에 테이블 레코드와 매핑(연결)하는 기술 : ORM Object Relational Mapping(자바 객체 <--> DB레코드)
public class Member {
    @Id // Primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    @Column( name = "id",  updatable = false ) // 필드/속성 설정, 수정 불가능
    private Long id;

    @Column(name = "name", nullable = false) // 필드/속성명 설정, not null
    private String name;

}
