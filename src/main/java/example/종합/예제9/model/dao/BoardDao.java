package example.종합.예제9.model.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component // 빈등록
public class BoardDao { connect();}
    // =========== 데이터베이스 연동 ============ //
    // 1) 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root"; private String password = "1234";
    // 2) 연동 인터페이스 변수 선언
    private Connection conn;