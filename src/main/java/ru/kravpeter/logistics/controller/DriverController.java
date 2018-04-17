package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.service.AuthenticationFacade;
import ru.kravpeter.logistics.service.DriverService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class DriverController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private DriverService driverService;

    /*@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }*/

    @GetMapping("/driver")
    public String driver(Model model) {
        Driver driver = driverService.findDriverByEmail(authenticationFacade.getAuthentication().getName());
        model.addAttribute("driver", driver);
        return "driver";
    }
/*
    @GetMapping("/username")
    @ResponseBody
    public String currentUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }*/
}
