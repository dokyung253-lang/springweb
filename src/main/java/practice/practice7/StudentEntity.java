package practice.practice7;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data@AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name="student")
public class StudentEntity extends BaseTime  {
    // Student : 학생번호(studentId, PK), 학생명(studentName)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;

    @OneToMany(mappedBy = "enrollEntity")
    @ToString.Exclude
    private List<StudentEntity> studentEntityList = new ArrayList<>();

}
