package itis.dependencyinjection.example3;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Taxi implements ReachType {
    public Taxi() {
        System.out.println("TAXI INIT");
    }

    @Override
    public void driveToSchool() {
        System.out.println("Выйди из дома");
        System.out.println("Заказать такси");
        System.out.println("Сесть в такси");
        System.out.println("Доехать до школы");
    }
}
