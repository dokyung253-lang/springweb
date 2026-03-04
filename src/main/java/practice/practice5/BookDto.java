package practice.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookDto {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCompany;
}
