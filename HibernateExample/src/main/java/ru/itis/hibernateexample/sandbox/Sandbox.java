package ru.itis.hibernateexample.sandbox;

import ru.itis.hibernateexample.model.Driver;
import ru.itis.hibernateexample.repository.CrudRepository;
import ru.itis.hibernateexample.repository.DriverRepositoryEntityManagerImpl;

import java.util.Optional;

public class Sandbox {
    public static void main(String[] args) {
        CrudRepository<Driver, Long> driversRepository = new DriverRepositoryEntityManagerImpl();

        Optional<Driver> optionalDriver = driversRepository.findById(1L);
        if(optionalDriver.isPresent()) {
            System.out.println(optionalDriver.get().getCars().getClass().getName());
            System.out.println("-----------");
            // System.out.println(optionalDriver.get().getCars().get(0).getDriver());
        }

        // Driver driver = Driver.builder().firstName("ASsddsa").lastName("SAdssd").age(20).build();
        // driversRepository.save(driver);

        // List<Driver> drivers = driversRepository.findAll();
        // for (Driver driver1: drivers) {
        //     System.out.println(driver1);
        // }
    }
}
