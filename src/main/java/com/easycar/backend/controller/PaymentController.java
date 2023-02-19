package com.easycar.backend.controller;

import com.easycar.backend.model.Agency;
import com.easycar.backend.model.Payment;
import com.easycar.backend.service.PaymentService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add_payment")
    public String addPayment(@RequestBody ObjectNode node){return paymentService.paymentDetails(node);}

    @GetMapping("/all_payments")
    public List<Payment> allPayments(){return paymentService.allPayments();}

    @PostMapping("/get")
    public Payment get(@RequestBody ObjectNode data){
        return paymentService.get(data.get("payment").asInt());
    }

    @PostMapping("/get-by-agency")
    public List<Payment> getByAgency(@RequestBody ObjectNode data){
        return paymentService.getAllByAgency(data.get("agency").asInt());
    }
}
