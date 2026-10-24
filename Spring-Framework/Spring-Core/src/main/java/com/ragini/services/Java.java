package com.ragini.services;

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
