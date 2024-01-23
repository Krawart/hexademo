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
public class Equipment extends Entity<UUID> {

    private String name;

    private Integer quantity;

    public void setName(String name) {
        requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }
}