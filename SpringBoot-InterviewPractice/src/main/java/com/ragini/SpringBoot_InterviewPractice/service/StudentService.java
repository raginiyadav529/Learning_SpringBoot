package com.ragini.SpringBoot_InterviewPractice.service;

import com.ragini.SpringBoot_InterviewPractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("session")
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// virtual bean if we need to create at startup or someone is dependent on this .

public class StudentService {

    @Autowired
    Student student;

    public Student getStudent(){

        return student;
    }
}


