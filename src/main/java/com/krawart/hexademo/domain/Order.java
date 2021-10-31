package com.krawart.hexademo.domain;

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
public class Order extends BaseEntity {

  @Column(name = "upc")
  private String upc;

  @ElementCollection
  @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"))
  @ToString.Exclude
  private Set<OrderItem> items = new HashSet<>();

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
