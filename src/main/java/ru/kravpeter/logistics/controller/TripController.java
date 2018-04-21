package ru.kravpeter.logistics.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.entity.Truck;
import ru.kravpeter.logistics.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    TruckService truckService;

    @Autowired
    DriverService driverService;

    private City city;
    private Truck truck;
    private List<Driver> driverList;



    @GetMapping("/trips")
    public String getTrips(Model model){
        model.addAttribute("trips",tripService.getTrips());
        return "trips";
    }

    @GetMapping("/addTrip1")
    public String addTrip1(Model model){
        model.addAttribute("citiesList", truckService.getCities());
        return "addTrip1";
    }

    @PostMapping("/addTrip1")
    public String selectCity(@RequestParam("cityId")int cityId, Model model){
        city = truckService.findCityById(cityId);
        List<Truck> truckList = truckService.getTrucksByCity(city);
        model.addAttribute("trucksList", truckList);
        return truckList.isEmpty() ? "addTripNoTrucks" : "addTrip2";
    }

    @GetMapping("/addTrip2")
    public String addTrip2(@RequestParam("truckRegNumber") String truckRegNumber, Model model){
        truck = truckService.findTrucksByTruckRegNumber(truckRegNumber);
        return "redirect:/addTrip3";
    }

    @GetMapping("/addTrip3")
    public String addTrip3(Model model){
        driverList = driverService.getDriversByCity(city);
        String string = "Quantity of drivers on the selected vehicle (" + truck.getTruckRegNumber() + ") should be " + truck.getTruckQuantityOfDrivers() + ".";
        String string2 = "Please, choose not more then " + truck.getTruckQuantityOfDrivers() + " drivers.";
        model.addAttribute("quantityDrivers", string);
        model.addAttribute("chooseDrivers", string2);
        model.addAttribute("checkedDriverList", new DriverList());
        model.addAttribute("driverList", driverList);
        //driverList.isEmpty() ? "addTripNoDrivers" :
        return "addTrip3";
    }


    @GetMapping("/addTrip5")
    public String addTrip5(@RequestParam("newRoute") int newRoute,
                           Model model){


        return "addTrip5";
    }



}
