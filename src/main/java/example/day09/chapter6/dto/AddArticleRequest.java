package example.day09.chapter6.dto;

import example.day09.chapter6.domain.Article;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class AddArticleRequest {
    private String title;
    private String content;


public Article toEntity() {
    return Article.builder()
            .title(title)
            .content(content)
            .build();
}
}