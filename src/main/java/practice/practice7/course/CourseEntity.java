package practice.practice7.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.BaseTime;
import practice.practice7.EnrollEntity;

import java.util.ArrayList;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity@Table(name="course")
public class CourseEntity extends BaseTime {
    // Course : 과정번호(courseId, PK), 과정명(courseName)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;

    @OneToMany(mappedBy = "courseEntity")
    @Builder.Default // 테이블명.Builder.build는 선택임
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

}
