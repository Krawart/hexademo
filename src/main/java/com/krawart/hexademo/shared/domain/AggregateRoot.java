package com.krawart.hexademo.shared.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serial;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AggregateRoot extends BaseEntity {

  @Serial
  private static final long serialVersionUID = 1L;

  @CreatedDate
  @Column(name = "created_date", updatable = false)
  @JsonIgnore
  private Instant createdDate;

  @LastModifiedBy
  @Column(name = "last_modified_by", length = 50)
  @JsonIgnore
  private String lastModifiedBy;
}
