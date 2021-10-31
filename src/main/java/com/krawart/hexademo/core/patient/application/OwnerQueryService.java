package com.krawart.hexademo.core.patient.application;

import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.core.patient.domain.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OwnerQueryService {
  private final OwnerRepository ownerRepository;

  public Owner getById(UUID id) {
    return ownerRepository.getById(id);
  }
}
