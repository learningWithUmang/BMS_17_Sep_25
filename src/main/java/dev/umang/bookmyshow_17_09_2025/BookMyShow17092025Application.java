package dev.umang.bookmyshow_17_09_2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShow17092025Application {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShow17092025Application.class, args);
    }

}
