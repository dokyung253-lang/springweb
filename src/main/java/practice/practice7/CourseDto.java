package practice.practice7;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor@NoArgsConstructor @Builder
public class CourseDto {
    private Integer courseId;
    private String courseName;
    // basetime
    private String createDate;
    private String updateDate;
    // dto > entity
    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .courseId(courseId);
                .courseName(courseName);
                .build();
    }
}
