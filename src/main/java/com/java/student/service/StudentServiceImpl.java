package com.java.student.service;

import com.java.student.domain.StudentEntity;
import com.java.student.dto.Student;
import com.java.student.repositories.StudentRepository;
import com.java.student.utils.JpaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(Long id) {
        logger.info("students id {} record retrieved successfully", id);
        StudentEntity studentEntity = studentRepository.findById(id).get();
        return JpaUtils.createStudentFromStudentEntity(studentEntity);
    }

    @Override
    public List<Student> findAllStudents() {
        logger.info("students records retrieved successfully");
        List<Student> students = new ArrayList<>();
        List<StudentEntity> all = studentRepository.findAll();
        for (StudentEntity studentEntity : all) {
            students.add(JpaUtils.createStudentFromStudentEntity(studentEntity));
        }
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        logger.info("student details saved successfully");
        StudentEntity studentEntity = JpaUtils.createStudentEntityFromStudent(student);
        StudentEntity save = studentRepository.save(studentEntity);
        return JpaUtils.createStudentFromStudentEntity(save);
    }

    @Override
    public void deleteStudentById(Long id) {
        logger.info("student id {} deleted successfully", id);
        studentRepository.deleteById(id);
    }

   @Override
    public Student updateStudent(Student student){
       logger.info("student details updated successfully");
       StudentEntity one = studentRepository.getOne(student.getId());
       one.setClassName(student.getClassName());
       studentRepository.save(one);
       return JpaUtils.createStudentFromStudentEntity(one);
    }
}
