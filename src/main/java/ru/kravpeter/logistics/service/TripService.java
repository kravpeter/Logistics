package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.*;
import ru.kravpeter.logistics.repository.CargoRepository;
import ru.kravpeter.logistics.repository.CheckpointRepository;
import ru.kravpeter.logistics.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    CheckpointRepository checkpointRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Transactional
    public void addTrip(User managerUser, Truck truck, List<Driver> drivers, List<City> checkpoints, List<CargoModel> cargoes){
        Trip trip = new Trip();
        trip.setTripManager(managerUser);
        truck.setTruckDrivers(drivers);
        trip.setTripTruck(truck);
        trip.setTripDrivers(drivers);
        trip.setTripStatus("in progress");
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
        tripRepository.save(trip);
    }

    @Transactional
    public List<Trip> getTrips(){ return tripRepository.findAll(); }


}
