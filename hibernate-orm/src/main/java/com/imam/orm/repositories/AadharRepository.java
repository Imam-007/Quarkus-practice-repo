package com.imam.orm.repositories;

import com.imam.orm.models.Aadhar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AadharRepository implements PanacheRepository<Aadhar> {
}
