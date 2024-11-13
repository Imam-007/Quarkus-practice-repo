package com.imam.orm.controllers;

import com.imam.orm.models.Laptop;
import com.imam.orm.repositories.LaptopRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/laptop")
public class LaptopController {
    
    @Inject
    private LaptopRepository laptopRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLaptop(){
        List<Laptop> listOfLaptop =laptopRepository.listAll();
        return Response.ok(listOfLaptop).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLaptopById(@PathParam("id") Long id){
       Laptop laptop1= laptopRepository.findById(id);
       return Response.ok(laptop1).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLaptop(Laptop laptopItem){
        laptopRepository.persist(laptopItem);

        if (laptopRepository.isPersistent(laptopItem)){
            return Response.created(URI.create("/laptop/"+laptopItem.id)).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLaptop(@PathParam("id") Long id,Laptop updatedLaptop){
        Optional<Laptop> optionalLaptop=laptopRepository.findByIdOptional(id);
        if (optionalLaptop.isPresent()){
            Laptop oldlaptop=optionalLaptop.get();

            if(Objects.nonNull(updatedLaptop.getName())){
                oldlaptop.setName(updatedLaptop.getName());
            }
            if (Objects.nonNull(updatedLaptop.getBrand())){
                oldlaptop.setBrand(updatedLaptop.getBrand());
            }
            if (updatedLaptop.getRam() != 0){
                oldlaptop.setRam(updatedLaptop.getRam());
            }
            if (updatedLaptop.getStorage() != 0){
                oldlaptop.setStorage(updatedLaptop.getStorage());
            }

            laptopRepository.persist(oldlaptop);

            if (laptopRepository.isPersistent(oldlaptop)){
                return Response.created(URI.create("/laptop/"+id)).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteLaptop(@PathParam("id") Long id){
        boolean isDeleted=laptopRepository.deleteById(id);
        if(isDeleted){
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
