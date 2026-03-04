package practice.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "book")
@Data @NoArgsConstructor @AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name= "bookId")
    private Integer bookId;

    @Column( name = "bookTitle", length = 100, nullable = true )
    private String bookTitle;
    @Column( name = "bookAuthor", length = 30, nullable = true )
    private String bookAuthor;
    @Column( name = "bookCompany", length = 30, nullable = true )
    private String bookCompany;
}
