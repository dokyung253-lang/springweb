package practice.practice7.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor@NoArgsConstructor @Builder
public class CourseDto {
    private Integer courseId;
    private String courseName;
    // baseTime
    private String createDate;
    private String updateDate;
}
