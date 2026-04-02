package practice.srpractice1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.srpractice1.dto.TaskDto;
import practice.srpractice1.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // 서로다른 port(프로그램 식별번호) 간의 통신 허용
// SOP 정책으로 서로 다른 도메인은 통신이 불가능하다. HTTP 보안 정책
// CORS : 교차출처 리소스 공유, 즉] 서로 다른 도메인(8080:스프링, 5173:리액트) 통신 공유 허용
@RequiredArgsConstructor // final 생성자(@AutoWired) 대신
@RequestMapping("/api/task") // 리액트 경로 ("/task") vs 스프링 경로 중복될 수 있으므로, 백엔드는 도메인 앞 api 포함 권장("/api/task")
public class TaskController {
    public final TaskService taskService;

    // 1. 등록
    @PostMapping
    private ResponseEntity<?> taskPost(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.taskPost(taskDto));
    }

    // 2. 전체조회
    @GetMapping
    public ResponseEntity<?> taskList(){
        return ResponseEntity.ok(taskService.taskList());
    }

    // 3. 상세조회
    @GetMapping("/detail")
    public ResponseEntity<?> taskDetailList(Integer id){
        return ResponseEntity.ok(taskService.taskDetailList(id));
    }

    // 4. 수정
    @PutMapping
    public ResponseEntity<?> updateTask(@RequestParam Integer id, @RequestBody TaskDto request){
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    // 5. 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteTask(@RequestParam Integer id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
