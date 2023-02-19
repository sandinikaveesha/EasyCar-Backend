package com.easycar.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "agency_user")
public class AgencyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String status;
    private String role;
    private int userRef;
    private int agencyRef;

    public int getAgencyRef() {
        return agencyRef;
    }

    public void setAgencyRef(int agencyRef) {
        this.agencyRef = agencyRef;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getUserRef() {
        return userRef;
    }

    public void setUserRef(int userRef) {
        this.userRef = userRef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}