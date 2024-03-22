package itis.dependencyinjection.example6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("itis.dependencyinjection.example6");
        A obj = context.getBean(A.class);
        A obj1 = context.getBean(A.class);
        B b = obj.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b.a.b;
    }
}
