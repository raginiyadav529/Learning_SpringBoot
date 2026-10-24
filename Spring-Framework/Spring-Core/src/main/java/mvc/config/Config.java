package mvc.config;

import mvc.service.Password;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"mvc"})  // only create and manage bean of mvc package's classes
public class Config {

    public Config(){

        System.out.println("Config called !");
    }

    @Bean
    public Password showPassword(){

        return new Password(12345);
    }
}
