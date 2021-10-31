package com.krawart.hexademo.core.staff.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.core.staff.domain.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class VetJPARepository implements VetRepository {

  private final VetDAO vetDAO;

  @Override
  public Vet add(Vet entity) {
    return vetDAO.save(entity);
  }

  @Override
  public Vet update(Vet entity) {
    return vetDAO.save(entity);
  }

  @Override
  public Optional<Vet> findById(UUID id) {
    return vetDAO.findById(id);
  }

  @Override
  public Vet getById(UUID id) {
    return vetDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet not found in database"));
  }

  @Override
  public void deleteById(UUID id) {
    vetDAO.deleteById(id);
  }
}

