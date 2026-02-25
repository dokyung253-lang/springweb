package example.day02.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Component // 빈 등록(싱글톤 대신)
// @Controller // Http 통신 + 빈 등록                    = 사용처 : view(화면) 반환
@RestController // ResponseBody + Http 통신 + 빈 등록    = 사용처 : 값(JSON) 반환
@RequestMapping("/day02")// @RequestMapping("/공통URL") 해당 컨트롤러 내 메소드들이 사용하는 공통 URL 정의한다.
public class RestController3 {
    // 1. 클래스가 @RestController 이므로 @ResponseBody 생략해도 된다.
    @GetMapping("/task6") // * 클래스가 @RequestMapping("/공통URL") 가지므로 localhost:8080/day02/task6
    public String method1(){ return "서버에게 받은 메세지";}
    // 2. http://localhost:8080/day02/task7?name=유재석&age=40
    @GetMapping("/task7") // 쿼리스트링이란? URL 주소 뒤로 ? 작성 후, 매개변수명1=값&매개변수명2=값
    public  int method2(@RequestParam String name, @RequestParam int age){ // 쿼리스트링매개변수명 == 메소드매개변수명
        // @RequestParam 이란? URL(웹주소) 안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 / *생략가능*
        System.out.println("RestController3.method2"); // sout+ m : 메소드명 출력 자동완성
        System.out.println("name = " + name + ", age = " + age); // sout+p : 메소드 매개변수 출력 자동완성
        return 3;
    }
} // class end
