package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.core.patient.domain.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class PetJPARepository implements PetRepository {

    private final PetDAO petDAO;

    @Override
    public Pet add(Pet entity) {
        return petDAO.save(PetEntity.of(entity)).toDomain();
    }

    @Override
    public Pet update(Pet entity) {
        return petDAO.save(PetEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Pet> findById(UUID id) {
        return petDAO.findById(id).map(PetEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        petDAO.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return petDAO.existsById(id);
    }
}
