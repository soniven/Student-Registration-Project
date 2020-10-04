package com.java.student.bootstrap;

import com.java.student.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public BootstrapData(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading student data ...");
        //System.out.println("Saved students: " + studentRepository.count());
    }
}
