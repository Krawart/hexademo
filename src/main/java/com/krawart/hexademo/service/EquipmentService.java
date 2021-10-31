package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Equipment;
import com.krawart.hexademo.service.command.AddEquipmentCommand;
import com.krawart.hexademo.service.command.UpdateEquipmentCommand;

import java.util.UUID;

public interface EquipmentService {
  Equipment add(AddEquipmentCommand command);

  Equipment update(UpdateEquipmentCommand command, UUID id);

  Equipment getById(UUID id);

  void deleteById(UUID id);
}
