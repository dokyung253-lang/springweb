package example.day09.springBootDeveloprer.service;

import example.day09.springBootDeveloprer.domain.Article;
import example.day09.springBootDeveloprer.dto.AddArticleRequest;
import example.day09.springBootDeveloprer.dto.UpdateArticleRequest;
import example.day09.springBootDeveloprer.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // IOC 빈 등록
@RequiredArgsConstructor// final 멤버변수의 자동생성자 // Autowired 안해도 됨
public class BlogService {
    // @Autowired private BlogRepository blogRepository; // [방법 1]
    private final BlogRepository blogRepository; // [방법 2] @RequiredArgsConstructor 사용하기

    // 블로그 글 추가 메소드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    // p.187 블로그 글 목록 조회 메소드
    public List<Article> findAll(){
        return blogRepository.findAll();

    }
    // p.190 블로그 글 조회 메소드
    public Article findById(long id){
       // 1. 매개변수로 받은 id로 조회
       Optional<Article> optionalArticle = blogRepository.findById(id);
       // 2. 엔티티가 존재하면
        if(optionalArticle.isPresent()){
            return optionalArticle.get(); // 3. 반환 : (찾으면) 엔티티 꺼내기
        }
        return null; // 3. 반환 : (못찾으면) null
    }

    // p.195 블로그 글 삭제 메소드
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    // p.198 블로그 글 수정 메소드
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        // 1. id에 해당하는 엔티티 조회
        Optional<Article> optionalArticle = blogRepository.findById(id);
        // 2. 만약에 엔티티가 존재하면
        if(optionalArticle.isPresent()){
            // 3. 엔티티 꺼내기
            Article article= optionalArticle.get();
            // 4. 엔티티 수정하기
            article.update(request.getTitle(), request.getContent());
            return article;
        }
        return null;
        /* 교재 코드 , 1~4번까지
        Article article= blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found" + id));
        article.update(request.getTitle(), request.getContent());
        return article;
         */
    }
}

