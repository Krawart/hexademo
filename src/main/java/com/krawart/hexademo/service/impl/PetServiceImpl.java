package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Pet;
import com.krawart.hexademo.repository.OwnerRepository;
import com.krawart.hexademo.repository.PetRepository;
import com.krawart.hexademo.service.PetService;
import com.krawart.hexademo.service.command.AddPetCommand;
import com.krawart.hexademo.service.command.UpdatePetCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;

  @Override
  public Pet add(AddPetCommand command) {
    return petRepository.save(
        Pet.builder()
            .birthDate(command.birthDate())
            .name(command.name())
            .owner(ownerRepository.getById(UUID.fromString(command.ownerId())))
            .build()
    );
  }

  @Override
  public Pet update(UpdatePetCommand command, UUID id) {
    var persistedEntity = petRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet not found"));

    persistedEntity.setBirthDate(command.birthDate());
    persistedEntity.setName(command.name());
    persistedEntity.setOwner(ownerRepository.getById(UUID.fromString(command.ownerId())));

    return persistedEntity;
  }

  @Override
  public Pet getById(UUID id) {
    return petRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet not found"));
  }

  @Override
  public void deleteById(UUID id) {
    petRepository.deleteById(id);
  }
}