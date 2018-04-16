package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kravpeter.logistics.entity.User;
import ru.kravpeter.logistics.service.SecurityService;
import ru.kravpeter.logistics.service.UserService;
import ru.kravpeter.logistics.validator.UserValidator;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @GetMapping("/admin")
    public String getView(Model model){
        model.addAttribute("userForm", new User());
        return "admin";
    }
    @PostMapping("/admin")
    public String addManager(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin";
        }

        userService.save(userForm);

        //securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "admin";

    }
}
