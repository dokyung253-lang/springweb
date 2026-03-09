package practice.practice7;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.practice7.course.CourseEntity;
import practice.practice7.student.StudentEntity;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity@Table(name="enroll")
public class EnrollEntity extends BaseTime {
    // Enroll : 수강번호(enrollId, PK), 수강상태(status), 과정번호(FK), 학생번호(FK)
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollId;
    private boolean status;

    // 과정번호 fk
    @ManyToOne
    @JoinColumn(name="courseId")
    private CourseEntity courseEntity;

    // 학생번호 fk
    @ManyToOne
    @JoinColumn(name="studentId")
    private StudentEntity studentEntity;


}
