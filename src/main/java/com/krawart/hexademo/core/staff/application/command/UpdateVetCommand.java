package com.krawart.hexademo.core.staff.application.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateVetCommand(
        @NotBlank String firstName, @NotBlank String lastName, @Email String email, @NotBlank String telephone) {}
