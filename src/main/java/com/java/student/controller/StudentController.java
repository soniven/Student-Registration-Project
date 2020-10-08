package com.java.student.controller;

import com.java.student.StudentApplication;
import com.java.student.dto.Student;
import com.java.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StudentController.BASE_URL)
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    public static final String BASE_URL = "/api/v1/students";
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    List<Student> getAllStudents(){
        logger.info("fetching all students");
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        logger.info("fetching student by id {}", id);
        return studentService.findStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student){
        logger.info("creating student {} {} in the class {}", student.getFirstName(),student.getLastName(),student.getClassName());
        return studentService.saveStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        logger.info("updating student class name to {}", student.getClassName());
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        logger.info("deleting student by id {}", id);
        studentService.deleteStudentById(id);
    }
}