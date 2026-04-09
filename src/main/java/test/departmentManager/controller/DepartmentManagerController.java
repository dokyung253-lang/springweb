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
    public ResponseEntity<?> DepartmentCreate(@RequestBody DepartmentManagerDto dto) {
        if (dto == null || dto.getDname() == null) {
            return ResponseEntity.badRequest().body(false);
        }
        return ResponseEntity.ok(departmentManagerService.DepartmentCreate(dto));
    }

    // 부서 전체조회
    @GetMapping("/get")
    public ResponseEntity<?> GetDepartment() {
        return ResponseEntity.ok(departmentManagerService.GetDepartment());
    }

    // 부서 수정
    @PutMapping("update")
    public ResponseEntity<?> updateDepartment(@RequestParam Long dno, @RequestBody DepartmentManagerDto request){
        return ResponseEntity.ok(departmentManagerService.updateDepartment(dno, request));
    }

    // 부서 삭제
    @DeleteMapping("delete")
    public ResponseEntity<?> deleteDepartment(@RequestParam Long dno){
        departmentManagerService.deleteDepartment(dno);
        return ResponseEntity.ok("부서 번호 " + dno + "번이 성공적으로 삭제되었습니다.");    }
}


