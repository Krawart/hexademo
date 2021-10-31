package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Owner;
import com.krawart.hexademo.service.command.AddOwnerCommand;
import com.krawart.hexademo.service.command.UpdateOwnerCommand;

import java.util.UUID;

public interface OwnerService {
  Owner add(AddOwnerCommand command);

  Owner update(UpdateOwnerCommand command, UUID id);

  Owner getById(UUID id);

  void deleteById(UUID id);
}
