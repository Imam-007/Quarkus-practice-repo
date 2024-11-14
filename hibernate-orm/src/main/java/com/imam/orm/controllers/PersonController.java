package com.imam.orm.controllers;

import com.imam.orm.models.Person;
import com.imam.orm.models.SimCard;
import com.imam.orm.repositories.PersonRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
@Transactional
public class PersonController {

    @Inject
    private PersonRepository personRepository;

    @POST
    @Path("/save")
    public Response savePerson(){
        Person person=new Person();

        person.setName("harsh");
        person.setGender("M");

        SimCard sim1=new SimCard();
        sim1.setSimNumber(840990l);
        sim1.setSimPovider("Jio");
        sim1.setActive(true);
        sim1.setPerson(person);

        SimCard sim2=new SimCard();
        sim2.setSimNumber(8434071l);
        sim2.setSimPovider("Airtel");
        sim2.setActive(true);
        sim2.setPerson(person);

        SimCard sim3=new SimCard();
        sim3.setSimNumber(805134l);
        sim3.setSimPovider("Idea");
        sim3.setActive(true);
        sim3.setPerson(person);

        person.setSimCard(List.of(sim1,sim2,sim3));

        personRepository.persist(person);

        if(personRepository.isPersistent(person)){
            return Response.ok("Data save successfully").build();
        }else{
            return Response.ok("Not saved").build();
        }
    }
}
