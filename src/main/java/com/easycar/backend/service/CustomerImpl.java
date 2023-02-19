package com.easycar.backend.service;

import com.easycar.backend.model.Customer;
import com.easycar.backend.model.User;
import com.easycar.backend.repository.CustomerRepository;
import com.easycar.backend.repository.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public String customerRegistration(ObjectNode node){
        int response = customerRepository.validate(node.get("username").asText(), node.get("phone").asText());
        if(response >0){
            return "User Already Exist";
        }else {
            Customer newCustomer = new Customer();
            User newUser = new User();
            newCustomer.setFirstName(node.get("firstName").asText());
            newCustomer.setLastName(node.get("lastName").asText());
            newCustomer.setEmail(node.get("username").asText());
            newCustomer.setPhoneNo(node.get("phone").asText());
            newCustomer.setImg(node.get("img").asText());
            newUser.setUsername(node.get("username").asText());
            newUser.setPassword(node.get("password").asText());

            newUser.setRole("Customer");
            newUser.setStatus("Active");
            User savedUser = userService.register(newUser);
            newCustomer.setUserRef(savedUser.getId());
            customerRepository.save(newCustomer);
            return "User Registered Successfully";

        }
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer login(ObjectNode node){
        int response = customerRepository.validateUser(node.get("username").asText(),node.get("password").asText());
        if(response > 0){
            User user = userRepository.getUser(node.get("username").asText(),node.get("password").asText());
            return customerRepository.getCustomer(user.getId());
        }else {
            return new Customer();
        }
    }

    @Override
    public Customer get(Integer customer) {
        return customerRepository.findById(customer).orElse(null);
    }
}
