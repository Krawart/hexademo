package com.krawart.hexademo.core.supply.domain;

import com.krawart.hexademo.common.domain.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@SuperBuilder
@Getter
@ToString
public class Order extends Entity<UUID> {

    private String upc;

    @ToString.Exclude
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    private Shipment shipment;

    public void setItems(Set<OrderItem> items) {
        requireNonNull(items, "Items cannot be null");
        this.items = new ArrayList<>(items);
    }

    public void setUpc(String upc) {
        requireNonNull(upc, "UPC cannot be null");
        this.upc = upc;
    }

    @Builder
    @Getter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class OrderItem {

        @EqualsAndHashCode.Include
        private Medicine medicine;

        private Integer quantity;
    }
}
