package mvc.main;

import mvc.config.Config;
import mvc.service.Password;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {


        //Annotation + xml Approach
/*
        ApplicationContext container =
                new ClassPathXmlApplicationContext("applicationContextMVC.xml");

        Password pass = container.getBean(Password.class);
        pass.display();
 */

        //  Annotation Approach

        ApplicationContext container =
                new AnnotationConfigApplicationContext(Config.class); // it'll see component-scan configuration from Config.class

        Password pass = container.getBean(Password.class);
        pass.display();

    }
}
