package ru.itis.springexample1.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.itis.springexample1");
        servletContextEvent.getServletContext().setAttribute("context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
