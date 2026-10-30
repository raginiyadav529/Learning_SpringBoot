package com.ragini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
   private TwoFAuthenticationProperties twoFAuthenticationProperties;

    @GetMapping("/")
    public String getMsg (){

        return " Hello and Welcome !!!";
    }

    private boolean is2fa;

    @GetMapping("/2fa")
    public boolean is2faEnabled(){

        return twoFAuthenticationProperties.isEnabled() ;
    }

    /*
    @Value("${feature.2fa.enabled}")
    private boolean is2fa;

    @GetMapping("/2fa")
    public boolean is2faEnabled(){

        return  is2fa ;
    }
     */
}


/************
 *
 * I want to use those custom properties in my application so how can that be done ???
 * --> There are 3 different ways .
 * 1. Using @Value annotation
 * 2. Using @ConfigurationProperties
 * 3. Using Environment Reference
 *
 *
 *
 *
 * *************/