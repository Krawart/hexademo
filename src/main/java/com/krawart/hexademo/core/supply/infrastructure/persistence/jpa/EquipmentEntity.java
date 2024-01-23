package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Equipment;
import com.krawart.hexademo.shared.infrastructure.persistence.jpa.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class EquipmentEntity extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    static EquipmentEntity of(Equipment equipment) {
        return EquipmentEntity.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .quantity(equipment.getQuantity())
                .build();
    }

    Equipment toDomain() {
        return Equipment.builder()
                .id(getId())
                .name(getName())
                .quantity(getQuantity())
                .build();
    }
}