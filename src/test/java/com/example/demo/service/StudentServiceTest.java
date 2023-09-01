package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }

    @Test
    void getStudents() {
        underTest.getStudents();
        verify(studentRepository).findAll();
    }

    @Test
    void addNewStudent() {
        Student student = new Student(
                "jamila",
                "Jamila@gmail.com",
                LocalDate.of(2000, 10, 6));
        underTest.addNewStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor=
                ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturestudent=studentArgumentCaptor.getValue();
        assertThat(capturestudent).isEqualTo(student);
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}