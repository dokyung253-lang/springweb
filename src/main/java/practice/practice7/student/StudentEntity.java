package practice.practice7.student;


import jakarta.persistence.*;
import lombok.*;
import practice.practice7.BaseTime;
import practice.practice7.EnrollEntity;

import java.util.ArrayList;
import java.util.List;

@Data@AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name="student")
public class StudentEntity extends BaseTime {
    // Student : 학생번호(studentId, PK), 학생명(studentName)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;

    @OneToMany(mappedBy = "studentEntity") // 양방향 : 자바에서 쓰는 거(조회용), 데이터베이스 지원 안 함, pk/fk 없음, 필드명으로 조인
    @ToString.Exclude @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();
}
