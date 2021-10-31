package com.krawart.hexademo.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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
public class Pet extends BaseEntity {

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
