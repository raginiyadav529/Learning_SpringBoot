package com.ragini.services;

import org.springframework.stereotype.Service;


@Service
public class SpringBoot implements ICourse{

    public SpringBoot(){

        System.out.println("SpringBoot Bean created !");
    }

    @Override
    public boolean getCourse(double price) {

        System.out.println("Course purchased by SpringBoot "+ price);
        return true ;
    }
}
