package ru.itis.hibernateexample.repository;

import ru.itis.hibernateexample.model.Driver;

import java.util.List;
import java.util.Optional;

public class DriverRepositoryHibernate implements CrudRepository<Driver, Long> {
    @Override
    public Optional<Driver> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public Driver save(Driver item) {
        return null;
    }

    @Override
    public void update(Long id, Driver item) {}

    @Override
    public void delete(Long id) {}
}
