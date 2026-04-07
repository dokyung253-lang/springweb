package springweb.member.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService.JWTService;
import springweb.member.service.MemberService;

@RestController @RequiredArgsConstructor @RequestMapping("/api/member3")
@CrossOrigin( value = "http://localhost:5173", allowCredentials = "true" )
public class MemberController3 {
    private final MemberService memberService;
    private final JWTService jwtService; //jwt 기능 객체

    // [1] 회원가입

    // [2] 로그인 == 세션방식 --> 토큰방식 변경 + 쿠키 vs 레디스(인메모리; db보다 좀 가벼운 저장소; 대규모 적합)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto, HttpServletResponse response) { // httpServletResponse : 응답객체
        boolean result = memberService.login(loginDto);
        // 1] 만약에 로그인을 성공했으면
        if (result) {
            // 2] 로그인성공한정보(아이디) 토큰에 저장
            String token = jwtService.createToken(loginDto.getMid());
            // ======================== 쿠키에 토큰 담아서 응답하기 ==============================
            // (1) 쿠키에 토큰 담기 , new Cookie ( "속성명", 값 )
            Cookie cookie = new Cookie("token", token);
            // (2) 쿠키 옵션 *
            cookie.setHttpOnly(true); // setHttpOnly(true) : 쿠키접근 방법, true이면 js가 접근 못한다.
            cookie.setSecure(false); // setSecure(false) : true 이면 https 만 접근 가능
            cookie.setPath("/"); // setPath("/") : 쿠키 접근하는 경로, "/": 전체경로
            // cookie.setMaxAge( ); // setMaxAge(초) : 쿠키 유지시간
            // (3) 쿠키 응답하기 , response.addcookie( 쿠키객체 );
            response.addCookie(cookie);
            // 3] 아니면 로그인 실패
            return ResponseEntity.ok(true);
        }else { return ResponseEntity.ok(false);}
    }

    // [3] 로그아웃 == 세션방식 ---> 토큰방식 변경 + 쿠키
    @GetMapping("/logout")
    public ResponseEntity<?> logout( HttpServletResponse response ){
        // 1) 매개변수에 HttpServletResponse response 받는다.

        // 2) 동일한 속성명으로 null 값 저장하는 쿠키 생성
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge( 0 ); // 쿠키의 생명주기를 0초로 설정한다.
        cookie.setPath("/");

        // 3) 쿠키 반환
        response.addCookie( cookie );

        // 3) 값 반환
        return ResponseEntity.ok( true );
    }

    // [4] 마이페이지 == 세션방식 --> 토큰방식 변경 + 쿠키
    @GetMapping("/my/info")
    public ResponseEntity<?> myInfo( @CookieValue( value = "token", required = false) String token ){
        // @CookieValue : HTTP 요청의 cookie 정보 매핑
        // @CookieValue("token") String token 매개변수로 받는다. required = false 설정하면 필수값이 아닌 상
        // 2] 만약에 쿠키 값이 없으면 비로그인
        if( token == null ){ return ResponseEntity.ok(false ); }
        // 4] 토큰에서 값(클레임) 추출
        String mid = jwtService.getClaim( token );
        if( mid == null )return ResponseEntity.ok(false); // 토큰 문제로 실패
        // 5] 토큰에서 꺼낸 값(mid)으로 회원정보 요청해서 반환하기
        return ResponseEntity.ok( memberService.myinfo( mid ));
    }
}
/*
    HTTP : 문자 이동 규약/규칙
    톰캣 session : 저장위치 - 서버(내부), 보안 강도 - 높음 , 주요활용처 - 로그인/장바구니
       vs
      쿠키       : 저장위치 - 브라우저(외부) , 보안강도 - 낮음(JWT로 보완) , 주요 활용처 - 로그인/장바구니/자동로그인/사용자설정(테마) *게임 등 시간제한 있는 이벤트*에서 많이 사용, 결과만 db에 저장
    * Token : 특정한 자료를 암호화(JWT)해서 인증

    활용 1) 세션은 서버에 저장하므로 *보안*에 강하지만 *대규모*서버에서는 과부하 증가한다.
        2) 토큰은 세션/쿠키 없이 HTTP 사용하지 않으므로 웹/앱 통합 가능하다.
        3) 쿠키는 브라우저에 저장하므로 *보안* 낮지만 JWT와 같이 사용하여 서버 과부하를 낮출 수 있다.
        즉] 앱(JWT), 웹(JWT/Cookie) 사용이 일반적이다.


*/