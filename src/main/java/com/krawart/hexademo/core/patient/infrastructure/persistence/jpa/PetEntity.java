package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.shared.infrastructure.persistence.jpa.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class PetEntity extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Instant birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;

    static PetEntity of(Pet pet) {
        return PetEntity.builder()
                .id(pet.getId())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .owner(OwnerEntity.of(pet.getOwner()))
                .build();
    }

    Pet toDomain() {
        return Pet.builder()
                .id(getId())
                .name(getName())
                .birthDate(getBirthDate())
                .owner(getOwner().toDomain())
                .build();
    }
}
