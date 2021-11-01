package com.krawart.hexademo.core.patient.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.core.patient.domain.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetQueryService {
  private final PetRepository petRepository;

  public Pet getById(UUID id) {
    return petRepository.getById(id);
  }

}
