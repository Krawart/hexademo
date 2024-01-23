package com.krawart.hexademo.core.patient.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.patient.domain.Owner;
import com.krawart.hexademo.shared.domain.value.Email;
import com.krawart.hexademo.shared.infrastructure.persistence.jpa.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class OwnerEntity extends AuditableEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private Email email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<PetEntity> pets;

    static OwnerEntity of(Owner owner) {
        return OwnerEntity.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .email(owner.getEmail())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .pets(owner.getPets().stream().map(PetEntity::of).collect(Collectors.toUnmodifiableSet()))
                .build();
    }

    Owner toDomain() {
        return Owner.builder()
                .id(getId())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .city(city)
                .telephone(telephone)
                .pets(pets.stream().map(PetEntity::toDomain).collect(Collectors.toUnmodifiableSet()))
                .build();
    }
}