package practice.practice6;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

/*
[조건 5] 서비스 구현 : Service 클래스를 작성하여 아래 기능을 구현한다.
영화 등록     새로운 영화 정보를 입력받아 DB에 저장
영화 전체 조회 모든 영화 목록을 조회
영화 개별 조회 영화번호(movieId)를 기준으로 특정 영화 상세 정보 조회
특정 영화 수정 영화번호(movieId)를 기준으로 해당 영화 정보 수정, @Transactional의 역할을 서술한다.
특정 영화 삭제 영화번호(movieId)를 기준으로 해당 영화 삭제
*/
@Service @Transactional
public class MovieService {

}
