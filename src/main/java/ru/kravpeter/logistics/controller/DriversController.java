package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.service.DriverService;

@Controller
public class DriversController {

    @Autowired
    protected DriverService driverService;

    @GetMapping("/drivers")
    public String drivers(Model model){
        model.addAttribute("driversList", driverService.getDrivers());
        model.addAttribute("citiesList", driverService.getCities());
        model.addAttribute("newDriver", new Driver());
        return "drivers";
    }

    @PostMapping("/drivers")
    public String addDriver(@ModelAttribute Driver driver, Model model){
        driverService.addDriver(driver);
        return "redirect:drivers";
    }
}
