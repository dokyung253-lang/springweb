package test.employeeManager.Entity;

import jakarta.persistence.*;
import lombok.*;
import test.BaseTime;
import test.departmentManager.entity.DepartmentManagerEntity;
import test.employeeManager.dto.EmployeeManagerDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
@Entity @Table(name = "employee")
public class EmployeeManagerEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long eno; // 사원번호

    @Column(nullable = false)
    private String ephoto; // 사원 사진

    @Column(nullable = false, length = 30)
    private String ename; // 사원이름

    @Column(nullable = false, length = 100)
    private String eposition; // 사원직급

    @ManyToOne
    @JoinColumn( name = "dno") @ToString.Exclude
    private DepartmentManagerEntity departmentManagerEntity; // 사원번호 fk


    public EmployeeManagerDto toDto(){
        return EmployeeManagerDto.builder()
                .eno(eno) .ephoto(ephoto) .ename(ename) .eposition(eposition)
                .createDate(getCreateDate().toString()) .updateDate(getUpdateDate().toString())
                .build();
    }

}
