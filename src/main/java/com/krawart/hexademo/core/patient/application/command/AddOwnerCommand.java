package com.krawart.hexademo.core.patient.application.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record AddOwnerCommand(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email String email
) {
}
