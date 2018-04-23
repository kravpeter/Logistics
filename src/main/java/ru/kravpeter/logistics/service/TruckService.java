package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Truck;
import ru.kravpeter.logistics.repository.CityRepository;
import ru.kravpeter.logistics.repository.DriverRepository;
import ru.kravpeter.logistics.repository.TruckRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TruckService {

    @Autowired
    TruckRepository truckRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CityRepository cityRepository;

    @Transactional
    public List<Truck> getTrucks(){ return truckRepository.findAll();}

    @Transactional
    public City findCityById(int cityId){ return cityRepository.findByCityId(cityId); }

    @Transactional
    public List<City> getCities(){ return cityRepository.findAll();}

    @Transactional
    public List<Truck> getTrucksByCity(City city){ return truckRepository.findTrucksByCityAndTruckStatus(city,"working");}

    @Transactional
    public Truck findTrucksByTruckRegNumber(String truckRegNumber){ return truckRepository.findById(truckRegNumber).get();}

    @Transactional
    public Truck addTruck(String truckRegNumber, short truckCapacity, short truckQuantityOfDrivers, String truckCondition, City city) {
        Truck truck = new Truck();
        truck.setTruckRegNumber(truckRegNumber);
        truck.setTruckCapacity(truckCapacity);
        truck.setTruckQuantityOfDrivers(truckQuantityOfDrivers);
        truck.setTruckStatus(truckCondition);
        truck.setCity(city);
        truckRepository.saveAndFlush(truck);
        return truck;
    }

    @Transactional
    public void removeTruck(String truckRegNumber){
        Truck truck = truckRepository.findById(truckRegNumber).get();
        truckRepository.delete(truck);
    }

}
