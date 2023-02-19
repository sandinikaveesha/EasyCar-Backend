package com.easycar.backend.repository;

import com.easycar.backend.model.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Integer> {
    @Query(value = "SELECT COUNT(id) FROM vehicle_owner WHERE nic=?1 OR phone_no=?2",nativeQuery = true)
    Integer validate(String nic, String phone);

    @Query(value = "SELECT * FROM vehicle_owner WHERE agency_ref=?1", nativeQuery = true)
    List<VehicleOwner> getByAgency(Integer agency);

    @Query(value = "SELECT COUNT(id) FROM vehicle WHERE vehicle_owner_ref=?1", nativeQuery = true)
    Integer vehicleCountForOwner(Integer owner);

}