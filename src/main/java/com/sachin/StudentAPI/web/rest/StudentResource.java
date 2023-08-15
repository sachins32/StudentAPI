package com.sachin.StudentAPI.web.rest;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addAllStudents(@RequestBody List<Student> students) {
        return new ResponseEntity<List<Student>>(studentService.saveAll(students), HttpStatus.OK);
    }
}
