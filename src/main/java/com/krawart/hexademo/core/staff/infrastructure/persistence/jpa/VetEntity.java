package com.krawart.hexademo.core.staff.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.shared.domain.value.Email;
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
class VetEntity extends AuditableEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private Email email;

    @Column(name = "telephone")
    private String telephone;

    static VetEntity of(Vet vet) {
        return VetEntity.builder()
                .id(vet.getId())
                .firstName(vet.getFirstName())
                .lastName(vet.getLastName())
                .email(vet.getEmail())
                .telephone(vet.getTelephone())
                .build();
    }

    Vet toDomain() {
        return Vet.builder()
                .id(getId())
                .firstName(getFirstName())
                .lastName(getLastName())
                .email(getEmail())
                .telephone(getTelephone())
                .build();
    }
}
