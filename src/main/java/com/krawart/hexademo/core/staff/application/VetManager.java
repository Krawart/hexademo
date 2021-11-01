package com.krawart.hexademo.core.staff.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.staff.application.command.AddVetCommand;
import com.krawart.hexademo.core.staff.application.command.UpdateVetCommand;
import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.core.staff.domain.VetRepository;
import com.krawart.hexademo.shared.domain.value.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class VetManager {
  private final VetRepository vetRepository;

  public Vet add(AddVetCommand command) {
    return vetRepository.add(
        Vet.builder()
            .firstName(command.firstName())
            .lastName(command.lastName())
            .email(new Email(command.email()))
            .telephone(command.telephone())
            .build()
    );
  }

  public Vet update(UpdateVetCommand command, UUID id) {
    var persistedEntity = vetRepository.getById(id);

    var firstCharValue = (int) command.firstName().charAt(0);
    if (64 < firstCharValue && firstCharValue < 91) {
      persistedEntity.setFirstName(command.firstName());
    }
    persistedEntity.setLastName(command.lastName());
    persistedEntity.setEmail(new Email(command.email()));
    persistedEntity.setTelephone(command.telephone());

    return persistedEntity;
  }

  public void deleteById(UUID id) {
    vetRepository.removeById(id);
  }
}