package com.krawart.hexademo.common.domain;

import java.io.Serializable;

/**
 * Interface for all domain objects that can be uniquely identified in some context.
 * It is often designed as a generic interface with the ID type as a generic parameter.
 */
public interface IdentifiableDomainObject<ID extends Serializable> extends DomainObject {
    ID getId();
}
