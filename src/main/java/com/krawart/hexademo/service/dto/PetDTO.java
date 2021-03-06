package com.krawart.hexademo.service.dto;

import com.krawart.hexademo.domain.Pet;
import com.krawart.hexademo.service.dto.OwnerDTO.OwnerShortDTO;
import com.krawart.hexademo.service.dto.VisitDTO.VisitShortDTO;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public record PetDTO(
    String id,
    Instant birthDate,
    String name,
    OwnerShortDTO owner,
    List<VisitShortDTO> visits
) {
  public static PetDTO of(Pet entity) {
    return new PetDTO(
        entity.getId().toString(),
        entity.getBirthDate(),
        entity.getName(),
        OwnerShortDTO.of(entity.getOwner()),
        entity.getVisits().stream().map(VisitShortDTO::of).collect(Collectors.toList())
    );
  }

  public static record PetShortDTO(
      String id,
      String name,
      String ownerId
  ) {
    public static PetShortDTO of(Pet entity) {
      return new PetShortDTO(
          entity.getId().toString(),
          entity.getName(),
          entity.getOwner().getId().toString()
      );
    }
  }
}
