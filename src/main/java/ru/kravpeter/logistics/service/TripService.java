package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.*;
import ru.kravpeter.logistics.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    TruckRepository truckRepository;

    @Autowired
    CheckpointRepository checkpointRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Transactional
    public void addTrip(User managerUser, Truck truck, List<Driver> drivers, List<City> checkpoints, List<CargoModel> cargoes, int duration){
        Trip trip = new Trip();
        trip.setTripManager(managerUser);
        truck.setTruckDrivers(drivers);
        truck.setTruckStatus("in trip");
        trip.setTripTruck(truck);
        //trip.setTripDrivers(drivers);
        trip.setTripStatus("in progress");
        truckRepository.save(truck);
        List<Checkpoint> checkpointList = new ArrayList<>();
        for (City city: checkpoints) {
            Checkpoint checkpoint = new Checkpoint();
            checkpoint.setCheckpointArrCity(city);
            checkpoint.setCheckpointTrip(trip);
            checkpoint.setCheckpointStatus("not passed");
            List<Cargo> cargoList = new ArrayList<>();
            for (CargoModel cm: cargoes) {
                if(city.equals(cm.getCity())){
                    Cargo cargo = new Cargo();
                    cargo.setCargoCheckpoint(checkpoint);
                    cargo.setCargoStatus(cm.getCargoStatus());
                    cargo.setCargoType(cm.getCargoType());
                    cargo.setCargoWeight(cm.getCargoWeight());
                    //cargo = cargoRepository.save(cargo);
                    cargoList.add(cargo);
                }
            }
            checkpoint.setCheckpointCargoes(cargoList);
            //checkpoint = checkpointRepository.save(checkpoint);
            checkpointList.add(checkpoint);
        }
        trip.setTripCheckpoints(checkpointList);
        trip = tripRepository.save(trip);
        for (Driver driver: drivers) {
            driver.setDriverTruck(truck);
            driver.setDriverStatus("standby");
            driver.setDriverHours(duration);
            driver.setDriverTrip(trip);
            driverRepository.save(driver);
        }
    }

    @Transactional
    public List<Trip> getTrips(){ return tripRepository.findAll(); }


}
