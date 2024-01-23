package com.krawart.hexademo.core.patient.application.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AddOwnerCommand(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email String email
) {
}
