package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, 12, 5)
            );
            Student jack = new Student(
                    "Jack",
                    "jack.musiala@gmail.com",
                    LocalDate.of(2000, 7, 15)
            );
            repository.saveAll(Arrays.asList(mariam, jack));
        };
    }
}
