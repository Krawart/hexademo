package com.krawart.hexademo.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit extends BaseEntity {

  @Column(name = "date")
  private Instant date;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @ToString.Exclude
  private Pet pet;
}
