package com.krawart.hexademo.core.supply.domain;

import com.krawart.hexademo.common.domain.Entity;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Medicine extends Entity<UUID> {

    private String name;

    private Double weight;

    public void setName(String name) {
        requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public void setWeight(Double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
    }
}
