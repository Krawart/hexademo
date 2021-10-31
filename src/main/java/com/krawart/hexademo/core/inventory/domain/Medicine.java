package com.krawart.hexademo.core.inventory.domain;

import com.krawart.hexademo.shared.domain.AggregateRoot;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Medicine extends AggregateRoot {

  @Column(name = "name")
  private String name;

  @Column(name = "weight")
  private Double weight;
}