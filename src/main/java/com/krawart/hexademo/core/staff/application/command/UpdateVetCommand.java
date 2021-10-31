package com.krawart.hexademo.core.staff.application.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UpdateVetCommand(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email String email,
    @NotBlank String telephone
) {
}
