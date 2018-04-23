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
    UserServiceImpl userService;

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
    public List<Driver> getDriversByCity(City city){ return driverRepository.findDriversByDriverCityAndDriverStatus(city, "off-work"); }

    @Transactional
    public List<City> getCities(){ return cityRepository.findAll();}

    @Transactional
    public Driver addDriver(Driver driver) {
        User user = userService.save(driver.getDriverUser());
        City city = findCityById(driver.getDriverCity().getCityId());
        driver.setDriverUser(user);
        driver.setDriverCity(city);
        driverRepository.save(driver);
        return driver;
    }

    @Transactional
    public Driver findDriverByEmail(String email){
        User user = userService.findUserByEmail(email);
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
    public void removeDriver(int driverId){
        Driver driver = driverRepository.findById(driverId).get();
        driverRepository.delete(driver);
        //userRepository.delete(driver.getDriverUser());

        //driverRepository.findDriverByDriverUser()
        //Driver driver = driverRepository.findById(driverEmail).get();
        //What's with User???
        //driverRepository.delete(driver);
    }

    @Transactional
    public void editDriver(int driverId,
                           String driverName,
                           String driverSurname,
                           String driverPhoneNumber,
                           int driverHours,
                           String driverStatus,
                           int driverCityId){
        Driver driver = driverRepository.findById(driverId).get();
        if (!driver.getDriverUser().getUserName().equals(driverName)) driver.getDriverUser().setUserName(driverName);
        if (!driver.getDriverUser().getUserSurname().equals(driverSurname)) driver.getDriverUser().setUserSurname(driverSurname);
        if (!driver.getDriverUser().getUserPhoneNumber().equals(driverPhoneNumber)) driver.getDriverUser().setUserPhoneNumber(driverPhoneNumber);
        if(driver.getDriverHours()!=driverHours) driver.setDriverHours(driverHours);
        if(!driver.getDriverStatus().equals(driverStatus)) driver.setDriverStatus(driverStatus);
        City editedCity = cityRepository.findByCityId(driverCityId);
        if(!driver.getDriverCity().equals(editedCity)) driver.setDriverCity(editedCity);
    }
}
