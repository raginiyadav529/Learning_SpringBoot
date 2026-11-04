package com.ragini.service;

import com.ragini.model.Student;
import com.ragini.repo.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository ;  // Constructor dependency injection
    }

    @Transactional
    public void createStudent(Student student){          // create

        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Student studentReq ,int id ){          // update

        Student student1 = studentRepository.findById(id);
        if (student1 == null){

            throw new RuntimeException("Student not found !");
        }

        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());

    }

    @Transactional
    public void deleteStudent(int id){         // delete

        Student student = studentRepository.findById(id);

        if (student == null){

            throw new RuntimeException("Student not found !");
        }

        studentRepository.remove(student);
    }

    @Transactional
    public Student getStudentById(int id){        // fetch single record

      return studentRepository.findById(id);

    }

    public List<Student> getAllStudents(){
          return null;
    }


}
