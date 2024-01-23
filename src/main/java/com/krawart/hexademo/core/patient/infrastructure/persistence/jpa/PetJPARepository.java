package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.core.patient.domain.PetRepository;
import jakarta.persistence.EntityNotFoundException;
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
    return petDAO.save(entity);
  }

  @Override
  public Pet update(Pet entity) {
    return petDAO.save(entity);
  }

  @Override
  public Optional<Pet> findById(UUID id) {
    return petDAO.findById(id);
  }

  @Override
  public Pet getById(UUID id) {
    return petDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet not found in database"));
  }

  @Override
  public void removeById(UUID id) {
    petDAO.deleteById(id);
  }
}
