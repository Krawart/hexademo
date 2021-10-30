package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Equipment;
import com.krawart.hexademo.repository.EquipmentRepository;
import com.krawart.hexademo.service.EquipmentService;
import com.krawart.hexademo.service.command.AddEquipmentCommand;
import com.krawart.hexademo.service.command.UpdateEquipmentCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
  private final EquipmentRepository equipmentRepository;

  @Override
  public Equipment add(AddEquipmentCommand command) {
    return equipmentRepository.save(
        Equipment.builder()
            .name(command.name())
            .quantity(command.quantity())
            .build()
    );
  }

  @Override
  public Equipment update(UpdateEquipmentCommand command, UUID id) {
    var persistedEntity = equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipment not found"));

    persistedEntity.setName(command.name());
    persistedEntity.setQuantity(command.quantity());

    return persistedEntity;
  }

  @Override
  public Equipment getById(UUID id) {
    return equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipment not found"));
  }

  @Override
  public void deleteById(UUID id) {
    equipmentRepository.deleteById(id);
  }
}
