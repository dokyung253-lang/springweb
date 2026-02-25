package example.day02.sevlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// 서블릿이란? 자바 회사에서 HTTP웹 동적처리 하기위한 라이브러리(미리 만든)/ 클래스
// 사용법
// 1. 현재 클래스의 "HttpServlet" 클래스로 부터 상속받는다. 상속이란? 다른 클래스로 부터 멤버변수/함수 물려받는 것이다.
// 2. 현재클래스 위에 @WebServlet("/URL") 주소 설정한다. 중복없이 영문으로 정의한다.
// 3. (스프링 환경에만 해당) AppStart 클래스 위에 @ServletComponentScan 주입하여 스프링이 서브릸 찾을 수 있도록 한다.
@WebServlet("/day02/servlet") // --> localhost:8080/day02/servlet 요청 시 통신 가능한 클래스 정의
public class ServletController extends HttpServlet {
    // 순수 자바의 메소드/함수
    boolean method( int param ){ return true; }

    @Override public void init(ServletConfig config) throws ServletException {
        // 1. 서블릿 클래스로 부터 HTTP 요청 시 init함수 최초 1번 실행된다.
        System.out.println("init 함수 실행");
        super.init(config);
    }

    // 2. 서블릿 클래스로부터 HTTP 요청마다 service함수 실행된다.
    @Override public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 함수 실행");
        super.service(req, res);
    }
}
