package test.departmentManager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.departmentManager.dto.DepartmentManagerDto;
import test.departmentManager.service.DepartmentManagerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
@CrossOrigin(value = "http://localhost:5173", exposedHeaders = "Authorization")
public class DepartmentManagerController {
    private final DepartmentManagerService departmentManagerService;

    // 부서 등록
    @PostMapping("/create")
    public ResponseEntity<?> DepartmentCreate(@RequestBody DepartmentManagerDto dto){
        if( dto == null || dto.getDname() == null){ return ResponseEntity.badRequest().body(false); }
        return ResponseEntity.ok(departmentManagerService.DepartmentCreate(dto));
    }

    // 부서 전체조회
    @GetMapping("/read")
    public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(departmentManagerService.findAll());
    }

    // 부서 삭제

}


