package ru.itis.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import java.util.Set;

public class ApplicationInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
        System.out.println("CONTEXT WILL BE INITIALIZED");
    }
}
