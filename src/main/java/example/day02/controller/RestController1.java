package example.day02.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// Rest란? HTTP GET/POST/PUT/DELETE 활용하여 통신
// CONTROLLER란? VIEW(client)와 model(DAO) 사이의 통신 중계
// @Component // 스프링이 해당 클래스를 이해할 수 있게 스프링 컨테이너에 빈(객체) 정보 등록  vs 싱글톤 생성
@Controller// @Component + Http 기능까지 포함된 어노테이션 (서블릿 포함)
public class RestController1{
    // 1] @COntroller( + Component )이므로 싱글톤 생략
    // 2] Http 기능(방법/함수/메소드/행위)
    // XXXMapping : 클라이언트가 요청한 HTTP 메소드와 매핑(연결) 어노테이션
    @PostMapping    // 2-1 post
    public void 등록하기(){
        System.out.println("RestController1.등록하기");
    }
    @GetMapping     // 2-2 get
    public void 조회하기(){
        System.out.println("RestController1.조회하기");
    }
    @PutMapping     // 2-3 put
    public void 수정하기(){
        System.out.println("RestController1.수정하기");
    }
    @DeleteMapping  // 2-4 delete
    public void 삭제하기(){
        System.out.println("RestController1.삭제하기");
    }
}// class end
