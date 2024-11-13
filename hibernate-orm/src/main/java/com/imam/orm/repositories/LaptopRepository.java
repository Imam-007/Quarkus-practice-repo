package com.imam.orm.repositories;

import com.imam.orm.models.Laptop;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LaptopRepository implements PanacheRepository<Laptop> {
}
