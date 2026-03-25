package springweb.member.service.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {

    // *] 비밀키 정의
    private String secret = "12312312345645645678978978901201"; // 개발자가 임의로 32글자 이상의 문자열 구성
    private Key secretKey = Keys.hmacShaKeyFor( secret.getBytes( StandardCharsets.UTF_8 )); // SHA-256 알고리즘으로 비밀키 정의
    // 1] 토큰 발급 : 특정한 자료를 사람이 이해하기 어려운 자료로 변경
    public String createToken( String mid ){
        String token = Jwts.builder() // 토큰객체 생성 빌더 시작
                .claim( "mid", mid ) // key와 value 한 쌍으로 토큰에 저장할 값 넣기
                .setIssuedAt(new Date()) // 토큰 발급날짜/시간
                .setExpiration( new Date( System.currentTimeMillis()*1000*60*60*24) ) // 토큰 유지/유효시간 , 24시간=밀리초*1000*60*60*24
                .signWith( secretKey , SignatureAlgorithm.HS256 ) // 토큰에 비밀키 넣고, 서명 알고리즘(HS512) 추가
                .compact(); // 토큰객체 생성 빌더 종료
        return token;
    }
    // 2] 토큰의 클레임(내용물) 추출
    public String getClaim( String token ) {
        try { Claims claims = Jwts.parser()
                .setSigningKey(secretKey) // 비밀키 대입
                .build()
                .parseClaimsJws(token) // 서명확인할 토큰 대입
                .getBody(); // 서명확인 토큰내 클레임(내용물) 반환 / 없으면 예외 발생
            Object object = claims.get("mid"); // 클레임(내용물)의 값은 모두 Object이다. 세션
            return (String) object; // 강제타입변환
        } catch (Exception e) {System.out.println(e);}
        return null; // 토큰이 없거나 유효하지 않을 때
    }

}
