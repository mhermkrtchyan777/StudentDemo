package com.example.demo.repo;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void findStudentByEmail() {
        String email = "Jamila@gmail.com";
        Student student = new Student("jamila", email, LocalDate.of(2000, 10, 6));
        underTest.save(student);

        var expected = underTest.findStudentByEmail(email);
        assertThat(expected).isPresent();
        assertThat(expected.get().getEmail()).isEqualTo(email);
    }
}