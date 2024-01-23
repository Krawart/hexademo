package com.krawart.hexademo.core.store.presentation.rest.v1.dto;

import com.krawart.hexademo.core.store.domain.Medicine;
import lombok.Builder;

@Builder
public record MedicineDTO(String id, String name, Double weight) {
    public static MedicineDTO of(Medicine entity) {
        return new MedicineDTO(entity.getId().toString(), entity.getName(), entity.getWeight());
    }

    public static record MedicineShortDTO(String id) {
        public static MedicineShortDTO of(Medicine entity) {
            return new MedicineShortDTO(entity.getId().toString());
        }
    }
}
