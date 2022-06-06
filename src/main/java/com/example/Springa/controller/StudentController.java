package com.example.Springa.controller;

import com.example.Springa.entity.Student;
import com.example.Springa.model.StudentDTO;
import com.example.Springa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    @Autowired
    private  IStudentService studentService;

  /*  @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }*/

    @GetMapping("/getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);

    }

    @GetMapping("/getStudentByFirstName/{firstName}")
    public List<Student> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);

    }

    @PostMapping("/addStudent")
    public Student addStudent(@Valid @RequestBody StudentDTO studentDTO){
     return studentService.addStudent(studentDTO);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable String id,@Valid @RequestBody StudentDTO student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }

}
