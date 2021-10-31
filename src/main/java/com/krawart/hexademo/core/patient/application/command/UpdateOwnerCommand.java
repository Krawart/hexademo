package com.krawart.hexademo.core.patient.application.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UpdateOwnerCommand(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email String email
) {
}
