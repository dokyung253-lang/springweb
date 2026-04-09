package test.departmentManager.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import test.departmentManager.dto.DepartmentManagerDto;
import test.departmentManager.entity.DepartmentManagerEntity;
import test.departmentManager.repository.DepartmentManagerRepository;

import java.util.List;

@Service @RequiredArgsConstructor
public class DepartmentManagerService {
    private final DepartmentManagerRepository departmentManagerRepository;

    // 부서 등록
    public boolean DepartmentCreate(DepartmentManagerDto dto) {
        DepartmentManagerEntity saveEntity = dto.toEntity();
        DepartmentManagerEntity savedEntity = departmentManagerRepository.save( saveEntity );
        if( savedEntity.getDno() > 0){ return true; }
        return false;
    }
    // 부서 전체조회
    public List<DepartmentManagerDto> GetDepartment() {
        return departmentManagerRepository.findAll()
                .stream()
                .map(DepartmentManagerEntity::toDto)
                .toList();
    }

    // 부서 수정
    @Transactional
    public DepartmentManagerDto updateDepartment (Long dno, DepartmentManagerDto request){
        DepartmentManagerEntity entity = departmentManagerRepository.findById(dno).orElseThrow();
        entity.setDname(request.getDname());
    return entity.toDto();
    }

    // 부서 삭제
    public void deleteDepartment( Long dno ){
        DepartmentManagerEntity department = departmentManagerRepository.findById(dno).orElseThrow();
         departmentManagerRepository.delete(department);
    }
}

