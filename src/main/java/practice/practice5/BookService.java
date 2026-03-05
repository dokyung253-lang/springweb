package practice.practice5;

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
    // c
    public boolean 도서등록( BookDto bookDto ){
        // 1. dto -> entity 변환
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookTitle(bookDto.getBookTitle());
        bookEntity.setBookAuthor(bookDto.getBookAuthor());
        bookEntity.setBookCompany(bookDto.getBookCompany());
        // 2. 직접적인 sql이 아닌 JPA 이용한 등록, .save()
        BookEntity savedEntity = bookRepository.save(bookEntity);
        // 3. 저장여부는 pk 생성 여부로 판단
        if( savedEntity.getBookId() >= 1 ) return true;
        return false;
    }
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
    // D
    public boolean 도서삭제 ( int bookId ){
        bookRepository.deleteById( bookId );
        return true;
    }
}
