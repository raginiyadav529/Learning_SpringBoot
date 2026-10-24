package com.ragini.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {                //  ******  ApplicationContext   *****

    public static void main(String[] args) {  // Eager initialization

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        TShaped tShaped = context.getBean(TShaped.class);
        boolean status = tShaped.buyCourse(499.9);

        if(status){
            System.out.println("Successful !");
        }
        else{
             System.out.println("Failed to purchase course !!!");
        }
    }
}

// Two-way to activate IOC Container for creating Beans
//ApplicationContext , BeanFactory

