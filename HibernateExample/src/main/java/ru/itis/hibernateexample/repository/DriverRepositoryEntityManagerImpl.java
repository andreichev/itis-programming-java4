package ru.itis.hibernateexample.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.itis.hibernateexample.config.HibernateConfig;
import ru.itis.hibernateexample.model.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


public class DriverRepositoryEntityManagerImpl implements CrudRepository<Driver, Long> {

    SessionFactory factory = HibernateConfig.getSessionFactory();
//    EntityManager entityManager = factory.createEntityManager();
//    private String HQL_SELECT_ALL = "from Driver";
//    private String HQL_DELETE_BY_ID = "delete from Driver where id = :id";

    @Override
    public Optional<Driver> findById(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(Driver.class, id));
        }
//        return Optional.ofNullable(entityManager.find(Driver.class, id));
    }

    @Override
    public List<Driver> findAll() {
        try (Session session = factory.openSession()) {
            Query<Driver> query1 = session.createQuery("FROM Driver", Driver.class);
            return query1.getResultList();
        }
//        Query query1 = entityManager.createQuery(HQL_SELECT_ALL);
//        List<Driver> drivers = query1.getResultList();
//        return drivers;
    }

    @Override
    public Driver save(Driver item) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            if (item.getId() == null) { // check if item is already persisted or not
                session.save(item); // persist new entity object in database and assign generated ID to it
            } else {
                // merge existing entity object with updated fields into database and update its state.
                item = (Driver) session.merge(item);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();   // rollback the changes made during the transactions on exception.
            }
        }
        return item;
//        entityManager.persist(item);
//        return item;
    }


    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            String hqlDeleteById = "delete from Driver where id=:id";
            Query<?> query = session.createQuery(hqlDeleteById).setParameter("id", id);
            transaction = session.beginTransaction();
            int noOfEntitiesDeleted = query.executeUpdate();// returns number of entities deleted
            if (noOfEntitiesDeleted == 0) {
                throw new EntityNotFoundException("No entity found for deletion with id: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // rollback the changes made during the transactions on exception.
            }
        }


//        entityManager.createQuery(HQL_DELETE_BY_ID)
//                .setParameter("id", id)
//                .executeUpdate();
    }
}
