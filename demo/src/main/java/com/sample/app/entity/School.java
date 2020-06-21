package com.sample.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "School")
@NamedQuery(name="School.findAll", query="select s from School s")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "zipcode")
    private Integer zipCode;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
