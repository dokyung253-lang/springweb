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
    private Integer studentId;
    private String studentName;
    // baseTime
    private String createDate;
    private String updateDate;
}
