package itis.dependencyinjection.example5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "prototype")
public class B {
    private final A a;

    public A getA() {
        return a;
    }

    public B(A a) {
        this.a = a;
        System.out.println("B INIT");
    }
}
