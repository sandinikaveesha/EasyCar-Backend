package com.easycar.backend.controller;

import com.easycar.backend.model.Agency;
import com.easycar.backend.service.AgencyService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
@CrossOrigin
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    @PostMapping("/register")
    public Agency register(@RequestBody ObjectNode agency){
        return agencyService.saveAgency(agency);
    }
    @GetMapping("/getall")
    public List<Agency> getAll(){return agencyService.getAllAgencies();}

    @PostMapping("/change_status")
    public String changeStatus(@RequestBody ObjectNode node){
        return agencyService.statusUpdate(node);
    }

    @PostMapping("/get")
    public Agency get(@RequestBody ObjectNode data){
        return agencyService.getAgency(data.get("id").asInt());
    }
}
