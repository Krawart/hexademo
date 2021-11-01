package com.krawart.hexademo.shared.domain;

import com.krawart.hexademo.common.domain.DomainObject;
import com.krawart.hexademo.common.domain.Entity;

import java.util.Optional;
import java.util.UUID;

public interface CRUDDomainRepository<T extends Entity<?>> extends DomainObject {
  T add(T entity);

  T update(T entity);

  Optional<T> findById(UUID id);

  T getById(UUID id);

  void deleteById(UUID id);
}
