package com.ragini.service;

import com.ragini.model.Department;
import com.ragini.model.Profile;
import com.ragini.model.Student;
import com.ragini.repository.DepartmentRepository;
import com.ragini.repository.ProfileRepository;
import com.ragini.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository ;
    private DepartmentRepository departmentRepository ;
    private ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository , ProfileRepository profileRepository){

        this.studentRepository = studentRepository ;
        this.departmentRepository = departmentRepository ;
        this.profileRepository = profileRepository ;
    }


    @Transactional
    public void createStudent(Student student) {

        Department department = new Department();
        department.setName("IT");

        Profile profile = new Profile();
        profile.setBio("Your Bio !");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);
    }

    public Student findStudentById(Integer id){

       Student s1 = studentRepository.findById(id);

        System.out.println("Lazily fetched Student !");

        Department d1 = s1.getDepartment();
        System.out.println("Lazily fetched department !");

        Profile p1 = s1.getProfile();
        System.out.println("Lazily fetched profile !");

        return s1;
    }

}
