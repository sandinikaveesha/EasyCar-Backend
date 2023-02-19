package com.easycar.backend.controller;

import com.easycar.backend.model.Trip;
import com.easycar.backend.service.TripService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
@CrossOrigin
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/add_trip")
    public String addTrip(@RequestBody ObjectNode node){return tripService.tripDetails(node);}

    @GetMapping("/get_all_trips")
    public List<Trip> getAllTrips(){return tripService.allTripDetails();}

    @PostMapping("/status_update")
    public String statusUpdate(@RequestBody ObjectNode node){return tripService.statusUpdate(node);}
}
