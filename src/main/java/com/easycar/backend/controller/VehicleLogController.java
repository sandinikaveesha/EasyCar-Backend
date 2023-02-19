package com.easycar.backend.controller;

import com.easycar.backend.model.VehicleLog;
import com.easycar.backend.service.VehicleLogService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
@CrossOrigin
public class VehicleLogController {
    @Autowired
    private VehicleLogService vehicleLogService;

    @PostMapping("/dispatch")
    public String dispatch(@RequestBody VehicleLog vehicleLog){
        return vehicleLogService.dispatchLog(vehicleLog);
    }

    @PostMapping("/get")
    public VehicleLog get(@RequestBody ObjectNode data){
        return vehicleLogService.getLog(data.get("booking").asInt());
    }

    @PostMapping("/vehicle-in")
    public String vehicleIn(@RequestBody VehicleLog vehicleLog){
        return vehicleLogService.vehicleIn(vehicleLog);
    }
}
