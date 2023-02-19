package com.easycar.backend.service;

import com.easycar.backend.model.Vehicle;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface VehicleService {
    public String vehicleRegistration(ObjectNode node);
    public List<Vehicle> getAllVehicles();
    public String vehicleStatusUpdate(ObjectNode node);

    public List<Vehicle> getByAgency(Integer agency);
    public Vehicle get(Integer vehicle);
}
