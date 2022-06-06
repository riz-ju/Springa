package com.example.Springa.repository;

import com.example.Springa.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface IStudentRepository extends MongoRepository<Student, String> {
    List<Student> getStudentByFirstName(String firstName);
}
