package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kravpeter.logistics.service.CityService;


@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String greeting(Model model) {

        return "index";
    }

}
