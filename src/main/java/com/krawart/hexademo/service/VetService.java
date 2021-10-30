package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Vet;
import com.krawart.hexademo.service.command.AddVetCommand;
import com.krawart.hexademo.service.command.UpdateVetCommand;

import java.util.UUID;

public interface VetService {
  Vet add(AddVetCommand command);

  Vet update(UpdateVetCommand command, UUID id);

  Vet getById(UUID id);

  void deleteById(UUID id);
}
