package com.easycar.backend.service;

import com.easycar.backend.model.DriverDetails;
import com.easycar.backend.repository.DriverDetailsRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverDetailsImpl implements DriverDetailsService{
    @Autowired
    private DriverDetailsRepository driverDetailsRepository;

    public String driverDetails(ObjectNode node) {
        int response = driverDetailsRepository.validate(node.get("identification_no").asText(),node.get("licence_no").asText());
        if(response > 0){
            return "Driver Already Added";
        }else {
            DriverDetails newDriver = new DriverDetails();
            newDriver.setIdentificationNo(node.get("identification_no").asText());
            newDriver.setIdentificationType(node.get("identification_type").asText());
            newDriver.setFirstName(node.get("firstName").asText());
            newDriver.setLastName(node.get("lastName").asText());
            newDriver.setLicenceNo(node.get("licence_no").asText());
            newDriver.setLicenceExp(node.get("licence_exp").asText());
            driverDetailsRepository.save(newDriver);
            return "Driver Details Added Successfully";
        }
    }
     public List<DriverDetails> allDrivers(){
        return driverDetailsRepository.findAll();
     }
}
