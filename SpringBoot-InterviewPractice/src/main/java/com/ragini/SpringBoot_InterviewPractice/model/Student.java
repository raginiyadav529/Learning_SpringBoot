package com.ragini.SpringBoot_InterviewPractice.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("session")

//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// virtual bean if we need to create at startup  .

public class Student {


    public Student(){

        System.out.println("student Constructor called !!! "+this.hashCode());
    }
}


/****
 *
 *
 *  when a bean depends on another bean with a scope that prevents immediate instantiation,
   a proxy is created to allow the dependent bean to be instantiated without delay .
 *
 *
 * *****/