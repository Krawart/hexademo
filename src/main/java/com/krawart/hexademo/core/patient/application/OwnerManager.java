package com.krawart.hexademo.core.patient.application;

import com.krawart.hexademo.core.patient.application.command.AddOwnerCommand;
import com.krawart.hexademo.core.patient.application.command.UpdateOwnerCommand;
import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.core.patient.domain.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerManager {
  private final OwnerRepository ownerRepository;

  public Owner add(AddOwnerCommand command) {
    return ownerRepository.add(
        Owner.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(command.email())
            .build()
    );
  }

  public Owner update(UpdateOwnerCommand command, UUID id) {
    var persistedEntity = ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));

    persistedEntity.setFirstName(command.firstName());
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(command.email());

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    ownerRepository.deleteById(id);
  }
}
