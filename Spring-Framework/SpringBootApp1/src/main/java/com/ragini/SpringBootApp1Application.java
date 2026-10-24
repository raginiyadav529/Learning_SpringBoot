package com.ragini;

import com.ragini.services.TShaped;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApp1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext container = SpringApplication.run(SpringBootApp1Application.class, args);
		System.out.println("Hello Ragini !!!");

//		Greetings greet =container.getBean(Greetings.class);
//		System.out.println(greet.greetingWish());

		TShaped tShaped = container.getBean(TShaped.class);
		System.out.println(tShaped.buyCourse(599.9));
	}
}
