package com.easycar.backend.service;

import com.easycar.backend.model.DriverDetails;
import com.easycar.backend.model.Payment;
import com.easycar.backend.model.Vehicle;
import com.easycar.backend.model.VehicleBooking;
import com.easycar.backend.repository.DriverDetailsRepository;
import com.easycar.backend.repository.PaymentRepository;
import com.easycar.backend.repository.VehicleBookingRepository;
import com.easycar.backend.repository.VehicleRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBookingImpl implements VehicleBookingService{
    @Autowired
    private VehicleBookingRepository vehicleBookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private DriverDetailsRepository driverDetailsRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public String addBooking(ObjectNode node){
        int response = vehicleBookingRepository.validate(node.get("vehicle_ref").asInt());
        if(response > 0){
            return "Vehicle is Already Booked";
        }else {
            Payment payment = new Payment();
            payment.setStatus("Paid");
            payment.setCustomerRef(node.get("user").asInt());
            payment.setVehicleRef(node.get("vehicle_ref").asInt());
            payment.setAmount(node.get("amount").asDouble());
            payment.setTimeStamp(node.get("now").asText());
            payment.setAgency(node.get("agency_ref").asInt());

            Payment savedPayment = paymentRepository.save(payment);

            DriverDetails driverDetails = new DriverDetails();

            driverDetails.setLicenceExp(node.get("exp").asText());
            driverDetails.setLicenceNo(node.get("license").asText());
            driverDetails.setFirstName(node.get("firstName").asText());
            driverDetails.setLastName(node.get("lastName").asText());
            driverDetails.setIdentificationType(node.get("type").asText());
            driverDetails.setIdentificationNo(node.get("nic").asText());

            DriverDetails savedDriver = driverDetailsRepository.save(driverDetails);


            VehicleBooking newBooking = new VehicleBooking();
            newBooking.setPaymentRef(savedPayment.getId());
            newBooking.setDriverRef(savedDriver.getId());
            newBooking.setStartDate(node.get("start_date").asText());
            newBooking.setEndDate(node.get("end_date").asText());
            newBooking.setStatus("Pending");
            newBooking.setUserRef(node.get("user").asInt());
            newBooking.setAgencyRef(node.get("agency_ref").asInt());
            newBooking.setVehicleRef(node.get("vehicle_ref").asInt());

            vehicleBookingRepository.save(newBooking);

            Vehicle vehicle = vehicleRepository.findById(node.get("vehicle_ref").asInt()).orElse(null);
            vehicle.setStatus("Deactivate");
            vehicleRepository.save(vehicle);

            return "Vehicle Booked Successfully";
        }
    }
    public List<VehicleBooking> getAllBookings(){return vehicleBookingRepository.findAll();}

    public String statusUpdate(ObjectNode node){
        VehicleBooking existingBooking = vehicleBookingRepository.findById(node.get("id").asInt()).orElse(null);
        existingBooking.setStatus(node.get("status").asText());
        vehicleBookingRepository.save(existingBooking);
        return "Vehicle Booking Status Updated";
    }

    @Override
    public List<VehicleBooking> getByAgency(Integer agency) {
        return vehicleBookingRepository.getByAgency(agency);
    }

    @Override
    public VehicleBooking get(Integer booking) {
        return vehicleBookingRepository.findById(booking).orElse(null);
    }

    @Override
    public List<VehicleBooking> getByUser(Integer user) {
        return vehicleBookingRepository.getByUser(user);
    }
}
