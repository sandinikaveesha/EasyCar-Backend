package com.easycar.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_booking")
public class VehicleBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String startDate;
    private String endDate;
    private String status;
    private int paymentRef;
    private int userRef;
    private int vehicleRef;
    private int agencyRef;
    private int driverRef;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(int paymentRef) {
        this.paymentRef = paymentRef;
    }

    public int getVehicleRef() {
        return vehicleRef;
    }

    public void setVehicleRef(int vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    public int getAgencyRef() {
        return agencyRef;
    }

    public void setAgencyRef(int agencyRef) {
        this.agencyRef = agencyRef;
    }

    public int getDriverRef() {
        return driverRef;
    }

    public int getUserRef() {
        return userRef;
    }

    public void setUserRef(int userRef) {
        this.userRef = userRef;
    }

    public void setDriverRef(int driverRef) {
        this.driverRef = driverRef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}