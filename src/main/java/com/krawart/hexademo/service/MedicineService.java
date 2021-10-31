package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Medicine;
import com.krawart.hexademo.service.command.AddMedicineCommand;
import com.krawart.hexademo.service.command.UpdateMedicineCommand;

import java.util.UUID;

public interface MedicineService {
  Medicine add(AddMedicineCommand command);

  Medicine update(UpdateMedicineCommand command, UUID id);

  Medicine getById(UUID id);

  void deleteById(UUID id);
}
