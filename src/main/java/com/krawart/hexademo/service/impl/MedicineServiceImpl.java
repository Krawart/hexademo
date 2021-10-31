package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Medicine;
import com.krawart.hexademo.repository.MedicineRepository;
import com.krawart.hexademo.service.MedicineService;
import com.krawart.hexademo.service.command.AddMedicineCommand;
import com.krawart.hexademo.service.command.UpdateMedicineCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
  private final MedicineRepository equipmentRepository;

  @Override
  public Medicine add(AddMedicineCommand command) {
    return equipmentRepository.save(
        Medicine.builder()
            .name(command.name())
            .weight(command.weight())
            .build()
    );
  }

  @Override
  public Medicine update(UpdateMedicineCommand command, UUID id) {
    var persistedEntity = equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicine not found"));

    persistedEntity.setName(command.name());
    persistedEntity.setWeight(command.weight());

    return persistedEntity;
  }

  @Override
  public Medicine getById(UUID id) {
    return equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicine not found"));
  }

  @Override
  public void deleteById(UUID id) {
    equipmentRepository.deleteById(id);
  }
}
