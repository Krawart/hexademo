package com.krawart.hexademo.core.store.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.store.application.command.AddEquipmentCommand;
import com.krawart.hexademo.core.store.application.command.UpdateEquipmentCommand;
import com.krawart.hexademo.core.store.domain.Equipment;
import com.krawart.hexademo.core.store.domain.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class EquipmentManager {
  private final EquipmentRepository equipmentRepository;

  public Equipment add(AddEquipmentCommand command) {
    return equipmentRepository.add(
        Equipment.builder()
            .name(command.name())
            .quantity(command.quantity())
            .build()
    );
  }

  public Equipment update(UpdateEquipmentCommand command, UUID id) {
    var persistedEntity = equipmentRepository.getById(id);

    persistedEntity.setName(command.name());
    persistedEntity.setQuantity(command.quantity());

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    equipmentRepository.removeById(id);
  }
}
