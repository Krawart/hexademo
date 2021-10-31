package com.krawart.hexademo.core.staff.application;

import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.core.staff.domain.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VetQueryService {
  private final VetRepository vetRepository;

  public Vet getById(UUID id) {
    return vetRepository.getById(id);
  }

}