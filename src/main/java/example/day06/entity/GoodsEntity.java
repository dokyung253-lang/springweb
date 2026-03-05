package example.day06.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder// 세 개가 롬복
@Entity @Table(name="goods") // + 영속성
public class GoodsEntity extends BaseTime{
    @Id // JPA는 엔티티 내 1개 이상의 pk를 필수로 한다.
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer gno ;   // 제품번호
    @Column(name = "제품명", nullable = false, length = 100 , unique = true, insertable = true, updatable = true )
    private String gname;   // 제품명
    @Column( columnDefinition = "varchar(100) default '제품설명' not null") // DB 수동 수정
    private String gdesc;   // 제품설명
    @Column // 생략 시 : 자바 타입 = sql 타입, 자바 변수명 = sql 필드명
    private Integer gprice; // 제품가격

    // ** ENTITY --> DTO 변환함수
    public GoodsDto toDto(){
        return GoodsDto.builder()
                .gno( gno )         .gname(gname)
                .gprice(gprice)     .gdesc( gdesc)
                .createDate( getCreatable().toString() ) // .toString : 날짜를 문자형식으로
                .updateDate( getUpdatable().toString() )
                .build();
    }
}
/*
@Id : primary key
@GeneratedValue( strategy = GenerationType.IDENTITY ) : auto_increment
@Column( )
 name = “필드명”           , 기본값 : 자바필드명
 nullable = false         , 기본값 : true , not null
 length = 길이             , 기본값 : 255 , varchar(길이)
 unique = true            ,  기본값 : false , 중복여부
 insertable = true        , 기본값 : true , insert할 때 적용여부
 updatable = true         , 기본값 : true , update 할 때 적용여부
 columnDefinition = "SQL" , JPA가 아닌 실제 SQL 쿼리 작성
 JPA 지원 : 레코드 생성날짜(회원가입등록작성일 등) , 수정날짜

*/