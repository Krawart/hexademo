package com.krawart.hexademo.core.schedule.application;

import com.krawart.hexademo.core.patient.domain.PetRepository;
import com.krawart.hexademo.core.schedule.application.command.AddVisitCommand;
import com.krawart.hexademo.core.schedule.application.command.UpdateVisitCommand;
import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.core.schedule.domain.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitManager {
  private final VisitRepository visitRepository;
  private final PetRepository petRepository;

  public Visit add(AddVisitCommand command) {
    return visitRepository.add(
        Visit.builder()
            .date(command.date())
            .description(command.description())
            .pet(petRepository.getById(UUID.fromString(command.petId())))
            .build()
    );
  }

  public Visit update(UpdateVisitCommand command, UUID id) {
    var persistedEntity = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found"));

    persistedEntity.setDate(command.date());
    persistedEntity.setDescription(command.description());
    persistedEntity.setPet(petRepository.getById(UUID.fromString(command.petId())));

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    visitRepository.deleteById(id);
  }
}