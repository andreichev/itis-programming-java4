package ru.itis.spring_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("HELLO!");
        SpringApplication.run(Main.class, args);
    }
}
