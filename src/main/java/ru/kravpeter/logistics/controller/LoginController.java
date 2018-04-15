package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kravpeter.logistics.service.SecurityService;
import ru.kravpeter.logistics.service.SecurityServiceImpl;
import ru.kravpeter.logistics.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }



}
