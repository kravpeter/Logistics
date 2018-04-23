package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/drivers/delete")
    public String deleteDriver(@RequestParam("driverDelete") int driverId,
                               Model model){
        driverService.removeDriver(driverId);
        return "redirect:/drivers";
    }

    @PostMapping("/drivers/edit")
    public String editeDriver(@RequestParam("driverId") int driverId,
                              @RequestParam("driverName") String driverName,
                              @RequestParam("driverSurname") String driverSurname,
                              @RequestParam("driverPhoneNumber") String driverPhoneNumber,
                              @RequestParam("driverHours") int driverHours,
                              @RequestParam("driverStatus") String driverStatus,
                              @RequestParam("driverCity") int driverCityId,
                               Model model){
        driverService.editDriver(driverId,
                driverName,
                driverSurname,
                driverPhoneNumber,
                driverHours,
                driverStatus,
                driverCityId);
        return "redirect:/drivers";
    }
}
