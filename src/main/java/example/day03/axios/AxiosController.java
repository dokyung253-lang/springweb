package example.day03.axios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day03/task")
public class AxiosController {
    @GetMapping
    public void method1(){
        System.out.println("AxiosController.method1");
    }
    @DeleteMapping
    public int method2(@RequestParam String name){
        System.out.println("AxiosController.method");
        return 10;
    }
}
