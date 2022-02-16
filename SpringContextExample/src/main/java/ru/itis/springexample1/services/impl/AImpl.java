package ru.itis.springexample1.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.itis.springexample1.services.A;

@Service
public class AImpl implements A {
    @Override
    public String getMessage() {
        return "HELLO FROM A";
    }
}
