package com.easycar.backend.service;

import com.easycar.backend.model.VehicleLog;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface VehicleLogService {
    public String dispatchLog(VehicleLog log);
    public VehicleLog getLog(Integer booking);
    public String vehicleIn(VehicleLog log);
}
