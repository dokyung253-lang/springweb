package example.day05.mvc;
// DTO : 데이터 이동 객체, 서로다른 레이어/계층간의 데이터 *이동* 목적 사용

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.util.EnumUtils;

@Entity // 해당객체는 데이터베이스 연동
@Table( name = "exam") // 데이터베이스에서 테이블명 정의
@Data @AllArgsConstructor @NoArgsConstructor // lombok
public class ExamEntity { // Entity : 데이터 실재의 본체/값, 데이터베이스와 연동된 객체, 주의할 점: 이동목적으로 사용되면 노출 가능성이 높다.

    @Id // pk 적용
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 적용
    private Integer eno;

    @Column( name = "ename", length = 255, nullable = true ) // 테이블 필드 속성
    private String ename;

} // Entity : 데이터베이스 테이블과 객체 간의 연동
