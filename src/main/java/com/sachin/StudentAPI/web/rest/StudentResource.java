package com.sachin.StudentAPI.web.rest;

import com.sachin.StudentAPI.model.Student;
import com.sachin.StudentAPI.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = studentService.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (studentService.existsById(student.getId()))
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        else return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        if (studentService.existsById(id)) {
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
