package com.krawart.hexademo.core.patient.domain;

import com.krawart.hexademo.common.domain.Entity;
import com.krawart.hexademo.shared.domain.value.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Owner extends Entity<UUID> {

    private String firstName;

    private String lastName;

    private Email email;

    private String address;

    private String city;

    private String telephone;

    @Builder.Default
    private Set<Pet> pets = new HashSet<>();

    public void setFirstName(String firstName) {
        requireNonNull(firstName, "First name cannot be null");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        requireNonNull(lastName, "Last name cannot be null");
        this.lastName = lastName;
    }

    public void setEmail(Email email) {
        requireNonNull(email, "Email cannot be null");
        this.email = email;
    }
}
