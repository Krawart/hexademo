package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Owner;
import com.krawart.hexademo.repository.OwnerRepository;
import com.krawart.hexademo.service.OwnerService;
import com.krawart.hexademo.service.command.AddOwnerCommand;
import com.krawart.hexademo.service.command.UpdateOwnerCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
  private final OwnerRepository ownerRepository;

  @Override
  public Owner add(AddOwnerCommand command) {
    return ownerRepository.save(
        Owner.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(command.email())
            .build()
    );
  }

  @Override
  public Owner update(UpdateOwnerCommand command, UUID id) {
    var persistedEntity = ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));

    persistedEntity.setFirstName(command.firstName());
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(command.email());

    return persistedEntity;
  }

  @Override
  public Owner getById(UUID id) {
    return ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
  }

  @Override
  public void deleteById(UUID id) {
    ownerRepository.deleteById(id);
  }
}
