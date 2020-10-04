package com.java.student.controller;

import com.java.student.dto.Student;
import com.java.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StudentController.BASE_URL)
public class StudentController {

    public static final String BASE_URL = "/api/v1/students";
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveCustomer(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}