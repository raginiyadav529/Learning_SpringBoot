package com.ragini.controller;

import com.ragini.model.Student;
import com.ragini.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService ;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable int id){

        studentService.updateStudent(student ,id);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id ){

        studentService.deleteStudent(id);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){

        Student student = studentService.getStudentById(id) ;
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);

    }
}
