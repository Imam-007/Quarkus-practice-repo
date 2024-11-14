package com.imam.orm.controllers;

import com.imam.orm.models.AccountHolder;
import com.imam.orm.models.Bank;
import com.imam.orm.repositories.AccountHolderRepository;
import com.imam.orm.repositories.BankRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
public class AccountHolderController {

    @Inject
    private BankRepository bankRepository;

    @Inject
    private AccountHolderRepository accountHolderRepository;

    @POST
    @Path("/save-bank")
    @Transactional
    public Response addBank(){

        String[] bankNames={"Axis","canara bankNames","SBI","PNB","RBL"};

        for(String bankName:bankNames){
            Bank bank=new Bank();
            bank.setBankName(bankName);
            bank.setBranch("Gachibowli, Hyderabad");
            bank.setIfscCode("66631"+bankName);
            bankRepository.persist(bank);
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/save-member")
    @Transactional
    public Response addMember(){
        String[] bankNames={"Axis","SBI","PNB","RBL"};

        Bank AxisBank=bankRepository.find("bankName",bankNames[0]).firstResult();
        Bank SBIBank=bankRepository.find("bankName",bankNames[1]).firstResult();
        Bank PNBBank=bankRepository.find("bankName",bankNames[2]).firstResult();
        Bank RBLBank=bankRepository.find("bankName",bankNames[3]).firstResult();

        System.out.println(">>>>>>>>>>>>"+AxisBank);

        AccountHolder member1=new AccountHolder();
        member1.setName("Harsh");
        member1.setGender("M");
        member1.setListOfBank(List.of(AxisBank,RBLBank,PNBBank));
        accountHolderRepository.persist(member1);


        AccountHolder member2=new AccountHolder();
        member2.setName("Asif");
        member2.setGender("M");
        member2.setListOfBank(List.of(PNBBank,AxisBank));
        accountHolderRepository.persist(member2);

        AccountHolder member3=new AccountHolder();
        member3.setName("Anuskha");
        member3.setGender("F");
        member3.setListOfBank(List.of(AxisBank));
        accountHolderRepository.persist(member3);

        return Response.status(Response.Status.OK).build();
    }
}
