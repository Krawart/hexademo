package com.krawart.hexademo.core.staff.domain;

import com.krawart.hexademo.common.domain.Entity;
import com.krawart.hexademo.shared.domain.value.Email;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Vet extends Entity<UUID> {

    private String firstName;

    private String lastName;

    private Email email;

    private String telephone;

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

    public void setTelephone(String telephone) {
        requireNonNull(telephone, "Telephone cannot be null");
        this.telephone = telephone;
    }
}
