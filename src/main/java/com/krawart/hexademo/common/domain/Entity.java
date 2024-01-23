package com.krawart.hexademo.common.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

/**
 * Abstract base class for entities. A field for the ID is Often included and class implements equals() and hashCode()
 * accordingly
 *
 * @param <ID> Identifier type
 */
@Getter
@SuperBuilder
public abstract class Entity<ID extends Serializable> implements IdentifiableDomainObject<ID> {

    private ID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
