package com.ragini.controller;


import com.ragini.model.Student;
import com.ragini.service.StudentService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentservice){

       this.studentService = studentservice ;
    }

    @PostMapping                                 // add student in student table
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);

        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")                               // add student in student table
    public ResponseEntity<Student> findStudent(@PathVariable Integer id){

       Student student = studentService.findStudentById(id);

        return ResponseEntity.ok(student);
    }


}
