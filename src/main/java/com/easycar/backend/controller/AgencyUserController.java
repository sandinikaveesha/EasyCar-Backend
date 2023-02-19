package com.easycar.backend.controller;

import com.easycar.backend.model.AgencyUser;
import com.easycar.backend.service.AgencyUserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency_user")
@CrossOrigin
public class AgencyUserController {
    @Autowired
    private AgencyUserService agencyUserService;

    @PostMapping("/register")
    public AgencyUser regisaer(@RequestBody AgencyUser agencyUser){
        return agencyUserService.save(agencyUser);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody ObjectNode node){
        return agencyUserService.login(node);
    }

    @GetMapping("/get_all_users")
    public List<AgencyUser> getAllUsers(){
        return agencyUserService.getAllAgencyUsers();
    }

    @PostMapping("/change_user_status")
    public String changeUserStatus(@RequestBody ObjectNode node){
        return agencyUserService.userStatusUpdate(node);
    }

    @PostMapping("/current_user")
    public AgencyUser current_user(@RequestBody ObjectNode node){
        return agencyUserService.get(node);
    }
}
