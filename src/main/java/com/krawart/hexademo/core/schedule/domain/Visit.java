package com.krawart.hexademo.core.schedule.domain;

import com.krawart.hexademo.core.patient.domain.Pet;
import com.krawart.hexademo.shared.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit extends AggregateRoot {

  @Column(name = "date")
  private Instant date;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @ToString.Exclude
  private Pet pet;
}
