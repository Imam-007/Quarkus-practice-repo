package com.imam.orm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String gender;

    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<SimCard> simCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SimCard> getSimCard() {
        return simCard;
    }

    public void setSimCard(List<SimCard> simCard) {
        this.simCard = simCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
