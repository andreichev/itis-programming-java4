package ru.itis.hibernateexample.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.itis.hibernateexample.config.HibernateConfig;
import ru.itis.hibernateexample.model.Driver;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class DriverRepositorySessionImpl implements CrudRepository<Driver, Long> {

    SessionFactory factory = HibernateConfig.getSessionFactory();

    private String HQL_SELECT_ALL = "from Driver";
    private String HQL_DELETE_BY_ID = "delete from Driver where id = :id";

    @Override
    public Optional<Driver> findById(Long id) {
        Optional<Driver> driverOptional;
        Session session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            driverOptional = Optional.of(session.get(Driver.class, id));
            session.getTransaction().commit();
            return driverOptional;
        }  catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return Optional.empty();
        }
    }

    @Override
    public List<Driver> findAll() {
        Session session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            //  Create Query object
            Query query1 = session.createQuery(HQL_SELECT_ALL);
            List<Driver> drivers = query1.getResultList();
            for (Driver driver : drivers) {
                System.out.println(driver.getFirstName());
            }
            session.getTransaction().commit();

            return drivers;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Driver save(Driver item) {
        Session session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            Driver driver = Driver.builder()
                    .firstName(item.getFirstName())
                    .lastName(item.getLastName())
                    .age(item.getAge())
                    .build();
            Long id = (Long) session.save(driver);
            driver.setId(id);
            session.getTransaction().commit();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Session session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.createQuery(HQL_DELETE_BY_ID)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}
