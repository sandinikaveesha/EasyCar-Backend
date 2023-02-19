package com.easycar.backend.service;

import com.easycar.backend.model.Agency;
import com.easycar.backend.model.AgencyUser;
import com.easycar.backend.model.User;
import com.easycar.backend.repository.AgencyUserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyUserImpl implements AgencyUserService{
    @Autowired
    private AgencyUserRepository agencyUserRepository;
    @Autowired
    private UserService userService;


    public String agencyUserRegistration(ObjectNode node){
        int response = agencyUserRepository.validate(node.get("username").asText(), node.get("password").asText());
        if(response > 0){
            return "User Already Exist";
        }else {
            AgencyUser newAgencyUser = new AgencyUser();
            User user = new User();
            newAgencyUser.setFirstName(node.get("firstName").asText());
            newAgencyUser.setLastName(node.get("lastName").asText());
            newAgencyUser.setEmail(node.get("username").asText());
            newAgencyUser.setPhoneNo(node.get("phone_no").asText());
            newAgencyUser.setStatus(node.get("status").asText());
            newAgencyUser.setRole(node.get("role").asText());
            newAgencyUser.setAgencyRef(node.get("agency_ref").asInt());
            user.setUsername(node.get("username").asText());
            user.setPassword(node.get("password").asText());
            user.setRole(node.get("role").asText());
            int responseUser = agencyUserRepository.validateUser(user.getUsername(),user.getPassword());
            if(responseUser > 0){
                return "Username Already Exist";
            }else {
                User savedUser = userService.register(user);
                newAgencyUser.setUserRef(savedUser.getId());
                agencyUserRepository.save(newAgencyUser);
                return "User Successfully Saved";
            }
        }
    }

    public List<AgencyUser> getAllAgencyUsers(){return agencyUserRepository.findAll();}

    public boolean login(ObjectNode node){
        int response = agencyUserRepository.validateUser(node.get("username").asText(), node.get("password").asText());
        if(response > 0 ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public AgencyUser get(ObjectNode node) {
        User user = userService.get(node);
        return agencyUserRepository.getUserByLogin(user.getId());
    }

    @Override
    public AgencyUser save(AgencyUser agencyUser) {
        int responseUser = agencyUserRepository.validate(agencyUser.getEmail(),agencyUser.getPhoneNo());
        if(responseUser > 0){
            return new AgencyUser();
        }else {

            return agencyUserRepository.save(agencyUser);

        }
    }

    public String userStatusUpdate(ObjectNode node){
        AgencyUser existingUser = agencyUserRepository.findById(node.get("id").asInt()).orElse(null);
        existingUser.setStatus(node.get("status").asText());
        agencyUserRepository.save(existingUser);
        return "Agency User Status Update";
    }


}
