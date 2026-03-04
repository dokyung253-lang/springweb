package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    // R : 조회 select
    @GetMapping("/day05/exam")
    public List< ExamDto > 전체조회(){
        List< ExamDto > result = examService.전체조회();
        return result;
    }
    // C : 쓰기 insert
    // D : 삭제 delete
    // U : 추가 update
}
