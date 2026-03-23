package springweb.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table( name = "member")
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class MemberEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long mno; // 회원번호

    @Column( nullable = false, unique = true, length = 100)
    private String mid; //회원아이디

    @Column( nullable = false)
    private String mpwd; // 회원비밀번호

    @Column( nullable = false, length = 30)
    private String mname; // 회원닉네임
}
