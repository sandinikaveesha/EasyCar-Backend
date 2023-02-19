package com.easycar.backend.controller;

import com.easycar.backend.model.DriverDetails;
import com.easycar.backend.service.DriverDetailsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverDetailsController {
    @Autowired
    private DriverDetailsService driverDetailsService;

    @PostMapping("/add_driver")
    public String addDriver(@RequestBody ObjectNode node){return driverDetailsService.driverDetails(node);}

    @GetMapping("/all_drivers")
    public List<DriverDetails> allDrivers(){return driverDetailsService.allDrivers();}
}
