package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.Cargo;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Trip;
import ru.kravpeter.logistics.repository.CargoRepository;
import ru.kravpeter.logistics.repository.CheckpointRepository;
import ru.kravpeter.logistics.repository.TripRepository;

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
    public List<Trip> getTrips(){ return tripRepository.findAll(); }


}
