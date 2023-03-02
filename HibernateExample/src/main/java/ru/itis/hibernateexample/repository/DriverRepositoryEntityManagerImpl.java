package ru.itis.hibernateexample.repository;

import org.hibernate.SessionFactory;
import ru.itis.hibernateexample.config.HibernateConfig;
import ru.itis.hibernateexample.model.Driver;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class DriverRepositoryEntityManagerImpl implements CrudRepository<Driver, Long> {

    SessionFactory factory = HibernateConfig.getSessionFactory();
    EntityManager entityManager = factory.createEntityManager();
    private String HQL_SELECT_ALL = "from Driver";
    private String HQL_DELETE_BY_ID = "delete from Driver where id = :id";

    @Override
    public Optional<Driver> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Driver.class, id));
    }

    @Override
    public List<Driver> findAll() {
        Query query1 = entityManager.createQuery(HQL_SELECT_ALL);
        List<Driver> drivers = query1.getResultList();
        return drivers;
    }

    @Override
    public Driver save(Driver item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(HQL_DELETE_BY_ID)
                .setParameter("id", id)
                .executeUpdate();
    }
}
