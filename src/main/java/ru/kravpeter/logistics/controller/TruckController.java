package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.service.DriverService;
import ru.kravpeter.logistics.service.TruckService;

@Controller
@RequestMapping("")
public class TruckController {

    @Autowired
    TruckService truckService;

    @Autowired
    DriverService driverService;

    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public String showTrucks(Model model){
        model.addAttribute("truckAndCitiesList",truckService.getTrucks());
        model.addAttribute("citiesList", truckService.getCities());
        return "trucks";
    }

    @RequestMapping(value = "/trucks", method = RequestMethod.POST)
    public String addTruck(@RequestParam("reg-number-input") String truckRegNumber,
                           @RequestParam("capacity-input") short truckCapacity,
                           @RequestParam("quantity-of-drivers-input") short truckQuantityOfDrivers,
                           @RequestParam("condition-select") String truckCondition,
                           @RequestParam("city-select") int cityId,
                           Model model){
       City city = truckService.findCityById(cityId);
        truckService.addTruck(truckRegNumber, truckCapacity, truckQuantityOfDrivers, truckCondition, city);
        model.addAttribute("truckAndCitiesList", truckService.getTrucks());
        return "redirect:trucks";
    }
    @RequestMapping(value = "trucks/delete", method = RequestMethod.POST)
    public String deleteTruck(@RequestParam("reg-number-select") String truckRegNumber,
                              Model model){
        truckService.removeTruck(truckRegNumber);
        model.addAttribute("truckAndCitiesList", truckService.getTrucks());
        return "redirect:/trucks";
    }
}
