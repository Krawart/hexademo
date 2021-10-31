package com.krawart.hexademo.core.staff.application;

import com.krawart.hexademo.core.staff.application.command.AddVetCommand;
import com.krawart.hexademo.core.staff.application.command.UpdateVetCommand;
import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.core.staff.domain.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class VetManager {
  private final VetRepository vetRepository;

  public Vet add(AddVetCommand command) {
    return vetRepository.add(
        Vet.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(command.email())
            .telephone(command.telephone())
            .build()
    );
  }

  public Vet update(UpdateVetCommand command, UUID id) {
    var persistedEntity = vetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet not found"));

    persistedEntity.setFirstName(command.firstName());
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(command.email());
    persistedEntity.setTelephone(command.telephone());

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    vetRepository.deleteById(id);
  }
}