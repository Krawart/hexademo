package com.krawart.hexademo.core.store.domain;

import com.krawart.hexademo.shared.domain.AggregateRoot;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_table")
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends AggregateRoot {

  @Column(name = "upc")
  private String upc;

  @ElementCollection
  @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"))
  @ToString.Exclude
  private Set<OrderItem> items = new HashSet<>();

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Shipment shipment;

  @Embeddable
  @Builder
  @Getter
  @Setter
  @ToString
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class OrderItem {

    @ManyToOne
    @ToString.Exclude
    private Medicine medicine;

    @Column(name = "quantity")
    private Integer quantity;
  }
}
