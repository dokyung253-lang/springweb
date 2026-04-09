package test.departmentManager.entity;

import jakarta.persistence.*;
import lombok.*;
import test.BaseTime;
import test.departmentManager.dto.DepartmentManagerDto;
import test.employeeManager.Entity.EmployeeManagerEntity;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
@Entity @Table(name = "department")
public class DepartmentManagerEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long dno; // 부서번호

    @Column(nullable = false, length = 30)
    private String dname; //부서명

    @OneToMany(mappedBy = "departmentManagerEntity")
    public List<EmployeeManagerEntity> employeeManagerEntityList = new ArrayList<>();

    // toDto
    public DepartmentManagerDto toDto(){
        return DepartmentManagerDto.builder()
                .dno(dno) .dname(dname)
                .createDate(getCreateDate().toString()) .updateDate(getUpdateDate().toString())
                .build();
    }
}
