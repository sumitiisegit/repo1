package com.timesangle.app.entity;

import javax.persistence.*;

@Entity

@Table(name = "Construct")
public class Construct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="construct_id")
    private Long id;

    @Column(name="construct_name")
    private String constructName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConstructName() {
        return constructName;
    }

    public void setConstructName(String constructName) {
        this.constructName = constructName;
    }

    @Override
    public String toString() {
        return "Construct{" +
                "id=" + id +
                ", constructName='" + constructName + '\'' +
                '}';
    }
}
