package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.entity.Truck;
import ru.kravpeter.logistics.entity.User;
import ru.kravpeter.logistics.repository.CityRepository;
import ru.kravpeter.logistics.repository.DriverRepository;
import ru.kravpeter.logistics.repository.TruckRepository;
import ru.kravpeter.logistics.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CityRepository cityRepository;

    @Transactional
    public List<Driver> getDrivers(){ return driverRepository.findAll();}

    @Transactional
    public List<Integer> getIds(){
        List<Integer> list = new ArrayList<>();
        for (Driver driver: driverRepository.findAll()) {
            list.add(driver.getDriverId());
        }
        return list;
    }

    @Transactional
    public City findCityById(int cityId){ return cityRepository.findByCityId(cityId); }

    @Transactional
    public List<Driver> getDriversByCity(City city){ return driverRepository.findDriversByDriverCity(city); }

    @Transactional
    public List<City> getCities(){ return cityRepository.findAll();}

    @Transactional
    public Driver addDriver(Driver driver) {
        User user = userServiceImpl.save(driver.getDriverUser());
        City city = findCityById(driver.getDriverCity().getCityId());
        driver.setDriverUser(user);
        driver.setDriverCity(city);
        driverRepository.save(driver);
        return driver;
    }

    @Transactional
    public Driver findDriverByEmail(String email){
        User user = userServiceImpl.findUserByEmail(email);
        Driver driver = driverRepository.findDriverByDriverUser(user);
        return driver;
    }

    @Transactional
    public List<Driver> getDriversByIds(int[] ids){
        List<Driver> drivers = new ArrayList<>();
        for (Integer i: ids) {
            drivers.add(driverRepository.findById(i).get());
        }
        return drivers;
    }

    @Transactional
    public void removeDriver(String driverEmail){
        //driverRepository.findDriverByDriverUser()
        //Driver driver = driverRepository.findById(driverEmail).get();
        //What's with User???
        //driverRepository.delete(driver);
    }
}
