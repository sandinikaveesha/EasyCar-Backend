package com.easycar.backend.service;

import com.easycar.backend.model.VehicleOwner;
import com.easycar.backend.repository.VehicleOwnerRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleOwnerImpl implements VehicleOwnerService{
    @Autowired
    private VehicleOwnerRepository vehicleOwnerRepository;

    public String vehicleOwnerRegistration(ObjectNode node){
        int response = vehicleOwnerRepository.validate(node.get("nic").asText(), node.get("phone_no").asText());
        if(response > 0){
            return "User Already Exist";
        } else {
            VehicleOwner newOwner = new VehicleOwner();
            newOwner.setFirstName(node.get("firstName").asText());
            newOwner.setLastName(node.get("lastName").asText());
            newOwner.setNic(node.get("nic").asText());
            newOwner.setPhoneNo(node.get("phone_no").asText());
            newOwner.setStatus("Active");
            newOwner.setEmail(node.get("email").asText());
            newOwner.setAgencyRef(node.get("agency").asInt());
            vehicleOwnerRepository.save(newOwner);
            return "Vehicle Owner added Successfully";

        }
    }

    public List<VehicleOwner> getAllOwners(){
        return vehicleOwnerRepository.findAll();
    }

    public String ownerStatusUpdate(ObjectNode node){
        VehicleOwner existingOwner = vehicleOwnerRepository.findById(node.get("id").asInt()).orElse(null);
        existingOwner.setStatus(node.get("status").asText());
        vehicleOwnerRepository.save(existingOwner);
        return "Vehicle Owner Status Updated";
    }

    @Override
    public List<VehicleOwner> getByAgency(Integer agency) {
        return vehicleOwnerRepository.getByAgency(agency);
    }

    @Override
    public VehicleOwner get(Integer owner) {
        return vehicleOwnerRepository.findById(owner).orElse(null);
    }

    @Override
    public Integer getVehicleCount(Integer owner) {
        return vehicleOwnerRepository.vehicleCountForOwner(owner);
    }
}
