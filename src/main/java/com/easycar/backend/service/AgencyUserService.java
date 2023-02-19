package com.easycar.backend.service;

import com.easycar.backend.model.AgencyUser;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface AgencyUserService {

    public String agencyUserRegistration(ObjectNode node);
    public List<AgencyUser> getAllAgencyUsers();
    public String userStatusUpdate(ObjectNode node);
    public boolean login(ObjectNode node);
    public AgencyUser get(ObjectNode node);

    public AgencyUser save(AgencyUser agencyUser);
}
