package com.easycar.backend.service;

import com.easycar.backend.model.VehicleBooking;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface VehicleBookingService {
    public String addBooking(ObjectNode node);
    public List<VehicleBooking> getAllBookings();
    public String statusUpdate(ObjectNode node);

    public List<VehicleBooking> getByAgency(Integer agency);
    public VehicleBooking get(Integer booking);

    public List<VehicleBooking> getByUser(Integer user);
}
