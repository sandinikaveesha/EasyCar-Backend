package com.easycar.backend.controller;

import com.easycar.backend.model.Customer;
import com.easycar.backend.service.CustomerService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String register(@RequestBody ObjectNode node){
        return customerService.customerRegistration(node);
    }
    @GetMapping("/getall")
    public List<Customer> getAll(){
        return customerService.getAllCustomers();
    }
    @PostMapping("/login")
    public Customer login(@RequestBody ObjectNode node){
        return customerService.login(node);
    }

    @PostMapping("/get")
    public Customer get(@RequestBody ObjectNode data){
        return customerService.get(data.get("customer").asInt());
    }
}
