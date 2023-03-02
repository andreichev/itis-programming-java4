package itis.dependencyinjection.example5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "prototype")
public class B {
    @Autowired
    public A a;

    B() {
        System.out.println("B INIT");
    }
}
