package com.krawart.hexademo.service;

import com.krawart.hexademo.domain.User;
import com.krawart.hexademo.service.command.AddUserCommand;
import com.krawart.hexademo.service.command.UpdateUserCommand;

import java.util.UUID;

public interface UserService {
  User add(AddUserCommand command);

  User update(UpdateUserCommand command, UUID id);

  User getById(UUID id);

  void deleteById(UUID id);
}
