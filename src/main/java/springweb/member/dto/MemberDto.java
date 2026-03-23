package springweb.member.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import springweb.member.entity.MemberEntity;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class MemberDto {
    private Long mno; // 회원번호
    private String mid; //회원아이디
    private String mpwd; // 회원비밀번호
    private String mname; // 회원닉네임

    // BaseTime 멤버변수
    private String createDate;
    private String updateDate;

    // DTO -> Entity , 주로 저장/수정일 때 사용
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .build();
    }
}
