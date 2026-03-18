--
-- -- ----------------------day09 todo sample code-------------------------------
-- insert into todo( title, content, done, create_date, update_date) values( "경제 서적 읽기", "부의 시나리오 100페이지까지", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "오전 조깅", "공원 한 바퀴 30분 달리기", true, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "기획안 검토", "신규 프로젝트 제안서 수정본 확인", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "영어 단어 암기", "토익 빈출 단어 50개 외우기", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "장보기", "닭가슴살, 고구마, 브로콜리 구매", true, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "분리수거", "플라스틱 및 종이류 배출하기", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "알고리즘 문제 풀이", "백준 실버 등급 2문제 해결", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "명상하기", "자기 전 10분 호흡 집중", true, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "치과 예약", "정기 검진 및 스케일링 예약", false, NOW(), NOW() );
-- insert into todo( title, content, done, create_date, update_date) values( "기타 연습", "코드 C와 G 메이저 전환 연습", false, NOW(), NOW() );

-- insert into article(title, content, created_at, updated_at) values('title1', 'content1', NOW(), NOW())
-- insert into article(title, content, created_at, updated_at) values('title2', 'content2', NOW(), NOW())
-- insert into article(title, content, created_at, updated_at) values('title2', 'content2', NOW(), NOW())

-- ---------------- day11 todo sample insert ----------------
insert into category (cname, create_date, update_date) values ('공부', now(), now());
insert into category (cname, create_date, update_date) values ('운동', now(), now());
insert into category (cname, create_date, update_date) values ('업무', now(), now());
insert into category (cname, create_date, update_date) values ('취미', now(), now());
insert into category (cname, create_date, update_date) values ('생활', now(), now());

insert into todo (title, content, done, cno, create_date, update_date) values('자바 공부', 'JPA 기본 개념 정리', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('Spring Boot 실습', 'REST API 만들기', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('React 공부', 'useState와 props 이해하기', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('데이터베이스 공부', 'JOIN과 INDEX 복습', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('알고리즘 문제풀이', '백준 문제 5개 풀기', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('헬스장 가기', '하체 운동', false, 2, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('러닝', '5km 달리기', false, 2, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('스트레칭', '아침 스트레칭 20분', true, 2, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('수영', '자유형 연습', false, 2, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('요가', '유연성 운동', false, 2, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('프로젝트 기획', '서비스 기능 목록 정리', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('회의 준비', '자료 PPT 작성', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('코드 리뷰', '팀원 PR 검토', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('API 설계', 'ERD 및 엔드포인트 설계', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('배포 준비', 'Docker 이미지 빌드', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('기타 연습', '기타 코드 연습', false, 4, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('독서', '기술 서적 30페이지 읽기', false, 4, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('사진 촬영', '야경 촬영 연습', false, 4, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('영화 감상', 'SF 영화 보기', true, 4, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('드로잉', '인물 스케치', false, 4, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('장보기', '마트에서 식료품 구매', false, 5, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('청소', '집 청소하기', false, 5, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('세탁', '세탁기 돌리기', true, 5, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('요리', '저녁 식사 준비', false, 5, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('공과금 납부', '전기세 납부', false, 5, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('AI 공부', '머신러닝 개념 정리', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('딥러닝 실습', 'CNN 모델 구현', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('LLM 실습', 'OpenAI API 테스트', false, 1, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('팀 프로젝트', '프론트엔드 UI 구현', false, 3, now(), now());
insert into todo (title, content, done, cno, create_date, update_date) values('Git 정리', 'Git Flow 복습', false, 3, now(), now());