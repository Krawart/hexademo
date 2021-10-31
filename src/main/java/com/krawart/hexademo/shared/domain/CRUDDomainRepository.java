package com.krawart.hexademo.shared.domain;

import java.util.Optional;
import java.util.UUID;

public interface CRUDDomainRepository<T extends AggregateRoot> {
  T add(T entity);

  T update(T entity);

  Optional<T> findById(UUID id);

  T getById(UUID id);

  void deleteById(UUID id);
}
