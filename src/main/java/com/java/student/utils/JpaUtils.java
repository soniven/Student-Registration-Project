package com.java.student.utils;

import com.java.student.domain.StudentEntity;
import com.java.student.dto.Student;

public class JpaUtils {

    public static Student createStudentFromEntity(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());
        student.setClassName(studentEntity.getClassName());
        student.setNationality(studentEntity.getNationality());
        return student;
    }

    public static StudentEntity createStudentEntityFromStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setClassName(student.getClassName());
        studentEntity.setNationality(student.getNationality());
        return studentEntity;
    }
}