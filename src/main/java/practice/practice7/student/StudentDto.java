package practice.practice7.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Integer sid;
    private String sname;
    // baseTime
    private String createDate;
    private String updateDate;
}
