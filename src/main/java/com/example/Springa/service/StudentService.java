package com.example.Springa.service;

import com.example.Springa.entity.Student;
import com.example.Springa.model.StudentDTO;
import com.example.Springa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class StudentService implements IStudentService{

    @Autowired
    private  IStudentRepository studentRepository;

   /* public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }*/

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);

        return student.get();
    }

    @Override
    public Student addStudent(StudentDTO student) {
        var newStudent = new Student();
        newStudent.setId(UUID.randomUUID().toString());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setAge(student.getAge());
        newStudent.setEmail(student.getEmail());

        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(String id, StudentDTO student) {
        var newStudent = new Student();
        Optional<Student> stud = studentRepository.findById(id);
        if(stud.isPresent()){
           newStudent = stud.get();
           // newStudent.setId(id);
            newStudent.setFirstName(student.getFirstName());
            newStudent.setLastName(student.getLastName());
            newStudent.setAge(student.getAge());
            newStudent.setEmail(student.getEmail());

        }




        return studentRepository.save(newStudent);

    }

    @Override
    public void deleteStudent(String id) {
       studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.getStudentByFirstName(firstName);
    }
}
