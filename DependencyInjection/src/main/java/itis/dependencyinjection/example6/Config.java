package itis.dependencyinjection.example6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    A createA() {
        System.out.println("I WILL CREATE A OBJECT");
        return new A();
    }
}
