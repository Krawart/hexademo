package com.krawart.hexademo.core.inventory.application;

import com.krawart.hexademo.core.inventory.domain.Medicine;
import com.krawart.hexademo.core.inventory.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MedicineQueryService {
  private final MedicineRepository medicineRepository;

  public Medicine getById(UUID id) {
    return medicineRepository.getById(id);
  }
}
