package com.imam.restapi.controllers;

import com.imam.restapi.models.Mobile;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/mobile")
public class MobileController {

    List<Mobile> mobileList=new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMobile(){
        return Response.ok(mobileList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMobileById(@PathParam("id") int id){
        Optional<Mobile> getMobile=mobileList.stream().filter(mobile -> mobile.getId()==id).findFirst();
        if (getMobile.isPresent()){
            return Response.ok(getMobile.get()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMobile(Mobile mobile){
        mobileList.add(mobile);
        return Response.ok(mobileList).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMobile(@PathParam("id") int id,Mobile updatedMobile){

        mobileList=mobileList.stream().map((mobile)->{
            if(mobile.getId()==id){
                return updatedMobile;
            }else{
                return mobile;
            }
        }).collect(Collectors.toList());

        return Response.ok(mobileList).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMobile(@PathParam("id") int id){

       Optional<Mobile> mobileInfo= mobileList.stream().filter(mobile -> mobile.getId()==id).findFirst();
       if(mobileInfo.isPresent()){
           mobileList.remove(mobileInfo.get());
           System.out.println(mobileInfo.get());
           return Response.ok(mobileList).build();
       }else{
           return Response.status(Response.Status.BAD_REQUEST).build();
       }
    }
}
