package ru.kravpeter.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.entity.Truck;
import ru.kravpeter.logistics.entity.User;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
    @Override
    List<Driver> findAll();

    @Override
    void delete(Driver driver);

    @Override
    Driver save(Driver driver);

    @Override
    Optional<Driver> findById(Integer driverId);

    Driver findDriverByDriverUser(User user);

    List<Driver> findDriversByDriverCityAndDriverStatus(City city, String status);
}
