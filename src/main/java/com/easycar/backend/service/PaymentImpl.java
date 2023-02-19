package com.easycar.backend.service;

import com.easycar.backend.model.Payment;
import com.easycar.backend.repository.PaymentRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    public String paymentDetails(ObjectNode node){
        Payment newPayment = new Payment();
        newPayment.setAmount(node.get("amount").asDouble());
        newPayment.setTimeStamp(node.get("time_stamp").asText());
        newPayment.setStatus(node.get("status").asText());
        newPayment.setVehicleRef(node.get("vehicle_ref").asInt());
        newPayment.setBookingRef(node.get("booking_ref").asInt());
        newPayment.setCustomerRef(node.get("customer_ref").asInt());
        newPayment.setAgency(node.get("agency").asInt());
        paymentRepository.save(newPayment);
        return "Payment Added Successfully";
    }

    public List<Payment> allPayments(){return paymentRepository.findAll();}

    @Override
    public Payment get(Integer payment) {
        return paymentRepository.findById(payment).orElse(null);
    }

    @Override
    public List<Payment> getAllByAgency(Integer agency) {
        return paymentRepository.getAllByAgency(agency);
    }

}
