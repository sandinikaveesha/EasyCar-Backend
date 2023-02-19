package com.easycar.backend.service;

import com.easycar.backend.model.VehicleOwner;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface VehicleOwnerService {
    public String vehicleOwnerRegistration(ObjectNode node);
    public List<VehicleOwner> getAllOwners();
    public String ownerStatusUpdate(ObjectNode node);
    public List<VehicleOwner> getByAgency(Integer agency);

    public VehicleOwner get(Integer owner);

    public Integer getVehicleCount(Integer owner);
}
