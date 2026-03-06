package example.종합.예제10.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 감사 기능 ; BaseTime (자동수정날짜 적용하기 위해)
public class AppStart { public static void main(String[] args) { SpringApplication.run(AppStart.class); } }
