package com.hr.project.entity;

import javax.persistence.*;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="car_id")
    private long id;

    @Column(name="model")
    private String model;

    @Column(name="color")
    private String color;

    @Column(name="registration_number")
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name="person_id",nullable=false)
    Person owner;

    public Car() {
        super();
    }

    public Car(long id, String model, String color, String registrationNumber, Person owner) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setPerson(Person owner) {
        this.owner = owner;
    }
}
