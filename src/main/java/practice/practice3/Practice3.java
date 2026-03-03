//package practice.practice3;
// /* 작성 순서
// 1. practice -> practice3 폴더생성
// */
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController("/attendence")
//class AttendanceController {
//
//    // 1. 출석 등록
//    @PostMapping
//    public boolean 출석등록(@RequestParam AttendenceDto attendenceDto){
//        System.out.println("AttendanceController.출석등록");
//        System.out.println("attendenceDto = " + attendenceDto);
//        return true;
//    }
//    // 2. 출석 전체조회
//    @GetMapping //
// public List<AttendanceDto> 출석전체조회(){
//    List<AttendenceDto> list = new ArrayList<>();
//    list.add
// }
//}
//
//public class AttendenceDto { private int ano;
//    private String studentName;
//    private String date;
//    private String status;
//}
//
//
