package practice.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/practice5/book")
    private List< BookDto > 도서전체조회(){
        List< BookDto > result = bookService.도서전체조회();
        return result;
    }
    @PostMapping("/practice5/book")
    private boolean 도서등록(@RequestBody BookDto bookDto){
        boolean result = bookService.도서등록( bookDto );
        return result;
    }
    @DeleteMapping("/practice5/book")
    public boolean 도서삭제( @RequestParam int bookId ){
        boolean result = bookService.도서삭제( bookId );
        return result;
    }
    @PutMapping("/practice5/book")
    public boolean 도서수정(@RequestBody BookDto bookDto ){
        boolean result = bookService.도서수정(bookDto);
        return result;
    }

}
