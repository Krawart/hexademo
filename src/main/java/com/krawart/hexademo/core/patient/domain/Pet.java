package com.krawart.hexademo.core.patient.domain;

import com.krawart.hexademo.common.domain.Entity;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Pet extends Entity<UUID> {

    private String name;

    private Instant birthDate;

    private Owner owner;

    public void setName(String name) {
        requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public void setBirthDate(Instant birthDate) {
        requireNonNull(birthDate, "Birth date cannot be null");
        this.birthDate = birthDate;
    }

    public void setOwner(Owner owner) {
        requireNonNull(owner, "Owner cannot be null");
        this.owner = owner;
    }
}
