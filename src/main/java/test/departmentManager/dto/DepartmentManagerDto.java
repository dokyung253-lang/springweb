package test.departmentManager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.departmentManager.entity.DepartmentManagerEntity;
import test.employeeManager.Entity.EmployeeManagerEntity;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class DepartmentManagerDto {
    private Long dno; // 부서번호
    private String dname; //부서명
    private String eno; // 사원번호 fk
    private String createDate;
    private String updateDate;

    public DepartmentManagerEntity toEntity(){
        return DepartmentManagerEntity.builder()
                .dno(dno) .dname(dname)
                .build();
    }

}
