package com.sachin.StudentAPI.service;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }
}
