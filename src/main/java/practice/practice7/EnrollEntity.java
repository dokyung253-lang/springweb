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
    private Integer eid;
    private String status;

    // 과정번호 fk
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="cid") // 데이터베이스에서는 cid와 조인, 자바에서는 Id와 조인
    private CourseEntity courseEntity;

    // 학생번호 fk
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="sid")
    private StudentEntity studentEntity;


}
