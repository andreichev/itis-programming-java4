package itis.dependencyinjection.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjection2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("itis.dependencyinjection.example3");
        ReachType reachType1 = context.getBean(ReachType.class);
        // ReachType reachType2 = context.getBean(ReachType.class);
        reachType1.driveToSchool();
    }
}
