package ru.kravpeter.logistics.repository;

import org.hibernate.Criteria;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.entity.Trip;
import ru.kravpeter.logistics.entity.User;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long>{
    @Override
    List<Trip> findAll();

    @Override
    void delete(Trip entity);

    @Override
    Trip save(Trip driver);
}
