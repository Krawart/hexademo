package com.krawart.hexademo.shared.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

/**
 * Abstract base class for local entities. If local identity is used for the local entities, this class will contain
 * code for managing that. Otherwise, it may just be an empty marker class
 */
@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class LocalEntity extends BaseEntity {
}
