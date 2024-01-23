package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Shipment;
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
class ShipmentEntity extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "code")
    private String code;

    static ShipmentEntity of(Shipment shipment) {
        return ShipmentEntity.builder()
                .id(shipment.getId())
                .name(shipment.getName())
                .status(shipment.getStatus())
                .code(shipment.getCode())
                .build();
    }

    Shipment toDomain() {
        return Shipment.builder()
                .id(getId())
                .name(getName())
                .status(getStatus())
                .code(getCode())
                .build();
    }
}