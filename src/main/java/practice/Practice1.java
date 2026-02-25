package practice;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Practice1 {
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

  @WebServlet("/practice1")
  public class Servlet extends HttpServlet{
        boolean method(int param ){return true; }

      @Override
      public void init(ServletConfig config) throws ServletException {
          System.out.println("init함수 실행");
          super.init(config);
      }

      @Override
      protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("service함수 실행");
            super.service(req, resp);
      }

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("Servlet.doGet");
          int data = req.getParameter(10);    System.out.println("data ="+ data);
            resp.getStatus().println();
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("Servlet.doPost");
          int data = req.getParameter(10);    System.out.println("data ="+ data);
          resp.getStatus().println();
      }

      @Override
      protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int data = req.getParameter(10);    System.out.println("data ="+ data);
          resp.getStatus().println();
      }

      @Override
      protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int data = req.getParameter(10);    System.out.println("data ="+ data);
          resp.getStatus().println();
      }
  }

}
