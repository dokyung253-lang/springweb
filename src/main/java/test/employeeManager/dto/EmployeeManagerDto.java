package test.employeeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.employeeManager.Entity.EmployeeManagerEntity;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class EmployeeManagerDto {
    private Long eno; // 사원번호
    private String ephoto; // 사원 사진
    private String ename; // 사원이름
    private String eposition; // 사원직급
    private String createDate;
    private String updateDate;

    public EmployeeManagerEntity toEntity(){
        return EmployeeManagerEntity.builder()
                .eno(eno) .ephoto(ephoto) .ename(ename) .eposition(eposition)
                .build();

    }

}
