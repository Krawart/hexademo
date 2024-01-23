package com.krawart.hexademo.core.patient.domain;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet extends AggregateRoot {

  @Column(name = "name")
  private String name;

  @Column(name = "birth_date")
  private Instant birthDate;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @Transient
  @ToString.Exclude
  @Builder.Default
  private Set<Visit> visits = new LinkedHashSet<>();
}
