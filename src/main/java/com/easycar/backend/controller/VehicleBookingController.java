package com.easycar.backend.controller;

import com.easycar.backend.model.VehicleBooking;
import com.easycar.backend.service.VehicleBookingService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle_booking")
@CrossOrigin
public class VehicleBookingController {
    @Autowired
    private VehicleBookingService vehicleBookingService;

    @PostMapping("/add_booking")
    public String addBooking(@RequestBody ObjectNode node){
        return vehicleBookingService.addBooking(node);
    }

    @GetMapping("/get_all_bookings")
    public List<VehicleBooking> getAllBookings(){return vehicleBookingService.getAllBookings();}

    @PostMapping("/status_update")
    public String statusUpdate(@RequestBody ObjectNode node){return vehicleBookingService.statusUpdate(node);}

    @PostMapping("/get-by-agency")
    public List<VehicleBooking> getByAgency(@RequestBody ObjectNode data){
        return vehicleBookingService.getByAgency(data.get("agency").asInt());
    }

    @PostMapping("/get")
    public VehicleBooking get(@RequestBody ObjectNode data){
        return vehicleBookingService.get(data.get("booking").asInt());
    }

    @PostMapping("/get-by-user")
    public List<VehicleBooking> getByUser(@RequestBody ObjectNode data){
        return vehicleBookingService.getByUser(data.get("user").asInt());
    }
}
