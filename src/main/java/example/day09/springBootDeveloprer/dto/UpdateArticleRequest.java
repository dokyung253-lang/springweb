package example.day09.springBootDeveloprer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder
@Data
public class UpdateArticleRequest {
    private String title;
    private String content;
}
