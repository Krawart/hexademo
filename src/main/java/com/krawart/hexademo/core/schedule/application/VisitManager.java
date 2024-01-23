package com.krawart.hexademo.core.schedule.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.patient.domain.PetRepository;
import com.krawart.hexademo.core.schedule.application.command.AddVisitCommand;
import com.krawart.hexademo.core.schedule.application.command.UpdateVisitCommand;
import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.core.schedule.domain.VisitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class VisitManager {
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;

    public Visit add(AddVisitCommand command) {
        if (!petRepository.existsById(command.petId())) {
            throw new EntityNotFoundException("Pet not found");
        }
        return visitRepository.add(Visit.builder()
                .date(command.date())
                .description(command.description())
                .petId((command.petId()))
                .build());
    }

    public Visit update(UpdateVisitCommand command, UUID id) {
        var persistedEntity =
                visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit not found"));

        persistedEntity.setDate(command.date());
        persistedEntity.setDescription(command.description());

        return persistedEntity;
    }

    public void deleteById(UUID id) {
        visitRepository.removeById(id);
    }
}