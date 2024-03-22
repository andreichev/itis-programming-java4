package itis.dependencyinjection.example3;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Bus implements ReachType {
    public Bus() {
        System.out.println("BUS INIT");
    }

    @Override
    public void driveToSchool() {
        System.out.println("Выйди из дома");
        System.out.println("Пойти на остановку");
        System.out.println("Доехать до школы");
    }
}
