package com.java.student.service;

import com.java.student.domain.StudentEntity;
import com.java.student.dto.Student;
import com.java.student.repositories.StudentRepository;
import com.java.student.utils.JpaUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        return JpaUtils.createStudentFromEntity(studentEntity);
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        List<StudentEntity> all = studentRepository.findAll();
        for (StudentEntity studentEntity : all) {
            students.add(JpaUtils.createStudentFromEntity(studentEntity));
        }
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntity = JpaUtils.createStudentEntityFromStudent(student);
        StudentEntity save = studentRepository.save(studentEntity);
        return JpaUtils.createStudentFromEntity(save);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

   @Override
    public Student updateStudent(Student student){
       StudentEntity one = studentRepository.getOne(student.getId());
       one.setClassName(student.getClassName());
       studentRepository.save(one);
       return JpaUtils.createStudentFromEntity(one);
    }
}
