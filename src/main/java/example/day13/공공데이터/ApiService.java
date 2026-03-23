//package example.day13.공공데이터;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ApiService {
//    // * 공공데이터 기준 : 로그인 -> 마이페이지 ( 개인 API 인증키 )
//    String serviceKey = "5f50b73a35de251ef95506ee806d3bb8701f545d40d325fee6444f2e346f7868";
//
//    // [2] 인천광역시 부평구_맛있는 집(맛집) 현황 JSON
//
//
//    // [1] 국립중앙의료원_전국 약국 정보 조회 서비스 XML
//    // https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire?serviceKey=5f50b73a35de251ef95506ee806d3bb8701f545d40d325fee6444f2e346f7868&Q0=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C&Q1=%EA%B0%95%EB%82%A8%EA%B5%AC&QT=1&QN=%EC%82%BC%EC%84%B1%EC%95%BD%EA%B5%AD&ORD=NAME&pageNo=1&numOfRows=10
//
//
//
//}
//
   /*
        API : 데이터 주고받고 기능을 공유할 수 있는 규칙/프로토콜(HTTP)
        REST API : HTTP 기반의 API
        종류
            1. 개발 : SPRING CONTROLLER
            2. 활용 : 무료/유료 판단
                    1) 공공데이터포털
                    2) LLM(AI모델) API (비설치/ 비학습)
                    3) 사기업 API
                        카카오(지도, 로그인),
                        네이버(로그인, 데이터랩),
                        구글(로그인, 자동입력방지/캡차),
                        번역 : Deep API, 파파고(다국어 API, 번역해서db 저장),
                        결제( 테스트 : 아임포트/ 카카오페이 )
                        등등
        반환타입 : JSON/XML
     */


