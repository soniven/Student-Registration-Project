package com.java.student.repositories;

import com.java.student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository <StudentEntity, Long> {
}