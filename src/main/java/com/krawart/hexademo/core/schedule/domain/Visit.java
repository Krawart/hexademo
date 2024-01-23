package com.krawart.hexademo.core.schedule.domain;

import com.krawart.hexademo.common.domain.Entity;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Visit extends Entity<UUID> {

    private Instant date;

    private String description;

    private UUID petId;

    public void setDate(Instant date) {
        requireNonNull(date, "Date cannot be null");
        if (date.isBefore(Instant.now())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        this.date = date;
    }

    public void setDescription(String description) {
        requireNonNull(description, "Description cannot be null");
        this.description = description;
    }
}
