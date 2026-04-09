package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import test.employeeManager.CustomBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
@EnableJpaAuditing
public class AppStart {
    public static void main(String[] args) {
            final Logger LOGGER = LoggerFactory.getLogger(AppStart.class);
        SpringApplication.run(AppStart.class, args);
    }
}
