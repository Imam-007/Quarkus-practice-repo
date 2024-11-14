package com.imam.orm.repositories;

import com.imam.orm.models.Citizen;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CitizenRepository implements PanacheRepository<Citizen> {
}
