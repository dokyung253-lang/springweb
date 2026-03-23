package example.day14;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionController {

    // [1] 세션객체 내 값 저장 = 로그인
    @PostMapping("") // http://localhost:8080/api/session?data=세션테스트
    public ResponseEntity<?> test1(@RequestParam String data, HttpServletRequest request){
        // 1) HttpServletRequest request : HTTP 요청 정보를 담고 있는 객체
        System.out.println( request.getRemoteAddr() ); // 요청한 클라이언트(사용자) IP 주소 얻기 (로그/위치추적/조회수)
        System.out.println( request.getHeader("User-Agent")); // 요청한 클라이언트 브라우저 정보
        System.out.println( request.getSession() ); // 요청한 클라이언트의 세션객체 정보 * 각 브라우저마다 할당됨
        // 2) 세션 객체
        HttpSession session = request.getSession();
        System.out.println( session.getId() ); // 세션의 식별번호 반환, 브라우저/디바이스마다 할당 (공유 불가)
        System.out.println( session.getCreationTime() ); // 세션의 최초 생성 시간
        System.out.println( session.getLastAccessedTime() ); // 세션의 마지막 접근 시간
        System.out.println( session.getMaxInactiveInterval() ); // 세션의 최대 유효시간(초)
        // 3) 세션 객체 내 값 저장 == 로그인
        session.setAttribute("data", data ); // 세션객체 내 값(key:value) 저장
        System.out.println( session.getAttribute("data")); // 세션객체 내 값(key) 호출

        return ResponseEntity.ok(true); // 임의값 변환

    }
    // [2] 세션객체 내 값 호출 = 로그인한 회원정보(마이페이지)
    @GetMapping("")
    public ResponseEntity<?> test2(HttpServletRequest request){
        System.out.println(request.getHeader("User-Agent") );
        // 1) 세션객체 반환
        HttpSession session = request.getSession();
        // 2) 세션객체 내 특정한 속성 반환 *모든 값은 Object로 반환된다 *
        Object obj = session.getAttribute("data"); // 'data' 이라는 이름의 속성값 반환
        // 3) 유효성검사 , 있으면 로그인 중, 없으면 비로그인
        if( obj == null ) {
            System.out.println("[상태없음]");
            return ResponseEntity.ok( false ); // * 서버재실행 하면 모든 세션정보는 초기화/사라진다. *
        }else{
            String data = (String)obj;
            System.out.println("[상태있음]");
            return ResponseEntity.ok( true );
        }
    }

    // [3] 세션객체 내 값 제거 = 로그아웃
    @DeleteMapping("")
    public ResponseEntity<?> test3(HttpSession session){ // 매개변수로 HttpSession 받는다.
        // 방법1) 세션 전체 초기화
        //session.invalidate(); // 세션객체 내 모든 속성 제거
        // 방법2) 특정 속성 초기화
        session.removeAttribute("data");

        return ResponseEntity.ok( true );
    }
}
/*
    톰캣 세션
        1. 정의 : 톰캣(서버프로그램)내 데이터를 *저장*하고 관리할 수 있게 메모리/객채 제공
        2. 목적 : 1) 상태/값 관리 2) 인증/권한 3) 효율적인 메모리 관리
        3. 사용처
            1) *로그인*상태( 어디에 저장할것이냐? 1) 서버내부= session vs 2) 클라이언트= JWT(암호화가 필요) ) 2) 비회원제 장바구니 3) 실시간처리
        4. 특징 : 브라우저(크롬/엣지/사파리/TV/모바일 등) 마다 *별도의 세션 객체* 할당된다.


    HttpServletRequest
        - 서블릿(Servlet) : WAS(톰캣) 서버 내 웹기술이 가능하게 JAVA의 HTTP통신 클래스 객체
        - 주요 메소드
            1) getRemoteAddr()         : 요청한 클라이언트의 IP 반환
            2) getHeader("User-Agent") : 요청한 클라이언트의 브라우저 정보 반환
            3) getSession()            : 요청한 클라이언트의 세션 객체 반환 *브라우저마다*

    HttpSession
        1. 세션 : 메모리가 저장되는 구역의 일부
        2. 톰캣 세션 : HTTP 객체 내 제공받는 메모리구역
        3. 주요메소드
            1) .setAttribute( "속섬명", 값 );  : 세션객체 내 속성명과 속성값 저장, 주로 로그인 상태/정보
            2) .getAttribute( "속성명" );      : 세션객체 내 이용한 속성값 호출, *Object로 반환*
            3) .removeAttribute("속성명");     : 세션객체 내 특정한 속성 삭제


    영구저장(DataBase) vs 실시간/사용자마다 저장(세션)
 */
