package com.krawart.hexademo.core.patient.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.patient.application.command.AddPetCommand;
import com.krawart.hexademo.core.patient.application.command.UpdatePetCommand;
import com.krawart.hexademo.core.patient.domain.OwnerRepository;
import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.core.patient.domain.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class PetManager {
  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;

  public Pet add(AddPetCommand command) {
    return petRepository.add(
        Pet.builder()
            .birthDate(command.birthDate())
            .name(command.name())
            .owner(ownerRepository.getById(UUID.fromString(command.ownerId())))
            .build()
    );
  }

  public Pet update(UpdatePetCommand command, UUID id) {
    var persistedEntity = petRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet not found"));

    persistedEntity.setBirthDate(command.birthDate());
    persistedEntity.setName(command.name());
    persistedEntity.setOwner(ownerRepository.getById(UUID.fromString(command.ownerId())));

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    petRepository.deleteById(id);
  }
}
