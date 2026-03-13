package example.day09.chapter6;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // created_At, updated_At 자동 업데이트
@SpringBootApplication
public class SpringBootDeveloperApplication {

}
