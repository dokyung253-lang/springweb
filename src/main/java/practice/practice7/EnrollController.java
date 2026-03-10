package practice.practice7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EnrollController {
    @Autowired
    private EnrollService enrollService;
    // 1. 과정 등록 http://localhost:8080/add1
    // 매개변수 : cname, { "cname" : "자바" }
    // 반환값 : boolean , t/f

    @PostMapping("/add1") // Map 타입이란? key와 value 한쌍(엔트리)으로 여러 엔트리 저장한다. == JSON / DTO
    public boolean add1(@RequestBody Map<String, Object>map){
        boolean result = enrollService.add1(map);
        return result;
    }

    // 2. 학생등록 http://localhost:8080/add2
    // 매개변수 : sname , { "sname" : 유재석 }
    // 반환값 : boolean, t/f
    @PostMapping("/add2") // Map 타입이란? key와 value 한쌍(엔트리)으로 여러 엔트리 저장한다. == JSON / DTO
    public boolean add2(@RequestBody Map<String, Object>map) {
    boolean result = enrollService.add2(map);
    return result;
    }

    // 3. 수강신청 목록 http://localhost:8080/add2
    // 매개변수 : status, cid, sid , {"status" : "신청", "cid" : 1, "sid" : 1 }
    // 반환값 : boolean
    @PostMapping("/add3") // Map 타입이란? key와 value 한쌍(엔트리)으로 여러 엔트리 저장한다. == JSON / DTO
    public boolean add3(@RequestBody Map<String, Object>map) {
        boolean result = enrollService.add3(map);
        return result;
    }

    // 4. 개별 수강정보 조회 http://localhost:8080/get?eid=1
    // 매개변수 : eid, { "eid" : 1 }
    // 반환값 : dto/ map
    @GetMapping("/get")
    public Map<String, Object> get(@RequestParam int eid){
        return enrollService.get(eid);
    }
}
