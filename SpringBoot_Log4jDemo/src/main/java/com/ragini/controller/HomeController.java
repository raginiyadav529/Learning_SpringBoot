package com.ragini.controller;

import com.ragini.service.HomeService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    HomeService service;

//  private static final Logger log  = LogManager.getLogger(HomeController.class);
    private static final Logger log  = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public ResponseEntity<String> greet(){
        log.info("Control in API1");
        String body = service.greet();
        log.trace("Control in trace !");
        log.debug("Control in debug");
        log.warn("Control in warn !");


        log.error("Control in error !");

        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
