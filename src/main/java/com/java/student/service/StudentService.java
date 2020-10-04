package com.java.student.service;

import com.java.student.dto.Student;

import java.util.List;

public interface StudentService {

    Student findStudentById(Long id);

    List<Student> findAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
