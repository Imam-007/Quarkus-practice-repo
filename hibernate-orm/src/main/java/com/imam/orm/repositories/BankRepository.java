package com.imam.orm.repositories;

import com.imam.orm.models.Bank;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankRepository implements PanacheRepository<Bank> {
}
