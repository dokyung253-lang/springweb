package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Http 기능 + 빈 등록
public class RestController2 {

    // 1. 100을 반환하는 메소드
    @GetMapping("/day02/task") // was(톰캣)주소/ 내가 정의한 주소, localhost:8080/day02/task
    @ResponseBody // Response(응답) Body(객체지향) : 응답자료 자동 타입변환
    // java(객체지향) <--번역--> http(문자), java는 int를 반환하겠다고 하지만 Http는 int 모른다.
    // 즉] java 타입을 자동으로 Http contents Type 변환해준다. int -> application/ json
    public int method1() {
        System.out.println("RestController2.method1"); return 100;
    }
}
