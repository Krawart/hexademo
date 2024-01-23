package com.krawart.hexademo.core.patient.presentation.rest.v1.dto;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.core.patient.presentation.rest.v1.dto.OwnerDTO.OwnerShortDTO;
import lombok.Builder;

import java.time.Instant;

@Builder
public record PetDTO(String id, Instant birthDate, String name, OwnerShortDTO owner) {
    public static PetDTO of(Pet entity) {
        return new PetDTO(
                entity.getId().toString(),
                entity.getBirthDate(),
                entity.getName(),
                OwnerShortDTO.of(entity.getOwner()));
    }

    public record PetShortDTO(String id, String name, String ownerId) {
        public static PetShortDTO of(Pet entity) {
            return new PetShortDTO(
                    entity.getId().toString(),
                    entity.getName(),
                    entity.getOwner().getId().toString());
        }
    }
}
