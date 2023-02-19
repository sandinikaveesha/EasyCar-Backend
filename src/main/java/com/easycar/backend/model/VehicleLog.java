package com.easycar.backend.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "vehicle_log")
public class VehicleLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer booking;
    private String outTime;
    private Integer outMeterReading;
    private String outRemark;
    private String inTime;
    private Integer inMeterReading;
    private String inRemark;

    public Integer getBooking() {
        return booking;
    }

    public void setBooking(Integer booking) {
        this.booking = booking;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getOutMeterReading() {
        return outMeterReading;
    }

    public void setOutMeterReading(Integer outMeterReading) {
        this.outMeterReading = outMeterReading;
    }

    public String getOutRemark() {
        return outRemark;
    }

    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public Integer getInMeterReading() {
        return inMeterReading;
    }

    public void setInMeterReading(Integer inMeterReading) {
        this.inMeterReading = inMeterReading;
    }

    public String getInRemark() {
        return inRemark;
    }

    public void setInRemark(String inRemark) {
        this.inRemark = inRemark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}