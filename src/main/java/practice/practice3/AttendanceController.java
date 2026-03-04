package practice.practice3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController{
    // 1. 출석 등록
    @PostMapping
    // "ano"생략 시 DTO에서 int -> Integer 래퍼클래스
    public boolean 출석등록(@RequestBody AttendenceDto attendenceDto){
        System.out.println("AttendanceController.출석등록");
        System.out.println("attendenceDto = " + attendenceDto);
        return true;
    }
    // 2. 출석 전체조회
    @GetMapping
    public List<AttendenceDto> 출석전체조회(){
        List<AttendenceDto> list = new ArrayList<>();
        list.add( new AttendenceDto(1, "유재석", "2026-02-06", "출석") );
        list.add( AttendenceDto.builder().status("출석").studentName("강호동"). date("2026-02-26").ano(1).build());
        return list;
    }
}