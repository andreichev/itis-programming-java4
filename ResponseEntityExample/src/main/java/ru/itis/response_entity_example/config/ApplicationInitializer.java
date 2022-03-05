package ru.itis.response_entity_example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.scan("ru.itis.response_entity_example");
        ContextLoaderListener listener = new ContextLoaderListener(springContext);
        servletContext.addListener(listener);
        springContext.register(AppConfiguration.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(springContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
