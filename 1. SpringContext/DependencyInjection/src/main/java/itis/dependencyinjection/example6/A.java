package itis.dependencyinjection.example6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

// @Component
public class A {
    @Autowired
    public B b;

    A() {
        System.out.println("A INIT");
    }
}
