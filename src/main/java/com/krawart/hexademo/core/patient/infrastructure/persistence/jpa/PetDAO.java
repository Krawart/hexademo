package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.shared.infrastructure.persistence.HexaDemoJpaRepository;

interface PetDAO extends HexaDemoJpaRepository<Pet> {
}