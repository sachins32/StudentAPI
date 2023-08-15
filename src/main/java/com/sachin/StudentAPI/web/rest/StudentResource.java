package com.sachin.StudentAPI.web.rest;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentResource {
    StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student s) {
        return new ResponseEntity<Student>(studentService.save(s), HttpStatus.OK);
    }
}
