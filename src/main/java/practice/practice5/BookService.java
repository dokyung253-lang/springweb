package practice.practice5;

import example.day05.mvc.ExamDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // R
    public List<BookDto> 도서전체조회() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        bookEntityList.forEach(entity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBookId(entity.getBookId());
            bookDto.setBookTitle(entity.getBookTitle());
            bookDto.setBookAuthor(entity.getBookAuthor());
            bookDto.setBookCompany(entity.getBookCompany());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }
    // c
    public boolean 도서등록( BookDto bookDto ){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookDto.getBookId());
        bookEntity.setBookTitle(bookDto.getBookTitle());
        bookEntity.setBookAuthor(bookDto.getBookAuthor());
        bookEntity.setBookCompany(bookDto.getBookCompany());
        BookEntity savedEntity = bookRepository.save(bookEntity);
        if( savedEntity.getBookId() >= 1 ) return true;
        return false;
    }
    // D
    public boolean 도서삭제 ( int bookId ){
        bookRepository.deleteById( bookId );
        return true;
    }
    // u
    @Transactional
    public boolean 도서수정( BookDto bookDto ){
        Optional<BookEntity > optional = bookRepository.findById(bookDto.getBookId());
    if( optional.isPresent() ){
        BookEntity bookEntity = optional.get();
        bookEntity.setBookTitle(bookDto.getBookTitle());
        bookEntity.setBookAuthor(bookDto.getBookAuthor());
        bookEntity.setBookCompany(bookDto.getBookCompany());
        return true;
    }
    return false;

    }


}
