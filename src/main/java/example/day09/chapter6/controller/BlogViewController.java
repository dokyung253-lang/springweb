package example.day09.chapter6.controller;

import example.day09.chapter6.domain.Article;
import example.day09.chapter6.dto.ArticleViewResponse;
import example.day09.chapter6.service.BlogService;
import example.day09.chapter6.dto.ArticleListViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor @Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 1. 블로그 글 리스트 저장
        return "articleList"; // articleList.html 라는 뷰 조회
    }
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }
}
