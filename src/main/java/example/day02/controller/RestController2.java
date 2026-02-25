package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller // Http 기능 + 빈 등록
public class RestController2 {

    // 1. 100을 반환하는 메소드
    @GetMapping("/day02/task1") // was(톰캣)주소/ 내가 정의한 주소, localhost:8080/day02/task
    @ResponseBody // Response(응답) Body(객체지향) : 응답자료 자동 타입변환
    // java(객체지향) <--번역--> http(문자), java는 int를 반환하겠다고 하지만 Http는 int 모른다.
    // 즉] java 타입을 자동으로 Http contents Type 변환해준다. int -> application/ json
    public int method1() {
        System.out.println("RestController2.method1"); return 100;
    }
    // 2. 문자열 반환하는 메소드
    @GetMapping("/day02/task2") @ResponseBody // java String -> text/plain
    public String method2( ){
        System.out.println("RestControllerw.method2"); return "유재석";
    }
    // 3. Map타입 변환하는 메소드
    @GetMapping("/day02/task3") @ResponseBody
    public Map< String, Object > method3(){
        Map< String, Object >map = new HashMap<>();
        map.put("유재석", 100); map.put("강호동",90);
        return map;
    }
    // 4. boolean 타입 반환하는 메소드
    @GetMapping("/day02/task4") @ResponseBody // java boolean -> application/json
    public boolean method4() {
        return true;
    }
    // 5. DTO 타입 반환하는 메소드
    @GetMapping("/day02/task5") @ResponseBody
    public TaskDto method5(){
        TaskDto taskDto = new TaskDto();
                taskDto.name = "유재석"; taskDto.point = 100;
                return taskDto;
    }
    // 즉]  String 제외한 자바의 대부분 타입은 Application/json으로 HTTP Content-type으로 설정된다.
} // class end
class TaskDto{ String name; int point;} // Dto
