package com.easycar.backend.service;

import com.easycar.backend.model.Customer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface CustomerService {
    public String customerRegistration(ObjectNode node);
    public List<Customer> getAllCustomers();
    public Customer login(ObjectNode node);
    public Customer get(Integer customer);
}
