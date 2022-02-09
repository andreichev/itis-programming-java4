package itis.dependencyinjection.example4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GazBoiler implements Boiler {
    @Override
    public void warm() {
        System.out.println("GAZ");
    }
}
