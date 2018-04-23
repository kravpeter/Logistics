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
import ru.kravpeter.logistics.entity.*;
import ru.kravpeter.logistics.service.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class TripController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationFacadeImpl authenticationFacade;

    @Autowired
    TripService tripService;

    @Autowired
    TruckService truckService;

    @Autowired
    DriverService driverService;

    @Autowired
    DistanceDurationService distanceDurationService;

    private User manager;
    private City city;
    private Truck truck;
    private List<City> cityList;
    private List<Driver> driverList;
    private List<City> checkpointCityList = new ArrayList<>();
    private List<String> distanceList = new ArrayList<>();
    private List<CargoModel> checkpointCargoList =
            new ArrayList<>();



    @GetMapping("/trips")
    public String getTrips(Model model){
        model.addAttribute("trips",tripService.getTrips());
        return "trips";
    }

    @GetMapping("/addTrip1")
    public String addTrip1(Model model){
        cityList = truckService.getCities();
        model.addAttribute("citiesList", cityList);
        return "addTrip1";
    }

    @PostMapping("/addTrip1")
    public String selectCity(@RequestParam("cityId")int cityId, Model model){
        city = truckService.findCityById(cityId);
        checkpointCityList.add(city);
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
        return driverList.isEmpty() ? "addTripNoDrivers" : "addTrip3";
    }

    @PostMapping("/addTrip3")
    public String addTrip3(@RequestParam("driver") int[] drivers, Model model){
        driverList = driverService.getDriversByIds(drivers);
        return "redirect:/addTrip4";
    }

    @GetMapping("/addTrip4")
    public String addTrip4(Model model){
        model.addAttribute("city", city);
        model.addAttribute("cities", cityList);
        return "addTrip4";
    }

    @PostMapping("/addTrip4")
    public String addTrip41(@RequestParam("checkpointCity") int cityId, Model model){

        checkpointCityList.add(driverService.findCityById(cityId));

        distanceList.add(distanceDurationService.getDistanceDuration(
                checkpointCityList.get(checkpointCityList.size() - 2).getCityName(),
                checkpointCityList.get(checkpointCityList.size() - 1).getCityName()));

        return "redirect:/addTrip5";
    }
    @GetMapping("/addTrip5")
    public String addTrip5(Model model){
        model.addAttribute("checkpointCities", checkpointCityList);
        model.addAttribute("distances", distanceList);
        model.addAttribute("city", city);
        model.addAttribute("cities", cityList);
        return "addTrip5";
    }

    @PostMapping("/addTrip42")
    public String addTrip42(Model model){

        return "addTrip6";
    }

    @GetMapping("/addTrip6")
    public String addTrip6 (Model model){
        String s = "Chosen waypoints: ";
        for (int i = 0; i < checkpointCityList.size() - 1; i++) {
            s += checkpointCityList.get(i).getCityName() + " -> ";
        }
        s += checkpointCityList.get(checkpointCityList.size()-1).getCityName();
        model.addAttribute("truck", truck);
        model.addAttribute("checkpoints", checkpointCityList);
        model.addAttribute("cargoes",checkpointCargoList);
        model.addAttribute("waypoints", s);
        return "addTrip6";
    }
    @PostMapping("/addTrip6")
    public String addCargoes (@RequestParam("checkpointIn") int cityIdIn,
                              @RequestParam("checkpointOut") int cityIdOut,
                              @RequestParam("cargoType") String cargoType,
                              @RequestParam("weight") short weight,
                              Model model){
        //quntityOfCheckpoints = checkpointCityList.size();
        checkpointCargoList.add(new CargoModel(driverService.findCityById(cityIdIn),
                cargoType, weight, "in"));
        checkpointCargoList.add(new CargoModel(driverService.findCityById(cityIdOut),
                cargoType, weight, "out"));
        return "redirect:/addTrip6";
    }
    @GetMapping("/addTrip7")
    public String addTrip7 (Model model){
        manager = userService.findUserByEmail(authenticationFacade.getAuthentication().getName());
        tripService.addTrip(manager,truck, driverList, checkpointCityList, checkpointCargoList);
        return "addTrip7";
    }

}
