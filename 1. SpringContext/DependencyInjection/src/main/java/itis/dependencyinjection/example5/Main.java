package itis.dependencyinjection.example5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("itis.dependencyinjection.example5");
        A obj = context.getBean(A.class);
        B b = obj.b.getA().b.getA().b.getA().b.getA().b;
    }
}
