package com.krawart.hexademo.service.dto;

import com.krawart.hexademo.domain.User;
import lombok.Builder;

@Builder
public record UserDTO(String id, String firstName, String lastName, String email) {

  public static UserDTO of(User user) {
    return new UserDTO(user.getId().toString(), user.getFirstName(), user.getLastName(), user.getEmail());
  }

}
