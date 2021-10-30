package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.Visit;
import com.krawart.hexademo.service.command.AddVisitCommand;
import com.krawart.hexademo.service.command.UpdateVisitCommand;

import java.util.UUID;

public interface VisitService {
  Visit add(AddVisitCommand command);

  Visit update(UpdateVisitCommand command, UUID id);

  Visit getById(UUID id);

  void deleteById(UUID id);
}
