package com.example.Springa.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id

    String id;
    String firstName;
    String lastName;
    Integer age;

    String email;
}
