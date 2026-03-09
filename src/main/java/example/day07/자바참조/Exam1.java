package example.day07.자바참조;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {

        // 자바는 객체지향 언어이다.
        // System : 클래스 , System.out : 객체, println( ) : 함수/메소드
        // 즉] 특정한 객체가 특정한 함수 실행한다. // .(점) : 참조(연산자)
        System.out.println("출력함수");

        // [1] 카테고리 객체 생성 == 클래스(설계도)로 메모리(인스턴스) 생성 뜻
        // 동일한 클래스(설계도)로 서로다른 객체(인스턴스) 생성한다.
        Category category = new Category(); // Category설계도 안의 객체 2개 중 1개; 101호
        category.setCno(1); category.setCname("공지사항");

        Category category2 = new Category(); // Category설계도 안의 객체 2개 중 1개; 102호
        category2.setCno(2); category2.setCname("자유게시판");

        // [2] 게시물 객체 생성 , 참조란? 다른 값 접근한다. [ Fk ]
        // 즉] ORM(JPA) 기술은 이러한 객체참조로 데이터베이스의 Pk-Fk 구현
        // 단방향 : Fk를 통해 Pk를 참조하는 것처럼, 특정한 객체 통해 참조 객체를 참조한다.
        // 즉] 게시물 객체 통해 카테고리객체를 참조한다. 카테고리 객체를 통해 게시물객체는 참조 못 한다.
        // 2-1. 첫번째 게시물은 공지사항이다.
        Board board = new Board();           // board설계도 안의 객체 1개; 201호
        board.setBcontent("첫 번째 게시물 입니다.");
        board.setCategory(category); // 첫 번째 카테고리 객체를 게시물 객체에 대입한다; 201호 안에 101호 참조

        // 2-2. 두 번째 게시물은 자유게시판이다.
        Board board2 = new Board();
        board2.setBcontent("두 번째 게시물 입니다.");
        board2.setCategory(category2);  // 202호 안에 102호 참조(pk -fk: fk를 보고 pk 유추 가능)

        // [3] 카테고리가 게시물 참조
        // 양방향 : 두 객체 간의 서로 참조하는 관계, 데이터베이스는 존재하지 않는다.
        // 즉] ORM(JPA) : 단방향/양방향 모두 지원// 특 : 조회 빠름 , JOIN 불필요
        // 1. 순환참조문제점 2. 복잡한 JOIN 3. LAZY(지연로딩) 고려
        category.getBoardList().add(board); // 101호에 201호 참조 대입한다.
        category2.getBoardList().add(board2); // 102호에 202호 참조 대입한다.

        // 확인
        // FK 에서 PK 단방향 참조/조회;
        System.out.println(board2.getCategory());
        // PK 에서 FK 양방향 참조/조회
        // StackOverflowError : 양방향 참조하다가 메모리 넘쳤다.
        // 해결방안 : 두 객체 간의 한쪽 필드에 @ToString.Exclude 주입한다.
        System.out.println(category.getBoardList());
    }
}

@Data // 롬복
class Category{ // 공지사항 ; 설계도 1개
    private int cno;      // 카테고리 번호
    private String cname; // 카테고리 이름
    @ToString.Exclude // 순환참조 방지
    private List<Board> boardList = new ArrayList<>(); // 양방향 참조, Fk 느낌
}
@Data
class Board{ // 게시물 ; 설계도 1개
    private int bno;
    private String bcontent;
    private Category category; // 다른 객체를 "참조" // 단방향 참조
}

