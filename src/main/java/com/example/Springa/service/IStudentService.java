package com.example.Springa.service;

import com.example.Springa.entity.Student;
import com.example.Springa.model.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    public List<Student> getStudent();
    public Student getStudentById(String id);
    public Student addStudent(StudentDTO student);
    public Student updateStudent(String id, StudentDTO student);
    public void deleteStudent(String id);

    public List<Student> getStudentByFirstName(String firstName);

}
