package practice.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // Create
    /* API 명세서 * 코드는 못 치더라도 API 명세서가 기본임 *
     URL : "practice5/book"
     Method : post
     Request : body
     매개변수 타입 : bookDto
     ( 서버에 전달할 값 ): { book_title : , book_author: , book_company : }
     ( 클라이언트에게 반환할 값 ) : true / false
    */

    @PostMapping("/practice5/book")
    private boolean 도서등록(@RequestBody BookDto bookDto){
        boolean result = bookService.도서등록( bookDto );
        return result;
    }
    // Read
    @GetMapping("/practice5/book")
    private List< BookDto > 도서전체조회(){
        List< BookDto > result = bookService.도서전체조회();
        return result;
    }
    // Update
    @PutMapping("/practice5/book")
    public boolean 도서수정(@RequestBody BookDto bookDto ){
        boolean result = bookService.도서수정(bookDto);
        return result;
    }
    // Delete
    @DeleteMapping("/practice5/book")
    public boolean 도서삭제( @RequestParam int bookId ){
        boolean result = bookService.도서삭제( bookId );
        return result;
    }
}
