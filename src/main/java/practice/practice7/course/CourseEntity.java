package practice.practice7.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.BaseTime;

import java.util.ArrayList;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity@Table(name="course")
public class CourseEntity extends BaseTime {
    // Course : 과정번호(courseId, PK), 과정명(courseName)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;

    @OneToMany(mappedBy = "enrollEntity")
    private List<CourseEntity> courseEntityList = new ArrayList<>();

}
