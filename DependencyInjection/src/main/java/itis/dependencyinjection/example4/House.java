package itis.dependencyinjection.example4;

import org.springframework.stereotype.Component;

@Component
public class House {
    Boiler b;

    public House(Boiler b) {
        this.b = b;
        System.out.println("HOUSE INITIALIZED");
    }

    void func() {
        b.warm();
    }
}
