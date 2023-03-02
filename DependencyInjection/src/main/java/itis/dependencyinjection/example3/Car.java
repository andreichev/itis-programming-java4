package itis.dependencyinjection.example3;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component
@Scope(value = "singleton")
// @Scope(value = "prototype")
@Primary
public class Car implements ReachType {
    public Car() {
        System.out.println("CAR INIT");
    }

    @Override
    public void driveToSchool() {
        System.out.println("Выйди из дома");
        System.out.println("Завести автомобиль");
        System.out.println("Доехать до школы");
    }
}
