package itis.dependencyinjection.example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("itis.dependencyinjection.example4");
        House house = context.getBean(House.class);
        house.func();
    }
}
