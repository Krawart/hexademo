package com.krawart.hexademo.core.patient.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.patient.application.command.AddOwnerCommand;
import com.krawart.hexademo.core.patient.application.command.UpdateOwnerCommand;
import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.core.patient.domain.OwnerRepository;
import com.krawart.hexademo.shared.domain.value.Email;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class OwnerManager {
  private final OwnerRepository ownerRepository;

  public Owner add(AddOwnerCommand command) {
    return ownerRepository.add(
        Owner.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(new Email(command.email()))
            .build()
    );
  }

  public Owner update(UpdateOwnerCommand command, UUID id) {
    var persistedEntity = ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));

    persistedEntity.setFirstName(command.firstName());
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(new Email(command.email()));

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    ownerRepository.removeById(id);
  }
}
