package itis.dependencyinjection.example5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    public B b;

    A() {
        System.out.println("A INIT");
    }
}
