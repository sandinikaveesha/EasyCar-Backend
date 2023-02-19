package com.easycar.backend.service;

import com.easycar.backend.model.Trip;
import com.easycar.backend.repository.TripRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripImpl implements TripService{
    @Autowired
    private TripRepository tripRepository;

    public String tripDetails(ObjectNode node){
        int response = tripRepository.validate(node.get("booking_ref").asInt());
        if(response > 0){
            return "This Vehicle is On a Trip";
        }else {
            Trip newTrip = new Trip();
            newTrip.setDispatchTime(node.get("dispatch_time").asText());
            newTrip.setArrivedTime(node.get("arrived_time").asText());
            newTrip.setStartKm(node.get("start_km").asDouble());
            newTrip.setEndKm(node.get("end_km").asDouble());
            newTrip.setStatus("On Trip");
            newTrip.setBookingRef(node.get("booking_ref").asInt());
            tripRepository.save(newTrip);
            return "Trip Details Added Successfully";
        }
    }

    public List<Trip> allTripDetails(){
        return tripRepository.findAll();
    }

    public String statusUpdate(ObjectNode node){
        Trip existingTrip = tripRepository.findById(node.get("id").asInt()).orElse(null);
        existingTrip.setStatus(node.get("status").asText());
        tripRepository.save(existingTrip);
        return "Trip Status Updated";
    }
}
