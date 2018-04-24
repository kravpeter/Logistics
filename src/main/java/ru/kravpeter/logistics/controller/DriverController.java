package ru.kravpeter.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kravpeter.logistics.entity.Checkpoint;
import ru.kravpeter.logistics.entity.Driver;
import ru.kravpeter.logistics.service.AuthenticationFacade;
import ru.kravpeter.logistics.service.CheckpointService;
import ru.kravpeter.logistics.service.DriverService;
import ru.kravpeter.logistics.service.TruckService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@Controller
public class DriverController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CheckpointService checkpointService;

    @Autowired
    private TruckService truckService;

    private Driver driver;

    private Set<Checkpoint> checkpoints;

    private Checkpoint currentCheckpoint;

    private Iterator<Checkpoint> iterator;

    /*@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }*/

    @GetMapping("/driver")
    public String driver(Model model) {
        driver = driverService.findDriverByEmail(authenticationFacade.getAuthentication().getName());
        checkpoints = new LinkedHashSet<>(driver.getDriverTrip().getTripCheckpoints());
        //numOfCheckpoints = checkpoints.size();
        model.addAttribute("driver", driver);
        model.addAttribute("checkpoints", checkpoints);
        return "driver";
    }

    @GetMapping("/driverStatus")
    public String driverStatus(Model model){
        iterator = checkpoints.iterator();
        while (iterator.hasNext())
        {
            currentCheckpoint = iterator.next();
            if(currentCheckpoint.getCheckpointStatus().equals("not passed")){
                model.addAttribute("currentCheckpoint", currentCheckpoint);
                return "driverStatus";
            }

        }

        return "driverStatus";
    }

    @PostMapping("/driverStatus")
    public String editStatus(Model model){
        currentCheckpoint.setCheckpointStatus("passed");
        checkpointService.save(currentCheckpoint);
        return "redirect:/driver";
    }
    @PostMapping("/changeDriverStatus")
    public String changeDriverStatus(@RequestParam("changeDriverStatus") String status,
                                     //@RequestParam("_csrf") String str,
                                     Model model){
        driver.setDriverStatus(status);
        driverService.changeDriver(driver);
        return "redirect:driver";
    }
/*ChangeDriverStatus

    @GetMapping("/username")
    @ResponseBody
    public String currentUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }*/
}
