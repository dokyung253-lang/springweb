package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    // R : 조회 select
    public List< ExamDto > 전체조회() {
        // * select 대신에 JPA 함수 사용 vs findAll : 전체 엔티티/레코드/객체 를 반환
        List<ExamEntity> examEntityList = examRepository.findAll();
        // entity ---> dto변경 < Entity 노출 안하기 >
        List<ExamDto> examDtoList = new ArrayList<>(); // 1) 여러개 dto 저장할 리스트 선언
        examEntityList.forEach(entity -> {
            // 2) 반복문 for( int index =0; index <= list.size()-1; index++ ) vs forEach( 반복변수 -> { 실행문; } )
            ExamDto examDto = new ExamDto();            // 3) dto 선언
            examDto.setEno(entity.getEno());          // 4) 반복중인 entity 객체 내 멤버변수를 dto에 저장
            examDto.setEname(entity.getEname());      // 4) ""
            examDtoList.add(examDto);                 // 5) dto를 리스트에 저장
        });    // for end
        return examDtoList; // ** entity가 아닌 dto 반환한다. 왜? 서비스개발자만 entity 다른다. 왜? 역할과 조직 권한 차이
    }
    // C : 쓰기 insert
    public boolean 저장(ExamDto examDto ){
        // insert 대신에 JPA 함수 사용
        // .save( 엔티티 ) : 해당 엔티티를 insert한다.
        // 1) 저장할 DTO --> ENTITY 변환
        ExamEntity examEntity = new ExamEntity();
        examEntity.setEname(examDto.getEname());
        // 2) .save 이용한 insert 하고 처리한 entity 반환, pk여부 확인
        ExamEntity savedEntity = examRepository.save( examEntity );
        // 3) 처리한 entity의 pk여부 (= auto_increment가 들어가면 성공)
        if( savedEntity.getEno() >= 1 )return true; // pk가 1보다 크면 성공
        return false;
    }
    // D : 삭제 delete
    public boolean 삭제 (int eno){
        // delete 대신에 JPA 함수 사용
        // .deleteById( 삭제할 pk번호 ); 해당하는 pk가 존재하면 삭제
        examRepository.deleteById( eno );
        return true;
    }
    // U : 수정 update
    public boolean 수정( ExamDto examDto ){
        // update 대신 JPA 영속성 사용한다.
        // *영속성 :데이터베이스와 자바객체 연결되는 상태를 지속적으로 유지
        // 즉] 자바객체가 수정되면 데이터베이스도 자동 수정
        // 1] 수정할 엔티티 찾기, pk
        // findById( 수정할pk번호 );
        Optional< ExamEntity > optional
                = examRepository.findById( examDto.getEno() );
        // 2] 만약에 엔티티가 존재(Present)하면, .isPresent() : 조회 결과가 있으면 true, 없으면 false 반환
        if( optional.isPresent()) {
            ExamEntity examEntity = optional.get() ; // 존재한 엔티티 꺼내기
            // ************************************************************** //\
            examEntity.setEname( examDto.getEname() ); // 입력받은(수정할) 값을 엔티티에 setter 이용하여 수정한다.
            return true;
        }
        return false;
    }

}

