package pl.stanikov.skapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SkAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkAppApplication.class, args);
    }
}
