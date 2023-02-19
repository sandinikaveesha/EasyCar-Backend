package com.easycar.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private double amount;
    private String timeStamp;
    private String status;
    private int vehicleRef;
    private int bookingRef;
    private int customerRef;
    private int agency;

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getVehicleRef() {
        return vehicleRef;
    }

    public void setVehicleRef(int vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    public int getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(int bookingRef) {
        this.bookingRef = bookingRef;
    }

    public int getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(int customerRef) {
        this.customerRef = customerRef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}