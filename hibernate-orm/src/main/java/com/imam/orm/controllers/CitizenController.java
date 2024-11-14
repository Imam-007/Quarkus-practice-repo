package com.imam.orm.controllers;

import com.imam.orm.models.Aadhar;
import com.imam.orm.models.Citizen;
import com.imam.orm.repositories.AadharRepository;
import com.imam.orm.repositories.CitizenRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class CitizenController {

    @Inject
    private CitizenRepository citizenRepository;

    @Inject
    private AadharRepository aadharRepository;

    @POST
    @Path("save")
    @Transactional
    public Response addCitizen(){

        Citizen citizen=new Citizen();
        citizen.setGender("M");
        citizen.setName("Harsh");


        Aadhar aadhar=new Aadhar();
        aadhar.setAadharNumber(95467l);
        aadhar.setCompanyName("UUDI");
        aadhar.setCitizen(citizen);

        citizen.setAadhar(aadhar);
        citizenRepository.persist(citizen);

//        aadharRepository.persist(aadhar);

//        Citizen citizen=citizenRepository.findById(1l);

        return Response.ok(citizen).build();
    }
}
