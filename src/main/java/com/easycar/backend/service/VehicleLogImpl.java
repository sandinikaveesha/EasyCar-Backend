package com.easycar.backend.service;

import com.easycar.backend.model.Vehicle;
import com.easycar.backend.model.VehicleBooking;
import com.easycar.backend.model.VehicleLog;
import com.easycar.backend.repository.VehicleBookingRepository;
import com.easycar.backend.repository.VehicleLogRepository;
import com.easycar.backend.repository.VehicleRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleLogImpl implements VehicleLogService{
    @Autowired
    private VehicleLogRepository vehicleLogRepository;
    @Autowired
    private VehicleBookingRepository vehicleBookingRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public String dispatchLog(VehicleLog log) {
        if(vehicleLogRepository.validate(log.getBooking())>0){
            return "false";
        }
        else{

            VehicleBooking booking = vehicleBookingRepository.findById(log.getBooking()).orElse(null);
            booking.setStatus("Processing");
            vehicleBookingRepository.save(booking);
            Vehicle vehicle = vehicleRepository.findById(booking.getVehicleRef()).orElse(null);
            vehicle.setStatus("On Trip");
            vehicleRepository.save(vehicle);
            vehicleLogRepository.save(log);
            return "true";
        }
    }

    @Override
    public VehicleLog getLog(Integer booking) {
        return vehicleLogRepository.getLog(booking);
    }

    @Override
    public String vehicleIn(VehicleLog log) {
        VehicleBooking booking = vehicleBookingRepository.findById(log.getBooking()).orElse(null);
        booking.setStatus("Completed");
        vehicleBookingRepository.save(booking);
        Vehicle vehicle = vehicleRepository.findById(booking.getVehicleRef()).orElse(null);
        vehicle.setStatus("Active");
        vehicleRepository.save(vehicle);
        vehicleLogRepository.save(log);
        return "true";
    }
}
