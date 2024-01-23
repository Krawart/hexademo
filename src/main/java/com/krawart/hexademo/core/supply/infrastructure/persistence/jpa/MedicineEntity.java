package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Medicine;
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
class MedicineEntity extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    static MedicineEntity of(Medicine medicine) {
        return MedicineEntity.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .weight(medicine.getWeight())
                .build();
    }

    Medicine toDomain() {
        return Medicine.builder()
                .id(getId())
                .name(getName())
                .weight(getWeight())
                .build();
    }
}
