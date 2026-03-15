package example.day09.springBootDeveloprer.dto;

import example.day09.springBootDeveloprer.domain.Article;
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