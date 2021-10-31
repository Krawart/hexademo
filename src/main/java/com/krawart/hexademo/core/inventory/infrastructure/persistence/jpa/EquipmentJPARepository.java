package com.krawart.hexademo.core.inventory.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.inventory.domain.Equipment;
import com.krawart.hexademo.core.inventory.domain.EquipmentRepository;
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
  public void deleteById(UUID id) {
    equipmentDAO.deleteById(id);
  }
}
