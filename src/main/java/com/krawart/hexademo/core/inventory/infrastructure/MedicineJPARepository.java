package com.krawart.hexademo.core.inventory.infrastructure;

import com.krawart.hexademo.core.inventory.domain.Medicine;
import com.krawart.hexademo.core.inventory.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class MedicineJPARepository implements MedicineRepository {

  private final MedicineDAO medicineDAO;

  @Override
  public Medicine add(Medicine entity) {
    return medicineDAO.save(entity);
  }

  @Override
  public Medicine update(Medicine entity) {
    return medicineDAO.save(entity);
  }

  @Override
  public Optional<Medicine> findById(UUID id) {
    return medicineDAO.findById(id);
  }

  @Override
  public Medicine getById(UUID id) {
    return medicineDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicine not found in database"));
  }

  @Override
  public void deleteById(UUID id) {
    medicineDAO.deleteById(id);
  }
}
