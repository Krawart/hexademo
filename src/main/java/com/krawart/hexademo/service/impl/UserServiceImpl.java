package com.krawart.hexademo.service.impl;

import com.krawart.hexademo.domain.User;
import com.krawart.hexademo.repository.UserRepository;
import com.krawart.hexademo.service.UserService;
import com.krawart.hexademo.service.command.AddUserCommand;
import com.krawart.hexademo.service.command.UpdateUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User add(AddUserCommand command) {
    return userRepository.save(
        User.builder()
            .firstName(command.getFirstName())
            .lastName(command.getLastName())
            .email(command.getEmail())
            .build()
    );
  }

  @Override
  public User update(UpdateUserCommand command, UUID id) {
    var persistedEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

    persistedEntity.setFirstName(command.getFirstName());
    persistedEntity.setLastName(command.getLastName());
    persistedEntity.setEmail(command.getEmail());

    return persistedEntity;
  }

  @Override
  public User getById(UUID id) {
    return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
  }

  @Override
  public void deleteById(UUID id) {
    userRepository.deleteById(id);
  }
}
