package com.jdbc2;

import com.jdbc2.model.Student;
import com.jdbc2.repo.StudentRepository;
import com.jdbc2.repo.StudentRepository2;

public class Main {

    public static void main(String[] args){

//        System.out.println("Hello World !!!!");
        StudentRepository s1 = new StudentRepository();
//        s1.createStudent();
//          s1.updateUser();
//        s1.deleteUser();
//        s1.getUserById();
//        s1.completeCRUD();

        StudentRepository2 s2 = new StudentRepository2();
//        s2.createStudent(new Student("Ayush","ayush@123",7));
//        s2.updateStudent(new Student("Rohan","rohan@1234",25) , 8);
//        s2.deleteStudent(9);
        s2.getStudents();


    }



}
