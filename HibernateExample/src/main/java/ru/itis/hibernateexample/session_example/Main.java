package ru.itis.hibernateexample.session_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.itis.hibernateexample.config.HibernateConfig;
import ru.itis.hibernateexample.model.Car;
import ru.itis.hibernateexample.model.Driver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateConfig.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // HQL
            //  select * from driver
            String hql1 = "select d from Driver d";
            //  Create Query object
            Query<Driver> query1 = session.createQuery(hql1, Driver.class);
            List<Driver> drivers = query1.getResultList();
            for (Driver driver : drivers) {
                System.out.println(driver.getFirstName());
            }

            // HQL
            // select * from driver
            String hql2 = "select c from Car c left join Driver d on c.driver = d";
            // String hql2 = "from Car";
            // Create Query object.
            Query<Car> query2 = session.createQuery(hql2);
            List<Car> cars = query2.getResultList();
            for (Car car : cars) {
                System.out.println(car.getDriver().getFirstName());
            }

            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            String lastName = scanner.next();
            int age = scanner.nextInt();

            Driver driver = Driver.builder()
                    .firstName(name)
                    .lastName(lastName)
                    .age(age)
                    .build();
            Long id = (Long) session.save(driver);
            driver.setId(id);
            System.out.println(String.format("Created driver with id: %d", id));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            HibernateConfig.shutdown();
        }
    }
}
