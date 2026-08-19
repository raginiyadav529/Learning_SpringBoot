package com.ragini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeService implements IGreetService {

    @Override
    public String greet() {

      Logger log = LoggerFactory.getLogger(HomeService.class);
      log.trace("Business logic in Service layer");

        LocalDateTime dateTime = LocalDateTime.now();
        int hour =dateTime.getHour();
        String body =null;
        if(hour <12){
            body="Good Morning !";
        }
        else if (hour<16){
            body ="Good Afternoon !";
        }
        else if (hour<18){
            body ="Good Evening !";
        }
        else{
            body ="Good night !";
        }
        return body;
    }
}
