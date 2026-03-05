package practice.practice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

    /*문제1 요구사항]
             1. practice1 폴더 에서 서블릿 클래스 를 만들기
2. 해당 서블릿 클래스의 주소는 "/practice1" 정의하기
3.쿼리스트링 방식으로 데이터와 함께 서블릿 주소를 요청 보내기   EX) 서블릿주소?value=10
    실행 예시]
            1. GET 메소드 일때  : 보내온값의  + 2 를 해서 결과값을 응답하기 EX) 12
            2. Post 메소드 일때  : 보내온값의  * 2 를 해서 결과값을 응답하기  EX) 20
            3. Put 메소드 일때  : 보내온값의  / 2 를 해서 결과값을 응답하기 EX) 5
            4. Delete 메소드 일때  : 보내온값의  % 2 를 해서 결과값을 응답하기 EX) 0
*/
    /*
    서블릿 생성방법
    1단계) HttpServlet으로 부터 상속받기
    2단계) 서블릿클래스 위에 @WebServlet(), 서블릿의 주소 주입한다.
    3단계)
    */

  @WebServlet("/practice1")
  public class Practice1 extends HttpServlet{
        boolean method(int param ){return true; }

  /*    @Override
      public void init(ServletConfig config) throws ServletException {
          System.out.println("init함수 실행");
          super.init(config);
      }

      @Override
      protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("service함수 실행");
            super.service(req, resp);
      }
    */ // 안해도 됨

      // [1] C
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          // 1. 보내온 값 가져오기 = 요청한 정보가 들어있는 매개변수 : HttpServletRequest req
          System.out.println("Servlet.doPost");
          String value = req.getParameter("value"); // HT(Text)TP는 텍스트(문자)전송이 기본값이다.
          int value2 = Integer.parseInt(value) *2; // 타입변환, 스프링에서는 자동타입으로 해준다.
          // 2.
          resp.getWriter().println(value2);
          System.out.println("value2 = " + value2);
      }

      // [2] R
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int value2 = Integer.parseInt(req.getParameter("value")); // int a = ( (3+3) *2 )
          // 2. 계산된 값을 반환한다. = 요청한 클라이언트에게 계산결과를 응답한다.
          resp.getWriter().println(value2 +2);
      }

      // [3] U
      @Override
      protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int value2 = Integer.parseInt(req.getParameter("value")); // int a = ( (3+3) *2 )
          // 2. 계산된 값을 반홚나다. = 요청한 클라이언트에게 계산결과를 응답한다.
          resp.getWriter().println(value2 /2);
      }

      // [4] D
      @Override
      protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String value = req.getParameter("value"); // HT(Text)TP는 텍스트(문자)전송이 기본값이다.
          int value2 = Integer.parseInt(value); // 타입변환, 스프링에서는 자동타입으로 해준다.
          // 2.
          resp.getWriter().println(value2 %2);

      }
  }
