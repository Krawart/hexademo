package com.krawart.hexademo.core.patient.presentation.rest.v1.dto;

import com.krawart.hexademo.core.patient.domain.Owner;
import lombok.Builder;

@Builder
public record OwnerDTO(
    String id,
    String firstName,
    String lastName,
    String email,
    String address,
    String city,
    String telephone
) {
  public static OwnerDTO of(Owner entity) {
    return new OwnerDTO(
        entity.getId().toString(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getEmail().email(),
        entity.getAddress(),
        entity.getCity(),
        entity.getTelephone()
    );
  }

  public static record OwnerShortDTO(
      String id,
      String firstName,
      String lastName,
      String email
  ) {
    public static OwnerShortDTO of(Owner entity) {
      return new OwnerShortDTO(
          entity.getId().toString(),
          entity.getFirstName(),
          entity.getLastName(),
          entity.getEmail().email()
      );
    }
  }
}
