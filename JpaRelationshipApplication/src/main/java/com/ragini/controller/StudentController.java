package com.ragini.controller;


import com.ragini.model.Student;
import com.ragini.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentservice){

       this.studentService = studentservice ;
    }

    @PostMapping               // add student in student table
    public ResponseEntity<String> createStudent(
            @RequestBody Student student ,@RequestParam Integer deptId){

        studentService.createStudent(student , deptId);

        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/withDept")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student ,@RequestParam String deptName){

        studentService.createStudent(student , deptName);

        return ResponseEntity.ok("DONE");
    }
}
