package example.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired private TodoRepository todoRepository;

    // [post] http://localhost:8080/
    //  { "title" : "장보기", "content" : "00마트", "done" : "false"}
    @PostMapping("/")
    public boolean 등록하기(@RequestBody TodoEntity todoEntity){
        todoRepository.save(todoEntity);
        return true;
    }

    // [get] http://localhost:8080/
    @GetMapping("/")
    public List<TodoEntity> 조회하기(){
        return todoRepository.findAll();
    }
}
