package com.ragini.service;

import com.ragini.model.Department;
import com.ragini.model.Student;
import com.ragini.repository.DepartmentRepository;
import com.ragini.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository ;
    private DepartmentRepository departmentRepository ;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository){

        this.studentRepository = studentRepository ;
        this.departmentRepository = departmentRepository ;
    }


    @Transactional
    public void createStudent(Student student , Integer deptId) {

        Department department = departmentRepository.getDepartmentById(deptId);
        student.setDepartment(department) ;
        department.getStudents().add(student) ;
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student , String deptName) {

       Department department = new Department();
       department.setName(deptName);

       student.setDepartment(department);
       department.getStudents().add(student);

       studentRepository.save(student);
       departmentRepository.save(department);

    }
}
