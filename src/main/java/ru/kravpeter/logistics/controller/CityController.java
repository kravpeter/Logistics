package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.service.CityService;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public String citiesPage(Model model){
        model.addAttribute("citiesList", cityService.getCities());
        return "cities";
    }

    @PostMapping("/cities")
    public String addCity(@RequestParam("cityName") String cityName, Model model){
        cityService.addCity(cityName);
        model.addAttribute("citiesList", cityService.getCities());
        return "redirect:cities";
    }
}
