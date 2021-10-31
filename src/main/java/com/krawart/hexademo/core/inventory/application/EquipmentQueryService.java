package com.krawart.hexademo.core.inventory.application;

import com.krawart.hexademo.core.inventory.domain.Equipment;
import com.krawart.hexademo.core.inventory.domain.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EquipmentQueryService {
  private final EquipmentRepository equipmentRepository;

  public Equipment getById(UUID id) {
    return equipmentRepository.getById(id);
  }

}
