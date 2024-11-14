package com.imam.orm.repositories;

import com.imam.orm.models.AccountHolder;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountHolderRepository implements PanacheRepository<AccountHolder> {
}
