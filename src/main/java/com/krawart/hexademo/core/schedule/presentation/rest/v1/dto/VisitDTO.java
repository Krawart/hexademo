package com.krawart.hexademo.core.schedule.presentation.rest.v1.dto;

import com.krawart.hexademo.core.schedule.domain.Visit;
import lombok.Builder;

import java.time.Instant;

@Builder
public record VisitDTO(String id, Instant date, String description, String petId) {
    public static VisitDTO of(Visit entity) {
        return new VisitDTO(
                entity.getId().toString(),
                entity.getDate(),
                entity.getDescription(),
                entity.getPetId().toString());
    }

    public record VisitShortDTO(String id, Instant date, String petId) {
        public static VisitShortDTO of(Visit entity) {
            return new VisitShortDTO(
                    entity.getId().toString(),
                    entity.getDate(),
                    entity.getPetId().toString());
        }
    }
}
