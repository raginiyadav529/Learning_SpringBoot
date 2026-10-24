package com.ragini.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Java implements ICourse{


    public Java(){

        System.out.println("Java Bean created !");
    }
    @Override
    public boolean getCourse(double price) {

        System.out.println("Course purchased by Java "+ price);
        return true;
    }
}
