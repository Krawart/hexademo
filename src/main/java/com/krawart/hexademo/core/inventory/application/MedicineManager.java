package com.krawart.hexademo.core.inventory.application;

import com.krawart.hexademo.core.inventory.application.command.AddMedicineCommand;
import com.krawart.hexademo.core.inventory.application.command.UpdateMedicineCommand;
import com.krawart.hexademo.core.inventory.domain.Medicine;
import com.krawart.hexademo.core.inventory.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicineManager {
  private final MedicineRepository medicineRepository;

  public Medicine add(AddMedicineCommand command) {
    return medicineRepository.add(
        Medicine.builder()
            .name(command.name())
            .weight(command.weight())
            .build()
    );
  }

  public Medicine update(UpdateMedicineCommand command, UUID id) {
    var persistedEntity = medicineRepository.getById(id);

    persistedEntity.setName(command.name());
    persistedEntity.setWeight(command.weight());

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    medicineRepository.deleteById(id);
  }
}