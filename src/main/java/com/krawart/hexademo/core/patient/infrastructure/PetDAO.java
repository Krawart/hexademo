package com.krawart.hexademo.core.patient.infrastructure;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.shared.infrastructure.HexaDemoJpaRepository;

interface PetDAO extends HexaDemoJpaRepository<Pet> {
}
