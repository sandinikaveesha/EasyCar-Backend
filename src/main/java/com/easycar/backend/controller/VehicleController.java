package com.easycar.backend.controller;

import com.easycar.backend.model.Vehicle;
import com.easycar.backend.service.VehicleService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add_vehicle")
    public String addOwner(@RequestBody ObjectNode node){return vehicleService.vehicleRegistration(node);}

    @GetMapping("/get_all_vehicles")
    public List<Vehicle> getAllVehicle(){return vehicleService.getAllVehicles();}

    @PostMapping("/status_update")
    public String statusUpdate(@RequestBody ObjectNode node){ return vehicleService.vehicleStatusUpdate(node);}

    @PostMapping("/get-by-agnecy")
    public List<Vehicle> getByAgency(@RequestBody ObjectNode data){
        return vehicleService.getByAgency(data.get("agency").asInt());
    }

    @PostMapping("/get")
    public Vehicle get(@RequestBody ObjectNode data){
        return vehicleService.get(data.get("vehicle").asInt());
    }
}
