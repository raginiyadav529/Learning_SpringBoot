package com.ragini.services;

public class TShaped {  // Target class

    private  ICourse course ;

    public TShaped(){

        System.out.println("TShaped Bean created !");
    }

    public TShaped(ICourse course) {
        this.course = course;
        System.out.println("Dependency injection through Constructor");
    }

    public void setCourse(ICourse course) { // setter
        this.course = course;
        System.out.println("Setter injection !!!");
    }

    public boolean buyCourse(double amount){

        return course.getCourse(amount);
    }
}
