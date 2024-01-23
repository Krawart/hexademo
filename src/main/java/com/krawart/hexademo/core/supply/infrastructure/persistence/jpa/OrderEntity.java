package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Order;
import com.krawart.hexademo.shared.infrastructure.persistence.jpa.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "order_table")
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class OrderEntity extends AuditableEntity {

    @Column(name = "upc")
    private String upc;

    @ElementCollection
    @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"))
    @ToString.Exclude
    private List<OrderItemEmbeddedValue> items = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShipmentEntity shipment;

    static OrderEntity of(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .upc(order.getUpc())
                .items(order.getItems().stream().map(OrderItemEmbeddedValue::of).collect(Collectors.toList()))
                .shipment(ShipmentEntity.of(order.getShipment()))
                .build();
    }

    Order toDomain() {
        return Order.builder()
                .id(getId())
                .upc(getUpc())
                .items(getItems().stream().map(OrderItemEmbeddedValue::toDomain).collect(Collectors.toList()))
                .shipment(getShipment().toDomain())
                .build();
    }

    @Embeddable
    @Builder
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OrderItemEmbeddedValue {

        @ManyToOne
        @ToString.Exclude
        private MedicineEntity medicine;

        @Column(name = "quantity")
        private Integer quantity;

        static OrderItemEmbeddedValue of(Order.OrderItem item) {
            return OrderItemEmbeddedValue.builder()
                    .medicine(MedicineEntity.of(item.getMedicine()))
                    .quantity(item.getQuantity())
                    .build();
        }

        Order.OrderItem toDomain() {
            return Order.OrderItem.builder()
                    .medicine(medicine.toDomain())
                    .quantity(quantity)
                    .build();
        }
    }
}
