package com.krawart.hexademo.core.store.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.store.domain.Equipment;
import com.krawart.hexademo.core.store.domain.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class EquipmentJPARepository implements EquipmentRepository {

  private final EquipmentDAO equipmentDAO;

  @Override
  public Equipment add(Equipment entity) {
    return equipmentDAO.save(entity);
  }

  @Override
  public Equipment update(Equipment entity) {
    return equipmentDAO.save(entity);
  }

  @Override
  public Optional<Equipment> findById(UUID id) {
    return equipmentDAO.findById(id);
  }

  @Override
  public Equipment getById(UUID id) {
    return equipmentDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipment not found in database"));
  }

  @Override
  public void removeById(UUID id) {
    equipmentDAO.deleteById(id);
  }
}
