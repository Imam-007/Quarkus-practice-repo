package com.imam.orm.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String gender;

    @ManyToMany
    List<Bank> listOfBank=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Bank> getListOfBank() {
        return listOfBank;
    }

    public void setListOfBank(List<Bank> listOfBank) {
        this.listOfBank = listOfBank;
    }
}
