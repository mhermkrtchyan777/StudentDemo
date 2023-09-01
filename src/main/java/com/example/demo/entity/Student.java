package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate date;

    public Student(Long id, String name, String email, LocalDate date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Student() {
    }

    public Student(String name, String email, LocalDate date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Integer getAge() {
        return Period.between(this.date,LocalDate.now()).getYears();
    }
}
