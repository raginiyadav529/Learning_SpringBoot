package com.ragini.service;

import com.ragini.model.Student;
import com.ragini.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){

        studentRepository.createStudent(student);
    }
    public void updateStudent(Student student ){

        studentRepository.updateStudent(student ,student.getId());
    }

    public void deleteStudent(int id){

        studentRepository.deleteStudent(id);
    }

    public Student getStudentById(int id){

      return  studentRepository.getStudentById(id);
    }

    public List<Student> getAllStudents(){

      return  studentRepository.getAllStudents();
    }



}
