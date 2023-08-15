package com.sachin.StudentAPI.service;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student s) {
        return studentRepository.save(s);
    }
}
