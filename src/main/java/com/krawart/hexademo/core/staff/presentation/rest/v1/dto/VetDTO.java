package com.krawart.hexademo.core.staff.presentation.rest.v1.dto;

import com.krawart.hexademo.core.staff.domain.Vet;
import lombok.Builder;

@Builder
public record VetDTO(String id, String firstName, String lastName, String email, String telephone) {

    public static VetDTO of(Vet entity) {
        return new VetDTO(
                entity.getId().toString(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail().email(),
                entity.getTelephone());
    }
}
