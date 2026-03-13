package example.day09.chapter6.controller;

import example.day09.chapter6.domain.Article;
import example.day09.chapter6.dto.ArticleResponse;
import example.day09.chapter6.dto.AddArticleRequest;
import example.day09.chapter6.dto.UpdateArticleRequest;
import example.day09.chapter6.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // ioc , 빈등록, @Contoroller, @ResponseBody 포함
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그글 정보를 응답객체에 담아 전송
        return ResponseEntity.status( 201 ).body(savedArticle); // 180p. 꼭 알아두면 좋을 응답코드< 암기 필요>
        // return ResponseEntity.status(응답코드).body(반환값)
        // vs
        // return 반환값
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        // 1. 서비스로 부터 모든 엔티티 반환
        List<Article> articleList = blogService.findAll();
        // 2. 모든 엔티티를 forEach로 활용하여 하나씩 entity -> dto 반복변환
        List<ArticleResponse> articleResponses = new ArrayList<>();
        articleList.forEach((entity) -> {
            // 3. entity -> dto 변환
            ArticleResponse articleResponse = new ArticleResponse(entity);
            // 4. 리스트에 담기
            articleResponses.add(articleResponse);
        });
        // 5. 반복문 종료
        return ResponseEntity.status(200).body(articleResponses);
    }

    // 개별글 조회 controller
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle (@PathVariable("id") long id){
        Article article = blogService.findById(id);
        ArticleResponse articleResponse = new ArticleResponse(article); // entity -> dto 변환 과정
        return ResponseEntity.status( 200 ).body(articleResponse); // dto 반환
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id){
        blogService.delete(id);
        return ResponseEntity.status(200).build(); // 반환값 없다 뜻
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody UpdateArticleRequest request){
        Article article = blogService.update(id, request);
        return ResponseEntity.status(200).body(article);
    }
}
