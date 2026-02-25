package example.day02.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return 7;
    }
    // 3.
    @GetMapping ("/task8") // 만약에 쿼리스트링의 매개변수명과 자바의 매개변수명이 다르면 @RequestParam( name = "쿼리스트링매개변수명" )
    public int method3(@RequestParam(required = false) String name, @RequestParam int age ){
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", age = " + age);
        return 8;
    }
    // 4. http://localhost:8080/day02/task9?name=유재석&age=40
    @DeleteMapping ("/task9") // Get/Delete 메소드는 구조와 사용법이 동일하다.
    public int method4( String name, @RequestParam(defaultValue = "19") int age){
        // 만약에 @RequestMapping 생략해도 매개변수 매핑(연결) 가능하다.
        // 만약에 쿼리스트링에 존재하지 않을 때 기본값으로 설정하기, @RequestParam( defaultValue = "초기값")
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;
    }
} // class end

