package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.core.patient.domain.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class OwnerJPARepository implements OwnerRepository {

  private final OwnerDAO ownerDAO;

  @Override
  public Owner add(Owner entity) {
    return ownerDAO.save(entity);
  }

  @Override
  public Owner update(Owner entity) {
    return ownerDAO.save(entity);
  }

  @Override
  public Optional<Owner> findById(UUID id) {
    return ownerDAO.findById(id);
  }

  @Override
  public Owner getById(UUID id) {
    return ownerDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found in database"));
  }

  @Override
  public void removeById(UUID id) {
    ownerDAO.deleteById(id);
  }
}
