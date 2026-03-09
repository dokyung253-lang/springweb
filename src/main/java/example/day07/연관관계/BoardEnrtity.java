package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
@Entity @Table( name = "board")
public class BoardEnrtity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String bcontent;
    // ** 단방향 FK 만들기 **
    // @JoinColumn 관례적으로 fk 필드명도 pk필드명과 동일
    // @ManyToOne 다수가 하나에게 , 1:M , 여러개의 게시물이 하나의 카테고리에 여러개 게시물 참조
    @ManyToOne
    @JoinColumn( name = "cno")
    private CategoryEntity categoryEntity;
}
/*
create table board(
    bno integer not null auto_increment,
    bcontent varchar(255),
    primary key (bno)
    ) engine=InnoDB
*/
