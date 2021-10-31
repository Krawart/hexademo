package com.krawart.hexademo.core.schedule.infrastructure;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.core.schedule.domain.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class VisitJPARepository implements VisitRepository {

  private final VisitDAO visitDAO;

  @Override
  public Visit add(Visit entity) {
    return visitDAO.save(entity);
  }

  @Override
  public Visit update(Visit entity) {
    return visitDAO.save(entity);
  }

  @Override
  public Optional<Visit> findById(UUID id) {
    return visitDAO.findById(id);
  }

  @Override
  public Visit getById(UUID id) {
    return visitDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found in database"));
  }

  @Override
  public void deleteById(UUID id) {
    visitDAO.deleteById(id);
  }
}