package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Pet;
import com.krawart.hexademo.service.command.AddPetCommand;
import com.krawart.hexademo.service.command.UpdatePetCommand;

import java.util.UUID;

public interface PetService {
  Pet add(AddPetCommand command);

  Pet update(UpdatePetCommand command, UUID id);

  Pet getById(UUID id);

  void deleteById(UUID id);
}
