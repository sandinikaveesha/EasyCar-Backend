package com.easycar.backend.service;

import com.easycar.backend.model.DriverDetails;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface DriverDetailsService {
    public String driverDetails(ObjectNode node);
    public List<DriverDetails> allDrivers();

}
