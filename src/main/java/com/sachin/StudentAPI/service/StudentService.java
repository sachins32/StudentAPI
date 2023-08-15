package com.sachin.StudentAPI.service;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAll(List<Student> students) {
        return (List<Student>) studentRepository.saveAll(students);
    }
}
