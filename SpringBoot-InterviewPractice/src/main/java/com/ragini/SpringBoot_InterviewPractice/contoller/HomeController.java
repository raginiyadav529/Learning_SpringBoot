package com.ragini.SpringBoot_InterviewPractice.contoller;

import com.ragini.SpringBoot_InterviewPractice.model.Student;
import com.ragini.SpringBoot_InterviewPractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Scope("session")

public class HomeController {

    @Autowired
    Student student1;

    @Autowired
    StudentService studentService ;

  /*
   @Autowired
    Student student2;
    @Autowired
    Student student3;
*/

    public HomeController(){

        System.out.println("HomeController Bean is created ! "+this.hashCode());
    }

    @GetMapping("/name1")
    public void getName1(){

        System.out.println("H1 :"+student1.hashCode());
        System.out.println("H2 :"+studentService.getStudent().hashCode());
    }

    /*
    @GetMapping("/name1")
    public String getName1(){

        return "Ragini Yadav ! "+student1.hashCode();
    }
    @GetMapping("/name2")
    public String getName2(){

        return "Nidhi Yadav ! "+student2.hashCode();
    }
    @GetMapping("/name3")
    public String getName3(){

        return "Prince Yadav ! "+student3.hashCode();
    }

     */
}



/************
 *
 *  1. Singleton scope(default scope) --> Crete a bean at the very beginning and that bean
       remain throughout the project as long as application is running.
 *
 *  2. Prototype scope --> It will create a new bean each time you autowired it or used in your application .
 *
 *  3. Request scope --> A bean will be created but its scope will be limited to that one api call
       after that when you make the api call again , it will be created a bean again as new one .
 *
 *  4. Session scope --> A new bean will be created everytime session is get changed .
 *  ******************/


