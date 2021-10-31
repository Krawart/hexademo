package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.Vet;
import com.krawart.hexademo.repository.VetRepository;
import com.krawart.hexademo.service.VetService;
import com.krawart.hexademo.service.command.AddVetCommand;
import com.krawart.hexademo.service.command.UpdateVetCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {
  private final VetRepository vetRepository;

  @Override
  public Vet add(AddVetCommand command) {
    return vetRepository.save(
        Vet.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(command.email())
            .telephone(command.telephone())
            .build()
    );
  }

  @Override
  public Vet update(UpdateVetCommand command, UUID id) {
    var persistedEntity = vetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet not found"));

    persistedEntity.setFirstName(command.firstName());
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(command.email());
    persistedEntity.setTelephone(command.telephone());

    return persistedEntity;
  }

  @Override
  public Vet getById(UUID id) {
    return vetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet not found"));
  }

  @Override
  public void deleteById(UUID id) {
    vetRepository.deleteById(id);
  }
}