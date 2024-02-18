package com.atalibdev.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/users")
    public ResponseEntity<List<Student>> fetch() {
        List<Student> students = studentService.fetch();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student createdStudent = studentService.register(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("users/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable("studentId") Long studentId) {
        studentService.deleteUser(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{studentId}")
    public ResponseEntity<Student> update(@PathVariable("studentId") Long studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.update(studentId, updatedStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
