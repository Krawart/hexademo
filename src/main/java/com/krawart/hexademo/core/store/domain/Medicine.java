package com.krawart.hexademo.core.store.domain;

import com.krawart.hexademo.shared.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
