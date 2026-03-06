package example.종합.예제10.comment.controller;

import example.종합.예제10.comment.dto.CommentDto;
import example.종합.예제10.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 1. 댓글등록
    @PostMapping("/board/detail")
    public boolean 댓글등록(@RequestBody CommentDto commentDto ){
        boolean result = CommentService.댓글등록(commentDto);
        return result;
    }

    // 2. 댓글전체조회
    @GetMapping("/board/detail")
    public List<CommentDto> 댓글전체조회(){
        List<CommentDto> result = commentService.댓글전체조회();
        return result;
    }

    // 3. 댓글개별조회
    @GetMapping("/board/detail")
    public CommentDto 댓글개별조회(@RequestParam int bno){
        CommentDto result = commentService.댓글개별조회(bno);
        return result;
    }

    // 4. 댓글개별수정
    @PutMapping("/board/detail")
    public boolean 댓글개별수정(@RequestBody CommentDto boardDto){
        return commentService.댓글개별수정( boardDto );
    }

    // 5. 댓글개별삭제
    @DeleteMapping("/board/detail")
    public boolean 댓글개별삭제(@RequestParam int bno){
        return commentService.개별삭제(bno);
    }
}
