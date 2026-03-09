//package example.종합.예제10.comment.service;
//
//import example.종합.예제10.comment.dto.CommentDto;
//import example.종합.예제10.comment.entity.CommentEntity;
//import example.종합.예제10.comment.repository.CommentRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CommentService {
//    @Autowired
//    private CommentRepository boardRepository;
//
//    // 1. 댓글등록 , 서비스는 HTTP 담당하지 않는다.
//    public boolean 댓글등록(CommentDto commentDto) {
//        // 1. 저장할 dto --> entity 변환
////        CommentEntity saveEntity = CommentDto.toEntity();
//        // 2. Jpa 이용한 entity 저장
////        saveEntity = CommentRepository.save(saveEntity);
//        // 3. PK 생성여부 판단
////        if (saveEntity.getBno() >= 1) { return true;
////        }return false;
//    }
//
//    // 2. 전체 조회
//    public List<CommentDto> 댓글전체조회(){
//        // 1) JPA 이용한 모든 엔티티 조회
//            List<CommentEntity> entityList = CommentRepository.findAll();
//        // 2) 조회된 모든 엔티티 --> dto 변환
//        List<CommentDto> list = new ArrayList<>(); // 여러개 dto
//        // 반복문; 리스트변수명.forEach( 반복변수 -> { 실행문; } ) ;
//            entityList.forEach( entity ->{
//                CommentDto boardDto = entity.toDto(); // 3) 엔티티 하나씩 dto로 변환
//                list.add( boardDto ); // 4) 새로운 리스트에 담기
//            });
//        // 5) 새로운 리스트 반호나
//        return list;
//    }
//
//    // 3. 개별 조회
//    public CommentDto 댓글개별조회(int bno ){
//        // 1) 조회할 번호(pk/id)의 엔티티 찾기
//        Optional<CommentEntity> optional = commentRepository.findById( bno );
//        // 2) 만약에 엔티티가 존재하면 , 유효성검사 제공
//        if ( optional.isPresent() ){
//            CommentEntity entity = optional.get();
//            CommentDto boardDto = entity.toDto(); // 3) 엔티티 --> dto 변환
//            return boardDto; // 4) 반환, 조회 성공
//        }
//        return null; // 4) 반환, 조회 실패
//    }
//
//    // 4. 개별 수정
//    @Transactional
//    public boolean 댓글개별수정( CommentDto commentDto ){
//        // 1) 수정할 게시물번호로 엔티티 찾기
//        Optional<CommentEntity> optional = commentRepository.findById(commentDto.getBno());
//        // 2) 만약에 엔티티가 존재하면
//        if(optional.isPresent()){
//            // 3) 엔티티내 멤버변수들을 수정한다. <영속성>
//            CommentEntity updateEntity = optional.get();
//            updateEntity.setCcontent(commentDto.getCcontent());
//            updateEntity.setCwriter(commentDto.getCwriter());
//            return true; // 4) 반환한다.
//        }
//        return false; // 4) 반환한다.
//    }
//
//    // 5. 개별 삭제
//    public boolean 개별삭제( int bno ){
//        // 1) 삭제할 게시물번호가 존재하는지 확인  // .existsById(pk번호) : 존재하면 true 없으면 false
//        boolean exists = commentRepository.existsById(bno);
//        // 2) 만약에 존재하면 삭제
//        if( exists == true ){
//            commentRepository.deleteById(bno);
//            return true; // 3) 반환
//        }
//        return false; // 3) 반환
//    }
//}
