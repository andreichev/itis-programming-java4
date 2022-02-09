package itis.dependencyinjection.example4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Drova implements Boiler {
    Drova() {
        System.out.println("DROVA INITIALIZED");
    }

    @Override
    public void warm() {
        System.out.println("DROVA");
    }
}
