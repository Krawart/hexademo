package com.krawart.hexademo.core.supply.presentation.rest.v1.dto;

import com.krawart.hexademo.core.supply.domain.Equipment;
import lombok.Builder;

@Builder
public record EquipmentDTO(String id, String name, Integer quantity) {
    public static EquipmentDTO of(Equipment entity) {
        return new EquipmentDTO(entity.getId().toString(), entity.getName(), entity.getQuantity());
    }
}
