package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.Optional;

@Service @Transactional @RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService;
    // [1] 글쓰기
    public boolean write ( BoardDto boardDto, String loginMid ){
        BoardEntity saveEntity = boardDto.toEntity(); // 1] dto --> entity 변환한다.
        // ** 저장하기 전에 fk 대입하기 , fk의 엔티티를 찾아서 대입 **//
        // 현재 로그인중인 mid로 엔티티 찾기
        Optional<MemberEntity> entityOptional = memberRepository.findByMid( loginMid );
        if( !entityOptional.isPresent() ){ // ! 부정문, isPresent() 아니면
            return false; // 존재하지 않은 회원으로 실패
        }
        // 저장할 게시물 엔티티에 set 참조 엔티티(회원엔티티)
        saveEntity.setMemberEntity(entityOptional.get() );

        // ++++++++++++++++ 최종 DB에 엔티티를 save 하기 전에 첨부파일이 존재하면 업로드 +++++++++++++++ //
        String fileName = fileService.upload( boardDto.getUploadFile() ); // dto내 multipartFile 저장한다.
        // 만약에 업로드 했다면 저장할 엔티티에 업로드된 파일명 저장하기
        if ( fileName != null ){ saveEntity.setBfile( fileName );}

        BoardEntity savedEntity = boardRepository.save( saveEntity ); // 2] entity 저장
        if( savedEntity.getBno() > 0 ){ return  true;}
        else{ return false; }
    }
}
