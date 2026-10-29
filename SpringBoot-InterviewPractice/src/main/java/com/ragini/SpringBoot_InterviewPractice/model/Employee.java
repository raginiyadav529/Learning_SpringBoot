package com.ragini.SpringBoot_InterviewPractice.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev","test"})
public class Employee {

    public Employee(){

        System.out.println("Employee Constructor called !!! "+this.hashCode());
    }
}

/*********   Spring Profiles -->
 *
 * Employee class's bean will be created only when dev and test environments are activate .
 *
 *
 * @Profile("dev") -->Single environment
 *
 * @Profile({"dev","test","prod"})-->multiple environment
 * *********/