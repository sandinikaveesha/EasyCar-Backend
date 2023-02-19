package com.easycar.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String comment;
    private double rating;
    private String timeStamp;
    private int vehicleRef;
    private int customerRef;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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