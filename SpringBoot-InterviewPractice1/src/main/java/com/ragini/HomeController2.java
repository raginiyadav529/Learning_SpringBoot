package com.ragini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController2 {

    @Autowired
    private TwoFAuthenticationProperties twoFAuthenticationProperties;

    @Autowired
    private Environment environment;

    @GetMapping("/send")
    public  void send2faCode(){

     Boolean is2fa = environment.getProperty("feature.2fa.enabled",Boolean.class);
       String provider = environment.getProperty("feature.2fa.provider");
        if(is2fa){

          if (provider.equals("sms")) {

              System.out.println("Sms flow triggered !");
          }
          else if (provider.equals("email")){

              System.out.println("Email flow triggered !");
          }
        }
        // throw some error
    }

    /*
    @GetMapping("/send")
    public  void send2faCode(){

        if(twoFAuthenticationProperties.isEnabled()){

            if (twoFAuthenticationProperties.getProvier().equals("sms")) {

                // send via sms
            } else if (twoFAuthenticationProperties.getProvier().equals("email")){

                // send via Email
            }
        }
    }
     */

    /*
    @Value("${feature.2fa.enabled}")
    private boolean is2faEnabled ;

    @Value("${feature.2fa.provider}")
    String provider;

    @GetMapping("/send")
    public  void send2faCode(){

        if(is2faEnabled){

            if (provider.equals("sms")){

                // send via sms
            } else if (provider.equals("email")){

                // send via Email
            }
        }
     */

    }
