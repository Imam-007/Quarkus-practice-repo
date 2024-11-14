package com.imam.orm.models;

import jakarta.persistence.*;

@Entity
public class SimCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long simNumber;

    String simPovider;

    boolean isActive;

    @ManyToOne
    Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(Long simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimPovider() {
        return simPovider;
    }

    public void setSimPovider(String simPovider) {
        this.simPovider = simPovider;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
