package com.krawart.hexademo.shared.domain;

import com.krawart.hexademo.common.domain.DomainObject;
import com.krawart.hexademo.common.domain.Entity;

import java.util.Optional;
import java.util.UUID;

public interface CRUDDomainRepository<T extends Entity<?>> extends DomainObject {
    T add(T entity);

    T update(T entity);

    Optional<T> findById(UUID id);

    default T getById(UUID id) {
        return findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    void removeById(UUID id);
}
