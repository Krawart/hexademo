package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Visit;
import com.krawart.hexademo.repository.PetRepository;
import com.krawart.hexademo.repository.VisitRepository;
import com.krawart.hexademo.service.VisitService;
import com.krawart.hexademo.service.command.AddVisitCommand;
import com.krawart.hexademo.service.command.UpdateVisitCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {
  private final VisitRepository visitRepository;
  private final PetRepository petRepository;

  @Override
  public Visit add(AddVisitCommand command) {
    return visitRepository.save(
        Visit.builder()
            .date(command.date())
            .description(command.description())
            .pet(petRepository.getById(UUID.fromString(command.petId())))
            .build()
    );
  }

  @Override
  public Visit update(UpdateVisitCommand command, UUID id) {
    var persistedEntity = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found"));

    persistedEntity.setDate(command.date());
    persistedEntity.setDescription(command.description());
    persistedEntity.setPet(petRepository.getById(UUID.fromString(command.petId())));

    return persistedEntity;
  }

  @Override
  public Visit getById(UUID id) {
    return visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found"));
  }

  @Override
  public void deleteById(UUID id) {
    visitRepository.deleteById(id);
  }
}