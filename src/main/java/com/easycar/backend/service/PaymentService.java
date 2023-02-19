package com.easycar.backend.service;

import com.easycar.backend.model.Payment;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface PaymentService {
    public String paymentDetails(ObjectNode node);
    public List<Payment> allPayments();
    public Payment get(Integer payment);

    public List<Payment> getAllByAgency(Integer agency);
}
