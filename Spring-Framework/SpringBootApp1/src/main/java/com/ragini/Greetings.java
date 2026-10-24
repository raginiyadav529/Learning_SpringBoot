package com.ragini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class Greetings {

   @Autowired
   private LocalTime time ;

    public Greetings(){

        System.out.println("Greeting bean created --> Constructor ");
    }

    public String greetingWish(){

        int hour = time.getHour();

        if(hour < 12 ){

            return "Good Morning !";
        }
        else if (hour < 16){

            return "Good Afternoon !";
        } else if (hour < 20){

            return "Good Evening !";
        }
        else{
            return "Good Night !";
        }
    }
}
