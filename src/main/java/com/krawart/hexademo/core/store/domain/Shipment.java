package com.krawart.hexademo.core.store.domain;


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
public class Shipment extends AggregateRoot {

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private String status;

  @Column(name = "code")
  private String code;
}