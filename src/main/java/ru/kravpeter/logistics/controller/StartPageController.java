package ru.kravpeter.logistics.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/")
public class StartPageController {
    @GetMapping("/success")
    public String getStartPage(HttpServletRequest req, HttpServletResponse resp){
        if (req.isUserInRole("ROLE_ADMIN")) return "redirect:/admin";
        else if (req.isUserInRole("ROLE_MANAGER")) return  "staff";
        else if (req.isUserInRole("ROLE_DRIVER")) return  "driver";
        return "index";
    }
}
