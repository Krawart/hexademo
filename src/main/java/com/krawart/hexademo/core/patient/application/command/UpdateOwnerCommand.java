package com.krawart.hexademo.core.patient.application.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateOwnerCommand(@NotBlank String firstName, @NotBlank String lastName, @Email String email) {}
