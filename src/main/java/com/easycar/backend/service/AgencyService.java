package com.easycar.backend.service;

import com.easycar.backend.model.Agency;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface AgencyService {
    public String agencyRegister(ObjectNode node);
    public List<Agency> getAllAgencies();
    public String statusUpdate(ObjectNode node);
    public Agency getAgency(Integer id);

    public Agency saveAgency(ObjectNode agency);

}
