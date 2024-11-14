package com.imam.orm.repositories;

import com.imam.orm.models.SimCard;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimCardRepository implements PanacheRepository<SimCard> {
}
