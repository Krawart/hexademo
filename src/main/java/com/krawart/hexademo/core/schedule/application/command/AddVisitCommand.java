package com.krawart.hexademo.core.schedule.application.command;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record AddVisitCommand(@Future @NotNull Instant date, String description, @NotNull String petId) {}
