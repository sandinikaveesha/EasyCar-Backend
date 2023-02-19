package com.easycar.backend.service;

import com.easycar.backend.model.Agency;
import com.easycar.backend.repository.AgencyRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyImpl implements AgencyService{
    @Autowired
    private AgencyRepository agencyRepository;

    public String agencyRegister(ObjectNode node){
        Agency newAgency = new Agency();
        newAgency.setBusinessName(node.get("business_name").asText());
        newAgency.setBRno(node.get("br_no").asText());
        newAgency.setEmail(node.get("business_email").asText());
        newAgency.setPhoneNo(node.get("business_phone").asText());
        newAgency.setAddress(node.get("address").asText());
        newAgency.setLon(node.get("lon").asDouble());
        newAgency.setLat(node.get("lat").asDouble());
        newAgency.setStatus("Pending");
        int response = agencyRepository.validate(newAgency.getBRno(), newAgency.getEmail(), newAgency.getPhoneNo());
        if(response > 0){
            return "Agency Already Exist";
        }else {
            agencyRepository.save(newAgency);
            return "Agency details has send to the Admin, Admin will send you an email";
        }
    }
    public List<Agency> getAllAgencies(){return agencyRepository.findAll();}

    public String statusUpdate(ObjectNode node){
        Agency existAgency = agencyRepository.findById(node.get("id").asInt()).orElse(null);
        existAgency.setStatus(node.get("status").asText());
        agencyRepository.save(existAgency);
        return "Agency Status Updated";
    }

    @Override
    public Agency getAgency(Integer id) {
        return agencyRepository.getAgency(id);
    }

    @Override
    public Agency saveAgency(ObjectNode agency) {
        int response = agencyRepository.validate(agency.get("BRno").asText(), agency.get("email").asText(),agency.get("phoneNo").asText());
        if(response > 0){
            return new Agency();
        }else {
            Agency newAgency = new Agency();
            newAgency.setBRno(agency.get("BRno").asText());
            newAgency.setAddress(agency.get("address").asText());
            newAgency.setBusinessName(agency.get("businessName").asText());
            newAgency.setEmail(agency.get("email").asText());
            newAgency.setLat(agency.get("lat").asDouble());
            newAgency.setLon(agency.get("lon").asDouble());
            newAgency.setStatus(agency.get("status").asText());
            newAgency.setPhoneNo(agency.get("phoneNo").asText());
            return agencyRepository.save(newAgency);
        }
    }
}
