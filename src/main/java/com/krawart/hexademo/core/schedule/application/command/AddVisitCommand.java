package com.krawart.hexademo.core.schedule.application.command;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record AddVisitCommand(@Future @NotNull Instant date, String description, @NotNull UUID petId) {}
