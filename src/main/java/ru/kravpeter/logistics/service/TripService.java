package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravpeter.logistics.entity.City;

import java.util.List;

@Service
public class TripService {
    @Autowired
    TruckService truckService;

    @Autowired
    CityService cityService;

    @Autowired
    DriverService driverService;


}
