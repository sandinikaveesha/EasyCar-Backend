package com.easycar.backend.service;


import com.easycar.backend.model.Image;
import com.easycar.backend.model.Vehicle;
import com.easycar.backend.repository.ImageRepository;
import com.easycar.backend.repository.VehicleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ImageRepository imageRepository;

    public String vehicleRegistration(ObjectNode node){
        int response = vehicleRepository.validate(node.get("registration_no").asText());
        if(response > 0){
            return "Vehicle Already Exist";
        }else {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setRegistrationNo(node.get("registration_no").asText());
            newVehicle.setCategory(node.get("category").asInt());
            newVehicle.setFuelType(node.get("fuel_type").asText());
            newVehicle.setEngineCapacity(node.get("engine").asText());
            newVehicle.setBrand(node.get("brand").asInt());
            newVehicle.setColor(node.get("color").asText());
            newVehicle.setPricePerDay(node.get("rate").asDouble());
            newVehicle.setExtraCharge(node.get("extra").asDouble());
            newVehicle.setStatus("Active");
            newVehicle.setModel(node.get("model").asText());
            newVehicle.setModelYear(node.get("model_year").asText());
            newVehicle.setAgencyRef(node.get("agency").asInt());
            newVehicle.setVehicleOwnerRef(node.get("owner").asInt());
            newVehicle.setDescription(node.get("description").asText());
            newVehicle.setGear(node.get("gearType").asText());
            Vehicle savedVehicle = vehicleRepository.save(newVehicle);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode listRoot = node.get("images");
            List<ObjectNode> images = mapper.convertValue(listRoot, new TypeReference<List<ObjectNode>>() {
            });

            for(int i = 0; i < images.size(); i++){
                Image img = new Image();
                img.setVehicle(savedVehicle.getId());
                img.setImg(images.get(i).get("img").asText());

                imageRepository.save(img);

            }

            return "Vehicle Saved Successfully";
        }
    }

    public List<Vehicle> getAllVehicles(){return vehicleRepository.findAll();}

    public String vehicleStatusUpdate(ObjectNode node){
        Vehicle existingVehicle = vehicleRepository.findById(node.get("id").asInt()).orElse(null);
        existingVehicle.setStatus(node.get("status").asText());
        vehicleRepository.save(existingVehicle);
        return "Vehicle Status Update";
    }

    @Override
    public List<Vehicle> getByAgency(Integer agency) {
        return vehicleRepository.getByAgency(agency);
    }

    @Override
    public Vehicle get(Integer vehicle) {
        return vehicleRepository.findById(vehicle).orElse(null);
    }
}
