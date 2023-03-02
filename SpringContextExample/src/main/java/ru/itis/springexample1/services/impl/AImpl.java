package ru.itis.springexample1.services.impl;

import org.springframework.stereotype.Component;
import ru.itis.springexample1.services.A;

@Component
public class AImpl implements A {
    @Override
    public String getMessage() {
        return "HELLO FROM A";
    }
}
