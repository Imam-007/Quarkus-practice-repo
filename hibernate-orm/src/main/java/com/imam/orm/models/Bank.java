package com.imam.orm.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String bankName;

    String branch;

    String ifscCode;

    @ManyToMany(mappedBy = "listOfBank")
    List<AccountHolder> listOfAccountHolder=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public List<AccountHolder> getListOfAccountHolder() {
        return listOfAccountHolder;
    }

    public void setListOfAccountHolder(List<AccountHolder> listOfAccountHolder) {
        this.listOfAccountHolder = listOfAccountHolder;
    }
}
