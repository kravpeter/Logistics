package ru.kravpeter.logistics.repository;

import ru.kravpeter.logistics.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findByCityId(int cityId);

    @Override
    List<City> findAll();

    City save(City city);
}
