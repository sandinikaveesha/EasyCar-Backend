package com.easycar.backend.service;

import com.easycar.backend.model.Trip;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface TripService {
    public String tripDetails(ObjectNode node);
    public List<Trip> allTripDetails();
    public String statusUpdate(ObjectNode node);
}
