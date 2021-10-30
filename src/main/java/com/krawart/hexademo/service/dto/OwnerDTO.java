package com.krawart.hexademo.service.dto;

import com.krawart.hexademo.domain.Person;
import lombok.Builder;

@Builder
public record OwnerDTO(
    String id,
    String firstName,
    String lastName,
    String email
) {
  public static OwnerDTO of(Person entity) {
    return new OwnerDTO(
        entity.getId().toString(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getEmail()
    );
  }

  public static record OwnerShortDTO(
      String id,
      String firstName,
      String lastName,
      String email
  ) {
    public static OwnerShortDTO of(Person entity) {
      return new OwnerShortDTO(
          entity.getId().toString(),
          entity.getFirstName(),
          entity.getLastName(),
          entity.getEmail()
      );
    }
  }
}
