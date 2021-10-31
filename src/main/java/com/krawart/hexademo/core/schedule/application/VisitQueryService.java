package com.krawart.hexademo.core.schedule.application;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.core.schedule.domain.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VisitQueryService {
  private final VisitRepository visitRepository;

  public Visit getById(UUID id) {
    return visitRepository.getById(id);
  }

}