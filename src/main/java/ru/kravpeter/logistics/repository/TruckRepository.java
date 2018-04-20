package ru.kravpeter.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Truck;

import java.util.List;
import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, String> {

    @Override
    List<Truck> findAll();

    @Override
    void delete(Truck entity);

    @Override
    Truck save(Truck truck);

    @Override
    Optional<Truck> findById(String truckRegNumber);

    List<Truck> findTrucksByCity(City city);
}
