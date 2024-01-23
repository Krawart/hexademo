package com.krawart.hexademo.core.patient.domain;

import com.krawart.hexademo.shared.domain.CRUDDomainRepository;

import java.util.UUID;

public interface PetRepository extends CRUDDomainRepository<Pet> {
    boolean existsById(UUID id);
}
