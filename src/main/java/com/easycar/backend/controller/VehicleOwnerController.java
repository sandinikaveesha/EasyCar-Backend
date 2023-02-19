package com.easycar.backend.controller;

import com.easycar.backend.model.Agency;
import com.easycar.backend.model.VehicleOwner;
import com.easycar.backend.service.VehicleOwnerService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle_owner")
@CrossOrigin
public class VehicleOwnerController {
    @Autowired
    private VehicleOwnerService vehicleOwnerService;

    @PostMapping("/add_owner")
    public String addOwner(@RequestBody ObjectNode node){
        return vehicleOwnerService.vehicleOwnerRegistration(node);
    }

    @GetMapping("/get_all_owners")
    public List<VehicleOwner> getAllOwners(){return vehicleOwnerService.getAllOwners();}

    @PostMapping("/change_owner_status")
    public String changeOwnerStatus(@RequestBody ObjectNode node){return vehicleOwnerService.ownerStatusUpdate(node);}

    @PostMapping("/get-by-agency")
    public List<VehicleOwner> getByAgency(@RequestBody ObjectNode data){
        return vehicleOwnerService.getByAgency(data.get("agency").asInt());
    }

    @PostMapping("/get")
    public VehicleOwner get(@RequestBody ObjectNode data){
        return vehicleOwnerService.get(data.get("owner").asInt());
    }

    @PostMapping("/get-vehicles-count")
    public Integer getVehicleCount(@RequestBody ObjectNode data){
        return vehicleOwnerService.getVehicleCount(data.get("owner").asInt());
    }
}
